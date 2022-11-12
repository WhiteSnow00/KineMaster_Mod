// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class b implements ResultConverter
{
    b(final zba zba) {
    }
    
    @Override
    public final Object a(final Result result) {
        return ((GoogleSignInResult)result).a();
    }
}
