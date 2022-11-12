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
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.subtle.AesGcmJce;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesGcmKeyManager extends KeyTypeManager<AesGcmKey>
{
    AesGcmKeyManager() {
        super(AesGcmKey.class, (PrimitiveFactory<?, AesGcmKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, AesGcmKey>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesGcmKey)o);
                }
                
                public Aead c(final AesGcmKey aesGcmKey) throws GeneralSecurityException {
                    return new AesGcmJce(aesGcmKey.M().toByteArray());
                }
            } });
    }
    
    public static final KeyTemplate j() {
        return k(32, KeyTemplate.OutputPrefixType.TINK);
    }
    
    private static KeyTemplate k(final int n, final KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.a(new AesGcmKeyManager().c(), ((GeneratedMessageLite.Builder<AesGcmKeyFormat, BuilderType>)AesGcmKeyFormat.M().D(n)).p().c(), outputPrefixType);
    }
    
    public static void n(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new AesGcmKeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }
    
    @Override
    public KeyFactory<AesGcmKeyFormat, AesGcmKey> e() {
        return new KeyFactory<AesGcmKeyFormat, AesGcmKey>(this, AesGcmKeyFormat.class) {
            final AesGcmKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesGcmKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesGcmKeyFormat)messageLite);
            }
            
            public AesGcmKey e(final AesGcmKeyFormat aesGcmKeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<AesGcmKey, BuilderType>)AesGcmKey.O().D(ByteString.copyFrom(Random.c(aesGcmKeyFormat.L()))).E(this.b.l())).p();
            }
            
            public AesGcmKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesGcmKeyFormat.N(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesGcmKeyFormat aesGcmKeyFormat) throws GeneralSecurityException {
                Validators.a(aesGcmKeyFormat.L());
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
        this.o((AesGcmKey)messageLite);
    }
    
    public int l() {
        return 0;
    }
    
    public AesGcmKey m(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesGcmKey.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void o(final AesGcmKey aesGcmKey) throws GeneralSecurityException {
        Validators.f(aesGcmKey.N(), this.l());
        Validators.a(aesGcmKey.M().size());
    }
}
