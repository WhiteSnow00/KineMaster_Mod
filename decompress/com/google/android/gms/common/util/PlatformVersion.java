// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.os.Build$VERSION;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public final class PlatformVersion
{
    private PlatformVersion() {
    }
    
    @KeepForSdk
    public static boolean a() {
        return true;
    }
    
    @KeepForSdk
    public static boolean b() {
        return true;
    }
    
    @KeepForSdk
    public static boolean c() {
        return true;
    }
    
    @KeepForSdk
    public static boolean d() {
        return true;
    }
    
    @KeepForSdk
    public static boolean e() {
        return true;
    }
    
    @KeepForSdk
    public static boolean f() {
        return true;
    }
    
    @KeepForSdk
    public static boolean g() {
        return true;
    }
    
    @KeepForSdk
    public static boolean h() {
        return true;
    }
    
    @KeepForSdk
    public static boolean i() {
        return true;
    }
    
    @KeepForSdk
    public static boolean j() {
        return Build$VERSION.SDK_INT >= 28;
    }
    
    @KeepForSdk
    public static boolean k() {
        return Build$VERSION.SDK_INT >= 29;
    }
    
    @KeepForSdk
    public static boolean l() {
        return Build$VERSION.SDK_INT >= 30;
    }
    
    @KeepForSdk
    public static boolean m() {
        return Build$VERSION.SDK_INT >= 31;
    }
}
