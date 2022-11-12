// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Continuation;

public final class n implements Continuation
{
    public final SessionReportingCoordinator a;
    
    public n(final SessionReportingCoordinator a) {
        this.a = a;
    }
    
    public final Object then(final Task task) {
        return SessionReportingCoordinator.a(this.a, task);
    }
}
