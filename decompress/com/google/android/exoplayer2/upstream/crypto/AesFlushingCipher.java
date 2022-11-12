// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.util.Assertions;
import javax.crypto.ShortBufferException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.google.android.exoplayer2.util.Util;
import javax.crypto.Cipher;

public final class AesFlushingCipher
{
    private final Cipher a;
    private final int b;
    private final byte[] c;
    private final byte[] d;
    private int e;
    
    public AesFlushingCipher(final int n, byte[] ex, final long n2, final long n3) {
        try {
            final Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            this.a = instance;
            final int blockSize = instance.getBlockSize();
            this.b = blockSize;
            this.c = new byte[blockSize];
            this.d = new byte[blockSize];
            final long n4 = n3 / blockSize;
            final int n5 = (int)(n3 % blockSize);
            final SecretKeySpec secretKeySpec = new SecretKeySpec((byte[])(Object)ex, Util.U0(instance.getAlgorithm(), "/")[0]);
            ex = (InvalidAlgorithmParameterException)new IvParameterSpec(this.b(n2, n4));
            instance.init(n, secretKeySpec, (AlgorithmParameterSpec)ex);
            if (n5 != 0) {
                this.e(new byte[n5], 0, n5);
            }
            return;
        }
        catch (final InvalidAlgorithmParameterException ex) {}
        catch (final InvalidKeyException ex) {}
        catch (final NoSuchPaddingException ex) {}
        catch (final NoSuchAlgorithmException ex2) {}
        throw new RuntimeException(ex);
    }
    
    public AesFlushingCipher(final int n, final byte[] array, final String s, final long n2) {
        this(n, array, a(s), n2);
    }
    
    private static long a(final String s) {
        long n = 0L;
        if (s == null) {
            return 0L;
        }
        for (int i = 0; i < s.length(); ++i) {
            final long n2 = n ^ (long)s.charAt(i);
            n = n2 + ((n2 << 1) + (n2 << 4) + (n2 << 5) + (n2 << 7) + (n2 << 8) + (n2 << 40));
        }
        return n;
    }
    
    private byte[] b(final long n, final long n2) {
        return ByteBuffer.allocate(16).putLong(n).putLong(n2).array();
    }
    
    private int c(final byte[] array, int update, final int n, final byte[] array2, final int n2) {
        try {
            update = this.a.update(array, update, n, array2, n2);
            return update;
        }
        catch (final ShortBufferException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void d(final byte[] array, int c, int i, final byte[] array2, int e) {
        do {
            final int e2 = this.e;
            if (e2 > 0) {
                array2[e] = (byte)(array[c] ^ this.d[this.b - e2]);
                ++e;
                ++c;
                this.e = e2 - 1;
            }
            else {
                c = this.c(array, c, i, array2, e);
                if (i == c) {
                    return;
                }
                final int n = i - c;
                final int b = this.b;
                i = 0;
                final boolean b2 = true;
                Assertions.g(n < b);
                c += e;
                e = this.b - n;
                this.e = e;
                Assertions.g(this.c(this.c, 0, e, this.d, 0) == this.b && b2);
                while (i < n) {
                    array2[c] = this.d[i];
                    ++i;
                    ++c;
                }
            }
        } while (--i != 0);
    }
    
    public void e(final byte[] array, final int n, final int n2) {
        this.d(array, n, n2, array, n);
    }
}
