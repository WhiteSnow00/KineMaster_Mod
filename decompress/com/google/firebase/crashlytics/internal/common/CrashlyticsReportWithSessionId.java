// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class CrashlyticsReportWithSessionId
{
    public static CrashlyticsReportWithSessionId a(final CrashlyticsReport crashlyticsReport, final String s, final File file) {
        return new a(crashlyticsReport, s, file);
    }
    
    public abstract CrashlyticsReport b();
    
    public abstract File c();
    
    public abstract String d();
}
