// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class GmsLogger
{
    private final String a;
    private final String b;
    
    @KeepForSdk
    public GmsLogger(final String s) {
        this(s, null);
    }
    
    @KeepForSdk
    public GmsLogger(final String a, final String b) {
        Preconditions.l(a, "log tag cannot be null");
        Preconditions.c(a.length() <= 23, "tag \"%s\" is longer than the %d character maximum", a, 23);
        this.a = a;
        if (b != null && b.length() > 0) {
            this.b = b;
            return;
        }
        this.b = null;
    }
    
    private final String f(final String s) {
        final String b = this.b;
        if (b == null) {
            return s;
        }
        return b.concat(s);
    }
    
    @KeepForSdk
    public boolean a(final int n) {
        return Log.isLoggable(this.a, n);
    }
    
    @KeepForSdk
    public void b(final String s, final String s2) {
        if (this.a(3)) {
            Log.d(s, this.f(s2));
        }
    }
    
    @KeepForSdk
    public void c(final String s, final String s2, final Throwable t) {
        if (this.a(6)) {
            Log.e(s, this.f(s2), t);
        }
    }
    
    @KeepForSdk
    public void d(final String s, final String s2) {
        if (this.a(2)) {
            Log.v(s, this.f(s2));
        }
    }
    
    @KeepForSdk
    public void e(final String s, final String s2) {
        if (this.a(5)) {
            Log.w(s, this.f(s2));
        }
    }
}
