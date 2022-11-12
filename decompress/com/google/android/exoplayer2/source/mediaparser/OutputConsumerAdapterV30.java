// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.mediaparser;

import com.google.android.exoplayer2.extractor.SeekPoint;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataReader;
import android.media.MediaParser$InputReader;
import com.google.android.exoplayer2.util.MimeTypes;
import android.media.MediaParser$TrackData;
import android.media.DrmInitData$SchemeInitData;
import android.media.DrmInitData;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.nio.LongBuffer;
import java.nio.IntBuffer;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.ColorInfo;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import java.util.List;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import android.media.MediaParser$SeekMap;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import android.media.MediaCodec$CryptoInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.util.ArrayList;
import java.util.regex.Pattern;
import android.media.MediaParser$SeekPoint;
import android.util.Pair;
import android.media.MediaParser$OutputConsumer;

public final class OutputConsumerAdapterV30 implements MediaParser$OutputConsumer
{
    private static final Pair<MediaParser$SeekPoint, MediaParser$SeekPoint> u;
    private static final Pattern v;
    private final ArrayList<TrackOutput> a;
    private final ArrayList<Format> b;
    private final ArrayList<MediaCodec$CryptoInfo> c;
    private final ArrayList<TrackOutput.CryptoData> d;
    private final b e;
    private final boolean f;
    private final int g;
    private final Format h;
    private ExtractorOutput i;
    private MediaParser$SeekMap j;
    private MediaParser$SeekMap k;
    private String l;
    private ChunkIndex m;
    private TimestampAdjuster n;
    private List<Format> o;
    private int p;
    private long q;
    private boolean r;
    private boolean s;
    private boolean t;
    
    static {
        final MediaParser$SeekPoint start = MediaParser$SeekPoint.START;
        u = Pair.create((Object)start, (Object)start);
        v = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    }
    
    public OutputConsumerAdapterV30() {
        this(null, -2, false);
    }
    
    public OutputConsumerAdapterV30(final Format h, final int g, final boolean f) {
        this.f = f;
        this.h = h;
        this.g = g;
        this.a = new ArrayList<TrackOutput>();
        this.b = new ArrayList<Format>();
        this.c = new ArrayList<MediaCodec$CryptoInfo>();
        this.d = new ArrayList<TrackOutput.CryptoData>();
        this.e = new b(null);
        this.i = new DummyExtractorOutput();
        this.q = -9223372036854775807L;
        this.o = (List<Format>)ImmutableList.of();
    }
    
    private void b(final int n) {
        for (int i = this.a.size(); i <= n; ++i) {
            this.a.add(null);
            this.b.add(null);
            this.c.add(null);
            this.d.add(null);
        }
    }
    
    private static byte[] c(final ByteBuffer byteBuffer) {
        final byte[] array = new byte[byteBuffer.remaining()];
        byteBuffer.get(array);
        return array;
    }
    
    private static ColorInfo e(final MediaFormat mediaFormat) {
        final ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] c;
        if (byteBuffer != null) {
            c = c(byteBuffer);
        }
        else {
            c = null;
        }
        final int integer = mediaFormat.getInteger("color-transfer", -1);
        final int integer2 = mediaFormat.getInteger("color-range", -1);
        final int integer3 = mediaFormat.getInteger("color-standard", -1);
        if (c == null && integer == -1 && integer2 == -1 && integer3 == -1) {
            return null;
        }
        return new ColorInfo(integer3, integer2, integer, c);
    }
    
    private static int g(final MediaFormat mediaFormat, final String s, int n) {
        if (mediaFormat.getInteger(s, 0) == 0) {
            n = 0;
        }
        return n;
    }
    
    private static List<byte[]> h(final MediaFormat mediaFormat) {
        final ArrayList list = new ArrayList();
        int n = 0;
        while (true) {
            final StringBuilder sb = new StringBuilder();
            sb.append("csd-");
            sb.append(n);
            final ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb.toString());
            if (byteBuffer == null) {
                break;
            }
            list.add(c(byteBuffer));
            ++n;
        }
        return list;
    }
    
    private static String i(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2063134683: {
                if (!s.equals("android.media.mediaparser.FlvParser")) {
                    break;
                }
                n = 13;
                break;
            }
            case 1343957595: {
                if (!s.equals("android.media.mediaparser.Mp3Parser")) {
                    break;
                }
                n = 12;
                break;
            }
            case 1264380477: {
                if (!s.equals("android.media.mediaparser.Ac4Parser")) {
                    break;
                }
                n = 11;
                break;
            }
            case 965962719: {
                if (!s.equals("android.media.mediaparser.MatroskaParser")) {
                    break;
                }
                n = 10;
                break;
            }
            case 768643067: {
                if (!s.equals("android.media.mediaparser.FlacParser")) {
                    break;
                }
                n = 9;
                break;
            }
            case 703268017: {
                if (!s.equals("android.media.mediaparser.AmrParser")) {
                    break;
                }
                n = 8;
                break;
            }
            case 376876796: {
                if (!s.equals("android.media.mediaparser.Ac3Parser")) {
                    break;
                }
                n = 7;
                break;
            }
            case 116768877: {
                if (!s.equals("android.media.mediaparser.FragmentedMp4Parser")) {
                    break;
                }
                n = 6;
                break;
            }
            case 52265814: {
                if (!s.equals("android.media.mediaparser.PsParser")) {
                    break;
                }
                n = 5;
                break;
            }
            case -589864617: {
                if (!s.equals("android.media.mediaparser.WavParser")) {
                    break;
                }
                n = 4;
                break;
            }
            case -900207883: {
                if (!s.equals("android.media.mediaparser.AdtsParser")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1566427438: {
                if (!s.equals("android.media.mediaparser.TsParser")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1870824006: {
                if (!s.equals("android.media.mediaparser.OggParser")) {
                    break;
                }
                n = 1;
                break;
            }
            case -2063506020: {
                if (!s.equals("android.media.mediaparser.Mp4Parser")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Illegal parser name: ");
                sb.append(s);
                throw new IllegalArgumentException(sb.toString());
            }
            case 13: {
                return "video/x-flv";
            }
            case 12: {
                return "audio/mpeg";
            }
            case 11: {
                return "audio/ac4";
            }
            case 10: {
                return "video/webm";
            }
            case 9: {
                return "audio/flac";
            }
            case 8: {
                return "audio/amr";
            }
            case 7: {
                return "audio/ac3";
            }
            case 5: {
                return "video/mp2p";
            }
            case 4: {
                return "audio/raw";
            }
            case 3: {
                return "audio/mp4a-latm";
            }
            case 2: {
                return "video/mp2t";
            }
            case 1: {
                return "audio/ogg";
            }
            case 0:
            case 6: {
                return "video/mp4";
            }
        }
    }
    
    private static int l(final MediaFormat mediaFormat) {
        return g(mediaFormat, "is-forced-subtitle", 2) | (g(mediaFormat, "is-autoselect", 4) | 0x0 | g(mediaFormat, "is-default", 1));
    }
    
    private void m() {
        if (this.r) {
            if (!this.s) {
                for (int size = this.a.size(), i = 0; i < size; ++i) {
                    if (this.a.get(i) == null) {
                        return;
                    }
                }
                this.i.o();
                this.s = true;
            }
        }
    }
    
    private boolean n(final MediaFormat mediaFormat) {
        final ByteBuffer byteBuffer = mediaFormat.getByteBuffer("chunk-index-int-sizes");
        if (byteBuffer == null) {
            return false;
        }
        final IntBuffer intBuffer = byteBuffer.asIntBuffer();
        final LongBuffer longBuffer = Assertions.e(mediaFormat.getByteBuffer("chunk-index-long-offsets")).asLongBuffer();
        final LongBuffer longBuffer2 = Assertions.e(mediaFormat.getByteBuffer("chunk-index-long-us-durations")).asLongBuffer();
        final LongBuffer longBuffer3 = Assertions.e(mediaFormat.getByteBuffer("chunk-index-long-us-times")).asLongBuffer();
        final int[] array = new int[intBuffer.remaining()];
        final long[] array2 = new long[longBuffer.remaining()];
        final long[] array3 = new long[longBuffer2.remaining()];
        final long[] array4 = new long[longBuffer3.remaining()];
        intBuffer.get(array);
        longBuffer.get(array2);
        longBuffer2.get(array3);
        longBuffer3.get(array4);
        final ChunkIndex m = new ChunkIndex(array, array2, array3, array4);
        this.m = m;
        this.i.l(m);
        return true;
    }
    
    private TrackOutput.CryptoData t(final int n, final MediaCodec$CryptoInfo mediaCodec$CryptoInfo) {
        if (mediaCodec$CryptoInfo == null) {
            return null;
        }
        TrackOutput.CryptoData cryptoData;
        if (this.c.get(n) == mediaCodec$CryptoInfo) {
            cryptoData = Assertions.e(this.d.get(n));
        }
        else {
            int n2 = 0;
            int int2;
            try {
                final Matcher matcher = OutputConsumerAdapterV30.v.matcher(mediaCodec$CryptoInfo.toString());
                matcher.find();
                final int int1 = Integer.parseInt(Util.j(matcher.group(1)));
                int2 = Integer.parseInt(Util.j(matcher.group(2)));
                n2 = int1;
            }
            catch (final RuntimeException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected error while parsing CryptoInfo: ");
                sb.append(mediaCodec$CryptoInfo);
                Log.d("OConsumerAdapterV30", sb.toString(), ex);
                int2 = 0;
            }
            final TrackOutput.CryptoData cryptoData2 = new TrackOutput.CryptoData(mediaCodec$CryptoInfo.mode, mediaCodec$CryptoInfo.key, n2, int2);
            this.c.set(n, mediaCodec$CryptoInfo);
            this.d.set(n, cryptoData2);
            cryptoData = cryptoData2;
        }
        return cryptoData;
    }
    
    private static com.google.android.exoplayer2.drm.DrmInitData u(final String s, final DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        final int schemeInitDataCount = drmInitData.getSchemeInitDataCount();
        final com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] array = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[schemeInitDataCount];
        for (int i = 0; i < schemeInitDataCount; ++i) {
            final DrmInitData$SchemeInitData schemeInitData = drmInitData.getSchemeInitDataAt(i);
            array[i] = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(schemeInitData.uuid, schemeInitData.mimeType, schemeInitData.data);
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(s, array);
    }
    
    private Format v(final MediaParser$TrackData mediaParser$TrackData) {
        final MediaFormat mediaFormat = mediaParser$TrackData.mediaFormat;
        final String string = mediaFormat.getString("mime");
        final int integer = mediaFormat.getInteger("caption-service-number", -1);
        final Format.Builder y = new Format.Builder().M(u(mediaFormat.getString("crypto-mode-fourcc"), mediaParser$TrackData.drmInitData)).K(this.l).Z(mediaFormat.getInteger("bitrate", -1)).H(mediaFormat.getInteger("channel-count", -1)).J(e(mediaFormat)).e0(string).I(mediaFormat.getString("codecs-string")).P(mediaFormat.getFloat("frame-rate", -1.0f)).j0(mediaFormat.getInteger("width", -1)).Q(mediaFormat.getInteger("height", -1)).T(h(mediaFormat)).V(mediaFormat.getString("language")).W(mediaFormat.getInteger("max-input-size", -1)).Y(mediaFormat.getInteger("exo-pcm-encoding", -1));
        int i = 0;
        final Format.Builder f = y.d0(mediaFormat.getInteger("rotation-degrees", 0)).f0(mediaFormat.getInteger("sample-rate", -1)).g0(l(mediaFormat)).N(mediaFormat.getInteger("encoder-delay", 0)).O(mediaFormat.getInteger("encoder-padding", 0)).a0(mediaFormat.getFloat("pixel-width-height-ratio-float", 1.0f)).i0(mediaFormat.getLong("subsample-offset-us-long", Long.MAX_VALUE)).F(integer);
        while (i < this.o.size()) {
            final Format format = this.o.get(i);
            if (Util.c(format.w, string) && format.O == integer) {
                f.V(format.c).c0(format.e).g0(format.d).U(format.b).X(format.j);
                break;
            }
            ++i;
        }
        return f.E();
    }
    
    private static int w(final String s) {
        if (s == null) {
            return -1;
        }
        int n = 0;
        Label_0152: {
            switch (s) {
                case "video": {
                    n = 4;
                    break Label_0152;
                }
                case "audio": {
                    n = 3;
                    break Label_0152;
                }
                case "text": {
                    n = 2;
                    break Label_0152;
                }
                case "unknown": {
                    n = 1;
                    break Label_0152;
                }
                case "metadata": {
                    n = 0;
                    break Label_0152;
                }
                default:
                    break;
            }
            n = -1;
        }
        switch (n) {
            default: {
                return MimeTypes.k(s);
            }
            case 4: {
                return 2;
            }
            case 3: {
                return 1;
            }
            case 2: {
                return 3;
            }
            case 1: {
                return -1;
            }
            case 0: {
                return 5;
            }
        }
    }
    
    public void a() {
        this.t = true;
    }
    
    public ChunkIndex d() {
        return this.m;
    }
    
    public MediaParser$SeekMap f() {
        return this.j;
    }
    
    public Format[] j() {
        if (!this.r) {
            return null;
        }
        final Format[] array = new Format[this.b.size()];
        for (int i = 0; i < this.b.size(); ++i) {
            array[i] = Assertions.e(this.b.get(i));
        }
        return array;
    }
    
    public Pair<MediaParser$SeekPoint, MediaParser$SeekPoint> k(final long n) {
        final MediaParser$SeekMap k = this.k;
        Pair pair;
        if (k != null) {
            pair = k.getSeekPoints(n);
        }
        else {
            pair = OutputConsumerAdapterV30.u;
        }
        return (Pair<MediaParser$SeekPoint, MediaParser$SeekPoint>)pair;
    }
    
    public void o(final ExtractorOutput i) {
        this.i = i;
    }
    
    public void onSampleCompleted(final int n, final long n2, final int n3, final int n4, final int n5, final MediaCodec$CryptoInfo mediaCodec$CryptoInfo) {
        final long q = this.q;
        if (q != -9223372036854775807L && n2 >= q) {
            return;
        }
        final TimestampAdjuster n6 = this.n;
        long a = n2;
        if (n6 != null) {
            a = n6.a(n2);
        }
        Assertions.e(this.a.get(n)).e(a, n3, n4, n5, this.t(n, mediaCodec$CryptoInfo));
    }
    
    public void onSampleDataFound(final int n, final MediaParser$InputReader a) throws IOException {
        this.b(n);
        this.e.a = a;
        TrackOutput e;
        if ((e = this.a.get(n)) == null) {
            e = this.i.e(n, -1);
            this.a.set(n, e);
        }
        e.b(this.e, (int)a.getLength(), true);
    }
    
    public void onSeekMapFound(final MediaParser$SeekMap mediaParser$SeekMap) {
        if (this.f && this.j == null) {
            this.j = mediaParser$SeekMap;
        }
        else {
            this.k = mediaParser$SeekMap;
            long durationMicros = mediaParser$SeekMap.getDurationMicros();
            final ExtractorOutput i = this.i;
            SeekMap seekMap;
            if (this.t) {
                if (durationMicros == -2147483648L) {
                    durationMicros = -9223372036854775807L;
                }
                seekMap = new SeekMap.Unseekable(durationMicros);
            }
            else {
                seekMap = new c(mediaParser$SeekMap);
            }
            i.l(seekMap);
        }
    }
    
    public void onTrackCountFound(final int n) {
        this.r = true;
        this.m();
    }
    
    public void onTrackDataFound(final int p2, final MediaParser$TrackData mediaParser$TrackData) {
        if (this.n(mediaParser$TrackData.mediaFormat)) {
            return;
        }
        this.b(p2);
        TrackOutput e;
        if ((e = this.a.get(p2)) == null) {
            final String string = mediaParser$TrackData.mediaFormat.getString("track-type-string");
            String string2;
            if (string != null) {
                string2 = string;
            }
            else {
                string2 = mediaParser$TrackData.mediaFormat.getString("mime");
            }
            final int w = w(string2);
            if (w == this.g) {
                this.p = p2;
            }
            e = this.i.e(p2, w);
            this.a.set(p2, e);
            if (string != null) {
                return;
            }
        }
        final Format v = this.v(mediaParser$TrackData);
        final Format h = this.h;
        Format k;
        if (h != null && p2 == this.p) {
            k = v.k(h);
        }
        else {
            k = v;
        }
        e.d(k);
        this.b.set(p2, v);
        this.m();
    }
    
    public void p(final List<Format> o) {
        this.o = o;
    }
    
    public void q(final long q) {
        this.q = q;
    }
    
    public void r(final String s) {
        this.l = i(s);
    }
    
    public void s(final TimestampAdjuster n) {
        this.n = n;
    }
    
    private static final class b implements DataReader
    {
        public MediaParser$InputReader a;
        
        private b() {
        }
        
        b(final OutputConsumerAdapterV30$a object) {
            this();
        }
        
        @Override
        public int read(final byte[] array, final int n, final int n2) throws IOException {
            return Util.j(this.a).read(array, n, n2);
        }
    }
    
    private static final class c implements SeekMap
    {
        private final MediaParser$SeekMap a;
        
        public c(final MediaParser$SeekMap a) {
            this.a = a;
        }
        
        private static SeekPoint a(final MediaParser$SeekPoint mediaParser$SeekPoint) {
            return new SeekPoint(mediaParser$SeekPoint.timeMicros, mediaParser$SeekPoint.position);
        }
        
        @Override
        public SeekPoints f(final long n) {
            final Pair seekPoints = this.a.getSeekPoints(n);
            final Object first = seekPoints.first;
            SeekPoints seekPoints2;
            if (first == seekPoints.second) {
                seekPoints2 = new SeekPoints(a((MediaParser$SeekPoint)first));
            }
            else {
                seekPoints2 = new SeekPoints(a((MediaParser$SeekPoint)first), a((MediaParser$SeekPoint)seekPoints.second));
            }
            return seekPoints2;
        }
        
        @Override
        public boolean h() {
            return this.a.isSeekable();
        }
        
        @Override
        public long i() {
            long durationMicros = this.a.getDurationMicros();
            if (durationMicros == -2147483648L) {
                durationMicros = -9223372036854775807L;
            }
            return durationMicros;
        }
    }
}
