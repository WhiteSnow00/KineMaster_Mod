// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.nio.channels.WritableByteChannel;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.lang.ref.SoftReference;

final class f
{
    private static final ThreadLocal<SoftReference<byte[]>> a;
    private static final Class<?> b;
    private static final long c;
    
    static {
        a = new ThreadLocal<SoftReference<byte[]>>();
        c = b(b = e("java.io.FileOutputStream"));
    }
    
    private static byte[] a() {
        final SoftReference softReference = f.a.get();
        byte[] array;
        if (softReference == null) {
            array = null;
        }
        else {
            array = (byte[])softReference.get();
        }
        return array;
    }
    
    private static long b(final Class<?> clazz) {
        if (clazz == null) {
            return -1L;
        }
        try {
            if (q0.G()) {
                return q0.I(clazz.getDeclaredField("channel"));
            }
            return -1L;
        }
        finally {
            return -1L;
        }
    }
    
    private static byte[] c(int max) {
        max = Math.max(max, 1024);
        final byte[] a = a();
        if (a != null) {
            final byte[] array = a;
            if (!d(max, a.length)) {
                return array;
            }
        }
        byte[] array;
        final byte[] array2 = array = new byte[max];
        if (max <= 16384) {
            f(array2);
            array = array2;
        }
        return array;
    }
    
    private static boolean d(final int n, final int n2) {
        return n2 < n && n2 < n * 0.5f;
    }
    
    private static Class<?> e(final String s) {
        try {
            return Class.forName(s);
        }
        catch (final ClassNotFoundException ex) {
            return null;
        }
    }
    
    private static void f(final byte[] array) {
        f.a.set(new SoftReference<byte[]>(array));
    }
    
    static void g(final ByteBuffer byteBuffer, final OutputStream outputStream) throws IOException {
        final int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            }
            else if (!h(byteBuffer, outputStream)) {
                final byte[] c = c(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    final int min = Math.min(byteBuffer.remaining(), c.length);
                    byteBuffer.get(c, 0, min);
                    outputStream.write(c, 0, min);
                }
            }
        }
        finally {
            byteBuffer.position(position);
        }
    }
    
    private static boolean h(final ByteBuffer byteBuffer, final OutputStream outputStream) throws IOException {
        final long c = f.c;
        if (c < 0L || !f.b.isInstance(outputStream)) {
            return false;
        }
        final WritableByteChannel writableByteChannel = null;
        while (true) {
            try {
                final WritableByteChannel writableByteChannel2 = (WritableByteChannel)q0.E(outputStream, c);
                if (writableByteChannel2 != null) {
                    writableByteChannel2.write(byteBuffer);
                    return true;
                }
                return false;
            }
            catch (final ClassCastException ex) {
                final WritableByteChannel writableByteChannel2 = writableByteChannel;
                continue;
            }
            break;
        }
    }
}
