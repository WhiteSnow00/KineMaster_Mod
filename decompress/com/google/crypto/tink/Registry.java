// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import java.util.Iterator;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.security.GeneralSecurityException;
import java.util.Set;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public final class Registry
{
    private static final Logger a;
    private static final ConcurrentMap<String, e> b;
    private static final ConcurrentMap<String, d> c;
    private static final ConcurrentMap<String, Boolean> d;
    private static final ConcurrentMap<String, Catalogue<?>> e;
    private static final ConcurrentMap<Class<?>, PrimitiveWrapper<?, ?>> f;
    
    static {
        a = Logger.getLogger(Registry.class.getName());
        b = new ConcurrentHashMap<String, e>();
        c = new ConcurrentHashMap<String, d>();
        d = new ConcurrentHashMap<String, Boolean>();
        e = new ConcurrentHashMap<String, Catalogue<?>>();
        f = new ConcurrentHashMap<Class<?>, PrimitiveWrapper<?, ?>>();
    }
    
    private Registry() {
    }
    
    private static <T> T a(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    private static <KeyProtoT extends MessageLite> e b(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return (e)new e(keyTypeManager) {
            final KeyTypeManager a;
            
            @Override
            public Class<?> a() {
                return null;
            }
            
            @Override
            public Class<?> b() {
                return this.a.getClass();
            }
            
            @Override
            public Set<Class<?>> c() {
                return this.a.h();
            }
            
            @Override
            public <Q> KeyManager<Q> d(final Class<Q> clazz) throws GeneralSecurityException {
                try {
                    return new KeyManagerImpl<Q, Object>(this.a, clazz);
                }
                catch (final IllegalArgumentException ex) {
                    throw new GeneralSecurityException("Primitive type not supported", ex);
                }
            }
            
            @Override
            public KeyManager<?> e() {
                final KeyTypeManager a = this.a;
                return new KeyManagerImpl<Object, Object>(a, a.a());
            }
        };
    }
    
    private static <KeyProtoT extends MessageLite> d c(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return (d)new d(keyTypeManager) {
            final KeyTypeManager a;
        };
    }
    
    private static <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> e d(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> keyTypeManager) {
        return (e)new e(privateKeyTypeManager, keyTypeManager) {
            final PrivateKeyTypeManager a;
            final KeyTypeManager b;
            
            @Override
            public Class<?> a() {
                return this.b.getClass();
            }
            
            @Override
            public Class<?> b() {
                return this.a.getClass();
            }
            
            @Override
            public Set<Class<?>> c() {
                return this.a.h();
            }
            
            @Override
            public <Q> KeyManager<Q> d(final Class<Q> clazz) throws GeneralSecurityException {
                try {
                    return (KeyManager<Q>)new PrivateKeyManagerImpl(this.a, this.b, (Class<Object>)clazz);
                }
                catch (final IllegalArgumentException ex) {
                    throw new GeneralSecurityException("Primitive type not supported", ex);
                }
            }
            
            @Override
            public KeyManager<?> e() {
                final PrivateKeyTypeManager a = this.a;
                return new PrivateKeyManagerImpl<Object, Object, Object>(a, this.b, a.a());
            }
        };
    }
    
    private static void e(final String s, final Class<?> clazz, final boolean b) throws GeneralSecurityException {
        synchronized (Registry.class) {
            final ConcurrentMap<String, e> b2 = Registry.b;
            if (!b2.containsKey(s)) {
                return;
            }
            final e e = (e)b2.get(s);
            if (!e.b().equals(clazz)) {
                final Logger a = Registry.a;
                final StringBuilder sb = new StringBuilder();
                sb.append("Attempted overwrite of a registered key manager for key type ");
                sb.append(s);
                a.warning(sb.toString());
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", s, e.b().getName(), clazz.getName()));
            }
            if (b && !Registry.d.get(s)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("New keys are already disallowed for key type ");
                sb2.append(s);
                throw new GeneralSecurityException(sb2.toString());
            }
        }
    }
    
    public static Class<?> f(final Class<?> clazz) {
        final PrimitiveWrapper primitiveWrapper = Registry.f.get(clazz);
        if (primitiveWrapper == null) {
            return null;
        }
        return primitiveWrapper.b();
    }
    
    private static e g(final String s) throws GeneralSecurityException {
        synchronized (Registry.class) {
            final ConcurrentMap<String, e> b = Registry.b;
            if (b.containsKey(s)) {
                return (e)b.get(s);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("No key manager found for key type ");
            sb.append(s);
            throw new GeneralSecurityException(sb.toString());
        }
    }
    
    private static <P> KeyManager<P> h(final String s, final Class<P> clazz) throws GeneralSecurityException {
        final e g = g(s);
        if (clazz == null) {
            return (KeyManager<P>)g.e();
        }
        if (g.c().contains(clazz)) {
            return g.d(clazz);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Primitive type ");
        sb.append(clazz.getName());
        sb.append(" not supported by key manager of type ");
        sb.append(g.b());
        sb.append(", supported primitives: ");
        sb.append(u(g.c()));
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static <P> P i(final String s, final ByteString byteString, final Class<P> clazz) throws GeneralSecurityException {
        return (P)k(s, byteString, (Class<Object>)a((Class<P>)clazz));
    }
    
    public static <P> P j(final String s, final byte[] array, final Class<P> clazz) throws GeneralSecurityException {
        return i(s, ByteString.copyFrom(array), clazz);
    }
    
    private static <P> P k(final String s, final ByteString byteString, final Class<P> clazz) throws GeneralSecurityException {
        return h(s, clazz).c(byteString);
    }
    
    public static <P> PrimitiveSet<P> l(final KeysetHandle keysetHandle, final KeyManager<P> keyManager, final Class<P> clazz) throws GeneralSecurityException {
        return (PrimitiveSet<P>)n(keysetHandle, (KeyManager<Object>)keyManager, (Class<Object>)a((Class<P>)clazz));
    }
    
    public static <P> PrimitiveSet<P> m(final KeysetHandle keysetHandle, final Class<P> clazz) throws GeneralSecurityException {
        return l(keysetHandle, null, clazz);
    }
    
    private static <P> PrimitiveSet<P> n(final KeysetHandle keysetHandle, final KeyManager<P> keyManager, final Class<P> clazz) throws GeneralSecurityException {
        com.google.crypto.tink.a.e(keysetHandle.f());
        final PrimitiveSet<P> f = PrimitiveSet.f(clazz);
        for (final Keyset.Key key : keysetHandle.f().Q()) {
            if (key.R() == KeyStatusType.ENABLED) {
                Object o;
                if (keyManager != null && keyManager.a(key.O().P())) {
                    o = keyManager.c(key.O().Q());
                }
                else {
                    o = k(key.O().P(), key.O().Q(), clazz);
                }
                final PrimitiveSet.Entry<P> a = f.a((P)o, key);
                if (key.P() != keysetHandle.f().R()) {
                    continue;
                }
                f.g(a);
            }
        }
        return f;
    }
    
    public static KeyManager<?> o(final String s) throws GeneralSecurityException {
        return g(s).e();
    }
    
    public static MessageLite p(final KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (Registry.class) {
            final KeyManager<?> o = o(keyTemplate.P());
            if (Registry.d.get(keyTemplate.P())) {
                return o.d(keyTemplate.Q());
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("newKey-operation not permitted for key type ");
            sb.append(keyTemplate.P());
            throw new GeneralSecurityException(sb.toString());
        }
    }
    
    public static KeyData q(final KeyTemplate keyTemplate) throws GeneralSecurityException {
        synchronized (Registry.class) {
            final KeyManager<?> o = o(keyTemplate.P());
            if (Registry.d.get(keyTemplate.P())) {
                return o.b(keyTemplate.Q());
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("newKey-operation not permitted for key type ");
            sb.append(keyTemplate.P());
            throw new GeneralSecurityException(sb.toString());
        }
    }
    
    public static <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void r(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> keyTypeManager, final boolean b) throws GeneralSecurityException {
        monitorenter(Registry.class);
        Label_0338: {
            if (privateKeyTypeManager == null || keyTypeManager == null) {
                break Label_0338;
            }
            try {
                final String c = privateKeyTypeManager.c();
                final String c2 = keyTypeManager.c();
                e(c, privateKeyTypeManager.getClass(), b);
                e(c2, keyTypeManager.getClass(), false);
                if (!c.equals(c2)) {
                    final ConcurrentMap<String, e> b2 = Registry.b;
                    if (b2.containsKey(c)) {
                        final Class<?> a = ((e)b2.get(c)).a();
                        if (a != null) {
                            if (!a.equals(keyTypeManager.getClass())) {
                                final Logger a2 = Registry.a;
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Attempted overwrite of a registered key manager for key type ");
                                sb.append(c);
                                sb.append(" with inconsistent public key type ");
                                sb.append(c2);
                                a2.warning(sb.toString());
                                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", privateKeyTypeManager.getClass().getName(), a.getName(), keyTypeManager.getClass().getName()));
                            }
                        }
                    }
                    if (!b2.containsKey(c) || ((e)b2.get(c)).a() == null) {
                        b2.put(c, d(privateKeyTypeManager, keyTypeManager));
                        Registry.c.put(c, c((KeyTypeManager<MessageLite>)privateKeyTypeManager));
                    }
                    final ConcurrentMap<String, Boolean> d = Registry.d;
                    d.put(c, b);
                    if (!b2.containsKey(c2)) {
                        b2.put((Object)c2, (Object)b(keyTypeManager));
                    }
                    d.put(c2, Boolean.FALSE);
                    return;
                }
                throw new GeneralSecurityException("Private and public key type must be different.");
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            finally {
                monitorexit(Registry.class);
            }
        }
    }
    
    public static <KeyProtoT extends MessageLite> void s(final KeyTypeManager<KeyProtoT> keyTypeManager, final boolean b) throws GeneralSecurityException {
        monitorenter(Registry.class);
        if (keyTypeManager != null) {
            Label_0096: {
                try {
                    final String c = keyTypeManager.c();
                    e(c, keyTypeManager.getClass(), b);
                    final ConcurrentMap<String, e> b2 = Registry.b;
                    if (!b2.containsKey(c)) {
                        b2.put((Object)c, (Object)b(keyTypeManager));
                        Registry.c.put(c, c(keyTypeManager));
                    }
                    Registry.d.put(c, b);
                    monitorexit(Registry.class);
                    return;
                }
                finally {
                    break Label_0096;
                }
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            monitorexit(Registry.class);
        }
        throw new IllegalArgumentException("key manager must be non-null.");
    }
    
    public static <B, P> void t(final PrimitiveWrapper<B, P> primitiveWrapper) throws GeneralSecurityException {
        monitorenter(Registry.class);
        if (primitiveWrapper != null) {
            Label_0172: {
                try {
                    final Class<P> c = primitiveWrapper.c();
                    final ConcurrentMap<Class<?>, PrimitiveWrapper<?, ?>> f = Registry.f;
                    if (f.containsKey(c)) {
                        final PrimitiveWrapper primitiveWrapper2 = f.get(c);
                        if (!primitiveWrapper.getClass().equals(primitiveWrapper2.getClass())) {
                            final Logger a = Registry.a;
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Attempted overwrite of a registered SetWrapper for type ");
                            sb.append(c);
                            a.warning(sb.toString());
                            throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", c.getName(), primitiveWrapper2.getClass().getName(), primitiveWrapper.getClass().getName()));
                        }
                    }
                    f.put(c, primitiveWrapper);
                    monitorexit(Registry.class);
                    return;
                }
                finally {
                    break Label_0172;
                }
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            monitorexit(Registry.class);
        }
        throw new IllegalArgumentException("wrapper must be non-null");
    }
    
    private static String u(final Set<Class<?>> set) {
        final StringBuilder sb = new StringBuilder();
        final Iterator<Class<?>> iterator = set.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final Class clazz = iterator.next();
            if (n == 0) {
                sb.append(", ");
            }
            sb.append(clazz.getCanonicalName());
            n = 0;
        }
        return sb.toString();
    }
    
    public static <B, P> P v(final PrimitiveSet<B> set, final Class<P> clazz) throws GeneralSecurityException {
        final PrimitiveWrapper primitiveWrapper = Registry.f.get(clazz);
        if (primitiveWrapper == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("No wrapper found for ");
            sb.append(set.d().getName());
            throw new GeneralSecurityException(sb.toString());
        }
        if (primitiveWrapper.b().equals(set.d())) {
            return (P)primitiveWrapper.a(set);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Wrong input primitive class, expected ");
        sb2.append(primitiveWrapper.b());
        sb2.append(", got ");
        sb2.append(set.d());
        throw new GeneralSecurityException(sb2.toString());
    }
    
    private interface d
    {
    }
    
    private interface e
    {
        Class<?> a();
        
        Class<?> b();
        
        Set<Class<?>> c();
        
         <P> KeyManager<P> d(final Class<P> p0) throws GeneralSecurityException;
        
        KeyManager<?> e();
    }
}
