// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import java.util.Collection;
import androidx.fragment.app.Fragment;
import android.graphics.Rect;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.view.View;
import java.util.List;
import androidx.fragment.app.f0;

public class e extends f0
{
    private static boolean v(final m m) {
        return !f0.i(m.C()) || !f0.i(m.D()) || !f0.i(m.E());
    }
    
    @Override
    public void a(final Object o, final View view) {
        if (o != null) {
            ((m)o).c(view);
        }
    }
    
    @Override
    public void b(final Object o, final ArrayList<View> list) {
        final m m = (m)o;
        if (m == null) {
            return;
        }
        final boolean b = m instanceof q;
        int i = 0;
        final int n = 0;
        if (b) {
            final q q = (q)m;
            for (int n2 = q.n0(), j = n; j < n2; ++j) {
                this.b(q.m0(j), list);
            }
        }
        else if (!v(m) && f0.i(m.F())) {
            while (i < list.size()) {
                m.c((View)list.get(i));
                ++i;
            }
        }
    }
    
    @Override
    public void c(final ViewGroup viewGroup, final Object o) {
        o.a(viewGroup, (m)o);
    }
    
    @Override
    public boolean e(final Object o) {
        return o instanceof m;
    }
    
    @Override
    public Object f(final Object o) {
        m n;
        if (o != null) {
            n = ((m)o).n();
        }
        else {
            n = null;
        }
        return n;
    }
    
    @Override
    public Object j(final Object o, Object o2, final Object o3) {
        m s0 = (m)o;
        final m m = (m)o2;
        final m i = (m)o3;
        if (s0 != null && m != null) {
            s0 = new q().k0(s0).k0(m).s0(1);
        }
        else if (s0 == null) {
            if (m != null) {
                s0 = m;
            }
            else {
                s0 = null;
            }
        }
        if (i != null) {
            o2 = new q();
            if (s0 != null) {
                ((q)o2).k0(s0);
            }
            ((q)o2).k0(i);
            return o2;
        }
        return s0;
    }
    
    @Override
    public Object k(final Object o, final Object o2, final Object o3) {
        final q q = new q();
        if (o != null) {
            q.k0((m)o);
        }
        if (o2 != null) {
            q.k0((m)o2);
        }
        if (o3 != null) {
            q.k0((m)o3);
        }
        return q;
    }
    
    @Override
    public void m(final Object o, final View view, final ArrayList<View> list) {
        ((m)o).b((m.f)new m.f(this, view, list) {
            final View a;
            final ArrayList b;
            final e c;
            
            @Override
            public void a(final m m) {
            }
            
            @Override
            public void b(final m m) {
                m.T((m.f)this);
                m.b((m.f)this);
            }
            
            @Override
            public void c(final m m) {
                m.T((m.f)this);
                this.a.setVisibility(8);
                for (int size = this.b.size(), i = 0; i < size; ++i) {
                    ((View)this.b.get(i)).setVisibility(0);
                }
            }
            
            @Override
            public void d(final m m) {
            }
            
            @Override
            public void e(final m m) {
            }
        });
    }
    
    @Override
    public void n(final Object o, final Object o2, final ArrayList<View> list, final Object o3, final ArrayList<View> list2, final Object o4, final ArrayList<View> list3) {
        ((m)o).b((m.f)new n(this, o2, list, o3, list2, o4, list3) {
            final Object a;
            final ArrayList b;
            final Object c;
            final ArrayList d;
            final Object e;
            final ArrayList f;
            final e g;
            
            @Override
            public void b(final m m) {
                final Object a = this.a;
                if (a != null) {
                    this.g.w(a, this.b, null);
                }
                final Object c = this.c;
                if (c != null) {
                    this.g.w(c, this.d, null);
                }
                final Object e = this.e;
                if (e != null) {
                    this.g.w(e, this.f, null);
                }
            }
            
            @Override
            public void c(final m m) {
                m.T((m.f)this);
            }
        });
    }
    
    @Override
    public void o(final Object o, final Rect rect) {
        if (o != null) {
            ((m)o).a0((m.e)new m.e(this, rect) {
                final Rect a;
                final e b;
            });
        }
    }
    
    @Override
    public void p(final Object o, final View view) {
        if (view != null) {
            final m m = (m)o;
            final Rect rect = new Rect();
            this.h(view, rect);
            m.a0((m.e)new m.e(this, rect) {
                final Rect a;
                final e b;
            });
        }
    }
    
    @Override
    public void q(final Fragment fragment, final Object o, final androidx.core.os.e e, final Runnable runnable) {
        final m m = (m)o;
        e.b((androidx.core.os.e.b)new androidx.core.os.e.b(this, m) {
            final m a;
            final e b;
            
            @Override
            public void a() {
                this.a.cancel();
            }
        });
        m.b((m.f)new m.f(this, runnable) {
            final Runnable a;
            final e b;
            
            @Override
            public void a(final m m) {
            }
            
            @Override
            public void b(final m m) {
            }
            
            @Override
            public void c(final m m) {
                this.a.run();
            }
            
            @Override
            public void d(final m m) {
            }
            
            @Override
            public void e(final m m) {
            }
        });
    }
    
    @Override
    public void s(final Object o, final View view, final ArrayList<View> list) {
        final q q = (q)o;
        final List<View> f = q.F();
        f.clear();
        for (int size = list.size(), i = 0; i < size; ++i) {
            f0.d(f, (View)list.get(i));
        }
        f.add(view);
        list.add(view);
        this.b(q, list);
    }
    
    @Override
    public void t(final Object o, final ArrayList<View> list, final ArrayList<View> list2) {
        final q q = (q)o;
        if (q != null) {
            q.F().clear();
            q.F().addAll(list2);
            this.w(q, list, list2);
        }
    }
    
    @Override
    public Object u(final Object o) {
        if (o == null) {
            return null;
        }
        final q q = new q();
        q.k0((m)o);
        return q;
    }
    
    public void w(final Object o, final ArrayList<View> list, final ArrayList<View> list2) {
        final m m = (m)o;
        final boolean b = m instanceof q;
        int i = 0;
        int j = 0;
        if (b) {
            for (q q = (q)m; j < q.n0(); ++j) {
                this.w(q.m0(j), list, list2);
            }
        }
        else if (!v(m)) {
            final List<View> f = m.F();
            if (f.size() == list.size() && f.containsAll(list)) {
                int size;
                if (list2 == null) {
                    size = 0;
                }
                else {
                    size = list2.size();
                }
                while (i < size) {
                    m.c((View)list2.get(i));
                    ++i;
                }
                for (int k = list.size() - 1; k >= 0; --k) {
                    m.U((View)list.get(k));
                }
            }
        }
    }
}
