// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Response;

final class g implements ResultConverter
{
    final Response a;
    
    g(final Response a) {
        this.a = a;
    }
    
    @Override
    public final /* bridge */ Object a(final Result result) {
        this.a.e(result);
        return this.a;
    }
}
