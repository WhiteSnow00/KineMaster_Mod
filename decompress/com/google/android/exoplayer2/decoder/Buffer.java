// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

public abstract class Buffer
{
    private int a;
    
    public final void g(final int n) {
        this.a |= n;
    }
    
    public void h() {
        this.a = 0;
    }
    
    public final void i(final int n) {
        this.a &= ~n;
    }
    
    protected final boolean k(final int n) {
        return (this.a & n) == n;
    }
    
    public final boolean l() {
        return this.k(268435456);
    }
    
    public final boolean m() {
        return this.k(Integer.MIN_VALUE);
    }
    
    public final boolean n() {
        return this.k(4);
    }
    
    public final boolean o() {
        return this.k(134217728);
    }
    
    public final boolean p() {
        return this.k(1);
    }
    
    public final void q(final int a) {
        this.a = a;
    }
}
