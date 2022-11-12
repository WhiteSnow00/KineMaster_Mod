// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.Arrays;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import com.google.android.exoplayer2.source.ShuffleOrder;
import java.util.Collection;
import java.util.HashMap;

final class q1 extends AbstractConcatenatedTimeline
{
    private final int f;
    private final int g;
    private final int[] h;
    private final int[] i;
    private final Timeline[] j;
    private final Object[] p;
    private final HashMap<Object, Integer> w;
    
    public q1(final Collection<? extends i1> collection, final ShuffleOrder shuffleOrder) {
        int f = 0;
        super(false, shuffleOrder);
        final int size = collection.size();
        this.h = new int[size];
        this.i = new int[size];
        this.j = new Timeline[size];
        this.p = new Object[size];
        this.w = new HashMap<Object, Integer>();
        final Iterator iterator = collection.iterator();
        int g = 0;
        int n = 0;
        while (iterator.hasNext()) {
            final i1 i1 = (i1)iterator.next();
            this.j[n] = i1.b();
            this.i[n] = f;
            this.h[n] = g;
            f += this.j[n].t();
            g += this.j[n].m();
            this.p[n] = i1.a();
            this.w.put(this.p[n], n);
            ++n;
        }
        this.f = f;
        this.g = g;
    }
    
    @Override
    protected int A(final int n) {
        return Util.h(this.i, n + 1, false, false);
    }
    
    @Override
    protected Object D(final int n) {
        return this.p[n];
    }
    
    @Override
    protected int F(final int n) {
        return this.h[n];
    }
    
    @Override
    protected int G(final int n) {
        return this.i[n];
    }
    
    @Override
    protected Timeline J(final int n) {
        return this.j[n];
    }
    
    List<Timeline> K() {
        return Arrays.asList(this.j);
    }
    
    @Override
    public int m() {
        return this.g;
    }
    
    @Override
    public int t() {
        return this.f;
    }
    
    @Override
    protected int y(final Object o) {
        final Integer n = this.w.get(o);
        int intValue;
        if (n == null) {
            intValue = -1;
        }
        else {
            intValue = n;
        }
        return intValue;
    }
    
    @Override
    protected int z(final int n) {
        return Util.h(this.h, n + 1, false, false);
    }
}
