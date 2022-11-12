// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import i3.a;
import android.util.Base64;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver
{
    public static void a() {
        b();
    }
    
    private static void b() {
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final String queryParameter = intent.getData().getQueryParameter("backendName");
        final String queryParameter2 = intent.getData().getQueryParameter("extras");
        final int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority"));
        final int int1 = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.f(context);
        final TransportContext.Builder d = TransportContext.a().b(queryParameter).d(PriorityMapping.b(intValue));
        if (queryParameter2 != null) {
            d.c(Base64.decode(queryParameter2, 0));
        }
        TransportRuntime.c().e().v(d.a(), int1, (Runnable)a.a);
    }
}
