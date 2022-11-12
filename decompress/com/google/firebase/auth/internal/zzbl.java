// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import org.json.JSONException;
import android.text.TextUtils;
import org.json.JSONObject;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.Status;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;

public final class zzbl
{
    static final Map a;
    
    static {
        final HashMap a2 = new HashMap();
        (a = a2).put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        a2.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        a2.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        a2.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        a2.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }
    
    public static Status a(final Intent intent) {
        Preconditions.k(intent);
        Preconditions.a(d(intent));
        return SafeParcelableSerializer.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }
    
    public static Status b(final String s) {
        try {
            final JSONObject jsonObject = new JSONObject(s);
            final String string = jsonObject.getString("code");
            final String string2 = jsonObject.getString("message");
            if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)string2)) {
                final Map a = zzbl.a;
                if (a.containsKey(string)) {
                    final String s2 = a.get(string);
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s2);
                    sb.append(":");
                    sb.append(string2);
                    return zzai.a(sb.toString());
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("WEB_INTERNAL_ERROR:");
            sb2.append(s);
            return zzai.a(sb2.toString());
        }
        catch (final JSONException ex) {
            final String localizedMessage = ex.getLocalizedMessage();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("WEB_INTERNAL_ERROR:");
            sb3.append(s);
            sb3.append("[ ");
            sb3.append(localizedMessage);
            sb3.append(" ]");
            return zzai.a(sb3.toString());
        }
    }
    
    public static void c(final Intent intent, final Status status) {
        SafeParcelableSerializer.e(status, intent, "com.google.firebase.auth.internal.STATUS");
    }
    
    public static boolean d(final Intent intent) {
        Preconditions.k(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }
}
