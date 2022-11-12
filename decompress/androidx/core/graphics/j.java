// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.os.ParcelFileDescriptor;
import android.content.res.AssetManager;
import java.lang.reflect.Array;
import android.net.Uri;
import java.util.Map;
import android.content.ContentResolver;
import java.io.IOException;
import android.graphics.Typeface$Builder;
import androidx.core.provider.g;
import android.os.CancellationSignal;
import android.graphics.Typeface;
import android.content.res.Resources;
import androidx.core.content.res.d;
import java.nio.ByteBuffer;
import android.graphics.fonts.FontVariationAxis;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Executable;
import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class j extends i
{
    protected final Class<?> g;
    protected final Constructor<?> h;
    protected final Method i;
    protected final Method j;
    protected final Method k;
    protected final Method l;
    protected final Method m;
    
    public j() {
        final Class<?> clazz = null;
        Class<?> s = null;
        Constructor<?> t = null;
        Method p = null;
        Executable q = null;
        Method u = null;
        Method o = null;
        Method r = null;
        Label_0120: {
            try {
                s = this.s();
                t = this.t(s);
                p = this.p(s);
                q = this.q(s);
                u = this.u(s);
                o = this.o(s);
                r = this.r(s);
                break Label_0120;
            }
            catch (final NoSuchMethodException s) {}
            catch (final ClassNotFoundException ex) {}
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to collect necessary methods for class ");
            sb.append(s.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", sb.toString(), (Throwable)s);
            r = null;
            t = null;
            final Constructor<?> constructor = (Constructor<?>)(q = t);
            u = (o = (Method)q);
            p = (Method)constructor;
            s = clazz;
        }
        this.g = s;
        this.h = t;
        this.i = p;
        this.j = (Method)q;
        this.k = u;
        this.l = o;
        this.m = r;
    }
    
    private Object i() {
        try {
            return this.h.newInstance(new Object[0]);
        }
        catch (final IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            return null;
        }
    }
    
    private void j(final Object o) {
        try {
            this.l.invoke(o, new Object[0]);
        }
        catch (final IllegalAccessException | InvocationTargetException ex) {}
    }
    
    private boolean k(final Context context, final Object o, final String s, final int n, final int n2, final int n3, final FontVariationAxis[] array) {
        try {
            return (boolean)this.i.invoke(o, context.getAssets(), s, 0, Boolean.FALSE, n, n2, n3, array);
        }
        catch (final IllegalAccessException | InvocationTargetException ex) {
            return false;
        }
    }
    
    private boolean l(final Object o, final ByteBuffer byteBuffer, final int n, final int n2, final int n3) {
        try {
            return (boolean)this.j.invoke(o, byteBuffer, n, null, n2, n3);
        }
        catch (final IllegalAccessException | InvocationTargetException ex) {
            return false;
        }
    }
    
    private boolean m(final Object o) {
        try {
            return (boolean)this.k.invoke(o, new Object[0]);
        }
        catch (final IllegalAccessException | InvocationTargetException ex) {
            return false;
        }
    }
    
    private boolean n() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }
    
    @Override
    public Typeface a(final Context context, final d.c c, final Resources resources, int i) {
        if (!this.n()) {
            return super.a(context, c, resources, i);
        }
        final Object j = this.i();
        if (j == null) {
            return null;
        }
        final d.d[] a = c.a();
        int length;
        d.d d;
        for (length = a.length, i = 0; i < length; ++i) {
            d = a[i];
            if (!this.k(context, j, d.a(), d.c(), d.e(), d.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(d.d()))) {
                this.j(j);
                return null;
            }
        }
        if (!this.m(j)) {
            return null;
        }
        return this.g(j);
    }
    
    @Override
    public Typeface b(Context openFileDescriptor, final CancellationSignal cancellationSignal, final g.b[] array, final int n) {
        if (array.length < 1) {
            return null;
        }
        if (!this.n()) {
            final g.b e = this.e(array, n);
            final ContentResolver contentResolver = openFileDescriptor.getContentResolver();
            try {
                openFileDescriptor = (Context)contentResolver.openFileDescriptor(e.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        ((ParcelFileDescriptor)openFileDescriptor).close();
                    }
                    return null;
                }
                try {
                    final Typeface build = new Typeface$Builder(((ParcelFileDescriptor)openFileDescriptor).getFileDescriptor()).setWeight(e.e()).setItalic(e.f()).build();
                    ((ParcelFileDescriptor)openFileDescriptor).close();
                    return build;
                }
                finally {
                    try {
                        ((ParcelFileDescriptor)openFileDescriptor).close();
                    }
                    finally {
                        final Throwable t;
                        ((Throwable)cancellationSignal).addSuppressed(t);
                    }
                }
            }
            catch (final IOException ex) {
                return null;
            }
        }
        final Map<Uri, ByteBuffer> f = n.f(openFileDescriptor, array, cancellationSignal);
        final Object i = this.i();
        if (i == null) {
            return null;
        }
        final int length = array.length;
        boolean b = false;
        for (final g.b b2 : array) {
            final ByteBuffer byteBuffer = f.get(b2.d());
            if (byteBuffer != null) {
                if (!this.l(i, byteBuffer, b2.c(), b2.e(), b2.f() ? 1 : 0)) {
                    this.j(i);
                    return null;
                }
                b = true;
            }
        }
        if (!b) {
            this.j(i);
            return null;
        }
        if (!this.m(i)) {
            return null;
        }
        final Typeface g = this.g(i);
        if (g == null) {
            return null;
        }
        return Typeface.create(g, n);
    }
    
    @Override
    public Typeface c(final Context context, final Resources resources, final int n, final String s, final int n2) {
        if (!this.n()) {
            return super.c(context, resources, n, s, n2);
        }
        final Object i = this.i();
        if (i == null) {
            return null;
        }
        if (!this.k(context, i, s, 0, -1, -1, null)) {
            this.j(i);
            return null;
        }
        if (!this.m(i)) {
            return null;
        }
        return this.g(i);
    }
    
    protected Typeface g(final Object o) {
        try {
            final Object instance = Array.newInstance(this.g, 1);
            Array.set(instance, 0, o);
            return (Typeface)this.m.invoke(null, instance, -1, -1);
        }
        catch (final IllegalAccessException | InvocationTargetException ex) {
            return null;
        }
    }
    
    protected Method o(final Class<?> clazz) throws NoSuchMethodException {
        return clazz.getMethod("abortCreation", (Class[])new Class[0]);
    }
    
    protected Method p(final Class<?> clazz) throws NoSuchMethodException {
        final Class<Integer> type = Integer.TYPE;
        return clazz.getMethod("addFontFromAssetManager", AssetManager.class, String.class, type, Boolean.TYPE, type, type, type, FontVariationAxis[].class);
    }
    
    protected Method q(final Class<?> clazz) throws NoSuchMethodException {
        final Class<Integer> type = Integer.TYPE;
        return clazz.getMethod("addFontFromBuffer", ByteBuffer.class, type, FontVariationAxis[].class, type, type);
    }
    
    protected Method r(final Class<?> clazz) throws NoSuchMethodException {
        final Class<?> class1 = Array.newInstance(clazz, 1).getClass();
        final Class<Integer> type = Integer.TYPE;
        final Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", class1, type, type);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
    
    protected Class<?> s() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }
    
    protected Constructor<?> t(final Class<?> clazz) throws NoSuchMethodException {
        return clazz.getConstructor((Class<?>[])new Class[0]);
    }
    
    protected Method u(final Class<?> clazz) throws NoSuchMethodException {
        return clazz.getMethod("freeze", (Class[])new Class[0]);
    }
}
