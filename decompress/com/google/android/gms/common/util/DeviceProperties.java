// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import android.content.pm.PackageManager;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties
{
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;
    private static Boolean e;
    
    private DeviceProperties() {
    }
    
    @KeepForSdk
    public static boolean a(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        if (DeviceProperties.e == null) {
            final boolean i = PlatformVersion.i();
            boolean b = false;
            if (i) {
                b = b;
                if (packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                    b = true;
                }
            }
            DeviceProperties.e = b;
        }
        return DeviceProperties.e;
    }
    
    @KeepForSdk
    public static boolean b(final Context context) {
        if (DeviceProperties.c == null) {
            final PackageManager packageManager = context.getPackageManager();
            final boolean hasSystemFeature = packageManager.hasSystemFeature("com.google.android.feature.services_updater");
            boolean b = false;
            if (hasSystemFeature) {
                b = b;
                if (packageManager.hasSystemFeature("cn.google.services")) {
                    b = true;
                }
            }
            DeviceProperties.c = b;
        }
        return DeviceProperties.c;
    }
    
    @KeepForSdk
    public static boolean c(final Context context) {
        return g(context);
    }
    
    @KeepForSdk
    public static boolean d() {
        final int a = GooglePlayServicesUtilLight.a;
        return "user".equals(Build.TYPE);
    }
    
    @KeepForSdk
    public static boolean e(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        if (DeviceProperties.a == null) {
            final boolean e = PlatformVersion.e();
            boolean b = false;
            if (e) {
                b = b;
                if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
                    b = true;
                }
            }
            DeviceProperties.a = b;
        }
        return DeviceProperties.a;
    }
    
    @KeepForSdk
    public static boolean f(final Context context) {
        return (e(context) && !PlatformVersion.h()) || (g(context) && (!PlatformVersion.i() || PlatformVersion.l()));
    }
    
    public static boolean g(final Context context) {
        if (DeviceProperties.b == null) {
            final boolean f = PlatformVersion.f();
            boolean b = false;
            if (f) {
                b = b;
                if (context.getPackageManager().hasSystemFeature("cn.google")) {
                    b = true;
                }
            }
            DeviceProperties.b = b;
        }
        return DeviceProperties.b;
    }
    
    public static boolean h(final Context context) {
        if (DeviceProperties.d == null) {
            final boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.type.iot");
            boolean b = true;
            if (!hasSystemFeature) {
                b = (context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") && b);
            }
            DeviceProperties.d = b;
        }
        return DeviceProperties.d;
    }
}
