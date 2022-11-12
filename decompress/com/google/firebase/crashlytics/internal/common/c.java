// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.ByteArrayOutputStream;

class c implements l
{
    private final byte[] a;
    private final String b;
    private final String c;
    
    c(final String b, final String c, final byte[] a) {
        this.b = b;
        this.c = c;
        this.a = a;
    }
    
    private byte[] c() {
        if (this.d()) {
            return null;
        }
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gzipOutputStream.write(this.a);
                    gzipOutputStream.finish();
                    final byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gzipOutputStream.close();
                    byteArrayOutputStream.close();
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
        catch (final IOException ex) {
            return null;
        }
    }
    
    private boolean d() {
        final byte[] a = this.a;
        return a == null || a.length == 0;
    }
    
    @Override
    public CrashlyticsReport.FilesPayload.File a() {
        final byte[] c = this.c();
        Object a;
        if (c == null) {
            a = null;
        }
        else {
            a = CrashlyticsReport.FilesPayload.File.a().b(c).c(this.b).a();
        }
        return (CrashlyticsReport.FilesPayload.File)a;
    }
    
    @Override
    public String b() {
        return this.c;
    }
    
    @Override
    public InputStream g() {
        InputStream inputStream;
        if (this.d()) {
            inputStream = null;
        }
        else {
            inputStream = new ByteArrayInputStream(this.a);
        }
        return inputStream;
    }
}
