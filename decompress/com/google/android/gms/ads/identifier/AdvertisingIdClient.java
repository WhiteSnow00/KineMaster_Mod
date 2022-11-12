// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.identifier;

import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import java.util.Map;
import java.util.HashMap;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.internal.ads_identifier.zze;
import java.util.concurrent.TimeUnit;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import android.content.ServiceConnection;
import com.google.android.gms.common.stats.ConnectionTracker;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import com.google.android.gms.internal.ads_identifier.zzf;
import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.annotation.KeepForSdk;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@KeepForSdk
public class AdvertisingIdClient
{
    @GuardedBy
    BlockingServiceConnection a;
    @GuardedBy
    zzf b;
    @GuardedBy
    boolean c;
    final Object d;
    @GuardedBy
    b e;
    @GuardedBy
    private final Context f;
    final long g;
    
    @KeepForSdk
    public AdvertisingIdClient(final Context context) {
        this(context, 30000L, false, false);
    }
    
    @VisibleForTesting
    public AdvertisingIdClient(final Context context, final long g, final boolean b, final boolean b2) {
        this.d = new Object();
        Preconditions.k(context);
        Context f = context;
        if (b) {
            final Context applicationContext = context.getApplicationContext();
            f = context;
            if (applicationContext != null) {
                f = applicationContext;
            }
        }
        this.f = f;
        this.c = false;
        this.g = g;
    }
    
    @KeepForSdk
    public static boolean b(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        context = (Context)new AdvertisingIdClient(context, -1L, false, false);
        try {
            ((AdvertisingIdClient)context).f(false);
            Preconditions.j("Calling this from your main thread can lead to deadlock");
            synchronized (context) {
                Label_0116: {
                    if (!((AdvertisingIdClient)context).c) {
                        final Object d = ((AdvertisingIdClient)context).d;
                        synchronized (d) {
                            final b e = ((AdvertisingIdClient)context).e;
                            if (e != null && e.d) {
                                monitorexit(d);
                                try {
                                    ((AdvertisingIdClient)context).f(false);
                                    if (((AdvertisingIdClient)context).c) {
                                        break Label_0116;
                                    }
                                    throw new IOException("AdvertisingIdClient cannot reconnect.");
                                }
                                catch (final Exception d) {
                                    throw new IOException("AdvertisingIdClient cannot reconnect.", (Throwable)d);
                                }
                            }
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                }
                Preconditions.k(((AdvertisingIdClient)context).a);
                Preconditions.k(((AdvertisingIdClient)context).b);
                try {
                    final boolean zzd = ((AdvertisingIdClient)context).b.zzd();
                    monitorexit(context);
                    ((AdvertisingIdClient)context).i();
                    return zzd;
                }
                catch (final RemoteException ex) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", (Throwable)ex);
                    throw new IOException("Remote exception");
                }
            }
        }
        finally {
            ((AdvertisingIdClient)context).e();
        }
    }
    
    @KeepForSdk
    @ShowFirstParty
    public static void c(final boolean b) {
    }
    
    @KeepForSdk
    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        context = (Context)new AdvertisingIdClient(context, -1L, true, false);
        try {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            ((AdvertisingIdClient)context).f(false);
            final Info h = ((AdvertisingIdClient)context).h(-1);
            ((AdvertisingIdClient)context).g(h, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", null);
            ((AdvertisingIdClient)context).e();
            return h;
        }
        finally {
            try {
                final Throwable t;
                ((AdvertisingIdClient)context).g(null, true, 0.0f, -1L, "", t);
            }
            finally {
                ((AdvertisingIdClient)context).e();
            }
        }
    }
    
    private final Info h(final int n) throws IOException {
        Preconditions.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            Label_0097: {
                if (!this.c) {
                    final Object d = this.d;
                    synchronized (d) {
                        final b e = this.e;
                        if (e != null && e.d) {
                            monitorexit(d);
                            try {
                                this.f(false);
                                if (this.c) {
                                    break Label_0097;
                                }
                                throw new IOException("AdvertisingIdClient cannot reconnect.");
                            }
                            catch (final Exception d) {
                                throw new IOException("AdvertisingIdClient cannot reconnect.", (Throwable)d);
                            }
                        }
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
            }
            Preconditions.k(this.a);
            Preconditions.k(this.b);
            try {
                final Info info = new Info(this.b.zzc(), this.b.zze(true));
                monitorexit(this);
                this.i();
                return info;
            }
            catch (final RemoteException ex) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", (Throwable)ex);
                throw new IOException("Remote exception");
            }
        }
    }
    
    private final void i() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.d:Ljava/lang/Object;
        //     4: astore_3       
        //     5: aload_3        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.e:Lcom/google/android/gms/ads/identifier/b;
        //    11: astore          4
        //    13: aload           4
        //    15: ifnull          33
        //    18: aload           4
        //    20: getfield        com/google/android/gms/ads/identifier/b.c:Ljava/util/concurrent/CountDownLatch;
        //    23: invokevirtual   java/util/concurrent/CountDownLatch.countDown:()V
        //    26: aload_0        
        //    27: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.e:Lcom/google/android/gms/ads/identifier/b;
        //    30: invokevirtual   java/lang/Thread.join:()V
        //    33: aload_0        
        //    34: getfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.g:J
        //    37: lstore_1       
        //    38: lload_1        
        //    39: lconst_0       
        //    40: lcmp           
        //    41: ifle            62
        //    44: new             Lcom/google/android/gms/ads/identifier/b;
        //    47: astore          4
        //    49: aload           4
        //    51: aload_0        
        //    52: lload_1        
        //    53: invokespecial   com/google/android/gms/ads/identifier/b.<init>:(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;J)V
        //    56: aload_0        
        //    57: aload           4
        //    59: putfield        com/google/android/gms/ads/identifier/AdvertisingIdClient.e:Lcom/google/android/gms/ads/identifier/b;
        //    62: aload_3        
        //    63: monitorexit    
        //    64: return         
        //    65: astore          4
        //    67: aload_3        
        //    68: monitorexit    
        //    69: aload           4
        //    71: athrow         
        //    72: astore          4
        //    74: goto            33
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  7      13     65     72     Any
        //  18     26     65     72     Any
        //  26     33     72     77     Ljava/lang/InterruptedException;
        //  26     33     65     72     Any
        //  33     38     65     72     Any
        //  44     62     65     72     Any
        //  62     64     65     72     Any
        //  67     69     65     72     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0033:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @KeepForSdk
    public Info a() throws IOException {
        return this.h(-1);
    }
    
    @KeepForSdk
    public void d() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        this.f(true);
    }
    
    public final void e() {
        Preconditions.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f != null && this.a != null) {
                try {
                    if (this.c) {
                        ConnectionTracker.b().c(this.f, (ServiceConnection)this.a);
                    }
                }
                finally {
                    final Throwable t;
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", t);
                }
                this.c = false;
                this.b = null;
                this.a = null;
            }
        }
    }
    
    @VisibleForTesting
    protected final void f(final boolean b) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Preconditions.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.c) {
                this.e();
            }
            final Context f = this.f;
            try {
                f.getPackageManager().getPackageInfo("com.android.vending", 0);
                final int j = GoogleApiAvailabilityLight.h().j(f, 12451000);
                if (j != 0 && j != 2) {
                    throw new IOException("Google Play services not available");
                }
                final BlockingServiceConnection a = new BlockingServiceConnection();
                final Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (ConnectionTracker.b().a(f, intent, (ServiceConnection)a, 1)) {
                        this.a = a;
                        try {
                            this.b = zze.zza(a.b(10000L, TimeUnit.MILLISECONDS));
                            this.c = true;
                            if (b) {
                                this.i();
                            }
                            return;
                        }
                        catch (final InterruptedException ex) {
                            final IOException ex2 = new IOException("Interrupted exception");
                        }
                    }
                    throw new IOException("Connection failure");
                }
                finally {
                    final Throwable t;
                    throw new IOException(t);
                }
            }
            catch (final PackageManager$NameNotFoundException ex3) {
                throw new GooglePlayServicesNotAvailableException(9);
            }
        }
    }
    
    @Override
    protected final void finalize() throws Throwable {
        this.e();
        super.finalize();
    }
    
    @VisibleForTesting
    final boolean g(final Info info, final boolean b, final float n, final long n2, String s, final Throwable t) {
        if (Math.random() <= 0.0) {
            final HashMap hashMap = new HashMap();
            s = "1";
            hashMap.put("app_context", "1");
            if (info != null) {
                if (!info.isLimitAdTrackingEnabled()) {
                    s = "0";
                }
                hashMap.put("limit_ad_tracking", s);
                final String id = info.getId();
                if (id != null) {
                    hashMap.put("ad_id_size", Integer.toString(id.length()));
                }
            }
            if (t != null) {
                hashMap.put("error", t.getClass().getName());
            }
            hashMap.put("tag", "AdvertisingIdClient");
            hashMap.put("time_spent", Long.toString(n2));
            new a(this, hashMap).start();
            return true;
        }
        return false;
    }
    
    @KeepForSdkWithMembers
    public static final class Info
    {
        private final String a;
        private final boolean b;
        
        @Deprecated
        public Info(final String a, final boolean b) {
            this.a = a;
            this.b = b;
        }
        
        public String getId() {
            return this.a;
        }
        
        public boolean isLimitAdTrackingEnabled() {
            return this.b;
        }
        
        @Override
        public String toString() {
            final String a = this.a;
            final boolean b = this.b;
            final StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 7);
            sb.append("{");
            sb.append(a);
            sb.append("}");
            sb.append(b);
            return sb.toString();
        }
    }
}
