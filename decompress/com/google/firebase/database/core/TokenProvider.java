// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.concurrent.ExecutorService;

public interface TokenProvider
{
    void a(final boolean p0, final GetTokenCompletionListener p1);
    
    void b(final ExecutorService p0, final TokenChangeListener p1);
    
    public interface GetTokenCompletionListener
    {
        void a(final String p0);
        
        void g(final String p0);
    }
    
    public interface TokenChangeListener
    {
        void a(final String p0);
    }
}
