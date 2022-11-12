// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.analytics;

import com.google.firebase.crashlytics.internal.Logger;
import android.os.Bundle;

public class UnavailableAnalyticsEventLogger implements AnalyticsEventLogger
{
    @Override
    public void a(final String s, final Bundle bundle) {
        Logger.f().b("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
