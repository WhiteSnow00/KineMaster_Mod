// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.streamingaead;

import java.security.NoSuchAlgorithmException;
import com.google.crypto.tink.proto.HashType;

class b
{
    public static String a(final HashType hashType) throws NoSuchAlgorithmException {
        final int n = b$a.a[hashType.ordinal()];
        if (n == 1) {
            return "HmacSha1";
        }
        if (n == 2) {
            return "HmacSha256";
        }
        if (n == 3) {
            return "HmacSha512";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("hash unsupported for HMAC: ");
        sb.append(hashType);
        throw new NoSuchAlgorithmException(sb.toString());
    }
}
