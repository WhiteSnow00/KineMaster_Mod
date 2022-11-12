// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L>
{
    @KeepForSdk
    public final RegisterListenerMethod<A, L> a;
    public final UnregisterListenerMethod b;
    public final Runnable c;
    
    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L>
    {
        private Runnable a;
        private boolean b;
        
        private Builder() {
            this.a = zacj.a;
            this.b = true;
        }
    }
}
