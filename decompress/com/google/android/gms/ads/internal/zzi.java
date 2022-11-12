// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.util.zzs;
import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzflv;
import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzflu;
import com.google.android.gms.internal.ads.zzanv;
import com.google.android.gms.internal.ads.zzaob;
import java.util.Iterator;
import android.view.MotionEvent;
import java.util.concurrent.ExecutorService;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.concurrent.Executors;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import com.google.android.gms.internal.ads.zzcfo;
import android.content.Context;
import com.google.android.gms.internal.ads.zzfks;
import java.util.concurrent.Executor;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import com.google.android.gms.internal.ads.zzany;

public final class zzi implements Runnable, zzany
{
    private final List a;
    private final AtomicReference b;
    private final AtomicReference c;
    @VisibleForTesting
    protected boolean d;
    private final boolean e;
    private final boolean f;
    private final Executor g;
    private final zzfks h;
    private Context i;
    private final Context j;
    private zzcfo p;
    private final zzcfo w;
    private final boolean x;
    final CountDownLatch y;
    private int z;
    
    public zzi(final Context context, final zzcfo zzcfo) {
        this.a = new Vector();
        this.b = new AtomicReference();
        this.c = new AtomicReference();
        this.y = new CountDownLatch(1);
        this.i = context;
        this.j = context;
        this.p = zzcfo;
        this.w = zzcfo;
        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        this.g = cachedThreadPool;
        final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzbT);
        this.x = booleanValue;
        this.h = zzfks.zza(context, (Executor)cachedThreadPool, booleanValue);
        this.e = (boolean)zzay.c().zzb(zzbhy.zzbP);
        this.f = (boolean)zzay.c().zzb(zzbhy.zzbU);
        if (zzay.c().zzb(zzbhy.zzbS)) {
            this.z = 2;
        }
        else {
            this.z = 1;
        }
        if (!(boolean)zzay.c().zzb(zzbhy.zzcB)) {
            this.d = this.c();
        }
        if (zzay.c().zzb(zzbhy.zzcv)) {
            ((Executor)zzcfv.zza).execute(this);
            return;
        }
        zzaw.b();
        if (zzcfb.zzs()) {
            ((Executor)zzcfv.zza).execute(this);
            return;
        }
        this.run();
    }
    
    static /* bridge */ zzfks a(final zzi zzi) {
        return zzi.h;
    }
    
    private final zzany f() {
        if (this.e() == 2) {
            return this.c.get();
        }
        return this.b.get();
    }
    
    private final void g() {
        final zzany f = this.f();
        if (!this.a.isEmpty()) {
            if (f != null) {
                for (final Object[] array : this.a) {
                    final int length = array.length;
                    if (length == 1) {
                        f.zzk((MotionEvent)array[0]);
                    }
                    else {
                        if (length != 3) {
                            continue;
                        }
                        f.zzl((int)array[0], (int)array[1], (int)array[2]);
                    }
                }
                this.a.clear();
            }
        }
    }
    
    private final void h(final boolean b) {
        this.b.set(zzaob.zzt(this.p.zza, i(this.i), b, this.z));
    }
    
    private static final Context i(final Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        return applicationContext;
    }
    
    final void b(final boolean b) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            zzanv.zza(this.w.zza, i(this.j), b, this.x).zzo();
        }
        catch (final NullPointerException ex) {
            this.h.zzc(2027, System.currentTimeMillis() - currentTimeMillis, (Exception)ex);
        }
    }
    
    protected final boolean c() {
        return new zzfmo(this.i, zzflu.zzb(this.i, this.h), (zzflv)new a(this), (boolean)zzay.c().zzb(zzbhy.zzbQ)).zzd(1);
    }
    
    public final boolean d() {
        try {
            this.y.await();
            return true;
        }
        catch (final InterruptedException ex) {
            zzcfi.zzk("Interrupted during GADSignals creation.", (Throwable)ex);
            return false;
        }
    }
    
    protected final int e() {
        if (this.e && !this.d) {
            return 1;
        }
        return this.z;
    }
    
    @Override
    public final void run() {
        try {
            if (zzay.c().zzb(zzbhy.zzcB)) {
                this.d = this.c();
            }
            final boolean zzd = this.p.zzd;
            final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzaQ);
            boolean b2;
            final boolean b = b2 = false;
            if (!booleanValue) {
                b2 = b;
                if (zzd) {
                    b2 = true;
                }
            }
            if (this.e() == 1) {
                this.h(b2);
                if (this.z == 2) {
                    this.g.execute(new zzg(this, b2));
                }
            }
            else {
                final long currentTimeMillis = System.currentTimeMillis();
                try {
                    final zzanv zza = zzanv.zza(this.p.zza, i(this.i), b2, this.x);
                    this.c.set(zza);
                    if (this.f && !zza.zzq()) {
                        this.z = 1;
                        this.h(b2);
                    }
                }
                catch (final NullPointerException ex) {
                    this.z = 1;
                    this.h(b2);
                    this.h.zzc(2031, System.currentTimeMillis() - currentTimeMillis, (Exception)ex);
                }
            }
        }
        finally {
            this.y.countDown();
            this.i = null;
            this.p = null;
        }
    }
    
    public final String zze(final Context context, final String s, final View view) {
        return this.zzf(context, s, view, null);
    }
    
    public final String zzf(final Context context, final String s, final View view, final Activity activity) {
        if (this.d()) {
            final zzany f = this.f();
            if (zzay.c().zzb(zzbhy.zzia)) {
                zzt.q();
                zzs.f(view, 4, null);
            }
            if (f != null) {
                this.g();
                return f.zzf(i(context), s, view, activity);
            }
        }
        return "";
    }
    
    public final String zzg(final Context context) {
        if (this.d()) {
            final zzany f = this.f();
            if (f != null) {
                this.g();
                return f.zzg(i(context));
            }
        }
        return "";
    }
    
    public final String zzh(final Context context, final View view, final Activity activity) {
        if (zzay.c().zzb(zzbhy.zzhZ)) {
            if (this.d()) {
                final zzany f = this.f();
                if (zzay.c().zzb(zzbhy.zzia)) {
                    zzt.q();
                    zzs.f(view, 2, null);
                }
                if (f != null) {
                    return f.zzh(context, view, activity);
                }
            }
        }
        else {
            final zzany f2 = this.f();
            if (zzay.c().zzb(zzbhy.zzia)) {
                zzt.q();
                zzs.f(view, 2, null);
            }
            if (f2 != null) {
                return f2.zzh(context, view, activity);
            }
        }
        return "";
    }
    
    public final void zzk(final MotionEvent motionEvent) {
        final zzany f = this.f();
        if (f != null) {
            this.g();
            f.zzk(motionEvent);
            return;
        }
        this.a.add(new Object[] { motionEvent });
    }
    
    public final void zzl(final int n, final int n2, final int n3) {
        final zzany f = this.f();
        if (f != null) {
            this.g();
            f.zzl(n, n2, n3);
            return;
        }
        this.a.add(new Object[] { n, n2, n3 });
    }
    
    public final void zzn(final View view) {
        final zzany f = this.f();
        if (f != null) {
            f.zzn(view);
        }
    }
}
