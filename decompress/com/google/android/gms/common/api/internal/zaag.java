// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.api.GoogleApiClient;

public class zaag extends GoogleApiClient
{
    private final String b;
    
    public zaag(final String s) {
        this.b = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";
    }
    
    @Override
    public final ConnectionResult d(final long n, final TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.b);
    }
    
    @Override
    public final void e() {
        throw new UnsupportedOperationException(this.b);
    }
    
    @Override
    public final void f() {
        throw new UnsupportedOperationException(this.b);
    }
    
    @Override
    public final void g(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        throw new UnsupportedOperationException(this.b);
    }
    
    @Override
    public final void p(final OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.b);
    }
    
    @Override
    public final void q(final OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.b);
    }
}
