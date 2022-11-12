// 
// Decompiled by Procyon v0.6.0
// 

package androidx.browser.customtabs;

import android.os.Parcelable;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.Looper;
import android.os.Handler;
import a.a;
import android.content.ServiceConnection;
import android.text.TextUtils;
import android.content.Intent;
import android.content.Context;
import android.content.ComponentName;
import a.b;

public class c
{
    private final b a;
    private final ComponentName b;
    private final Context c;
    
    c(final b a, final ComponentName b, final Context c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static boolean a(final Context context, final String package1, final e e) {
        e.setApplicationContext(context.getApplicationContext());
        final Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty((CharSequence)package1)) {
            intent.setPackage(package1);
        }
        return context.bindService(intent, (ServiceConnection)e, 33);
    }
    
    private a.a b(final androidx.browser.customtabs.b b) {
        return new a.a(this, b) {
            private Handler a = new Handler(Looper.getMainLooper());
            final c b;
            
            public void Q(final String s, final Bundle bundle) throws RemoteException {
            }
            
            public void a1(final int n, final Bundle bundle) {
            }
            
            public void j1(final String s, final Bundle bundle) throws RemoteException {
            }
            
            public void l1(final Bundle bundle) throws RemoteException {
            }
            
            public void m1(final int n, final Uri uri, final boolean b, final Bundle bundle) throws RemoteException {
            }
            
            public Bundle u(final String s, final Bundle bundle) throws RemoteException {
                return null;
            }
        };
    }
    
    private f d(androidx.browser.customtabs.b b, final PendingIntent pendingIntent) {
        final a.a b2 = this.b(b);
        b = null;
        Label_0048: {
            if (pendingIntent == null) {
                break Label_0048;
            }
            try {
                final Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", (Parcelable)pendingIntent);
                boolean b3 = this.a.O0(b2, bundle);
                while (true) {
                    if (!b3) {
                        return null;
                    }
                    b = (androidx.browser.customtabs.b)new f(this.a, b2, this.b, pendingIntent);
                    return (f)b;
                    b3 = this.a.F0(b2);
                    continue;
                }
            }
            catch (final RemoteException ex) {
                return (f)b;
            }
        }
    }
    
    public f c(final androidx.browser.customtabs.b b) {
        return this.d(b, null);
    }
    
    public boolean e(final long n) {
        try {
            return this.a.J0(n);
        }
        catch (final RemoteException ex) {
            return false;
        }
    }
}
