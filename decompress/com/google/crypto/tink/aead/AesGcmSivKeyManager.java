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
import com.google.crypto.tink.proto.AesGcmSivKeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import com.google.crypto.tink.aead.subtle.AesGcmSiv;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.AesGcmSivKey;
import com.google.crypto.tink.KeyTypeManager;

public final class AesGcmSivKeyManager extends KeyTypeManager<AesGcmSivKey>
{
    AesGcmSivKeyManager() {
        super(AesGcmSivKey.class, (PrimitiveFactory<?, AesGcmSivKey>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, AesGcmSivKey>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((AesGcmSivKey)o);
                }
                
                public Aead c(final AesGcmSivKey aesGcmSivKey) throws GeneralSecurityException {
                    return new AesGcmSiv(aesGcmSivKey.M().toByteArray());
                }
            } });
    }
    
    private static boolean j() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        }
        catch (final NoSuchAlgorithmException | NoSuchPaddingException ex) {
            return false;
        }
    }
    
    public static void m(final boolean b) throws GeneralSecurityException {
        if (j()) {
            Registry.s((KeyTypeManager<MessageLite>)new AesGcmSivKeyManager(), b);
        }
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }
    
    @Override
    public KeyFactory<AesGcmSivKeyFormat, AesGcmSivKey> e() {
        return new KeyFactory<AesGcmSivKeyFormat, AesGcmSivKey>(this, AesGcmSivKeyFormat.class) {
            final AesGcmSivKeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((AesGcmSivKeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((AesGcmSivKeyFormat)messageLite);
            }
            
            public AesGcmSivKey e(final AesGcmSivKeyFormat aesGcmSivKeyFormat) {
                return ((GeneratedMessageLite.Builder<AesGcmSivKey, BuilderType>)AesGcmSivKey.O().D(ByteString.copyFrom(Random.c(aesGcmSivKeyFormat.K()))).E(this.b.k())).p();
            }
            
            public AesGcmSivKeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return AesGcmSivKeyFormat.L(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final AesGcmSivKeyFormat aesGcmSivKeyFormat) throws GeneralSecurityException {
                Validators.a(aesGcmSivKeyFormat.K());
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
        this.n((AesGcmSivKey)messageLite);
    }
    
    public int k() {
        return 0;
    }
    
    public AesGcmSivKey l(final ByteString byteString) throws InvalidProtocolBufferException {
        return AesGcmSivKey.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void n(final AesGcmSivKey aesGcmSivKey) throws GeneralSecurityException {
        Validators.f(aesGcmSivKey.N(), this.k());
        Validators.a(aesGcmSivKey.M().size());
    }
}
