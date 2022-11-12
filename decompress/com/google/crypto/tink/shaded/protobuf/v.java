// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class v
{
    private static final t a;
    private static final t b;
    
    static {
        a = c();
        b = new u();
    }
    
    static t a() {
        return v.a;
    }
    
    static t b() {
        return v.b;
    }
    
    private static t c() {
        try {
            return (t)Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            return null;
        }
    }
}
