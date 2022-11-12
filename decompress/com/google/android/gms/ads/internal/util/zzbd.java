// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class zzbd
{
    private final List a;
    private final List b;
    private final List c;
    
    public zzbd() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }
    
    static /* bridge */ List c(final zzbd zzbd) {
        return zzbd.b;
    }
    
    static /* bridge */ List d(final zzbd zzbd) {
        return zzbd.c;
    }
    
    static /* bridge */ List e(final zzbd zzbd) {
        return zzbd.a;
    }
    
    public final zzbd a(final String s, final double n, final double n2) {
        int i;
        for (i = 0; i < this.a.size(); ++i) {
            final double doubleValue = this.c.get(i);
            final double doubleValue2 = this.b.get(i);
            if (n < doubleValue) {
                break;
            }
            if (doubleValue == n && n2 < doubleValue2) {
                break;
            }
        }
        this.a.add(i, s);
        this.c.add(i, n);
        this.b.add(i, n2);
        return this;
    }
    
    public final zzbf b() {
        return new zzbf(this, null);
    }
}
