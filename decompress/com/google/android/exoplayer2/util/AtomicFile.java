// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;

public final class AtomicFile
{
    private final File a;
    private final File b;
    
    public AtomicFile(final File a) {
        this.a = a;
        final StringBuilder sb = new StringBuilder();
        sb.append(a.getPath());
        sb.append(".bak");
        this.b = new File(sb.toString());
    }
    
    private void e() {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
    }
    
    public void a() {
        this.a.delete();
        this.b.delete();
    }
    
    public void b(final OutputStream outputStream) throws IOException {
        outputStream.close();
        this.b.delete();
    }
    
    public boolean c() {
        return this.a.exists() || this.b.exists();
    }
    
    public InputStream d() throws FileNotFoundException {
        this.e();
        return new FileInputStream(this.a);
    }
    
    public OutputStream f() throws IOException {
        if (this.a.exists()) {
            if (!this.b.exists()) {
                if (!this.a.renameTo(this.b)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Couldn't rename file ");
                    sb.append(this.a);
                    sb.append(" to backup file ");
                    sb.append(this.b);
                    Log.i("AtomicFile", sb.toString());
                }
            }
            else {
                this.a.delete();
            }
        }
        try {
            return new a(this.a);
        }
        catch (final FileNotFoundException ex) {
            final File parentFile = this.a.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    return new a(this.a);
                }
                catch (final FileNotFoundException ex2) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Couldn't create ");
                    sb2.append(this.a);
                    throw new IOException(sb2.toString(), ex2);
                }
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Couldn't create ");
            sb3.append(this.a);
            throw new IOException(sb3.toString(), ex);
        }
    }
    
    private static final class a extends OutputStream
    {
        private final FileOutputStream a;
        private boolean b;
        
        public a(final File file) throws FileNotFoundException {
            this.b = false;
            this.a = new FileOutputStream(file);
        }
        
        @Override
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            this.flush();
            try {
                this.a.getFD().sync();
            }
            catch (final IOException ex) {
                Log.j("AtomicFile", "Failed to sync file descriptor:", ex);
            }
            this.a.close();
        }
        
        @Override
        public void flush() throws IOException {
            this.a.flush();
        }
        
        @Override
        public void write(final int n) throws IOException {
            this.a.write(n);
        }
        
        @Override
        public void write(final byte[] array) throws IOException {
            this.a.write(array);
        }
        
        @Override
        public void write(final byte[] array, final int n, final int n2) throws IOException {
            this.a.write(array, n, n2);
        }
    }
}
