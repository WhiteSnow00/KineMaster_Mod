// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class b
{
    private static final Class<?> a;
    private static final boolean b;
    
    static {
        a = a("libcore.io.Memory");
        b = (a("org.robolectric.Robolectric") != null);
    }
    
    private static <T> Class<T> a(final String s) {
        try {
            return (Class<T>)Class.forName(s);
        }
        finally {
            return null;
        }
    }
    
    static Class<?> b() {
        return com.google.crypto.tink.shaded.protobuf.b.a;
    }
    
    static boolean c() {
        return com.google.crypto.tink.shaded.protobuf.b.a != null && !com.google.crypto.tink.shaded.protobuf.b.b;
    }
}
