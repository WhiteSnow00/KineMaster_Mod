// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Assertions;
import android.net.Uri;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import java.util.UUID;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.offline.FilterableManifest;

public class SsManifest implements FilterableManifest<SsManifest>
{
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final ProtectionElement e;
    public final StreamElement[] f;
    public final long g;
    public final long h;
    
    private SsManifest(final int a, final int b, final long g, final long h, final int c, final boolean d, final ProtectionElement e, final StreamElement[] f) {
        this.a = a;
        this.b = b;
        this.g = g;
        this.h = h;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public SsManifest(final int n, final int n2, long o0, long o2, final long n3, final int n4, final boolean b, final ProtectionElement protectionElement, final StreamElement[] array) {
        final long n5 = -9223372036854775807L;
        if (o2 == 0L) {
            o2 = -9223372036854775807L;
        }
        else {
            o2 = Util.O0(o2, 1000000L, o0);
        }
        if (n3 == 0L) {
            o0 = n5;
        }
        else {
            o0 = Util.O0(n3, 1000000L, o0);
        }
        this(n, n2, o2, o0, n4, b, protectionElement, array);
    }
    
    @Override
    public /* bridge */ Object a(final List list) {
        return this.b(list);
    }
    
    public final SsManifest b(final List<StreamKey> list) {
        final ArrayList list2 = new ArrayList((Collection<? extends E>)list);
        Collections.sort((List<Comparable>)list2);
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        StreamElement streamElement = null;
        StreamElement streamElement2;
        for (int i = 0; i < list2.size(); ++i, streamElement = streamElement2) {
            final StreamKey streamKey = list2.get(i);
            streamElement2 = this.f[streamKey.b];
            if (streamElement2 != streamElement && streamElement != null) {
                list3.add(streamElement.b((Format[])list4.toArray(new Format[0])));
                list4.clear();
            }
            list4.add(streamElement2.j[streamKey.c]);
        }
        if (streamElement != null) {
            list3.add(streamElement.b((Format[])list4.toArray(new Format[0])));
        }
        return new SsManifest(this.a, this.b, this.g, this.h, this.c, this.d, this.e, (StreamElement[])list3.toArray(new StreamElement[0]));
    }
    
    public static class ProtectionElement
    {
        public final UUID a;
        public final byte[] b;
        public final TrackEncryptionBox[] c;
        
        public ProtectionElement(final UUID a, final byte[] b, final TrackEncryptionBox[] c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static class StreamElement
    {
        public final int a;
        public final String b;
        public final long c;
        public final String d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final String i;
        public final Format[] j;
        public final int k;
        private final String l;
        private final String m;
        private final List<Long> n;
        private final long[] o;
        private final long p;
        
        public StreamElement(final String s, final String s2, final int n, final String s3, final long n2, final String s4, final int n3, final int n4, final int n5, final int n6, final String s5, final Format[] array, final List<Long> list, final long n7) {
            this(s, s2, n, s3, n2, s4, n3, n4, n5, n6, s5, array, list, Util.P0(list, 1000000L, n2), Util.O0(n7, 1000000L, n2));
        }
        
        private StreamElement(final String l, final String m, final int a, final String b, final long c, final String d, final int e, final int f, final int g, final int h, final String i, final Format[] j, final List<Long> n, final long[] o, final long p15) {
            this.l = l;
            this.m = m;
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
            this.j = j;
            this.n = n;
            this.o = o;
            this.p = p15;
            this.k = n.size();
        }
        
        public Uri a(final int n, final int n2) {
            final Format[] j = this.j;
            final boolean b = true;
            Assertions.g(j != null);
            Assertions.g(this.n != null);
            Assertions.g(n2 < this.n.size() && b);
            final String string = Integer.toString(this.j[n].h);
            final String string2 = this.n.get(n2).toString();
            return UriUtil.e(this.l, this.m.replace("{bitrate}", string).replace("{Bitrate}", string).replace("{start time}", string2).replace("{start_time}", string2));
        }
        
        public StreamElement b(final Format[] array) {
            return new StreamElement(this.l, this.m, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, array, this.n, this.o, this.p);
        }
        
        public long c(final int n) {
            long p;
            if (n == this.k - 1) {
                p = this.p;
            }
            else {
                final long[] o = this.o;
                p = o[n + 1] - o[n];
            }
            return p;
        }
        
        public int d(final long n) {
            return Util.i(this.o, n, true, true);
        }
        
        public long e(final int n) {
            return this.o[n];
        }
    }
}
