// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Map;

public class GetTokenResult
{
    private String a;
    private Map<String, Object> b;
    
    @KeepForSdk
    public GetTokenResult(final String a, final Map<String, Object> b) {
        this.a = a;
        this.b = b;
    }
    
    public Map<String, Object> a() {
        return this.b;
    }
    
    public String b() {
        final Map map = this.b.get("firebase");
        if (map != null) {
            return (String)map.get("sign_in_provider");
        }
        return null;
    }
    
    public String c() {
        return this.a;
    }
}
