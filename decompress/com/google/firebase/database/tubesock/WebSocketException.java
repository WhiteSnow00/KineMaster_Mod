// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.tubesock;

public class WebSocketException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public WebSocketException(final String s) {
        super(s);
    }
    
    public WebSocketException(final String s, final Throwable t) {
        super(s, t);
    }
}
