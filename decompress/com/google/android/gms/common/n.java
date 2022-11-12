// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
class n
{
    private static final n e;
    final boolean a;
    @Nullable
    final String b;
    @Nullable
    final Throwable c;
    final int d;
    
    static {
        e = new n(true, 3, 1, null, null);
    }
    
    private n(final boolean a, final int d, final int n, @Nullable final String b, @Nullable final Throwable c) {
        this.a = a;
        this.d = d;
        this.b = b;
        this.c = c;
    }
    
    n(final boolean b, final int n, final int n2, final String s, final Throwable t, final zzw zzw) {
        this(false, 1, 5, null, null);
    }
    
    @Deprecated
    static n b() {
        return n.e;
    }
    
    static n c(final String s) {
        return new n(false, 1, 5, s, null);
    }
    
    static n d(final String s, final Throwable t) {
        return new n(false, 1, 5, s, t);
    }
    
    static n f(final int n) {
        return new n(true, n, 1, null, null);
    }
    
    static n g(final int n, final int n2, final String s, @Nullable final Throwable t) {
        return new n(false, n, n2, s, t);
    }
    
    @Nullable
    String a() {
        return this.b;
    }
    
    final void e() {
        if (!this.a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.c != null) {
                Log.d("GoogleCertificatesRslt", this.a(), this.c);
                return;
            }
            Log.d("GoogleCertificatesRslt", this.a());
        }
    }
}
