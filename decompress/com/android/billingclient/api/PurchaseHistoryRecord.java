// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseHistoryRecord
{
    private final String a;
    private final String b;
    private final JSONObject c;
    
    public PurchaseHistoryRecord(final String a, final String b) throws JSONException {
        this.a = a;
        this.b = b;
        this.c = new JSONObject(a);
    }
    
    public String a() {
        return this.a;
    }
    
    public String b() {
        final JSONObject c = this.c;
        return c.optString("token", c.optString("purchaseToken"));
    }
    
    public String c() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseHistoryRecord)) {
            return false;
        }
        final PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord)o;
        return TextUtils.equals((CharSequence)this.a, (CharSequence)purchaseHistoryRecord.a()) && TextUtils.equals((CharSequence)this.b, (CharSequence)purchaseHistoryRecord.c());
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.a));
    }
}
