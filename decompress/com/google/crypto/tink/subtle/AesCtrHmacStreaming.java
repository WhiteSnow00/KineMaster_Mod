// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

public final class AesCtrHmacStreaming extends i
{
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final String g;
    private final byte[] h;
    
    public AesCtrHmacStreaming(final byte[] array, final String g, final int a, final String b, final int c, final int d, final int f) throws InvalidAlgorithmParameterException {
        a(array.length, a, b, c, d, f);
        this.h = Arrays.copyOf(array, array.length);
        this.g = g;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = d - c;
    }
    
    private static void a(final int n, final int n2, final String s, final int n3, final int n4, final int n5) throws InvalidAlgorithmParameterException {
        if (n < 16 || n < n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ikm too short, must be >= ");
            sb.append(Math.max(16, n2));
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
        Validators.a(n2);
        if (n3 < 10) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("tag size too small ");
            sb2.append(n3);
            throw new InvalidAlgorithmParameterException(sb2.toString());
        }
        if ((s.equals("HmacSha1") && n3 > 20) || (s.equals("HmacSha256") && n3 > 32) || (s.equals("HmacSha512") && n3 > 64)) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        if (n4 - n5 - n3 - n2 - 7 - 1 > 0) {
            return;
        }
        throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
    }
}
