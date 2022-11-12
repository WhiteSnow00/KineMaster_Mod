// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzbxt;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import android.app.Activity;
import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzexs;
import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzdoa;
import java.util.HashMap;
import android.view.View;
import com.google.android.gms.internal.ads.zzblk;
import com.google.android.gms.internal.ads.zzezl;
import com.google.android.gms.internal.ads.zzewf;
import com.google.android.gms.internal.ads.zzewe;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzelg;
import com.google.android.gms.ads.internal.client.zzbo;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.ads.zzfaz;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzdoc;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzdxo;
import com.google.android.gms.internal.ads.zzcnf;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbpj;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.ads.internal.client.zzcb;

public class ClientApi extends zzcb
{
    @KeepForSdk
    public ClientApi() {
    }
    
    public final zzbpj I0(final IObjectWrapper objectWrapper, final zzbtz zzbtz, final int n, final zzbpg zzbpg) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        final zzdxo zzj = zzcnf.zza(context, zzbtz, n).zzj();
        zzj.zzb(context);
        zzj.zza(zzbpg);
        return (zzbpj)zzj.zzc().zzd();
    }
    
    public final zzble P(final IObjectWrapper objectWrapper, final IObjectWrapper objectWrapper2) {
        return (zzble)new zzdoc((FrameLayout)ObjectWrapper.p1(objectWrapper), (FrameLayout)ObjectWrapper.p1(objectWrapper2), 221310000);
    }
    
    public final zzcbd Q0(final IObjectWrapper objectWrapper, final String s, final zzbtz zzbtz, final int n) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        final zzfaz zzu = zzcnf.zza(context, zzbtz, n).zzu();
        zzu.zzb(context);
        zzu.zza(s);
        return (zzcbd)zzu.zzc().zza();
    }
    
    public final zzbs S0(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final int n) {
        return new zzs(ObjectWrapper.p1(objectWrapper), zzq, s, new zzcfo(221310000, n, true, false));
    }
    
    public final zzbxk V(final IObjectWrapper objectWrapper, final zzbtz zzbtz, final int n) {
        return (zzbxk)zzcnf.zza((Context)ObjectWrapper.p1(objectWrapper), zzbtz, n).zzl();
    }
    
    public final zzbo c0(final IObjectWrapper objectWrapper, final String s, final zzbtz zzbtz, final int n) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        return (zzbo)new zzelg(zzcnf.zza(context, zzbtz, n), context, s);
    }
    
    public final zzbs f(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final zzbtz zzbtz, final int n) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        final zzewe zzr = zzcnf.zza(context, zzbtz, n).zzr();
        zzr.zza(s);
        zzr.zzb(context);
        final zzewf zzc = zzr.zzc();
        if (n >= (int)zzay.c().zzb(zzbhy.zzej)) {
            return (zzbs)zzc.zzb();
        }
        return (zzbs)zzc.zza();
    }
    
    public final zzbs f1(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final zzbtz zzbtz, final int n) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        final zzezl zzt = zzcnf.zza(context, zzbtz, n).zzt();
        zzt.zzc(context);
        zzt.zza(zzq);
        zzt.zzb(s);
        return (zzbs)zzt.zzd().zza();
    }
    
    public final zzblk n1(final IObjectWrapper objectWrapper, final IObjectWrapper objectWrapper2, final IObjectWrapper objectWrapper3) {
        return (zzblk)new zzdoa((View)ObjectWrapper.p1(objectWrapper), (HashMap)ObjectWrapper.p1(objectWrapper2), (HashMap)ObjectWrapper.p1(objectWrapper3));
    }
    
    public final zzcdz o(final IObjectWrapper objectWrapper, final zzbtz zzbtz, final int n) {
        return (zzcdz)zzcnf.zza((Context)ObjectWrapper.p1(objectWrapper), zzbtz, n).zzo();
    }
    
    public final zzbs p(final IObjectWrapper objectWrapper, final zzq zzq, final String s, final zzbtz zzbtz, final int n) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        final zzexs zzs = zzcnf.zza(context, zzbtz, n).zzs();
        zzs.zzc(context);
        zzs.zza(zzq);
        zzs.zzb(s);
        return (zzbs)zzs.zzd().zza();
    }
    
    public final zzcan z(final IObjectWrapper objectWrapper, final zzbtz zzbtz, final int n) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        final zzfaz zzu = zzcnf.zza(context, zzbtz, n).zzu();
        zzu.zzb(context);
        return (zzcan)zzu.zzc().zzb();
    }
    
    public final zzcm zzg(final IObjectWrapper objectWrapper, final int n) {
        return (zzcm)zzcnf.zza((Context)ObjectWrapper.p1(objectWrapper), (zzbtz)null, n).zzb();
    }
    
    public final zzbxu zzl(final IObjectWrapper objectWrapper) {
        final Activity activity = ObjectWrapper.p1(objectWrapper);
        final AdOverlayInfoParcel k1 = AdOverlayInfoParcel.K1(activity.getIntent());
        zzbxt zzbxt;
        if (k1 == null) {
            zzbxt = new zzt(activity);
        }
        else {
            final int p = k1.p;
            if (p != 1) {
                if (p != 2) {
                    if (p != 3) {
                        if (p != 4) {
                            if (p != 5) {
                                zzbxt = new zzt(activity);
                            }
                            else {
                                zzbxt = new zzz(activity);
                            }
                        }
                        else {
                            zzbxt = new zzv(activity, k1);
                        }
                    }
                    else {
                        zzbxt = new zzac(activity);
                    }
                }
                else {
                    zzbxt = new zzab(activity);
                }
            }
            else {
                zzbxt = new com.google.android.gms.ads.internal.overlay.zzs(activity);
            }
        }
        return (zzbxu)zzbxt;
    }
}
