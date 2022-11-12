// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.Iterator;
import androidx.collection.a;
import com.google.android.gms.internal.firebase_auth_api.zznp;
import android.util.Log;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import com.google.android.gms.common.util.Base64Utils;
import java.util.HashMap;
import com.google.android.gms.internal.firebase_auth_api.zzaf;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import com.google.android.gms.common.util.VisibleForTesting;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import com.google.android.gms.common.logging.Logger;

final class l
{
    private static final Logger a;
    
    static {
        a = new Logger("JSONParser", new String[0]);
    }
    
    @VisibleForTesting
    static List a(final JSONArray jsonArray) throws JSONException {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < jsonArray.length(); ++i) {
            final Object value = jsonArray.get(i);
            Object o;
            if (value instanceof JSONArray) {
                o = a((JSONArray)value);
            }
            else {
                o = value;
                if (value instanceof JSONObject) {
                    o = d((JSONObject)value);
                }
            }
            list.add(o);
        }
        return list;
    }
    
    public static Map b(String s) {
        Preconditions.g(s);
        final List zzd = ((zzaf)zzaf.zzb('.')).zzd((CharSequence)s);
        if (zzd.size() < 2) {
            l.a.c("Invalid idToken ".concat(String.valueOf(s)), new Object[0]);
            return new HashMap();
        }
        s = (String)zzd.get(1);
        try {
            Map c;
            if ((c = c(new String(Base64Utils.b(s), "UTF-8"))) == null) {
                c = new HashMap();
            }
            return c;
        }
        catch (final UnsupportedEncodingException ex) {
            l.a.b("Unable to decode token", ex, new Object[0]);
            return new HashMap();
        }
    }
    
    public static Map c(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        try {
            final JSONObject jsonObject = new JSONObject(s);
            if (jsonObject != JSONObject.NULL) {
                return d(jsonObject);
            }
            return null;
        }
        catch (final Exception ex) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zznp((Throwable)ex);
        }
    }
    
    @VisibleForTesting
    static Map d(final JSONObject jsonObject) throws JSONException {
        final a a = new a();
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            final String s = keys.next();
            final Object value = jsonObject.get(s);
            Object o;
            if (value instanceof JSONArray) {
                o = a((JSONArray)value);
            }
            else {
                o = value;
                if (value instanceof JSONObject) {
                    o = d((JSONObject)value);
                }
            }
            a.put(s, o);
        }
        return a;
    }
}
