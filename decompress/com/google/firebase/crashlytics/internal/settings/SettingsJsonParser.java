// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

import org.json.JSONException;
import org.json.JSONObject;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;

public class SettingsJsonParser
{
    private final CurrentTimeProvider a;
    
    SettingsJsonParser(final CurrentTimeProvider a) {
        this.a = a;
    }
    
    private static c a(final int n) {
        if (n != 3) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not determine SettingsJsonTransform for settings version ");
            sb.append(n);
            sb.append(". Using default settings values.");
            f.d(sb.toString());
            return new a();
        }
        return new f();
    }
    
    public Settings b(final JSONObject jsonObject) throws JSONException {
        return a(jsonObject.getInt("settings_version")).a(this.a, jsonObject);
    }
}
