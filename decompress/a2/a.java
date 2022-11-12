// 
// Decompiled by Procyon v0.6.0
// 

package a2;

import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.io.EOFException;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.PrintStream;
import android.os.StrictMode$ThreadPolicy;
import android.os.StrictMode$ThreadPolicy$Builder;
import android.os.StrictMode;
import java.io.IOException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.io.File;
import java.io.Closeable;

public final class a implements Closeable
{
    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    private final int g;
    private long h;
    private Writer i;
    private final LinkedHashMap<String, d> j;
    private int p;
    private long w;
    final ThreadPoolExecutor x;
    private final Callable<Void> y;
    
    private a(final File a, final int e, final int g, final long f) {
        this.h = 0L;
        this.j = new LinkedHashMap<String, d>(0, 0.75f, true);
        this.w = 0L;
        this.x = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new b(null));
        this.y = new Callable<Void>() {
            final a a;
            
            public Void a() throws Exception {
                synchronized (this.a) {
                    if (a2.a.a(this.a) == null) {
                        return null;
                    }
                    a2.a.d(this.a);
                    if (a2.a.i(this.a)) {
                        a2.a.j(this.a);
                        a2.a.k(this.a, 0);
                    }
                    return null;
                }
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        };
        this.a = a;
        this.e = e;
        this.b = new File(a, "journal");
        this.c = new File(a, "journal.tmp");
        this.d = new File(a, "journal.bkp");
        this.g = g;
        this.f = f;
    }
    
    private c F(final String s, final long n) throws IOException {
        synchronized (this) {
            this.l();
            d d = this.j.get(s);
            if (n != -1L && (d == null || a2.a.d.c(d) != n)) {
                return null;
            }
            if (d == null) {
                d = new d(s, null);
                this.j.put(s, d);
            }
            else if (a2.a.d.g(d) != null) {
                return null;
            }
            final c c = new c(d, null);
            a2.a.d.h(d, c);
            this.i.append((CharSequence)"DIRTY");
            this.i.append(' ');
            this.i.append((CharSequence)s);
            this.i.append('\n');
            L(this.i);
            return c;
        }
    }
    
    private static void L(final Writer writer) throws IOException {
        final StrictMode$ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode$ThreadPolicy$Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        }
        finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
    
    private boolean O() {
        final int p = this.p;
        return p >= 2000 && p >= this.j.size();
    }
    
    public static a V(final File file, final int n, final int n2, final long n3) throws IOException {
        if (n3 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n2 > 0) {
            final File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                final File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                }
                else {
                    f0(file2, file3, false);
                }
            }
            final a a = new a(file, n, n2, n3);
            if (a.b.exists()) {
                try {
                    a.Z();
                    a.W();
                    return a;
                }
                catch (final IOException ex) {
                    final PrintStream out = System.out;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(file);
                    sb.append(" is corrupt: ");
                    sb.append(ex.getMessage());
                    sb.append(", removing");
                    out.println(sb.toString());
                    a.t();
                }
            }
            file.mkdirs();
            final a a2 = new a(file, n, n2, n3);
            a2.c0();
            return a2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }
    
    private void W() throws IOException {
        u(this.c);
        final Iterator<d> iterator = this.j.values().iterator();
        while (iterator.hasNext()) {
            final d d = iterator.next();
            final c g = a2.a.d.g(d);
            int i = 0;
            final int n = 0;
            if (g == null) {
                for (int j = n; j < this.g; ++j) {
                    this.h += a2.a.d.a(d)[j];
                }
            }
            else {
                a2.a.d.h(d, null);
                while (i < this.g) {
                    u(d.j(i));
                    u(d.k(i));
                    ++i;
                }
                iterator.remove();
            }
        }
    }
    
    private void Z() throws IOException {
        final a2.b b = new a2.b(new FileInputStream(this.b), a2.c.a);
        try {
            final String e = b.e();
            final String e2 = b.e();
            final String e3 = b.e();
            final String e4 = b.e();
            final String e5 = b.e();
            if ("libcore.io.DiskLruCache".equals(e) && "1".equals(e2) && Integer.toString(this.e).equals(e3) && Integer.toString(this.g).equals(e4) && "".equals(e5)) {
                int n = 0;
                try {
                    while (true) {
                        this.a0(b.e());
                        ++n;
                    }
                }
                catch (final EOFException ex) {
                    this.p = n - this.j.size();
                    if (b.d()) {
                        this.c0();
                    }
                    else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), a2.c.a));
                    }
                    return;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal header: [");
            sb.append(e);
            sb.append(", ");
            sb.append(e2);
            sb.append(", ");
            sb.append(e4);
            sb.append(", ");
            sb.append(e5);
            sb.append("]");
            throw new IOException(sb.toString());
        }
        finally {
            a2.c.a(b);
        }
    }
    
    static Writer a(final a a) {
        return a.i;
    }
    
    private void a0(final String s) throws IOException {
        final int index = s.indexOf(32);
        if (index != -1) {
            final int n = index + 1;
            final int index2 = s.indexOf(32, n);
            String s3;
            if (index2 == -1) {
                final String s2 = s3 = s.substring(n);
                if (index == 6) {
                    s3 = s2;
                    if (s.startsWith("REMOVE")) {
                        this.j.remove(s2);
                        return;
                    }
                }
            }
            else {
                s3 = s.substring(n, index2);
            }
            d d;
            if ((d = this.j.get(s3)) == null) {
                d = new d(s3, null);
                this.j.put(s3, d);
            }
            if (index2 != -1 && index == 5 && s.startsWith("CLEAN")) {
                final String[] split = s.substring(index2 + 1).split(" ");
                a2.a.d.f(d, true);
                a2.a.d.h(d, null);
                a2.a.d.i(d, split);
            }
            else if (index2 == -1 && index == 5 && s.startsWith("DIRTY")) {
                a2.a.d.h(d, new c(d, null));
            }
            else if (index2 != -1 || index != 4 || !s.startsWith("READ")) {
                final StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal line: ");
                sb.append(s);
                throw new IOException(sb.toString());
            }
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("unexpected journal line: ");
        sb2.append(s);
        throw new IOException(sb2.toString());
    }
    
    static int c(final a a) {
        return a.g;
    }
    
    private void c0() throws IOException {
        synchronized (this) {
            final Writer i = this.i;
            if (i != null) {
                r(i);
            }
            BufferedWriter j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), a2.c.a));
            try {
                j.write("libcore.io.DiskLruCache");
                j.write("\n");
                j.write("1");
                j.write("\n");
                j.write(Integer.toString(this.e));
                j.write("\n");
                j.write(Integer.toString(this.g));
                j.write("\n");
                j.write("\n");
                for (final d d : this.j.values()) {
                    if (a2.a.d.g(d) != null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(a2.a.d.b(d));
                        sb.append('\n');
                        j.write(sb.toString());
                    }
                    else {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(a2.a.d.b(d));
                        sb2.append(d.l());
                        sb2.append('\n');
                        j.write(sb2.toString());
                    }
                }
                r(j);
                if (this.b.exists()) {
                    f0(this.b, this.d, true);
                }
                f0(this.c, this.b, false);
                this.d.delete();
                j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), a2.c.a));
                this.i = j;
            }
            finally {
                r(j);
            }
        }
    }
    
    static void d(final a a) throws IOException {
        a.g0();
    }
    
    static File e(final a a) {
        return a.a;
    }
    
    private static void f0(final File file, final File file2, final boolean b) throws IOException {
        if (b) {
            u(file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException();
    }
    
    private void g0() throws IOException {
        while (this.h > this.f) {
            this.e0(((Map.Entry)this.j.entrySet().iterator().next()).getKey());
        }
    }
    
    static void h(final a a, final c c, final boolean b) throws IOException {
        a.s(c, b);
    }
    
    static boolean i(final a a) {
        return a.O();
    }
    
    static void j(final a a) throws IOException {
        a.c0();
    }
    
    static int k(final a a, final int p2) {
        return a.p = p2;
    }
    
    private void l() {
        if (this.i != null) {
            return;
        }
        throw new IllegalStateException("cache is closed");
    }
    
    private static void r(final Writer writer) throws IOException {
        final StrictMode$ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode$ThreadPolicy$Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        }
        finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
    
    private void s(final c c, final boolean b) throws IOException {
        synchronized (this) {
            final d c2 = a2.a.c.c(c);
            if (a2.a.d.g(c2) == c) {
                int i;
                final int n = i = 0;
                if (b) {
                    i = n;
                    if (!a2.a.d.e(c2)) {
                        int n2 = 0;
                        while (true) {
                            i = n;
                            if (n2 >= this.g) {
                                break;
                            }
                            if (!a2.a.c.d(c)[n2]) {
                                c.a();
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Newly created entry didn't create value for index ");
                                sb.append(n2);
                                throw new IllegalStateException(sb.toString());
                            }
                            if (!c2.k(n2).exists()) {
                                c.a();
                                return;
                            }
                            ++n2;
                        }
                    }
                }
                while (i < this.g) {
                    final File k = c2.k(i);
                    if (b) {
                        if (k.exists()) {
                            final File j = c2.j(i);
                            k.renameTo(j);
                            final long n3 = a2.a.d.a(c2)[i];
                            final long length = j.length();
                            a2.a.d.a(c2)[i] = length;
                            this.h = this.h - n3 + length;
                        }
                    }
                    else {
                        u(k);
                    }
                    ++i;
                }
                ++this.p;
                a2.a.d.h(c2, null);
                if (a2.a.d.e(c2) | b) {
                    a2.a.d.f(c2, true);
                    this.i.append((CharSequence)"CLEAN");
                    this.i.append(' ');
                    this.i.append((CharSequence)a2.a.d.b(c2));
                    this.i.append((CharSequence)c2.l());
                    this.i.append('\n');
                    if (b) {
                        final long w = this.w;
                        this.w = 1L + w;
                        a2.a.d.d(c2, w);
                    }
                }
                else {
                    this.j.remove(a2.a.d.b(c2));
                    this.i.append((CharSequence)"REMOVE");
                    this.i.append(' ');
                    this.i.append((CharSequence)a2.a.d.b(c2));
                    this.i.append('\n');
                }
                L(this.i);
                if (this.h > this.f || this.O()) {
                    this.x.submit(this.y);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }
    
    private static void u(final File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }
    
    public c E(final String s) throws IOException {
        return this.F(s, -1L);
    }
    
    public e M(final String s) throws IOException {
        synchronized (this) {
            this.l();
            final d d = this.j.get(s);
            if (d == null) {
                return null;
            }
            if (!a2.a.d.e(d)) {
                return null;
            }
            final File[] c = d.c;
            for (int length = c.length, i = 0; i < length; ++i) {
                if (!c[i].exists()) {
                    return null;
                }
            }
            ++this.p;
            this.i.append((CharSequence)"READ");
            this.i.append(' ');
            this.i.append((CharSequence)s);
            this.i.append('\n');
            if (this.O()) {
                this.x.submit(this.y);
            }
            return new e(s, a2.a.d.c(d), d.c, a2.a.d.a(d), null);
        }
    }
    
    @Override
    public void close() throws IOException {
        synchronized (this) {
            if (this.i == null) {
                return;
            }
            for (final d d : new ArrayList(this.j.values())) {
                if (a2.a.d.g(d) != null) {
                    a2.a.d.g(d).a();
                }
            }
            this.g0();
            r(this.i);
            this.i = null;
        }
    }
    
    public boolean e0(final String s) throws IOException {
        synchronized (this) {
            this.l();
            final d d = this.j.get(s);
            int i = 0;
            if (d != null && a2.a.d.g(d) == null) {
                while (i < this.g) {
                    final File j = d.j(i);
                    if (j.exists() && !j.delete()) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("failed to delete ");
                        sb.append(j);
                        throw new IOException(sb.toString());
                    }
                    this.h -= a2.a.d.a(d)[i];
                    a2.a.d.a(d)[i] = 0L;
                    ++i;
                }
                ++this.p;
                this.i.append((CharSequence)"REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence)s);
                this.i.append('\n');
                this.j.remove(s);
                if (this.O()) {
                    this.x.submit(this.y);
                }
                return true;
            }
            return false;
        }
    }
    
    public void t() throws IOException {
        this.close();
        a2.c.b(this.a);
    }
    
    private static final class b implements ThreadFactory
    {
        private b() {
        }
        
        b(final a$a callable) {
            this();
        }
        
        @Override
        public Thread newThread(final Runnable runnable) {
            synchronized (this) {
                final Thread thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                thread.setPriority(1);
                return thread;
            }
        }
    }
    
    public final class c
    {
        private final d a;
        private final boolean[] b;
        private boolean c;
        final a d;
        
        private c(final a d, final d a) {
            this.d = d;
            this.a = a;
            boolean[] b;
            if (a2.a.d.e(a)) {
                b = null;
            }
            else {
                b = new boolean[a2.a.c(d)];
            }
            this.b = b;
        }
        
        c(final a a, final d d, final a$a callable) {
            this(a, d);
        }
        
        static d c(final c c) {
            return c.a;
        }
        
        static boolean[] d(final c c) {
            return c.b;
        }
        
        public void a() throws IOException {
            a2.a.h(this.d, this, false);
        }
        
        public void b() {
            if (this.c) {
                return;
            }
            try {
                this.a();
            }
            catch (final IOException ex) {}
        }
        
        public void e() throws IOException {
            a2.a.h(this.d, this, true);
            this.c = true;
        }
        
        public File f(final int n) throws IOException {
            synchronized (this.d) {
                if (a2.a.d.g(this.a) == this) {
                    if (!a2.a.d.e(this.a)) {
                        this.b[n] = true;
                    }
                    final File k = this.a.k(n);
                    a2.a.e(this.d).mkdirs();
                    return k;
                }
                throw new IllegalStateException();
            }
        }
    }
    
    private final class d
    {
        private final String a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private c f;
        private long g;
        final a h;
        
        private d(final a h, final String a) {
            this.h = h;
            this.a = a;
            this.b = new long[a2.a.c(h)];
            this.c = new File[a2.a.c(h)];
            this.d = new File[a2.a.c(h)];
            final StringBuilder sb = new StringBuilder(a);
            sb.append('.');
            final int length = sb.length();
            for (int i = 0; i < a2.a.c(h); ++i) {
                sb.append(i);
                this.c[i] = new File(a2.a.e(h), sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(a2.a.e(h), sb.toString());
                sb.setLength(length);
            }
        }
        
        d(final a a, final String s, final a$a callable) {
            this(a, s);
        }
        
        static long[] a(final d d) {
            return d.b;
        }
        
        static String b(final d d) {
            return d.a;
        }
        
        static long c(final d d) {
            return d.g;
        }
        
        static long d(final d d, final long g) {
            return d.g = g;
        }
        
        static boolean e(final d d) {
            return d.e;
        }
        
        static boolean f(final d d, final boolean e) {
            return d.e = e;
        }
        
        static c g(final d d) {
            return d.f;
        }
        
        static c h(final d d, final c f) {
            return d.f = f;
        }
        
        static void i(final d d, final String[] array) throws IOException {
            d.n(array);
        }
        
        private IOException m(final String[] array) throws IOException {
            final StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(array));
            throw new IOException(sb.toString());
        }
        
        private void n(final String[] array) throws IOException {
            if (array.length == a2.a.c(this.h)) {
                int i = 0;
                try {
                    while (i < array.length) {
                        this.b[i] = Long.parseLong(array[i]);
                        ++i;
                    }
                    return;
                }
                catch (final NumberFormatException ex) {
                    throw this.m(array);
                }
            }
            throw this.m(array);
        }
        
        public File j(final int n) {
            return this.c[n];
        }
        
        public File k(final int n) {
            return this.d[n];
        }
        
        public String l() throws IOException {
            final StringBuilder sb = new StringBuilder();
            for (final long n : this.b) {
                sb.append(' ');
                sb.append(n);
            }
            return sb.toString();
        }
    }
    
    public final class e
    {
        private final String a;
        private final long b;
        private final long[] c;
        private final File[] d;
        final a e;
        
        private e(final a e, final String a, final long b, final File[] d, final long[] c) {
            this.e = e;
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = c;
        }
        
        e(final a a, final String s, final long n, final File[] array, final long[] array2, final a$a callable) {
            this(a, s, n, array, array2);
        }
        
        public File a(final int n) {
            return this.d[n];
        }
    }
}
