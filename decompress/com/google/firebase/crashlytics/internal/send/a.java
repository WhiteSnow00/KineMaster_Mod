// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.send;

import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.datatransport.TransportScheduleCallback;

public final class a implements TransportScheduleCallback
{
    public final TaskCompletionSource a;
    public final CrashlyticsReportWithSessionId b;
    
    public a(final TaskCompletionSource a, final CrashlyticsReportWithSessionId b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a(final Exception ex) {
        com.google.firebase.crashlytics.internal.send.b.a(this.a, this.b, ex);
    }
}
