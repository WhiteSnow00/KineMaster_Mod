// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.res.Resources$Theme;
import androidx.collection.e;
import android.graphics.ColorFilter;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.drawable.a;
import android.util.AttributeSet;
import android.content.res.XmlResourceParser;
import android.content.res.Resources;
import android.util.Log;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import android.graphics.PorterDuffColorFilter;
import g.b;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.graphics.drawable.Drawable$ConstantState;
import java.lang.ref.WeakReference;
import androidx.collection.d;
import androidx.collection.g;
import android.content.res.ColorStateList;
import androidx.collection.h;
import android.content.Context;
import java.util.WeakHashMap;
import android.graphics.PorterDuff$Mode;

public final class h0
{
    private static final PorterDuff$Mode h;
    private static h0 i;
    private static final a j;
    private WeakHashMap<Context, h<ColorStateList>> a;
    private g<String, b> b;
    private h<String> c;
    private final WeakHashMap<Context, d<WeakReference<Drawable$ConstantState>>> d;
    private TypedValue e;
    private boolean f;
    private c g;
    
    static {
        h = PorterDuff$Mode.SRC_IN;
        j = new a(6);
    }
    
    public h0() {
        this.d = new WeakHashMap<Context, d<WeakReference<Drawable$ConstantState>>>(0);
    }
    
    private boolean a(final Context context, final long n, final Drawable drawable) {
        synchronized (this) {
            final Drawable$ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                d d;
                if ((d = this.d.get(context)) == null) {
                    d = new d();
                    this.d.put(context, d);
                }
                d.l(n, new WeakReference(constantState));
                return true;
            }
            return false;
        }
    }
    
    private void b(final Context context, final int n, final ColorStateList list) {
        if (this.a == null) {
            this.a = new WeakHashMap<Context, h<ColorStateList>>();
        }
        h h;
        if ((h = this.a.get(context)) == null) {
            h = new h();
            this.a.put(context, h);
        }
        h.b(n, list);
    }
    
    private void c(final Context context) {
        if (this.f) {
            return;
        }
        this.f = true;
        final Drawable i = this.i(context, g.b.a);
        if (i != null && p(i)) {
            return;
        }
        this.f = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }
    
    private static long d(final TypedValue typedValue) {
        return (long)typedValue.assetCookie << 32 | (long)typedValue.data;
    }
    
    private Drawable e(final Context context, final int n) {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        final TypedValue e = this.e;
        context.getResources().getValue(n, e, true);
        final long d = d(e);
        final Drawable h = this.h(context, d);
        if (h != null) {
            return h;
        }
        final c g = this.g;
        Drawable a;
        if (g == null) {
            a = null;
        }
        else {
            a = g.a(this, context, n);
        }
        if (a != null) {
            a.setChangingConfigurations(e.changingConfigurations);
            this.a(context, d, a);
        }
        return a;
    }
    
    private static PorterDuffColorFilter f(final ColorStateList list, final PorterDuff$Mode porterDuff$Mode, final int[] array) {
        if (list != null && porterDuff$Mode != null) {
            return k(list.getColorForState(array, 0), porterDuff$Mode);
        }
        return null;
    }
    
    public static h0 g() {
        synchronized (h0.class) {
            if (h0.i == null) {
                o(h0.i = new h0());
            }
            return h0.i;
        }
    }
    
    private Drawable h(final Context context, final long n) {
        synchronized (this) {
            final d d = this.d.get(context);
            if (d == null) {
                return null;
            }
            final WeakReference weakReference = (WeakReference)d.f(n);
            if (weakReference != null) {
                final Drawable$ConstantState drawable$ConstantState = (Drawable$ConstantState)weakReference.get();
                if (drawable$ConstantState != null) {
                    return drawable$ConstantState.newDrawable(context.getResources());
                }
                d.m(n);
            }
            return null;
        }
    }
    
    public static PorterDuffColorFilter k(final int n, final PorterDuff$Mode porterDuff$Mode) {
        synchronized (h0.class) {
            final a j = h0.j;
            PorterDuffColorFilter b;
            if ((b = j.b(n, porterDuff$Mode)) == null) {
                b = new PorterDuffColorFilter(n, porterDuff$Mode);
                j.c(n, porterDuff$Mode, b);
            }
            return b;
        }
    }
    
    private ColorStateList m(final Context context, final int n) {
        final WeakHashMap<Context, h<ColorStateList>> a = this.a;
        ColorStateList list = null;
        if (a != null) {
            final h h = a.get(context);
            list = list;
            if (h != null) {
                list = (ColorStateList)h.g(n);
            }
        }
        return list;
    }
    
    private static void o(final h0 h0) {
    }
    
    private static boolean p(final Drawable drawable) {
        return drawable instanceof a1.d || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
    
    private Drawable q(final Context context, final int n) {
        final g<String, b> b = this.b;
        if (b == null || b.isEmpty()) {
            return null;
        }
        final h<String> c = this.c;
        if (c != null) {
            final String s = c.g(n);
            if ("appcompat_skip_skip".equals(s) || (s != null && this.b.get(s) == null)) {
                return null;
            }
        }
        else {
            this.c = new h<String>();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        final TypedValue e = this.e;
        final Resources resources = context.getResources();
        resources.getValue(n, e, true);
        final long d = d(e);
        final Drawable h = this.h(context, d);
        if (h != null) {
            return h;
        }
        final CharSequence string = e.string;
        Drawable drawable = h;
        if (string != null) {
            drawable = h;
            if (string.toString().endsWith(".xml")) {
                drawable = h;
                try {
                    final XmlResourceParser xml = resources.getXml(n);
                    drawable = h;
                    final AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xml);
                    int next;
                    do {
                        drawable = h;
                        next = ((XmlPullParser)xml).next();
                    } while (next != 2 && next != 1);
                    if (next != 2) {
                        drawable = h;
                        drawable = h;
                        final XmlPullParserException ex = new XmlPullParserException("No start tag found");
                        drawable = h;
                        throw ex;
                    }
                    drawable = h;
                    final String name = ((XmlPullParser)xml).getName();
                    drawable = h;
                    this.c.b(n, name);
                    drawable = h;
                    final b b2 = this.b.get(name);
                    Drawable a = h;
                    if (b2 != null) {
                        drawable = h;
                        a = b2.a(context, (XmlPullParser)xml, attributeSet, context.getTheme());
                    }
                    if ((drawable = a) != null) {
                        drawable = a;
                        a.setChangingConfigurations(e.changingConfigurations);
                        drawable = a;
                        this.a(context, d, a);
                        drawable = a;
                    }
                }
                catch (final Exception ex2) {
                    Log.e("ResourceManagerInternal", "Exception while inflating drawable", (Throwable)ex2);
                }
            }
        }
        if (drawable == null) {
            this.c.b(n, "appcompat_skip_skip");
        }
        return drawable;
    }
    
    private Drawable u(final Context context, final int n, final boolean b, final Drawable drawable) {
        final ColorStateList l = this.l(context, n);
        Drawable drawable2;
        if (l != null) {
            Drawable mutate = drawable;
            if (a0.a(drawable)) {
                mutate = drawable.mutate();
            }
            final Drawable i = androidx.core.graphics.drawable.a.l(mutate);
            androidx.core.graphics.drawable.a.i(i, l);
            final PorterDuff$Mode n2 = this.n(n);
            drawable2 = i;
            if (n2 != null) {
                androidx.core.graphics.drawable.a.j(i, n2);
                drawable2 = i;
            }
        }
        else {
            final c g = this.g;
            if (g != null && g.e(context, n, drawable)) {
                drawable2 = drawable;
            }
            else {
                drawable2 = drawable;
                if (!this.w(context, n, drawable)) {
                    drawable2 = drawable;
                    if (b) {
                        drawable2 = null;
                    }
                }
            }
        }
        return drawable2;
    }
    
    static void v(final Drawable drawable, final p0 p3, final int[] array) {
        final int[] state = drawable.getState();
        if (a0.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (drawable instanceof LayerDrawable && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        final boolean d = p3.d;
        if (!d && !p3.c) {
            drawable.clearColorFilter();
        }
        else {
            ColorStateList a;
            if (d) {
                a = p3.a;
            }
            else {
                a = null;
            }
            PorterDuff$Mode porterDuff$Mode;
            if (p3.c) {
                porterDuff$Mode = p3.b;
            }
            else {
                porterDuff$Mode = h0.h;
            }
            drawable.setColorFilter((ColorFilter)f(a, porterDuff$Mode, array));
        }
    }
    
    public Drawable i(final Context context, final int n) {
        synchronized (this) {
            return this.j(context, n, false);
        }
    }
    
    Drawable j(final Context context, final int n, final boolean b) {
        synchronized (this) {
            this.c(context);
            Drawable drawable;
            if ((drawable = this.q(context, n)) == null) {
                drawable = this.e(context, n);
            }
            Drawable drawable2;
            if ((drawable2 = drawable) == null) {
                drawable2 = androidx.core.content.a.getDrawable(context, n);
            }
            Drawable u;
            if ((u = drawable2) != null) {
                u = this.u(context, n, b, drawable2);
            }
            if (u != null) {
                a0.b(u);
            }
            return u;
        }
    }
    
    ColorStateList l(final Context context, final int n) {
        synchronized (this) {
            ColorStateList m;
            if ((m = this.m(context, n)) == null) {
                final c g = this.g;
                ColorStateList b;
                if (g == null) {
                    b = null;
                }
                else {
                    b = g.b(context, n);
                }
                m = b;
                if (b != null) {
                    this.b(context, n, b);
                    m = b;
                }
            }
            return m;
        }
    }
    
    PorterDuff$Mode n(final int n) {
        final c g = this.g;
        PorterDuff$Mode d;
        if (g == null) {
            d = null;
        }
        else {
            d = g.d(n);
        }
        return d;
    }
    
    public void r(final Context context) {
        synchronized (this) {
            final d d = this.d.get(context);
            if (d != null) {
                d.b();
            }
        }
    }
    
    Drawable s(final Context context, final v0 v0, final int n) {
        synchronized (this) {
            Drawable drawable;
            if ((drawable = this.q(context, n)) == null) {
                drawable = v0.a(n);
            }
            if (drawable != null) {
                return this.u(context, n, false, drawable);
            }
            return null;
        }
    }
    
    public void t(final c g) {
        synchronized (this) {
            this.g = g;
        }
    }
    
    boolean w(final Context context, final int n, final Drawable drawable) {
        final c g = this.g;
        return g != null && g.c(context, n, drawable);
    }
    
    private static class a extends e<Integer, PorterDuffColorFilter>
    {
        public a(final int n) {
            super(n);
        }
        
        private static int a(final int n, final PorterDuff$Mode porterDuff$Mode) {
            return (n + 31) * 31 + porterDuff$Mode.hashCode();
        }
        
        PorterDuffColorFilter b(final int n, final PorterDuff$Mode porterDuff$Mode) {
            return this.get(a(n, porterDuff$Mode));
        }
        
        PorterDuffColorFilter c(final int n, final PorterDuff$Mode porterDuff$Mode, final PorterDuffColorFilter porterDuffColorFilter) {
            return this.put(a(n, porterDuff$Mode), porterDuffColorFilter);
        }
    }
    
    private interface b
    {
        Drawable a(final Context p0, final XmlPullParser p1, final AttributeSet p2, final Resources$Theme p3);
    }
    
    public interface c
    {
        Drawable a(final h0 p0, final Context p1, final int p2);
        
        ColorStateList b(final Context p0, final int p1);
        
        boolean c(final Context p0, final int p1, final Drawable p2);
        
        PorterDuff$Mode d(final int p0);
        
        boolean e(final Context p0, final int p1, final Drawable p2);
    }
}
