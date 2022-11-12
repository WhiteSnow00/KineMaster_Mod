// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import com.google.crypto.tink.PublicKeyVerify;

public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify
{
    private final RSAPublicKey a;
    private final Enums.HashType b;
    
    public RsaSsaPkcs1VerifyJce(final RSAPublicKey a, final Enums.HashType b) throws GeneralSecurityException {
        Validators.e(b);
        Validators.c(a.getModulus().bitLength());
        Validators.d(a.getPublicExponent());
        this.a = a;
        this.b = b;
    }
    
    private byte[] a(byte[] digest, int n, final Enums.HashType hashType) throws GeneralSecurityException {
        Validators.e(hashType);
        final MessageDigest messageDigest = EngineFactory.i.a(SubtleUtil.f(this.b));
        messageDigest.update(digest);
        digest = messageDigest.digest();
        final byte[] b = this.b(hashType);
        final int n2 = b.length + digest.length;
        if (n >= n2 + 11) {
            final byte[] array = new byte[n];
            array[0] = 0;
            int n3 = 2;
            array[1] = 1;
            for (int i = 0; i < n - n2 - 3; ++i, ++n3) {
                array[n3] = -1;
            }
            n = n3 + 1;
            array[n3] = 0;
            System.arraycopy(b, 0, array, n, b.length);
            System.arraycopy(digest, 0, array, n + b.length, digest.length);
            return array;
        }
        throw new GeneralSecurityException("intended encoded message length too short");
    }
    
    private byte[] b(final Enums.HashType hashType) throws GeneralSecurityException {
        final int n = RsaSsaPkcs1VerifyJce$a.a[hashType.ordinal()];
        if (n == 1) {
            return Hex.a("3031300d060960864801650304020105000420");
        }
        if (n == 2) {
            return Hex.a("3051300d060960864801650304020305000440");
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unsupported hash ");
        sb.append(hashType);
        throw new GeneralSecurityException(sb.toString());
    }
    
    public void c(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        final BigInteger publicExponent = this.a.getPublicExponent();
        final BigInteger modulus = this.a.getModulus();
        final int n = (modulus.bitLength() + 7) / 8;
        if (n != array.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        final BigInteger b = SubtleUtil.b(array);
        if (b.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        if (Bytes.b(SubtleUtil.c(b.modPow(publicExponent, modulus), n), this.a(array2, n, this.b))) {
            return;
        }
        throw new GeneralSecurityException("invalid signature");
    }
}
