// 
// Decompiled by Procyon v0.6.0
// 

package n2;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import e2.d;
import b2.a;

public final class b implements a
{
    private final d a;
    private final e2.b b;
    
    public b(final d a, final e2.b b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void a(final Bitmap bitmap) {
        this.a.c(bitmap);
    }
    
    @Override
    public byte[] b(final int n) {
        final e2.b b = this.b;
        if (b == null) {
            return new byte[n];
        }
        return b.c(n, byte[].class);
    }
    
    @Override
    public Bitmap c(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return this.a.e(n, n2, bitmap$Config);
    }
    
    @Override
    public int[] d(final int n) {
        final e2.b b = this.b;
        if (b == null) {
            return new int[n];
        }
        return b.c(n, int[].class);
    }
    
    @Override
    public void e(final byte[] array) {
        final e2.b b = this.b;
        if (b == null) {
            return;
        }
        b.put(array);
    }
    
    @Override
    public void f(final int[] array) {
        final e2.b b = this.b;
        if (b == null) {
            return;
        }
        b.put(array);
    }
}
