// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

import org.json.JSONObject;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;

class a implements c
{
    static Settings b(final CurrentTimeProvider currentTimeProvider) {
        return new Settings(currentTimeProvider.a() + 3600000, new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false), 0, 3600, 10.0, 1.2, 60);
    }
    
    @Override
    public Settings a(final CurrentTimeProvider currentTimeProvider, final JSONObject jsonObject) {
        return b(currentTimeProvider);
    }
}
