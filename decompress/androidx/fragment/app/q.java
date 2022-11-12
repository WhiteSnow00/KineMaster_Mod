// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.view.View;
import android.content.Context;
import java.util.Iterator;
import android.os.Bundle;
import java.util.concurrent.CopyOnWriteArrayList;

class q
{
    private final CopyOnWriteArrayList<a> a;
    private final FragmentManager b;
    
    q(final FragmentManager b) {
        this.a = new CopyOnWriteArrayList<a>();
        this.b = b;
    }
    
    void a(final Fragment fragment, final Bundle bundle, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().a(fragment, bundle, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.a(this.b, fragment, bundle);
            }
        }
    }
    
    void b(final Fragment fragment, final boolean b) {
        final Context f = this.b.A0().f();
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().b(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.b(this.b, fragment, f);
            }
        }
    }
    
    void c(final Fragment fragment, final Bundle bundle, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().c(fragment, bundle, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.c(this.b, fragment, bundle);
            }
        }
    }
    
    void d(final Fragment fragment, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().d(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.d(this.b, fragment);
            }
        }
    }
    
    void e(final Fragment fragment, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().e(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.e(this.b, fragment);
            }
        }
    }
    
    void f(final Fragment fragment, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().f(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.f(this.b, fragment);
            }
        }
    }
    
    void g(final Fragment fragment, final boolean b) {
        final Context f = this.b.A0().f();
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().g(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.g(this.b, fragment, f);
            }
        }
    }
    
    void h(final Fragment fragment, final Bundle bundle, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().h(fragment, bundle, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.h(this.b, fragment, bundle);
            }
        }
    }
    
    void i(final Fragment fragment, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().i(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.i(this.b, fragment);
            }
        }
    }
    
    void j(final Fragment fragment, final Bundle bundle, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().j(fragment, bundle, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.j(this.b, fragment, bundle);
            }
        }
    }
    
    void k(final Fragment fragment, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().k(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.k(this.b, fragment);
            }
        }
    }
    
    void l(final Fragment fragment, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().l(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.l(this.b, fragment);
            }
        }
    }
    
    void m(final Fragment fragment, final View view, final Bundle bundle, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().m(fragment, view, bundle, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.m(this.b, fragment, view, bundle);
            }
        }
    }
    
    void n(final Fragment fragment, final boolean b) {
        final Fragment d0 = this.b.D0();
        if (d0 != null) {
            d0.getParentFragmentManager().C0().n(fragment, true);
        }
        for (final a a : this.a) {
            if (!b || a.b) {
                a.a.n(this.b, fragment);
            }
        }
    }
    
    public void o(final FragmentManager.l l, final boolean b) {
        this.a.add(new a(l, b));
    }
    
    public void p(final FragmentManager.l l) {
        final CopyOnWriteArrayList<a> a = this.a;
        monitorenter(a);
        int i = 0;
        try {
            while (i < this.a.size()) {
                if (this.a.get(i).a == l) {
                    this.a.remove(i);
                    break;
                }
                ++i;
            }
        }
        finally {
            monitorexit(a);
        }
    }
    
    private static final class a
    {
        final FragmentManager.l a;
        final boolean b;
        
        a(final FragmentManager.l a, final boolean b) {
            this.a = a;
            this.b = b;
        }
    }
}
