// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.security.MessageDigest;
import java.util.Arrays;
import java.security.GeneralSecurityException;
import java.math.BigInteger;

public class SubtleUtil
{
    public static int a() {
        try {
            return Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(null);
        }
        catch (final ClassNotFoundException | NoSuchFieldException | IllegalAccessException ex) {
            return -1;
        }
    }
    
    public static BigInteger b(final byte[] array) {
        return new BigInteger(1, array);
    }
    
    public static byte[] c(final BigInteger bigInteger, final int n) throws GeneralSecurityException {
        final byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == n) {
            return byteArray;
        }
        final int length = byteArray.length;
        final int n2 = n + 1;
        if (length > n2) {
            throw new GeneralSecurityException("integer too large");
        }
        if (byteArray.length != n2) {
            final byte[] array = new byte[n];
            System.arraycopy(byteArray, 0, array, n - byteArray.length, byteArray.length);
            return array;
        }
        if (byteArray[0] == 0) {
            return Arrays.copyOfRange(byteArray, 1, byteArray.length);
        }
        throw new GeneralSecurityException("integer too large");
    }
    
    public static boolean d() {
        boolean b = false;
        try {
            Class.forName("android.app.Application", false, null);
            b = true;
            return b;
        }
        catch (final Exception ex) {
            return b;
        }
    }
    
    public static byte[] e(final byte[] array, final int n, final Enums.HashType hashType) throws GeneralSecurityException {
        final MessageDigest messageDigest = EngineFactory.i.a(f(hashType));
        final int digestLength = messageDigest.getDigestLength();
        final byte[] array2 = new byte[n];
        int i = 0;
        int n2 = 0;
        while (i <= (n - 1) / digestLength) {
            messageDigest.reset();
            messageDigest.update(array);
            messageDigest.update(c(BigInteger.valueOf(i), 4));
            final byte[] digest = messageDigest.digest();
            System.arraycopy(digest, 0, array2, n2, Math.min(digest.length, n - n2));
            n2 += digest.length;
            ++i;
        }
        return array2;
    }
    
    public static String f(final Enums.HashType hashType) throws GeneralSecurityException {
        final int n = SubtleUtil$a.a[hashType.ordinal()];
        if (n == 1) {
            return "SHA-1";
        }
        if (n == 2) {
            return "SHA-256";
        }
        if (n == 3) {
            return "SHA-384";
        }
        if (n == 4) {
            return "SHA-512";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unsupported hash ");
        sb.append(hashType);
        throw new GeneralSecurityException(sb.toString());
    }
    
    public static String g(final Enums.HashType hashType) throws GeneralSecurityException {
        Validators.e(hashType);
        final StringBuilder sb = new StringBuilder();
        sb.append(hashType);
        sb.append("withECDSA");
        return sb.toString();
    }
    
    public static String h(final Enums.HashType hashType) throws GeneralSecurityException {
        Validators.e(hashType);
        final StringBuilder sb = new StringBuilder();
        sb.append(hashType);
        sb.append("withRSA");
        return sb.toString();
    }
}
