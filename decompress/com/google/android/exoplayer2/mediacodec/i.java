// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import java.util.NoSuchElementException;

final class i
{
    private int a;
    private int b;
    private int c;
    private int[] d;
    private int e;
    
    public i() {
        this.a = 0;
        this.b = -1;
        this.c = 0;
        final int[] d = new int[16];
        this.d = d;
        this.e = d.length - 1;
    }
    
    private void c() {
        final int[] d = this.d;
        final int n = d.length << 1;
        if (n >= 0) {
            final int[] d2 = new int[n];
            final int length = d.length;
            final int a = this.a;
            final int n2 = length - a;
            System.arraycopy(d, a, d2, 0, n2);
            System.arraycopy(this.d, 0, d2, n2, a);
            this.a = 0;
            this.b = this.c - 1;
            this.d = d2;
            this.e = d2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }
    
    public void a(final int n) {
        if (this.c == this.d.length) {
            this.c();
        }
        final int b = this.b + 1 & this.e;
        this.b = b;
        this.d[b] = n;
        ++this.c;
    }
    
    public void b() {
        this.a = 0;
        this.b = -1;
        this.c = 0;
    }
    
    public boolean d() {
        return this.c == 0;
    }
    
    public int e() {
        final int c = this.c;
        if (c != 0) {
            final int[] d = this.d;
            final int a = this.a;
            final int n = d[a];
            this.a = (a + 1 & this.e);
            this.c = c - 1;
            return n;
        }
        throw new NoSuchElementException();
    }
}
