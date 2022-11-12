// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import java.util.ArrayList;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import com.google.common.collect.ImmutableList;
import android.net.Uri;
import java.util.Map;
import java.util.List;
import com.google.android.exoplayer2.drm.DrmInitData;

public final class HlsMediaPlaylist extends HlsPlaylist
{
    public final int d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final int j;
    public final long k;
    public final int l;
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final DrmInitData q;
    public final List<Segment> r;
    public final List<Part> s;
    public final Map<Uri, RenditionReport> t;
    public final long u;
    public final ServerControl v;
    
    public HlsMediaPlaylist(final int d, final String s, final List<String> list, final long n, final boolean g, long n2, final boolean i, final int j, final long k, final int l, final long m, final long n3, final boolean b, final boolean o, final boolean p20, final DrmInitData q, final List<Segment> list2, final List<Part> list3, final ServerControl v, final Map<Uri, RenditionReport> map) {
        super(s, list, b);
        this.d = d;
        this.h = n2;
        this.g = g;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n3;
        this.o = o;
        this.p = p20;
        this.q = q;
        this.r = (List<Segment>)ImmutableList.copyOf((Collection)list2);
        this.s = (List<Part>)ImmutableList.copyOf((Collection)list3);
        this.t = (Map<Uri, RenditionReport>)ImmutableMap.copyOf((Map)map);
        if (!list3.isEmpty()) {
            final Part part = (Part)Iterables.h((Iterable)list3);
            this.u = ((SegmentBase)part).e + ((SegmentBase)part).c;
        }
        else if (!list2.isEmpty()) {
            final Segment segment = (Segment)Iterables.h((Iterable)list2);
            this.u = ((SegmentBase)segment).e + ((SegmentBase)segment).c;
        }
        else {
            this.u = 0L;
        }
        n2 = -9223372036854775807L;
        if (n != -9223372036854775807L) {
            if (n >= 0L) {
                n2 = Math.min(this.u, n);
            }
            else {
                n2 = Math.max(0L, this.u + n);
            }
        }
        this.e = n2;
        this.f = (n >= 0L);
        this.v = v;
    }
    
    @Override
    public /* bridge */ Object a(final List list) {
        return this.b(list);
    }
    
    public HlsMediaPlaylist b(final List<StreamKey> list) {
        return this;
    }
    
    public HlsMediaPlaylist c(final long n, final int n2) {
        return new HlsMediaPlaylist(this.d, super.a, super.b, this.e, this.g, n, true, n2, this.k, this.l, this.m, this.n, super.c, this.o, this.p, this.q, this.r, this.s, this.v, this.t);
    }
    
    public HlsMediaPlaylist d() {
        if (this.o) {
            return this;
        }
        return new HlsMediaPlaylist(this.d, super.a, super.b, this.e, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, super.c, true, this.p, this.q, this.r, this.s, this.v, this.t);
    }
    
    public long e() {
        return this.h + this.u;
    }
    
    public boolean f(final HlsMediaPlaylist hlsMediaPlaylist) {
        final boolean b = true;
        final boolean b2 = true;
        boolean b3 = b;
        if (hlsMediaPlaylist != null) {
            final long k = this.k;
            final long i = hlsMediaPlaylist.k;
            if (k > i) {
                b3 = b;
            }
            else {
                if (k < i) {
                    return false;
                }
                final int n = this.r.size() - hlsMediaPlaylist.r.size();
                if (n != 0) {
                    return n > 0 && b2;
                }
                final int size = this.s.size();
                final int size2 = hlsMediaPlaylist.s.size();
                b3 = b;
                if (size <= size2) {
                    b3 = (size == size2 && this.o && !hlsMediaPlaylist.o && b);
                }
            }
        }
        return b3;
    }
    
    public static final class Part extends SegmentBase
    {
        public final boolean w;
        public final boolean x;
        
        public Part(final String s, final Segment segment, final long n, final int n2, final long n3, final DrmInitData drmInitData, final String s2, final String s3, final long n4, final long n5, final boolean b, final boolean w, final boolean x) {
            super(s, segment, n, n2, n3, drmInitData, s2, s3, n4, n5, b, null);
            this.w = w;
            this.x = x;
        }
        
        public Part c(final long n, final int n2) {
            return new Part(super.a, super.b, super.c, n2, n, super.f, super.g, super.h, super.i, super.j, super.p, this.w, this.x);
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface PlaylistType {
    }
    
    public static final class RenditionReport
    {
        public final Uri a;
        public final long b;
        public final int c;
        
        public RenditionReport(final Uri a, final long b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static final class Segment extends SegmentBase
    {
        public final String w;
        public final List<Part> x;
        
        public Segment(final String s, final long n, final long n2, final String s2, final String s3) {
            this(s, null, "", 0L, -1, -9223372036854775807L, null, s2, s3, n, n2, false, (List<Part>)ImmutableList.of());
        }
        
        public Segment(final String s, final Segment segment, final String w, final long n, final int n2, final long n3, final DrmInitData drmInitData, final String s2, final String s3, final long n4, final long n5, final boolean b, final List<Part> list) {
            super(s, segment, n, n2, n3, drmInitData, s2, s3, n4, n5, b, null);
            this.w = w;
            this.x = (List<Part>)ImmutableList.copyOf((Collection)list);
        }
        
        public Segment c(final long n, final int n2) {
            final ArrayList list = new ArrayList();
            int i = 0;
            long n3 = n;
            while (i < this.x.size()) {
                final Part part = this.x.get(i);
                list.add(part.c(n3, n2));
                n3 += part.c;
                ++i;
            }
            return new Segment(super.a, super.b, this.w, super.c, n2, n, super.f, super.g, super.h, super.i, super.j, super.p, list);
        }
    }
    
    public static class SegmentBase implements Comparable<Long>
    {
        public final String a;
        public final Segment b;
        public final long c;
        public final int d;
        public final long e;
        public final DrmInitData f;
        public final String g;
        public final String h;
        public final long i;
        public final long j;
        public final boolean p;
        
        private SegmentBase(final String a, final Segment b, final long c, final int d, final long e, final DrmInitData f, final String g, final String h, final long i, final long j, final boolean p11) {
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
            this.p = p11;
        }
        
        SegmentBase(final String s, final Segment segment, final long n, final int n2, final long n3, final DrmInitData drmInitData, final String s2, final String s3, final long n4, final long n5, final boolean b, final HlsMediaPlaylist$a object) {
            this(s, segment, n, n2, n3, drmInitData, s2, s3, n4, n5, b);
        }
        
        public int a(final Long n) {
            int n2;
            if (this.e > n) {
                n2 = 1;
            }
            else if (this.e < n) {
                n2 = -1;
            }
            else {
                n2 = 0;
            }
            return n2;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((Long)o);
        }
    }
    
    public static final class ServerControl
    {
        public final long a;
        public final boolean b;
        public final long c;
        public final long d;
        public final boolean e;
        
        public ServerControl(final long a, final boolean b, final long c, final long d, final boolean e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
}
