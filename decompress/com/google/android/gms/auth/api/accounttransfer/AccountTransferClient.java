// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

public class AccountTransferClient extends GoogleApi<zzq>
{
    private static final Api.ClientKey<zzap> a;
    private static final Api.AbstractClientBuilder<zzap, zzq> b;
    private static final Api<zzq> c;
    
    static {
        c = new Api<zzq>("AccountTransfer.ACCOUNT_TRANSFER_API", b = new b(), a = new Api.ClientKey());
    }
}
