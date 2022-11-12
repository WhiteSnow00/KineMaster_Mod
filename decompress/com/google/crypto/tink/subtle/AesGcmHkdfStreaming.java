// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;
import java.security.InvalidAlgorithmParameterException;

public final class AesGcmHkdfStreaming extends i
{
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final String e;
    private final byte[] f;
    
    public AesGcmHkdfStreaming(final byte[] array, final String e, final int a, final int b, final int d) throws InvalidAlgorithmParameterException {
        if (array.length < 16 || array.length < a) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ikm too short, must be >= ");
            sb.append(Math.max(16, a));
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
        Validators.a(a);
        if (b > this.a() + d + 16) {
            this.f = Arrays.copyOf(array, array.length);
            this.e = e;
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = b - 16;
            return;
        }
        throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
    }
    
    public int a() {
        return this.a + 1 + 7;
    }
}
