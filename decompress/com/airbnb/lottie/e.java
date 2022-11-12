// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import qc.a0;
import java.util.zip.ZipEntry;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.res.Resources$NotFoundException;
import java.lang.ref.WeakReference;
import x1.t;
import java.io.Closeable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import qc.o;
import java.io.InputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import android.content.Context;
import java.util.Iterator;
import t1.f;
import java.util.concurrent.Callable;
import java.util.HashMap;
import java.util.Map;

public class e
{
    private static final Map<String, m<d>> a;
    private static final byte[] b;
    
    static {
        a = new HashMap<String, m<d>>();
        b = new byte[] { 80, 75, 3, 4 };
    }
    
    static Map a() {
        return e.a;
    }
    
    private static m<d> b(final String s, final Callable<l<d>> callable) {
        d a;
        if (s == null) {
            a = null;
        }
        else {
            a = f.b().a(s);
        }
        if (a != null) {
            return new m<d>((Callable<l<Object>>)new Callable<l<d>>(a) {
                final d a;
                
                public l<d> a() {
                    return new l<d>(this.a);
                }
                
                @Override
                public /* bridge */ Object call() throws Exception {
                    return this.a();
                }
            });
        }
        if (s != null) {
            final Map<String, m<d>> a2 = e.a;
            if (a2.containsKey(s)) {
                return a2.get(s);
            }
        }
        final m m = new m(callable);
        if (s != null) {
            m.f(new h<d>(s) {
                final String a;
                
                @Override
                public /* bridge */ void a(final Object o) {
                    this.b((d)o);
                }
                
                public void b(final d d) {
                    e.a().remove(this.a);
                }
            });
            m.e(new h<Throwable>(s) {
                final String a;
                
                @Override
                public /* bridge */ void a(final Object o) {
                    this.b((Throwable)o);
                }
                
                public void b(final Throwable t) {
                    e.a().remove(this.a);
                }
            });
            e.a.put(s, m);
        }
        return m;
    }
    
    private static g c(final d d, final String s) {
        for (final g g : d.i().values()) {
            if (g.b().equals(s)) {
                return g;
            }
        }
        return null;
    }
    
    public static m<d> d(final Context context, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("asset_");
        sb.append(s);
        return e(context, s, sb.toString());
    }
    
    public static m<d> e(final Context context, final String s, final String s2) {
        return b(s2, new Callable<l<d>>(context.getApplicationContext(), s, s2) {
            final Context a;
            final String b;
            final String c;
            
            public l<d> a() {
                return e.g(this.a, this.b, this.c);
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public static l<d> f(final Context context, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("asset_");
        sb.append(s);
        return g(context, s, sb.toString());
    }
    
    public static l<d> g(final Context context, final String s, final String s2) {
        try {
            if (!s.endsWith(".zip") && !s.endsWith(".lottie")) {
                return i(context.getAssets().open(s), s2);
            }
            return s(new ZipInputStream(context.getAssets().open(s)), s2);
        }
        catch (final IOException ex) {
            return new l<d>(ex);
        }
    }
    
    public static m<d> h(final InputStream inputStream, final String s) {
        return b(s, new Callable<l<d>>(inputStream, s) {
            final InputStream a;
            final String b;
            
            public l<d> a() {
                return e.i(this.a, this.b);
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public static l<d> i(final InputStream inputStream, final String s) {
        return j(inputStream, s, true);
    }
    
    private static l<d> j(final InputStream inputStream, final String s, final boolean b) {
        try {
            return k(JsonReader.t(o.d(o.k(inputStream))), s);
        }
        finally {
            if (b) {
                y1.h.c(inputStream);
            }
        }
    }
    
    public static l<d> k(final JsonReader jsonReader, final String s) {
        return l(jsonReader, s, true);
    }
    
    private static l<d> l(final JsonReader jsonReader, final String s, final boolean b) {
        try {
            try {
                final d a = t.a(jsonReader);
                if (s != null) {
                    f.b().c(s, a);
                }
                final l l = new l<d>(a);
                if (b) {
                    y1.h.c(jsonReader);
                }
                return (l<d>)l;
            }
            finally {
                if (b) {
                    y1.h.c(jsonReader);
                }
                y1.h.c(jsonReader);
                return;
            }
        }
        catch (final Exception ex) {}
    }
    
    public static m<d> m(final Context context, final int n) {
        return n(context, n, w(context, n));
    }
    
    public static m<d> n(final Context context, final int n, final String s) {
        return b(s, new Callable<l<d>>(new WeakReference((T)context), context.getApplicationContext(), n, s) {
            final WeakReference a;
            final Context b;
            final int c;
            final String d;
            
            public l<d> a() {
                Context b = (Context)this.a.get();
                if (b == null) {
                    b = this.b;
                }
                return e.p(b, this.c, this.d);
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public static l<d> o(final Context context, final int n) {
        return p(context, n, w(context, n));
    }
    
    public static l<d> p(final Context context, final int n, final String s) {
        try {
            final qc.h d = o.d(o.k(context.getResources().openRawResource(n)));
            if (v(d)) {
                return s(new ZipInputStream(d.H1()), s);
            }
            return i(d.H1(), s);
        }
        catch (final Resources$NotFoundException ex) {
            return new l<d>((Throwable)ex);
        }
    }
    
    public static m<d> q(final Context context, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("url_");
        sb.append(s);
        return r(context, s, sb.toString());
    }
    
    public static m<d> r(final Context context, final String s, final String s2) {
        return b(s2, new Callable<l<d>>(context, s, s2) {
            final Context a;
            final String b;
            final String c;
            
            public l<d> a() {
                final l<d> c = com.airbnb.lottie.c.d(this.a).c(this.b, this.c);
                if (this.c != null && c.b() != null) {
                    f.b().c(this.c, c.b());
                }
                return c;
            }
            
            @Override
            public /* bridge */ Object call() throws Exception {
                return this.a();
            }
        });
    }
    
    public static l<d> s(final ZipInputStream zipInputStream, final String s) {
        try {
            return t(zipInputStream, s);
        }
        finally {
            y1.h.c(zipInputStream);
        }
    }
    
    private static l<d> t(final ZipInputStream zipInputStream, final String s) {
        final HashMap hashMap = new HashMap();
        try {
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            d d = null;
            while (zipEntry != null) {
                final String name = zipEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                }
                else if (zipEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                }
                else if (zipEntry.getName().contains(".json")) {
                    d = l(JsonReader.t(o.d(o.k((InputStream)zipInputStream))), null, false).b();
                }
                else if (!name.contains(".png") && !name.contains(".webp")) {
                    zipInputStream.closeEntry();
                }
                else {
                    final String[] split = name.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream((InputStream)zipInputStream));
                }
                zipEntry = zipInputStream.getNextEntry();
            }
            if (d == null) {
                return new l<d>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (final Map.Entry<String, V> entry : hashMap.entrySet()) {
                final g c = c(d, entry.getKey());
                if (c != null) {
                    c.f(y1.h.l((Bitmap)entry.getValue(), c.e(), c.c()));
                }
            }
            for (final Map.Entry<K, g> entry2 : d.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("There is no image for ");
                    sb.append(entry2.getValue().b());
                    return new l<d>(new IllegalStateException(sb.toString()));
                }
            }
            if (s != null) {
                f.b().c(s, d);
            }
            return new l<d>(d);
        }
        catch (final IOException ex) {
            return new l<d>(ex);
        }
    }
    
    private static boolean u(final Context context) {
        return (context.getResources().getConfiguration().uiMode & 0x30) == 0x20;
    }
    
    private static Boolean v(final qc.h h) {
        try {
            final qc.h peek = h.peek();
            final byte[] b = e.b;
            for (int length = b.length, i = 0; i < length; ++i) {
                if (peek.readByte() != b[i]) {
                    return Boolean.FALSE;
                }
            }
            ((a0)peek).close();
            return Boolean.TRUE;
        }
        catch (final Exception ex) {
            y1.d.b("Failed to check zip file header", ex);
            return Boolean.FALSE;
        }
    }
    
    private static String w(final Context context, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        String s;
        if (u(context)) {
            s = "_night_";
        }
        else {
            s = "_day_";
        }
        sb.append(s);
        sb.append(n);
        return sb.toString();
    }
}
