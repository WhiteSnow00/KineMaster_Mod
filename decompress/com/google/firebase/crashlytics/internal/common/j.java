// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

class j implements l
{
    private final File a;
    private final String b;
    private final String c;
    
    j(final String b, final String c, final File a) {
        this.b = b;
        this.c = c;
        this.a = a;
    }
    
    private byte[] c() {
        final byte[] array = new byte[8192];
        try {
            final InputStream g = this.g();
            try {
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (g == null) {
                        gzipOutputStream.close();
                        byteArrayOutputStream.close();
                        if (g != null) {
                            g.close();
                        }
                        return null;
                    }
                    Label_0054: {
                        break Label_0054;
                        try {
                            while (true) {
                                final int read = g.read(array);
                                if (read <= 0) {
                                    break;
                                }
                                gzipOutputStream.write(array, 0, read);
                            }
                            gzipOutputStream.finish();
                            final byte[] byteArray = byteArrayOutputStream.toByteArray();
                            gzipOutputStream.close();
                            byteArrayOutputStream.close();
                            g.close();
                            return byteArray;
                        }
                        finally {
                            try {
                                gzipOutputStream.close();
                            }
                            finally {
                                final Throwable t;
                                final Throwable t2;
                                t.addSuppressed(t2);
                            }
                        }
                    }
                }
                finally {
                    try {
                        byteArrayOutputStream.close();
                    }
                    finally {
                        final Throwable t3;
                        final Throwable t4;
                        t3.addSuppressed(t4);
                    }
                }
            }
            finally {
                if (g != null) {
                    try {
                        g.close();
                    }
                    finally {
                        final Throwable t5;
                        final Throwable t6;
                        t5.addSuppressed(t6);
                    }
                }
            }
        }
        catch (final IOException ex) {
            return null;
        }
    }
    
    @Override
    public CrashlyticsReport.FilesPayload.File a() {
        final byte[] c = this.c();
        Object a;
        if (c != null) {
            a = CrashlyticsReport.FilesPayload.File.a().b(c).c(this.b).a();
        }
        else {
            a = null;
        }
        return (CrashlyticsReport.FilesPayload.File)a;
    }
    
    @Override
    public String b() {
        return this.c;
    }
    
    @Override
    public InputStream g() {
        Label_0037: {
            if (!this.a.exists()) {
                break Label_0037;
            }
            if (!this.a.isFile()) {
                break Label_0037;
            }
            try {
                return new FileInputStream(this.a);
                return null;
            }
            catch (final FileNotFoundException ex) {
                return null;
            }
        }
    }
}
