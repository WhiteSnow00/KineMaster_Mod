// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Locale;
import java.security.InvalidAlgorithmParameterException;
import java.util.regex.Pattern;

public final class Validators
{
    private static final Pattern a;
    private static final Pattern b;
    
    static {
        a = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"), 2);
        b = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"), 2);
    }
    
    private Validators() {
    }
    
    public static void a(final int n) throws InvalidAlgorithmParameterException {
        if (n != 16 && n != 32) {
            throw new InvalidAlgorithmParameterException(String.format("invalid key size %d; only 128-bit and 256-bit AES keys are supported", n * 8));
        }
    }
    
    public static String b(final String s, final String s2) {
        if (s2.toLowerCase(Locale.US).startsWith(s)) {
            return s2.substring(s.length());
        }
        throw new IllegalArgumentException(String.format("key URI must start with %s", s));
    }
    
    public static void c(final int n) throws GeneralSecurityException {
        if (n >= 2048) {
            return;
        }
        throw new GeneralSecurityException(String.format("Modulus size is %d; only modulus size >= 2048-bit is supported", n));
    }
    
    public static void d(final BigInteger bigInteger) throws GeneralSecurityException {
        if (!bigInteger.testBit(0)) {
            throw new GeneralSecurityException("Public exponent must be odd.");
        }
        if (bigInteger.compareTo(BigInteger.valueOf(65536L)) > 0) {
            return;
        }
        throw new GeneralSecurityException("Public exponent must be greater than 65536.");
    }
    
    public static void e(final Enums.HashType hashType) throws GeneralSecurityException {
        final int n = Validators$a.a[hashType.ordinal()];
        if (n != 1 && n != 2 && n != 3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unsupported hash: ");
            sb.append(hashType.name());
            throw new GeneralSecurityException(sb.toString());
        }
    }
    
    public static void f(final int n, final int n2) throws GeneralSecurityException {
        if (n >= 0 && n <= n2) {
            return;
        }
        throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", n, n2));
    }
}
