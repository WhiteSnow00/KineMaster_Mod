// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.util.Map;
import java.security.SecureRandom;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.io.IOException;
import com.google.android.exoplayer2.util.Log;
import android.os.ConditionVariable;
import com.google.android.exoplayer2.database.DatabaseProvider;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.HashSet;

public final class SimpleCache implements Cache
{
    private static final HashSet<File> l;
    private final File a;
    private final CacheEvictor b;
    private final d c;
    private final b d;
    private final HashMap<String, ArrayList<Listener>> e;
    private final Random f;
    private final boolean g;
    private long h;
    private long i;
    private boolean j;
    private CacheException k;
    
    static {
        l = new HashSet<File>();
    }
    
    public SimpleCache(final File file, final CacheEvictor cacheEvictor, final DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }
    
    public SimpleCache(final File file, final CacheEvictor cacheEvictor, final DatabaseProvider databaseProvider, final byte[] array, final boolean b, final boolean b2) {
        final d d = new d(databaseProvider, file, array, b, b2);
        b b3;
        if (databaseProvider != null && !b2) {
            b3 = new b(databaseProvider);
        }
        else {
            b3 = null;
        }
        this(file, cacheEvictor, d, b3);
    }
    
    SimpleCache(final File a, final CacheEvictor b, final d c, final b d) {
        if (w(a)) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = new HashMap<String, ArrayList<Listener>>();
            this.f = new Random();
            this.g = b.b();
            this.h = -1L;
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread(this, "ExoPlayer:SimpleCacheInit", conditionVariable) {
                final ConditionVariable a;
                final SimpleCache b;
                
                @Override
                public void run() {
                    synchronized (this.b) {
                        this.a.open();
                        SimpleCache.l(this.b);
                        SimpleCache.m(this.b).f();
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Another SimpleCache instance uses the folder: ");
        sb.append(a);
        throw new IllegalStateException(sb.toString());
    }
    
    private static long A(final String s) {
        return Long.parseLong(s.substring(0, s.indexOf(46)), 16);
    }
    
    private void C(final CacheSpan cacheSpan) {
        final c g = this.c.g(cacheSpan.a);
        if (g != null) {
            if (g.k(cacheSpan)) {
                this.i -= cacheSpan.c;
                if (this.d != null) {
                    final String name = cacheSpan.e.getName();
                    try {
                        this.d.f(name);
                    }
                    catch (final IOException ex) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Failed to remove file index entry for: ");
                        sb.append(name);
                        Log.i("SimpleCache", sb.toString());
                    }
                }
                this.c.p(g.b);
                this.y(cacheSpan);
            }
        }
    }
    
    private void D() {
        final ArrayList list = new ArrayList();
        final Iterator<c> iterator = this.c.h().iterator();
        while (iterator.hasNext()) {
            for (final CacheSpan cacheSpan : iterator.next().f()) {
                if (cacheSpan.e.length() != cacheSpan.c) {
                    list.add(cacheSpan);
                }
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            this.C((CacheSpan)list.get(i));
        }
    }
    
    private f E(final String s, final f f) {
        if (!this.g) {
            return f;
        }
        final String name = Assertions.e(f.e).getName();
        final long c = f.c;
        final long currentTimeMillis = System.currentTimeMillis();
        boolean b = false;
        final b d = this.d;
        if (d != null) {
            try {
                d.h(name, c, currentTimeMillis);
            }
            catch (final IOException ex) {
                Log.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
        }
        else {
            b = true;
        }
        final f l = this.c.g(s).l(f, currentTimeMillis, b);
        this.z(f, l);
        return l;
    }
    
    private static void F(final File file) {
        synchronized (SimpleCache.class) {
            SimpleCache.l.remove(file.getAbsoluteFile());
        }
    }
    
    static void l(final SimpleCache simpleCache) {
        simpleCache.s();
    }
    
    static CacheEvictor m(final SimpleCache simpleCache) {
        return simpleCache.b;
    }
    
    private void n(final f f) {
        this.c.m(f.a).a(f);
        this.i += f.c;
        this.x(f);
    }
    
    private static void p(final File file) throws CacheException {
        if (!file.mkdirs() && !file.isDirectory()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to create cache directory: ");
            sb.append(file);
            final String string = sb.toString();
            Log.c("SimpleCache", string);
            throw new CacheException(string);
        }
    }
    
    private static long q(final File file) throws IOException {
        final long nextLong = new SecureRandom().nextLong();
        long abs;
        if (nextLong == Long.MIN_VALUE) {
            abs = 0L;
        }
        else {
            abs = Math.abs(nextLong);
        }
        final String string = Long.toString(abs, 16);
        final StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(".uid");
        final File file2 = new File(file, sb.toString());
        if (file2.createNewFile()) {
            return abs;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to create UID file: ");
        sb2.append(file2);
        throw new IOException(sb2.toString());
    }
    
    private f r(final String s, final long n, final long n2) {
        final c g = this.c.g(s);
        if (g == null) {
            return com.google.android.exoplayer2.upstream.cache.f.i(s, n, n2);
        }
        f e;
        while (true) {
            e = g.e(n, n2);
            if (!e.d || e.e.length() == e.c) {
                break;
            }
            this.D();
        }
        return e;
    }
    
    private void s() {
        if (!this.a.exists()) {
            try {
                p(this.a);
            }
            catch (final CacheException k) {
                this.k = k;
                return;
            }
        }
        final File[] listFiles = this.a.listFiles();
        if (listFiles == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to list cache directory files: ");
            sb.append(this.a);
            final String string = sb.toString();
            Log.c("SimpleCache", string);
            this.k = new CacheException(string);
            return;
        }
        final long v = v(listFiles);
        this.h = v;
        if (v == -1L) {
            try {
                this.h = q(this.a);
            }
            catch (final IOException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to create cache UID: ");
                sb2.append(this.a);
                final String string2 = sb2.toString();
                Log.d("SimpleCache", string2, ex);
                this.k = new CacheException(string2, ex);
                return;
            }
        }
        try {
            this.c.n(this.h);
            final b d = this.d;
            if (d != null) {
                d.e(this.h);
                final Map<String, a> b = this.d.b();
                this.u(this.a, true, listFiles, b);
                this.d.g(b.keySet());
            }
            else {
                this.u(this.a, true, listFiles, null);
            }
            this.c.r();
            try {
                this.c.s();
            }
            catch (final IOException ex2) {
                Log.d("SimpleCache", "Storing index file failed", ex2);
            }
        }
        catch (final IOException ex3) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to initialize cache indices: ");
            sb3.append(this.a);
            final String string3 = sb3.toString();
            Log.d("SimpleCache", string3, ex3);
            this.k = new CacheException(string3, ex3);
        }
    }
    
    private void u(final File file, final boolean b, final File[] array, final Map<String, a> map) {
        if (array != null && array.length != 0) {
            for (final File file2 : array) {
                final String name = file2.getName();
                Label_0173: {
                    if (b && name.indexOf(46) == -1) {
                        this.u(file2, false, file2.listFiles(), map);
                    }
                    else {
                        if (b) {
                            if (com.google.android.exoplayer2.upstream.cache.d.o(name)) {
                                break Label_0173;
                            }
                            if (name.endsWith(".uid")) {
                                break Label_0173;
                            }
                        }
                        long a = -1L;
                        long b2 = -9223372036854775807L;
                        a a2;
                        if (map != null) {
                            a2 = map.remove(name);
                        }
                        else {
                            a2 = null;
                        }
                        if (a2 != null) {
                            a = a2.a;
                            b2 = a2.b;
                        }
                        final f g = com.google.android.exoplayer2.upstream.cache.f.g(file2, a, b2, this.c);
                        if (g != null) {
                            this.n(g);
                        }
                        else {
                            file2.delete();
                        }
                    }
                }
            }
            return;
        }
        if (!b) {
            file.delete();
        }
    }
    
    private static long v(final File[] array) {
        for (final File file : array) {
            final String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return A(name);
                }
                catch (final NumberFormatException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Malformed UID file: ");
                    sb.append(file);
                    Log.c("SimpleCache", sb.toString());
                    file.delete();
                }
            }
        }
        return -1L;
    }
    
    private static boolean w(final File file) {
        synchronized (SimpleCache.class) {
            return SimpleCache.l.add(file.getAbsoluteFile());
        }
    }
    
    private void x(final f f) {
        final ArrayList list = this.e.get(f.a);
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; --i) {
                ((Listener)list.get(i)).a(this, f);
            }
        }
        ((Listener)this.b).a(this, f);
    }
    
    private void y(final CacheSpan cacheSpan) {
        final ArrayList list = this.e.get(cacheSpan.a);
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; --i) {
                ((Listener)list.get(i)).d(this, cacheSpan);
            }
        }
        ((Listener)this.b).d(this, cacheSpan);
    }
    
    private void z(final f f, final CacheSpan cacheSpan) {
        final ArrayList list = this.e.get(f.a);
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; --i) {
                ((Listener)list.get(i)).e(this, f, cacheSpan);
            }
        }
        ((Listener)this.b).e(this, f, cacheSpan);
    }
    
    public void B() {
        synchronized (this) {
            if (this.j) {
                return;
            }
            this.e.clear();
            this.D();
            while (true) {
                try {
                    try {
                        this.c.s();
                        F(this.a);
                        this.j = true;
                    }
                    finally {}
                }
                catch (final IOException ex) {
                    Log.d("SimpleCache", "Storing index file failed", ex);
                    F(this.a);
                    continue;
                }
                break;
            }
            return;
            F(this.a);
            this.j = true;
        }
    }
    
    @Override
    public File a(final String s, final long n, long currentTimeMillis) throws CacheException {
        synchronized (this) {
            Assertions.g(!this.j);
            this.o();
            final c g = this.c.g(s);
            Assertions.e(g);
            Assertions.g(g.h(n, currentTimeMillis));
            if (!this.a.exists()) {
                p(this.a);
                this.D();
            }
            this.b.c(this, s, n, currentTimeMillis);
            final File file = new File(this.a, Integer.toString(this.f.nextInt(10)));
            if (!file.exists()) {
                p(file);
            }
            currentTimeMillis = System.currentTimeMillis();
            return com.google.android.exoplayer2.upstream.cache.f.l(file, g.a, n, currentTimeMillis);
        }
    }
    
    @Override
    public ContentMetadata b(final String s) {
        synchronized (this) {
            Assertions.g(!this.j);
            return this.c.j(s);
        }
    }
    
    @Override
    public void c(final String s, final ContentMetadataMutations contentMetadataMutations) throws CacheException {
        synchronized (this) {
            Assertions.g(!this.j);
            this.o();
            this.c.e(s, contentMetadataMutations);
            try {
                this.c.s();
            }
            catch (final IOException ex) {
                throw new CacheException(ex);
            }
        }
    }
    
    @Override
    public long d(final String s, long n, long n2) {
        monitorenter(this);
        if (n2 == -1L) {
            n2 = Long.MAX_VALUE;
        }
        else {
            n2 += n;
        }
        if (n2 < 0L) {
            n2 = Long.MAX_VALUE;
        }
        long n3 = 0L;
        while (n < n2) {
            try {
                long f = this.f(s, n, n2 - n);
                if (f > 0L) {
                    n3 += f;
                }
                else {
                    f = -f;
                }
                n += f;
                continue;
            }
            finally {
                monitorexit(this);
            }
            break;
        }
        monitorexit(this);
        return n3;
    }
    
    @Override
    public CacheSpan e(final String s, final long n, final long n2) throws CacheException {
        synchronized (this) {
            Assertions.g(!this.j);
            this.o();
            final f r = this.r(s, n, n2);
            if (r.d) {
                return this.E(s, r);
            }
            if (this.c.m(s).j(n, r.c)) {
                return r;
            }
            return null;
        }
    }
    
    @Override
    public long f(final String s, long c, final long n) {
        synchronized (this) {
            Assertions.g(!this.j);
            long n2 = n;
            if (n == -1L) {
                n2 = Long.MAX_VALUE;
            }
            final c g = this.c.g(s);
            if (g != null) {
                c = g.c(c, n2);
            }
            else {
                c = -n2;
            }
            return c;
        }
    }
    
    @Override
    public long g() {
        synchronized (this) {
            Assertions.g(!this.j);
            return this.i;
        }
    }
    
    @Override
    public void h(final CacheSpan cacheSpan) {
        synchronized (this) {
            Assertions.g(!this.j);
            final c c = Assertions.e(this.c.g(cacheSpan.a));
            c.m(cacheSpan.b);
            this.c.p(c.b);
            this.notifyAll();
        }
    }
    
    @Override
    public void i(final CacheSpan cacheSpan) {
        synchronized (this) {
            Assertions.g(!this.j);
            this.C(cacheSpan);
        }
    }
    
    @Override
    public CacheSpan j(final String s, final long n, final long n2) throws InterruptedException, CacheException {
        synchronized (this) {
            Assertions.g(!this.j);
            this.o();
            CacheSpan e;
            while (true) {
                e = this.e(s, n, n2);
                if (e != null) {
                    break;
                }
                this.wait();
            }
            return e;
        }
    }
    
    @Override
    public void k(final File file, long d) throws CacheException {
        synchronized (this) {
            final boolean j = this.j;
            final boolean b = true;
            Assertions.g(!j);
            if (!file.exists()) {
                return;
            }
            if (d == 0L) {
                file.delete();
                return;
            }
            final f f = Assertions.e(com.google.android.exoplayer2.upstream.cache.f.h(file, d, this.c));
            final c c = Assertions.e(this.c.g(f.a));
            Assertions.g(c.h(f.b, f.c));
            d = ContentMetadata.d(c.d());
            if (d != -1L) {
                Assertions.g(f.b + f.c <= d && b);
            }
            if (this.d != null) {
                final String name = file.getName();
                try {
                    this.d.h(name, f.c, f.f);
                }
                catch (final IOException ex) {
                    throw new CacheException(ex);
                }
            }
            this.n(f);
            try {
                this.c.s();
                this.notifyAll();
            }
            catch (final IOException ex2) {
                throw new CacheException(ex2);
            }
        }
    }
    
    public void o() throws CacheException {
        synchronized (this) {
            final CacheException k = this.k;
            if (k == null) {
                return;
            }
            throw k;
        }
    }
    
    public boolean t(final String s, long c, final long n) {
        synchronized (this) {
            final boolean j = this.j;
            final boolean b = true;
            Assertions.g(!j);
            final c g = this.c.g(s);
            if (g != null) {
                c = g.c(c, n);
                if (c >= n) {
                    return b;
                }
            }
            return false;
        }
    }
}
