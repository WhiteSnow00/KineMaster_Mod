// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import java.util.ArrayList;
import android.widget.BaseAdapter;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ContextThemeWrapper;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListAdapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.AdapterView$OnItemClickListener;

public class e implements m, AdapterView$OnItemClickListener
{
    Context a;
    LayoutInflater b;
    g c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    private m.a h;
    a i;
    private int j;
    
    public e(final int g, final int f) {
        this.g = g;
        this.f = f;
    }
    
    public e(final Context a, final int n) {
        this(n, 0);
        this.a = a;
        this.b = LayoutInflater.from(a);
    }
    
    public ListAdapter a() {
        if (this.i == null) {
            this.i = new a();
        }
        return (ListAdapter)this.i;
    }
    
    @Override
    public void b(final g g, final boolean b) {
        final m.a h = this.h;
        if (h != null) {
            h.b(g, b);
        }
    }
    
    @Override
    public boolean c(final g g, final i i) {
        return false;
    }
    
    @Override
    public void d(final m.a h) {
        this.h = h;
    }
    
    @Override
    public void e(final Parcelable parcelable) {
        this.m((Bundle)parcelable);
    }
    
    @Override
    public boolean f(final r r) {
        if (!r.hasVisibleItems()) {
            return false;
        }
        new h(r).d(null);
        final m.a h = this.h;
        if (h != null) {
            h.c(r);
        }
        return true;
    }
    
    @Override
    public Parcelable g() {
        if (this.d == null) {
            return null;
        }
        final Bundle bundle = new Bundle();
        this.n(bundle);
        return (Parcelable)bundle;
    }
    
    @Override
    public int getId() {
        return this.j;
    }
    
    @Override
    public void h(final boolean b) {
        final a i = this.i;
        if (i != null) {
            i.notifyDataSetChanged();
        }
    }
    
    @Override
    public boolean i() {
        return false;
    }
    
    @Override
    public boolean j(final g g, final i i) {
        return false;
    }
    
    @Override
    public void k(final Context a, final g c) {
        if (this.f != 0) {
            final ContextThemeWrapper a2 = new ContextThemeWrapper(a, this.f);
            this.a = (Context)a2;
            this.b = LayoutInflater.from((Context)a2);
        }
        else if (this.a != null) {
            this.a = a;
            if (this.b == null) {
                this.b = LayoutInflater.from(a);
            }
        }
        this.c = c;
        final a i = this.i;
        if (i != null) {
            i.notifyDataSetChanged();
        }
    }
    
    public n l(final ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView)this.b.inflate(d.g.g, viewGroup, false);
            if (this.i == null) {
                this.i = new a();
            }
            this.d.setAdapter((ListAdapter)this.i);
            this.d.setOnItemClickListener((AdapterView$OnItemClickListener)this);
        }
        return this.d;
    }
    
    public void m(final Bundle bundle) {
        final SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            ((View)this.d).restoreHierarchyState(sparseParcelableArray);
        }
    }
    
    public void n(final Bundle bundle) {
        final SparseArray sparseArray = new SparseArray();
        final ExpandedMenuView d = this.d;
        if (d != null) {
            ((View)d).saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        this.c.O((MenuItem)this.i.b(n), this, 0);
    }
    
    private class a extends BaseAdapter
    {
        private int a;
        final e b;
        
        public a(final e b) {
            this.b = b;
            this.a = -1;
            this.a();
        }
        
        void a() {
            final i x = this.b.c.x();
            if (x != null) {
                final ArrayList<i> b = this.b.c.B();
                for (int size = b.size(), i = 0; i < size; ++i) {
                    if (b.get(i) == x) {
                        this.a = i;
                        return;
                    }
                }
            }
            this.a = -1;
        }
        
        public i b(int n) {
            final ArrayList<i> b = this.b.c.B();
            final int n2 = n + this.b.e;
            final int a = this.a;
            n = n2;
            if (a >= 0 && (n = n2) >= a) {
                n = n2 + 1;
            }
            return b.get(n);
        }
        
        public int getCount() {
            final int n = this.b.c.B().size() - this.b.e;
            if (this.a < 0) {
                return n;
            }
            return n - 1;
        }
        
        public /* bridge */ Object getItem(final int n) {
            return this.b(n);
        }
        
        public long getItemId(final int n) {
            return n;
        }
        
        public View getView(final int n, final View view, final ViewGroup viewGroup) {
            View inflate = view;
            if (view == null) {
                final e b = this.b;
                inflate = b.b.inflate(b.g, viewGroup, false);
            }
            ((n.a)inflate).c(this.b(n), 0);
            return inflate;
        }
        
        public void notifyDataSetChanged() {
            this.a();
            super.notifyDataSetChanged();
        }
    }
}
