// 
// Decompiled by Procyon v0.6.0
// 

package androidx.versionedparcelable;

import java.lang.reflect.InvocationTargetException;
import android.os.Parcelable;
import b1.b;
import java.lang.reflect.Method;
import androidx.collection.a;

public abstract class VersionedParcel
{
    protected final a<String, Method> a;
    protected final a<String, Method> b;
    protected final a<String, Class> c;
    
    public VersionedParcel(final a<String, Method> a, final a<String, Method> b, final a<String, Class> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void N(final b b) {
        try {
            this.I(this.c(b.getClass()).getName());
        }
        catch (final ClassNotFoundException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append(b.getClass().getSimpleName());
            sb.append(" does not have a Parcelizer");
            throw new RuntimeException(sb.toString(), ex);
        }
    }
    
    private Class c(final Class<? extends b> clazz) throws ClassNotFoundException {
        Class<?> forName;
        if ((forName = this.c.get(clazz.getName())) == null) {
            forName = Class.forName(String.format("%s.%sParcelizer", clazz.getPackage().getName(), clazz.getSimpleName()), false, clazz.getClassLoader());
            this.c.put(clazz.getName(), forName);
        }
        return forName;
    }
    
    private Method d(final String s) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method declaredMethod;
        if ((declaredMethod = this.a.get(s)) == null) {
            System.currentTimeMillis();
            declaredMethod = Class.forName(s, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
            this.a.put(s, declaredMethod);
        }
        return declaredMethod;
    }
    
    private Method e(final Class clazz) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method declaredMethod;
        if ((declaredMethod = this.b.get(clazz.getName())) == null) {
            final Class c = this.c(clazz);
            System.currentTimeMillis();
            declaredMethod = c.getDeclaredMethod("write", clazz, VersionedParcel.class);
            this.b.put(clazz.getName(), declaredMethod);
        }
        return declaredMethod;
    }
    
    protected abstract void A(final byte[] p0);
    
    public void B(final byte[] array, final int n) {
        this.w(n);
        this.A(array);
    }
    
    protected abstract void C(final CharSequence p0);
    
    public void D(final CharSequence charSequence, final int n) {
        this.w(n);
        this.C(charSequence);
    }
    
    protected abstract void E(final int p0);
    
    public void F(final int n, final int n2) {
        this.w(n2);
        this.E(n);
    }
    
    protected abstract void G(final Parcelable p0);
    
    public void H(final Parcelable parcelable, final int n) {
        this.w(n);
        this.G(parcelable);
    }
    
    protected abstract void I(final String p0);
    
    public void J(final String s, final int n) {
        this.w(n);
        this.I(s);
    }
    
    protected <T extends b> void K(final T t, final VersionedParcel versionedParcel) {
        try {
            this.e(t.getClass()).invoke(null, t, versionedParcel);
        }
        catch (final ClassNotFoundException ex) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", ex);
        }
        catch (final NoSuchMethodException ex2) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", ex2);
        }
        catch (final InvocationTargetException ex3) {
            if (ex3.getCause() instanceof RuntimeException) {
                throw (RuntimeException)ex3.getCause();
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", ex3);
        }
        catch (final IllegalAccessException ex4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", ex4);
        }
    }
    
    protected void L(final b b) {
        if (b == null) {
            this.I(null);
            return;
        }
        this.N(b);
        final VersionedParcel b2 = this.b();
        this.K(b, b2);
        b2.a();
    }
    
    public void M(final b b, final int n) {
        this.w(n);
        this.L(b);
    }
    
    protected abstract void a();
    
    protected abstract VersionedParcel b();
    
    public boolean f() {
        return false;
    }
    
    protected abstract boolean g();
    
    public boolean h(final boolean b, final int n) {
        if (!this.m(n)) {
            return b;
        }
        return this.g();
    }
    
    protected abstract byte[] i();
    
    public byte[] j(final byte[] array, final int n) {
        if (!this.m(n)) {
            return array;
        }
        return this.i();
    }
    
    protected abstract CharSequence k();
    
    public CharSequence l(final CharSequence charSequence, final int n) {
        if (!this.m(n)) {
            return charSequence;
        }
        return this.k();
    }
    
    protected abstract boolean m(final int p0);
    
    protected <T extends b> T n(final String s, final VersionedParcel versionedParcel) {
        try {
            return (T)this.d(s).invoke(null, versionedParcel);
        }
        catch (final ClassNotFoundException ex) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", ex);
        }
        catch (final NoSuchMethodException ex2) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", ex2);
        }
        catch (final InvocationTargetException ex3) {
            if (ex3.getCause() instanceof RuntimeException) {
                throw (RuntimeException)ex3.getCause();
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", ex3);
        }
        catch (final IllegalAccessException ex4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", ex4);
        }
    }
    
    protected abstract int o();
    
    public int p(final int n, final int n2) {
        if (!this.m(n2)) {
            return n;
        }
        return this.o();
    }
    
    protected abstract <T extends Parcelable> T q();
    
    public <T extends Parcelable> T r(final T t, final int n) {
        if (!this.m(n)) {
            return t;
        }
        return this.q();
    }
    
    protected abstract String s();
    
    public String t(final String s, final int n) {
        if (!this.m(n)) {
            return s;
        }
        return this.s();
    }
    
    protected <T extends b> T u() {
        final String s = this.s();
        if (s == null) {
            return null;
        }
        return (T)this.n(s, this.b());
    }
    
    public <T extends b> T v(final T t, final int n) {
        if (!this.m(n)) {
            return t;
        }
        return this.u();
    }
    
    protected abstract void w(final int p0);
    
    public void x(final boolean b, final boolean b2) {
    }
    
    protected abstract void y(final boolean p0);
    
    public void z(final boolean b, final int n) {
        this.w(n);
        this.y(b);
    }
    
    public static class ParcelException extends RuntimeException
    {
        public ParcelException(final Throwable t) {
            super(t);
        }
    }
}
