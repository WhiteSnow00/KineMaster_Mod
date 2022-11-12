// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.metadata;

import java.util.logging.Level;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.logging.Logger;
import java.io.Closeable;

class QueueFile implements Closeable
{
    private static final Logger g;
    private final RandomAccessFile a;
    int b;
    private int c;
    private b d;
    private b e;
    private final byte[] f;
    
    static {
        g = Logger.getLogger(QueueFile.class.getName());
    }
    
    public QueueFile(final File file) throws IOException {
        this.f = new byte[16];
        if (!file.exists()) {
            r(file);
        }
        this.a = u(file);
        this.F();
    }
    
    private b E(final int n) throws IOException {
        if (n == 0) {
            return QueueFile.b.c;
        }
        this.a.seek(n);
        return new b(n, this.a.readInt());
    }
    
    private void F() throws IOException {
        this.a.seek(0L);
        this.a.readFully(this.f);
        final int l = L(this.f, 0);
        this.b = l;
        if (l <= this.a.length()) {
            this.c = L(this.f, 4);
            final int i = L(this.f, 8);
            final int j = L(this.f, 12);
            this.d = this.E(i);
            this.e = this.E(j);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("File is truncated. Expected length: ");
        sb.append(this.b);
        sb.append(", Actual length: ");
        sb.append(this.a.length());
        throw new IOException(sb.toString());
    }
    
    private static int L(final byte[] array, final int n) {
        return ((array[n] & 0xFF) << 24) + ((array[n + 1] & 0xFF) << 16) + ((array[n + 2] & 0xFF) << 8) + (array[n + 3] & 0xFF);
    }
    
    private int M() {
        return this.b - this.a0();
    }
    
    private void V(int c0, final byte[] array, final int n, final int n2) throws IOException {
        c0 = this.c0(c0);
        final int b = this.b;
        if (c0 + n2 <= b) {
            this.a.seek(c0);
            this.a.readFully(array, n, n2);
        }
        else {
            final int n3 = b - c0;
            this.a.seek(c0);
            this.a.readFully(array, n, n3);
            this.a.seek(16L);
            this.a.readFully(array, n + n3, n2 - n3);
        }
    }
    
    private void W(int c0, final byte[] array, final int n, final int n2) throws IOException {
        c0 = this.c0(c0);
        final int b = this.b;
        if (c0 + n2 <= b) {
            this.a.seek(c0);
            this.a.write(array, n, n2);
        }
        else {
            final int n3 = b - c0;
            this.a.seek(c0);
            this.a.write(array, n, n3);
            this.a.seek(16L);
            this.a.write(array, n + n3, n2 - n3);
        }
    }
    
    private void Z(final int n) throws IOException {
        this.a.setLength(n);
        this.a.getChannel().force(true);
    }
    
    static int a(final QueueFile queueFile, final int n) {
        return queueFile.c0(n);
    }
    
    static Object c(final Object o, final String s) {
        return t(o, s);
    }
    
    private int c0(int n) {
        final int b = this.b;
        if (n >= b) {
            n = n + 16 - b;
        }
        return n;
    }
    
    static void d(final QueueFile queueFile, final int n, final byte[] array, final int n2, final int n3) throws IOException {
        queueFile.V(n, array, n2, n3);
    }
    
    static RandomAccessFile e(final QueueFile queueFile) {
        return queueFile.a;
    }
    
    private void e0(final int n, final int n2, final int n3, final int n4) throws IOException {
        g0(this.f, n, n2, n3, n4);
        this.a.seek(0L);
        this.a.write(this.f);
    }
    
    private static void f0(final byte[] array, final int n, final int n2) {
        array[n] = (byte)(n2 >> 24);
        array[n + 1] = (byte)(n2 >> 16);
        array[n + 2] = (byte)(n2 >> 8);
        array[n + 3] = (byte)n2;
    }
    
    private static void g0(final byte[] array, final int... array2) {
        final int length = array2.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            f0(array, n, array2[i]);
            n += 4;
            ++i;
        }
    }
    
    private void k(int n) throws IOException {
        final int n2 = n + 4;
        int m = this.M();
        if (m >= n2) {
            return;
        }
        n = this.b;
        int i;
        int b;
        do {
            i = m + n;
            b = n << 1;
            m = i;
            n = b;
        } while (i < n2);
        this.Z(b);
        final b e = this.e;
        n = this.c0(e.a + 4 + e.b);
        if (n < this.d.a) {
            final FileChannel channel = this.a.getChannel();
            channel.position(this.b);
            final long n3 = n - 4;
            if (channel.transferTo(16L, n3, channel) != n3) {
                throw new AssertionError((Object)"Copied insufficient number of bytes!");
            }
        }
        final int a = this.e.a;
        n = this.d.a;
        if (a < n) {
            final int n4 = this.b + a - 16;
            this.e0(b, this.c, n, n4);
            this.e = new b(n4, this.e.b);
        }
        else {
            this.e0(b, this.c, n, a);
        }
        this.b = b;
    }
    
    private static void r(final File file) throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append(".tmp");
        final File file2 = new File(sb.toString());
        final RandomAccessFile u = u(file2);
        try {
            u.setLength(4096L);
            u.seek(0L);
            final byte[] array = new byte[16];
            g0(array, 4096, 0, 0, 0);
            u.write(array);
            u.close();
            if (file2.renameTo(file)) {
                return;
            }
            throw new IOException("Rename failed!");
        }
        finally {
            u.close();
        }
    }
    
    private static <T> T t(final T t, final String s) {
        Objects.requireNonNull(t, s);
        return t;
    }
    
    private static RandomAccessFile u(final File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }
    
    public void O() throws IOException {
        synchronized (this) {
            if (!this.s()) {
                if (this.c == 1) {
                    this.j();
                }
                else {
                    final b d = this.d;
                    final int c0 = this.c0(d.a + 4 + d.b);
                    this.V(c0, this.f, 0, 4);
                    final int l = L(this.f, 0);
                    this.e0(this.b, this.c - 1, c0, this.e.a);
                    --this.c;
                    this.d = new b(c0, l);
                }
                return;
            }
            throw new NoSuchElementException();
        }
    }
    
    public int a0() {
        if (this.c == 0) {
            return 16;
        }
        final b e = this.e;
        final int a = e.a;
        final int a2 = this.d.a;
        if (a >= a2) {
            return a - a2 + 4 + e.b + 16;
        }
        return a + 4 + e.b + this.b - a2;
    }
    
    @Override
    public void close() throws IOException {
        synchronized (this) {
            this.a.close();
        }
    }
    
    public void h(final byte[] array) throws IOException {
        this.i(array, 0, array.length);
    }
    
    public void i(final byte[] array, int n, final int n2) throws IOException {
        synchronized (this) {
            t(array, "buffer");
            if ((n | n2) >= 0 && n2 <= array.length - n) {
                this.k(n2);
                final boolean s = this.s();
                int c0;
                if (s) {
                    c0 = 16;
                }
                else {
                    final b e = this.e;
                    c0 = this.c0(e.a + 4 + e.b);
                }
                final b b = new b(c0, n2);
                f0(this.f, 0, n2);
                this.W(b.a, this.f, 0, 4);
                this.W(b.a + 4, array, n, n2);
                if (s) {
                    n = b.a;
                }
                else {
                    n = this.d.a;
                }
                this.e0(this.b, this.c + 1, n, b.a);
                this.e = b;
                ++this.c;
                if (s) {
                    this.d = b;
                }
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void j() throws IOException {
        synchronized (this) {
            this.e0(4096, 0, 0, 0);
            this.c = 0;
            final b c = QueueFile.b.c;
            this.d = c;
            this.e = c;
            if (this.b > 4096) {
                this.Z(4096);
            }
            this.b = 4096;
        }
    }
    
    public void l(final ElementReader elementReader) throws IOException {
        synchronized (this) {
            int n = this.d.a;
            for (int i = 0; i < this.c; ++i) {
                final b e = this.E(n);
                elementReader.a(new c(e, null), e.b);
                n = this.c0(e.a + 4 + e.b);
            }
        }
    }
    
    public boolean s() {
        synchronized (this) {
            return this.c == 0;
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.b);
        sb.append(", size=");
        sb.append(this.c);
        sb.append(", first=");
        sb.append(this.d);
        sb.append(", last=");
        sb.append(this.e);
        sb.append(", element lengths=[");
        try {
            this.l((ElementReader)new ElementReader(this, sb) {
                boolean a = true;
                final StringBuilder b;
                final QueueFile c;
                
                @Override
                public void a(final InputStream inputStream, final int n) throws IOException {
                    if (this.a) {
                        this.a = false;
                    }
                    else {
                        this.b.append(", ");
                    }
                    this.b.append(n);
                }
            });
        }
        catch (final IOException ex) {
            QueueFile.g.log(Level.WARNING, "read error", ex);
        }
        sb.append("]]");
        return sb.toString();
    }
    
    public interface ElementReader
    {
        void a(final InputStream p0, final int p1) throws IOException;
    }
    
    static class b
    {
        static final b c;
        final int a;
        final int b;
        
        static {
            c = new b(0, 0);
        }
        
        b(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.a);
            sb.append(", length = ");
            sb.append(this.b);
            sb.append("]");
            return sb.toString();
        }
    }
    
    private final class c extends InputStream
    {
        private int a;
        private int b;
        final QueueFile c;
        
        private c(final QueueFile c, final b b) {
            this.c = c;
            this.a = QueueFile.a(c, b.a + 4);
            this.b = b.b;
        }
        
        c(final QueueFile queueFile, final b b, final QueueFile$a elementReader) {
            this(queueFile, b);
        }
        
        @Override
        public int read() throws IOException {
            if (this.b == 0) {
                return -1;
            }
            QueueFile.e(this.c).seek(this.a);
            final int read = QueueFile.e(this.c).read();
            this.a = QueueFile.a(this.c, this.a + 1);
            --this.b;
            return read;
        }
        
        @Override
        public int read(final byte[] array, final int n, final int n2) throws IOException {
            QueueFile.c(array, "buffer");
            if ((n | n2) < 0 || n2 > array.length - n) {
                throw new ArrayIndexOutOfBoundsException();
            }
            final int b = this.b;
            if (b > 0) {
                int n3;
                if ((n3 = n2) > b) {
                    n3 = b;
                }
                QueueFile.d(this.c, this.a, array, n, n3);
                this.a = QueueFile.a(this.c, this.a + n3);
                this.b -= n3;
                return n3;
            }
            return -1;
        }
    }
}
