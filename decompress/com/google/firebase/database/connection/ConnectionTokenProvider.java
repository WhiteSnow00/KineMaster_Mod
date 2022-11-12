// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

public interface ConnectionTokenProvider
{
    void a(final boolean p0, final GetTokenCallback p1);
    
    public interface GetTokenCallback
    {
        void a(final String p0);
        
        void g(final String p0);
    }
}
