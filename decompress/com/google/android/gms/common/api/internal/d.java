// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

final class d
{
    private final ApiKey a;
    private final TaskCompletionSource b;
    
    public d(final ApiKey a) {
        this.b = new TaskCompletionSource();
        this.a = a;
    }
    
    public final ApiKey a() {
        return this.a;
    }
    
    public final TaskCompletionSource b() {
        return this.b;
    }
}
