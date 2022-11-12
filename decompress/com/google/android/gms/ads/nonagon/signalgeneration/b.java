// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import org.json.JSONException;
import org.json.JSONObject;
import com.google.android.gms.ads.query.QueryInfo;
import android.webkit.ValueCallback;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

final class b extends QueryInfoGenerationCallback
{
    final String a;
    final a b;
    
    b(final a b, final String a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void a(String format) {
        zzcfi.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(format)));
        format = String.format("window.postMessage({'paw_id': '%1$s', 'error': '%2$s'}, '*');", this.a, format);
        com.google.android.gms.ads.nonagon.signalgeneration.a.a(this.b).evaluateJavascript(format, (ValueCallback)null);
    }
    
    @Override
    public final void b(QueryInfo queryInfo) {
        final String b = queryInfo.b();
        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("paw_id", (Object)this.a);
            jsonObject.put("signal", (Object)b);
            queryInfo = (QueryInfo)String.format("window.postMessage(%1$s, '*');", jsonObject);
        }
        catch (final JSONException ex) {
            queryInfo = (QueryInfo)String.format("window.postMessage({'paw_id': '%1$s', 'signal': '%2$s'}, '*');", this.a, queryInfo.b());
        }
        com.google.android.gms.ads.nonagon.signalgeneration.a.a(this.b).evaluateJavascript((String)queryInfo, (ValueCallback)null);
    }
}
