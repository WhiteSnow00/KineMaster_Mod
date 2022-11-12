// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

public abstract class BaseMediaChunkIterator implements MediaChunkIterator
{
    private final long b;
    private final long c;
    private long d;
    
    public BaseMediaChunkIterator(final long b, final long c) {
        this.b = b;
        this.c = c;
        this.f();
    }
    
    protected final void c() {
        final long d = this.d;
        if (d >= this.b && d <= this.c) {
            return;
        }
        throw new NoSuchElementException();
    }
    
    protected final long d() {
        return this.d;
    }
    
    public boolean e() {
        return this.d > this.c;
    }
    
    public void f() {
        this.d = this.b - 1L;
    }
    
    @Override
    public boolean next() {
        ++this.d;
        return this.e() ^ true;
    }
}
