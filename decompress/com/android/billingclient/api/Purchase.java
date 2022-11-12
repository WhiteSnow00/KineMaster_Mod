// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Purchase
{
    private final String a;
    private final String b;
    private final JSONObject c;
    
    public Purchase(final String a, final String b) throws JSONException {
        this.a = a;
        this.b = b;
        this.c = new JSONObject(a);
    }
    
    public String a() {
        return this.c.optString("orderId");
    }
    
    public String b() {
        return this.a;
    }
    
    public int c() {
        if (this.c.optInt("purchaseState", 1) != 4) {
            return 1;
        }
        return 2;
    }
    
    public String d() {
        final JSONObject c = this.c;
        return c.optString("token", c.optString("purchaseToken"));
    }
    
    public String e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Purchase)) {
            return false;
        }
        final Purchase purchase = (Purchase)o;
        return TextUtils.equals((CharSequence)this.a, (CharSequence)purchase.b()) && TextUtils.equals((CharSequence)this.b, (CharSequence)purchase.e());
    }
    
    public boolean f() {
        return this.c.optBoolean("acknowledged", true);
    }
    
    public boolean g() {
        return this.c.optBoolean("autoRenewing");
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.a));
    }
}
