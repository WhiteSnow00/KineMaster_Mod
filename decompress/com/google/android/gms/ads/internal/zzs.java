// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.zzbi;
import java.util.Iterator;
import java.util.Map;
import com.google.android.gms.internal.ads.zzbjc;
import android.net.Uri$Builder;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzdh;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.ads.internal.client.zzaw;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.ads.internal.client.zzfg;
import com.google.android.gms.internal.ads.zzcaq;
import com.google.android.gms.internal.ads.zzbyg;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzbyd;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.client.zzcg;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.common.internal.Preconditions;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import android.view.ViewGroup$LayoutParams;
import android.content.Intent;
import com.google.android.gms.internal.ads.zzaod;
import com.google.android.gms.internal.ads.zzcfi;
import android.app.Activity;
import android.view.View;
import android.net.Uri;
import android.view.View$OnTouchListener;
import android.webkit.WebViewClient;
import java.util.concurrent.Callable;
import com.google.android.gms.internal.ads.zzcfv;
import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzaoc;
import com.google.android.gms.ads.internal.client.zzbf;
import android.webkit.WebView;
import android.content.Context;
import java.util.concurrent.Future;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.ads.zzcfo;
import javax.annotation.ParametersAreNonnullByDefault;
import com.google.android.gms.ads.internal.client.zzbr;

@ParametersAreNonnullByDefault
public final class zzs extends zzbr
{
    private final zzcfo a;
    private final zzq b;
    private final Future c;
    private final Context d;
    private final f e;
    private WebView f;
    private zzbf g;
    private zzaoc h;
    private AsyncTask i;
    
    public zzs(final Context d, final zzq b, final String s, final zzcfo a) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.f = new WebView(d);
        this.c = (Future)zzcfv.zza.zzb((Callable)new d(this));
        this.e = new f(d, s);
        this.M0(0);
        this.f.setVerticalScrollBarEnabled(false);
        this.f.getSettings().setJavaScriptEnabled(true);
        this.f.setWebViewClient((WebViewClient)new b(this));
        this.f.setOnTouchListener((View$OnTouchListener)new c(this));
    }
    
    static /* bridge */ Context p1(final zzs zzs) {
        return zzs.d;
    }
    
    static /* bridge */ WebView q1(final zzs zzs) {
        return zzs.f;
    }
    
    static /* bridge */ zzaoc r1(final zzs zzs) {
        return zzs.h;
    }
    
    static /* bridge */ zzbf s1(final zzs zzs) {
        return zzs.g;
    }
    
    static /* bridge */ zzcfo t1(final zzs zzs) {
        return zzs.a;
    }
    
    static /* bridge */ String u1(final zzs zzs, String s) {
        if (zzs.h != null) {
            s = (String)Uri.parse(s);
            Object zza;
            try {
                zza = zzs.h.zza((Uri)s, zzs.d, (View)null, (Activity)null);
            }
            catch (final zzaod zzaod) {
                zzcfi.zzk("Unable to process ad data", (Throwable)zzaod);
                zza = s;
            }
            s = ((Uri)zza).toString();
        }
        return s;
    }
    
    static /* bridge */ Future v1(final zzs zzs) {
        return zzs.c;
    }
    
    static /* bridge */ void w1(final zzs zzs, final zzaoc h) {
        zzs.h = h;
    }
    
    static /* bridge */ void x1(final zzs zzs, final String s) {
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s));
        zzs.d.startActivity(intent);
    }
    
    @VisibleForTesting
    final void M0(final int n) {
        if (this.f == null) {
            return;
        }
        this.f.setLayoutParams(new ViewGroup$LayoutParams(-1, n));
    }
    
    public final void zzA() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzB() throws RemoteException {
        Preconditions.f("resume must be called on the main UI thread.");
    }
    
    public final void zzC(final zzbc zzbc) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzD(final zzbf g) throws RemoteException {
        this.g = g;
    }
    
    public final void zzE(final zzbw zzbw) {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzF(final zzq zzq) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }
    
    public final void zzG(final zzbz zzbz) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzH(final zzbci zzbci) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzI(final zzw zzw) {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzJ(final zzcg zzcg) {
    }
    
    public final void zzK(final zzdo zzdo) {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzL(final boolean b) {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzM(final zzbyd zzbyd) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzN(final boolean b) throws RemoteException {
    }
    
    public final void zzO(final zzbit zzbit) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzP(final zzde zzde) {
    }
    
    public final void zzQ(final zzbyg zzbyg, final String s) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzR(final String s) {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzS(final zzcaq zzcaq) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzT(final String s) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzU(final zzfg zzfg) {
        throw new IllegalStateException("Unused method");
    }
    
    public final void zzW(final IObjectWrapper objectWrapper) {
    }
    
    public final void zzX() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    public final boolean zzY() throws RemoteException {
        return false;
    }
    
    public final boolean zzZ() throws RemoteException {
        return false;
    }
    
    public final boolean zzaa(final zzl zzl) throws RemoteException {
        Preconditions.l(this.f, "This Search Ad has already been torn down");
        this.e.f(zzl, this.a);
        this.i = new e(this, null).execute((Object[])new Void[0]);
        return true;
    }
    
    public final void zzab(final zzcd zzcd) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
    
    @VisibleForTesting
    final int zzb(String queryParameter) {
        queryParameter = Uri.parse(queryParameter).getQueryParameter("height");
        if (TextUtils.isEmpty((CharSequence)queryParameter)) {
            return 0;
        }
        try {
            zzaw.b();
            return zzcfb.zzv(this.d, Integer.parseInt(queryParameter));
        }
        catch (final NumberFormatException ex) {
            return 0;
        }
    }
    
    public final Bundle zzd() {
        throw new IllegalStateException("Unused method");
    }
    
    public final zzq zzg() throws RemoteException {
        return this.b;
    }
    
    public final zzbf zzi() {
        throw new IllegalStateException("getIAdListener not implemented");
    }
    
    public final zzbz zzj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }
    
    public final zzdh zzk() {
        return null;
    }
    
    public final zzdk zzl() {
        return null;
    }
    
    public final IObjectWrapper zzn() throws RemoteException {
        Preconditions.f("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.q1(this.f);
    }
    
    @VisibleForTesting
    final String zzp() {
        final Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.scheme("https://").appendEncodedPath((String)zzbjc.zzd.zze());
        uri$Builder.appendQueryParameter("query", this.e.d());
        uri$Builder.appendQueryParameter("pubId", this.e.c());
        uri$Builder.appendQueryParameter("mappver", this.e.a());
        final Map e = this.e.e();
        for (final String s : e.keySet()) {
            uri$Builder.appendQueryParameter(s, (String)e.get(s));
        }
        final Uri build = uri$Builder.build();
        final zzaoc h = this.h;
        Uri zzb = build;
        if (h != null) {
            try {
                zzb = h.zzb(build, this.d);
            }
            catch (final zzaod zzaod) {
                zzcfi.zzk("Unable to process ad data", (Throwable)zzaod);
                zzb = build;
            }
        }
        final String zzq = this.zzq();
        final String encodedQuery = zzb.getEncodedQuery();
        final StringBuilder sb = new StringBuilder();
        sb.append(zzq);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }
    
    @VisibleForTesting
    final String zzq() {
        String b;
        if (TextUtils.isEmpty((CharSequence)(b = this.e.b()))) {
            b = "www.google.com";
        }
        final String s = (String)zzbjc.zzd.zze();
        final StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(b);
        sb.append(s);
        return sb.toString();
    }
    
    public final String zzr() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }
    
    public final String zzs() throws RemoteException {
        return null;
    }
    
    public final String zzt() throws RemoteException {
        return null;
    }
    
    public final void zzx() throws RemoteException {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.i.cancel(true);
        this.c.cancel(true);
        this.f.destroy();
        this.f = null;
    }
    
    public final void zzy(final zzl zzl, final zzbi zzbi) {
    }
    
    public final void zzz() throws RemoteException {
        Preconditions.f("pause must be called on the main UI thread.");
    }
}
