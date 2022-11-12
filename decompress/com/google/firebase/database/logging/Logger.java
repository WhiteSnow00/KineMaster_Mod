// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.logging;

public interface Logger
{
    void a(final Level p0, final String p1, final String p2, final long p3);
    
    Level b();
    
    public enum Level
    {
        private static final Level[] $VALUES;
        
        DEBUG, 
        ERROR, 
        INFO, 
        NONE, 
        WARN;
    }
}
