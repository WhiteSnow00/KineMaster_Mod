// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class f0
{
    private static final f0 c;
    private final k0 a;
    private final ConcurrentMap<Class<?>, j0<?>> b;
    
    static {
        c = new f0();
    }
    
    private f0() {
        this.b = new ConcurrentHashMap<Class<?>, j0<?>>();
        this.a = new s();
    }
    
    public static f0 a() {
        return f0.c;
    }
    
    public <T> void b(final T t, final i0 i0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        this.e(t).i(t, i0, extensionRegistryLite);
    }
    
    public j0<?> c(final Class<?> clazz, final j0<?> j0) {
        Internal.b(clazz, "messageType");
        Internal.b(j0, "schema");
        return this.b.putIfAbsent(clazz, j0);
    }
    
    public <T> j0<T> d(final Class<T> clazz) {
        Internal.b(clazz, "messageType");
        j0<T> a;
        if ((a = (j0)this.b.get(clazz)) == null) {
            a = this.a.a(clazz);
            final j0<?> c = this.c(clazz, a);
            if (c != null) {
                a = (j0<T>)c;
            }
        }
        return a;
    }
    
    public <T> j0<T> e(final T t) {
        return this.d(t.getClass());
    }
}
