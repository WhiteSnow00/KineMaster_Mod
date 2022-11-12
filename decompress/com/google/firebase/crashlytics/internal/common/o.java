// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Comparator;

public final class o implements Comparator
{
    public static final o a;
    
    static {
        a = new o();
    }
    
    private o() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return SessionReportingCoordinator.b((CrashlyticsReport.CustomAttribute)o, (CrashlyticsReport.CustomAttribute)o2);
    }
}
