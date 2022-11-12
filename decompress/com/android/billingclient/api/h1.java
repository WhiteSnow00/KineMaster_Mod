// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import org.json.JSONArray;
import android.os.Bundle;
import org.json.JSONException;
import java.util.ArrayList;
import org.json.JSONObject;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.List;
import android.content.Intent;
import com.google.android.gms.internal.play_billing.zzb;
import android.content.IntentFilter;
import android.content.Context;
import android.content.BroadcastReceiver;

final class h1 extends BroadcastReceiver
{
    private final q a;
    private final s0 b;
    private final d1 c;
    private boolean d;
    final i1 e;
    
    h1(final i1 e, final q a, final d1 c, final g1 g1) {
        this.e = e;
        this.a = a;
        this.c = c;
        this.b = null;
    }
    
    h1(final i1 e, final s0 s0, final g1 g1) {
        this.e = e;
        this.a = null;
        this.c = null;
        this.b = null;
    }
    
    static /* bridge */ s0 a(final h1 h1) {
        final s0 b = h1.b;
        return null;
    }
    
    static /* bridge */ q b(final h1 h1) {
        return h1.a;
    }
    
    public final void c(final Context context, final IntentFilter intentFilter) {
        if (!this.d) {
            context.registerReceiver((BroadcastReceiver)i1.a(this.e), intentFilter);
            this.d = true;
        }
    }
    
    public final void d(final Context context) {
        if (this.d) {
            context.unregisterReceiver((BroadcastReceiver)i1.a(this.e));
            this.d = false;
            return;
        }
        zzb.zzo("BillingBroadcastManager", "Receiver is not registered.");
    }
    
    public final void onReceive(Context string, final Intent intent) {
        final g zzi = zzb.zzi(intent, "BillingBroadcastManager");
        final String action = intent.getAction();
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            this.a.a(zzi, zzb.zzm(intent.getExtras()));
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            final Bundle extras = intent.getExtras();
            if (zzi.b() != 0) {
                this.a.a(zzi, (List<Purchase>)zzu.zzl());
                return;
            }
            if (this.c == null) {
                zzb.zzo("BillingBroadcastManager", "AlternativeBillingListener is null.");
                this.a.a(p0.j, (List<Purchase>)zzu.zzl());
                return;
            }
            if (extras == null) {
                zzb.zzo("BillingBroadcastManager", "Bundle is null.");
                this.a.a(p0.j, (List<Purchase>)zzu.zzl());
                return;
            }
            string = (Context)extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
            if (string != null) {
                try {
                    final JSONArray optJSONArray = new JSONObject((String)string).optJSONArray("products");
                    final ArrayList list = new ArrayList();
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); ++i) {
                            final JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                list.add(new f1(optJSONObject, null));
                            }
                        }
                    }
                    this.c.zza();
                    return;
                }
                catch (final JSONException ex) {
                    zzb.zzo("BillingBroadcastManager", String.format("Error when parsing invalid alternative choice data: [%s]", string));
                    this.a.a(p0.j, (List<Purchase>)zzu.zzl());
                    return;
                }
            }
            zzb.zzo("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
            this.a.a(p0.j, (List<Purchase>)zzu.zzl());
        }
    }
}
