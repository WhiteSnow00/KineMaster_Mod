// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.core.view.b0;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

public abstract class c0
{
    private final l a;
    private final ClassLoader b;
    ArrayList<a> c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j;
    String k;
    int l;
    CharSequence m;
    int n;
    CharSequence o;
    ArrayList<String> p;
    ArrayList<String> q;
    boolean r;
    ArrayList<Runnable> s;
    
    c0(final l a, final ClassLoader b) {
        this.c = new ArrayList<a>();
        this.j = true;
        this.r = false;
        this.a = a;
        this.b = b;
    }
    
    c0(final l l, final ClassLoader classLoader, final c0 c0) {
        this(l, classLoader);
        final Iterator<a> iterator = c0.c.iterator();
        while (iterator.hasNext()) {
            this.c.add(new a(iterator.next()));
        }
        this.d = c0.d;
        this.e = c0.e;
        this.f = c0.f;
        this.g = c0.g;
        this.h = c0.h;
        this.i = c0.i;
        this.j = c0.j;
        this.k = c0.k;
        this.n = c0.n;
        this.o = c0.o;
        this.l = c0.l;
        this.m = c0.m;
        if (c0.p != null) {
            (this.p = new ArrayList<String>()).addAll(c0.p);
        }
        if (c0.q != null) {
            (this.q = new ArrayList<String>()).addAll(c0.q);
        }
        this.r = c0.r;
    }
    
    public c0 b(final int n, final Fragment fragment) {
        this.n(n, fragment, null, 1);
        return this;
    }
    
    public c0 c(final int n, final Fragment fragment, final String s) {
        this.n(n, fragment, s, 1);
        return this;
    }
    
    c0 d(final ViewGroup mContainer, final Fragment fragment, final String s) {
        fragment.mContainer = mContainer;
        return this.c(mContainer.getId(), fragment, s);
    }
    
    public c0 e(final Fragment fragment, final String s) {
        this.n(0, fragment, s, 1);
        return this;
    }
    
    void f(final a a) {
        this.c.add(a);
        a.d = this.d;
        a.e = this.e;
        a.f = this.f;
        a.g = this.g;
    }
    
    public c0 g(final View view, final String s) {
        if (d0.e()) {
            final String j = b0.J(view);
            if (j == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.p == null) {
                this.p = new ArrayList<String>();
                this.q = new ArrayList<String>();
            }
            else {
                if (this.q.contains(s)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("A shared element with the target name '");
                    sb.append(s);
                    sb.append("' has already been added to the transaction.");
                    throw new IllegalArgumentException(sb.toString());
                }
                if (this.p.contains(j)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("A shared element with the source name '");
                    sb2.append(j);
                    sb2.append("' has already been added to the transaction.");
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            this.p.add(j);
            this.q.add(s);
        }
        return this;
    }
    
    public c0 h(final String k) {
        if (this.j) {
            this.i = true;
            this.k = k;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    
    public abstract int i();
    
    public abstract int j();
    
    public abstract void k();
    
    public abstract void l();
    
    public c0 m() {
        if (!this.i) {
            this.j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    
    void n(final int n, final Fragment fragment, final String mTag, final int n2) {
        final String mPreviousWho = fragment.mPreviousWho;
        if (mPreviousWho != null) {
            FragmentStrictMode.h(fragment, mPreviousWho);
        }
        final Class<? extends Fragment> class1 = fragment.getClass();
        final int modifiers = class1.getModifiers();
        if (!class1.isAnonymousClass() && Modifier.isPublic(modifiers) && (!class1.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (mTag != null) {
                final String mTag2 = fragment.mTag;
                if (mTag2 != null && !mTag.equals(mTag2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Can't change tag of fragment ");
                    sb.append(fragment);
                    sb.append(": was ");
                    sb.append(fragment.mTag);
                    sb.append(" now ");
                    sb.append(mTag);
                    throw new IllegalStateException(sb.toString());
                }
                fragment.mTag = mTag;
            }
            if (n != 0) {
                if (n == -1) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Can't add fragment ");
                    sb2.append(fragment);
                    sb2.append(" with tag ");
                    sb2.append(mTag);
                    sb2.append(" to container view with no id");
                    throw new IllegalArgumentException(sb2.toString());
                }
                final int mFragmentId = fragment.mFragmentId;
                if (mFragmentId != 0 && mFragmentId != n) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Can't change container ID of fragment ");
                    sb3.append(fragment);
                    sb3.append(": was ");
                    sb3.append(fragment.mFragmentId);
                    sb3.append(" now ");
                    sb3.append(n);
                    throw new IllegalStateException(sb3.toString());
                }
                fragment.mFragmentId = n;
                fragment.mContainerId = n;
            }
            this.f(new a(n2, fragment));
            return;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("Fragment ");
        sb4.append(class1.getCanonicalName());
        sb4.append(" must be a public static class to be  properly recreated from instance state.");
        throw new IllegalStateException(sb4.toString());
    }
    
    public abstract boolean o();
    
    public c0 p(final Fragment fragment) {
        this.f(new a(3, fragment));
        return this;
    }
    
    public c0 q(final int n, final Fragment fragment) {
        return this.r(n, fragment, null);
    }
    
    public c0 r(final int n, final Fragment fragment, final String s) {
        if (n != 0) {
            this.n(n, fragment, s, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    
    public c0 s(final int n, final int n2) {
        return this.t(n, n2, 0, 0);
    }
    
    public c0 t(final int d, final int e, final int f, final int g) {
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        return this;
    }
    
    public c0 u(final Fragment fragment, final Lifecycle.State state) {
        this.f(new a(10, fragment, state));
        return this;
    }
    
    public c0 v(final Fragment fragment) {
        this.f(new a(8, fragment));
        return this;
    }
    
    public c0 w(final boolean r) {
        this.r = r;
        return this;
    }
    
    public c0 x(final int h) {
        this.h = h;
        return this;
    }
    
    static final class a
    {
        int a;
        Fragment b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        Lifecycle.State h;
        Lifecycle.State i;
        
        a() {
        }
        
        a(final int a, final Fragment b) {
            this.a = a;
            this.b = b;
            this.c = false;
            final Lifecycle.State resumed = Lifecycle.State.RESUMED;
            this.h = resumed;
            this.i = resumed;
        }
        
        a(final int a, final Fragment b, final Lifecycle.State i) {
            this.a = a;
            this.b = b;
            this.c = false;
            this.h = b.mMaxState;
            this.i = i;
        }
        
        a(final int a, final Fragment b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
            final Lifecycle.State resumed = Lifecycle.State.RESUMED;
            this.h = resumed;
            this.i = resumed;
        }
        
        a(final a a) {
            this.a = a.a;
            this.b = a.b;
            this.c = a.c;
            this.d = a.d;
            this.e = a.e;
            this.f = a.f;
            this.g = a.g;
            this.h = a.h;
            this.i = a.i;
        }
    }
}
