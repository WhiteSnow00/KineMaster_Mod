// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

public abstract class ForwardingTimeline extends Timeline
{
    protected final Timeline c;
    
    public ForwardingTimeline(final Timeline c) {
        this.c = c;
    }
    
    @Override
    public int e(final boolean b) {
        return this.c.e(b);
    }
    
    @Override
    public int f(final Object o) {
        return this.c.f(o);
    }
    
    @Override
    public int g(final boolean b) {
        return this.c.g(b);
    }
    
    @Override
    public int i(final int n, final int n2, final boolean b) {
        return this.c.i(n, n2, b);
    }
    
    @Override
    public Period k(final int n, final Period period, final boolean b) {
        return this.c.k(n, period, b);
    }
    
    @Override
    public int m() {
        return this.c.m();
    }
    
    @Override
    public int p(final int n, final int n2, final boolean b) {
        return this.c.p(n, n2, b);
    }
    
    @Override
    public Object q(final int n) {
        return this.c.q(n);
    }
    
    @Override
    public Window s(final int n, final Window window, final long n2) {
        return this.c.s(n, window, n2);
    }
    
    @Override
    public int t() {
        return this.c.t();
    }
}
