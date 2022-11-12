// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.util.Log;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import javax.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class GoogleSignatureVerifier
{
    @Nullable
    private static GoogleSignatureVerifier c;
    private final Context a;
    private volatile String b;
    
    public GoogleSignatureVerifier(final Context context) {
        this.a = context.getApplicationContext();
    }
    
    @KeepForSdk
    public static GoogleSignatureVerifier a(final Context context) {
        Preconditions.k(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (GoogleSignatureVerifier.c == null) {
                l.d(context);
                GoogleSignatureVerifier.c = new GoogleSignatureVerifier(context);
            }
            return GoogleSignatureVerifier.c;
        }
    }
    
    @Nullable
    static final h d(final PackageInfo packageInfo, final h... array) {
        final Signature[] signatures = packageInfo.signatures;
        if (signatures == null) {
            return null;
        }
        if (signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        final Signature[] signatures2 = packageInfo.signatures;
        int i = 0;
        final i j = new i(signatures2[0].toByteArray());
        while (i < array.length) {
            if (array[i].equals(j)) {
                return array[i];
            }
            ++i;
        }
        return null;
    }
    
    public static final boolean e(final PackageInfo packageInfo, final boolean b) {
        boolean b2 = b;
        Label_0065: {
            if (b) {
                b2 = b;
                if (packageInfo != null) {
                    if (!"com.android.vending".equals(packageInfo.packageName)) {
                        b2 = b;
                        if (!"com.google.android.gms".equals(packageInfo.packageName)) {
                            break Label_0065;
                        }
                    }
                    final ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    b2 = (applicationInfo != null && (applicationInfo.flags & 0x81) != 0x0);
                }
            }
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            h h;
            if (b2) {
                h = d(packageInfo, k.a);
            }
            else {
                h = d(packageInfo, k.a[0]);
            }
            if (h != null) {
                return true;
            }
        }
        return false;
    }
    
    private final n f(final String b, final boolean b2, final boolean b3) {
        if (b == null) {
            return n.c("null pkg");
        }
        if (!b.equals(this.b)) {
            Label_0207: {
                if (l.e()) {
                    final n n = l.b(b, GooglePlayServicesUtilLight.g(this.a), false, false);
                    break Label_0207;
                }
                try {
                    final PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(b, 64);
                    final boolean g = GooglePlayServicesUtilLight.g(this.a);
                    n n;
                    if (packageInfo == null) {
                        n = com.google.android.gms.common.n.c("null pkg");
                    }
                    else {
                        final Signature[] signatures = packageInfo.signatures;
                        if (signatures != null && signatures.length == 1) {
                            final i i = new i(packageInfo.signatures[0].toByteArray());
                            final String packageName = packageInfo.packageName;
                            n = l.a(packageName, i, g, false);
                            if (n.a) {
                                final ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                                if (applicationInfo != null && (applicationInfo.flags & 0x2) != 0x0 && l.a(packageName, i, false, true).a) {
                                    n = com.google.android.gms.common.n.c("debuggable release cert app rejected");
                                }
                            }
                        }
                        else {
                            n = com.google.android.gms.common.n.c("single cert required");
                        }
                    }
                    if (n.a) {
                        this.b = b;
                    }
                    return n;
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    return n.d("no pkg ".concat(b), (Throwable)ex);
                }
            }
        }
        return n.b();
    }
    
    @KeepForSdk
    public boolean b(final PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.g(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }
    
    @KeepForSdk
    @ShowFirstParty
    public boolean c(int i) {
        final String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        n n = null;
        Label_0079: {
            if (packagesForUid != null) {
                final int length = packagesForUid.length;
                if (length != 0) {
                    n = null;
                    for (i = 0; i < length; ++i) {
                        n = this.f(packagesForUid[i], false, false);
                        if (n.a) {
                            break Label_0079;
                        }
                    }
                    Preconditions.k(n);
                    break Label_0079;
                }
            }
            n = com.google.android.gms.common.n.c("no pkgs");
        }
        n.e();
        return n.a;
    }
}
