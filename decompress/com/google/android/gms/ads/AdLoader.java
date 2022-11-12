// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzfg;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzbxg;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.client.zzep;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.ads.internal.client.zzbo;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzcex;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzbl;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzp;

public class AdLoader
{
    private final zzp a;
    private final Context b;
    private final zzbl c;
    
    AdLoader(final Context b, final zzbl c, final zzp a) {
        this.b = b;
        this.c = c;
        this.a = a;
    }
    
    private final void c(final zzdr zzdr) {
        zzbhy.zzc(this.b);
        if (zzbjm.zzc.zze()) {
            if (zzay.c().zzb(zzbhy.zziq)) {
                zzcex.zzb.execute(new zza(this, zzdr));
                return;
            }
        }
        try {
            this.c.zzg(this.a.a(this.b, zzdr));
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("Failed to load ad.", (Throwable)ex);
        }
    }
    
    public void a(final AdRequest adRequest) {
        this.c(adRequest.a());
    }
    
    final void b(final zzdr zzdr) {
        try {
            this.c.zzg(this.a.a(this.b, zzdr));
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("Failed to load ad.", (Throwable)ex);
        }
    }
    
    public static class Builder
    {
        private final Context a;
        private final zzbo b;
        
        public Builder(final Context context, final String s) {
            final Context a = Preconditions.l(context, "context cannot be null");
            final zzbo c = zzaw.a().c(context, s, (zzbtz)new zzbtw());
            this.a = a;
            this.b = c;
        }
        
        public AdLoader a() {
            try {
                return new AdLoader(this.a, this.b.zze(), zzp.a);
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Failed to build AdLoader.", (Throwable)ex);
                return new AdLoader(this.a, new zzep().p1(), zzp.a);
            }
        }
        
        @Deprecated
        public Builder b(final String s, final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, final NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            final zzbnf zzbnf = new zzbnf(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.b.zzh(s, zzbnf.zze(), zzbnf.zzd());
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Failed to add custom template ad listener", (Throwable)ex);
            }
            return this;
        }
        
        public Builder c(final NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.b.zzk((zzbmo)new zzbxg(onNativeAdLoadedListener));
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Failed to add google native ad listener", (Throwable)ex);
            }
            return this;
        }
        
        @Deprecated
        public Builder d(final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.b.zzk((zzbmo)new zzbni(onUnifiedNativeAdLoadedListener));
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Failed to add google native ad listener", (Throwable)ex);
            }
            return this;
        }
        
        public Builder e(final AdListener adListener) {
            try {
                this.b.zzl(new zzg(adListener));
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Failed to set AdListener.", (Throwable)ex);
            }
            return this;
        }
        
        @Deprecated
        public Builder f(final NativeAdOptions nativeAdOptions) {
            try {
                this.b.zzo(new zzbko(nativeAdOptions));
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Failed to specify native ad options", (Throwable)ex);
            }
            return this;
        }
        
        public Builder g(final com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                final zzbo b = this.b;
                final boolean e = nativeAdOptions.e();
                final boolean d = nativeAdOptions.d();
                final int a = nativeAdOptions.a();
                zzfg zzfg;
                if (nativeAdOptions.c() != null) {
                    zzfg = new zzfg(nativeAdOptions.c());
                }
                else {
                    zzfg = null;
                }
                b.zzo(new zzbko(4, e, -1, d, a, zzfg, nativeAdOptions.f(), nativeAdOptions.b()));
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Failed to specify native ad options", (Throwable)ex);
            }
            return this;
        }
    }
}
