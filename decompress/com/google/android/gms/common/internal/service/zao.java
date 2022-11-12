// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.api.GoogleApi;

public final class zao extends GoogleApi implements TelemetryLoggingClient
{
    private static final Api.ClientKey a;
    private static final Api.AbstractClientBuilder b;
    private static final Api c;
    public static final int d = 0;
    
    static {
        c = new Api("ClientTelemetry.API", b = new b(), a = new Api.ClientKey());
    }
    
    public zao(final Context context, final TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, zao.c, (Api.ApiOptions)telemetryLoggingOptions, Settings.c);
    }
    
    @Override
    public final Task<Void> a(final TelemetryData telemetryData) {
        final TaskApiCall.Builder<Api.AnyClient, Object> a = TaskApiCall.a();
        a.d(com.google.android.gms.internal.base.zaf.zaa);
        a.c(false);
        a.b(new zam(telemetryData));
        return this.doBestEffortWrite((TaskApiCall<Api.AnyClient, Void>)a.a());
    }
}
