// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

final class a
{
    private final int a;
    private boolean b;
    private boolean c;
    public byte[] d;
    public int e;
    
    public a(final int a, final int n) {
        this.a = a;
        (this.d = new byte[n + 3])[2] = 1;
    }
    
    public void a(final byte[] array, final int n, int length) {
        if (!this.b) {
            return;
        }
        final int n2 = length - n;
        final byte[] d = this.d;
        length = d.length;
        final int e = this.e;
        if (length < e + n2) {
            this.d = Arrays.copyOf(d, (e + n2) * 2);
        }
        System.arraycopy(array, n, this.d, this.e, n2);
        this.e += n2;
    }
    
    public boolean b(final int n) {
        if (!this.b) {
            return false;
        }
        this.e -= n;
        this.b = false;
        return this.c = true;
    }
    
    public boolean c() {
        return this.c;
    }
    
    public void d() {
        this.b = false;
        this.c = false;
    }
    
    public void e(final int n) {
        final boolean b = this.b;
        boolean b2 = true;
        Assertions.g(b ^ true);
        if (n != this.a) {
            b2 = false;
        }
        this.b = b2;
        if (b2) {
            this.e = 3;
            this.c = false;
        }
    }
}
