// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class j
{
    static final Class<?> a;
    
    static {
        a = c();
    }
    
    public static ExtensionRegistryLite a() {
        ExtensionRegistryLite extensionRegistryLite = b("getEmptyRegistry");
        if (extensionRegistryLite == null) {
            extensionRegistryLite = ExtensionRegistryLite.d;
        }
        return extensionRegistryLite;
    }
    
    private static final ExtensionRegistryLite b(final String s) {
        final Class<?> a = j.a;
        if (a == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite)a.getDeclaredMethod(s, (Class[])new Class[0]).invoke(null, new Object[0]);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    static Class<?> c() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionRegistry");
        }
        catch (final ClassNotFoundException ex) {
            return null;
        }
    }
}
