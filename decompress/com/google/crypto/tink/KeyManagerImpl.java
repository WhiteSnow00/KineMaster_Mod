// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.shaded.protobuf.MessageLite;

@Alpha
public class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT>
{
    private final KeyTypeManager<KeyProtoT> a;
    private final Class<PrimitiveT> b;
    
    public KeyManagerImpl(final KeyTypeManager<KeyProtoT> a, final Class<PrimitiveT> b) {
        if (!a.h().contains(b) && !Void.class.equals(b)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", a.toString(), b.getName()));
        }
        this.a = a;
        this.b = b;
    }
    
    private a<?, KeyProtoT> f() {
        return new a<Object, KeyProtoT>(this.a.e());
    }
    
    private PrimitiveT g(final KeyProtoT keyProtoT) throws GeneralSecurityException {
        if (!Void.class.equals(this.b)) {
            this.a.i(keyProtoT);
            return this.a.d(keyProtoT, this.b);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }
    
    @Override
    public final boolean a(final String s) {
        return s.equals(this.e());
    }
    
    @Override
    public final KeyData b(final ByteString byteString) throws GeneralSecurityException {
        try {
            return ((GeneratedMessageLite.Builder<KeyData, BuilderType>)KeyData.R().E(this.e()).F(this.f().a(byteString).b()).D(this.a.f())).p();
        }
        catch (final InvalidProtocolBufferException ex) {
            throw new GeneralSecurityException("Unexpected proto", ex);
        }
    }
    
    @Override
    public final PrimitiveT c(final ByteString byteString) throws GeneralSecurityException {
        try {
            return this.g(this.a.g(byteString));
        }
        catch (final InvalidProtocolBufferException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failures parsing proto of type ");
            sb.append(this.a.b().getName());
            throw new GeneralSecurityException(sb.toString(), ex);
        }
    }
    
    @Override
    public final MessageLite d(final ByteString byteString) throws GeneralSecurityException {
        try {
            return this.f().a(byteString);
        }
        catch (final InvalidProtocolBufferException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failures parsing proto of type ");
            sb.append(this.a.e().b().getName());
            throw new GeneralSecurityException(sb.toString(), ex);
        }
    }
    
    public final String e() {
        return this.a.c();
    }
    
    private static class a<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite>
    {
        final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> a;
        
        a(final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> a) {
            this.a = a;
        }
        
        private KeyProtoT b(final KeyFormatProtoT keyFormatProtoT) throws GeneralSecurityException {
            this.a.d(keyFormatProtoT);
            return this.a.a(keyFormatProtoT);
        }
        
        KeyProtoT a(final ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
            return this.b(this.a.c(byteString));
        }
    }
}
