// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.AesEaxJce;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.AesEaxKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesEaxKeyManager extends KeyTypeManager<AesEaxKey>
{
    AesEaxKeyManager() {
        super(AesEaxKey.class, (PrimitiveFactory<?, AesEaxKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, AesEaxKey>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesEaxKey)o);
                }
                
                public Aead c(final AesEaxKey aesEaxKey) throws GeneralSecurityException {
                    return new AesEaxJce(aesEaxKey.N().toByteArray(), aesEaxKey.O().M());
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new AesEaxKeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }
    
    @Override
    public KeyFactory<AesEaxKeyFormat, AesEaxKey> e() {
        return new KeyFactory<AesEaxKeyFormat, AesEaxKey>(this, AesEaxKeyFormat.class) {
            final AesEaxKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesEaxKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesEaxKeyFormat)messageLite);
            }
            
            public AesEaxKey e(final AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesEaxKey, BuilderType>)AesEaxKey.Q().D(ByteString.copyFrom(Random.c(aesEaxKeyFormat.M()))).E(aesEaxKeyFormat.N()).F(this.b.j())).p();
            }
            
            public AesEaxKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesEaxKeyFormat.P(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesEaxKeyFormat aesEaxKeyFormat) throws GeneralSecurityException {
                Validators.a(aesEaxKeyFormat.M());
                if (aesEaxKeyFormat.N().M() != 12 && aesEaxKeyFormat.N().M() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.k(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.m((AesEaxKey)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public AesEaxKey k(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesEaxKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final AesEaxKey aesEaxKey) throws GeneralSecurityException {
        Validators.f(aesEaxKey.P(), this.j());
        Validators.a(aesEaxKey.N().size());
        if (aesEaxKey.O().M() != 12 && aesEaxKey.O().M() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
