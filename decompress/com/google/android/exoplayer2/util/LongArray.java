// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LongArray
{
    private int a;
    private long[] b;
    
    public LongArray() {
        this(32);
    }
    
    public LongArray(final int n) {
        this.b = new long[n];
    }
    
    public void a(final long n) {
        final int a = this.a;
        final long[] b = this.b;
        if (a == b.length) {
            this.b = Arrays.copyOf(b, a * 2);
        }
        this.b[this.a++] = n;
    }
    
    public long b(final int n) {
        if (n >= 0 && n < this.a) {
            return this.b[n];
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid index ");
        sb.append(n);
        sb.append(", size is ");
        sb.append(this.a);
        throw new IndexOutOfBoundsException(sb.toString());
    }
    
    public int c() {
        return this.a;
    }
    
    public long[] d() {
        return Arrays.copyOf(this.b, this.a);
    }
}
