// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.util.Set;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.KeyData;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.shaded.protobuf.MessageLite;

@Alpha
public abstract class KeyTypeManager<KeyProtoT extends MessageLite>
{
    private final Class<KeyProtoT> a;
    private final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> b;
    private final Class<?> c;
    
    @SafeVarargs
    protected KeyTypeManager(final Class<KeyProtoT> a, final PrimitiveFactory<?, KeyProtoT>... array) {
        this.a = a;
        final HashMap hashMap = new HashMap();
        for (final PrimitiveFactory<?, KeyProtoT> primitiveFactory : array) {
            if (hashMap.containsKey(primitiveFactory.b())) {
                final StringBuilder sb = new StringBuilder();
                sb.append("KeyTypeManager constructed with duplicate factories for primitive ");
                sb.append(primitiveFactory.b().getCanonicalName());
                throw new IllegalArgumentException(sb.toString());
            }
            hashMap.put(primitiveFactory.b(), primitiveFactory);
        }
        if (array.length > 0) {
            this.c = array[0].b();
        }
        else {
            this.c = Void.class;
        }
        this.b = (Map<Class<?>, PrimitiveFactory<?, KeyProtoT>>)Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    final Class<?> a() {
        return this.c;
    }
    
    public final Class<KeyProtoT> b() {
        return this.a;
    }
    
    public abstract String c();
    
    public final <P> P d(final KeyProtoT keyProtoT, final Class<P> clazz) throws GeneralSecurityException {
        final PrimitiveFactory primitiveFactory = this.b.get(clazz);
        if (primitiveFactory != null) {
            return (P)primitiveFactory.a(keyProtoT);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Requested primitive class ");
        sb.append(clazz.getCanonicalName());
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public KeyFactory<?, KeyProtoT> e() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
    
    public abstract KeyData.KeyMaterialType f();
    
    public abstract KeyProtoT g(final ByteString p0) throws InvalidProtocolBufferException;
    
    public final Set<Class<?>> h() {
        return this.b.keySet();
    }
    
    public abstract void i(final KeyProtoT p0) throws GeneralSecurityException;
    
    public abstract static class KeyFactory<KeyFormatProtoT extends MessageLite, KeyT>
    {
        private final Class<KeyFormatProtoT> a;
        
        public KeyFactory(final Class<KeyFormatProtoT> a) {
            this.a = a;
        }
        
        public abstract KeyT a(final KeyFormatProtoT p0) throws GeneralSecurityException;
        
        public final Class<KeyFormatProtoT> b() {
            return this.a;
        }
        
        public abstract KeyFormatProtoT c(final ByteString p0) throws InvalidProtocolBufferException;
        
        public abstract void d(final KeyFormatProtoT p0) throws GeneralSecurityException;
    }
    
    protected abstract static class PrimitiveFactory<PrimitiveT, KeyT>
    {
        private final Class<PrimitiveT> a;
        
        public PrimitiveFactory(final Class<PrimitiveT> a) {
            this.a = a;
        }
        
        public abstract PrimitiveT a(final KeyT p0) throws GeneralSecurityException;
        
        final Class<PrimitiveT> b() {
            return this.a;
        }
    }
}
