// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

public class Response<T extends Result>
{
    private Result a;
    
    protected T a() {
        return (T)this.a;
    }
    
    public void e(final T a) {
        this.a = a;
    }
}
