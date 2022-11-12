// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.g;
import android.util.Log;
import t0.c;
import t0.a;
import java.util.Objects;
import java.nio.channels.ReadableByteChannel;
import java.io.IOException;
import t0.d;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.channels.Channels;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.io.File;
import android.content.Context;
import v0.h;

class v0 implements h, p
{
    private final Context a;
    private final String b;
    private final File c;
    private final Callable<InputStream> d;
    private final int e;
    private final h f;
    private o g;
    private boolean h;
    
    v0(final Context a, final String b, final File c, final Callable<InputStream> d, final int e, final h f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    private void a(final File file, final boolean b) throws IOException {
        Label_0077: {
            if (this.b != null) {
                final ReadableByteChannel readableByteChannel = Channels.newChannel(this.a.getAssets().open(this.b));
                break Label_0077;
            }
            if (this.c != null) {
                final ReadableByteChannel readableByteChannel = new FileInputStream(this.c).getChannel();
                break Label_0077;
            }
            final Callable<InputStream> d = this.d;
            if (d == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                final ReadableByteChannel readableByteChannel = Channels.newChannel(d.call());
                final File tempFile = File.createTempFile("room-copy-helper", ".tmp", this.a.getCacheDir());
                tempFile.deleteOnExit();
                t0.d.a(readableByteChannel, new FileOutputStream(tempFile).getChannel());
                final File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to create directories for ");
                    sb.append(file.getAbsolutePath());
                    throw new IOException(sb.toString());
                }
                this.c(tempFile, b);
                if (tempFile.renameTo(file)) {
                    return;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to move intermediate file (");
                sb2.append(tempFile.getAbsolutePath());
                sb2.append(") to destination (");
                sb2.append(file.getAbsolutePath());
                sb2.append(").");
                throw new IOException(sb2.toString());
            }
            catch (final Exception ex) {
                throw new IOException("inputStreamCallable exception on call", ex);
            }
        }
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }
    
    private void c(final File file, final boolean b) {
        final o g = this.g;
        if (g != null) {
            Objects.requireNonNull(g);
        }
    }
    
    private void e(final boolean b) {
        final String databaseName = this.getDatabaseName();
        final File databasePath = this.a.getDatabasePath(databaseName);
        final o g = this.g;
        final t0.a a = new t0.a(databaseName, this.a.getFilesDir(), g == null || g.l);
        try {
            a.b();
            if (!databasePath.exists()) {
                try {
                    this.a(databasePath, b);
                    return;
                }
                catch (final IOException ex) {
                    throw new RuntimeException("Unable to copy database file.", ex);
                }
            }
            if (this.g == null) {
                return;
            }
            try {
                final int d = t0.c.d(databasePath);
                final int e = this.e;
                if (d == e) {
                    return;
                }
                if (this.g.a(d, e)) {
                    return;
                }
                if (this.a.deleteDatabase(databaseName)) {
                    try {
                        this.a(databasePath, b);
                    }
                    catch (final IOException ex2) {
                        Log.w("ROOM", "Unable to copy database file.", (Throwable)ex2);
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to delete database file (");
                    sb.append(databaseName);
                    sb.append(") for a copy destructive migration.");
                    Log.w("ROOM", sb.toString());
                }
            }
            catch (final IOException ex3) {
                Log.w("ROOM", "Unable to read database version.", (Throwable)ex3);
            }
        }
        finally {
            a.c();
        }
    }
    
    @Override
    public void close() {
        synchronized (this) {
            this.f.close();
            this.h = false;
        }
    }
    
    void d(final o g) {
        this.g = g;
    }
    
    @Override
    public String getDatabaseName() {
        return this.f.getDatabaseName();
    }
    
    @Override
    public h getDelegate() {
        return this.f;
    }
    
    @Override
    public g getWritableDatabase() {
        synchronized (this) {
            if (!this.h) {
                this.e(true);
                this.h = true;
            }
            return this.f.getWritableDatabase();
        }
    }
    
    @Override
    public void setWriteAheadLoggingEnabled(final boolean writeAheadLoggingEnabled) {
        this.f.setWriteAheadLoggingEnabled(writeAheadLoggingEnabled);
    }
}
