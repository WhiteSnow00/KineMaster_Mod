// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content;

import androidx.core.util.c;
import android.os.Process;
import androidx.core.app.e;
import android.content.Context;

public final class d
{
    public static int a(final Context context, String s, int n, final int n2, String packageName) {
        if (context.checkPermission(s, n, n2) == -1) {
            return -1;
        }
        final String c = e.c(s);
        final int n3 = 0;
        if (c == null) {
            return 0;
        }
        if ((s = packageName) == null) {
            final String[] packagesForUid = context.getPackageManager().getPackagesForUid(n2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            s = packagesForUid[0];
        }
        n = Process.myUid();
        packageName = context.getPackageName();
        if (n == n2 && androidx.core.util.c.a(packageName, s)) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            n = e.a(context, n2, c, s);
        }
        else {
            n = e.b(context, c, s);
        }
        if (n == 0) {
            n = n3;
        }
        else {
            n = -2;
        }
        return n;
    }
    
    public static int b(final Context context, final String s) {
        return a(context, s, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
