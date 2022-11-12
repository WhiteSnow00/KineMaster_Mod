// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.net.Uri$Builder;
import android.content.ComponentName;
import android.net.Uri;

public final class zzn
{
    private static final Uri f;
    private final String a;
    private final String b;
    private final ComponentName c;
    private final int d;
    private final boolean e;
    
    static {
        f = new Uri$Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    }
    
    public zzn(final ComponentName c, final int d) {
        this.a = null;
        this.b = null;
        Preconditions.k(c);
        this.c = c;
        this.d = d;
        this.e = false;
    }
    
    public zzn(final String a, final String b, final int d, final boolean e) {
        Preconditions.g(a);
        this.a = a;
        Preconditions.g(b);
        this.b = b;
        this.c = null;
        this.d = d;
        this.e = e;
    }
    
    public final int a() {
        return this.d;
    }
    
    public final ComponentName b() {
        return this.c;
    }
    
    public final Intent c(final Context context) {
        Intent setComponent;
        if (this.a != null) {
            final boolean e = this.e;
            setComponent = null;
            final Intent intent = null;
            if (e) {
                final Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", this.a);
                Bundle call;
                try {
                    call = context.getContentResolver().call(zzn.f, "serviceIntentCall", (String)null, bundle);
                }
                catch (final IllegalArgumentException ex) {
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(ex.toString()));
                    call = null;
                }
                Intent intent2;
                if (call == null) {
                    intent2 = intent;
                }
                else {
                    intent2 = (Intent)call.getParcelable("serviceResponseIntentKey");
                }
                setComponent = intent2;
                if (intent2 == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.a)));
                    setComponent = intent2;
                }
            }
            if (setComponent == null) {
                return new Intent(this.a).setPackage(this.b);
            }
        }
        else {
            setComponent = new Intent().setComponent(this.c);
        }
        return setComponent;
    }
    
    public final String d() {
        return this.b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzn)) {
            return false;
        }
        final zzn zzn = (zzn)o;
        return Objects.b(this.a, zzn.a) && Objects.b(this.b, zzn.b) && Objects.b(this.c, zzn.c) && this.d == zzn.d && this.e == zzn.e;
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d, this.e);
    }
    
    @Override
    public final String toString() {
        String s;
        if ((s = this.a) == null) {
            Preconditions.k(this.c);
            s = this.c.flattenToString();
        }
        return s;
    }
}
