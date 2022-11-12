// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class d0
{
    private static final b0 a;
    private static final b0 b;
    
    static {
        a = c();
        b = new c0();
    }
    
    static b0 a() {
        return d0.a;
    }
    
    static b0 b() {
        return d0.b;
    }
    
    private static b0 c() {
        try {
            return (b0)Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            return null;
        }
    }
}
