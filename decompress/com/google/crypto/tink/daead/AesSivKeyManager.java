// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.daead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.security.InvalidKeyException;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import java.security.InvalidAlgorithmParameterException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.subtle.AesSiv;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesSivKeyManager extends KeyTypeManager<AesSivKey>
{
    AesSivKeyManager() {
        super(AesSivKey.class, (PrimitiveFactory<?, AesSivKey>[])new PrimitiveFactory[] { new PrimitiveFactory<DeterministicAead, AesSivKey>(DeterministicAead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesSivKey)o);
                }
                
                public DeterministicAead c(final AesSivKey aesSivKey) throws GeneralSecurityException {
                    return new AesSiv(aesSivKey.M().toByteArray());
                }
            } });
    }
    
    public static final KeyTemplate j() {
        return k(64, KeyTemplate.OutputPrefixType.TINK);
    }
    
    private static KeyTemplate k(final int n, final KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.a(new AesSivKeyManager().c(), ((GeneratedMessageLite.Builder<AesSivKeyFormat, BuilderType>)AesSivKeyFormat.M().D(n)).p().c(), outputPrefixType);
    }
    
    public static void n(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new AesSivKeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }
    
    @Override
    public KeyFactory<AesSivKeyFormat, AesSivKey> e() {
        return new KeyFactory<AesSivKeyFormat, AesSivKey>(this, AesSivKeyFormat.class) {
            final AesSivKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesSivKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesSivKeyFormat)messageLite);
            }
            
            public AesSivKey e(final AesSivKeyFormat aesSivKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesSivKey, BuilderType>)AesSivKey.O().D(ByteString.copyFrom(Random.c(aesSivKeyFormat.L()))).E(this.b.l())).p();
            }
            
            public AesSivKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesSivKeyFormat.N(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesSivKeyFormat aesSivKeyFormat) throws GeneralSecurityException {
                if (aesSivKeyFormat.L() == 64) {
                    return;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("invalid key size: ");
                sb.append(aesSivKeyFormat.L());
                sb.append(". Valid keys must have 64 bytes.");
                throw new InvalidAlgorithmParameterException(sb.toString());
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
        this.o((AesSivKey)messageLite);
    }
    
    public int l() {
        return 0;
    }
    
    public AesSivKey m(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesSivKey.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void o(final AesSivKey aesSivKey) throws GeneralSecurityException {
        Validators.f(aesSivKey.N(), this.l());
        if (aesSivKey.M().size() == 64) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("invalid key size: ");
        sb.append(aesSivKey.M().size());
        sb.append(". Valid keys must have 64 bytes.");
        throw new InvalidKeyException(sb.toString());
    }
}
