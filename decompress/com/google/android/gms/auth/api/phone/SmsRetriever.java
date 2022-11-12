// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.phone;

import com.google.android.gms.internal.auth_api_phone.zzab;
import android.content.Context;

public final class SmsRetriever
{
    private SmsRetriever() {
    }
    
    public static SmsRetrieverClient a(final Context context) {
        return (SmsRetrieverClient)new zzab(context);
    }
}
