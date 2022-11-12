// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONArray;
import java.util.ArrayList;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

public final class m
{
    private final String a;
    private final JSONObject b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final List i;
    
    m(final String a) throws JSONException {
        this.a = a;
        final JSONObject b = new JSONObject(a);
        this.b = b;
        final String optString = b.optString("productId");
        this.c = optString;
        final String optString2 = b.optString("type");
        this.d = optString2;
        if (TextUtils.isEmpty((CharSequence)optString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty((CharSequence)optString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.e = b.optString("title");
        this.f = b.optString("name");
        this.g = b.optString("description");
        this.h = b.optString("skuDetailsToken");
        if (!optString2.equals("inapp")) {
            final ArrayList i = new ArrayList();
            final JSONArray optJSONArray = b.optJSONArray("subscriptionOfferDetails");
            if (optJSONArray != null) {
                for (int j = 0; j < optJSONArray.length(); ++j) {
                    i.add(new d(optJSONArray.getJSONObject(j)));
                }
            }
            this.i = i;
            return;
        }
        this.i = null;
    }
    
    public String a() {
        return this.g;
    }
    
    public a b() {
        final JSONObject optJSONObject = this.b.optJSONObject("oneTimePurchaseOfferDetails");
        if (optJSONObject != null) {
            return new a(optJSONObject);
        }
        return null;
    }
    
    public String c() {
        return this.c;
    }
    
    public String d() {
        return this.d;
    }
    
    public List<d> e() {
        return this.i;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return this == o || (o instanceof m && TextUtils.equals((CharSequence)this.a, (CharSequence)((m)o).a));
    }
    
    public String f() {
        return this.e;
    }
    
    public final String g() {
        return this.b.optString("packageName");
    }
    
    final String h() {
        return this.h;
    }
    
    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public final String toString() {
        final String a = this.a;
        final String string = this.b.toString();
        final String c = this.c;
        final String d = this.d;
        final String e = this.e;
        final String h = this.h;
        final String value = String.valueOf(this.i);
        final StringBuilder sb = new StringBuilder();
        sb.append("ProductDetails{jsonString='");
        sb.append(a);
        sb.append("', parsedJson=");
        sb.append(string);
        sb.append(", productId='");
        sb.append(c);
        sb.append("', productType='");
        sb.append(d);
        sb.append("', title='");
        sb.append(e);
        sb.append("', productDetailsToken='");
        sb.append(h);
        sb.append("', subscriptionOfferDetails=");
        sb.append(value);
        sb.append("}");
        return sb.toString();
    }
    
    public static final class a
    {
        private final String a;
        private final long b;
        private final String c;
        private final String d;
        private final String e;
        
        a(final JSONObject jsonObject) {
            this.a = jsonObject.optString("formattedPrice");
            this.b = jsonObject.optLong("priceAmountMicros");
            this.c = jsonObject.optString("priceCurrencyCode");
            this.d = jsonObject.optString("offerIdToken");
            this.e = jsonObject.optString("offerId");
            jsonObject.optInt("offerType");
        }
        
        public final String a() {
            return this.d;
        }
    }
    
    public static final class b
    {
        private final String a;
        private final long b;
        private final String c;
        private final String d;
        private final int e;
        private final int f;
        
        b(final JSONObject jsonObject) {
            this.d = jsonObject.optString("billingPeriod");
            this.c = jsonObject.optString("priceCurrencyCode");
            this.a = jsonObject.optString("formattedPrice");
            this.b = jsonObject.optLong("priceAmountMicros");
            this.f = jsonObject.optInt("recurrenceMode");
            this.e = jsonObject.optInt("billingCycleCount");
        }
        
        public int a() {
            return this.e;
        }
        
        public String b() {
            return this.a;
        }
        
        public long c() {
            return this.b;
        }
        
        public String d() {
            return this.c;
        }
    }
    
    public static class c
    {
        private final List<b> a;
        
        c(final JSONArray jsonArray) {
            final ArrayList a = new ArrayList();
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); ++i) {
                    final JSONObject optJSONObject = jsonArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        a.add(new b(optJSONObject));
                    }
                }
            }
            this.a = a;
        }
        
        public List<b> a() {
            return this.a;
        }
    }
    
    public static final class d
    {
        private final String a;
        private final c b;
        private final List<String> c;
        private final t0 d;
        
        d(final JSONObject jsonObject) throws JSONException {
            this.a = jsonObject.getString("offerIdToken");
            this.b = new c(jsonObject.getJSONArray("pricingPhases"));
            final JSONObject optJSONObject = jsonObject.optJSONObject("installmentPlanDetails");
            t0 d;
            if (optJSONObject == null) {
                d = null;
            }
            else {
                d = new t0(optJSONObject);
            }
            this.d = d;
            final ArrayList c = new ArrayList();
            final JSONArray optJSONArray = jsonObject.optJSONArray("offerTags");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); ++i) {
                    c.add(optJSONArray.getString(i));
                }
            }
            this.c = c;
        }
        
        public String a() {
            return this.a;
        }
        
        public c b() {
            return this.b;
        }
    }
}
