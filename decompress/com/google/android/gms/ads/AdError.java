// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONObject;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zze;

public class AdError
{
    private final int a;
    private final String b;
    private final String c;
    private final AdError d;
    
    public AdError(final int n, final String s, final String s2) {
        this(n, s, s2, null);
    }
    
    public AdError(final int a, final String b, final String c, final AdError d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int a() {
        return this.a;
    }
    
    public String b() {
        return this.c;
    }
    
    public String c() {
        return this.b;
    }
    
    public final zze d() {
        zze zze;
        if (this.d == null) {
            zze = null;
        }
        else {
            final AdError d = this.d;
            zze = new zze(d.a, d.b, d.c, null, null);
        }
        return new zze(this.a, this.b, this.c, zze, null);
    }
    
    public JSONObject e() throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("Code", this.a);
        jsonObject.put("Message", (Object)this.b);
        jsonObject.put("Domain", (Object)this.c);
        final AdError d = this.d;
        if (d == null) {
            jsonObject.put("Cause", (Object)"null");
        }
        else {
            jsonObject.put("Cause", (Object)d.e());
        }
        return jsonObject;
    }
    
    @Override
    public String toString() {
        String string;
        try {
            string = this.e().toString(2);
        }
        catch (final JSONException ex) {
            string = "Error forming toString output.";
        }
        return string;
    }
}
