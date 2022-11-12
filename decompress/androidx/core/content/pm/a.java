// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.pm;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build$VERSION;
import android.content.pm.PackageInfo;

public final class a
{
    public static long a(final PackageInfo packageInfo) {
        if (Build$VERSION.SDK_INT >= 28) {
            return a.b(packageInfo);
        }
        return packageInfo.versionCode;
    }
    
    private static class a
    {
        static Signature[] a(final SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }
        
        static long b(final PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
        
        static Signature[] c(final SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }
        
        static boolean d(final SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }
        
        static boolean e(final PackageManager packageManager, final String s, final byte[] array, final int n) {
            return packageManager.hasSigningCertificate(s, array, n);
        }
    }
}
