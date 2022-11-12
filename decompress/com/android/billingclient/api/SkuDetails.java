// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

@Deprecated
public class SkuDetails
{
    private final String a;
    private final JSONObject b;
    
    public String a() {
        return this.b.optString("productId");
    }
    
    public String b() {
        return this.b.optString("type");
    }
    
    public int c() {
        return this.b.optInt("offer_type");
    }
    
    public String d() {
        return this.b.optString("offer_id");
    }
    
    public String e() {
        String s;
        if ((s = this.b.optString("offerIdToken")).isEmpty()) {
            s = this.b.optString("offer_id_token");
        }
        return s;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof SkuDetails && TextUtils.equals((CharSequence)this.a, (CharSequence)((SkuDetails)o).a));
    }
    
    public final String f() {
        return this.b.optString("packageName");
    }
    
    public String g() {
        return this.b.optString("serializedDocid");
    }
    
    final String h() {
        return this.b.optString("skuDetailsToken");
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.a));
    }
}
