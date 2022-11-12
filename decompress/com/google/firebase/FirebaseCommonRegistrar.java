// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;
import android.os.Build;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import android.os.Build$VERSION;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import java.util.ArrayList;
import com.google.firebase.components.Component;
import java.util.List;
import android.content.pm.ApplicationInfo;
import android.content.Context;
import com.google.firebase.components.ComponentRegistrar;

public class FirebaseCommonRegistrar implements ComponentRegistrar
{
    public static String a(final Context context) {
        return h(context);
    }
    
    public static String b(final Context context) {
        return e(context);
    }
    
    public static String c(final Context context) {
        return f(context);
    }
    
    public static String d(final Context context) {
        return g(context);
    }
    
    private static String e(final Context context) {
        final ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            return String.valueOf(applicationInfo.targetSdkVersion);
        }
        return "";
    }
    
    private static String f(final Context context) {
        final ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            return String.valueOf(applicationInfo.minSdkVersion);
        }
        return "";
    }
    
    private static String g(final Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            return "tv";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            return "watch";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return "auto";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
            return "embedded";
        }
        return "";
    }
    
    private static String h(final Context context) {
        final String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        String i;
        if (installerPackageName != null) {
            i = i(installerPackageName);
        }
        else {
            i = "";
        }
        return i;
    }
    
    private static String i(final String s) {
        return s.replace(' ', '_').replace('/', '_');
    }
    
    @Override
    public List<Component<?>> getComponents() {
        final ArrayList list = new ArrayList();
        list.add(DefaultUserAgentPublisher.c());
        list.add(DefaultHeartBeatController.h());
        list.add(LibraryVersionComponent.b("fire-android", String.valueOf(Build$VERSION.SDK_INT)));
        list.add(LibraryVersionComponent.b("fire-core", "20.1.1"));
        list.add(LibraryVersionComponent.b("device-name", i(Build.PRODUCT)));
        list.add(LibraryVersionComponent.b("device-model", i(Build.DEVICE)));
        list.add(LibraryVersionComponent.b("device-brand", i(Build.BRAND)));
        list.add(LibraryVersionComponent.c("android-target-sdk", (LibraryVersionComponent$VersionExtractor)d.a));
        list.add(LibraryVersionComponent.c("android-min-sdk", (LibraryVersionComponent$VersionExtractor)e.a));
        list.add(LibraryVersionComponent.c("android-platform", (LibraryVersionComponent$VersionExtractor)f.a));
        list.add(LibraryVersionComponent.c("android-installer", (LibraryVersionComponent$VersionExtractor)c.a));
        final String a = KotlinDetector.a();
        if (a != null) {
            list.add(LibraryVersionComponent.b("kotlin", a));
        }
        return list;
    }
}
