// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public final class VorbisBitArray
{
    private final byte[] a;
    private final int b;
    private int c;
    private int d;
    
    public VorbisBitArray(final byte[] a) {
        this.a = a;
        this.b = a.length;
    }
    
    private void a() {
        final int c = this.c;
        boolean b2 = false;
        Label_0038: {
            if (c >= 0) {
                final int b = this.b;
                if (c < b || (c == b && this.d == 0)) {
                    b2 = true;
                    break Label_0038;
                }
            }
            b2 = false;
        }
        Assertions.g(b2);
    }
    
    public int b() {
        return this.c * 8 + this.d;
    }
    
    public boolean c() {
        final boolean b = ((this.a[this.c] & 0xFF) >> this.d & 0x1) == 0x1;
        this.e(1);
        return b;
    }
    
    public int d(final int n) {
        final int c = this.c;
        int i = Math.min(n, 8 - this.d);
        final byte[] a = this.a;
        int n2 = c + 1;
        int n3 = (a[c] & 0xFF) >> this.d & 255 >> 8 - i;
        while (i < n) {
            n3 |= (this.a[n2] & 0xFF) << i;
            i += 8;
            ++n2;
        }
        this.e(n);
        return n3 & -1 >>> 32 - n;
    }
    
    public void e(int d) {
        final int n = d / 8;
        final int c = this.c + n;
        this.c = c;
        d = this.d + (d - n * 8);
        this.d = d;
        if (d > 7) {
            this.c = c + 1;
            this.d = d - 8;
        }
        this.a();
    }
}
