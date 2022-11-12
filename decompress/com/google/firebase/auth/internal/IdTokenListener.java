// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.internal.InternalTokenResult;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface IdTokenListener
{
    @KeepForSdk
    void a(final InternalTokenResult p0);
}
