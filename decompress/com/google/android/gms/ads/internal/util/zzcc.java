// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import android.webkit.WebSettings;
import android.text.TextUtils;
import android.content.Context;
import java.util.concurrent.Callable;

public final class zzcc implements Callable
{
    public final Context a;
    
    public zzcc(final Context a) {
        this.a = a;
    }
    
    @Override
    public final Object call() {
        final Context a = this.a;
        final SharedPreferences sharedPreferences = a.getSharedPreferences("admob_user_agent", 0);
        String s = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty((CharSequence)s)) {
            zze.a("User agent is not initialized on Google Play Services. Initializing.");
            s = WebSettings.getDefaultUserAgent(a);
            SharedPreferencesUtils.a(a, sharedPreferences.edit().putString("user_agent", s), "admob_user_agent");
        }
        else {
            zze.a("User agent is already initialized on Google Play Services.");
        }
        return s;
    }
}
