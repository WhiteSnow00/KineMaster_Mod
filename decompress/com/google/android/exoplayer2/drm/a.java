// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import org.json.JSONArray;
import org.json.JSONException;
import com.google.android.exoplayer2.util.Log;
import org.json.JSONObject;
import com.google.android.exoplayer2.util.Util;

final class a
{
    public static byte[] a(final byte[] array) {
        if (Util.a >= 27) {
            return array;
        }
        return Util.n0(c(Util.D(array)));
    }
    
    public static byte[] b(final byte[] array) {
        if (Util.a >= 27) {
            return array;
        }
        try {
            final JSONObject jsonObject = new JSONObject(Util.D(array));
            final StringBuilder sb = new StringBuilder("{\"keys\":[");
            final JSONArray jsonArray = jsonObject.getJSONArray("keys");
            for (int i = 0; i < jsonArray.length(); ++i) {
                if (i != 0) {
                    sb.append(",");
                }
                final JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(d(jsonObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jsonObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jsonObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return Util.n0(sb.toString());
        }
        catch (final JSONException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to adjust response data: ");
            sb2.append(Util.D(array));
            Log.d("ClearKeyUtil", sb2.toString(), (Throwable)ex);
            return array;
        }
    }
    
    private static String c(final String s) {
        return s.replace('+', '-').replace('/', '_');
    }
    
    private static String d(final String s) {
        return s.replace('-', '+').replace('_', '/');
    }
}
