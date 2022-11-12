// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.content.SharedPreferences$Editor;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class SharedPreferencesUtils
{
    private SharedPreferencesUtils() {
    }
    
    @Deprecated
    @KeepForSdk
    public static void a(final Context context, final SharedPreferences$Editor sharedPreferences$Editor, final String s) {
        throw new IllegalStateException("world-readable shared preferences should only be used by apk");
    }
}
