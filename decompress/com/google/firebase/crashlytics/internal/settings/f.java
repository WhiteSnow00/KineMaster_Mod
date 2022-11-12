// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

import org.json.JSONException;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONObject;

class f implements c
{
    private static Settings.FeatureFlagData b(final JSONObject jsonObject) {
        return new Settings.FeatureFlagData(jsonObject.optBoolean("collect_reports", true), jsonObject.optBoolean("collect_anrs", false));
    }
    
    private static Settings.SessionData c(final JSONObject jsonObject) {
        return new Settings.SessionData(jsonObject.optInt("max_custom_exception_events", 8), 4);
    }
    
    private static long d(final CurrentTimeProvider currentTimeProvider, long optLong, final JSONObject jsonObject) {
        if (jsonObject.has("expires_at")) {
            optLong = jsonObject.optLong("expires_at");
        }
        else {
            optLong = currentTimeProvider.a() + optLong * 1000L;
        }
        return optLong;
    }
    
    @Override
    public Settings a(final CurrentTimeProvider currentTimeProvider, final JSONObject jsonObject) throws JSONException {
        final int optInt = jsonObject.optInt("settings_version", 0);
        final int optInt2 = jsonObject.optInt("cache_duration", 3600);
        final double optDouble = jsonObject.optDouble("on_demand_upload_rate_per_minute", 10.0);
        final double optDouble2 = jsonObject.optDouble("on_demand_backoff_base", 1.2);
        final int optInt3 = jsonObject.optInt("on_demand_backoff_step_duration_seconds", 60);
        Settings.SessionData sessionData;
        if (jsonObject.has("session")) {
            sessionData = c(jsonObject.getJSONObject("session"));
        }
        else {
            sessionData = c(new JSONObject());
        }
        return new Settings(d(currentTimeProvider, optInt2, jsonObject), sessionData, b(jsonObject.getJSONObject("features")), optInt, optInt2, optDouble, optDouble2, optInt3);
    }
}
