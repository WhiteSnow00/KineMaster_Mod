// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public final class AdValue
{
    private final int a;
    private final String b;
    private final long c;
    
    private AdValue(final int a, final String b, final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static AdValue a(final int n, final String s, final long n2) {
        return new AdValue(n, s, n2);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface PrecisionType {
    }
}
