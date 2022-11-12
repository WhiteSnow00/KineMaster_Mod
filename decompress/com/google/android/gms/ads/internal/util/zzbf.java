// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class zzbf
{
    private final String[] a;
    private final double[] b;
    private final double[] c;
    private final int[] d;
    private int e;
    
    zzbf(final zzbd zzbd, final zzbe zzbe) {
        final int size = zzbd.c(zzbd).size();
        this.a = zzbd.e(zzbd).toArray(new String[size]);
        this.b = c(zzbd.c(zzbd));
        this.c = c(zzbd.d(zzbd));
        this.d = new int[size];
        this.e = 0;
    }
    
    private static final double[] c(final List list) {
        final int size = list.size();
        final double[] array = new double[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (double)list.get(i);
        }
        return array;
    }
    
    public final List a() {
        final ArrayList list = new ArrayList(this.a.length);
        int n = 0;
        while (true) {
            final String[] a = this.a;
            if (n >= a.length) {
                break;
            }
            final String s = a[n];
            final double n2 = this.c[n];
            final double n3 = this.b[n];
            final int n4 = this.d[n];
            list.add(new zzbc(s, n2, n3, n4 / (double)this.e, n4));
            ++n;
        }
        return list;
    }
    
    public final void b(final double n) {
        ++this.e;
        int n2 = 0;
        while (true) {
            final double[] c = this.c;
            if (n2 >= c.length) {
                break;
            }
            final double n3 = c[n2];
            if (n3 <= n && n < this.b[n2]) {
                final int[] d = this.d;
                ++d[n2];
            }
            if (n < n3) {
                break;
            }
            ++n2;
        }
    }
}
