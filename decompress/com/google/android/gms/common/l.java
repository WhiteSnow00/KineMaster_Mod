// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.zzae;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.IBinder;
import java.util.concurrent.Callable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import android.os.RemoteException;
import android.util.Log;
import java.security.MessageDigest;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import android.os.StrictMode$ThreadPolicy;
import android.os.StrictMode;
import android.content.Context;
import com.google.android.gms.common.internal.zzaf;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
final class l
{
    static final j a;
    static final j b;
    static final j c;
    static final j d;
    private static volatile zzaf e;
    private static final Object f;
    private static Context g;
    
    static {
        a = new d(h.p1("0\u0082\u0005\u00c80\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bs\u00f9/\u008eQ\u00ed"));
        b = new e(h.p1("0\u0082\u0006\u00040\u0082\u0003\u00ec \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad\u00d7\u00e1r\u00cak\u00ec"));
        c = new f(h.p1("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000\u00c2\u00e0\u0087FdJ0\u008d0"));
        d = new g(h.p1("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000\u00d5\u0085¸l}\u00d3N\u00f50"));
        f = new Object();
    }
    
    static n a(final String s, final h h, final boolean b, final boolean b2) {
        final StrictMode$ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(s, h, b, b2);
        }
        finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
    
    static n b(final String s, final boolean b, final boolean b2, final boolean b3) {
        return g(s, b, false, false, true);
    }
    
    static String c(final boolean b, final String s, final h h) throws Exception {
        String s2;
        if (b || !f(s, h, true, false).a) {
            s2 = "not allowed";
        }
        else {
            s2 = "debug cert rejected";
        }
        final MessageDigest b2 = AndroidUtilsLight.b("SHA-256");
        Preconditions.k(b2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", s2, s, Hex.a(b2.digest(h.q1())), b, "12451000.false");
    }
    
    static void d(final Context context) {
        synchronized (l.class) {
            if (l.g != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                return;
            }
            if (context != null) {
                l.g = context.getApplicationContext();
            }
        }
    }
    
    static boolean e() {
        final StrictMode$ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                final boolean zzi = l.e.zzi();
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return zzi;
            }
            finally {}
        }
        catch (final RemoteException ex) {}
        catch (final DynamiteModule.LoadingException ex2) {}
        final RemoteException ex;
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return false;
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }
    
    private static n f(final String s, final h h, final boolean b, final boolean b2) {
        try {
            h();
            Preconditions.k(l.g);
            final zzs zzs = new zzs(s, h, b, b2);
            try {
                if (l.e.t0(zzs, ObjectWrapper.q1(l.g.getPackageManager()))) {
                    return n.b();
                }
                return new m(new zze(b, s, h), null);
            }
            catch (final RemoteException ex) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex);
                return n.d("module call", (Throwable)ex);
            }
        }
        catch (final DynamiteModule.LoadingException ex2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex2);
            return n.d("module init: ".concat(String.valueOf(ex2.getMessage())), ex2);
        }
    }
    
    private static n g(final String s, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final StrictMode$ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.k(l.g);
            n n = null;
            try {
                h();
                final zzo zzo = new zzo(s, b, false, (IBinder)ObjectWrapper.q1(l.g), false);
                Label_0054: {
                    if (!b4) {
                        break Label_0054;
                    }
                    try {
                        zzq zzq = l.e.K0(zzo);
                        while (true) {
                            if (zzq.K1()) {
                                n = com.google.android.gms.common.n.f(zzq.L1());
                                return n;
                            }
                            final String zza = zzq.zza();
                            Object o;
                            if (zzq.M1() == 4) {
                                o = new PackageManager$NameNotFoundException();
                            }
                            else {
                                o = null;
                            }
                            String s2 = zza;
                            if (zza == null) {
                                s2 = "error checking package certificate";
                            }
                            n = com.google.android.gms.common.n.g(zzq.L1(), zzq.M1(), s2, (Throwable)o);
                            return n;
                            zzq = l.e.U0(zzo);
                            continue;
                        }
                    }
                    catch (final RemoteException ex) {
                        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex);
                        n = com.google.android.gms.common.n.d("module call", (Throwable)ex);
                    }
                }
            }
            catch (final DynamiteModule.LoadingException ex2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex2);
                n = com.google.android.gms.common.n.d("module init: ".concat(String.valueOf(ex2.getMessage())), ex2);
            }
            return n;
        }
        finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
    
    private static void h() throws DynamiteModule.LoadingException {
        if (l.e != null) {
            return;
        }
        Preconditions.k(l.g);
        synchronized (l.f) {
            if (l.e == null) {
                l.e = zzae.M0(DynamiteModule.e(l.g, DynamiteModule.f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
