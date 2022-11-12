// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import java.util.Map;
import java.util.List;

public interface PersistentConnection
{
    void a(final List<String> p0, final Map<String, Object> p1, final RequestResultCallback p2);
    
    void c(final List<String> p0, final Object p1, final String p2, final RequestResultCallback p3);
    
    void d(final List<String> p0, final Map<String, Object> p1, final ListenHashProvider p2, final Long p3, final RequestResultCallback p4);
    
    void f(final List<String> p0, final Map<String, Object> p1);
    
    void g(final String p0);
    
    void i(final String p0);
    
    void initialize();
    
    void j(final List<String> p0, final Object p1, final RequestResultCallback p2);
    
    void l(final String p0);
    
    void m(final String p0);
    
    public interface Delegate
    {
        void a();
        
        void b(final List<String> p0, final Object p1, final boolean p2, final Long p3);
        
        void c(final boolean p0);
        
        void d();
        
        void e(final Map<String, Object> p0);
        
        void f(final List<String> p0, final List<RangeMerge> p1, final Long p2);
    }
}
