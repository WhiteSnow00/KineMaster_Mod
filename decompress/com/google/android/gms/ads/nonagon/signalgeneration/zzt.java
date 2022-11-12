// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import org.json.JSONObject;
import com.google.android.gms.internal.ads.zzfoi;

public final class zzt implements zzfoi
{
    public static final zzt a;
    
    static {
        a = new zzt();
    }
    
    private zzt() {
    }
    
    public final Object apply(final Object o) {
        final JSONObject jsonObject = (JSONObject)o;
        final int r = zzz.R;
        return jsonObject.optString("nas");
    }
}
