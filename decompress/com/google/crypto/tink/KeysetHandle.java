// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeysetInfo;
import java.io.IOException;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;

public final class KeysetHandle
{
    private final Keyset a;
    
    private KeysetHandle(final Keyset a) {
        this.a = a;
    }
    
    public static void a(final EncryptedKeyset encryptedKeyset) throws GeneralSecurityException {
        if (encryptedKeyset != null && encryptedKeyset.M().size() != 0) {
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }
    
    public static void b(final Keyset keyset) throws GeneralSecurityException {
        if (keyset != null && keyset.P() > 0) {
            return;
        }
        throw new GeneralSecurityException("empty keyset");
    }
    
    private static Keyset c(final EncryptedKeyset encryptedKeyset, final Aead aead) throws GeneralSecurityException {
        try {
            final Keyset u = Keyset.U(aead.b(encryptedKeyset.M().toByteArray(), new byte[0]), ExtensionRegistryLite.b());
            b(u);
            return u;
        }
        catch (final InvalidProtocolBufferException ex) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }
    
    private static EncryptedKeyset d(final Keyset keyset, final Aead aead) throws GeneralSecurityException {
        final byte[] a = aead.a(keyset.c(), new byte[0]);
        try {
            if (Keyset.U(aead.b(a, new byte[0]), ExtensionRegistryLite.b()).equals(keyset)) {
                return EncryptedKeyset.O().D(ByteString.copyFrom(a)).E(com.google.crypto.tink.a.b(keyset)).p();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        }
        catch (final InvalidProtocolBufferException ex) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }
    
    static final KeysetHandle e(final Keyset keyset) throws GeneralSecurityException {
        b(keyset);
        return new KeysetHandle(keyset);
    }
    
    private <B, P> P i(final Class<P> clazz, final Class<B> clazz2) throws GeneralSecurityException {
        return Registry.v((PrimitiveSet<Object>)Registry.m(this, (Class<B>)clazz2), clazz);
    }
    
    public static final KeysetHandle j(final KeysetReader keysetReader, final Aead aead) throws GeneralSecurityException, IOException {
        final EncryptedKeyset a = keysetReader.a();
        a(a);
        return new KeysetHandle(c(a, aead));
    }
    
    Keyset f() {
        return this.a;
    }
    
    public KeysetInfo g() {
        return com.google.crypto.tink.a.b(this.a);
    }
    
    public <P> P h(final Class<P> clazz) throws GeneralSecurityException {
        final Class<?> f = Registry.f(clazz);
        if (f != null) {
            return this.i(clazz, f);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No wrapper found for ");
        sb.append(clazz.getName());
        throw new GeneralSecurityException(sb.toString());
    }
    
    public void k(final KeysetWriter keysetWriter, final Aead aead) throws GeneralSecurityException, IOException {
        keysetWriter.b(d(this.a, aead));
    }
    
    @Override
    public String toString() {
        return this.g().toString();
    }
}
