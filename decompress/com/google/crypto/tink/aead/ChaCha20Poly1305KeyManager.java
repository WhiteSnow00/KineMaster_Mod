// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.aead;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.proto.ChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.ChaCha20Poly1305;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.ChaCha20Poly1305Key;
import com.google.crypto.tink.KeyTypeManager;

public class ChaCha20Poly1305KeyManager extends KeyTypeManager<ChaCha20Poly1305Key>
{
    ChaCha20Poly1305KeyManager() {
        super(ChaCha20Poly1305Key.class, (PrimitiveFactory<?, ChaCha20Poly1305Key>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, ChaCha20Poly1305Key>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((ChaCha20Poly1305Key)o);
                }
                
                public Aead c(final ChaCha20Poly1305Key chaCha20Poly1305Key) throws GeneralSecurityException {
                    return new ChaCha20Poly1305(chaCha20Poly1305Key.M().toByteArray());
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new ChaCha20Poly1305KeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }
    
    @Override
    public KeyFactory<ChaCha20Poly1305KeyFormat, ChaCha20Poly1305Key> e() {
        return new KeyFactory<ChaCha20Poly1305KeyFormat, ChaCha20Poly1305Key>(this, ChaCha20Poly1305KeyFormat.class) {
            final ChaCha20Poly1305KeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((ChaCha20Poly1305KeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((ChaCha20Poly1305KeyFormat)messageLite);
            }
            
            public ChaCha20Poly1305Key e(final ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<ChaCha20Poly1305Key, BuilderType>)ChaCha20Poly1305Key.O().E(this.b.j()).D(ByteString.copyFrom(Random.c(32)))).p();
            }
            
            public ChaCha20Poly1305KeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return ChaCha20Poly1305KeyFormat.K(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat) throws GeneralSecurityException {
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
        this.m((ChaCha20Poly1305Key)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public ChaCha20Poly1305Key k(final ByteString byteString) throws InvalidProtocolBufferException {
        return ChaCha20Poly1305Key.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final ChaCha20Poly1305Key chaCha20Poly1305Key) throws GeneralSecurityException {
        Validators.f(chaCha20Poly1305Key.N(), this.j());
        if (chaCha20Poly1305Key.M().size() == 32) {
            return;
        }
        throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
    }
}
