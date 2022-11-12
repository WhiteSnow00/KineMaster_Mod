// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.tubesock;

public class WebSocketMessage
{
    private byte[] a;
    private String b;
    private byte c;
    
    public WebSocketMessage(final String b) {
        this.b = b;
        this.c = 1;
    }
    
    public WebSocketMessage(final byte[] a) {
        this.a = a;
        this.c = 2;
    }
    
    public String a() {
        return this.b;
    }
}
