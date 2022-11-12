// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.nio.ByteBuffer;
import com.google.crypto.tink.proto.Keyset;

public final class CryptoFormat
{
    public static final byte[] a;
    
    static {
        a = new byte[0];
    }
    
    public static byte[] a(final Keyset.Key key) throws GeneralSecurityException {
        final int n = CryptoFormat$a.a[key.Q().ordinal()];
        if (n == 1 || n == 2) {
            return ByteBuffer.allocate(5).put((byte)0).putInt(key.P()).array();
        }
        if (n == 3) {
            return ByteBuffer.allocate(5).put((byte)1).putInt(key.P()).array();
        }
        if (n == 4) {
            return CryptoFormat.a;
        }
        throw new GeneralSecurityException("unknown output prefix type");
    }
}
