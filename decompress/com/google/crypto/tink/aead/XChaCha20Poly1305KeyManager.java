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
import com.google.crypto.tink.proto.XChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.XChaCha20Poly1305;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.proto.XChaCha20Poly1305Key;
import com.google.crypto.tink.KeyTypeManager;

public class XChaCha20Poly1305KeyManager extends KeyTypeManager<XChaCha20Poly1305Key>
{
    XChaCha20Poly1305KeyManager() {
        super(XChaCha20Poly1305Key.class, (PrimitiveFactory<?, XChaCha20Poly1305Key>[])new PrimitiveFactory[] { new PrimitiveFactory<Aead, XChaCha20Poly1305Key>(Aead.class) {
                @Override
                public /* bridge */ Object a(final Object o) throws GeneralSecurityException {
                    return this.c((XChaCha20Poly1305Key)o);
                }
                
                public Aead c(final XChaCha20Poly1305Key xChaCha20Poly1305Key) throws GeneralSecurityException {
                    return new XChaCha20Poly1305(xChaCha20Poly1305Key.M().toByteArray());
                }
            } });
    }
    
    public static void l(final boolean b) throws GeneralSecurityException {
        Registry.s((KeyTypeManager<MessageLite>)new XChaCha20Poly1305KeyManager(), b);
    }
    
    @Override
    public String c() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }
    
    @Override
    public KeyFactory<XChaCha20Poly1305KeyFormat, XChaCha20Poly1305Key> e() {
        return new KeyFactory<XChaCha20Poly1305KeyFormat, XChaCha20Poly1305Key>(this, XChaCha20Poly1305KeyFormat.class) {
            final XChaCha20Poly1305KeyManager b;
            
            @Override
            public /* bridge */ Object a(final MessageLite messageLite) throws GeneralSecurityException {
                return this.e((XChaCha20Poly1305KeyFormat)messageLite);
            }
            
            @Override
            public /* bridge */ MessageLite c(final ByteString byteString) throws InvalidProtocolBufferException {
                return this.f(byteString);
            }
            
            @Override
            public /* bridge */ void d(final MessageLite messageLite) throws GeneralSecurityException {
                this.g((XChaCha20Poly1305KeyFormat)messageLite);
            }
            
            public XChaCha20Poly1305Key e(final XChaCha20Poly1305KeyFormat xChaCha20Poly1305KeyFormat) throws GeneralSecurityException {
                return ((GeneratedMessageLite.Builder<XChaCha20Poly1305Key, BuilderType>)XChaCha20Poly1305Key.O().E(this.b.j()).D(ByteString.copyFrom(Random.c(32)))).p();
            }
            
            public XChaCha20Poly1305KeyFormat f(final ByteString byteString) throws InvalidProtocolBufferException {
                return XChaCha20Poly1305KeyFormat.K(byteString, ExtensionRegistryLite.b());
            }
            
            public void g(final XChaCha20Poly1305KeyFormat xChaCha20Poly1305KeyFormat) throws GeneralSecurityException {
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
        this.m((XChaCha20Poly1305Key)messageLite);
    }
    
    public int j() {
        return 0;
    }
    
    public XChaCha20Poly1305Key k(final ByteString byteString) throws InvalidProtocolBufferException {
        return XChaCha20Poly1305Key.P(byteString, ExtensionRegistryLite.b());
    }
    
    public void m(final XChaCha20Poly1305Key xChaCha20Poly1305Key) throws GeneralSecurityException {
        Validators.f(xChaCha20Poly1305Key.N(), this.j());
        if (xChaCha20Poly1305Key.M().size() == 32) {
            return;
        }
        throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
    }
}
