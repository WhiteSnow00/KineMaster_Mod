// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.InputStream;

class m
{
    private static void a(final InputStream inputStream, final File file) throws IOException {
        if (inputStream == null) {
            return;
        }
        final byte[] array = new byte[8192];
        final Closeable closeable = null;
        Closeable closeable2;
        try {
            final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(file));
            try {
                while (true) {
                    final int read = inputStream.read(array);
                    if (read <= 0) {
                        break;
                    }
                    gzipOutputStream.write(array, 0, read);
                }
                gzipOutputStream.finish();
                CommonUtils.f(gzipOutputStream);
                return;
            }
            finally {}
        }
        finally {
            closeable2 = closeable;
        }
        CommonUtils.f(closeable2);
    }
    
    static void b(final File file, List<l> o) {
        for (final l l : o) {
            o = null;
            Closeable closeable = null;
            try {
                final InputStream g = l.g();
                if (g == null) {
                    o = g;
                }
                else {
                    closeable = g;
                    o = g;
                    closeable = g;
                    o = g;
                    final File file2 = new File(file, l.b());
                    closeable = g;
                    o = g;
                    a(g, file2);
                    o = g;
                }
            }
            catch (final IOException ex) {}
            finally {
                CommonUtils.f(closeable);
            }
        }
        goto Label_0103;
    }
}
