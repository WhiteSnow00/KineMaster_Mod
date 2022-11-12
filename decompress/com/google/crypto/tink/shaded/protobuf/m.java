// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class m
{
    private static final k<?> a;
    private static final k<?> b;
    
    static {
        a = new l();
        b = c();
    }
    
    static k<?> a() {
        final k<?> b = m.b;
        if (b != null) {
            return b;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
    
    static k<?> b() {
        return m.a;
    }
    
    private static k<?> c() {
        try {
            return (k)Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            return null;
        }
    }
}
