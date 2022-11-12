// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import android.os.Parcelable$Creator;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.ads.internal.client.zzaw;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class AdSize
{
    public static final AdSize i;
    public static final AdSize j;
    public static final AdSize k;
    public static final AdSize l;
    public static final AdSize m;
    public static final AdSize n;
    @Deprecated
    public static final AdSize o;
    public static final AdSize p;
    public static final AdSize q;
    public static final AdSize r;
    public static final AdSize s;
    private final int a;
    private final int b;
    private final String c;
    private boolean d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    
    static {
        i = new AdSize(320, 50, "320x50_mb");
        j = new AdSize(468, 60, "468x60_as");
        k = new AdSize(320, 100, "320x100_as");
        l = new AdSize(728, 90, "728x90_as");
        m = new AdSize(300, 250, "300x250_as");
        n = new AdSize(160, 600, "160x600_as");
        o = new AdSize(-1, -2, "smart_banner");
        p = new AdSize(-3, -4, "fluid");
        q = new AdSize(0, 0, "invalid");
        s = new AdSize(50, 50, "50x50_mb");
        r = new AdSize(-3, 0, "search_v2");
    }
    
    public AdSize(final int n, final int n2) {
        String value;
        if (n == -1) {
            value = "FULL";
        }
        else {
            value = String.valueOf(n);
        }
        String value2;
        if (n2 == -2) {
            value2 = "AUTO";
        }
        else {
            value2 = String.valueOf(n2);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append("x");
        sb.append(value2);
        sb.append("_as");
        this(n, n2, sb.toString());
    }
    
    AdSize(final int a, final int b, final String c) {
        if (a < 0 && a != -1 && a != -3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid width for AdSize: ");
            sb.append(a);
            throw new IllegalArgumentException(sb.toString());
        }
        if (b < 0 && b != -2 && b != -4) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid height for AdSize: ");
            sb2.append(b);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int a() {
        return this.b;
    }
    
    public int b(final Context context) {
        final int b = this.b;
        if (b == -4 || b == -3) {
            return -1;
        }
        if (b != -2) {
            zzaw.b();
            return zzcfb.zzv(context, this.b);
        }
        return zzq.K1(context.getResources().getDisplayMetrics());
    }
    
    public int c() {
        return this.a;
    }
    
    public int d(final Context context) {
        final int a = this.a;
        if (a == -3) {
            return -1;
        }
        if (a != -1) {
            zzaw.b();
            return zzcfb.zzv(context, this.a);
        }
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final Parcelable$Creator<zzq> creator = zzq.CREATOR;
        return displayMetrics.widthPixels;
    }
    
    public boolean e() {
        return this.a == -3 && this.b == -4;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdSize)) {
            return false;
        }
        final AdSize adSize = (AdSize)o;
        return this.a == adSize.a && this.b == adSize.b && this.c.equals(adSize.c);
    }
    
    final int f() {
        return this.h;
    }
    
    final int g() {
        return this.f;
    }
    
    final void h(final int f) {
        this.f = f;
    }
    
    @Override
    public int hashCode() {
        return this.c.hashCode();
    }
    
    final void i(final int h) {
        this.h = h;
    }
    
    final void j(final boolean b) {
        this.e = true;
    }
    
    final void k(final boolean b) {
        this.g = true;
    }
    
    final boolean l() {
        return this.d;
    }
    
    final boolean m() {
        return this.e;
    }
    
    final boolean n() {
        return this.g;
    }
    
    @Override
    public String toString() {
        return this.c;
    }
}
