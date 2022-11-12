// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import javax.crypto.AEADBadTagException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.util.Arrays;
import java.security.Key;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import com.google.crypto.tink.Aead;

public final class AesEaxJce implements Aead
{
    private static final ThreadLocal<Cipher> e;
    private static final ThreadLocal<Cipher> f;
    private final byte[] a;
    private final byte[] b;
    private final SecretKeySpec c;
    private final int d;
    
    static {
        e = new ThreadLocal<Cipher>() {
            protected Cipher a() {
                try {
                    return EngineFactory.f.a("AES/ECB/NOPADDING");
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
        f = new ThreadLocal<Cipher>() {
            protected Cipher a() {
                try {
                    return EngineFactory.f.a("AES/CTR/NOPADDING");
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
    }
    
    public AesEaxJce(byte[] c, final int d) throws GeneralSecurityException {
        if (d != 12 && d != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.d = d;
        Validators.a(c.length);
        final SecretKeySpec c2 = new SecretKeySpec(c, "AES");
        this.c = c2;
        final Cipher cipher = AesEaxJce.e.get();
        cipher.init(1, c2);
        c = c(cipher.doFinal(new byte[16]));
        this.a = c;
        this.b = c(c);
    }
    
    private static byte[] c(final byte[] array) {
        final byte[] array2 = new byte[16];
        final int n = 0;
        int n2;
        for (int i = 0; i < 15; i = n2) {
            final byte b = array[i];
            n2 = i + 1;
            array2[i] = (byte)((b << 1 ^ (array[n2] & 0xFF) >>> 7) & 0xFF);
        }
        final byte b2 = array[15];
        int n3;
        if ((array[0] & 0x80) == 0x0) {
            n3 = n;
        }
        else {
            n3 = 135;
        }
        array2[15] = (byte)(b2 << 1 ^ n3);
        return array2;
    }
    
    private byte[] d(final Cipher cipher, int n, final byte[] array, final int n2, final int n3) throws IllegalBlockSizeException, BadPaddingException {
        final byte[] array2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (byte)n };
        if (n3 == 0) {
            return cipher.doFinal(f(array2, this.a));
        }
        byte[] array3 = cipher.doFinal(array2);
        int i;
        for (n = 0; n3 - n > 16; n += 16) {
            for (i = 0; i < 16; ++i) {
                array3[i] ^= array[n2 + n + i];
            }
            array3 = cipher.doFinal(array3);
        }
        return cipher.doFinal(f(array3, this.e(Arrays.copyOfRange(array, n + n2, n2 + n3))));
    }
    
    private byte[] e(final byte[] array) {
        if (array.length == 16) {
            return f(array, this.a);
        }
        final byte[] copy = Arrays.copyOf(this.b, 16);
        for (int i = 0; i < array.length; ++i) {
            copy[i] ^= array[i];
        }
        copy[array.length] ^= (byte)128;
        return copy;
    }
    
    private static byte[] f(final byte[] array, final byte[] array2) {
        final int length = array.length;
        final byte[] array3 = new byte[length];
        for (int i = 0; i < length; ++i) {
            array3[i] = (byte)(array[i] ^ array2[i]);
        }
        return array3;
    }
    
    @Override
    public byte[] a(final byte[] array, byte[] d) throws GeneralSecurityException {
        final int length = array.length;
        final int d2 = this.d;
        if (length <= Integer.MAX_VALUE - d2 - 16) {
            final byte[] array2 = new byte[array.length + d2 + 16];
            final byte[] c = Random.c(d2);
            final int d3 = this.d;
            int i = 0;
            System.arraycopy(c, 0, array2, 0, d3);
            final Cipher cipher = AesEaxJce.e.get();
            cipher.init(1, this.c);
            final byte[] d4 = this.d(cipher, 0, c, 0, c.length);
            if (d == null) {
                d = new byte[0];
            }
            d = this.d(cipher, 1, d, 0, d.length);
            final Cipher cipher2 = AesEaxJce.f.get();
            cipher2.init(1, this.c, new IvParameterSpec(d4));
            cipher2.doFinal(array, 0, array.length, array2, this.d);
            final byte[] d5 = this.d(cipher, 2, array2, this.d, array.length);
            final int length2 = array.length;
            final int d6 = this.d;
            while (i < 16) {
                array2[length2 + d6 + i] = (byte)(d[i] ^ d4[i] ^ d5[i]);
                ++i;
            }
            return array2;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
    
    @Override
    public byte[] b(final byte[] array, byte[] d) throws GeneralSecurityException {
        final int n = array.length - this.d - 16;
        if (n < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        final Cipher cipher = AesEaxJce.e.get();
        cipher.init(1, this.c);
        final byte[] d2 = this.d(cipher, 0, array, 0, this.d);
        int i = 0;
        byte[] array2;
        if ((array2 = d) == null) {
            array2 = new byte[0];
        }
        d = this.d(cipher, 1, array2, 0, array2.length);
        final byte[] d3 = this.d(cipher, 2, array, this.d, n);
        final int length = array.length;
        byte b = 0;
        while (i < 16) {
            b |= (byte)(array[length - 16 + i] ^ d[i] ^ d2[i] ^ d3[i]);
            ++i;
        }
        if (b == 0) {
            final Cipher cipher2 = AesEaxJce.f.get();
            cipher2.init(1, this.c, new IvParameterSpec(d2));
            return cipher2.doFinal(array, this.d, n);
        }
        throw new AEADBadTagException("tag mismatch");
    }
}
