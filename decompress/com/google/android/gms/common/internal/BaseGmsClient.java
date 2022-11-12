// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.content.Intent;
import java.util.Collections;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import java.util.concurrent.Executor;
import android.accounts.Account;
import com.google.android.gms.common.api.CommonStatusCodes;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.IBinder;
import android.app.PendingIntent;
import android.os.Bundle;
import android.content.ServiceConnection;
import android.util.Log;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import android.os.Looper;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import android.os.Handler;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.IInterface;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface>
{
    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES;
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zze;
    private volatile String zzA;
    private ConnectionResult zzB;
    private boolean zzC;
    private volatile zzj zzD;
    @VisibleForTesting
    zzu zza;
    final Handler zzb;
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks zzc;
    @VisibleForTesting
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    @GuardedBy
    private IGmsServiceBroker zzr;
    @GuardedBy
    private IInterface zzs;
    private final ArrayList zzt;
    @GuardedBy
    private zze zzu;
    @GuardedBy
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;
    
    static {
        zze = new Feature[0];
        GOOGLE_PLUS_REQUIRED_FEATURES = new String[] { "service_esmobile", "service_googleme" };
    }
    
    @KeepForSdk
    @VisibleForTesting
    protected BaseGmsClient(final Context zzl, final Handler zzb, final GmsClientSupervisor zzn, final GoogleApiAvailabilityLight zzo, final int zzy, final BaseConnectionCallbacks zzw, final BaseOnConnectionFailedListener zzx) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.l(zzl, "Context must not be null");
        this.zzl = zzl;
        Preconditions.l(zzb, "Handler must not be null");
        this.zzb = zzb;
        this.zzm = zzb.getLooper();
        Preconditions.l(zzn, "Supervisor must not be null");
        this.zzn = zzn;
        Preconditions.l(zzo, "API availability must not be null");
        this.zzo = zzo;
        this.zzy = zzy;
        this.zzw = zzw;
        this.zzx = zzx;
        this.zzz = null;
    }
    
    @KeepForSdk
    protected BaseGmsClient(final Context context, final Looper looper, final int n, final BaseConnectionCallbacks baseConnectionCallbacks, final BaseOnConnectionFailedListener baseOnConnectionFailedListener, final String s) {
        final GmsClientSupervisor c = GmsClientSupervisor.c(context);
        final GoogleApiAvailabilityLight h = GoogleApiAvailabilityLight.h();
        Preconditions.k(baseConnectionCallbacks);
        Preconditions.k(baseOnConnectionFailedListener);
        this(context, looper, c, h, n, baseConnectionCallbacks, baseOnConnectionFailedListener, s);
    }
    
    @KeepForSdk
    @VisibleForTesting
    protected BaseGmsClient(final Context zzl, final Looper zzm, final GmsClientSupervisor zzn, final GoogleApiAvailabilityLight zzo, final int zzy, final BaseConnectionCallbacks zzw, final BaseOnConnectionFailedListener zzx, final String zzz) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.l(zzl, "Context must not be null");
        this.zzl = zzl;
        Preconditions.l(zzm, "Looper must not be null");
        this.zzm = zzm;
        Preconditions.l(zzn, "Supervisor must not be null");
        this.zzn = zzn;
        Preconditions.l(zzo, "API availability must not be null");
        this.zzo = zzo;
        this.zzb = (Handler)new k(this, zzm);
        this.zzy = zzy;
        this.zzw = zzw;
        this.zzx = zzx;
        this.zzz = zzz;
    }
    
    static /* bridge */ ConnectionResult zza(final BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzB;
    }
    
    static /* bridge */ BaseConnectionCallbacks zzb(final BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzw;
    }
    
    static /* bridge */ BaseOnConnectionFailedListener zzc(final BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzx;
    }
    
    static /* bridge */ Object zzd(final BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzq;
    }
    
    static /* bridge */ ArrayList zzf(final BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzt;
    }
    
    static /* bridge */ void zzg(final BaseGmsClient baseGmsClient, final ConnectionResult zzB) {
        baseGmsClient.zzB = zzB;
    }
    
    static /* bridge */ void zzh(final BaseGmsClient baseGmsClient, final IGmsServiceBroker zzr) {
        baseGmsClient.zzr = zzr;
    }
    
    static /* bridge */ void zzi(final BaseGmsClient baseGmsClient, final int n, final IInterface interface1) {
        baseGmsClient.zzp(n, null);
    }
    
    static /* bridge */ void zzj(final BaseGmsClient baseGmsClient, final zzj zzD) {
        baseGmsClient.zzD = zzD;
        if (baseGmsClient.usesClientTelemetry()) {
            final ConnectionTelemetryConfiguration d = zzD.d;
            final RootTelemetryConfigManager b = RootTelemetryConfigManager.b();
            RootTelemetryConfiguration p2;
            if (d == null) {
                p2 = null;
            }
            else {
                p2 = d.P1();
            }
            b.c(p2);
        }
    }
    
    static /* bridge */ void zzk(final BaseGmsClient baseGmsClient, int zzv) {
        Object o = baseGmsClient.zzp;
        synchronized (o) {
            zzv = baseGmsClient.zzv;
            monitorexit(o);
            if (zzv == 3) {
                baseGmsClient.zzC = true;
                zzv = 5;
            }
            else {
                zzv = 4;
            }
            o = baseGmsClient.zzb;
            ((Handler)o).sendMessage(((Handler)o).obtainMessage(zzv, baseGmsClient.zzd.get(), 16));
        }
    }
    
    static /* bridge */ boolean zzm(final BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzC;
    }
    
    static /* bridge */ boolean zzn(final BaseGmsClient baseGmsClient, final int n, final int n2, final IInterface interface1) {
        synchronized (baseGmsClient.zzp) {
            boolean b;
            if (baseGmsClient.zzv != n) {
                monitorexit(baseGmsClient.zzp);
                b = false;
            }
            else {
                baseGmsClient.zzp(n2, interface1);
                monitorexit(baseGmsClient.zzp);
                b = true;
            }
            return b;
        }
    }
    
    static /* bridge */ boolean zzo(final BaseGmsClient baseGmsClient) {
        final boolean zzC = baseGmsClient.zzC;
        boolean b = false;
        if (zzC) {
            return b;
        }
        if (TextUtils.isEmpty((CharSequence)baseGmsClient.getServiceDescriptor())) {
            return b;
        }
        if (TextUtils.isEmpty((CharSequence)baseGmsClient.getLocalStartServiceAction())) {
            return b;
        }
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            b = true;
            return b;
        }
        catch (final ClassNotFoundException ex) {
            return b;
        }
    }
    
    private final void zzp(int a, final IInterface zzs) {
        boolean b = false;
        if (a == 4 == (zzs != null)) {
            b = true;
        }
        Preconditions.a(b);
        synchronized (this.zzp) {
            this.zzv = a;
            this.zzs = zzs;
            if (a != 1) {
                if (a != 2 && a != 3) {
                    if (a == 4) {
                        Preconditions.k(zzs);
                        this.onConnectedLocked(zzs);
                    }
                }
                else {
                    final zze zzu = this.zzu;
                    if (zzu != null) {
                        final zzu zza = this.zza;
                        if (zza != null) {
                            final String c = zza.c();
                            final String b2 = zza.b();
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Calling connect() while still connected, missing disconnect() for ");
                            sb.append(c);
                            sb.append(" on ");
                            sb.append(b2);
                            Log.e("GmsClient", sb.toString());
                            final GmsClientSupervisor zzn = this.zzn;
                            final String c2 = this.zza.c();
                            Preconditions.k(c2);
                            zzn.g(c2, this.zza.b(), this.zza.a(), (ServiceConnection)zzu, this.zze(), this.zza.d());
                            this.zzd.incrementAndGet();
                        }
                    }
                    final zze zzu2 = new zze(this, this.zzd.get());
                    this.zzu = zzu2;
                    zzu zza2;
                    if (this.zzv == 3 && this.getLocalStartServiceAction() != null) {
                        zza2 = new zzu(this.getContext().getPackageName(), this.getLocalStartServiceAction(), true, GmsClientSupervisor.b(), false);
                    }
                    else {
                        zza2 = new zzu(this.getStartServicePackage(), this.getStartServiceAction(), false, GmsClientSupervisor.b(), this.getUseDynamicLookup());
                    }
                    this.zza = zza2;
                    if (zza2.d() && this.getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.c())));
                    }
                    final GmsClientSupervisor zzn2 = this.zzn;
                    final String c3 = this.zza.c();
                    Preconditions.k(c3);
                    final String b3 = this.zza.b();
                    a = this.zza.a();
                    if (!zzn2.h(new zzn(c3, b3, a, this.zza.d()), (ServiceConnection)zzu2, this.zze(), this.getBindServiceExecutor())) {
                        final String c4 = this.zza.c();
                        final String b4 = this.zza.b();
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("unable to connect to service: ");
                        sb2.append(c4);
                        sb2.append(" on ");
                        sb2.append(b4);
                        Log.w("GmsClient", sb2.toString());
                        this.zzl(16, null, this.zzd.get());
                    }
                }
            }
            else {
                final zze zzu3 = this.zzu;
                if (zzu3 != null) {
                    final GmsClientSupervisor zzn3 = this.zzn;
                    final String c5 = this.zza.c();
                    Preconditions.k(c5);
                    zzn3.g(c5, this.zza.b(), this.zza.a(), (ServiceConnection)zzu3, this.zze(), this.zza.d());
                    this.zzu = null;
                }
            }
        }
    }
    
    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        final int j = this.zzo.j(this.zzl, this.getMinApkVersion());
        if (j != 0) {
            this.zzp(1, null);
            this.triggerNotAvailable((ConnectionProgressReportCallbacks)new LegacyClientCallbackAdapter(), j, null);
            return;
        }
        this.connect((ConnectionProgressReportCallbacks)new LegacyClientCallbackAdapter());
    }
    
    @KeepForSdk
    protected final void checkConnected() {
        if (this.isConnected()) {
            return;
        }
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
    
    @KeepForSdk
    public void connect(final ConnectionProgressReportCallbacks zzc) {
        Preconditions.l(zzc, "Connection progress callbacks cannot be null.");
        this.zzc = zzc;
        this.zzp(2, null);
    }
    
    @KeepForSdk
    protected abstract T createServiceInterface(final IBinder p0);
    
    @KeepForSdk
    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            for (int size = this.zzt.size(), i = 0; i < size; ++i) {
                ((zzc)this.zzt.get(i)).d();
            }
            this.zzt.clear();
            monitorexit(this.zzt);
            synchronized (this.zzq) {
                this.zzr = null;
                monitorexit(this.zzq);
                this.zzp(1, null);
            }
        }
    }
    
    @KeepForSdk
    public void disconnect(final String zzk) {
        this.zzk = zzk;
        this.disconnect();
    }
    
    @KeepForSdk
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, String[] array) {
        array = (String[])this.zzp;
        synchronized (array) {
            final int zzv = this.zzv;
            final IInterface zzs = this.zzs;
            monitorexit(array);
            array = (String[])this.zzq;
            synchronized (array) {
                final IGmsServiceBroker zzr = this.zzr;
                monitorexit(array);
                printWriter.append(s).append("mConnectState=");
                if (zzv != 1) {
                    if (zzv != 2) {
                        if (zzv != 3) {
                            if (zzv != 4) {
                                if (zzv != 5) {
                                    printWriter.print("UNKNOWN");
                                }
                                else {
                                    printWriter.print("DISCONNECTING");
                                }
                            }
                            else {
                                printWriter.print("CONNECTED");
                            }
                        }
                        else {
                            printWriter.print("LOCAL_CONNECTING");
                        }
                    }
                    else {
                        printWriter.print("REMOTE_CONNECTING");
                    }
                }
                else {
                    printWriter.print("DISCONNECTED");
                }
                printWriter.append(" mService=");
                if (zzs == null) {
                    printWriter.append("null");
                }
                else {
                    printWriter.append(this.getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(zzs.asBinder())));
                }
                printWriter.append(" mServiceBroker=");
                if (zzr == null) {
                    printWriter.println("null");
                }
                else {
                    printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((IInterface)zzr).asBinder())));
                }
                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
                if (this.zzh > 0L) {
                    final PrintWriter append = printWriter.append(s).append("lastConnectedTime=");
                    final long zzh = this.zzh;
                    final String format = simpleDateFormat.format(new Date(zzh));
                    array = (String[])(Object)new StringBuilder();
                    ((StringBuilder)(Object)array).append(zzh);
                    ((StringBuilder)(Object)array).append(" ");
                    ((StringBuilder)(Object)array).append(format);
                    append.println(((StringBuilder)(Object)array).toString());
                }
                if (this.zzg > 0L) {
                    printWriter.append(s).append("lastSuspendedCause=");
                    final int zzf = this.zzf;
                    if (zzf != 1) {
                        if (zzf != 2) {
                            if (zzf != 3) {
                                printWriter.append(String.valueOf(zzf));
                            }
                            else {
                                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
                            }
                        }
                        else {
                            printWriter.append("CAUSE_NETWORK_LOST");
                        }
                    }
                    else {
                        printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    }
                    final PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
                    final long zzg = this.zzg;
                    array = (String[])(Object)simpleDateFormat.format(new Date(zzg));
                    final StringBuilder sb = new StringBuilder();
                    sb.append(zzg);
                    sb.append(" ");
                    sb.append((String)(Object)array);
                    append2.println(sb.toString());
                }
                if (this.zzj > 0L) {
                    printWriter.append(s).append("lastFailedStatus=").append(CommonStatusCodes.a(this.zzi));
                    final PrintWriter append3 = printWriter.append(" lastFailedTime=");
                    final long zzj = this.zzj;
                    final String format2 = simpleDateFormat.format(new Date(zzj));
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(zzj);
                    sb2.append(" ");
                    sb2.append(format2);
                    append3.println(sb2.toString());
                }
            }
        }
    }
    
    @KeepForSdk
    protected boolean enableLocalFallback() {
        return false;
    }
    
    @KeepForSdk
    public Account getAccount() {
        return null;
    }
    
    @KeepForSdk
    public Feature[] getApiFeatures() {
        return BaseGmsClient.zze;
    }
    
    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        final zzj zzD = this.zzD;
        if (zzD == null) {
            return null;
        }
        return zzD.b;
    }
    
    @KeepForSdk
    protected Executor getBindServiceExecutor() {
        return null;
    }
    
    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }
    
    @KeepForSdk
    public final Context getContext() {
        return this.zzl;
    }
    
    @KeepForSdk
    public String getEndpointPackageName() {
        if (this.isConnected()) {
            final zzu zza = this.zza;
            if (zza != null) {
                return zza.b();
            }
        }
        throw new RuntimeException("Failed to connect when checking package");
    }
    
    @KeepForSdk
    public int getGCoreServiceId() {
        return this.zzy;
    }
    
    @KeepForSdk
    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }
    
    @KeepForSdk
    public String getLastDisconnectMessage() {
        return this.zzk;
    }
    
    @KeepForSdk
    protected String getLocalStartServiceAction() {
        return null;
    }
    
    @KeepForSdk
    public final Looper getLooper() {
        return this.zzm;
    }
    
    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.a;
    }
    
    @KeepForSdk
    public void getRemoteService(final IAccountAccessor ex, final Set<Scope> set) {
        final Bundle getServiceRequestExtraArgs = this.getGetServiceRequestExtraArgs();
        final int zzy = this.zzy;
        final String zzA = this.zzA;
        final int a = GoogleApiAvailabilityLight.a;
        final Scope[] z = GetServiceRequest.z;
        final Bundle bundle = new Bundle();
        final Feature[] a2 = GetServiceRequest.A;
        final GetServiceRequest getServiceRequest = new GetServiceRequest(6, zzy, a, null, null, z, bundle, null, a2, a2, true, 0, false, zzA);
        getServiceRequest.d = this.zzl.getPackageName();
        getServiceRequest.g = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.f = (Scope[])set.toArray((Object[])new Scope[0]);
        }
        if (this.requiresSignIn()) {
            Account account;
            if ((account = this.getAccount()) == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.h = account;
            if (ex != null) {
                getServiceRequest.e = ((IInterface)ex).asBinder();
            }
        }
        else if (this.requiresAccount()) {
            getServiceRequest.h = this.getAccount();
        }
        getServiceRequest.i = BaseGmsClient.zze;
        getServiceRequest.j = this.getApiFeatures();
        if (this.usesClientTelemetry()) {
            getServiceRequest.x = true;
        }
        try {
            synchronized (this.zzq) {
                final IGmsServiceBroker zzr = this.zzr;
                if (zzr != null) {
                    zzr.y0(new zzd(this, this.zzd.get()), getServiceRequest);
                }
                else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        }
        catch (final RuntimeException ex) {
            goto Label_0286;
        }
        catch (final RemoteException ex2) {}
        catch (final SecurityException ex3) {
            throw ex3;
        }
        catch (final DeadObjectException ex4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)ex4);
            this.triggerConnectionSuspended(3);
        }
    }
    
    @KeepForSdk
    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }
    
    @KeepForSdk
    public final T getService() throws DeadObjectException {
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                this.checkConnected();
                final IInterface zzs = this.zzs;
                Preconditions.l(zzs, "Client is connected but service is null");
                return (T)zzs;
            }
            throw new DeadObjectException();
        }
    }
    
    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            final IGmsServiceBroker zzr = this.zzr;
            if (zzr == null) {
                return null;
            }
            return ((IInterface)zzr).asBinder();
        }
    }
    
    @KeepForSdk
    protected abstract String getServiceDescriptor();
    
    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }
    
    @KeepForSdk
    protected abstract String getStartServiceAction();
    
    @KeepForSdk
    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }
    
    @KeepForSdk
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        final zzj zzD = this.zzD;
        if (zzD == null) {
            return null;
        }
        return zzD.d;
    }
    
    @KeepForSdk
    protected boolean getUseDynamicLookup() {
        return this.getMinApkVersion() >= 211700000;
    }
    
    @KeepForSdk
    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }
    
    @KeepForSdk
    public boolean isConnected() {
        synchronized (this.zzp) {
            return this.zzv == 4;
        }
    }
    
    @KeepForSdk
    public boolean isConnecting() {
        synchronized (this.zzp) {
            final int zzv = this.zzv;
            boolean b = true;
            if (zzv != 2) {
                b = (zzv == 3 && b);
            }
            return b;
        }
    }
    
    @KeepForSdk
    protected void onConnectedLocked(final T t) {
        this.zzh = System.currentTimeMillis();
    }
    
    @KeepForSdk
    protected void onConnectionFailed(final ConnectionResult connectionResult) {
        this.zzi = connectionResult.K1();
        this.zzj = System.currentTimeMillis();
    }
    
    @KeepForSdk
    protected void onConnectionSuspended(final int zzf) {
        this.zzf = zzf;
        this.zzg = System.currentTimeMillis();
    }
    
    @KeepForSdk
    protected void onPostInitHandler(final int n, final IBinder binder, final Bundle bundle, final int n2) {
        final Handler zzb = this.zzb;
        zzb.sendMessage(zzb.obtainMessage(1, n2, -1, (Object)new zzf(this, n, binder, bundle)));
    }
    
    @KeepForSdk
    public void onUserSignOut(final SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.a();
    }
    
    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }
    
    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }
    
    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }
    
    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }
    
    @KeepForSdk
    public void setAttributionTag(final String zzA) {
        this.zzA = zzA;
    }
    
    @KeepForSdk
    public void triggerConnectionSuspended(final int n) {
        final Handler zzb = this.zzb;
        zzb.sendMessage(zzb.obtainMessage(6, this.zzd.get(), n));
    }
    
    @KeepForSdk
    @VisibleForTesting
    protected void triggerNotAvailable(final ConnectionProgressReportCallbacks zzc, final int n, final PendingIntent pendingIntent) {
        Preconditions.l(zzc, "Connection progress callbacks cannot be null.");
        this.zzc = zzc;
        final Handler zzb = this.zzb;
        zzb.sendMessage(zzb.obtainMessage(3, this.zzd.get(), n, (Object)pendingIntent));
    }
    
    @KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }
    
    protected final String zze() {
        String s;
        if ((s = this.zzz) == null) {
            s = this.zzl.getClass().getName();
        }
        return s;
    }
    
    protected final void zzl(final int n, final Bundle bundle, final int n2) {
        final Handler zzb = this.zzb;
        zzb.sendMessage(zzb.obtainMessage(7, n2, -1, (Object)new zzg(this, n, null)));
    }
    
    @KeepForSdk
    public interface BaseConnectionCallbacks
    {
        @KeepForSdk
        void onConnected(final Bundle p0);
        
        @KeepForSdk
        void onConnectionSuspended(final int p0);
    }
    
    @KeepForSdk
    public interface BaseOnConnectionFailedListener
    {
        @KeepForSdk
        void onConnectionFailed(final ConnectionResult p0);
    }
    
    @KeepForSdk
    public interface ConnectionProgressReportCallbacks
    {
        @KeepForSdk
        void a(final ConnectionResult p0);
    }
    
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks
    {
        final BaseGmsClient a;
        
        @KeepForSdk
        public LegacyClientCallbackAdapter(final BaseGmsClient a) {
            this.a = a;
        }
        
        @Override
        public final void a(final ConnectionResult connectionResult) {
            if (connectionResult.O1()) {
                final BaseGmsClient a = this.a;
                a.getRemoteService(null, a.getScopes());
                return;
            }
            if (BaseGmsClient.zzc(this.a) != null) {
                BaseGmsClient.zzc(this.a).onConnectionFailed(connectionResult);
            }
        }
    }
    
    @KeepForSdk
    public interface SignOutCallbacks
    {
        @KeepForSdk
        void a();
    }
}
