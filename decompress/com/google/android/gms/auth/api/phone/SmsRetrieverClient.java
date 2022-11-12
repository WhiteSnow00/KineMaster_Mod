// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.phone;

import com.google.android.gms.tasks.Task;
import android.content.Context;
import android.app.Activity;
import com.google.android.gms.internal.auth_api_phone.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

public abstract class SmsRetrieverClient extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsRetrieverApi
{
    private static final Api.ClientKey<zzw> zza;
    private static final Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;
    
    static {
        zzc = new Api<Api.ApiOptions.NoOptions>("SmsRetriever.API", zzb = new a(), zza = new Api.ClientKey());
    }
    
    public SmsRetrieverClient(final Activity activity) {
        super(activity, (Api<Api.ApiOptions>)SmsRetrieverClient.zzc, (Api.ApiOptions)Api.ApiOptions.o, Settings.c);
    }
    
    public SmsRetrieverClient(final Context context) {
        super(context, (Api<Api.ApiOptions>)SmsRetrieverClient.zzc, (Api.ApiOptions)Api.ApiOptions.o, Settings.c);
    }
    
    public abstract Task<Void> startSmsRetriever();
    
    public abstract Task<Void> startSmsUserConsent(final String p0);
}
