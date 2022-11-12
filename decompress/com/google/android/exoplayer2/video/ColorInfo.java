// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import java.util.Arrays;
import android.os.Bundle;
import h4.a;
import com.google.android.exoplayer2.Bundleable;

public final class ColorInfo implements Bundleable
{
    public static final Creator<ColorInfo> f;
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    private int e;
    
    static {
        f = (Creator)a.a;
    }
    
    public ColorInfo(final int a, final int b, final int c, final byte[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static ColorInfo a(final Bundle bundle) {
        return e(bundle);
    }
    
    public static int b(final int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 9) {
            return 6;
        }
        if (n != 4 && n != 5 && n != 6 && n != 7) {
            return -1;
        }
        return 2;
    }
    
    public static int c(final int n) {
        if (n != 1) {
            if (n == 16) {
                return 6;
            }
            if (n == 18) {
                return 7;
            }
            if (n != 6 && n != 7) {
                return -1;
            }
        }
        return 3;
    }
    
    private static String d(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static ColorInfo e(final Bundle bundle) {
        return new ColorInfo(bundle.getInt(d(0), -1), bundle.getInt(d(1), -1), bundle.getInt(d(2), -1), bundle.getByteArray(d(3)));
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && ColorInfo.class == o.getClass()) {
            final ColorInfo colorInfo = (ColorInfo)o;
            if (this.a != colorInfo.a || this.b != colorInfo.b || this.c != colorInfo.c || !Arrays.equals(this.d, colorInfo.d)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        if (this.e == 0) {
            this.e = (((527 + this.a) * 31 + this.b) * 31 + this.c) * 31 + Arrays.hashCode(this.d);
        }
        return this.e;
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putInt(d(0), this.a);
        bundle.putInt(d(1), this.b);
        bundle.putInt(d(2), this.c);
        bundle.putByteArray(d(3), this.d);
        return bundle;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(")");
        return sb.toString();
    }
}
