// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.android.gms.common.internal.Preconditions;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT>
{
    private final Feature[] a;
    private final boolean b;
    private final int c;
    
    @Deprecated
    @KeepForSdk
    public TaskApiCall() {
        this.a = null;
        this.b = false;
        this.c = 0;
    }
    
    @KeepForSdk
    protected TaskApiCall(final Feature[] a, final boolean b, final int c) {
        this.a = a;
        boolean b2 = false;
        if (a != null) {
            b2 = b2;
            if (b) {
                b2 = true;
            }
        }
        this.b = b2;
        this.c = c;
    }
    
    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> a() {
        return new Builder<A, ResultT>(null);
    }
    
    @KeepForSdk
    protected abstract void b(final A p0, final TaskCompletionSource<ResultT> p1) throws RemoteException;
    
    @KeepForSdk
    public boolean c() {
        return this.b;
    }
    
    public final int d() {
        return this.c;
    }
    
    public final Feature[] e() {
        return this.a;
    }
    
    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, ResultT>
    {
        private RemoteCall a;
        private boolean b;
        private Feature[] c;
        private int d;
        
        private Builder() {
            this.b = true;
            this.d = 0;
        }
        
        Builder(final zacw zacw) {
            this.b = true;
            this.d = 0;
        }
        
        static /* bridge */ RemoteCall f(final Builder builder) {
            return builder.a;
        }
        
        @KeepForSdk
        public TaskApiCall<A, ResultT> a() {
            Preconditions.b(this.a != null, "execute parameter required");
            return new h0(this, this.c, this.b, this.d);
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public Builder<A, ResultT> b(final RemoteCall<A, TaskCompletionSource<ResultT>> a) {
            this.a = a;
            return this;
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public Builder<A, ResultT> c(final boolean b) {
            this.b = b;
            return this;
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public Builder<A, ResultT> d(final Feature... c) {
            this.c = c;
            return this;
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public Builder<A, ResultT> e(final int d) {
            this.d = d;
            return this;
        }
    }
}
