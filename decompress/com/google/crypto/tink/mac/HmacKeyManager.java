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
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.prf.Prf;
import com.google.crypto.tink.subtle.PrfMac;
import java.security.Key;
import com.google.crypto.tink.subtle.PrfHmacJce;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.KeyTypeManager;

public final class HmacKeyManager extends KeyTypeManager<HmacKey>
{
    public HmacKeyManager() {
        super(HmacKey.class, (PrimitiveFactory<?, HmacKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Mac, HmacKey>(Mac.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((HmacKey)o);
                }
                
                public Mac c(final HmacKey hmacKey) throws GeneralSecurityException {
                    final HashType n = hmacKey.P().N();
                    final SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey.O().toByteArray(), "HMAC");
                    final int o = hmacKey.P().O();
                    final int n2 = HmacKeyManager$c.a[n.ordinal()];
                    if (n2 == 1) {
                        return new PrfMac(new PrfHmacJce("HMACSHA1", secretKeySpec), o);
                    }
                    if (n2 == 2) {
                        return new PrfMac(new PrfHmacJce("HMACSHA256", secretKeySpec), o);
                    }
                    if (n2 == 3) {
                        return new PrfMac(new PrfHmacJce("HMACSHA512", secretKeySpec), o);
                    }
                    throw new GeneralSecurityException("unknown hash");
                }
            } });
    }
    
    static void j(final HmacParams hmacParams) throws GeneralSecurityException {
        o(hmacParams);
    }
    
    public static void m(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new HmacKeyManager(), b);
    }
    
    private static void o(final HmacParams hmacParams) throws GeneralSecurityException {
        if (hmacParams.O() >= 10) {
            final int n = HmacKeyManager$c.a[hmacParams.N().ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    }
                    if (hmacParams.O() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                }
                else if (hmacParams.O() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            }
            else if (hmacParams.O() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        throw new GeneralSecurityException("tag size too small");
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }
    
    @Override
    public KeyFactory<HmacKeyFormat, HmacKey> e() {
        return new KeyFactory<HmacKeyFormat, HmacKey>(this, HmacKeyFormat.class) {
            final HmacKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((HmacKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((HmacKeyFormat)messageLite);
            }
            
            public HmacKey e(final HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<HmacKey, BuilderType>)HmacKey.R().F(this.b.k()).E(hmacKeyFormat.O()).D(ByteString.copyFrom(Random.c(hmacKeyFormat.N())))).p();
            }
            
            public HmacKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return HmacKeyFormat.Q(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
                if (hmacKeyFormat.N() >= 16) {
                    HmacKeyManager.j(hmacKeyFormat.O());
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
        this.n((HmacKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public HmacKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return HmacKey.S(byteString, ExtensionRegistryLite.b());
    }
    
    public void n(final HmacKey hmacKey) throws GeneralSecurityException {
        Validators.f(hmacKey.Q(), this.k());
        if (hmacKey.O().size() >= 16) {
            o(hmacKey.P());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
