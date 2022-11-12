// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.internal.common.zzd;
import android.app.PendingIntent;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.wrappers.Wrappers;
import android.text.TextUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.internal.zzt;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@ShowFirstParty
public class GoogleApiAvailabilityLight
{
    @KeepForSdk
    public static final int a;
    private static final GoogleApiAvailabilityLight b;
    
    static {
        a = GooglePlayServicesUtilLight.a;
        b = new GoogleApiAvailabilityLight();
    }
    
    @KeepForSdk
    GoogleApiAvailabilityLight() {
    }
    
    @KeepForSdk
    public static GoogleApiAvailabilityLight h() {
        return GoogleApiAvailabilityLight.b;
    }
    
    @KeepForSdk
    public void a(final Context context) {
        GooglePlayServicesUtilLight.a(context);
    }
    
    @KeepForSdk
    @ShowFirstParty
    public int b(final Context context) {
        return GooglePlayServicesUtilLight.c(context);
    }
    
    @Deprecated
    @KeepForSdk
    @ShowFirstParty
    public Intent c(final int n) {
        return this.d(null, n, null);
    }
    
    @KeepForSdk
    @ShowFirstParty
    public Intent d(final Context context, final int n, final String s) {
        if (n != 1 && n != 2) {
            if (n != 3) {
                return null;
            }
            return zzt.c("com.google.android.gms");
        }
        else {
            if (context != null && DeviceProperties.f(context)) {
                return zzt.a();
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("gcore_");
            sb.append(GoogleApiAvailabilityLight.a);
            sb.append("-");
            if (!TextUtils.isEmpty((CharSequence)s)) {
                sb.append(s);
            }
            sb.append("-");
            if (context != null) {
                sb.append(context.getPackageName());
            }
            sb.append("-");
            Label_0144: {
                if (context == null) {
                    break Label_0144;
                }
                try {
                    sb.append(Wrappers.a(context).f(context.getPackageName(), 0).versionCode);
                    return zzt.b("com.google.android.gms", sb.toString());
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    return zzt.b("com.google.android.gms", sb.toString());
                }
            }
        }
    }
    
    @KeepForSdk
    public PendingIntent e(final Context context, final int n, final int n2) {
        return this.f(context, n, n2, null);
    }
    
    @KeepForSdk
    @ShowFirstParty
    public PendingIntent f(final Context context, final int n, final int n2, final String s) {
        final Intent d = this.d(context, n, s);
        if (d == null) {
            return null;
        }
        return PendingIntent.getActivity(context, n2, d, zzd.zza | 0x8000000);
    }
    
    @KeepForSdk
    public String g(final int n) {
        return GooglePlayServicesUtilLight.d(n);
    }
    
    @KeepForSdk
    @HideFirstParty
    public int i(final Context context) {
        return this.j(context, GoogleApiAvailabilityLight.a);
    }
    
    @KeepForSdk
    public int j(final Context context, int h) {
        h = GooglePlayServicesUtilLight.h(context, h);
        if (GooglePlayServicesUtilLight.i(context, h)) {
            return 18;
        }
        return h;
    }
    
    @KeepForSdk
    @ShowFirstParty
    public boolean k(final Context context, final int n) {
        return GooglePlayServicesUtilLight.i(context, n);
    }
    
    @KeepForSdk
    public boolean l(final Context context, final String s) {
        return GooglePlayServicesUtilLight.m(context, s);
    }
    
    @KeepForSdk
    public boolean m(final int n) {
        return GooglePlayServicesUtilLight.k(n);
    }
    
    @KeepForSdk
    public void n(final Context context, final int n) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.b(context, n);
    }
}
