// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzcbd;
import android.content.Intent;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzbxu;
import android.app.Activity;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbpj;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzble;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.zzbtz;
import android.os.Bundle;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzbna;
import com.google.android.gms.internal.ads.zzbxr;
import com.google.android.gms.internal.ads.zzcbp;
import com.google.android.gms.internal.ads.zzbmz;

public final class zzau
{
    private final zzk a;
    private final zzi b;
    private final zzel c;
    private final zzbmz d;
    private final zzcbp e;
    private final zzbxr f;
    private final zzbna g;
    private zzbyz h;
    
    public zzau(final zzk a, final zzi b, final zzel c, final zzbmz d, final zzcbp e, final zzbxr f, final zzbna g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    static /* bridge */ zzi a(final zzau zzau) {
        return zzau.b;
    }
    
    static /* bridge */ zzk b(final zzau zzau) {
        return zzau.a;
    }
    
    static /* bridge */ zzel f(final zzau zzau) {
        return zzau.c;
    }
    
    static /* bridge */ zzbmz h(final zzau zzau) {
        return zzau.d;
    }
    
    static /* bridge */ zzbxr k(final zzau zzau) {
        return zzau.f;
    }
    
    static /* bridge */ zzbyz m(final zzau zzau) {
        return zzau.h;
    }
    
    static /* bridge */ void p(final zzau zzau, final zzbyz h) {
        zzau.h = h;
    }
    
    static /* bridge */ void q(final Context context, final String s) {
        final Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", s);
        zzaw.b().zzl(context, zzaw.c().zza, "gmob-apps", bundle, true);
    }
    
    public final zzbo c(final Context context, final String s, final zzbtz zzbtz) {
        return (zzbo)new i(this, context, s, zzbtz).d(context, false);
    }
    
    public final zzbs d(final Context context, final zzq zzq, final String s, final zzbtz zzbtz) {
        return (zzbs)new f(this, context, zzq, s, zzbtz).d(context, false);
    }
    
    public final zzbs e(final Context context, final zzq zzq, final String s, final zzbtz zzbtz) {
        return (zzbs)new h(this, context, zzq, s, zzbtz).d(context, false);
    }
    
    public final zzble g(final Context context, final FrameLayout frameLayout, final FrameLayout frameLayout2) {
        return (zzble)new k(this, frameLayout, frameLayout2, context).d(context, false);
    }
    
    public final zzbpj i(final Context context, final zzbtz zzbtz, final OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbpj)new d(this, context, zzbtz, onH5AdsEventListener).d(context, false);
    }
    
    public final zzbxk j(final Context context, final zzbtz zzbtz) {
        return (zzbxk)new c(this, context, zzbtz).d(context, false);
    }
    
    public final zzbxu l(final Activity activity) {
        final a a = new a(this, activity);
        final Intent intent = activity.getIntent();
        final boolean hasExtra = intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar");
        boolean booleanExtra = false;
        if (!hasExtra) {
            zzcfi.zzg("useClientJar flag not found in activity intent extras.");
        }
        else {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbxu)a.d((Context)activity, booleanExtra);
    }
    
    public final zzcbd n(final Context context, final String s, final zzbtz zzbtz) {
        return (zzcbd)new l(this, context, s, zzbtz).d(context, false);
    }
    
    public final zzcdz o(final Context context, final zzbtz zzbtz) {
        return (zzcdz)new b(this, context, zzbtz).d(context, false);
    }
}
