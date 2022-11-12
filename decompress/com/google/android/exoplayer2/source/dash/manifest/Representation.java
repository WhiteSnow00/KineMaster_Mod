// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import java.util.Collections;
import java.util.Collection;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Format;

public abstract class Representation
{
    public final long a;
    public final Format b;
    public final ImmutableList<BaseUrl> c;
    public final long d;
    public final List<Descriptor> e;
    public final List<Descriptor> f;
    public final List<Descriptor> g;
    private final RangedUri h;
    
    private Representation(final long a, final Format b, final List<BaseUrl> list, final SegmentBase segmentBase, final List<Descriptor> list2, final List<Descriptor> f, final List<Descriptor> g) {
        Assertions.a(list.isEmpty() ^ true);
        this.a = a;
        this.b = b;
        this.c = (ImmutableList<BaseUrl>)ImmutableList.copyOf((Collection)list);
        List<Object> e;
        if (list2 == null) {
            e = (List<Object>)Collections.emptyList();
        }
        else {
            e = (List<Object>)Collections.unmodifiableList((List<? extends Descriptor>)list2);
        }
        this.e = (List<Descriptor>)e;
        this.f = f;
        this.g = g;
        this.h = segmentBase.a(this);
        this.d = segmentBase.b();
    }
    
    Representation(final long n, final Format format, final List list, final SegmentBase segmentBase, final List list2, final List list3, final List list4, final Representation$a object) {
        this(n, format, list, segmentBase, list2, list3, list4);
    }
    
    public static Representation o(final long n, final Format format, final List<BaseUrl> list, final SegmentBase segmentBase, final List<Descriptor> list2, final List<Descriptor> list3, final List<Descriptor> list4, final String s) {
        if (segmentBase instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(n, format, list, (SegmentBase.SingleSegmentBase)segmentBase, list2, list3, list4, s, -1L);
        }
        if (segmentBase instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(n, format, list, (SegmentBase.MultiSegmentBase)segmentBase, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }
    
    public abstract String k();
    
    public abstract DashSegmentIndex l();
    
    public abstract RangedUri m();
    
    public RangedUri n() {
        return this.h;
    }
    
    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex
    {
        final SegmentBase.MultiSegmentBase i;
        
        public MultiSegmentRepresentation(final long n, final Format format, final List<BaseUrl> list, final SegmentBase.MultiSegmentBase i, final List<Descriptor> list2, final List<Descriptor> list3, final List<Descriptor> list4) {
            super(n, format, list, i, list2, list3, list4, null);
            this.i = i;
        }
        
        @Override
        public long a(final long n, final long n2) {
            return this.i.h(n, n2);
        }
        
        @Override
        public long b(final long n, final long n2) {
            return this.i.d(n, n2);
        }
        
        @Override
        public long c(final long n) {
            return this.i.j(n);
        }
        
        @Override
        public long d(final long n, final long n2) {
            return this.i.f(n, n2);
        }
        
        @Override
        public RangedUri e(final long n) {
            return this.i.k(this, n);
        }
        
        @Override
        public long f(final long n, final long n2) {
            return this.i.i(n, n2);
        }
        
        @Override
        public long g(final long n) {
            return this.i.g(n);
        }
        
        @Override
        public boolean h() {
            return this.i.l();
        }
        
        @Override
        public long i() {
            return this.i.e();
        }
        
        @Override
        public long j(final long n, final long n2) {
            return this.i.c(n, n2);
        }
        
        @Override
        public String k() {
            return null;
        }
        
        @Override
        public DashSegmentIndex l() {
            return this;
        }
        
        @Override
        public RangedUri m() {
            return null;
        }
    }
    
    public static class SingleSegmentRepresentation extends Representation
    {
        public final Uri i;
        public final long j;
        private final String k;
        private final RangedUri l;
        private final a m;
        
        public SingleSegmentRepresentation(final long n, final Format format, final List<BaseUrl> list, final SegmentBase.SingleSegmentBase singleSegmentBase, final List<Descriptor> list2, final List<Descriptor> list3, final List<Descriptor> list4, final String k, final long j) {
            super(n, format, list, singleSegmentBase, list2, list3, list4, null);
            this.i = Uri.parse(list.get(0).a);
            final RangedUri c = singleSegmentBase.c();
            this.l = c;
            this.k = k;
            this.j = j;
            a m;
            if (c != null) {
                m = null;
            }
            else {
                m = new a(new RangedUri(null, 0L, j));
            }
            this.m = m;
        }
        
        @Override
        public String k() {
            return this.k;
        }
        
        @Override
        public DashSegmentIndex l() {
            return this.m;
        }
        
        @Override
        public RangedUri m() {
            return this.l;
        }
    }
}
