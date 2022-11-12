// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle.prf;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.io.InputStream;
import com.google.errorprone.annotations.Immutable;
import com.google.crypto.tink.prf.Prf;

@Immutable
public class PrfImpl implements Prf
{
    private final StreamingPrf a;
    
    private PrfImpl(final StreamingPrf a) {
        this.a = a;
    }
    
    private static byte[] b(final InputStream inputStream, final int n) throws GeneralSecurityException {
        try {
            final byte[] array = new byte[n];
            int read;
            for (int i = 0; i < n; i += read) {
                read = inputStream.read(array, i, n - i);
                if (read <= 0) {
                    throw new GeneralSecurityException("Provided StreamingPrf terminated before providing requested number of bytes.");
                }
            }
            return array;
        }
        catch (final IOException ex) {
            throw new GeneralSecurityException(ex);
        }
    }
    
    public static PrfImpl c(final StreamingPrf streamingPrf) {
        return new PrfImpl(streamingPrf);
    }
    
    @Override
    public byte[] a(final byte[] array, final int n) throws GeneralSecurityException {
        if (array == null) {
            throw new GeneralSecurityException("Invalid input provided.");
        }
        if (n > 0) {
            return b(this.a.a(array), n);
        }
        throw new GeneralSecurityException("Invalid outputLength specified.");
    }
}
