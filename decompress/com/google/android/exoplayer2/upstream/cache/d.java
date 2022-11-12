// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.io.FilterInputStream;
import javax.crypto.CipherOutputStream;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.CipherInputStream;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import java.io.Closeable;
import java.io.BufferedInputStream;
import com.google.android.exoplayer2.util.AtomicFile;
import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;
import android.database.sqlite.SQLiteException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import android.database.Cursor;
import android.database.SQLException;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.VersionTable;
import android.content.ContentValues;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import android.database.sqlite.SQLiteDatabase;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.Cipher;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.io.File;
import com.google.android.exoplayer2.database.DatabaseProvider;
import android.util.SparseBooleanArray;
import android.util.SparseArray;
import java.util.HashMap;

class d
{
    private final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> a;
    private final SparseArray<String> b;
    private final SparseBooleanArray c;
    private final SparseBooleanArray d;
    private c e;
    private c f;
    
    public d(final DatabaseProvider databaseProvider, final File file, final byte[] array, final boolean b, final boolean b2) {
        Assertions.g(databaseProvider != null || file != null);
        this.a = new HashMap<String, com.google.android.exoplayer2.upstream.cache.c>();
        this.b = (SparseArray<String>)new SparseArray();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        Object f = null;
        Object o;
        if (databaseProvider != null) {
            o = new a(databaseProvider);
        }
        else {
            o = null;
        }
        if (file != null) {
            f = new b(new File(file, "cached_content_index.exi"), array, b);
        }
        if (o != null && (f == null || !b2)) {
            this.e = (c)o;
            this.f = (c)f;
        }
        else {
            this.e = Util.j(f);
            this.f = (c)o;
        }
    }
    
    static Cipher a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return i();
    }
    
    static DefaultContentMetadata b(final DataInputStream dataInputStream) throws IOException {
        return q(dataInputStream);
    }
    
    static void c(final DefaultContentMetadata defaultContentMetadata, final DataOutputStream dataOutputStream) throws IOException {
        t(defaultContentMetadata, dataOutputStream);
    }
    
    private com.google.android.exoplayer2.upstream.cache.c d(final String s) {
        final int l = l(this.b);
        final com.google.android.exoplayer2.upstream.cache.c c = new com.google.android.exoplayer2.upstream.cache.c(l, s);
        this.a.put(s, c);
        this.b.put(l, (Object)s);
        this.d.put(l, true);
        this.e.f(c);
        return c;
    }
    
    private static Cipher i() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Label_0018: {
            if (Util.a != 18) {
                break Label_0018;
            }
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
                return Cipher.getInstance("AES/CBC/PKCS5PADDING");
            }
            finally {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING");
            }
        }
    }
    
    static int l(final SparseArray<String> sparseArray) {
        final int size = sparseArray.size();
        final int n = 0;
        int n2;
        if (size == 0) {
            n2 = 0;
        }
        else {
            n2 = sparseArray.keyAt(size - 1) + 1;
        }
        int n3 = n2;
        if (n2 < 0) {
            int n4;
            for (n4 = n; n4 < size && n4 == sparseArray.keyAt(n4); ++n4) {}
            n3 = n4;
        }
        return n3;
    }
    
    public static boolean o(final String s) {
        return s.startsWith("cached_content_index.exi");
    }
    
    private static DefaultContentMetadata q(final DataInputStream dataInputStream) throws IOException {
        final int int1 = dataInputStream.readInt();
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < int1; ++i) {
            final String utf = dataInputStream.readUTF();
            final int int2 = dataInputStream.readInt();
            if (int2 < 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid value size: ");
                sb.append(int2);
                throw new IOException(sb.toString());
            }
            int n = Math.min(int2, 10485760);
            byte[] array = Util.f;
            int n2;
            for (int j = 0; j != int2; j = n2) {
                n2 = j + n;
                array = Arrays.copyOf(array, n2);
                dataInputStream.readFully(array, j, n);
                n = Math.min(int2 - n2, 10485760);
            }
            hashMap.put(utf, array);
        }
        return new DefaultContentMetadata(hashMap);
    }
    
    private static void t(final DefaultContentMetadata defaultContentMetadata, final DataOutputStream dataOutputStream) throws IOException {
        final Set<Map.Entry<String, byte[]>> h = defaultContentMetadata.h();
        dataOutputStream.writeInt(h.size());
        for (final Map.Entry<String, V> entry : h) {
            dataOutputStream.writeUTF(entry.getKey());
            final byte[] array = (Object)entry.getValue();
            dataOutputStream.writeInt(array.length);
            dataOutputStream.write(array);
        }
    }
    
    public void e(final String s, final ContentMetadataMutations contentMetadataMutations) {
        final com.google.android.exoplayer2.upstream.cache.c m = this.m(s);
        if (m.b(contentMetadataMutations)) {
            this.e.f(m);
        }
    }
    
    public int f(final String s) {
        return this.m(s).a;
    }
    
    public com.google.android.exoplayer2.upstream.cache.c g(final String s) {
        return this.a.get(s);
    }
    
    public Collection<com.google.android.exoplayer2.upstream.cache.c> h() {
        return Collections.unmodifiableCollection((Collection<? extends com.google.android.exoplayer2.upstream.cache.c>)this.a.values());
    }
    
    public ContentMetadata j(final String s) {
        final com.google.android.exoplayer2.upstream.cache.c g = this.g(s);
        DefaultContentMetadata defaultContentMetadata;
        if (g != null) {
            defaultContentMetadata = g.d();
        }
        else {
            defaultContentMetadata = DefaultContentMetadata.c;
        }
        return defaultContentMetadata;
    }
    
    public String k(final int n) {
        return (String)this.b.get(n);
    }
    
    public com.google.android.exoplayer2.upstream.cache.c m(final String s) {
        com.google.android.exoplayer2.upstream.cache.c d;
        if ((d = this.a.get(s)) == null) {
            d = this.d(s);
        }
        return d;
    }
    
    public void n(final long n) throws IOException {
        this.e.d(n);
        final c f = this.f;
        if (f != null) {
            f.d(n);
        }
        Label_0106: {
            if (!this.e.b()) {
                final c f2 = this.f;
                if (f2 != null && f2.b()) {
                    this.f.g(this.a, this.b);
                    this.e.e(this.a);
                    break Label_0106;
                }
            }
            this.e.g(this.a, this.b);
        }
        final c f3 = this.f;
        if (f3 != null) {
            f3.h();
            this.f = null;
        }
    }
    
    public void p(final String s) {
        final com.google.android.exoplayer2.upstream.cache.c c = this.a.get(s);
        if (c != null && c.g() && c.i()) {
            this.a.remove(s);
            final int a = c.a;
            final boolean value = this.d.get(a);
            this.e.a(c, value);
            if (value) {
                this.b.remove(a);
                this.d.delete(a);
            }
            else {
                this.b.put(a, (Object)null);
                this.c.put(a, true);
            }
        }
    }
    
    public void r() {
        final UnmodifiableIterator iterator = ImmutableSet.copyOf((Collection)this.a.keySet()).iterator();
        while (((Iterator)iterator).hasNext()) {
            this.p((String)((Iterator)iterator).next());
        }
    }
    
    public void s() throws IOException {
        this.e.c(this.a);
        for (int size = this.c.size(), i = 0; i < size; ++i) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
    
    private static final class a implements c
    {
        private static final String[] e;
        private final DatabaseProvider a;
        private final SparseArray<com.google.android.exoplayer2.upstream.cache.c> b;
        private String c;
        private String d;
        
        static {
            e = new String[] { "id", "key", "metadata" };
        }
        
        public a(final DatabaseProvider a) {
            this.a = a;
            this.b = (SparseArray<com.google.android.exoplayer2.upstream.cache.c>)new SparseArray();
        }
        
        private void i(final SQLiteDatabase sqLiteDatabase, final com.google.android.exoplayer2.upstream.cache.c c) throws IOException {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.google.android.exoplayer2.upstream.cache.d.c(c.d(), new DataOutputStream(byteArrayOutputStream));
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            final ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(c.a));
            contentValues.put("key", c.b);
            contentValues.put("metadata", byteArray);
            sqLiteDatabase.replaceOrThrow((String)Assertions.e(this.d), (String)null, contentValues);
        }
        
        private static void j(DatabaseProvider writableDatabase, final String s) throws DatabaseIOException {
            try {
                final String n = n(s);
                writableDatabase = (DatabaseProvider)writableDatabase.getWritableDatabase();
                ((SQLiteDatabase)writableDatabase).beginTransactionNonExclusive();
                try {
                    VersionTable.c((SQLiteDatabase)writableDatabase, 1, s);
                    l((SQLiteDatabase)writableDatabase, n);
                    ((SQLiteDatabase)writableDatabase).setTransactionSuccessful();
                }
                finally {
                    ((SQLiteDatabase)writableDatabase).endTransaction();
                }
            }
            catch (final SQLException ex) {
                throw new DatabaseIOException(ex);
            }
        }
        
        private void k(final SQLiteDatabase sqLiteDatabase, final int n) {
            sqLiteDatabase.delete((String)Assertions.e(this.d), "id = ?", new String[] { Integer.toString(n) });
        }
        
        private static void l(final SQLiteDatabase sqLiteDatabase, final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append("DROP TABLE IF EXISTS ");
            sb.append(s);
            sqLiteDatabase.execSQL(sb.toString());
        }
        
        private Cursor m() {
            return this.a.getReadableDatabase().query((String)Assertions.e(this.d), com.google.android.exoplayer2.upstream.cache.d.a.e, (String)null, (String[])null, (String)null, (String)null, (String)null);
        }
        
        private static String n(final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append("ExoPlayerCacheIndex");
            sb.append(s);
            return sb.toString();
        }
        
        private void o(final SQLiteDatabase sqLiteDatabase) throws DatabaseIOException {
            VersionTable.d(sqLiteDatabase, 1, Assertions.e(this.c), 1);
            l(sqLiteDatabase, Assertions.e(this.d));
            final StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.d);
            sb.append(" ");
            sb.append("(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
            sqLiteDatabase.execSQL(sb.toString());
        }
        
        @Override
        public void a(final com.google.android.exoplayer2.upstream.cache.c c, final boolean b) {
            if (b) {
                this.b.delete(c.a);
            }
            else {
                this.b.put(c.a, (Object)null);
            }
        }
        
        @Override
        public boolean b() throws DatabaseIOException {
            final SQLiteDatabase readableDatabase = this.a.getReadableDatabase();
            final String s = Assertions.e(this.c);
            boolean b = true;
            if (VersionTable.b(readableDatabase, 1, s) == -1) {
                b = false;
            }
            return b;
        }
        
        @Override
        public void c(HashMap<String, com.google.android.exoplayer2.upstream.cache.c> writableDatabase) throws IOException {
            if (this.b.size() == 0) {
                return;
            }
            try {
                writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                int i = 0;
                try {
                    while (i < this.b.size()) {
                        final com.google.android.exoplayer2.upstream.cache.c c = (com.google.android.exoplayer2.upstream.cache.c)this.b.valueAt(i);
                        if (c == null) {
                            this.k(writableDatabase, this.b.keyAt(i));
                        }
                        else {
                            this.i(writableDatabase, c);
                        }
                        ++i;
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                }
                finally {
                    writableDatabase.endTransaction();
                }
            }
            catch (final SQLException ex) {
                throw new DatabaseIOException(ex);
            }
        }
        
        @Override
        public void d(final long n) {
            final String hexString = Long.toHexString(n);
            this.c = hexString;
            this.d = n(hexString);
        }
        
        @Override
        public void e(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> hashMap) throws IOException {
            try {
                final SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    this.o(writableDatabase);
                    final Iterator<com.google.android.exoplayer2.upstream.cache.c> iterator = hashMap.values().iterator();
                    while (iterator.hasNext()) {
                        this.i(writableDatabase, iterator.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                }
                finally {
                    writableDatabase.endTransaction();
                }
            }
            catch (final SQLException ex) {
                throw new DatabaseIOException(ex);
            }
        }
        
        @Override
        public void f(final com.google.android.exoplayer2.upstream.cache.c c) {
            this.b.put(c.a, (Object)c);
        }
        
        @Override
        public void g(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> hashMap, final SparseArray<String> sparseArray) throws IOException {
            Assertions.g(this.b.size() == 0);
            try {
                if (VersionTable.b(this.a.getReadableDatabase(), 1, Assertions.e(this.c)) != 1) {
                    final SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        this.o(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                    }
                    finally {
                        writableDatabase.endTransaction();
                    }
                }
                final Cursor m = this.m();
                try {
                    while (m.moveToNext()) {
                        final com.google.android.exoplayer2.upstream.cache.c c = new com.google.android.exoplayer2.upstream.cache.c(m.getInt(0), Assertions.e(m.getString(1)), com.google.android.exoplayer2.upstream.cache.d.b(new DataInputStream(new ByteArrayInputStream(m.getBlob(2)))));
                        hashMap.put(c.b, c);
                        sparseArray.put(c.a, (Object)c.b);
                    }
                    m.close();
                }
                finally {
                    if (m != null) {
                        try {
                            m.close();
                        }
                        finally {
                            final Throwable t;
                            final Throwable t2;
                            t.addSuppressed(t2);
                        }
                    }
                }
            }
            catch (final SQLiteException ex) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException((SQLException)ex);
            }
        }
        
        @Override
        public void h() throws DatabaseIOException {
            j(this.a, Assertions.e(this.c));
        }
    }
    
    private static class b implements c
    {
        private final boolean a;
        private final Cipher b;
        private final SecretKeySpec c;
        private final SecureRandom d;
        private final AtomicFile e;
        private boolean f;
        private e g;
        
        public b(final File ex, final byte[] array, final boolean a) {
            final boolean b = false;
            Assertions.g(array != null || !a);
            final SecureRandom secureRandom = null;
            Cipher b3 = null;
            SecretKeySpec c = null;
            Label_0110: {
                if (array != null) {
                    boolean b2 = b;
                    if (array.length == 16) {
                        b2 = true;
                    }
                    Assertions.a(b2);
                    try {
                        final Cipher a2 = d.a();
                        final SecretKeySpec secretKeySpec = new SecretKeySpec(array, "AES");
                        b3 = a2;
                        c = secretKeySpec;
                        break Label_0110;
                    }
                    catch (final NoSuchPaddingException ex) {}
                    catch (final NoSuchAlgorithmException ex2) {}
                    throw new IllegalStateException(ex);
                }
                Assertions.a(a ^ true);
                b3 = null;
                c = null;
            }
            this.a = a;
            this.b = b3;
            this.c = c;
            SecureRandom d = secureRandom;
            if (a) {
                d = new SecureRandom();
            }
            this.d = d;
            this.e = new AtomicFile((File)ex);
        }
        
        private int i(final com.google.android.exoplayer2.upstream.cache.c c, int n) {
            final int n2 = c.a * 31 + c.b.hashCode();
            int hashCode;
            if (n < 2) {
                final long d = ContentMetadata.d(c.d());
                n = n2 * 31;
                hashCode = (int)(d ^ d >>> 32);
            }
            else {
                n = n2 * 31;
                hashCode = c.d().hashCode();
            }
            return n + hashCode;
        }
        
        private com.google.android.exoplayer2.upstream.cache.c j(final int n, final DataInputStream dataInputStream) throws IOException {
            final int int1 = dataInputStream.readInt();
            final String utf = dataInputStream.readUTF();
            DefaultContentMetadata defaultContentMetadata;
            if (n < 2) {
                final long long1 = dataInputStream.readLong();
                final ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.g(contentMetadataMutations, long1);
                defaultContentMetadata = DefaultContentMetadata.c.g(contentMetadataMutations);
            }
            else {
                defaultContentMetadata = com.google.android.exoplayer2.upstream.cache.d.b(dataInputStream);
            }
            return new com.google.android.exoplayer2.upstream.cache.c(int1, utf, defaultContentMetadata);
        }
        
        private boolean k(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> ex, final SparseArray<String> sparseArray) {
            if (!this.e.c()) {
                return true;
            }
            Object b = null;
            try {
                final BufferedInputStream bufferedInputStream = new BufferedInputStream(this.e.d());
                final DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
                try {
                    final int int1 = dataInputStream.readInt();
                    if (int1 < 0 || int1 > 2) {
                        Util.n(dataInputStream);
                        return false;
                    }
                    Label_0344: {
                        if ((dataInputStream.readInt() & 0x1) != 0x0) {
                            b = this.b;
                            if (b == null) {
                                Util.n(dataInputStream);
                                return false;
                            }
                            b = new byte[16];
                            dataInputStream.readFully((byte[])b);
                            final IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])b);
                            try {
                                this.b.init(2, Util.j(this.c), ivParameterSpec);
                                b = new DataInputStream(new CipherInputStream(bufferedInputStream, this.b));
                                break Label_0344;
                            }
                            catch (final InvalidAlgorithmParameterException ex) {}
                            catch (final InvalidKeyException ex2) {}
                            throw new IllegalStateException(ex);
                        }
                        else {
                            b = dataInputStream;
                            if (this.a) {
                                this.f = true;
                                b = dataInputStream;
                            }
                        }
                    }
                    final int int2 = ((DataInputStream)b).readInt();
                    int i = 0;
                    int n = 0;
                    while (i < int2) {
                        final com.google.android.exoplayer2.upstream.cache.c j = this.j(int1, (DataInputStream)b);
                        ((HashMap<String, com.google.android.exoplayer2.upstream.cache.c>)ex).put(j.b, j);
                        sparseArray.put(j.a, (Object)j.b);
                        n += this.i(j, int1);
                        ++i;
                    }
                    final int int3 = ((DataInputStream)b).readInt();
                    final boolean b2 = ((FilterInputStream)b).read() == -1;
                    if (int3 == n && b2) {
                        Util.n((Closeable)b);
                        return true;
                    }
                    Util.n((Closeable)b);
                    return false;
                }
                catch (final IOException ex3) {}
            }
            catch (final IOException ex4) {
                goto Label_0561;
            }
        }
        
        private void l(final com.google.android.exoplayer2.upstream.cache.c c, final DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(c.a);
            dataOutputStream.writeUTF(c.b);
            com.google.android.exoplayer2.upstream.cache.d.c(c.d(), dataOutputStream);
        }
        
        private void m(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> ex) throws IOException {
            Closeable closeable = null;
            try {
                final OutputStream f = this.e.f();
                final e g = this.g;
                if (g == null) {
                    this.g = new e(f);
                }
                else {
                    g.a(f);
                }
                final e g2 = this.g;
                final DataOutputStream dataOutputStream = (DataOutputStream)(closeable = new DataOutputStream(g2));
                try {
                    dataOutputStream.writeInt(2);
                    closeable = dataOutputStream;
                    final boolean a = this.a;
                    final int n = 0;
                    int n2;
                    if (a) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    closeable = dataOutputStream;
                    dataOutputStream.writeInt(n2);
                    DataOutputStream dataOutputStream2 = dataOutputStream;
                    closeable = dataOutputStream;
                    Label_0305: {
                        if (this.a) {
                            closeable = dataOutputStream;
                            final byte[] array = new byte[16];
                            closeable = dataOutputStream;
                            Util.j(this.d).nextBytes(array);
                            closeable = dataOutputStream;
                            dataOutputStream.write(array);
                            closeable = dataOutputStream;
                            closeable = dataOutputStream;
                            final IvParameterSpec ivParameterSpec = new IvParameterSpec(array);
                            closeable = dataOutputStream;
                            try {
                                Util.j(this.b).init(1, Util.j(this.c), ivParameterSpec);
                                closeable = dataOutputStream;
                                dataOutputStream.flush();
                                closeable = dataOutputStream;
                                closeable = dataOutputStream;
                                closeable = dataOutputStream;
                                final CipherOutputStream cipherOutputStream = new CipherOutputStream(g2, this.b);
                                closeable = dataOutputStream;
                                dataOutputStream2 = new DataOutputStream(cipherOutputStream);
                                break Label_0305;
                            }
                            catch (final InvalidAlgorithmParameterException ex) {}
                            catch (final InvalidKeyException ex2) {}
                            closeable = dataOutputStream;
                            closeable = dataOutputStream;
                            final IllegalStateException ex3 = new IllegalStateException(ex);
                            closeable = dataOutputStream;
                            throw ex3;
                        }
                    }
                    closeable = dataOutputStream2;
                    dataOutputStream2.writeInt(((HashMap)ex).size());
                    closeable = dataOutputStream2;
                    final Iterator iterator = ((HashMap)ex).values().iterator();
                    int n3 = n;
                    while (true) {
                        closeable = dataOutputStream2;
                        if (!iterator.hasNext()) {
                            break;
                        }
                        closeable = dataOutputStream2;
                        final com.google.android.exoplayer2.upstream.cache.c c = (com.google.android.exoplayer2.upstream.cache.c)iterator.next();
                        closeable = dataOutputStream2;
                        this.l(c, dataOutputStream2);
                        closeable = dataOutputStream2;
                        n3 += this.i(c, 2);
                    }
                    closeable = dataOutputStream2;
                    dataOutputStream2.writeInt(n3);
                    closeable = dataOutputStream2;
                    this.e.b(dataOutputStream2);
                    Util.n(null);
                    return;
                }
                finally {}
            }
            finally {}
            Util.n(closeable);
        }
        
        @Override
        public void a(final com.google.android.exoplayer2.upstream.cache.c c, final boolean b) {
            this.f = true;
        }
        
        @Override
        public boolean b() {
            return this.e.c();
        }
        
        @Override
        public void c(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> hashMap) throws IOException {
            if (!this.f) {
                return;
            }
            this.e(hashMap);
        }
        
        @Override
        public void d(final long n) {
        }
        
        @Override
        public void e(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> hashMap) throws IOException {
            this.m(hashMap);
            this.f = false;
        }
        
        @Override
        public void f(final com.google.android.exoplayer2.upstream.cache.c c) {
            this.f = true;
        }
        
        @Override
        public void g(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> hashMap, final SparseArray<String> sparseArray) {
            Assertions.g(this.f ^ true);
            if (!this.k(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.e.a();
            }
        }
        
        @Override
        public void h() {
            this.e.a();
        }
    }
    
    private interface c
    {
        void a(final com.google.android.exoplayer2.upstream.cache.c p0, final boolean p1);
        
        boolean b() throws IOException;
        
        void c(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> p0) throws IOException;
        
        void d(final long p0);
        
        void e(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> p0) throws IOException;
        
        void f(final com.google.android.exoplayer2.upstream.cache.c p0);
        
        void g(final HashMap<String, com.google.android.exoplayer2.upstream.cache.c> p0, final SparseArray<String> p1) throws IOException;
        
        void h() throws IOException;
    }
}
