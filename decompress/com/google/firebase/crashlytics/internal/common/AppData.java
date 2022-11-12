// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageInfo;
import android.content.Context;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

public class AppData
{
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final DevelopmentPlatformProvider g;
    
    public AppData(final String a, final String b, final String c, final String d, final String e, final String f, final DevelopmentPlatformProvider g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public static AppData a(final Context context, final IdManager idManager, final String s, final String s2, final DevelopmentPlatformProvider developmentPlatformProvider) throws PackageManager$NameNotFoundException {
        final String packageName = context.getPackageName();
        final String g = idManager.g();
        final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        final String string = Integer.toString(packageInfo.versionCode);
        String versionName;
        if ((versionName = packageInfo.versionName) == null) {
            versionName = "0.0";
        }
        return new AppData(s, s2, g, packageName, string, versionName, developmentPlatformProvider);
    }
}
