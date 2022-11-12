// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

public final class XChaCha20Poly1305 extends d
{
    public XChaCha20Poly1305(final byte[] array) throws InvalidKeyException {
        super(array);
    }
    
    @Override
    public /* bridge */ byte[] a(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        return super.a(array, array2);
    }
    
    @Override
    public /* bridge */ byte[] b(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        return super.b(array, array2);
    }
    
    @Override
    c g(final byte[] array, final int n) throws InvalidKeyException {
        return new k(array, n);
    }
}
