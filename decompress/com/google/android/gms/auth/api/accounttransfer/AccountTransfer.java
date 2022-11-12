// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzao;
import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.common.api.Api;

public final class AccountTransfer
{
    private static final Api.ClientKey<zzap> a;
    private static final Api.AbstractClientBuilder<zzap, zzq> b;
    public static final Api<zzq> c;
    @Deprecated
    public static final zzao d;
    @Deprecated
    public static final zzao e;
    
    static {
        c = new Api<zzq>("AccountTransfer.ACCOUNT_TRANSFER_API", b = new a(), a = new Api.ClientKey());
        d = new zzao();
        e = new zzao();
    }
    
    private AccountTransfer() {
    }
}
