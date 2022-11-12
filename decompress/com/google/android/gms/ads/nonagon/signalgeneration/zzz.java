// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzfug;
import com.google.android.gms.internal.ads.zzcdw;
import org.json.JSONObject;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.internal.ads.zzced;
import com.google.android.gms.internal.ads.zzaod;
import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.view.View;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzfpg;
import java.util.Iterator;
import com.google.android.gms.internal.ads.zzfuw;
import java.util.concurrent.Callable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzfoi;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.internal.ads.zzfur;
import java.util.concurrent.Executor;
import com.google.android.gms.internal.ads.zzfuh;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzdsd;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzdhc;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.ads.zzfbw;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import android.text.TextUtils;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.android.gms.internal.ads.zzfig;
import com.google.android.gms.internal.ads.zzdwl;
import java.util.Set;
import android.graphics.Point;
import com.google.android.gms.internal.ads.zzbys;
import java.util.concurrent.ScheduledExecutorService;
import com.google.android.gms.internal.ads.zzfvk;
import com.google.android.gms.internal.ads.zzdwb;
import com.google.android.gms.internal.ads.zzfcu;
import com.google.android.gms.internal.ads.zzaoc;
import android.content.Context;
import com.google.android.gms.internal.ads.zzcnf;
import com.google.android.gms.internal.ads.zzcfo;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import com.google.android.gms.internal.ads.zzcdy;

public final class zzz extends zzcdy
{
    protected static final List N;
    protected static final List O;
    protected static final List P;
    protected static final List Q;
    public static final int R = 0;
    private final boolean A;
    private final boolean B;
    private final boolean C;
    private final String D;
    private final String E;
    private final AtomicInteger F;
    private final zzcfo G;
    private String H;
    private final String I;
    private final List J;
    private final List K;
    private final List L;
    private final List M;
    private final zzcnf a;
    private Context b;
    private final zzaoc c;
    private final zzfcu d;
    private zzdwb e;
    private final zzfvk f;
    private final ScheduledExecutorService g;
    private zzbys h;
    private Point i;
    private Point j;
    private final Set p;
    private final zzc w;
    private final zzdwl x;
    private final zzfig y;
    private final boolean z;
    
    static {
        N = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
        O = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
        P = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
        Q = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    }
    
    public zzz(final zzcnf a, final Context b, final zzaoc c, final zzfcu d, final zzfvk f, final ScheduledExecutorService g, final zzdwl x, final zzfig y, final zzcfo g2) {
        this.e = null;
        this.i = new Point();
        this.j = new Point();
        this.p = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
        this.F = new AtomicInteger(0);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.g = g;
        this.w = a.zzm();
        this.x = x;
        this.y = y;
        this.G = g2;
        this.z = (boolean)zzay.c().zzb(zzbhy.zzgi);
        this.A = (boolean)zzay.c().zzb(zzbhy.zzgh);
        this.B = (boolean)zzay.c().zzb(zzbhy.zzgj);
        this.C = (boolean)zzay.c().zzb(zzbhy.zzgl);
        this.D = (String)zzay.c().zzb(zzbhy.zzgk);
        this.E = (String)zzay.c().zzb(zzbhy.zzgm);
        this.I = (String)zzay.c().zzb(zzbhy.zzgn);
        List m;
        if (zzay.c().zzb(zzbhy.zzgo)) {
            this.J = K1((String)zzay.c().zzb(zzbhy.zzgp));
            this.K = K1((String)zzay.c().zzb(zzbhy.zzgq));
            this.L = K1((String)zzay.c().zzb(zzbhy.zzgr));
            m = K1((String)zzay.c().zzb(zzbhy.zzgs));
        }
        else {
            this.J = zzz.N;
            this.K = zzz.O;
            this.L = zzz.P;
            m = zzz.Q;
        }
        this.M = m;
    }
    
    static final Uri C1(final Uri uri, final String s) {
        Uri j1 = uri;
        if (!TextUtils.isEmpty((CharSequence)s)) {
            j1 = J1(uri, "nas", s);
        }
        return j1;
    }
    
    private final zzh D1(final Context context, final String s, final String s2, final zzq zzq, final zzl zzl) {
        final zzg zzn = this.a.zzn();
        final zzdbc zzdbc = new zzdbc();
        zzdbc.zzc(context);
        final zzfbw zzfbw = new zzfbw();
        String s3 = s;
        if (s == null) {
            s3 = "adUnitId";
        }
        zzfbw.zzs(s3);
        zzl a;
        if ((a = zzl) == null) {
            a = new zzm().a();
        }
        zzfbw.zzE(a);
        zzq zzq2;
        if ((zzq2 = zzq) == null) {
            zzq2 = new zzq();
        }
        zzfbw.zzr(zzq2);
        zzfbw.zzx(true);
        zzdbc.zzf(zzfbw.zzG());
        zzn.b(zzdbc.zzg());
        final zzab zzab = new zzab();
        zzab.a(s2);
        zzn.a(new zzad(zzab, null));
        new zzdhc();
        final zzh zzc = zzn.zzc();
        this.e = zzc.a();
        return zzc;
    }
    
    private final zzfvj E1(final String s) {
        final zzdsd[] array = { null };
        final zzfvj zzn = zzfva.zzn(this.d.zza(), (zzfuh)new zzj(this, array, s), (Executor)this.f);
        zzn.zzc((Runnable)new zzk(this, array), (Executor)this.f);
        return zzfva.zzf(zzfva.zzm((zzfvj)zzfva.zzo((zzfvj)zzfur.zzv(zzn), (long)(int)zzay.c().zzb(zzbhy.zzgv), TimeUnit.MILLISECONDS, this.g), (zzfoi)zzt.a, (Executor)this.f), (Class)Exception.class, (zzfoi)zzu.a, (Executor)this.f);
    }
    
    private final void F1(final List list, final IObjectWrapper objectWrapper, final zzbyj zzbyj, final boolean b) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzgu)) {
            zzcfi.zzj("The updating URL feature is not enabled.");
            try {
                zzbyj.zze("The updating URL feature is not enabled.");
                return;
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("", (Throwable)ex);
                return;
            }
        }
        final Iterator iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (this.A1((Uri)iterator.next())) {
                ++n;
            }
        }
        if (n > 1) {
            zzcfi.zzj("Multiple google urls found: ".concat(String.valueOf(list)));
        }
        final ArrayList list2 = new ArrayList();
        for (final Uri uri : list) {
            zzfvj zzfvj;
            if (!this.A1(uri)) {
                zzcfi.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                zzfvj = zzfva.zzi((Object)uri);
            }
            else {
                zzfvj = this.f.zzb((Callable)new zzo(this, uri, objectWrapper));
                if (this.I1()) {
                    zzfvj = zzfva.zzn(zzfvj, (zzfuh)new zzp(this), (Executor)this.f);
                }
                else {
                    zzcfi.zzi("Asset view map is empty.");
                }
            }
            list2.add(zzfvj);
        }
        zzfva.zzr(zzfva.zze((Iterable)list2), (zzfuw)new e(this, zzbyj, b), this.a.zzA());
    }
    
    private final void G1(final List list, final IObjectWrapper objectWrapper, final zzbyj zzbyj, final boolean b) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzgu)) {
            try {
                zzbyj.zze("The updating URL feature is not enabled.");
                return;
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("", (Throwable)ex);
                return;
            }
        }
        zzfvj zzfvj = this.f.zzb((Callable)new com.google.android.gms.ads.nonagon.signalgeneration.zzq(this, list, objectWrapper));
        if (this.I1()) {
            zzfvj = zzfva.zzn(zzfvj, (zzfuh)new zzr(this), (Executor)this.f);
        }
        else {
            zzcfi.zzi("Asset view map is empty.");
        }
        zzfva.zzr(zzfvj, (zzfuw)new d(this, zzbyj, b), this.a.zzA());
    }
    
    private static boolean H1(final Uri uri, final List list, final List list2) {
        final String host = uri.getHost();
        final String path = uri.getPath();
        if (host != null) {
            if (path != null) {
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    if (path.contains((CharSequence)iterator.next())) {
                        final Iterator iterator2 = list2.iterator();
                        while (iterator2.hasNext()) {
                            if (host.endsWith((String)iterator2.next())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private final boolean I1() {
        final zzbys h = this.h;
        if (h != null) {
            final Map zzb = h.zzb;
            if (zzb != null && !zzb.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    private static final Uri J1(final Uri uri, final String s, final String s2) {
        final String string = uri.toString();
        int n;
        if ((n = string.indexOf("&adurl=")) == -1) {
            n = string.indexOf("?adurl=");
        }
        if (n != -1) {
            ++n;
            final StringBuilder sb = new StringBuilder(string.substring(0, n));
            sb.append(s);
            sb.append("=");
            sb.append(s2);
            sb.append("&");
            sb.append(string.substring(n));
            return Uri.parse(sb.toString());
        }
        return uri.buildUpon().appendQueryParameter(s, s2).build();
    }
    
    private static final List K1(final String s) {
        final String[] split = TextUtils.split(s, ",");
        final ArrayList list = new ArrayList();
        for (final String s2 : split) {
            if (!zzfpg.zzd(s2)) {
                list.add(s2);
            }
        }
        return list;
    }
    
    static /* bridge */ Context L1(final zzz zzz) {
        return zzz.b;
    }
    
    static /* bridge */ Uri M1(final zzz zzz, final Uri uri, final String s, final String s2) {
        return J1(uri, s, "1");
    }
    
    static /* bridge */ zzcfo O1(final zzz zzz) {
        return zzz.G;
    }
    
    static /* bridge */ zzdwb P1(final zzz zzz) {
        return zzz.e;
    }
    
    static /* bridge */ zzdwl Q1(final zzz zzz) {
        return zzz.x;
    }
    
    static /* bridge */ zzfig R1(final zzz zzz) {
        return zzz.y;
    }
    
    public static zzfvj S1(final zzz zzz, final Uri uri) {
        return zzfva.zzm(zzz.E1("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), (zzfoi)new com.google.android.gms.ads.nonagon.signalgeneration.zzl(zzz, uri), (Executor)zzz.f);
    }
    
    static /* bridge */ String X1(final zzz zzz) {
        return zzz.I;
    }
    
    static /* bridge */ String Y1(final zzz zzz) {
        return zzz.E;
    }
    
    static /* bridge */ String Z1(final zzz zzz) {
        return zzz.H;
    }
    
    static /* bridge */ String a2(final zzz zzz) {
        return zzz.D;
    }
    
    static /* bridge */ AtomicInteger q1(final zzz zzz) {
        return zzz.F;
    }
    
    static /* bridge */ void r1(final zzz zzz, final String h) {
        zzz.H = h;
    }
    
    static /* bridge */ void s1(final zzz zzz, final List list) {
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (zzz.A1((Uri)iterator.next())) {
                zzz.F.getAndIncrement();
                break;
            }
        }
    }
    
    static /* bridge */ void t1(final zzz zzz, final String s, final String s2, final zzdwb zzdwb) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzfT)) {
            return;
        }
        if (zzay.c().zzb(zzbhy.zzfZ)) {
            ((Executor)zzcfv.zza).execute(new zzi(zzz, s, s2, zzdwb));
            return;
        }
        zzz.w.d(s, s2, zzdwb);
    }
    
    static /* bridge */ boolean w1(final zzz zzz) {
        return zzz.C;
    }
    
    static /* bridge */ boolean x1(final zzz zzz) {
        return zzz.B;
    }
    
    static /* bridge */ boolean y1(final zzz zzz) {
        return zzz.A;
    }
    
    static /* bridge */ boolean z1(final zzz zzz) {
        return zzz.z;
    }
    
    final boolean A1(final Uri uri) {
        return H1(uri, this.J, this.K);
    }
    
    final boolean B1(final Uri uri) {
        return H1(uri, this.L, this.M);
    }
    
    final ArrayList M0(final List list, final String s) {
        final ArrayList list2 = new ArrayList();
        for (final Uri uri : list) {
            if (this.B1(uri) && !TextUtils.isEmpty((CharSequence)s)) {
                list2.add(J1(uri, "nas", s));
            }
            else {
                list2.add(uri);
            }
        }
        return list2;
    }
    
    final Uri N1(Uri zza, final IObjectWrapper objectWrapper) throws Exception {
        try {
            zza = this.c.zza(zza, this.b, (View)ObjectWrapper.p1(objectWrapper), (Activity)null);
        }
        catch (final zzaod zzaod) {
            zzcfi.zzk("", (Throwable)zzaod);
        }
        if (zza.getQueryParameter("ms") != null) {
            return zza;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }
    
    final zzfvj T1(final zzced zzced) throws Exception {
        return this.D1(this.b, zzced.zza, zzced.zzb, zzced.zzc, zzced.zzd).b();
    }
    
    final zzfvj U1() throws Exception {
        return this.D1(this.b, null, AdFormat.BANNER.name(), null, null).b();
    }
    
    final zzfvj V1(final zzdsd[] array, final String s, final zzdsd zzdsd) throws Exception {
        array[0] = zzdsd;
        final Context b = this.b;
        final zzbys h = this.h;
        final Map zzb = h.zzb;
        final JSONObject d = zzbx.d(b, zzb, zzb, h.zza);
        final JSONObject g = zzbx.g(this.b, this.h.zza);
        final JSONObject f = zzbx.f(this.h.zza);
        final JSONObject e = zzbx.e(this.b, this.h.zza);
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("asset_view_signal", (Object)d);
        jsonObject.put("ad_view_signal", (Object)g);
        jsonObject.put("scroll_view_signal", (Object)f);
        jsonObject.put("lock_screen_signal", (Object)e);
        if (s == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jsonObject.put("click_signal", (Object)zzbx.c(null, this.b, this.j, this.i));
        }
        return zzdsd.zzd(s, jsonObject);
    }
    
    final zzfvj W1(final ArrayList list) throws Exception {
        return zzfva.zzm(this.E1("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), (zzfoi)new com.google.android.gms.ads.nonagon.signalgeneration.zzm(this, list), (Executor)this.f);
    }
    
    final ArrayList p1(final List list, final IObjectWrapper objectWrapper) throws Exception {
        String zzh;
        if (this.c.zzc() != null) {
            zzh = this.c.zzc().zzh(this.b, (View)ObjectWrapper.p1(objectWrapper), (Activity)null);
        }
        else {
            zzh = "";
        }
        if (TextUtils.isEmpty((CharSequence)zzh)) {
            throw new Exception("Failed to get view signals.");
        }
        final ArrayList<Uri> list2 = new ArrayList<Uri>();
        for (final Uri uri : list) {
            if (!this.B1(uri)) {
                zzcfi.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                list2.add(uri);
            }
            else {
                list2.add(J1(uri, "ms", zzh));
            }
        }
        if (!list2.isEmpty()) {
            return list2;
        }
        throw new Exception("Empty impression URLs result.");
    }
    
    final void u1(final zzdsd[] array) {
        final zzdsd zzdsd = array[0];
        if (zzdsd != null) {
            this.d.zzb(zzfva.zzi((Object)zzdsd));
        }
    }
    
    final void v1(final String s, final String s2, final zzdwb zzdwb) {
        this.w.d(s, s2, zzdwb);
    }
    
    public final void zze(final IObjectWrapper objectWrapper, final zzced zzced, final zzcdw zzcdw) {
        this.b = ObjectWrapper.p1(objectWrapper);
        zzfvj zzfvj;
        if (zzay.c().zzb(zzbhy.zzio)) {
            zzfvj = zzfva.zzl((zzfug)new zzn(this, zzced), (Executor)zzcfv.zza);
        }
        else {
            zzfvj = this.D1(this.b, zzced.zza, zzced.zzb, zzced.zzc, zzced.zzd).b();
        }
        zzfva.zzr(zzfvj, (zzfuw)new c(this, zzcdw, com.google.android.gms.ads.internal.zzt.a().a()), this.a.zzA());
    }
    
    public final void zzf(final zzbys h) {
        this.h = h;
        this.d.zzc(1);
    }
    
    public final void zzg(final List list, final IObjectWrapper objectWrapper, final zzbyj zzbyj) {
        this.F1(list, objectWrapper, zzbyj, true);
    }
    
    public final void zzh(final List list, final IObjectWrapper objectWrapper, final zzbyj zzbyj) {
        this.G1(list, objectWrapper, zzbyj, true);
    }
    
    public final void zzi(final IObjectWrapper objectWrapper) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzhK)) {
            return;
        }
        if (zzay.c().zzb(zzbhy.zzhL)) {
            zzfvj zzfvj;
            if (zzay.c().zzb(zzbhy.zzio)) {
                zzfvj = zzfva.zzl((zzfug)new zzs(this), (Executor)zzcfv.zza);
            }
            else {
                zzfvj = this.D1(this.b, null, AdFormat.BANNER.name(), null, null).b();
            }
            zzfva.zzr(zzfvj, (zzfuw)new f(this), this.a.zzA());
        }
        final WebView webView = ObjectWrapper.p1(objectWrapper);
        if (webView == null) {
            zzcfi.zzg("The webView cannot be null.");
            return;
        }
        if (this.p.contains(webView)) {
            zzcfi.zzi("This webview has already been registered.");
            return;
        }
        this.p.add(webView);
        webView.addJavascriptInterface((Object)new a(webView, this.c, this.x), "gmaSdk");
    }
    
    public final void zzj(final IObjectWrapper objectWrapper) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzgu)) {
            return;
        }
        final MotionEvent motionEvent = ObjectWrapper.p1(objectWrapper);
        final zzbys h = this.h;
        View zza;
        if (h == null) {
            zza = null;
        }
        else {
            zza = h.zza;
        }
        this.i = zzbx.a(motionEvent, zza);
        if (motionEvent.getAction() == 0) {
            this.j = this.i;
        }
        final MotionEvent obtain = MotionEvent.obtain(motionEvent);
        final Point i = this.i;
        obtain.setLocation((float)i.x, (float)i.y);
        this.c.zzd(obtain);
        obtain.recycle();
    }
    
    public final void zzk(final List list, final IObjectWrapper objectWrapper, final zzbyj zzbyj) {
        this.F1(list, objectWrapper, zzbyj, false);
    }
    
    public final void zzl(final List list, final IObjectWrapper objectWrapper, final zzbyj zzbyj) {
        this.G1(list, objectWrapper, zzbyj, false);
    }
}
