// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import android.webkit.WebSettings;
import android.text.TextUtils;
import android.content.Context;
import java.util.concurrent.Callable;

public final class zzcd implements Callable
{
    public final Context a;
    public final Context b;
    
    public zzcd(final Context a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object call() {
        final Context a = this.a;
        final Context b = this.b;
        boolean b2 = false;
        SharedPreferences sharedPreferences;
        if (a != null) {
            zze.a("Attempting to read user agent from Google Play Services.");
            sharedPreferences = a.getSharedPreferences("admob_user_agent", 0);
        }
        else {
            zze.a("Attempting to read user agent from local cache.");
            sharedPreferences = b.getSharedPreferences("admob_user_agent", 0);
            b2 = true;
        }
        String s;
        if (TextUtils.isEmpty((CharSequence)(s = sharedPreferences.getString("user_agent", "")))) {
            zze.a("Reading user agent from WebSettings");
            final String s2 = s = WebSettings.getDefaultUserAgent(b);
            if (b2) {
                sharedPreferences.edit().putString("user_agent", s2).apply();
                zze.a("Persisting user agent.");
                s = s2;
            }
        }
        return s;
    }
}
