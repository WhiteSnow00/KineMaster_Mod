// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.dvbsi;

import java.nio.ByteBuffer;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import java.util.List;
import com.google.common.base.Charsets;
import java.util.ArrayList;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;

public final class AppInfoTableDecoder extends SimpleMetadataDecoder
{
    private static Metadata c(final ParsableBitArray parsableBitArray) {
        parsableBitArray.r(12);
        final int h = parsableBitArray.h(12);
        final int d = parsableBitArray.d();
        parsableBitArray.r(44);
        parsableBitArray.s(parsableBitArray.h(12));
        parsableBitArray.r(16);
        final ArrayList list = new ArrayList();
        Metadata metadata;
        while (true) {
            final int d2 = parsableBitArray.d();
            metadata = null;
            String s = null;
            if (d2 >= d + h - 4) {
                break;
            }
            parsableBitArray.r(48);
            final int h2 = parsableBitArray.h(8);
            parsableBitArray.r(4);
            final int n = parsableBitArray.d() + parsableBitArray.h(12);
            String s2 = null;
            while (parsableBitArray.d() < n) {
                final int h3 = parsableBitArray.h(8);
                final int h4 = parsableBitArray.h(8);
                final int n2 = parsableBitArray.d() + h4;
                String s3;
                String l;
                if (h3 == 2) {
                    final int h5 = parsableBitArray.h(16);
                    parsableBitArray.r(8);
                    s3 = s;
                    l = s2;
                    if (h5 == 3) {
                        while (true) {
                            s3 = s;
                            l = s2;
                            if (parsableBitArray.d() >= n2) {
                                break;
                            }
                            final String i = parsableBitArray.l(parsableBitArray.h(8), Charsets.a);
                            final int h6 = parsableBitArray.h(8);
                            int n3 = 0;
                            while (true) {
                                s = i;
                                if (n3 >= h6) {
                                    break;
                                }
                                parsableBitArray.s(parsableBitArray.h(8));
                                ++n3;
                            }
                        }
                    }
                }
                else {
                    s3 = s;
                    l = s2;
                    if (h3 == 21) {
                        l = parsableBitArray.l(h4, Charsets.a);
                        s3 = s;
                    }
                }
                parsableBitArray.p(n2 * 8);
                s = s3;
                s2 = l;
            }
            parsableBitArray.p(n * 8);
            if (s == null || s2 == null) {
                continue;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(s2);
            list.add(new AppInfoTable(h2, sb.toString()));
        }
        Metadata metadata2;
        if (list.isEmpty()) {
            metadata2 = metadata;
        }
        else {
            metadata2 = new Metadata(list);
        }
        return metadata2;
    }
    
    @Override
    protected Metadata b(final MetadataInputBuffer metadataInputBuffer, final ByteBuffer byteBuffer) {
        Metadata c;
        if (byteBuffer.get() == 116) {
            c = c(new ParsableBitArray(byteBuffer.array(), byteBuffer.limit()));
        }
        else {
            c = null;
        }
        return c;
    }
}
