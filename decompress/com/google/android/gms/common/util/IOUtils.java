// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import javax.annotation.Nullable;
import java.io.Closeable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@Deprecated
@KeepForSdk
@ShowFirstParty
public final class IOUtils
{
    private IOUtils() {
    }
    
    @KeepForSdk
    public static void a(@Nullable final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (final IOException ex) {}
    }
    
    @Deprecated
    @KeepForSdk
    public static long b(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        return c(inputStream, outputStream, false, 1024);
    }
    
    @Deprecated
    @KeepForSdk
    public static long c(final InputStream inputStream, final OutputStream outputStream, final boolean b, final int n) throws IOException {
        final byte[] array = new byte[n];
        long n2 = 0L;
        try {
            while (true) {
                final int read = inputStream.read(array, 0, n);
                if (read == -1) {
                    break;
                }
                n2 += read;
                outputStream.write(array, 0, read);
            }
            if (b) {
                a(inputStream);
                a(outputStream);
            }
            return n2;
        }
        finally {
            if (b) {
                a(inputStream);
                a(outputStream);
            }
        }
    }
    
    @Deprecated
    @KeepForSdk
    public static byte[] d(final InputStream inputStream, final boolean b) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c(inputStream, byteArrayOutputStream, b, 1024);
        return byteArrayOutputStream.toByteArray();
    }
}
