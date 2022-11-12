// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.util.Iterator;
import android.content.pm.PackageInstaller$SessionInfo;
import com.google.android.gms.common.util.UidVerifier;
import android.os.Bundle;
import android.os.UserManager;
import com.google.android.gms.common.util.PlatformVersion;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzag;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import android.content.res.Resources;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.app.NotificationManager;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@ShowFirstParty
public class GooglePlayServicesUtilLight
{
    @Deprecated
    @KeepForSdk
    public static final int a = 12451000;
    @KeepForSdk
    @VisibleForTesting
    static final AtomicBoolean b;
    private static boolean c = false;
    @VisibleForTesting
    static boolean d = false;
    private static final AtomicBoolean e;
    
    static {
        b = new AtomicBoolean();
        e = new AtomicBoolean();
    }
    
    @KeepForSdk
    GooglePlayServicesUtilLight() {
    }
    
    @Deprecated
    @KeepForSdk
    public static void a(final Context context) {
        if (GooglePlayServicesUtilLight.b.getAndSet(true)) {
            return;
        }
        try {
            final NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        }
        catch (final SecurityException ex) {}
    }
    
    @Deprecated
    @KeepForSdk
    public static void b(final Context context, int j) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        j = GoogleApiAvailabilityLight.h().j(context, j);
        if (j == 0) {
            return;
        }
        final Intent d = GoogleApiAvailabilityLight.h().d(context, j, "e");
        final StringBuilder sb = new StringBuilder();
        sb.append("GooglePlayServices not available due to error ");
        sb.append(j);
        Log.e("GooglePlayServicesUtil", sb.toString());
        if (d == null) {
            throw new GooglePlayServicesNotAvailableException(j);
        }
        throw new GooglePlayServicesRepairableException(j, "Google Play Services not available", d);
    }
    
    @Deprecated
    @KeepForSdk
    @ShowFirstParty
    public static int c(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }
    
    @Deprecated
    @KeepForSdk
    @VisibleForTesting
    public static String d(final int n) {
        return ConnectionResult.P1(n);
    }
    
    @KeepForSdk
    public static Context e(Context packageContext) {
        try {
            packageContext = packageContext.createPackageContext("com.google.android.gms", 3);
            return packageContext;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return null;
        }
    }
    
    @KeepForSdk
    public static Resources f(final Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return null;
        }
    }
    
    @KeepForSdk
    @ShowFirstParty
    public static boolean g(final Context context) {
        if (!GooglePlayServicesUtilLight.d) {
            try {
                try {
                    final PackageInfo f = Wrappers.a(context).f("com.google.android.gms", 64);
                    GoogleSignatureVerifier.a(context);
                    if (f != null && !GoogleSignatureVerifier.e(f, false) && GoogleSignatureVerifier.e(f, true)) {
                        GooglePlayServicesUtilLight.c = true;
                    }
                    else {
                        GooglePlayServicesUtilLight.c = false;
                    }
                    GooglePlayServicesUtilLight.d = true;
                }
                finally {}
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", (Throwable)ex);
                GooglePlayServicesUtilLight.d = true;
                return GooglePlayServicesUtilLight.c || !DeviceProperties.d();
            }
            GooglePlayServicesUtilLight.d = true;
        }
        return GooglePlayServicesUtilLight.c || !DeviceProperties.d();
    }
    
    @Deprecated
    @KeepForSdk
    public static int h(final Context context, int n) {
        try {
            context.getResources().getString(R.string.a);
        }
        finally {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            if (!GooglePlayServicesUtilLight.e.get()) {
                final int a = zzag.a(context);
                if (a == 0) {
                    throw new GooglePlayServicesMissingManifestValueException();
                }
                if (a != GooglePlayServicesUtilLight.a) {
                    throw new GooglePlayServicesIncorrectManifestValueException(a);
                }
            }
        }
        final boolean f = DeviceProperties.f(context);
        final int n2 = 1;
        final boolean b = !f && !DeviceProperties.h(context);
        Preconditions.a(n >= 0);
        final String packageName = context.getPackageName();
        final PackageManager packageManager = context.getPackageManager();
        Label_0186: {
            PackageInfo packageInfo = null;
            Block_9: {
                if (!b) {
                    packageInfo = null;
                    break Block_9;
                }
                try {
                    packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                    break Label_0186;
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                }
                n = 9;
                return n;
            }
            try {
                final PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier.a(context);
                if (!GoogleSignatureVerifier.e(packageInfo2, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                    return 9;
                }
                if (b) {
                    Preconditions.k(packageInfo);
                    if (!GoogleSignatureVerifier.e(packageInfo, true)) {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                        return 9;
                    }
                }
                if (b && packageInfo != null && !packageInfo.signatures[0].equals((Object)packageInfo2.signatures[0])) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                    return 9;
                }
                if (zza.a(packageInfo2.versionCode) < zza.a(n)) {
                    final int versionCode = packageInfo2.versionCode;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Google Play services out of date for ");
                    sb.append(packageName);
                    sb.append(".  Requires ");
                    sb.append(n);
                    sb.append(" but found ");
                    sb.append(versionCode);
                    Log.w("GooglePlayServicesUtil", sb.toString());
                    n = 2;
                }
                else {
                    ApplicationInfo applicationInfo;
                    if ((applicationInfo = packageInfo2.applicationInfo) == null) {
                        try {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        }
                        catch (final PackageManager$NameNotFoundException ex2) {
                            Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), (Throwable)ex2);
                            n = n2;
                            return n;
                        }
                    }
                    if (applicationInfo.enabled) {
                        return 0;
                    }
                    n = 3;
                }
            }
            catch (final PackageManager$NameNotFoundException ex3) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
                n = n2;
            }
        }
        return n;
    }
    
    @Deprecated
    @KeepForSdk
    @ShowFirstParty
    public static boolean i(final Context context, final int n) {
        return n == 18 || (n == 1 && m(context, "com.google.android.gms"));
    }
    
    @KeepForSdk
    public static boolean j(final Context context) {
        if (PlatformVersion.c()) {
            final Object systemService = context.getSystemService("user");
            Preconditions.k(systemService);
            final Bundle applicationRestrictions = ((UserManager)systemService).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    @KeepForSdk
    public static boolean k(final int n) {
        return n == 1 || n == 2 || n == 3 || n == 9;
    }
    
    @Deprecated
    @KeepForSdk
    public static boolean l(final Context context, final int n, final String s) {
        return UidVerifier.b(context, n, s);
    }
    
    static boolean m(final Context context, final String s) {
        final boolean equals = s.equals("com.google.android.gms");
        if (PlatformVersion.f()) {
            try {
                final Iterator iterator = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (iterator.hasNext()) {
                    if (s.equals(((PackageInstaller$SessionInfo)iterator.next()).getAppPackageName())) {
                        return true;
                    }
                }
            }
            catch (final Exception ex) {
                return false;
            }
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            final ApplicationInfo applicationInfo = packageManager.getApplicationInfo(s, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled && !j(context)) {
                return true;
            }
            return false;
        }
        catch (final PackageManager$NameNotFoundException ex2) {
            return false;
        }
    }
}
