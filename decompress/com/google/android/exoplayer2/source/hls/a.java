// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.io.InputStream;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.google.android.exoplayer2.upstream.DataSpec;
import javax.crypto.CipherInputStream;
import com.google.android.exoplayer2.upstream.DataSource;

class a implements DataSource
{
    private final DataSource a;
    private final byte[] b;
    private final byte[] c;
    private CipherInputStream d;
    
    public a(final DataSource a, final byte[] b, final byte[] c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final long b(DataSpec ex) throws IOException {
        try {
            final Cipher j = this.j();
            final SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
            final IvParameterSpec ivParameterSpec = new IvParameterSpec(this.c);
            try {
                j.init(2, secretKeySpec, ivParameterSpec);
                ex = (InvalidAlgorithmParameterException)new DataSourceInputStream(this.a, (DataSpec)ex);
                this.d = new CipherInputStream((InputStream)ex, j);
                ((DataSourceInputStream)ex).c();
                return -1L;
            }
            catch (final InvalidAlgorithmParameterException ex) {}
            catch (final InvalidKeyException ex2) {}
            throw new RuntimeException(ex);
        }
        catch (final NoSuchPaddingException ex) {}
        catch (final NoSuchAlgorithmException ex3) {}
        throw new RuntimeException(ex);
    }
    
    @Override
    public void close() throws IOException {
        if (this.d != null) {
            this.d = null;
            this.a.close();
        }
    }
    
    @Override
    public final void e(final TransferListener transferListener) {
        Assertions.e(transferListener);
        this.a.e(transferListener);
    }
    
    @Override
    public final Map<String, List<String>> g() {
        return this.a.g();
    }
    
    protected Cipher j() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }
    
    @Override
    public final Uri q() {
        return this.a.q();
    }
    
    @Override
    public final int read(final byte[] array, int read, int n) throws IOException {
        Assertions.e(this.d);
        n = (read = this.d.read(array, read, n));
        if (n < 0) {
            read = -1;
        }
        return read;
    }
}
