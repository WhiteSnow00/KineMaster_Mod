// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.math.BigInteger;
import java.security.Key;
import javax.crypto.Cipher;
import java.security.MessageDigest;
import java.security.GeneralSecurityException;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import com.google.crypto.tink.PublicKeySign;

public final class RsaSsaPssSignJce implements PublicKeySign
{
    private final RSAPrivateCrtKey a;
    private final RSAPublicKey b;
    private final Enums.HashType c;
    private final Enums.HashType d;
    private final int e;
    
    public RsaSsaPssSignJce(final RSAPrivateCrtKey a, final Enums.HashType c, final Enums.HashType d, final int e) throws GeneralSecurityException {
        Validators.e(c);
        Validators.c(a.getModulus().bitLength());
        Validators.d(a.getPublicExponent());
        this.a = a;
        this.b = (RSAPublicKey)EngineFactory.l.a("RSA").generatePublic(new RSAPublicKeySpec(a.getModulus(), a.getPublicExponent()));
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private byte[] a(byte[] digest, int n) throws GeneralSecurityException {
        Validators.e(this.c);
        final MessageDigest messageDigest = EngineFactory.i.a(SubtleUtil.f(this.c));
        final byte[] digest2 = messageDigest.digest(digest);
        final int digestLength = messageDigest.getDigestLength();
        final int n2 = (n - 1) / 8 + 1;
        final int e = this.e;
        if (n2 >= digestLength + e + 2) {
            final byte[] c = Random.c(e);
            final int n3 = digestLength + 8;
            digest = new byte[this.e + n3];
            System.arraycopy(digest2, 0, digest, 8, digestLength);
            System.arraycopy(c, 0, digest, n3, c.length);
            digest = messageDigest.digest(digest);
            final int n4 = n2 - digestLength - 1;
            final byte[] array = new byte[n4];
            final int e2 = this.e;
            array[n2 - e2 - digestLength - 2] = 1;
            System.arraycopy(c, 0, array, n2 - e2 - digestLength - 1, c.length);
            final byte[] e3 = SubtleUtil.e(digest, n4, this.d);
            final byte[] array2 = new byte[n4];
            for (int i = 0; i < n4; ++i) {
                array2[i] = (byte)(array[i] ^ e3[i]);
            }
            for (int n5 = 0; n5 < n2 * 8L - n; ++n5) {
                final int n6 = n5 / 8;
                array2[n6] &= (byte)~(1 << 7 - n5 % 8);
            }
            n = digestLength + n4;
            final byte[] array3 = new byte[n + 1];
            System.arraycopy(array2, 0, array3, 0, n4);
            System.arraycopy(digest, 0, array3, n4, digest.length);
            array3[n] = -68;
            return array3;
        }
        throw new GeneralSecurityException("encoding error");
    }
    
    private byte[] b(final byte[] array) throws GeneralSecurityException {
        final EngineFactory<EngineWrapper.TCipher, Cipher> f = EngineFactory.f;
        final Cipher cipher = f.a("RSA/ECB/NOPADDING");
        cipher.init(2, this.a);
        final byte[] doFinal = cipher.doFinal(array);
        final Cipher cipher2 = f.a("RSA/ECB/NOPADDING");
        cipher2.init(1, this.b);
        if (new BigInteger(1, array).equals(new BigInteger(1, cipher2.doFinal(doFinal)))) {
            return doFinal;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }
    
    public byte[] c(final byte[] array) throws GeneralSecurityException {
        return this.b(this.a(array, this.b.getModulus().bitLength() - 1));
    }
}
