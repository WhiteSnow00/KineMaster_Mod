// 
// Decompiled by Procyon v0.6.0
// 

package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.Closeable;
import android.util.Log;
import java.io.FileDescriptor;

class b
{
    static String a(final byte[] array) {
        final StringBuilder sb = new StringBuilder(array.length * 2);
        for (int i = 0; i < array.length; ++i) {
            sb.append(String.format("%02x", array[i]));
        }
        return sb.toString();
    }
    
    static void b(final FileDescriptor fileDescriptor) {
        try {
            a.a(fileDescriptor);
        }
        catch (final Exception ex) {
            Log.e("ExifInterfaceUtils", "Error closing fd.");
        }
    }
    
    static void c(final Closeable closeable) {
        if (closeable == null) {
            goto Label_0016;
        }
        try {
            closeable.close();
            goto Label_0016;
        }
        catch (final RuntimeException ex) {
            throw ex;
        }
        catch (final Exception ex2) {
            goto Label_0016;
        }
    }
    
    static long[] d(final Object o) {
        if (o instanceof int[]) {
            final int[] array = (int[])o;
            final long[] array2 = new long[array.length];
            for (int i = 0; i < array.length; ++i) {
                array2[i] = array[i];
            }
            return array2;
        }
        if (o instanceof long[]) {
            return (long[])o;
        }
        return null;
    }
    
    static int e(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        final byte[] array = new byte[8192];
        int n = 0;
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            n += read;
            outputStream.write(array, 0, read);
        }
        return n;
    }
    
    static void f(final InputStream inputStream, final OutputStream outputStream, int i) throws IOException {
        final byte[] array = new byte[8192];
        while (i > 0) {
            final int min = Math.min(i, 8192);
            final int read = inputStream.read(array, 0, min);
            if (read != min) {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i -= read;
            outputStream.write(array, 0, read);
        }
    }
    
    static boolean g(final byte[] array, final byte[] array2) {
        if (array == null || array2 == null) {
            return false;
        }
        if (array.length < array2.length) {
            return false;
        }
        for (int i = 0; i < array2.length; ++i) {
            if (array[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
    
    static class a
    {
        static void a(final FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }
        
        static FileDescriptor b(final FileDescriptor fileDescriptor) throws ErrnoException {
            return Os.dup(fileDescriptor);
        }
        
        static long c(final FileDescriptor fileDescriptor, final long n, final int n2) throws ErrnoException {
            return Os.lseek(fileDescriptor, n, n2);
        }
    }
    
    static class b
    {
        static void a(final MediaMetadataRetriever mediaMetadataRetriever, final MediaDataSource dataSource) {
            mediaMetadataRetriever.setDataSource(dataSource);
        }
    }
}
