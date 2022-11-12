// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.prf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import com.google.crypto.tink.subtle.PrfAesCmac;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.AesCmacPrfKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesCmacPrfKeyManager extends KeyTypeManager<AesCmacPrfKey>
{
    AesCmacPrfKeyManager() {
        super(AesCmacPrfKey.class, (PrimitiveFactory<?, AesCmacPrfKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Prf, AesCmacPrfKey>(Prf.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesCmacPrfKey)o);
                }
                
                public Prf c(final AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
                    return new PrfAesCmac(aesCmacPrfKey.M().toByteArray());
                }
            } });
    }
    
    static void j(final int n) throws GeneralSecurityException {
        n(n);
    }
    
    private static void n(final int n) throws GeneralSecurityException {
        if (n == 32) {
            return;
        }
        throw new GeneralSecurityException("AesCmacPrfKey size wrong, must be 32 bytes");
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCmacPrfKey";
    }
    
    @Override
    public KeyFactory<AesCmacPrfKeyFormat, AesCmacPrfKey> e() {
        return new KeyFactory<AesCmacPrfKeyFormat, AesCmacPrfKey>(this, AesCmacPrfKeyFormat.class) {
            final AesCmacPrfKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesCmacPrfKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesCmacPrfKeyFormat)messageLite);
            }
            
            public AesCmacPrfKey e(final AesCmacPrfKeyFormat aesCmacPrfKeyFormat) {
                return ((GeneratedMessageLite.Builder<AesCmacPrfKey, BuilderType>)AesCmacPrfKey.O().E(0).D(ByteString.copyFrom(Random.c(aesCmacPrfKeyFormat.L())))).p();
            }
            
            public AesCmacPrfKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesCmacPrfKeyFormat.N(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesCmacPrfKeyFormat aesCmacPrfKeyFormat) throws GeneralSecurityException {
                AesCmacPrfKeyManager.j(aesCmacPrfKeyFormat.L());
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.l(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.m((AesCmacPrfKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public AesCmacPrfKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesCmacPrfKey.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
        Validators.f(aesCmacPrfKey.N(), this.k());
        n(aesCmacPrfKey.M().size());
    }
}
