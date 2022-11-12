// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzfpg;
import com.google.android.gms.common.internal.Preconditions;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbqn;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.internal.ads.zzbqf;
import java.util.HashMap;
import java.util.List;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.RequestConfiguration;
import javax.annotation.Nullable;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import java.util.ArrayList;
import javax.annotation.concurrent.GuardedBy;

public final class zzee
{
    @GuardedBy
    private static zzee i;
    private final ArrayList a;
    private final Object b;
    @GuardedBy
    private zzcm c;
    private boolean d;
    private boolean e;
    @Nullable
    private OnAdInspectorClosedListener f;
    private RequestConfiguration g;
    private InitializationStatus h;
    
    private zzee() {
        this.b = new Object();
        this.d = false;
        this.e = false;
        this.f = null;
        this.g = new RequestConfiguration.Builder().a();
        this.a = new ArrayList();
    }
    
    private static final InitializationStatus a(final List list) {
        final HashMap hashMap = new HashMap();
        for (final zzbqf zzbqf : list) {
            final String zza = zzbqf.zza;
            AdapterStatus.State state;
            if (zzbqf.zzb) {
                state = AdapterStatus.State.READY;
            }
            else {
                state = AdapterStatus.State.NOT_READY;
            }
            hashMap.put(zza, new zzbqn(state, zzbqf.zzd, zzbqf.zzc));
        }
        return (InitializationStatus)new zzbqo((Map)hashMap);
    }
    
    static /* bridge */ InitializationStatus d(final zzee zzee, final List list) {
        return a(list);
    }
    
    public static zzee f() {
        synchronized (zzee.class) {
            if (zzee.i == null) {
                zzee.i = new zzee();
            }
            return zzee.i;
        }
    }
    
    static /* bridge */ ArrayList h(final zzee zzee) {
        return zzee.a;
    }
    
    static /* bridge */ void i(final zzee zzee, final boolean b) {
        zzee.e = true;
    }
    
    static /* bridge */ void j(final zzee zzee, final boolean b) {
        zzee.d = false;
    }
    
    @GuardedBy
    private final void p(final Context context, @Nullable final String s, @Nullable final OnInitializationCompleteListener onInitializationCompleteListener) {
        try {
            zzbts.zza().zzb(context, (String)null);
            this.c.zzj();
            this.c.zzk(null, ObjectWrapper.q1((Object)null));
            if (!(boolean)zzay.c().zzb(zzbhy.zzeq) && !this.g().endsWith("0")) {
                zzcfi.zzg("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                this.h = new zzdw(this);
                if (onInitializationCompleteListener != null) {
                    zzcfb.zza.post((Runnable)new zzdv(this, onInitializationCompleteListener));
                }
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzk("MobileAdsSettingManager initialization failed", (Throwable)ex);
        }
    }
    
    @GuardedBy
    private final void q(final Context context) {
        if (this.c == null) {
            this.c = (zzcm)new j(zzaw.a(), context).d(context, false);
        }
    }
    
    @GuardedBy
    private final void r(final RequestConfiguration requestConfiguration) {
        try {
            this.c.zzs(new zzfa(requestConfiguration));
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("Unable to set request configuration parcel.", (Throwable)ex);
        }
    }
    
    public final float b() {
        synchronized (this.b) {
            final zzcm c = this.c;
            final float n = 1.0f;
            if (c == null) {
                return 1.0f;
            }
            float zze;
            try {
                zze = c.zze();
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to get app volume.", (Throwable)ex);
                zze = n;
            }
            return zze;
        }
    }
    
    public final RequestConfiguration c() {
        return this.g;
    }
    
    public final InitializationStatus e() {
        synchronized (this.b) {
            Preconditions.p(this.c != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                final InitializationStatus h = this.h;
                if (h != null) {
                    return h;
                }
                return a(this.c.zzg());
            }
            catch (final RemoteException ex) {
                zzcfi.zzg("Unable to get Initialization status.");
                return new zzdw(this);
            }
        }
    }
    
    @Deprecated
    public final String g() {
        synchronized (this.b) {
            Preconditions.p(this.c != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                return zzfpg.zzc(this.c.zzf());
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to get version string.", (Throwable)ex);
                return "";
            }
        }
    }
    
    public final void k(final Context context, @Nullable final String s, @Nullable final OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.b) {
            if (this.d) {
                if (onInitializationCompleteListener != null) {
                    f().a.add(onInitializationCompleteListener);
                }
                return;
            }
            if (this.e) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.a(this.e());
                }
                return;
            }
            this.d = true;
            if (onInitializationCompleteListener != null) {
                f().a.add(onInitializationCompleteListener);
            }
            if (context != null) {
                try {
                    this.q(context);
                    if (onInitializationCompleteListener != null) {
                        this.c.zzr((zzbqm)new p(this, null));
                    }
                    this.c.zzn((zzbtz)new zzbtw());
                    if (this.g.b() != -1 || this.g.c() != -1) {
                        this.r(this.g);
                    }
                }
                catch (final RemoteException ex) {
                    zzcfi.zzk("MobileAdsSettingManager initialization failed", (Throwable)ex);
                }
                zzbhy.zzc(context);
                if ((boolean)zzbjm.zza.zze() && (boolean)zzay.c().zzb(zzbhy.zzip)) {
                    zzcfi.zze("Initializing on bg thread");
                    zzcex.zza.execute(new zzdx(this, context, null, onInitializationCompleteListener));
                }
                else if ((boolean)zzbjm.zzb.zze() && (boolean)zzay.c().zzb(zzbhy.zzip)) {
                    zzcex.zzb.execute(new zzdy(this, context, null, onInitializationCompleteListener));
                }
                else {
                    zzcfi.zze("Initializing on calling thread");
                    this.p(context, null, onInitializationCompleteListener);
                }
                return;
            }
            throw new IllegalArgumentException("Context cannot be null.");
        }
    }
    
    final void l(final OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.a(this.h);
    }
    
    final void m(final Context context, final String s, final OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.b) {
            this.p(context, null, onInitializationCompleteListener);
        }
    }
    
    final void n(final Context context, final String s, final OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.b) {
            this.p(context, null, onInitializationCompleteListener);
        }
    }
    
    public final boolean o() {
        synchronized (this.b) {
            final zzcm c = this.c;
            final boolean b = false;
            if (c == null) {
                return false;
            }
            boolean zzt;
            try {
                zzt = c.zzt();
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Unable to get app mute state.", (Throwable)ex);
                zzt = b;
            }
            return zzt;
        }
    }
}
