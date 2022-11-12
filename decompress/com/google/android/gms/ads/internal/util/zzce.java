// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences$Editor;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import android.webkit.WebSettings;
import android.content.Context;

public final class zzce
{
    private static zzce b;
    String a;
    
    private zzce() {
    }
    
    public static zzce a() {
        if (zzce.b == null) {
            zzce.b = new zzce();
        }
        return zzce.b;
    }
    
    public final void b(final Context context) {
        zze.a("Updating user agent.");
        final String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(this.a)) {
            Context e = GooglePlayServicesUtilLight.e(context);
            Label_0088: {
                if (!ClientLibraryUtils.a()) {
                    if (e != null) {
                        break Label_0088;
                    }
                    e = null;
                }
                final SharedPreferences$Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (e == null) {
                    putString.apply();
                }
                else {
                    SharedPreferencesUtils.a(context, putString, "admob_user_agent");
                }
            }
            this.a = defaultUserAgent;
        }
        zze.a("User agent is updated.");
    }
}
