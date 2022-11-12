// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzb
{
    public static int a(final AdSize adSize) {
        return adSize.g();
    }
    
    public static int b(final AdSize adSize) {
        return adSize.f();
    }
    
    public static AdSize c(final int n, final int n2, final String s) {
        return new AdSize(n, n2, s);
    }
    
    public static AdSize d(final int n, final int n2) {
        final AdSize adSize = new AdSize(n, n2);
        adSize.j(true);
        adSize.h(n2);
        return adSize;
    }
    
    public static AdSize e(final int n, final int n2) {
        final AdSize adSize = new AdSize(n, n2);
        adSize.k(true);
        adSize.i(n2);
        return adSize;
    }
    
    public static boolean f(final AdSize adSize) {
        return adSize.l();
    }
    
    public static boolean g(final AdSize adSize) {
        return adSize.m();
    }
    
    public static boolean h(final AdSize adSize) {
        return adSize.n();
    }
}
