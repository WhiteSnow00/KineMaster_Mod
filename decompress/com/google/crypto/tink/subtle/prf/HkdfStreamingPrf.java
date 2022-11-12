// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle.prf;

import java.io.IOException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import com.google.crypto.tink.subtle.EngineFactory;
import java.nio.ByteBuffer;
import javax.crypto.Mac;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;

@Immutable
public class HkdfStreamingPrf implements StreamingPrf
{
    private final Enums.HashType a;
    private final byte[] b;
    private final byte[] c;
    
    public HkdfStreamingPrf(final Enums.HashType a, final byte[] array, final byte[] array2) {
        this.a = a;
        this.b = Arrays.copyOf(array, array.length);
        this.c = Arrays.copyOf(array2, array2.length);
    }
    
    static Enums.HashType b(final HkdfStreamingPrf hkdfStreamingPrf) {
        return hkdfStreamingPrf.a;
    }
    
    static String c(final Enums.HashType hashType) throws GeneralSecurityException {
        return f(hashType);
    }
    
    static byte[] d(final HkdfStreamingPrf hkdfStreamingPrf) {
        return hkdfStreamingPrf.c;
    }
    
    static byte[] e(final HkdfStreamingPrf hkdfStreamingPrf) {
        return hkdfStreamingPrf.b;
    }
    
    private static String f(final Enums.HashType hashType) throws GeneralSecurityException {
        final int n = HkdfStreamingPrf$a.a[hashType.ordinal()];
        if (n == 1) {
            return "HmacSha1";
        }
        if (n == 2) {
            return "HmacSha256";
        }
        if (n == 3) {
            return "HmacSha384";
        }
        if (n == 4) {
            return "HmacSha512";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No getJavaxHmacName for given hash ");
        sb.append(hashType);
        sb.append(" known");
        throw new GeneralSecurityException(sb.toString());
    }
    
    @Override
    public InputStream a(final byte[] array) {
        return new b(array);
    }
    
    private class b extends InputStream
    {
        private final byte[] a;
        private Mac b;
        private byte[] c;
        private ByteBuffer d;
        private int e;
        final HkdfStreamingPrf f;
        
        public b(final HkdfStreamingPrf f, final byte[] array) {
            this.f = f;
            this.e = -1;
            this.a = Arrays.copyOf(array, array.length);
        }
        
        private void a() throws GeneralSecurityException, IOException {
            try {
                this.b = EngineFactory.g.a(HkdfStreamingPrf.c(HkdfStreamingPrf.b(this.f)));
                if (HkdfStreamingPrf.d(this.f) != null && HkdfStreamingPrf.d(this.f).length != 0) {
                    this.b.init(new SecretKeySpec(HkdfStreamingPrf.d(this.f), HkdfStreamingPrf.c(HkdfStreamingPrf.b(this.f))));
                }
                else {
                    this.b.init(new SecretKeySpec(new byte[this.b.getMacLength()], HkdfStreamingPrf.c(HkdfStreamingPrf.b(this.f))));
                }
                this.b.update(HkdfStreamingPrf.e(this.f));
                this.c = this.b.doFinal();
                (this.d = ByteBuffer.allocateDirect(0)).mark();
                this.e = 0;
            }
            catch (final GeneralSecurityException ex) {
                throw new IOException("Creating HMac failed", ex);
            }
        }
        
        private void c() throws GeneralSecurityException, IOException {
            this.b.init(new SecretKeySpec(this.c, HkdfStreamingPrf.c(HkdfStreamingPrf.b(this.f))));
            this.d.reset();
            this.b.update(this.d);
            this.b.update(this.a);
            final int e = this.e + 1;
            this.e = e;
            this.b.update((byte)e);
            (this.d = ByteBuffer.wrap(this.b.doFinal())).mark();
        }
        
        @Override
        public int read() throws IOException {
            final byte[] array = { 0 };
            final int read = this.read(array, 0, 1);
            if (read == 1) {
                return array[0] & 0xFF;
            }
            if (read == -1) {
                return read;
            }
            throw new IOException("Reading failed");
        }
        
        @Override
        public int read(final byte[] array) throws IOException {
            return this.read(array, 0, array.length);
        }
        
        @Override
        public int read(final byte[] array, int n, final int n2) throws IOException {
            try {
                if (this.e == -1) {
                    this.a();
                }
                int i;
                int min;
                for (i = 0; i < n2; i += min) {
                    if (!this.d.hasRemaining()) {
                        if (this.e == 255) {
                            return i;
                        }
                        this.c();
                    }
                    min = Math.min(n2 - i, this.d.remaining());
                    this.d.get(array, n, min);
                    n += min;
                }
                return i;
            }
            catch (final GeneralSecurityException ex) {
                this.b = null;
                throw new IOException("HkdfInputStream failed", ex);
            }
        }
    }
}
