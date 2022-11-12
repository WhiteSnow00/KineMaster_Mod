// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import com.google.crypto.tink.Mac;

@Immutable
public class PrfMac implements Mac
{
    private final Prf a;
    private final int b;
    
    public PrfMac(final Prf a, final int b) throws GeneralSecurityException {
        this.a = a;
        this.b = b;
        if (b >= 10) {
            a.a(new byte[0], b);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }
    
    @Override
    public void a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        if (Bytes.b(this.b(array2), array)) {
            return;
        }
        throw new GeneralSecurityException("invalid MAC");
    }
    
    @Override
    public byte[] b(final byte[] array) throws GeneralSecurityException {
        return this.a.a(array, this.b);
    }
}
