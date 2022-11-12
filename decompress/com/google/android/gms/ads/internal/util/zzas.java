// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import java.util.concurrent.Executor;
import android.view.WindowManager$BadTokenException;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzcfv;
import android.net.Uri$Builder;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcfi;
import android.app.Activity;
import android.content.Intent;
import android.content.DialogInterface;
import com.google.android.gms.internal.ads.zzfvk;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import java.util.concurrent.atomic.AtomicInteger;
import android.app.AlertDialog$Builder;
import com.google.android.gms.internal.ads.zzdyw;
import java.util.List;
import java.util.ArrayList;
import com.google.android.gms.ads.internal.zzt;
import android.view.ViewConfiguration;
import android.os.Handler;
import android.graphics.PointF;
import com.google.android.gms.internal.ads.zzdza;
import android.content.Context;

public final class zzas
{
    private final Context a;
    private final zzdza b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private PointF i;
    private PointF j;
    private Handler k;
    private Runnable l;
    
    public zzas(final Context a) {
        this.g = 0;
        this.l = new zzar(this);
        this.a = a;
        this.h = ViewConfiguration.get(a).getScaledTouchSlop();
        zzt.u().b();
        this.k = zzt.u().a();
        this.b = zzt.t().a();
    }
    
    public zzas(final Context context, final String c) {
        this(context);
        this.c = c;
    }
    
    private final void s(final Context context) {
        final ArrayList list = new ArrayList();
        int u = u(list, "None", true);
        final int u2 = u(list, "Shake", true);
        final int u3 = u(list, "Flick", true);
        final zzdyw zza = zzdyw.zza;
        final int ordinal = ((Enum)this.b.zza()).ordinal();
        if (ordinal != 1) {
            if (ordinal == 2) {
                u = u3;
            }
        }
        else {
            u = u2;
        }
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context, zzt.r().a());
        final AtomicInteger atomicInteger = new AtomicInteger(u);
        alertDialog$Builder.setTitle((CharSequence)"Setup gesture");
        alertDialog$Builder.setSingleChoiceItems((CharSequence[])list.toArray(new String[0]), u, (DialogInterface$OnClickListener)new zzaj(atomicInteger));
        alertDialog$Builder.setNegativeButton((CharSequence)"Dismiss", (DialogInterface$OnClickListener)new zzak(this));
        alertDialog$Builder.setPositiveButton((CharSequence)"Save", (DialogInterface$OnClickListener)new zzal(this, atomicInteger, u, u2, u3));
        alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new zzam(this));
        alertDialog$Builder.create().show();
    }
    
    private final boolean t(final float n, final float n2, final float n3, final float n4) {
        return Math.abs(this.i.x - n) < this.h && Math.abs(this.i.y - n2) < this.h && Math.abs(this.j.x - n3) < this.h && Math.abs(this.j.y - n4) < this.h;
    }
    
    private static final int u(final List list, final String s, final boolean b) {
        if (!b) {
            return -1;
        }
        list.add(s);
        return list.size() - 1;
    }
    
    final void a() {
        this.s(this.a);
    }
    
    final void b() {
        this.s(this.a);
    }
    
    final void c(final zzfvk zzfvk) {
        if (!zzt.t().j(this.a, this.d, this.e)) {
            zzt.t().d(this.a, this.d, this.e);
            return;
        }
        ((Executor)zzfvk).execute(new zzaf(this));
    }
    
    final void d(final zzfvk zzfvk) {
        if (!zzt.t().j(this.a, this.d, this.e)) {
            zzt.t().d(this.a, this.d, this.e);
            return;
        }
        ((Executor)zzfvk).execute(new zzaq(this));
    }
    
    final void e() {
        zzt.t().c(this.a);
    }
    
    final void f() {
        zzt.t().c(this.a);
    }
    
    final void g() {
        this.g = 4;
        this.r();
    }
    
    final void h(final AtomicInteger atomicInteger, final int n, final int n2, final int n3, final DialogInterface dialogInterface, final int n4) {
        if (atomicInteger.get() != n) {
            if (atomicInteger.get() == n2) {
                this.b.zzj(zzdyw.zzb);
            }
            else if (atomicInteger.get() == n3) {
                this.b.zzj(zzdyw.zzc);
            }
            else {
                this.b.zzj(zzdyw.zza);
            }
        }
        this.r();
    }
    
    final void i(final String s, final DialogInterface dialogInterface, final int n) {
        zzt.q();
        zzs.i(this.a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", s), (CharSequence)"Share via"));
    }
    
    final void j(final int n, final int n2, final int n3, final int n4, final int n5, final DialogInterface dialogInterface, final int n6) {
        if (n6 == n) {
            if (!(this.a instanceof Activity)) {
                zzcfi.zzi("Can not create dialog without Activity Context");
                return;
            }
            final String c = this.c;
            final boolean empty = TextUtils.isEmpty((CharSequence)c);
            String message = "No debug information";
            if (!empty) {
                final Uri build = new Uri$Builder().encodedQuery(c.replaceAll("\\+", "%20")).build();
                final StringBuilder sb = new StringBuilder();
                zzt.q();
                final Map k = zzs.k(build);
                for (final String s : k.keySet()) {
                    sb.append(s);
                    sb.append(" = ");
                    sb.append((String)k.get(s));
                    sb.append("\n\n");
                }
                final String trim = sb.toString().trim();
                if (!TextUtils.isEmpty((CharSequence)trim)) {
                    message = trim;
                }
            }
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(this.a);
            alertDialog$Builder.setMessage((CharSequence)message);
            alertDialog$Builder.setTitle((CharSequence)"Ad Information");
            alertDialog$Builder.setPositiveButton((CharSequence)"Share", (DialogInterface$OnClickListener)new zzad(this, message));
            alertDialog$Builder.setNegativeButton((CharSequence)"Close", (DialogInterface$OnClickListener)zzae.a);
            alertDialog$Builder.create().show();
        }
        else {
            if (n6 == n2) {
                zzcfi.zze("Debug mode [Creative Preview] selected.");
                ((Executor)zzcfv.zza).execute(new zzac(this));
                return;
            }
            if (n6 == n3) {
                zzcfi.zze("Debug mode [Troubleshooting] selected.");
                ((Executor)zzcfv.zza).execute(new zzag(this));
                return;
            }
            if (n6 != n4) {
                if (n6 == n5) {
                    final zzfvk zze = zzcfv.zze;
                    final zzfvk zza = zzcfv.zza;
                    if (this.b.zzm()) {
                        ((Executor)zze).execute(new zzah(this));
                        return;
                    }
                    ((Executor)zza).execute(new zzai(this, zze));
                }
                return;
            }
            final zzfvk zze2 = zzcfv.zze;
            final zzfvk zza2 = zzcfv.zza;
            if (this.b.zzm()) {
                ((Executor)zze2).execute(new zzan(this));
                return;
            }
            ((Executor)zza2).execute(new zzao(this, zze2));
        }
    }
    
    final void k() {
        final zzaw t = zzt.t();
        final Context a = this.a;
        final String d = this.d;
        final String e = this.e;
        final String f = this.f;
        final boolean m = t.m();
        t.h(t.j(a, d, e));
        if (t.m()) {
            if (!m && !TextUtils.isEmpty((CharSequence)f)) {
                t.e(a, e, f, d);
            }
            zzcfi.zze("Device is linked for debug signals.");
            t.i(a, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        t.d(a, d, e);
    }
    
    final void l() {
        final zzaw t = zzt.t();
        final Context a = this.a;
        final String d = this.d;
        final String e = this.e;
        if (!t.k(a, d, e)) {
            t.i(a, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(t.f)) {
            zzcfi.zze("Creative is not pushed for this device.");
            t.i(a, "There was no creative pushed from DFP to the device.", false, false);
            return;
        }
        if ("1".equals(t.f)) {
            zzcfi.zze("The app is not linked for creative preview.");
            t.d(a, d, e);
            return;
        }
        if ("0".equals(t.f)) {
            zzcfi.zze("Device is linked for in app preview.");
            t.i(a, "The device is successfully linked for creative preview.", false, true);
        }
    }
    
    public final void m(final MotionEvent motionEvent) {
        final int actionMasked = motionEvent.getActionMasked();
        final int historySize = motionEvent.getHistorySize();
        final int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.g = 0;
            this.i = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        final int g = this.g;
        if (g == -1) {
            return;
        }
        if (g == 0) {
            if (actionMasked == 5) {
                this.g = 5;
                this.j = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.k.postDelayed(this.l, (long)zzay.c().zzb(zzbhy.zzdI));
            }
        }
        else if (g == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                int i = 0;
                boolean b = false;
                while (i < historySize) {
                    b |= (this.t(motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i), motionEvent.getHistoricalX(1, i), motionEvent.getHistoricalY(1, i)) ^ true);
                    ++i;
                }
                if (this.t(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !b) {
                    return;
                }
            }
            this.g = -1;
            this.k.removeCallbacks(this.l);
        }
    }
    
    public final void n(final String d) {
        this.d = d;
    }
    
    public final void o(final String e) {
        this.e = e;
    }
    
    public final void p(final String c) {
        this.c = c;
    }
    
    public final void q(final String f) {
        this.f = f;
    }
    
    public final void r() {
        try {
            if (!(this.a instanceof Activity)) {
                zzcfi.zzi("Can not create dialog without Activity Context");
                return;
            }
            final boolean empty = TextUtils.isEmpty((CharSequence)zzt.t().b());
            String s = "Creative preview (enabled)";
            if (empty) {
                s = "Creative preview";
            }
            final boolean m = zzt.t().m();
            String s2 = "Troubleshooting (enabled)";
            if (!m) {
                s2 = "Troubleshooting";
            }
            final ArrayList list = new ArrayList();
            final int u = u(list, "Ad information", true);
            final int u2 = u(list, s, true);
            final int u3 = u(list, s2, true);
            final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzhG);
            final int u4 = u(list, "Open ad inspector", booleanValue);
            final int u5 = u(list, "Ad inspector settings", booleanValue);
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(this.a, zzt.r().a());
            alertDialog$Builder.setTitle((CharSequence)"Select a debug mode").setItems((CharSequence[])list.toArray(new String[0]), (DialogInterface$OnClickListener)new zzap(this, u, u2, u3, u4, u5));
            alertDialog$Builder.create().show();
        }
        catch (final WindowManager$BadTokenException ex) {
            zze.b("", (Throwable)ex);
        }
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.c);
        sb.append(",DebugSignal: ");
        sb.append(this.f);
        sb.append(",AFMA Version: ");
        sb.append(this.e);
        sb.append(",Ad Unit ID: ");
        sb.append(this.d);
        sb.append("}");
        return sb.toString();
    }
}
