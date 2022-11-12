// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import android.os.Looper;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import java.util.ArrayDeque;
import java.util.Queue;
import android.os.Handler;

public final class l
{
    private static final char[] a;
    private static final char[] b;
    private static volatile Handler c;
    
    static {
        a = "0123456789abcdef".toCharArray();
        b = new char[64];
    }
    
    private l() {
    }
    
    public static void a() {
        if (r()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on a background thread");
    }
    
    public static void b() {
        if (s()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }
    
    public static boolean c(final Object o, final Object o2) {
        if (o == null) {
            return o2 == null;
        }
        if (o instanceof h2.l) {
            return ((h2.l)o).a(o2);
        }
        return o.equals(o2);
    }
    
    public static boolean d(final Object o, final Object o2) {
        boolean equals;
        if (o == null) {
            equals = (o2 == null);
        }
        else {
            equals = o.equals(o2);
        }
        return equals;
    }
    
    private static String e(final byte[] array, final char[] array2) {
        for (int i = 0; i < array.length; ++i) {
            final int n = array[i] & 0xFF;
            final int n2 = i * 2;
            final char[] a = l.a;
            array2[n2] = a[n >>> 4];
            array2[n2 + 1] = a[n & 0xF];
        }
        return new String(array2);
    }
    
    public static <T> Queue<T> f(final int n) {
        return new ArrayDeque<T>(n);
    }
    
    public static int g(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return n * n2 * i(bitmap$Config);
    }
    
    public static int h(final Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            }
            catch (final NullPointerException ex) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot obtain size for recycled Bitmap: ");
        sb.append(bitmap);
        sb.append("[");
        sb.append(bitmap.getWidth());
        sb.append("x");
        sb.append(bitmap.getHeight());
        sb.append("] ");
        sb.append(bitmap.getConfig());
        throw new IllegalStateException(sb.toString());
    }
    
    public static int i(final Bitmap$Config bitmap$Config) {
        Bitmap$Config argb_8888 = bitmap$Config;
        if (bitmap$Config == null) {
            argb_8888 = Bitmap$Config.ARGB_8888;
        }
        final int n = l$a.a[argb_8888.ordinal()];
        int n2 = 4;
        if (n != 1) {
            if (n != 2 && n != 3) {
                if (n == 4) {
                    n2 = 8;
                }
            }
            else {
                n2 = 2;
            }
        }
        else {
            n2 = 1;
        }
        return n2;
    }
    
    public static <T> List<T> j(final Collection<T> collection) {
        final ArrayList list = new ArrayList(collection.size());
        for (final Object next : collection) {
            if (next != null) {
                list.add(next);
            }
        }
        return list;
    }
    
    private static Handler k() {
        if (l.c == null) {
            synchronized (l.class) {
                if (l.c == null) {
                    l.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return l.c;
    }
    
    public static int l(final float n) {
        return m(n, 17);
    }
    
    public static int m(final float n, final int n2) {
        return o(Float.floatToIntBits(n), n2);
    }
    
    public static int n(final int n) {
        return o(n, 17);
    }
    
    public static int o(final int n, final int n2) {
        return n2 * 31 + n;
    }
    
    public static int p(final Object o, final int n) {
        int hashCode;
        if (o == null) {
            hashCode = 0;
        }
        else {
            hashCode = o.hashCode();
        }
        return o(hashCode, n);
    }
    
    public static int q(final boolean b, final int n) {
        return o(b ? 1 : 0, n);
    }
    
    public static boolean r() {
        return s() ^ true;
    }
    
    public static boolean s() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
    
    private static boolean t(final int n) {
        return n > 0 || n == Integer.MIN_VALUE;
    }
    
    public static boolean u(final int n, final int n2) {
        return t(n) && t(n2);
    }
    
    public static void v(final Runnable runnable) {
        k().post(runnable);
    }
    
    public static void w(final Runnable runnable) {
        k().removeCallbacks(runnable);
    }
    
    public static String x(final byte[] array) {
        final char[] b = l.b;
        synchronized (b) {
            return e(array, b);
        }
    }
}
