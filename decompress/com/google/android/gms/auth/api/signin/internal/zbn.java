// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zbn
{
    private static zbn d;
    @VisibleForTesting
    final Storage a;
    @VisibleForTesting
    GoogleSignInAccount b;
    @VisibleForTesting
    GoogleSignInOptions c;
    
    private zbn(final Context context) {
        final Storage b = Storage.b(context);
        this.a = b;
        this.b = b.c();
        this.c = b.d();
    }
    
    public static zbn c(final Context context) {
        synchronized (zbn.class) {
            return f(context.getApplicationContext());
        }
    }
    
    private static zbn f(final Context context) {
        synchronized (zbn.class) {
            final zbn d = zbn.d;
            if (d != null) {
                return d;
            }
            return zbn.d = new zbn(context);
        }
    }
    
    public final GoogleSignInAccount a() {
        synchronized (this) {
            return this.b;
        }
    }
    
    public final GoogleSignInOptions b() {
        synchronized (this) {
            return this.c;
        }
    }
    
    public final void d() {
        synchronized (this) {
            this.a.a();
            this.b = null;
            this.c = null;
        }
    }
    
    public final void e(final GoogleSignInOptions c, final GoogleSignInAccount b) {
        synchronized (this) {
            this.a.f(b, c);
            this.b = b;
            this.c = c;
        }
    }
}
