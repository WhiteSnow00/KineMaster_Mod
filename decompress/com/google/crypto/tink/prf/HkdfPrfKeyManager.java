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
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.subtle.prf.PrfImpl;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.subtle.prf.StreamingPrf;
import com.google.crypto.tink.proto.HkdfPrfKey;
import com.google.crypto.tink.KeyTypeManager;

public class HkdfPrfKeyManager extends KeyTypeManager<HkdfPrfKey>
{
    HkdfPrfKeyManager() {
        super(HkdfPrfKey.class, (PrimitiveFactory<?, HkdfPrfKey>[])new PrimitiveFactory[] { new PrimitiveFactory<StreamingPrf, HkdfPrfKey>(StreamingPrf.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((HkdfPrfKey)o);
                }
                
                public StreamingPrf c(final HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
                    return new HkdfStreamingPrf(HkdfPrfKeyManager.j(hkdfPrfKey.O().M()), hkdfPrfKey.N().toByteArray(), hkdfPrfKey.O().N().toByteArray());
                }
            }, new PrimitiveFactory<Prf, HkdfPrfKey>(Prf.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((HkdfPrfKey)o);
                }
                
                public Prf c(final HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
                    return PrfImpl.c(new HkdfStreamingPrf(HkdfPrfKeyManager.j(hkdfPrfKey.O().M()), hkdfPrfKey.N().toByteArray(), hkdfPrfKey.O().N().toByteArray()));
                }
            } });
    }
    
    static Enums.HashType j(final HashType hashType) throws GeneralSecurityException {
        return m(hashType);
    }
    
    static void k(final int n) throws GeneralSecurityException {
        r(n);
    }
    
    static void l(final HkdfPrfParams hkdfPrfParams) throws GeneralSecurityException {
        s(hkdfPrfParams);
    }
    
    private static Enums.HashType m(final HashType hashType) throws GeneralSecurityException {
        final int n = HkdfPrfKeyManager$d.a[hashType.ordinal()];
        if (n == 1) {
            return Enums.HashType.SHA1;
        }
        if (n == 2) {
            return Enums.HashType.SHA256;
        }
        if (n == 3) {
            return Enums.HashType.SHA384;
        }
        if (n == 4) {
            return Enums.HashType.SHA512;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("HashType ");
        sb.append(hashType.name());
        sb.append(" not known in");
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static String p() {
        return new HkdfPrfKeyManager().c();
    }
    
    private static void r(final int n) throws GeneralSecurityException {
        if (n >= 32) {
            return;
        }
        throw new GeneralSecurityException("Invalid HkdfPrfKey/HkdfPrfKeyFormat: Key size too short");
    }
    
    private static void s(final HkdfPrfParams hkdfPrfParams) throws GeneralSecurityException {
        if (hkdfPrfParams.M() != HashType.SHA256 && hkdfPrfParams.M() != HashType.SHA512) {
            throw new GeneralSecurityException("Invalid HkdfPrfKey/HkdfPrfKeyFormat: Unsupported hash");
        }
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    }
    
    @Override
    public KeyFactory<HkdfPrfKeyFormat, HkdfPrfKey> e() {
        return new KeyFactory<HkdfPrfKeyFormat, HkdfPrfKey>(this, HkdfPrfKeyFormat.class) {
            final HkdfPrfKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((HkdfPrfKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((HkdfPrfKeyFormat)messageLite);
            }
            
            public HkdfPrfKey e(final HkdfPrfKeyFormat hkdfPrfKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<HkdfPrfKey, BuilderType>)HkdfPrfKey.Q().D(ByteString.copyFrom(Random.c(hkdfPrfKeyFormat.M()))).F(this.b.n()).E(hkdfPrfKeyFormat.N())).p();
            }
            
            public HkdfPrfKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return HkdfPrfKeyFormat.P(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final HkdfPrfKeyFormat hkdfPrfKeyFormat) throws GeneralSecurityException {
                HkdfPrfKeyManager.k(hkdfPrfKeyFormat.M());
                HkdfPrfKeyManager.l(hkdfPrfKeyFormat.N());
            }
        };
    }
    
    @Override
    public KeyData.KeyMaterialType f() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }
    
    @Override
    public /* bridge */ MessageLite g(final ByteString byteString) throws InvalidProtocolBufferException {
        return this.o(byteString);
    }
    
    @Override
    public /* bridge */ void i(final MessageLite messageLite) throws GeneralSecurityException {
        this.q((HkdfPrfKey)messageLite);
    }
    
    public int n() {
        return 0;
    }
    
    public HkdfPrfKey o(final ByteString byteString) throws InvalidProtocolBufferException {
        return HkdfPrfKey.R(byteString, ExtensionRegistryLite.b());
    }
    
    public void q(final HkdfPrfKey hkdfPrfKey) throws GeneralSecurityException {
        Validators.f(hkdfPrfKey.P(), this.n());
        r(hkdfPrfKey.N().size());
        s(hkdfPrfKey.O());
    }
}
