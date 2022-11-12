// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.ArrayList;
import com.google.android.gms.internal.play_billing.zzb;
import android.os.Bundle;

final class v0
{
    static g a(final Bundle bundle, final String s, final String s2) {
        final g j = p0.j;
        if (bundle == null) {
            zzb.zzo("BillingClient", String.format("%s got null owned items list", s2));
            return j;
        }
        final int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        final String zzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundle, "BillingClient");
        final g.a c = g.c();
        c.c(zzb);
        c.b(zzk);
        final g a = c.a();
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("%s failed. Response code: %s", s2, zzb));
            return a;
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", s2));
            return j;
        }
        final ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        final ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        final ArrayList stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", s2));
            return j;
        }
        if (stringArrayList2 == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null purchases list.", s2));
            return j;
        }
        if (stringArrayList3 == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", String.format("Bundle returned from %s contains null signatures list.", s2));
            return j;
        }
        return p0.l;
    }
}
