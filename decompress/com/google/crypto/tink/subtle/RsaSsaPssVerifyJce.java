// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.math.BigInteger;
import java.util.Arrays;
import java.security.MessageDigest;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import com.google.crypto.tink.PublicKeyVerify;

public final class RsaSsaPssVerifyJce implements PublicKeyVerify
{
    private final RSAPublicKey a;
    private final Enums.HashType b;
    private final Enums.HashType c;
    private final int d;
    
    public RsaSsaPssVerifyJce(final RSAPublicKey a, final Enums.HashType b, final Enums.HashType c, final int d) throws GeneralSecurityException {
        Validators.e(b);
        Validators.c(a.getModulus().bitLength());
        Validators.d(a.getPublicExponent());
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    private void a(byte[] digest, final byte[] array, int i) throws GeneralSecurityException {
        Validators.e(this.b);
        final MessageDigest messageDigest = EngineFactory.i.a(SubtleUtil.f(this.b));
        digest = messageDigest.digest(digest);
        final int digestLength = messageDigest.getDigestLength();
        final int length = array.length;
        if (length < this.d + digestLength + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (array[array.length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        final int n = length - digestLength;
        final int n2 = n - 1;
        final byte[] copy = Arrays.copyOf(array, n2);
        final byte[] copyOfRange = Arrays.copyOfRange(array, copy.length, copy.length + digestLength);
        int n3 = 0;
        final MessageDigest messageDigest2 = messageDigest;
        while (true) {
            final long n4 = n3;
            final long n5 = length * 8L - i;
            if (n4 < n5) {
                if ((copy[n3 / 8] >> 7 - n3 % 8 & 0x1) != 0x0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                ++n3;
            }
            else {
                final byte[] e = SubtleUtil.e(copyOfRange, n2, this.c);
                final int length2 = e.length;
                final byte[] array2 = new byte[length2];
                for (i = 0; i < length2; ++i) {
                    array2[i] = (byte)(e[i] ^ copy[i]);
                }
                int n6;
                for (i = 0; i <= n5; ++i) {
                    n6 = i / 8;
                    array2[n6] &= (byte)~(1 << 7 - i % 8);
                }
                i = 0;
                while (true) {
                    final int d = this.d;
                    if (i < n - d - 2) {
                        if (array2[i] != 0) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        ++i;
                    }
                    else {
                        if (array2[n - d - 2] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        final byte[] copyOfRange2 = Arrays.copyOfRange(array2, length2 - d, length2);
                        i = digestLength + 8;
                        final byte[] array3 = new byte[this.d + i];
                        System.arraycopy(digest, 0, array3, 8, digest.length);
                        System.arraycopy(copyOfRange2, 0, array3, i, copyOfRange2.length);
                        if (Bytes.b(messageDigest2.digest(array3), copyOfRange)) {
                            return;
                        }
                        throw new GeneralSecurityException("inconsistent");
                    }
                }
            }
        }
    }
    
    public void b(final byte[] array, final byte[] array2) throws GeneralSecurityException {
        final BigInteger publicExponent = this.a.getPublicExponent();
        final BigInteger modulus = this.a.getModulus();
        final int n = (modulus.bitLength() + 7) / 8;
        final int n2 = (modulus.bitLength() - 1 + 7) / 8;
        if (n != array.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        final BigInteger b = SubtleUtil.b(array);
        if (b.compareTo(modulus) < 0) {
            this.a(array2, SubtleUtil.c(b.modPow(publicExponent, modulus), n2), modulus.bitLength() - 1);
            return;
        }
        throw new GeneralSecurityException("signature out of range");
    }
}
