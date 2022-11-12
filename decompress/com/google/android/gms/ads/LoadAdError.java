// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONObject;

public final class LoadAdError extends AdError
{
    private final ResponseInfo e;
    
    public LoadAdError(final int n, final String s, final String s2, final AdError adError, final ResponseInfo e) {
        super(n, s, s2, adError);
        this.e = e;
    }
    
    @Override
    public final JSONObject e() throws JSONException {
        final JSONObject e = super.e();
        final ResponseInfo f = this.f();
        if (f == null) {
            e.put("Response Info", (Object)"null");
        }
        else {
            e.put("Response Info", (Object)f.e());
        }
        return e;
    }
    
    public ResponseInfo f() {
        return this.e;
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
