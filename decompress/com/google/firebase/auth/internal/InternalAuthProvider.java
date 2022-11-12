// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.auth.GetTokenResult;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.internal.InternalTokenProvider;

@KeepForSdk
public interface InternalAuthProvider extends InternalTokenProvider
{
    @KeepForSdk
    Task<GetTokenResult> a(final boolean p0);
    
    @KeepForSdk
    @DeferredApi
    void b(final IdTokenListener p0);
}
