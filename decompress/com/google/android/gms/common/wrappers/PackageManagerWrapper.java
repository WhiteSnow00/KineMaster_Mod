// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import com.google.android.gms.common.util.PlatformVersion;
import android.os.Process;
import android.os.Binder;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import androidx.core.util.d;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class PackageManagerWrapper
{
    protected final Context a;
    
    public PackageManagerWrapper(final Context a) {
        this.a = a;
    }
    
    @KeepForSdk
    public int a(final String s) {
        return this.a.checkCallingOrSelfPermission(s);
    }
    
    @KeepForSdk
    public int b(final String s, final String s2) {
        return this.a.getPackageManager().checkPermission(s, s2);
    }
    
    @KeepForSdk
    public ApplicationInfo c(final String s, final int n) throws PackageManager$NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(s, n);
    }
    
    @KeepForSdk
    public CharSequence d(final String s) throws PackageManager$NameNotFoundException {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(s, 0));
    }
    
    @KeepForSdk
    public d<CharSequence, Drawable> e(final String s) throws PackageManager$NameNotFoundException {
        final ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(s, 0);
        return d.a(this.a.getPackageManager().getApplicationLabel(applicationInfo), this.a.getPackageManager().getApplicationIcon(applicationInfo));
    }
    
    @KeepForSdk
    public PackageInfo f(final String s, final int n) throws PackageManager$NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(s, n);
    }
    
    @KeepForSdk
    public boolean g() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.a(this.a);
        }
        if (PlatformVersion.i()) {
            final String nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.a.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return false;
    }
    
    public final boolean h(int i, final String s) {
        if (PlatformVersion.d()) {
            try {
                final AppOpsManager appOpsManager = (AppOpsManager)this.a.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i, s);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            catch (final SecurityException ex) {
                return false;
            }
        }
        final String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (s != null && packagesForUid != null) {
            for (i = 0; i < packagesForUid.length; ++i) {
                if (s.equals(packagesForUid[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
