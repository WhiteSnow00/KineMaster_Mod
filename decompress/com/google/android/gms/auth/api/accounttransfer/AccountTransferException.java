// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ApiException;

public class AccountTransferException extends ApiException
{
    public AccountTransferException(final Status status) {
        super(status);
    }
}
