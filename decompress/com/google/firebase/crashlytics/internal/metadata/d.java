// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.metadata;

import java.io.Closeable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.InputStream;
import java.io.IOException;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.io.File;
import java.nio.charset.Charset;

class d implements a
{
    private static final Charset d;
    private final File a;
    private final int b;
    private QueueFile c;
    
    static {
        d = Charset.forName("UTF-8");
    }
    
    d(final File a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    private void f(final long n, String s) {
        if (this.c == null) {
            return;
        }
        String s2;
        if ((s2 = s) == null) {
            s2 = "null";
        }
        try {
            final int n2 = this.b / 4;
            s = s2;
            if (s2.length() > n2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("...");
                sb.append(s2.substring(s2.length() - n2));
                s = sb.toString();
            }
            s = s.replaceAll("\r", " ").replaceAll("\n", " ");
            this.c.h(String.format(Locale.US, "%d %s%n", n, s).getBytes(com.google.firebase.crashlytics.internal.metadata.d.d));
            while (!this.c.s() && this.c.a0() > this.b) {
                this.c.O();
            }
        }
        catch (final IOException ex) {
            Logger.f().e("There was a problem writing to the Crashlytics log.", ex);
        }
    }
    
    private b g() {
        if (!this.a.exists()) {
            return null;
        }
        this.h();
        final QueueFile c = this.c;
        if (c == null) {
            return null;
        }
        final int[] array = { 0 };
        final byte[] array2 = new byte[c.a0()];
        try {
            this.c.l((QueueFile.ElementReader)new QueueFile.ElementReader(this, array2, array) {
                final byte[] a;
                final int[] b;
                final d c;
                
                @Override
                public void a(final InputStream inputStream, final int n) throws IOException {
                    try {
                        inputStream.read(this.a, this.b[0], n);
                        final int[] b = this.b;
                        b[0] += n;
                    }
                    finally {
                        inputStream.close();
                    }
                }
            });
        }
        catch (final IOException ex) {
            Logger.f().e("A problem occurred while reading the Crashlytics log file.", ex);
        }
        return new b(array2, array[0]);
    }
    
    private void h() {
        if (this.c == null) {
            try {
                this.c = new QueueFile(this.a);
            }
            catch (final IOException ex) {
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not open log file: ");
                sb.append(this.a);
                f.e(sb.toString(), ex);
            }
        }
    }
    
    @Override
    public void a() {
        CommonUtils.e(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }
    
    @Override
    public String b() {
        final byte[] c = this.c();
        String s;
        if (c != null) {
            s = new String(c, com.google.firebase.crashlytics.internal.metadata.d.d);
        }
        else {
            s = null;
        }
        return s;
    }
    
    @Override
    public byte[] c() {
        final b g = this.g();
        if (g == null) {
            return null;
        }
        final int b = g.b;
        final byte[] array = new byte[b];
        System.arraycopy(g.a, 0, array, 0, b);
        return array;
    }
    
    @Override
    public void d() {
        this.a();
        this.a.delete();
    }
    
    @Override
    public void e(final long n, final String s) {
        this.h();
        this.f(n, s);
    }
    
    private static class b
    {
        public final byte[] a;
        public final int b;
        
        b(final byte[] a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
}
