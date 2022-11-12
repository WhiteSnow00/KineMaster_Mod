// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content.res;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.os.Build$VERSION;
import android.os.Looper;
import android.content.res.Configuration;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.content.res.XmlResourceParser;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import androidx.core.util.h;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import android.os.Handler;
import android.graphics.Typeface;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.ColorStateList;
import android.util.SparseArray;
import java.util.WeakHashMap;
import android.util.TypedValue;

public final class f
{
    private static final ThreadLocal<TypedValue> a;
    private static final WeakHashMap<d, SparseArray<c>> b;
    private static final Object c;
    
    static {
        a = new ThreadLocal<TypedValue>();
        b = new WeakHashMap<d, SparseArray<c>>(0);
        c = new Object();
    }
    
    private static void a(final d d, final int n, final ColorStateList list, final Resources$Theme resources$Theme) {
        synchronized (f.c) {
            final WeakHashMap<d, SparseArray<c>> b = f.b;
            SparseArray sparseArray;
            if ((sparseArray = b.get(d)) == null) {
                sparseArray = new SparseArray();
                b.put(d, (SparseArray<c>)sparseArray);
            }
            sparseArray.append(n, (Object)new c(list, d.a.getConfiguration(), resources$Theme));
        }
    }
    
    private static ColorStateList b(final d d, final int n) {
        synchronized (f.c) {
            final SparseArray sparseArray = f.b.get(d);
            if (sparseArray != null && sparseArray.size() > 0) {
                final c c = (c)sparseArray.get(n);
                if (c != null) {
                    if (c.b.equals(d.a.getConfiguration())) {
                        final Resources$Theme b = d.b;
                        if ((b == null && c.c == 0) || (b != null && c.c == b.hashCode())) {
                            return c.a;
                        }
                    }
                    sparseArray.remove(n);
                }
            }
            return null;
        }
    }
    
    public static Typeface c(final Context context, final int n) throws Resources$NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, n, new TypedValue(), 0, null, null, false, true);
    }
    
    public static int d(final Resources resources, final int n, final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        return androidx.core.content.res.f.b.a(resources, n, resources$Theme);
    }
    
    public static ColorStateList e(final Resources resources, final int n, final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        final d d = new d(resources, resources$Theme);
        final ColorStateList b = b(d, n);
        if (b != null) {
            return b;
        }
        final ColorStateList l = l(resources, n, resources$Theme);
        if (l != null) {
            a(d, n, l, resources$Theme);
            return l;
        }
        return androidx.core.content.res.f.b.b(resources, n, resources$Theme);
    }
    
    public static Drawable f(final Resources resources, final int n, final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        return androidx.core.content.res.f.a.a(resources, n, resources$Theme);
    }
    
    public static Drawable g(final Resources resources, final int n, final int n2, final Resources$Theme resources$Theme) throws Resources$NotFoundException {
        return androidx.core.content.res.f.a.b(resources, n, n2, resources$Theme);
    }
    
    public static Typeface h(final Context context, final int n) throws Resources$NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, n, new TypedValue(), 0, null, null, false, false);
    }
    
    public static Typeface i(final Context context, final int n, final TypedValue typedValue, final int n2, final e e) throws Resources$NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, n, typedValue, n2, e, null, true, false);
    }
    
    public static void j(final Context context, final int n, final e e, final Handler handler) throws Resources$NotFoundException {
        h.g(e);
        if (context.isRestricted()) {
            e.c(-4, handler);
            return;
        }
        n(context, n, new TypedValue(), 0, e, handler, false, false);
    }
    
    private static TypedValue k() {
        final ThreadLocal<TypedValue> a = f.a;
        TypedValue typedValue;
        if ((typedValue = a.get()) == null) {
            typedValue = new TypedValue();
            a.set(typedValue);
        }
        return typedValue;
    }
    
    private static ColorStateList l(final Resources resources, final int n, final Resources$Theme resources$Theme) {
        if (m(resources, n)) {
            return null;
        }
        final XmlResourceParser xml = resources.getXml(n);
        try {
            return androidx.core.content.res.c.a(resources, (XmlPullParser)xml, resources$Theme);
        }
        catch (final Exception ex) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", (Throwable)ex);
            return null;
        }
    }
    
    private static boolean m(final Resources resources, int type) {
        final TypedValue k = k();
        boolean b = true;
        resources.getValue(type, k, true);
        type = k.type;
        if (type < 28 || type > 31) {
            b = false;
        }
        return b;
    }
    
    private static Typeface n(final Context context, final int n, final TypedValue typedValue, final int n2, final e e, final Handler handler, final boolean b, final boolean b2) {
        final Resources resources = context.getResources();
        resources.getValue(n, typedValue, true);
        final Typeface o = o(context, resources, typedValue, n, n2, e, handler, b, b2);
        if (o == null && e == null && !b2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Font resource ID #0x");
            sb.append(Integer.toHexString(n));
            sb.append(" could not be retrieved.");
            throw new Resources$NotFoundException(sb.toString());
        }
        return o;
    }
    
    private static Typeface o(final Context context, final Resources resources, final TypedValue typedValue, final int n, final int n2, final e e, final Handler handler, final boolean b, final boolean b2) {
        final CharSequence string = typedValue.string;
        if (string == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Resource \"");
            sb.append(resources.getResourceName(n));
            sb.append("\" (");
            sb.append(Integer.toHexString(n));
            sb.append(") is not a Font: ");
            sb.append(typedValue);
            throw new Resources$NotFoundException(sb.toString());
        }
        final String string2 = string.toString();
        if (!string2.startsWith("res/")) {
            if (e != null) {
                e.c(-3, handler);
            }
            return null;
        }
        final Typeface f = androidx.core.graphics.h.f(resources, n, string2, typedValue.assetCookie, n2);
        if (f != null) {
            if (e != null) {
                e.d(f, handler);
            }
            return f;
        }
        if (b2) {
            return null;
        }
        try {
            if (!string2.toLowerCase().endsWith(".xml")) {
                final Typeface d = androidx.core.graphics.h.d(context, resources, n, string2, typedValue.assetCookie, n2);
                if (e != null) {
                    if (d != null) {
                        e.d(d, handler);
                    }
                    else {
                        e.c(-3, handler);
                    }
                }
                return d;
            }
            final androidx.core.content.res.d.b b3 = androidx.core.content.res.d.b((XmlPullParser)resources.getXml(n), resources);
            if (b3 == null) {
                Log.e("ResourcesCompat", "Failed to find font-family tag");
                if (e != null) {
                    e.c(-3, handler);
                }
                return null;
            }
            return androidx.core.graphics.h.c(context, b3, resources, n, string2, typedValue.assetCookie, n2, e, handler, b);
        }
        catch (final IOException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to read xml resource ");
            sb2.append(string2);
            Log.e("ResourcesCompat", sb2.toString(), (Throwable)ex);
        }
        catch (final XmlPullParserException ex2) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to parse xml resource ");
            sb3.append(string2);
            Log.e("ResourcesCompat", sb3.toString(), (Throwable)ex2);
        }
        if (e != null) {
            e.c(-3, handler);
        }
        return null;
    }
    
    static class a
    {
        static Drawable a(final Resources resources, final int n, final Resources$Theme resources$Theme) {
            return resources.getDrawable(n, resources$Theme);
        }
        
        static Drawable b(final Resources resources, final int n, final int n2, final Resources$Theme resources$Theme) {
            return resources.getDrawableForDensity(n, n2, resources$Theme);
        }
    }
    
    static class b
    {
        static int a(final Resources resources, final int n, final Resources$Theme resources$Theme) {
            return resources.getColor(n, resources$Theme);
        }
        
        static ColorStateList b(final Resources resources, final int n, final Resources$Theme resources$Theme) {
            return resources.getColorStateList(n, resources$Theme);
        }
    }
    
    private static class c
    {
        final ColorStateList a;
        final Configuration b;
        final int c;
        
        c(final ColorStateList a, final Configuration b, final Resources$Theme resources$Theme) {
            this.a = a;
            this.b = b;
            int hashCode;
            if (resources$Theme == null) {
                hashCode = 0;
            }
            else {
                hashCode = resources$Theme.hashCode();
            }
            this.c = hashCode;
        }
    }
    
    private static final class d
    {
        final Resources a;
        final Resources$Theme b;
        
        d(final Resources a, final Resources$Theme b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && d.class == o.getClass()) {
                final d d = (d)o;
                if (!this.a.equals(d.a) || !androidx.core.util.c.a(this.b, d.b)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return androidx.core.util.c.b(this.a, this.b);
        }
    }
    
    public abstract static class e
    {
        public static void a(final e e, final int n) {
            e.f(n);
        }
        
        public static void b(final e e, final Typeface typeface) {
            e.g(typeface);
        }
        
        public static Handler e(final Handler handler) {
            Handler handler2 = handler;
            if (handler == null) {
                handler2 = new Handler(Looper.getMainLooper());
            }
            return handler2;
        }
        
        private void f(final int n) {
            this.h(n);
        }
        
        private void g(final Typeface typeface) {
            this.i(typeface);
        }
        
        public final void c(final int n, final Handler handler) {
            e(handler).post((Runnable)new g(this, n));
        }
        
        public final void d(final Typeface typeface, final Handler handler) {
            e(handler).post((Runnable)new androidx.core.content.res.h(this, typeface));
        }
        
        public abstract void h(final int p0);
        
        public abstract void i(final Typeface p0);
    }
    
    public static final class f
    {
        public static void a(final Resources$Theme resources$Theme) {
            if (Build$VERSION.SDK_INT >= 29) {
                b.a(resources$Theme);
            }
            else {
                a.a(resources$Theme);
            }
        }
        
        static class a
        {
            private static final Object a;
            private static Method b;
            private static boolean c;
            
            static {
                a = new Object();
            }
            
            static void a(final Resources$Theme ex) {
                synchronized (f.a.a) {
                    if (!f.a.c) {
                        try {
                            (f.a.b = Resources$Theme.class.getDeclaredMethod("rebase", (Class<?>[])new Class[0])).setAccessible(true);
                        }
                        catch (final NoSuchMethodException ex2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", (Throwable)ex2);
                        }
                        f.a.c = true;
                    }
                    final Method b = f.a.b;
                    if (b != null) {
                        try {
                            b.invoke(ex, new Object[0]);
                            return;
                        }
                        catch (final InvocationTargetException ex) {}
                        catch (final IllegalAccessException ex3) {}
                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", (Throwable)ex);
                        f.a.b = null;
                    }
                }
            }
        }
        
        static class b
        {
            static void a(final Resources$Theme resources$Theme) {
                resources$Theme.rebase();
            }
        }
    }
}
