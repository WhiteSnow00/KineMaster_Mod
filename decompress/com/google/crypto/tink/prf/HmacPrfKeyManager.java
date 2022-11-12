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
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.HashType;
import java.security.Key;
import com.google.crypto.tink.subtle.PrfHmacJce;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.HmacPrfKey;
import com.google.crypto.tink.KeyTypeManager;

public final class HmacPrfKeyManager extends KeyTypeManager<HmacPrfKey>
{
    public HmacPrfKeyManager() {
        super(HmacPrfKey.class, (PrimitiveFactory<?, HmacPrfKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Prf, HmacPrfKey>(Prf.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((HmacPrfKey)o);
                }
                
                public Prf c(final HmacPrfKey hmacPrfKey) throws GeneralSecurityException {
                    final HashType m = hmacPrfKey.O().M();
                    final SecretKeySpec secretKeySpec = new SecretKeySpec(hmacPrfKey.N().toByteArray(), "HMAC");
                    final int n = HmacPrfKeyManager$c.a[m.ordinal()];
                    if (n == 1) {
                        return new PrfHmacJce("HMACSHA1", secretKeySpec);
                    }
                    if (n == 2) {
                        return new PrfHmacJce("HMACSHA256", secretKeySpec);
                    }
                    if (n == 3) {
                        return new PrfHmacJce("HMACSHA512", secretKeySpec);
                    }
                    throw new GeneralSecurityException("unknown hash");
                }
            } });
    }
    
    static void j(final HmacPrfParams hmacPrfParams) throws GeneralSecurityException {
        n(hmacPrfParams);
    }
    
    private static void n(final HmacPrfParams hmacPrfParams) throws GeneralSecurityException {
        if (hmacPrfParams.M() != HashType.SHA1 && hmacPrfParams.M() != HashType.SHA256 && hmacPrfParams.M() != HashType.SHA512) {
            throw new GeneralSecurityException("unknown hash type");
        }
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HmacPrfKey";
    }
    
    @Override
    public KeyFactory<HmacPrfKeyFormat, HmacPrfKey> e() {
        return new KeyFactory<HmacPrfKeyFormat, HmacPrfKey>(this, HmacPrfKeyFormat.class) {
            final HmacPrfKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((HmacPrfKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((HmacPrfKeyFormat)messageLite);
            }
            
            public HmacPrfKey e(final HmacPrfKeyFormat hmacPrfKeyFormat) {
                return ((GeneratedMessageLite.Builder<HmacPrfKey, BuilderType>)HmacPrfKey.Q().F(this.b.k()).E(hmacPrfKeyFormat.N()).D(ByteString.copyFrom(Random.c(hmacPrfKeyFormat.M())))).p();
            }
            
            public HmacPrfKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return HmacPrfKeyFormat.P(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final HmacPrfKeyFormat hmacPrfKeyFormat) throws GeneralSecurityException {
                if (hmacPrfKeyFormat.M() >= 16) {
                    HmacPrfKeyManager.j(hmacPrfKeyFormat.N());
                    return;
                }
                throw new GeneralSecurityException("key too short");
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
        this.m((HmacPrfKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public HmacPrfKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return HmacPrfKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final HmacPrfKey hmacPrfKey) throws GeneralSecurityException {
        Validators.f(hmacPrfKey.P(), this.k());
        if (hmacPrfKey.N().size() >= 16) {
            n(hmacPrfKey.O());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
