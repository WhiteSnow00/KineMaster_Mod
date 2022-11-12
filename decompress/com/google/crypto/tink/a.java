// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.Keyset;
import java.nio.charset.Charset;

class a
{
    public static final Charset a;
    
    static {
        a = Charset.forName("UTF-8");
    }
    
    public static KeysetInfo.KeyInfo a(final Keyset.Key key) {
        return ((GeneratedMessageLite.Builder<KeysetInfo.KeyInfo, BuilderType>)KeysetInfo.KeyInfo.S().G(key.O().P()).F(key.R()).E(key.Q()).D(key.P())).p();
    }
    
    public static KeysetInfo b(final Keyset keyset) {
        final KeysetInfo.Builder e = KeysetInfo.S().E(keyset.R());
        final Iterator<Keyset.Key> iterator = keyset.Q().iterator();
        while (iterator.hasNext()) {
            e.D(a(iterator.next()));
        }
        return ((GeneratedMessageLite.Builder<KeysetInfo, BuilderType>)e).p();
    }
    
    public static byte[] c(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final byte[] array = new byte[1024];
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(array, 0, read);
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    public static void d(final Keyset.Key key) throws GeneralSecurityException {
        if (!key.S()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", key.P()));
        }
        if (key.Q() == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", key.P()));
        }
        if (key.R() != KeyStatusType.UNKNOWN_STATUS) {
            return;
        }
        throw new GeneralSecurityException(String.format("key %d has unknown status", key.P()));
    }
    
    public static void e(final Keyset keyset) throws GeneralSecurityException {
        final int r = keyset.R();
        final Iterator<Keyset.Key> iterator = keyset.Q().iterator();
        boolean b = true;
        int n = 0;
        int n2 = 0;
        while (iterator.hasNext()) {
            final Keyset.Key key = iterator.next();
            if (key.R() != KeyStatusType.ENABLED) {
                continue;
            }
            d(key);
            int n3 = n2;
            if (key.P() == r) {
                if (n2 != 0) {
                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                }
                n3 = 1;
            }
            if (key.O().O() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                b = false;
            }
            ++n;
            n2 = n3;
        }
        if (n == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (n2 == 0 && !b) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
