// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.content.pm.ServiceInfo;
import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.CancellationException;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.content.Intent;
import java.util.concurrent.TimeUnit;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.internal.play_billing.zzz;
import android.app.Activity;
import android.content.ServiceConnection;
import java.util.Collection;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import android.os.Bundle;
import android.os.RemoteException;
import org.json.JSONException;
import android.text.TextUtils;
import java.util.List;
import java.util.ArrayList;
import com.google.android.gms.internal.play_billing.zzb;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import com.google.android.gms.internal.play_billing.zze;
import android.content.Context;
import android.os.Handler;

class d extends c
{
    private volatile int a;
    private final String b;
    private final Handler c;
    private volatile i1 d;
    private Context e;
    private volatile zze f;
    private volatile f0 g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ExecutorService v;
    
    private d(final Context context, final boolean b, final q q, final String b2, final String s, final d1 d1) {
        this.a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.j = 0;
        this.b = b2;
        this.l(context, q, b, null);
    }
    
    d(final String s, final boolean b, final Context context, final q q, final d1 d1) {
        this(context, b, q, u(), null, null);
    }
    
    d(final String s, final boolean t, final Context context, final s0 s2) {
        this.a = 0;
        this.c = new Handler(Looper.getMainLooper());
        this.j = 0;
        this.b = u();
        final Context applicationContext = context.getApplicationContext();
        this.e = applicationContext;
        this.d = new i1(applicationContext, null);
        this.t = t;
    }
    
    static /* bridge */ Handler C(final d d) {
        return d.r();
    }
    
    static /* bridge */ g0 D(final d d, final String s) {
        zzb.zzn("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(s)));
        final ArrayList list = new ArrayList();
        final Bundle zzh = zzb.zzh(d.m, d.t, d.b);
        String s2 = null;
        while (d.k) {
            g0 g0;
            try {
                final Bundle zzh2 = d.f.zzh(6, d.e.getPackageName(), s, s2, zzh);
                final g a = v0.a(zzh2, "BillingClient", "getPurchaseHistory()");
                if (a != p0.l) {
                    g0 = new g0(a, null);
                }
                else {
                    final ArrayList stringArrayList = zzh2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    final ArrayList stringArrayList2 = zzh2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    final ArrayList stringArrayList3 = zzh2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    int i = 0;
                    while (i < stringArrayList2.size()) {
                        final String s3 = stringArrayList2.get(i);
                        final String s4 = stringArrayList3.get(i);
                        zzb.zzn("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i))));
                        try {
                            final PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(s3, s4);
                            if (TextUtils.isEmpty((CharSequence)purchaseHistoryRecord.b())) {
                                zzb.zzo("BillingClient", "BUG: empty/null token!");
                            }
                            list.add(purchaseHistoryRecord);
                            ++i;
                            continue;
                        }
                        catch (final JSONException ex) {
                            zzb.zzp("BillingClient", "Got an exception trying to decode the purchase!", (Throwable)ex);
                            g0 = new g0(p0.j, null);
                            return g0;
                        }
                        break;
                    }
                    final String string = zzh2.getString("INAPP_CONTINUATION_TOKEN");
                    zzb.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                    s2 = string;
                    if (!TextUtils.isEmpty((CharSequence)string)) {
                        continue;
                    }
                    g0 = new g0(p0.l, list);
                }
            }
            catch (final RemoteException ex2) {
                zzb.zzp("BillingClient", "Got exception trying to get purchase history, try to reconnect", (Throwable)ex2);
                g0 = new g0(p0.m, null);
            }
            return g0;
        }
        zzb.zzo("BillingClient", "getPurchaseHistory is not supported on current device");
        return new g0(p0.q, null);
    }
    
    static /* bridge */ g E(final d d) {
        return d.t();
    }
    
    static /* bridge */ u0 F(final d d, final String s) {
        zzb.zzn("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(s)));
        final ArrayList list = new ArrayList();
        final Bundle zzh = zzb.zzh(d.m, d.t, d.b);
        String s2 = null;
        u0 u0;
        try {
            String string;
            do {
                Bundle bundle;
                if (d.m) {
                    bundle = d.f.zzj(9, d.e.getPackageName(), s, s2, zzh);
                }
                else {
                    bundle = d.f.zzi(3, d.e.getPackageName(), s, s2);
                }
                final g a = v0.a(bundle, "BillingClient", "getPurchase()");
                if (a != p0.l) {
                    u0 = new u0(a, null);
                    return u0;
                }
                final ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                final ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                final ArrayList stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i = 0;
                while (i < stringArrayList2.size()) {
                    final String s3 = stringArrayList2.get(i);
                    final String s4 = stringArrayList3.get(i);
                    zzb.zzn("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        final Purchase purchase = new Purchase(s3, s4);
                        if (TextUtils.isEmpty((CharSequence)purchase.d())) {
                            zzb.zzo("BillingClient", "BUG: empty/null token!");
                        }
                        list.add(purchase);
                        ++i;
                        continue;
                    }
                    catch (final JSONException ex) {
                        zzb.zzp("BillingClient", "Got an exception trying to decode the purchase!", (Throwable)ex);
                        u0 = new u0(p0.j, null);
                        return u0;
                    }
                    break;
                }
                string = bundle.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                s2 = string;
            } while (!TextUtils.isEmpty((CharSequence)string));
            u0 = new u0(p0.l, list);
        }
        catch (final Exception ex2) {
            zzb.zzp("BillingClient", "Got exception trying to get purchasesm try to reconnect", (Throwable)ex2);
            u0 = new u0(p0.m, null);
        }
        return u0;
    }
    
    static /* bridge */ zze G(final d d) {
        return d.f;
    }
    
    static /* bridge */ Future K(final d d, final Callable callable, final long n, final Runnable runnable, final Handler handler) {
        return d.v(callable, 30000L, runnable, handler);
    }
    
    static /* bridge */ void L(final d d, final int a) {
        d.a = a;
    }
    
    static /* bridge */ void M(final d d, final int j) {
        d.j = j;
    }
    
    static /* bridge */ void N(final d d, final boolean n) {
        d.n = n;
    }
    
    static /* bridge */ void O(final d d, final boolean o) {
        d.o = o;
    }
    
    static /* bridge */ void P(final d d, final boolean p2) {
        d.p = p2;
    }
    
    static /* bridge */ void Q(final d d, final boolean q) {
        d.q = q;
    }
    
    static /* bridge */ void R(final d d, final boolean r) {
        d.r = r;
    }
    
    static /* bridge */ void S(final d d, final boolean s) {
        d.s = s;
    }
    
    static /* bridge */ void T(final d d, final boolean k) {
        d.k = k;
    }
    
    static /* bridge */ void U(final d d, final boolean l) {
        d.l = l;
    }
    
    private void l(Context applicationContext, final q q, final boolean t, final d1 d1) {
        applicationContext = applicationContext.getApplicationContext();
        this.e = applicationContext;
        this.d = new i1(applicationContext, q, d1);
        this.t = t;
        this.u = (d1 != null);
    }
    
    static /* bridge */ void m(final d d, final boolean m) {
        d.m = m;
    }
    
    static /* bridge */ void n(final d d, final zze f) {
        d.f = f;
    }
    
    static /* bridge */ void o(final d d, final boolean i) {
        d.i = i;
    }
    
    static /* bridge */ void p(final d d, final boolean h) {
        d.h = h;
    }
    
    private final Handler r() {
        Handler c;
        if (Looper.myLooper() == null) {
            c = this.c;
        }
        else {
            c = new Handler(Looper.myLooper());
        }
        return c;
    }
    
    private final g s(final g g) {
        if (Thread.interrupted()) {
            return g;
        }
        this.c.post((Runnable)new y(this, g));
        return g;
    }
    
    private final g t() {
        g g;
        if (this.a != 0 && this.a != 3) {
            g = p0.j;
        }
        else {
            g = p0.m;
        }
        return g;
    }
    
    private static String u() {
        try {
            return (String)Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        }
        catch (final Exception ex) {
            return "5.0.0";
        }
    }
    
    private final Future v(final Callable callable, long n, final Runnable runnable, final Handler handler) {
        n *= (long)0.95;
        if (this.v == null) {
            this.v = Executors.newFixedThreadPool(zzb.zza, new b0(this));
        }
        try {
            final Future<Object> submit = this.v.submit((Callable<Object>)callable);
            handler.postDelayed((Runnable)new x(submit, runnable), n);
            return submit;
        }
        catch (final Exception ex) {
            zzb.zzp("BillingClient", "Async task throws exception!", (Throwable)ex);
            return null;
        }
    }
    
    private final void w(final String s, final o o) {
        if (!this.e()) {
            o.a(p0.m, null);
            return;
        }
        if (this.v(new a0(this, s, o), 30000L, new o1(o), this.r()) == null) {
            o.a(this.t(), null);
        }
    }
    
    private final void x(final String s, final p p2) {
        if (!this.e()) {
            p2.a(p0.m, (List<Purchase>)zzu.zzl());
            return;
        }
        if (TextUtils.isEmpty((CharSequence)s)) {
            zzb.zzo("BillingClient", "Please provide a valid product type.");
            p2.a(p0.g, (List<Purchase>)zzu.zzl());
            return;
        }
        if (this.v(new z(this, s, p2), 30000L, new w(p2), this.r()) == null) {
            p2.a(this.t(), (List<Purchase>)zzu.zzl());
        }
    }
    
    static /* bridge */ int y(final d d) {
        return d.j;
    }
    
    static /* bridge */ Context z(final d d) {
        return d.e;
    }
    
    final Bundle A(final int n, final String s, final String s2, final f f, final Bundle bundle) throws Exception {
        return this.f.zzg(n, this.e.getPackageName(), s, s2, (String)null, bundle);
    }
    
    final Bundle B(final String s, final String s2) throws Exception {
        return this.f.zzf(3, this.e.getPackageName(), s, s2, (String)null);
    }
    
    final Object H(final com.android.billingclient.api.a a, final b b) throws Exception {
        try {
            final Bundle zzd = this.f.zzd(9, this.e.getPackageName(), a.a(), zzb.zzc(a, this.b));
            final int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(zzd, "BillingClient");
            final String zzk = com.google.android.gms.internal.play_billing.zzb.zzk(zzd, "BillingClient");
            final g.a c = com.android.billingclient.api.g.c();
            c.c(zzb);
            c.b(zzk);
            b.a(c.a());
            return null;
        }
        catch (final Exception ex) {
            zzb.zzp("BillingClient", "Error acknowledge purchase!", (Throwable)ex);
            b.a(p0.m);
            return null;
        }
    }
    
    final Object I(final h h, final i i) throws Exception {
        final String a = h.a();
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("Consuming purchase with token: ");
            sb.append(a);
            zzb.zzn("BillingClient", sb.toString());
            int n;
            String zzk;
            if (this.m) {
                final Bundle zze = this.f.zze(9, this.e.getPackageName(), a, zzb.zzd(h, this.m, this.b));
                n = zze.getInt("RESPONSE_CODE");
                zzk = zzb.zzk(zze, "BillingClient");
            }
            else {
                n = this.f.zza(3, this.e.getPackageName(), a);
                zzk = "";
            }
            final g.a c = com.android.billingclient.api.g.c();
            c.c(n);
            c.b(zzk);
            final g a2 = c.a();
            if (n == 0) {
                zzb.zzn("BillingClient", "Successfully consumed purchase.");
                i.a(a2, a);
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Error consuming purchase with token. Response code: ");
                sb2.append(n);
                zzb.zzo("BillingClient", sb2.toString());
                i.a(a2, a);
            }
        }
        catch (final Exception ex) {
            zzb.zzp("BillingClient", "Error consuming purchase!", (Throwable)ex);
            i.a(p0.m, a);
        }
        return null;
    }
    
    final Object J(final r r, final n n) throws Exception {
        final ArrayList list = new ArrayList();
        final String c = r.c();
        final zzu b = r.b();
        final int size = ((List)b).size();
        final int n2 = 0;
        int n3 = 0;
        String zzk;
        int zzb;
        while (true) {
            zzk = "Item is unavailable for purchase.";
            if (n3 < size) {
                final int n4 = n3 + 20;
                int n5;
                if (n4 > size) {
                    n5 = size;
                }
                else {
                    n5 = n4;
                }
                final ArrayList list2 = new ArrayList(((List)b).subList(n3, n5));
                final ArrayList<String> list3 = new ArrayList<String>();
                for (int size2 = list2.size(), i = 0; i < size2; ++i) {
                    list3.add(((r.b)list2.get(i)).b());
                }
                final Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", (ArrayList)list3);
                bundle.putString("playBillingLibraryVersion", this.b);
                Label_0433: {
                    try {
                        final Bundle zzl = this.f.zzl(17, this.e.getPackageName(), c, bundle, com.google.android.gms.internal.play_billing.zzb.zzg(this.b, list2, (String)null));
                        if (zzl == null) {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "queryProductDetailsAsync got empty product details response.");
                        }
                        else if (!zzl.containsKey("DETAILS_LIST")) {
                            zzb = com.google.android.gms.internal.play_billing.zzb.zzb(zzl, "BillingClient");
                            zzk = com.google.android.gms.internal.play_billing.zzb.zzk(zzl, "BillingClient");
                            if (zzb != 0) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("getSkuDetails() failed for queryProductDetailsAsync. Response code: ");
                                sb.append(zzb);
                                com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", sb.toString());
                                break;
                            }
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                            break Label_0433;
                        }
                        else {
                            final ArrayList stringArrayList = zzl.getStringArrayList("DETAILS_LIST");
                            if (stringArrayList != null) {
                                int j = 0;
                                while (j < stringArrayList.size()) {
                                    final String s = stringArrayList.get(j);
                                    try {
                                        final m m = new m(s);
                                        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Got product details: ".concat(m.toString()));
                                        list.add(m);
                                        ++j;
                                        continue;
                                    }
                                    catch (final JSONException ex) {
                                        com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", (Throwable)ex);
                                        zzk = "Error trying to decode SkuDetails.";
                                        break Label_0433;
                                    }
                                    break;
                                }
                                n3 = n4;
                                continue;
                            }
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "queryProductDetailsAsync got null response list");
                        }
                        zzb = 4;
                        break;
                    }
                    catch (final Exception ex2) {
                        com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", (Throwable)ex2);
                        zzk = "An internal error occurred.";
                    }
                }
                zzb = 6;
                break;
            }
            zzk = "";
            zzb = n2;
            break;
        }
        final g.a c2 = com.android.billingclient.api.g.c();
        c2.c(zzb);
        c2.b(zzk);
        n.a(c2.a(), list);
        return null;
    }
    
    @Override
    public final void a(final com.android.billingclient.api.a a, final b b) {
        if (!this.e()) {
            b.a(p0.m);
            return;
        }
        if (TextUtils.isEmpty((CharSequence)a.a())) {
            zzb.zzo("BillingClient", "Please provide a valid purchase token.");
            b.a(p0.i);
            return;
        }
        if (!this.m) {
            b.a(p0.b);
            return;
        }
        if (this.v(new p1(this, a, b), 30000L, new q1(b), this.r()) == null) {
            b.a(this.t());
        }
    }
    
    @Override
    public final void b(final h h, final i i) {
        if (!this.e()) {
            i.a(p0.m, h.a());
            return;
        }
        if (this.v(new m1(this, h, i), 30000L, new n1(i, h), this.r()) == null) {
            i.a(this.t(), h.a());
        }
    }
    
    @Override
    public final void c() {
        try {
            try {
                this.d.d();
                if (this.g != null) {
                    this.g.c();
                }
                if (this.g != null && this.f != null) {
                    zzb.zzn("BillingClient", "Unbinding from service.");
                    this.e.unbindService((ServiceConnection)this.g);
                    this.g = null;
                }
                this.f = null;
                final ExecutorService v = this.v;
                if (v != null) {
                    v.shutdownNow();
                    this.v = null;
                }
                this.a = 3;
                return;
            }
            finally {}
        }
        catch (final Exception ex) {
            zzb.zzp("BillingClient", "There was an exception while ending connection!", (Throwable)ex);
            this.a = 3;
            return;
        }
        this.a = 3;
    }
    
    @Override
    public final int d() {
        return this.a;
    }
    
    @Override
    public final boolean e() {
        return this.a == 2 && this.f != null && this.g != null;
    }
    
    @Override
    public final g f(Activity ex, f f) {
        if (!this.e()) {
            final g m = p0.m;
            this.s(m);
            return m;
        }
        final ArrayList f2 = f.f();
        final List g = f.g();
        final SkuDetails skuDetails = (SkuDetails)zzz.zza((Iterable)f2, (Object)null);
        final f.b b = (f.b)zzz.zza((Iterable)g, (Object)null);
        String s;
        String s2;
        if (skuDetails != null) {
            s = skuDetails.a();
            s2 = skuDetails.b();
        }
        else {
            s = b.b().c();
            s2 = b.b().d();
        }
        final boolean equals = s2.equals("subs");
        Object zzk = "BillingClient";
        if (equals && !this.h) {
            zzb.zzo("BillingClient", "Current client doesn't support subscriptions.");
            final g o = p0.o;
            this.s(o);
            return o;
        }
        if (f.p() && !this.k) {
            zzb.zzo("BillingClient", "Current client doesn't support extra params for buy intent.");
            final g h = p0.h;
            this.s(h);
            return h;
        }
        if (f2.size() > 1 && !this.r) {
            zzb.zzo("BillingClient", "Current client doesn't support multi-item purchases.");
            final g t = p0.t;
            this.s(t);
            return t;
        }
        if (!g.isEmpty() && !this.s) {
            zzb.zzo("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            final g v = p0.v;
            this.s(v);
            return v;
        }
        Label_1346: {
            if (!this.k) {
                break Label_1346;
            }
            final Bundle zzf = zzb.zzf(f, this.m, this.t, this.u, this.b);
            f.b b7;
            SkuDetails skuDetails3;
            if (!f2.isEmpty()) {
                final ArrayList<String> list = new ArrayList<String>();
                final ArrayList<String> list2 = new ArrayList<String>();
                final ArrayList<String> list3 = new ArrayList<String>();
                final ArrayList<Integer> list4 = new ArrayList<Integer>();
                final ArrayList<String> list5 = new ArrayList<String>();
                final Iterator iterator = f2.iterator();
                boolean b2 = false;
                boolean b3 = false;
                boolean b4 = false;
                boolean b5 = false;
                while (iterator.hasNext()) {
                    final SkuDetails skuDetails2 = (SkuDetails)iterator.next();
                    if (!skuDetails2.h().isEmpty()) {
                        list.add(skuDetails2.h());
                    }
                    final String e = skuDetails2.e();
                    final String d = skuDetails2.d();
                    final int c = skuDetails2.c();
                    final String g2 = skuDetails2.g();
                    list2.add(e);
                    b2 |= (TextUtils.isEmpty((CharSequence)e) ^ true);
                    list3.add(d);
                    final boolean b6 = b3 | (TextUtils.isEmpty((CharSequence)d) ^ true);
                    list4.add(c);
                    b4 |= (c != 0);
                    b5 |= (TextUtils.isEmpty((CharSequence)g2) ^ true);
                    list5.add(g2);
                    b3 = b6;
                }
                final Object o2 = zzk;
                if (!list.isEmpty()) {
                    zzf.putStringArrayList("skuDetailsTokens", (ArrayList)list);
                }
                if (b2) {
                    zzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", (ArrayList)list2);
                }
                if (b3) {
                    zzf.putStringArrayList("SKU_OFFER_ID_LIST", (ArrayList)list3);
                }
                if (b4) {
                    zzf.putIntegerArrayList("SKU_OFFER_TYPE_LIST", (ArrayList)list4);
                }
                if (b5) {
                    zzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", (ArrayList)list5);
                }
                zzk = o2;
                b7 = b;
                skuDetails3 = skuDetails;
                if (f2.size() > 1) {
                    final ArrayList list6 = new ArrayList<String>(f2.size() - 1);
                    final ArrayList list7 = new ArrayList<String>(f2.size() - 1);
                    for (int i = 1; i < f2.size(); ++i) {
                        list6.add(((SkuDetails)f2.get(i)).a());
                        list7.add(((SkuDetails)f2.get(i)).b());
                    }
                    zzf.putStringArrayList("additionalSkus", list6);
                    zzf.putStringArrayList("additionalSkuTypes", list7);
                    zzk = o2;
                    b7 = b;
                    skuDetails3 = skuDetails;
                }
            }
            else {
                final String s3 = "BillingClient";
                final ArrayList list8 = new ArrayList<String>(g.size() - 1);
                final ArrayList list9 = new ArrayList<String>(g.size() - 1);
                final ArrayList<String> list10 = new ArrayList<String>();
                final ArrayList<String> list11 = new ArrayList<String>();
                for (int j = 0; j < g.size(); ++j) {
                    final f.b b8 = g.get(j);
                    final m b9 = b8.b();
                    if (!b9.h().isEmpty()) {
                        list10.add(b9.h());
                    }
                    list11.add(b8.c());
                    if (j > 0) {
                        list8.add(((f.b)g.get(j)).b().c());
                        list9.add(((f.b)g.get(j)).b().d());
                    }
                }
                zzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", (ArrayList)list11);
                if (!list10.isEmpty()) {
                    zzf.putStringArrayList("skuDetailsTokens", (ArrayList)list10);
                }
                zzk = s3;
                b7 = b;
                skuDetails3 = skuDetails;
                if (!list8.isEmpty()) {
                    zzf.putStringArrayList("additionalSkus", list8);
                    zzf.putStringArrayList("additionalSkuTypes", list9);
                    skuDetails3 = skuDetails;
                    b7 = b;
                    zzk = s3;
                }
            }
            if (zzf.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.p) {
                final g u = p0.u;
                this.s(u);
                return u;
            }
            int zzb = 0;
            Label_1135: {
                if (skuDetails3 != null && !TextUtils.isEmpty((CharSequence)skuDetails3.f())) {
                    zzf.putString("skuPackageName", skuDetails3.f());
                }
                else {
                    if (b7 == null || TextUtils.isEmpty((CharSequence)b7.b().g())) {
                        zzb = 0;
                        break Label_1135;
                    }
                    zzf.putString("skuPackageName", b7.b().g());
                }
                zzb = 1;
            }
            if (!TextUtils.isEmpty((CharSequence)null)) {
                zzf.putString("accountName", (String)null);
            }
            final Intent intent = ((Activity)ex).getIntent();
            String stringExtra;
            String versionName = null;
            Bundle bundle;
            String s4;
            String s5;
            Future future;
            Bundle bundle2;
            Block_47_Outer:Label_1240_Outer:
            while (true) {
                if (intent == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzo((String)zzk, "Activity's intent is null.");
                    break Label_1251;
                }
                if (TextUtils.isEmpty((CharSequence)intent.getStringExtra("PROXY_PACKAGE"))) {
                    break Label_1251;
                }
                stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                zzf.putString("proxyPackage", stringExtra);
                try {
                    versionName = this.e.getPackageManager().getPackageInfo(stringExtra, 0).versionName;
                    bundle = zzf;
                    s4 = "proxyPackageVersion";
                    s5 = versionName;
                    bundle.putString(s4, s5);
                    break Label_1251;
                }
                catch (final PackageManager$NameNotFoundException ex2) {}
                while (true) {
                    try {
                        bundle = zzf;
                        s4 = "proxyPackageVersion";
                        s5 = versionName;
                        bundle.putString(s4, s5);
                        if (this.s && !g.isEmpty()) {
                            zzb = 17;
                        }
                        else if (this.q && zzb != 0) {
                            zzb = 15;
                        }
                        else if (this.m) {
                            zzb = 9;
                        }
                        else {
                            zzb = 6;
                        }
                        future = this.v(new u(this, zzb, s, s2, f, zzf), 5000L, null, this.c);
                        f = (f)zzk;
                        while (true) {
                            try {
                                bundle2 = future.get(5000L, TimeUnit.MILLISECONDS);
                                zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle2, (String)f);
                                zzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundle2, (String)f);
                                if (zzb != 0) {
                                    ex = (Exception)new StringBuilder();
                                    ((StringBuilder)ex).append("Unable to buy item, Error response code: ");
                                    ((StringBuilder)ex).append(zzb);
                                    com.google.android.gms.internal.play_billing.zzb.zzo((String)f, ((StringBuilder)ex).toString());
                                    ex = (Exception)com.android.billingclient.api.g.c();
                                    ((g.a)ex).c(zzb);
                                    ((g.a)ex).b((String)zzk);
                                    ex = (Exception)((g.a)ex).a();
                                    this.s((g)ex);
                                    return (g)ex;
                                }
                                zzk = new Intent((Context)ex, (Class)ProxyBillingActivity.class);
                                ((Intent)zzk).putExtra("BUY_INTENT", (Parcelable)bundle2.getParcelable("BUY_INTENT"));
                                ((Activity)ex).startActivity((Intent)zzk);
                                return p0.l;
                            }
                            catch (Exception ex) {
                                com.google.android.gms.internal.play_billing.zzb.zzp((String)f, "Exception while launching billing flow. Try to reconnect", (Throwable)ex);
                                ex = (Exception)p0.m;
                                this.s((g)ex);
                                return (g)ex;
                            }
                            catch (final CancellationException ex) {}
                            catch (final TimeoutException ex3) {}
                            com.google.android.gms.internal.play_billing.zzb.zzp((String)f, "Time out while launching billing flow. Try to reconnect", (Throwable)ex);
                            ex = (Exception)p0.n;
                            this.s((g)ex);
                            return (g)ex;
                            f = (f)"BillingClient";
                            future = this.v(new v(this, s, s2), 5000L, null, this.c);
                            continue Label_1240_Outer;
                        }
                        zzf.putString("proxyPackageVersion", "package not found");
                        continue Block_47_Outer;
                    }
                    catch (final PackageManager$NameNotFoundException ex4) {
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
    
    @Override
    public void h(final r r, final n n) {
        if (!this.e()) {
            n.a(p0.m, new ArrayList<m>());
            return;
        }
        if (!this.s) {
            zzb.zzo("BillingClient", "Querying product details is not supported.");
            n.a(p0.v, new ArrayList<m>());
            return;
        }
        if (this.v(new k1(this, r, n), 30000L, new l1(n), this.r()) == null) {
            n.a(this.t(), new ArrayList<m>());
        }
    }
    
    @Override
    public final void i(final String s, final o o) {
        this.w(s, o);
    }
    
    @Override
    public void j(final s s, final p p2) {
        this.x(s.b(), p2);
    }
    
    @Override
    public final void k(final e e) {
        if (this.e()) {
            zzb.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
            e.a(p0.l);
            return;
        }
        if (this.a == 1) {
            zzb.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
            e.a(p0.d);
            return;
        }
        if (this.a == 3) {
            zzb.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            e.a(p0.m);
            return;
        }
        this.a = 1;
        this.d.e();
        zzb.zzn("BillingClient", "Starting in-app billing setup.");
        this.g = new f0(this, e, null);
        final Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        final List queryIntentServices = this.e.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            final ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                final String packageName = serviceInfo.packageName;
                final String name = serviceInfo.name;
                if ("com.android.vending".equals(packageName) && name != null) {
                    final ComponentName component = new ComponentName(packageName, name);
                    final Intent intent2 = new Intent(intent);
                    intent2.setComponent(component);
                    intent2.putExtra("playBillingLibraryVersion", this.b);
                    if (this.e.bindService(intent2, (ServiceConnection)this.g, 1)) {
                        zzb.zzn("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    zzb.zzo("BillingClient", "Connection to Billing service is blocked.");
                }
                else {
                    zzb.zzo("BillingClient", "The device doesn't have valid Play Store.");
                }
            }
        }
        this.a = 0;
        zzb.zzn("BillingClient", "Billing service unavailable on device.");
        e.a(p0.c);
    }
    
    final void q(final g g) {
        if (this.d.c() != null) {
            this.d.c().a(g, null);
            return;
        }
        this.d.b();
        zzb.zzo("BillingClient", "No valid listener is set in BroadcastManager");
    }
}
