// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.util.Map;
import android.net.Uri;
import java.io.IOException;
import java.io.EOFException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import android.text.TextUtils;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import java.util.Collections;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.Format;
import com.google.common.primitives.Ints;
import java.util.List;

public final class DefaultHlsExtractorFactory implements HlsExtractorFactory
{
    private static final int[] d;
    private final int b;
    private final boolean c;
    
    static {
        d = new int[] { 8, 13, 11, 2, 0, 1, 7 };
    }
    
    public DefaultHlsExtractorFactory() {
        this(0, true);
    }
    
    public DefaultHlsExtractorFactory(final int b, final boolean c) {
        this.b = b;
        this.c = c;
    }
    
    private static void b(final int n, final List<Integer> list) {
        if (Ints.i(DefaultHlsExtractorFactory.d, n) != -1) {
            if (!list.contains(n)) {
                list.add(n);
            }
        }
    }
    
    private Extractor d(final int n, final Format format, final List<Format> list, final TimestampAdjuster timestampAdjuster) {
        if (n == 0) {
            return new Ac3Extractor();
        }
        if (n == 1) {
            return new Ac4Extractor();
        }
        if (n == 2) {
            return new AdtsExtractor();
        }
        if (n == 7) {
            return new Mp3Extractor(0, 0L);
        }
        if (n == 8) {
            return e(timestampAdjuster, format, list);
        }
        if (n == 11) {
            return f(this.b, this.c, format, list, timestampAdjuster);
        }
        if (n != 13) {
            return null;
        }
        return new WebvttExtractor(format.c, timestampAdjuster);
    }
    
    private static FragmentedMp4Extractor e(final TimestampAdjuster timestampAdjuster, final Format format, List<Format> emptyList) {
        int n;
        if (g(format)) {
            n = 4;
        }
        else {
            n = 0;
        }
        if (emptyList == null) {
            emptyList = Collections.emptyList();
        }
        return new FragmentedMp4Extractor(n, timestampAdjuster, null, emptyList);
    }
    
    private static TsExtractor f(int n, final boolean b, final Format format, List<Format> list, final TimestampAdjuster timestampAdjuster) {
        n |= 0x10;
        if (list != null) {
            n |= 0x20;
        }
        else if (b) {
            list = Collections.singletonList(new Format.Builder().e0("application/cea-608").E());
        }
        else {
            list = Collections.emptyList();
        }
        final String i = format.i;
        int n2 = n;
        if (!TextUtils.isEmpty((CharSequence)i)) {
            int n3 = n;
            if (!MimeTypes.b(i, "audio/mp4a-latm")) {
                n3 = (n | 0x2);
            }
            n2 = n3;
            if (!MimeTypes.b(i, "video/avc")) {
                n2 = (n3 | 0x4);
            }
        }
        return new TsExtractor(2, timestampAdjuster, new DefaultTsPayloadReaderFactory(n2, list));
    }
    
    private static boolean g(final Format format) {
        final Metadata j = format.j;
        if (j == null) {
            return false;
        }
        for (int i = 0; i < j.d(); ++i) {
            final Metadata.Entry c = j.c(i);
            if (c instanceof HlsTrackMetadataEntry) {
                return ((HlsTrackMetadataEntry)c).c.isEmpty() ^ true;
            }
        }
        return false;
    }
    
    private static boolean h(final Extractor extractor, final ExtractorInput extractorInput) throws IOException {
        boolean d;
        try {
            d = extractor.d(extractorInput);
        }
        catch (final EOFException ex) {
            extractorInput.h();
            d = false;
        }
        finally {
            extractorInput.h();
        }
        return d;
    }
    
    @Override
    public /* bridge */ HlsMediaChunkExtractor a(final Uri uri, final Format format, final List list, final TimestampAdjuster timestampAdjuster, final Map map, final ExtractorInput extractorInput, final PlayerId playerId) throws IOException {
        return this.c(uri, format, list, timestampAdjuster, map, extractorInput, playerId);
    }
    
    public BundledHlsMediaChunkExtractor c(final Uri uri, final Format format, final List<Format> list, final TimestampAdjuster timestampAdjuster, final Map<String, List<String>> map, final ExtractorInput extractorInput, final PlayerId playerId) throws IOException {
        final int a = FileTypes.a(format.w);
        final int b = FileTypes.b(map);
        final int c = FileTypes.c(uri);
        final int[] d = DefaultHlsExtractorFactory.d;
        final ArrayList list2 = new ArrayList<Integer>(d.length);
        b(a, (List<Integer>)list2);
        b(b, (List<Integer>)list2);
        b(c, (List<Integer>)list2);
        final int length = d.length;
        final int n = 0;
        for (int i = 0; i < length; ++i) {
            b(d[i], (List<Integer>)list2);
        }
        Extractor extractor = null;
        extractorInput.h();
        Extractor extractor3;
        for (int j = n; j < list2.size(); ++j, extractor = extractor3) {
            final int intValue = list2.get(j);
            final Extractor extractor2 = Assertions.e(this.d(intValue, format, list, timestampAdjuster));
            if (h(extractor2, extractorInput)) {
                return new BundledHlsMediaChunkExtractor(extractor2, format, timestampAdjuster);
            }
            if ((extractor3 = extractor) == null) {
                if (intValue != a && intValue != b && intValue != c) {
                    extractor3 = extractor;
                    if (intValue != 11) {
                        continue;
                    }
                }
                extractor3 = extractor2;
            }
        }
        return new BundledHlsMediaChunkExtractor(Assertions.e(extractor), format, timestampAdjuster);
    }
}
