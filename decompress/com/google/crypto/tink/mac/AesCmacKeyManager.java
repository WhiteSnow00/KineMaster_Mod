// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.mac;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.PrfAesCmac;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.proto.AesCmacKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesCmacKeyManager extends KeyTypeManager<AesCmacKey>
{
    AesCmacKeyManager() {
        super(AesCmacKey.class, (PrimitiveFactory<?, AesCmacKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Mac, AesCmacKey>(Mac.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesCmacKey)o);
                }
                
                public Mac c(final AesCmacKey aesCmacKey) throws GeneralSecurityException {
                    return new PrfMac(new PrfAesCmac(aesCmacKey.N().toByteArray()), aesCmacKey.O().M());
                }
            } });
    }
    
    static void j(final AesCmacParams aesCmacParams) throws GeneralSecurityException {
        p(aesCmacParams);
    }
    
    static void k(final int n) throws GeneralSecurityException {
        q(n);
    }
    
    public static void n(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new AesCmacKeyManager(), b);
    }
    
    private static void p(final AesCmacParams aesCmacParams) throws GeneralSecurityException {
        if (aesCmacParams.M() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (aesCmacParams.M() <= 16) {
            return;
        }
        throw new GeneralSecurityException("tag size too long");
    }
    
    private static void q(final int n) throws GeneralSecurityException {
        if (n == 32) {
            return;
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }
    
    @Override
    public KeyFactory<AesCmacKeyFormat, AesCmacKey> e() {
        return new KeyFactory<AesCmacKeyFormat, AesCmacKey>(this, AesCmacKeyFormat.class) {
            final AesCmacKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesCmacKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesCmacKeyFormat)messageLite);
            }
            
            public AesCmacKey e(final AesCmacKeyFormat aesCmacKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesCmacKey, BuilderType>)AesCmacKey.Q().F(0).D(ByteString.copyFrom(Random.c(aesCmacKeyFormat.M()))).E(aesCmacKeyFormat.N())).p();
            }
            
            public AesCmacKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesCmacKeyFormat.P(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesCmacKeyFormat aesCmacKeyFormat) throws GeneralSecurityException {
                AesCmacKeyManager.j(aesCmacKeyFormat.N());
                AesCmacKeyManager.k(aesCmacKeyFormat.M());
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.m(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.o((AesCmacKey)messageLite);
    }
    
    public int l() {
        return 0;
    }
    
    public AesCmacKey m(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesCmacKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void o(final AesCmacKey aesCmacKey) throws GeneralSecurityException {
        Validators.f(aesCmacKey.P(), this.l());
        q(aesCmacKey.N().size());
        p(aesCmacKey.O());
    }
}
