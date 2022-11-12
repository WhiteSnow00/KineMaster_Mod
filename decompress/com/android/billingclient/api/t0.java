// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

public final class t0
{
    t0(final JSONObject jsonObject) throws JSONException {
        jsonObject.getInt("commitmentPaymentsCount");
        jsonObject.optInt("subsequentCommitmentPaymentsCount");
    }
}
