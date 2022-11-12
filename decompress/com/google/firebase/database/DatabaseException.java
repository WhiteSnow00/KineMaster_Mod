// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

public class DatabaseException extends RuntimeException
{
    public DatabaseException(final String s) {
        super(s);
    }
    
    public DatabaseException(final String s, final Throwable t) {
        super(s, t);
    }
}
