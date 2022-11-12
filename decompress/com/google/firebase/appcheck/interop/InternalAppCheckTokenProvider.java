// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.appcheck.interop;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.android.gms.tasks.Task;

public interface InternalAppCheckTokenProvider
{
    Task<AppCheckTokenResult> a(final boolean p0);
    
    void b(final AppCheckTokenListener p0);
}
