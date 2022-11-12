// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.util.Arrays;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
import com.google.errorprone.annotations.Immutable;
import com.google.crypto.tink.prf.Prf;

@Immutable
public final class PrfHmacJce implements Prf
{
    private final ThreadLocal<Mac> a;
    private final String b;
    private final Key c;
    private final int d;
    
    public PrfHmacJce(final String b, final Key c) throws GeneralSecurityException {
        final ThreadLocal<Mac> a = new ThreadLocal<Mac>() {
            final PrfHmacJce a;
            
            protected Mac a() {
                try {
                    final Mac mac = EngineFactory.g.a(PrfHmacJce.b(this.a));
                    mac.init(PrfHmacJce.c(this.a));
                    return mac;
                }
                catch (final GeneralSecurityException ex) {
                    throw new IllegalStateException(ex);
                }
            }
            
            @Override
            protected /* bridge */ Object initialValue() {
                return this.a();
            }
        };
        this.a = a;
        this.b = b;
        this.c = c;
        if (c.getEncoded().length >= 16) {
            b.hashCode();
            int n = -1;
            switch (b) {
                case "HMACSHA512": {
                    n = 3;
                    break;
                }
                case "HMACSHA384": {
                    n = 2;
                    break;
                }
                case "HMACSHA256": {
                    n = 1;
                    break;
                }
                case "HMACSHA1": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("unknown Hmac algorithm: ");
                    sb.append(b);
                    throw new NoSuchAlgorithmException(sb.toString());
                }
                case 3: {
                    this.d = 64;
                    break;
                }
                case 2: {
                    this.d = 48;
                    break;
                }
                case 1: {
                    this.d = 32;
                    break;
                }
                case 0: {
                    this.d = 20;
                    break;
                }
            }
            a.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }
    
    static String b(final PrfHmacJce prfHmacJce) {
        return prfHmacJce.b;
    }
    
    static Key c(final PrfHmacJce prfHmacJce) {
        return prfHmacJce.c;
    }
    
    @Override
    public byte[] a(final byte[] array, final int n) throws GeneralSecurityException {
        if (n <= this.d) {
            this.a.get().update(array);
            return Arrays.copyOf(this.a.get().doFinal(), n);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
