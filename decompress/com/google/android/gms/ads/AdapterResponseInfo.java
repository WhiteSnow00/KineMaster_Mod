// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import org.json.JSONException;
import java.util.Iterator;
import org.json.JSONObject;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;

public final class AdapterResponseInfo
{
    private final zzu a;
    private final AdError b;
    
    private AdapterResponseInfo(final zzu a) {
        this.a = a;
        final zze c = a.c;
        AdError k1;
        if (c == null) {
            k1 = null;
        }
        else {
            k1 = c.K1();
        }
        this.b = k1;
    }
    
    public static AdapterResponseInfo e(final zzu zzu) {
        if (zzu != null) {
            return new AdapterResponseInfo(zzu);
        }
        return null;
    }
    
    public String a() {
        return this.a.f;
    }
    
    public String b() {
        return this.a.h;
    }
    
    public String c() {
        return this.a.g;
    }
    
    public String d() {
        return this.a.e;
    }
    
    public final JSONObject f() throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("Adapter", (Object)this.a.a);
        jsonObject.put("Latency", this.a.b);
        final String d = this.d();
        if (d == null) {
            jsonObject.put("Ad Source Name", (Object)"null");
        }
        else {
            jsonObject.put("Ad Source Name", (Object)d);
        }
        final String a = this.a();
        if (a == null) {
            jsonObject.put("Ad Source ID", (Object)"null");
        }
        else {
            jsonObject.put("Ad Source ID", (Object)a);
        }
        final String c = this.c();
        if (c == null) {
            jsonObject.put("Ad Source Instance Name", (Object)"null");
        }
        else {
            jsonObject.put("Ad Source Instance Name", (Object)c);
        }
        final String b = this.b();
        if (b == null) {
            jsonObject.put("Ad Source Instance ID", (Object)"null");
        }
        else {
            jsonObject.put("Ad Source Instance ID", (Object)b);
        }
        final JSONObject jsonObject2 = new JSONObject();
        for (final String s : this.a.d.keySet()) {
            jsonObject2.put(s, this.a.d.get(s));
        }
        jsonObject.put("Credentials", (Object)jsonObject2);
        final AdError b2 = this.b;
        if (b2 == null) {
            jsonObject.put("Ad Error", (Object)"null");
        }
        else {
            jsonObject.put("Ad Error", (Object)b2.e());
        }
        return jsonObject;
    }
    
    @Override
    public String toString() {
        String string;
        try {
            string = this.f().toString(2);
        }
        catch (final JSONException ex) {
            string = "Error forming toString output.";
        }
        return string;
    }
}
