// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import java.util.Iterator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import com.google.android.gms.tasks.Tasks;
import android.util.Log;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.BlockingServiceConnection;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.auth.zzby;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zze;
import android.os.IBinder;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzhj;
import com.google.android.gms.internal.auth.zzcz;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import android.accounts.AccountManager;
import java.io.IOException;
import android.os.Bundle;
import android.accounts.Account;
import android.content.Context;
import com.google.android.gms.common.logging.Logger;
import android.content.ComponentName;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public class zzl
{
    @ShowFirstParty
    public static final String[] a;
    @ShowFirstParty
    public static final String b;
    private static final ComponentName c;
    private static final Logger d;
    
    static {
        a = new String[] { "com.google", "com.google.work", "cn.google" };
        b = "androidPackageName";
        c = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        d = zzd.a("GoogleAuthUtil");
    }
    
    zzl() {
    }
    
    public static String a(final Context context, final Account account, final String s) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return b(context, account, s, new Bundle());
    }
    
    public static String b(final Context context, final Account account, final String s, final Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        m(account);
        return e(context, account, s, bundle).zza();
    }
    
    @Deprecated
    public static String c(final Context context, final String s, final String s2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return a(context, new Account(s, "com.google"), s2);
    }
    
    @Deprecated
    public static void d(final Context context, final String s) {
        AccountManager.get(context).invalidateAuthToken("com.google", s);
    }
    
    public static TokenData e(final Context context, final Account account, final String s, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Preconditions.j("Calling this from your main thread can lead to deadlock");
        Preconditions.h(s, "Scope cannot be empty or null.");
        m(account);
        k(context, 8400000);
        if (bundle == null) {
            bundle = new Bundle();
        }
        else {
            bundle = new Bundle(bundle);
        }
        final String packageName = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", packageName);
        final String b = zzl.b;
        if (TextUtils.isEmpty((CharSequence)bundle.getString(b))) {
            bundle.putString(b, packageName);
        }
        bundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        zzcz.zze(context);
        if (zzhj.zze() && n(context)) {
            final Task zzc = zzh.zza(context).zzc(account, s, bundle);
            try {
                final Bundle bundle2 = i((com.google.android.gms.tasks.Task<Bundle>)zzc, "token retrieval");
                j(bundle2);
                return g(bundle2);
            }
            catch (final ApiException ex) {
                l(ex, "token retrieval");
            }
        }
        return h(context, zzl.c, (a<TokenData>)new zzg(account, s, bundle));
    }
    
    static TokenData f(final Account account, final String s, final Bundle bundle, final IBinder binder) throws RemoteException, IOException, GoogleAuthException {
        final Bundle zze = com.google.android.gms.internal.auth.zze.zzb(binder).zze(account, s, bundle);
        if (zze != null) {
            return g(zze);
        }
        throw new IOException("Service call returned null");
    }
    
    private static TokenData g(final Bundle bundle) throws GoogleAuthException, IOException {
        final Parcelable$Creator<TokenData> creator = TokenData.CREATOR;
        final ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        final Bundle bundle2 = bundle.getBundle("tokenDetails");
        TokenData tokenData;
        if (bundle2 == null) {
            tokenData = null;
        }
        else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData)bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        final String string = bundle.getString("Error");
        final Intent intent = (Intent)bundle.getParcelable("userRecoveryIntent");
        final zzby zza = zzby.zza(string);
        if (zzby.zzb(zza)) {
            final Logger d = zzl.d;
            final String value = String.valueOf(zza);
            final StringBuilder sb = new StringBuilder(value.length() + 31);
            sb.append("isUserRecoverableError status: ");
            sb.append(value);
            d.h("GoogleAuthUtil", sb.toString());
            throw new UserRecoverableAuthException(string, intent);
        }
        if (!((Enum)zzby.zze).equals(zza) && !((Enum)zzby.zzf).equals(zza) && !((Enum)zzby.zzg).equals(zza) && !((Enum)zzby.zzae).equals(zza)) {
            throw new GoogleAuthException(string);
        }
        throw new IOException(string);
    }
    
    private static <T> T h(final Context ex, final ComponentName componentName, final a<T> a) throws IOException, GoogleAuthException {
        final BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        final GmsClientSupervisor c = GmsClientSupervisor.c((Context)ex);
        try {
            if (!c.a(componentName, (ServiceConnection)blockingServiceConnection, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service.");
            }
            try {
                try {
                    final T a2 = a.a(blockingServiceConnection.a());
                    c.e(componentName, (ServiceConnection)blockingServiceConnection, "GoogleAuthUtil");
                    return a2;
                }
                finally {}
            }
            catch (final InterruptedException ex) {}
            catch (final RemoteException ex2) {}
            Log.i("GoogleAuthUtil", "Error on service connection.", (Throwable)ex);
            throw new IOException("Error on service connection.", ex);
            c.e(componentName, (ServiceConnection)blockingServiceConnection, "GoogleAuthUtil");
        }
        catch (final SecurityException ex3) {
            Log.w("GoogleAuthUtil", String.format("SecurityException while bind to auth service: %s", ex3.getMessage()));
            throw new IOException("SecurityException while binding to Auth service.", ex3);
        }
    }
    
    private static <ResultT> ResultT i(final Task<ResultT> task, String s) throws IOException, ApiException {
        try {
            return (ResultT)Tasks.a((Task)task);
        }
        catch (final CancellationException ex) {
            s = String.format("Canceled while waiting for the task of %s to finish.", s);
            zzl.d.h(s, new Object[0]);
            throw new IOException(s, ex);
        }
        catch (final InterruptedException ex2) {
            s = String.format("Interrupted while waiting for the task of %s to finish.", s);
            zzl.d.h(s, new Object[0]);
            throw new IOException(s, ex2);
        }
        catch (final ExecutionException ex3) {
            final Throwable cause = ex3.getCause();
            if (cause instanceof ApiException) {
                throw (ApiException)cause;
            }
            s = String.format("Unable to get a result for %s due to ExecutionException.", s);
            zzl.d.h(s, new Object[0]);
            throw new IOException(s, ex3);
        }
    }
    
    private static <T> T j(final T t) throws IOException {
        if (t != null) {
            return t;
        }
        zzl.d.h("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }
    
    private static void k(final Context ex, final int n) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.b(((Context)ex).getApplicationContext(), n);
        }
        catch (final GooglePlayServicesIncorrectManifestValueException ex) {
            goto Label_0014;
        }
        catch (final GooglePlayServicesNotAvailableException ex2) {}
        catch (final GooglePlayServicesRepairableException ex3) {
            throw new GooglePlayServicesAvailabilityException(ex3.getConnectionStatusCode(), ex3.getMessage(), ex3.getIntent());
        }
    }
    
    private static void l(final ApiException ex, final String s) {
        zzl.d.h("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", s, Log.getStackTraceString((Throwable)ex));
    }
    
    private static void m(final Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (!TextUtils.isEmpty((CharSequence)account.name)) {
            final String[] a = zzl.a;
            for (int i = 0; i < 3; ++i) {
                if (a[i].equals(account.type)) {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        }
        throw new IllegalArgumentException("Account name cannot be empty!");
    }
    
    private static boolean n(final Context context) {
        if (GoogleApiAvailability.q().j(context, 17895000) != 0) {
            return false;
        }
        final String packageName = context.getApplicationInfo().packageName;
        final Iterator iterator = zzhj.zzb().zzm().iterator();
        while (iterator.hasNext()) {
            if (((String)iterator.next()).equals(packageName)) {
                return false;
            }
        }
        return true;
    }
}
