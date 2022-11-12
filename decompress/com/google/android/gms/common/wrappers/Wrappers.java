// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.wrappers;

import com.google.android.gms.common.util.VisibleForTesting;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class Wrappers
{
    private static Wrappers b;
    private PackageManagerWrapper a;
    
    static {
        Wrappers.b = new Wrappers();
    }
    
    public Wrappers() {
        this.a = null;
    }
    
    @KeepForSdk
    public static PackageManagerWrapper a(final Context context) {
        return Wrappers.b.b(context);
    }
    
    @VisibleForTesting
    public final PackageManagerWrapper b(final Context context) {
        synchronized (this) {
            if (this.a == null) {
                Context applicationContext = context;
                if (context.getApplicationContext() != null) {
                    applicationContext = context.getApplicationContext();
                }
                this.a = new PackageManagerWrapper(applicationContext);
            }
            return this.a;
        }
    }
}
