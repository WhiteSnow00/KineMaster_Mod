// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;
import java.io.FileDescriptor;

public interface zaca
{
    void a();
    
    void b();
    
    void c();
    
    void d();
    
    boolean e(final SignInConnectionListener p0);
    
    void f(final String p0, final FileDescriptor p1, final PrintWriter p2, final String[] p3);
    
    ConnectionResult g(final long p0, final TimeUnit p1);
    
    BaseImplementation.ApiMethodImpl h(final BaseImplementation.ApiMethodImpl p0);
    
    boolean i();
    
    BaseImplementation.ApiMethodImpl j(final BaseImplementation.ApiMethodImpl p0);
}
