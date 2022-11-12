// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class s implements k0
{
    private static final x b;
    private final x a;
    
    static {
        b = new x() {
            @Override
            public w a(final Class<?> clazz) {
                throw new IllegalStateException("This should never be called.");
            }
            
            @Override
            public boolean b(final Class<?> clazz) {
                return false;
            }
        };
    }
    
    public s() {
        this(b());
    }
    
    private s(final x x) {
        this.a = Internal.b(x, "messageInfoFactory");
    }
    
    private static x b() {
        return new b(new x[] { o.c(), c() });
    }
    
    private static x c() {
        try {
            return (x)Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
        }
        catch (final Exception ex) {
            return s.b;
        }
    }
    
    private static boolean d(final w w) {
        return w.c() == ProtoSyntax.PROTO2;
    }
    
    private static <T> j0<T> e(final Class<T> clazz, final w w) {
        if (GeneratedMessageLite.class.isAssignableFrom(clazz)) {
            z<T> z;
            if (d(w)) {
                z = com.google.crypto.tink.shaded.protobuf.z.Q(clazz, w, d0.b(), q.b(), l0.M(), m.b(), v.b());
            }
            else {
                z = com.google.crypto.tink.shaded.protobuf.z.Q(clazz, w, d0.b(), q.b(), l0.M(), null, v.b());
            }
            return z;
        }
        z<T> z2;
        if (d(w)) {
            z2 = z.Q(clazz, w, d0.a(), q.a(), l0.H(), m.a(), v.a());
        }
        else {
            z2 = z.Q(clazz, w, d0.a(), q.a(), l0.I(), null, v.a());
        }
        return z2;
    }
    
    @Override
    public <T> j0<T> a(final Class<T> clazz) {
        l0.J(clazz);
        final w a = this.a.a(clazz);
        if (!a.a()) {
            return e(clazz, a);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(clazz)) {
            return (j0<T>)a0.m(l0.M(), m.b(), a.b());
        }
        return (j0<T>)a0.m(l0.H(), m.a(), a.b());
    }
    
    private static class b implements x
    {
        private x[] a;
        
        b(final x... a) {
            this.a = a;
        }
        
        @Override
        public w a(final Class<?> clazz) {
            for (final x x : this.a) {
                if (x.b(clazz)) {
                    return x.a(clazz);
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No factory is available for message type: ");
            sb.append(clazz.getName());
            throw new UnsupportedOperationException(sb.toString());
        }
        
        @Override
        public boolean b(final Class<?> clazz) {
            final x[] a = this.a;
            for (int length = a.length, i = 0; i < length; ++i) {
                if (a[i].b(clazz)) {
                    return true;
                }
            }
            return false;
        }
    }
}
