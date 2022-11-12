// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import java.util.Objects;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.view.View;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzcfb;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.OnPaidEventListener;
import android.view.ViewGroup;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.ads.VideoController;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.android.gms.internal.ads.zzbtw;

public final class zzdu
{
    private final zzbtw a;
    private final zzp b;
    private final AtomicBoolean c;
    private final VideoController d;
    @VisibleForTesting
    final zzax e;
    private zza f;
    private AdListener g;
    private AdSize[] h;
    private AppEventListener i;
    private zzbs j;
    private VideoOptions k;
    private String l;
    private final ViewGroup m;
    private int n;
    private boolean o;
    private OnPaidEventListener p;
    
    public zzdu(final ViewGroup viewGroup, final int n) {
        this(viewGroup, null, false, zzp.a, null, n);
    }
    
    @VisibleForTesting
    zzdu(final ViewGroup m, final AttributeSet set, final boolean b, final zzp b2, zzbs context, int n) {
        this.a = new zzbtw();
        this.d = new VideoController();
        this.e = new n(this);
        this.m = m;
        this.b = b2;
        this.j = null;
        this.c = new AtomicBoolean(false);
        this.n = n;
        if (set != null) {
            context = (zzbs)m.getContext();
            try {
                final zzy zzy = new zzy((Context)context, set);
                this.h = zzy.b(b);
                this.l = zzy.a();
                if (m.isInEditMode()) {
                    final zzcfb b3 = zzaw.b();
                    final AdSize adSize = this.h[0];
                    n = this.n;
                    zzq o1;
                    if (adSize.equals(AdSize.q)) {
                        o1 = zzq.O1();
                    }
                    else {
                        o1 = new zzq((Context)context, adSize);
                        o1.j = c(n);
                    }
                    b3.zzk(m, o1, "Ads by Google");
                }
            }
            catch (final IllegalArgumentException ex) {
                zzaw.b().zzj(m, new zzq((Context)context, AdSize.i), ex.getMessage(), ex.getMessage());
            }
        }
    }
    
    private static zzq b(final Context context, final AdSize[] array, final int n) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (array[i].equals(AdSize.q)) {
                return zzq.O1();
            }
        }
        final zzq zzq = new zzq(context, array);
        zzq.j = c(n);
        return zzq;
    }
    
    private static boolean c(final int n) {
        return n == 1;
    }
    
    static /* bridge */ VideoController h(final zzdu zzdu) {
        return zzdu.d;
    }
    
    public final void A(final VideoOptions k) {
        this.k = k;
        try {
            final zzbs j = this.j;
            if (j != null) {
                zzfg zzfg;
                if (k == null) {
                    zzfg = null;
                }
                else {
                    zzfg = new zzfg(k);
                }
                j.zzU(zzfg);
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    public final boolean B(final zzbs j) {
        try {
            final IObjectWrapper zzn = j.zzn();
            if (zzn == null) {
                return false;
            }
            if (((View)ObjectWrapper.p1(zzn)).getParent() != null) {
                return false;
            }
            this.m.addView((View)ObjectWrapper.p1(zzn));
            this.j = j;
            return true;
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            return false;
        }
    }
    
    public final AdSize[] a() {
        return this.h;
    }
    
    public final AdListener d() {
        return this.g;
    }
    
    public final AdSize e() {
        try {
            final zzbs j = this.j;
            if (j != null) {
                final zzq zzg = j.zzg();
                if (zzg != null) {
                    return zzb.c(zzg.e, zzg.b, zzg.a);
                }
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
        final AdSize[] h = this.h;
        if (h != null) {
            return h[0];
        }
        return null;
    }
    
    public final OnPaidEventListener f() {
        return this.p;
    }
    
    public final ResponseInfo g() {
        final zzdh zzdh = null;
        zzdh zzk;
        try {
            final zzbs j = this.j;
            zzk = zzdh;
            if (j != null) {
                zzk = j.zzk();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            zzk = zzdh;
        }
        return ResponseInfo.c(zzk);
    }
    
    public final VideoController i() {
        return this.d;
    }
    
    public final VideoOptions j() {
        return this.k;
    }
    
    public final AppEventListener k() {
        return this.i;
    }
    
    public final zzdk l() {
        final zzbs j = this.j;
        if (j != null) {
            try {
                return j.zzl();
            }
            catch (final RemoteException ex) {
                zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
            }
        }
        return null;
    }
    
    public final String m() {
        if (this.l == null) {
            final zzbs j = this.j;
            if (j != null) {
                try {
                    this.l = j.zzr();
                }
                catch (final RemoteException ex) {
                    zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
                }
            }
        }
        return this.l;
    }
    
    public final void n() {
        try {
            final zzbs j = this.j;
            if (j != null) {
                j.zzx();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    final void o(final IObjectWrapper objectWrapper) {
        this.m.addView((View)ObjectWrapper.p1(objectWrapper));
    }
    
    public final void p(final zzdr zzdr) {
        try {
            if (this.j == null) {
                if (this.h == null || this.l == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                final Context context = this.m.getContext();
                final zzq b = b(context, this.h, this.n);
                zzbs j;
                if ("search_v2".equals(b.a)) {
                    j = (zzbs)new g(zzaw.a(), context, b, this.l).d(context, false);
                }
                else {
                    j = (zzbs)new e(zzaw.a(), context, b, this.l, (zzbtz)this.a).d(context, false);
                }
                (this.j = j).zzD(new zzg(this.e));
                final zza f = this.f;
                if (f != null) {
                    this.j.zzC(new com.google.android.gms.ads.internal.client.zzb(f));
                }
                final AppEventListener i = this.i;
                if (i != null) {
                    this.j.zzG((zzbz)new zzbba(i));
                }
                if (this.k != null) {
                    this.j.zzU(new zzfg(this.k));
                }
                this.j.zzP(new zzez(this.p));
                this.j.zzN(this.o);
                final zzbs k = this.j;
                if (k != null) {
                    try {
                        final IObjectWrapper zzn = k.zzn();
                        if (zzn != null) {
                            if ((boolean)zzbjm.zze.zze() && (boolean)zzay.c().zzb(zzbhy.zziq)) {
                                zzcfb.zza.post((Runnable)new zzds(this, zzn));
                            }
                            else {
                                this.m.addView((View)ObjectWrapper.p1(zzn));
                            }
                        }
                    }
                    catch (final RemoteException ex) {
                        zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
                    }
                }
            }
            final zzbs l = this.j;
            Objects.requireNonNull(l);
            l.zzaa(this.b.a(this.m.getContext(), zzdr));
        }
        catch (final RemoteException ex2) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex2);
        }
    }
    
    public final void q() {
        try {
            final zzbs j = this.j;
            if (j != null) {
                j.zzz();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    public final void r() {
        try {
            final zzbs j = this.j;
            if (j != null) {
                j.zzB();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    public final void s(final zza f) {
        try {
            this.f = f;
            final zzbs j = this.j;
            if (j != null) {
                zzbc zzbc;
                if (f != null) {
                    zzbc = new com.google.android.gms.ads.internal.client.zzb(f);
                }
                else {
                    zzbc = null;
                }
                j.zzC(zzbc);
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    public final void t(final AdListener g) {
        this.g = g;
        this.e.e(g);
    }
    
    public final void u(final AdSize... array) {
        if (this.h == null) {
            this.v(array);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    
    public final void v(final AdSize... h) {
        this.h = h;
        try {
            final zzbs j = this.j;
            if (j != null) {
                j.zzF(b(this.m.getContext(), this.h, this.n));
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
        this.m.requestLayout();
    }
    
    public final void w(final String l) {
        if (this.l == null) {
            this.l = l;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    
    public final void x(final AppEventListener i) {
        try {
            this.i = i;
            final zzbs j = this.j;
            if (j != null) {
                Object o;
                if (i != null) {
                    o = new zzbba(i);
                }
                else {
                    o = null;
                }
                j.zzG((zzbz)o);
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    public final void y(final boolean o) {
        this.o = o;
        try {
            final zzbs j = this.j;
            if (j != null) {
                j.zzN(o);
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
    
    public final void z(final OnPaidEventListener p) {
        try {
            this.p = p;
            final zzbs j = this.j;
            if (j != null) {
                j.zzP(new zzez(p));
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)ex);
        }
    }
}
