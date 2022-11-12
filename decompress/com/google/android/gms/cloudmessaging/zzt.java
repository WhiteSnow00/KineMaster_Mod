// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import java.util.List;
import android.content.pm.PackageManager;
import android.content.Intent;
import com.google.android.gms.common.util.PlatformVersion;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;
import android.content.Context;

public final class zzt
{
    private final Context a;
    @GuardedBy
    private int b;
    @GuardedBy
    private int c;
    
    public zzt(final Context a) {
        this.c = 0;
        this.a = a;
    }
    
    public final int a() {
        synchronized (this) {
            if (this.b == 0) {
                PackageInfo f;
                try {
                    f = Wrappers.a(this.a).f("com.google.android.gms", 0);
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    final String value = String.valueOf(ex);
                    final StringBuilder sb = new StringBuilder(value.length() + 23);
                    sb.append("Failed to find package ");
                    sb.append(value);
                    Log.w("Metadata", sb.toString());
                    f = null;
                }
                if (f != null) {
                    this.b = f.versionCode;
                }
            }
            return this.b;
        }
    }
    
    public final int b() {
        synchronized (this) {
            final int c = this.c;
            if (c != 0) {
                return c;
            }
            final PackageManager packageManager = this.a.getPackageManager();
            if (Wrappers.a(this.a).b("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                Log.e("Metadata", "Google Play services missing or without correct permission.");
                return 0;
            }
            final boolean i = PlatformVersion.i();
            int n = 1;
            if (!i) {
                final Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                final List queryIntentServices = packageManager.queryIntentServices(intent, 0);
                if (queryIntentServices != null) {
                    if (queryIntentServices.size() > 0) {
                        return this.c = 1;
                    }
                }
            }
            final Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
            intent2.setPackage("com.google.android.gms");
            final List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return this.c = 2;
            }
            Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.i()) {
                this.c = 2;
                n = 2;
            }
            else {
                this.c = 1;
            }
            return n;
        }
    }
}
