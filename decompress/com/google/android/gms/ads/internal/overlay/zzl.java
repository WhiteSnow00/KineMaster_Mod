// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.ads.zzbrc;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzdcf;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Intent;
import java.util.Map;
import java.util.Collections;
import com.google.android.gms.internal.ads.zzfnu;
import com.google.android.gms.ads.internal.util.zzs;
import android.os.Build$VERSION;
import com.google.android.gms.internal.ads.zzbwu;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzbnn;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcmv;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.internal.ads.zzeev;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzcmt;
import com.google.android.gms.internal.ads.zzdjf;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzfgo;
import com.google.android.gms.internal.ads.zzdwg;
import com.google.android.gms.internal.ads.zzfig;
import com.google.android.gms.internal.ads.zzeen;
import com.google.android.gms.internal.ads.zzccj;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzboo;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.internal.ads.zzfbj;
import com.google.android.gms.internal.ads.zzfbg;
import com.google.android.gms.internal.ads.zzbin;
import com.google.android.gms.internal.ads.zzbix;
import com.google.android.gms.internal.ads.zzaoc;
import com.google.android.gms.internal.ads.zzclu;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzcfi;
import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import android.content.res.Configuration;
import android.graphics.Color;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.zzcli;
import android.app.Activity;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbxt;

public class zzl extends zzbxt implements zzaa
{
    @VisibleForTesting
    static final int F;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    @VisibleForTesting
    int E;
    protected final Activity a;
    @VisibleForTesting
    AdOverlayInfoParcel b;
    @VisibleForTesting
    zzcli c;
    @VisibleForTesting
    zzh d;
    @VisibleForTesting
    zzr e;
    @VisibleForTesting
    boolean f;
    @VisibleForTesting
    FrameLayout g;
    @VisibleForTesting
    WebChromeClient$CustomViewCallback h;
    @VisibleForTesting
    boolean i;
    @VisibleForTesting
    boolean j;
    @VisibleForTesting
    a p;
    @VisibleForTesting
    boolean w;
    private final Object x;
    private Runnable y;
    private boolean z;
    
    static {
        F = Color.argb(0, 0, 0, 0);
    }
    
    public zzl(final Activity a) {
        this.f = false;
        this.i = false;
        this.j = false;
        this.w = false;
        this.E = 1;
        this.x = new Object();
        this.B = false;
        this.C = false;
        this.D = true;
        this.a = a;
    }
    
    private final void q1(final Configuration configuration) {
        final AdOverlayInfoParcel b = this.b;
        final int n = 1;
        final int n2 = 0;
        boolean b2 = false;
        Label_0044: {
            if (b != null) {
                final zzj z = b.z;
                if (z != null && z.b) {
                    b2 = true;
                    break Label_0044;
                }
            }
            b2 = false;
        }
        final boolean e = zzt.r().e(this.a, configuration);
        int n3;
        int n4;
        if ((!this.j || b2) && !e) {
            final AdOverlayInfoParcel b3 = this.b;
            n3 = n;
            n4 = n2;
            if (b3 != null) {
                final zzj z2 = b3.z;
                n3 = n;
                n4 = n2;
                if (z2 != null) {
                    n3 = n;
                    n4 = n2;
                    if (z2.g) {
                        n4 = 1;
                        n3 = n;
                    }
                }
            }
        }
        else {
            n3 = 0;
            n4 = n2;
        }
        final Window window = this.a.getWindow();
        if (zzay.c().zzb(zzbhy.zzaY)) {
            final View decorView = window.getDecorView();
            int systemUiVisibility;
            if (n3 != 0) {
                if (n4 != 0) {
                    systemUiVisibility = 5894;
                }
                else {
                    systemUiVisibility = 5380;
                }
            }
            else {
                systemUiVisibility = 256;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
            return;
        }
        if (n3 != 0) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (n4 != 0) {
                window.getDecorView().setSystemUiVisibility(4098);
            }
            return;
        }
        window.addFlags(2048);
        window.clearFlags(1024);
    }
    
    private static final void r1(final IObjectWrapper objectWrapper, final View view) {
        if (objectWrapper != null && view != null) {
            zzt.i().zzc(objectWrapper, view);
        }
    }
    
    public final void M0(final View view, final WebChromeClient$CustomViewCallback h) {
        (this.g = new FrameLayout((Context)this.a)).setBackgroundColor(-16777216);
        this.g.addView(view, -1, -1);
        this.a.setContentView((View)this.g);
        this.A = true;
        this.h = h;
        this.f = true;
    }
    
    protected final void p1(final boolean b) throws zzf {
        if (!this.A) {
            this.a.requestWindowFeature(1);
        }
        final Window window = this.a.getWindow();
        if (window == null) {
            throw new zzf("Invalid activity, no window available.");
        }
        final zzcli d = this.b.d;
        final zzb zzb = null;
        zzcmv zzP;
        if (d != null) {
            zzP = d.zzP();
        }
        else {
            zzP = null;
        }
        final boolean b2 = false;
        final boolean b3 = false;
        final boolean b4 = false;
        final boolean b5 = zzP != null && zzP.zzJ();
        this.w = false;
        boolean b6 = b3;
        if (b5) {
            final int j = this.b.j;
            if (j == 6) {
                b6 = b4;
                if (this.a.getResources().getConfiguration().orientation == 1) {
                    b6 = true;
                }
                this.w = b6;
            }
            else {
                b6 = b3;
                if (j == 7) {
                    b6 = b2;
                    if (this.a.getResources().getConfiguration().orientation == 2) {
                        b6 = true;
                    }
                    this.w = b6;
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Delay onShow to next orientation change: ");
        sb.append(b6);
        zzcfi.zze(sb.toString());
        this.u1(this.b.j);
        window.setFlags(16777216, 16777216);
        zzcfi.zze("Hardware acceleration on the AdActivity window enabled.");
        if (!this.j) {
            this.p.setBackgroundColor(-16777216);
        }
        else {
            this.p.setBackgroundColor(zzl.F);
        }
        this.a.setContentView((View)this.p);
        this.A = true;
        Label_0701: {
            if (b) {
                try {
                    zzt.A();
                    final Activity a = this.a;
                    final zzcli d2 = this.b.d;
                    zzcmx zzQ;
                    if (d2 != null) {
                        zzQ = d2.zzQ();
                    }
                    else {
                        zzQ = null;
                    }
                    final zzcli d3 = this.b.d;
                    String zzU;
                    if (d3 != null) {
                        zzU = d3.zzU();
                    }
                    else {
                        zzU = null;
                    }
                    final AdOverlayInfoParcel b7 = this.b;
                    final zzcfo x = b7.x;
                    final zzcli d4 = b7.d;
                    com.google.android.gms.ads.internal.zza zzm;
                    if (d4 != null) {
                        zzm = d4.zzm();
                    }
                    else {
                        zzm = null;
                    }
                    final zzcli zza = zzclu.zza((Context)a, zzQ, zzU, true, b5, (zzaoc)null, (zzbix)null, x, (zzbin)null, (com.google.android.gms.ads.internal.zzl)null, zzm, zzbdl.zza(), (zzfbg)null, (zzfbj)null);
                    this.c = zza;
                    final zzcmv zzP2 = zza.zzP();
                    final AdOverlayInfoParcel b8 = this.b;
                    final zzbnl a2 = b8.A;
                    final zzbnn e = b8.e;
                    final zzw i = b8.i;
                    final zzcli d5 = b8.d;
                    zzb zzd = zzb;
                    if (d5 != null) {
                        zzd = d5.zzP().zzd();
                    }
                    zzP2.zzL((zza)null, a2, (zzo)null, e, i, true, (zzboo)null, zzd, (zzbwv)null, (zzccj)null, (zzeen)null, (zzfig)null, (zzdwg)null, (zzfgo)null, (zzbom)null, (zzdjf)null);
                    this.c.zzP().zzz((zzcmt)new zzd(this));
                    final AdOverlayInfoParcel b9 = this.b;
                    final String w = b9.w;
                    if (w != null) {
                        this.c.loadUrl(w);
                    }
                    else {
                        final String h = b9.h;
                        if (h == null) {
                            throw new zzf("No URL or HTML to display in ad overlay.");
                        }
                        this.c.loadDataWithBaseURL(b9.f, h, "text/html", "UTF-8", (String)null);
                    }
                    final zzcli d6 = this.b.d;
                    if (d6 != null) {
                        d6.zzat(this);
                    }
                    break Label_0701;
                }
                catch (final Exception ex) {
                    zzcfi.zzh("Error obtaining webview.", (Throwable)ex);
                    throw new zzf("Could not obtain webview for the overlay.");
                }
            }
            (this.c = this.b.d).zzam((Context)this.a);
        }
        this.c.zzah(this);
        final zzcli d7 = this.b.d;
        if (d7 != null) {
            r1(d7.zzS(), (View)this.p);
        }
        if (this.b.p != 5) {
            final ViewParent parent = this.c.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(this.c.zzH());
            }
            if (this.j) {
                this.c.zzal();
            }
            this.p.addView(this.c.zzH(), -1, -1);
        }
        if (!b && !this.w) {
            this.zze();
        }
        final AdOverlayInfoParcel b10 = this.b;
        if (b10.p != 5) {
            this.s1(b5);
            if (this.c.zzay()) {
                this.t1(b5, true);
            }
            return;
        }
        zzeev.zzh(this.a, this, b10.F, b10.C, b10.D, b10.E, b10.B, b10.G);
    }
    
    public final void s1(final boolean b) {
        final int intValue = (int)zzay.c().zzb(zzbhy.zzdT);
        final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzaU);
        final int n = 0;
        final boolean b2 = booleanValue || b;
        final zzq zzq = new zzq();
        zzq.d = 50;
        int a;
        if (!b2) {
            a = 0;
        }
        else {
            a = intValue;
        }
        zzq.a = a;
        int b3 = n;
        if (!b2) {
            b3 = intValue;
        }
        zzq.b = b3;
        zzq.c = intValue;
        this.e = new zzr((Context)this.a, zzq, this);
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-2, -2);
        relativeLayout$LayoutParams.addRule(10);
        int n2;
        if (!b2) {
            n2 = 9;
        }
        else {
            n2 = 11;
        }
        relativeLayout$LayoutParams.addRule(n2);
        this.t1(b, this.b.g);
        this.p.addView((View)this.e, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
    }
    
    public final void t1(final boolean b, final boolean b2) {
        final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzaS);
        final boolean b3 = true;
        boolean b5 = false;
        Label_0067: {
            if (booleanValue) {
                final AdOverlayInfoParcel b4 = this.b;
                if (b4 != null) {
                    final zzj z = b4.z;
                    if (z != null && z.h) {
                        b5 = true;
                        break Label_0067;
                    }
                }
            }
            b5 = false;
        }
        boolean b7 = false;
        Label_0129: {
            if (zzay.c().zzb(zzbhy.zzaT)) {
                final AdOverlayInfoParcel b6 = this.b;
                if (b6 != null) {
                    final zzj z2 = b6.z;
                    if (z2 != null && z2.i) {
                        b7 = true;
                        break Label_0129;
                    }
                }
            }
            b7 = false;
        }
        if (b && b2 && b5 && !b7) {
            new zzbwu(this.c, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        final zzr e = this.e;
        if (e != null) {
            boolean b8 = b3;
            if (!b7) {
                b8 = (b2 && !b5 && b3);
            }
            e.b(b8);
        }
    }
    
    public final void u1(final int requestedOrientation) {
        if (this.a.getApplicationInfo().targetSdkVersion >= (int)zzay.c().zzb(zzbhy.zzeU) && this.a.getApplicationInfo().targetSdkVersion <= (int)zzay.c().zzb(zzbhy.zzeV)) {
            final int sdk_INT = Build$VERSION.SDK_INT;
            if (sdk_INT >= (int)zzay.c().zzb(zzbhy.zzeW)) {
                if (sdk_INT <= (int)zzay.c().zzb(zzbhy.zzeX)) {
                    return;
                }
            }
        }
        try {
            this.a.setRequestedOrientation(requestedOrientation);
        }
        finally {
            final Throwable t;
            zzt.p().zzs(t, "AdOverlay.setRequestedOrientation");
        }
    }
    
    public final void v1(final boolean b) {
        if (b) {
            this.p.setBackgroundColor(0);
            return;
        }
        this.p.setBackgroundColor(-16777216);
    }
    
    public final void zzC() {
        synchronized (this.x) {
            this.z = true;
            final Runnable y = this.y;
            if (y != null) {
                final zzfnu i = zzs.i;
                ((Handler)i).removeCallbacks(y);
                ((Handler)i).post(this.y);
            }
        }
    }
    
    protected final void zzD() {
        if (this.a.isFinishing()) {
            if (!this.B) {
                this.B = true;
                final zzcli c = this.c;
                if (c != null) {
                    c.zzY(this.E - 1);
                    synchronized (this.x) {
                        if (!this.z && this.c.zzaz()) {
                            if ((boolean)zzay.c().zzb(zzbhy.zzdP) && !this.C) {
                                final AdOverlayInfoParcel b = this.b;
                                if (b != null) {
                                    final zzo c2 = b.c;
                                    if (c2 != null) {
                                        c2.zzbC();
                                    }
                                }
                            }
                            final zze y = new zze(this);
                            this.y = y;
                            ((Handler)zzs.i).postDelayed((Runnable)y, (long)zzay.c().zzb(zzbhy.zzaR));
                            return;
                        }
                    }
                }
                this.zzc();
            }
        }
    }
    
    public final boolean zzE() {
        this.E = 1;
        if (this.c == null) {
            return true;
        }
        if ((boolean)zzay.c().zzb(zzbhy.zzhr) && this.c.canGoBack()) {
            this.c.goBack();
            return false;
        }
        final boolean zzaE = this.c.zzaE();
        if (!zzaE) {
            ((zzbrc)this.c).zzd("onbackblocked", (Map)Collections.emptyMap());
        }
        return zzaE;
    }
    
    public final void zzb() {
        this.E = 3;
        this.a.finish();
        final AdOverlayInfoParcel b = this.b;
        if (b != null && b.p == 5) {
            this.a.overridePendingTransition(0, 0);
        }
    }
    
    public final void zzbJ() {
        this.E = 2;
        this.a.finish();
    }
    
    @VisibleForTesting
    final void zzc() {
        if (this.C) {
            return;
        }
        this.C = true;
        final zzcli c = this.c;
        if (c != null) {
            this.p.removeView(c.zzH());
            final zzh d = this.d;
            if (d != null) {
                this.c.zzam(d.d);
                this.c.zzap(false);
                final ViewGroup c2 = this.d.c;
                final View zzH = this.c.zzH();
                final zzh d2 = this.d;
                c2.addView(zzH, d2.a, d2.b);
                this.d = null;
            }
            else if (this.a.getApplicationContext() != null) {
                this.c.zzam(this.a.getApplicationContext());
            }
            this.c = null;
        }
        final AdOverlayInfoParcel b = this.b;
        if (b != null) {
            final zzo c3 = b.c;
            if (c3 != null) {
                c3.zzf(this.E);
            }
        }
        final AdOverlayInfoParcel b2 = this.b;
        if (b2 != null) {
            final zzcli d3 = b2.d;
            if (d3 != null) {
                r1(d3.zzS(), this.b.d.zzH());
            }
        }
    }
    
    public final void zzd() {
        this.p.b = true;
    }
    
    protected final void zze() {
        this.c.zzZ();
    }
    
    public final void zzf() {
        final AdOverlayInfoParcel b = this.b;
        if (b != null && this.f) {
            this.u1(b.j);
        }
        if (this.g != null) {
            this.a.setContentView((View)this.p);
            this.A = true;
            this.g.removeAllViews();
            this.g = null;
        }
        final WebChromeClient$CustomViewCallback h = this.h;
        if (h != null) {
            h.onCustomViewHidden();
            this.h = null;
        }
        this.f = false;
    }
    
    public final void zzg(final int n, final int n2, final Intent intent) {
    }
    
    public final void zzh() {
        this.E = 1;
    }
    
    public final void zzj(final IObjectWrapper objectWrapper) {
        this.q1(ObjectWrapper.p1(objectWrapper));
    }
    
    public void zzk(final Bundle bundle) {
        this.a.requestWindowFeature(1);
        this.i = (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false));
        try {
            final AdOverlayInfoParcel k1 = AdOverlayInfoParcel.K1(this.a.getIntent());
            this.b = k1;
            if (k1 == null) {
                throw new zzf("Could not get info for ad overlay.");
            }
            if (k1.x.zzc > 7500000) {
                this.E = 4;
            }
            if (this.a.getIntent() != null) {
                this.D = this.a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            final AdOverlayInfoParcel b = this.b;
            final zzj z = b.z;
            Label_0200: {
                if (z != null) {
                    final boolean a = z.a;
                    this.j = a;
                    if (!a) {
                        break Label_0200;
                    }
                }
                else {
                    if (b.p != 5) {
                        this.j = false;
                        break Label_0200;
                    }
                    this.j = true;
                }
                if (b.p != 5 && z.f != -1) {
                    new b(this, null).zzb();
                }
            }
            if (bundle == null) {
                if (this.D) {
                    final zzdcf i = this.b.I;
                    if (i != null) {
                        i.zzd();
                    }
                    final zzo c = this.b.c;
                    if (c != null) {
                        c.zzb();
                    }
                }
                final AdOverlayInfoParcel b2 = this.b;
                if (b2.p != 1) {
                    final zza b3 = b2.b;
                    if (b3 != null) {
                        b3.onAdClicked();
                    }
                    final zzdjf j = this.b.J;
                    if (j != null) {
                        j.zzq();
                    }
                }
            }
            final Activity a2 = this.a;
            final AdOverlayInfoParcel b4 = this.b;
            (this.p = new a((Context)a2, b4.y, b4.x.zza, b4.H)).setId(1000);
            zzt.r().h(this.a);
            final AdOverlayInfoParcel b5 = this.b;
            final int p = b5.p;
            if (p == 1) {
                this.p1(false);
                return;
            }
            if (p == 2) {
                this.d = new zzh(b5.d);
                this.p1(false);
                return;
            }
            if (p == 3) {
                this.p1(true);
                return;
            }
            if (p == 5) {
                this.p1(false);
                return;
            }
            throw new zzf("Could not determine ad overlay type.");
        }
        catch (final zzf zzf) {
            zzcfi.zzj(zzf.getMessage());
            this.E = 4;
            this.a.finish();
        }
    }
    
    public final void zzl() {
        final zzcli c = this.c;
        while (true) {
            if (c == null) {
                break Label_0022;
            }
            try {
                this.p.removeView(c.zzH());
                this.zzD();
            }
            catch (final NullPointerException ex) {
                continue;
            }
            break;
        }
    }
    
    public final void zzm() {
        if (this.w) {
            this.w = false;
            this.zze();
        }
    }
    
    public final void zzn() {
        this.zzf();
        final AdOverlayInfoParcel b = this.b;
        if (b != null) {
            final zzo c = b.c;
            if (c != null) {
                c.zzbr();
            }
        }
        if (!(boolean)zzay.c().zzb(zzbhy.zzdR) && this.c != null && (!this.a.isFinishing() || this.d == null)) {
            this.c.onPause();
        }
        this.zzD();
    }
    
    public final void zzo() {
    }
    
    public final void zzp() {
        final AdOverlayInfoParcel b = this.b;
        if (b != null) {
            final zzo c = b.c;
            if (c != null) {
                c.zzbK();
            }
        }
        this.q1(this.a.getResources().getConfiguration());
        if (!(boolean)zzay.c().zzb(zzbhy.zzdR)) {
            final zzcli c2 = this.c;
            if (c2 != null && !c2.zzaB()) {
                this.c.onResume();
                return;
            }
            zzcfi.zzj("The webview does not exist. Ignoring action.");
        }
    }
    
    public final void zzq(final Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.i);
    }
    
    public final void zzr() {
        if (zzay.c().zzb(zzbhy.zzdR)) {
            final zzcli c = this.c;
            if (c != null && !c.zzaB()) {
                this.c.onResume();
                return;
            }
            zzcfi.zzj("The webview does not exist. Ignoring action.");
        }
    }
    
    public final void zzs() {
        if ((boolean)zzay.c().zzb(zzbhy.zzdR) && this.c != null && (!this.a.isFinishing() || this.d == null)) {
            this.c.onPause();
        }
        this.zzD();
    }
    
    public final void zzt() {
        final AdOverlayInfoParcel b = this.b;
        if (b != null) {
            final zzo c = b.c;
            if (c != null) {
                c.zze();
            }
        }
    }
    
    public final void zzv() {
        this.A = true;
    }
    
    public final void zzx() {
        this.p.removeView((View)this.e);
        this.s1(true);
    }
}
