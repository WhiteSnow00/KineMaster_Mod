// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.settings;

import org.json.JSONException;
import org.json.JSONObject;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;

interface c
{
    Settings a(final CurrentTimeProvider p0, final JSONObject p1) throws JSONException;
}
