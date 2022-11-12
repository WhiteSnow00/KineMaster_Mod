// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.ViewGroup;
import android.util.Log;
import androidx.core.util.h;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.lang.ref.WeakReference;
import java.util.List;

class g implements b
{
    private final ConcatAdapter a;
    private final b0 b;
    private List<WeakReference<RecyclerView>> c;
    private final IdentityHashMap<RecyclerView.c0, q> d;
    private List<q> e;
    private a f;
    private final ConcatAdapter.Config.StableIdMode g;
    private final y h;
    
    g(final ConcatAdapter a, final ConcatAdapter.Config config) {
        this.c = new ArrayList<WeakReference<RecyclerView>>();
        this.d = new IdentityHashMap<RecyclerView.c0, q>();
        this.e = new ArrayList<q>();
        this.f = new a();
        this.a = a;
        if (config.a) {
            this.b = new b0.a();
        }
        else {
            this.b = new b0.b();
        }
        final ConcatAdapter.Config.StableIdMode b = config.b;
        this.g = b;
        if (b == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.h = new y.b();
        }
        else if (b == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.h = new y.a();
        }
        else {
            if (b != ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
                throw new IllegalArgumentException("unknown stable id mode");
            }
            this.h = new y.c();
        }
    }
    
    private void D(final a f) {
        f.c = false;
        f.a = null;
        f.b = -1;
        this.f = f;
    }
    
    private void i() {
        final RecyclerView.Adapter.StateRestorationPolicy j = this.j();
        if (j != ((RecyclerView.Adapter)this.a).getStateRestorationPolicy()) {
            this.a.m(j);
        }
    }
    
    private RecyclerView.Adapter.StateRestorationPolicy j() {
        for (final q q : this.e) {
            final RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = q.c.getStateRestorationPolicy();
            final RecyclerView.Adapter.StateRestorationPolicy prevent = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == prevent) {
                return prevent;
            }
            if (stateRestorationPolicy == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && q.a() == 0) {
                return prevent;
            }
        }
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }
    
    private int k(final q q) {
        final Iterator<q> iterator = this.e.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final q q2 = iterator.next();
            if (q2 == q) {
                break;
            }
            n += q2.a();
        }
        return n;
    }
    
    private a l(final int n) {
        a f = this.f;
        if (f.c) {
            f = new a();
        }
        else {
            f.c = true;
        }
        final Iterator<q> iterator = this.e.iterator();
        int b = n;
        while (iterator.hasNext()) {
            final q a = iterator.next();
            if (a.a() > b) {
                f.a = a;
                f.b = b;
                break;
            }
            b -= a.a();
        }
        if (f.a != null) {
            return f;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot find wrapper for ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    private q m(final RecyclerView.Adapter<RecyclerView.c0> adapter) {
        final int t = this.t(adapter);
        if (t == -1) {
            return null;
        }
        return this.e.get(t);
    }
    
    private q r(final RecyclerView.c0 c0) {
        final q q = this.d.get(c0);
        if (q != null) {
            return q;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot find wrapper for ");
        sb.append(c0);
        sb.append(", seems like it is not bound by this adapter: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }
    
    private int t(final RecyclerView.Adapter<RecyclerView.c0> adapter) {
        for (int size = this.e.size(), i = 0; i < size; ++i) {
            if (this.e.get(i).c == adapter) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean u(final RecyclerView recyclerView) {
        final Iterator<WeakReference<RecyclerView>> iterator = this.c.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().get() == recyclerView) {
                return true;
            }
        }
        return false;
    }
    
    public void A(final RecyclerView.c0 c0) {
        this.r(c0).c.onViewAttachedToWindow(c0);
    }
    
    public void B(final RecyclerView.c0 c0) {
        this.r(c0).c.onViewDetachedFromWindow(c0);
    }
    
    public void C(final RecyclerView.c0 c0) {
        final q q = this.d.get(c0);
        if (q != null) {
            q.c.onViewRecycled(c0);
            this.d.remove(c0);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot find wrapper for ");
        sb.append(c0);
        sb.append(", seems like it is not bound by this adapter: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }
    
    @Override
    public void a(final q q, final int n, final int n2, final Object o) {
        ((RecyclerView.Adapter)this.a).notifyItemRangeChanged(n + this.k(q), n2, o);
    }
    
    @Override
    public void b(final q q, final int n, final int n2) {
        ((RecyclerView.Adapter)this.a).notifyItemRangeInserted(n + this.k(q), n2);
    }
    
    @Override
    public void c(final q q, final int n, final int n2) {
        final int k = this.k(q);
        ((RecyclerView.Adapter)this.a).notifyItemMoved(n + k, n2 + k);
    }
    
    @Override
    public void d(final q q) {
        this.i();
    }
    
    @Override
    public void e(final q q) {
        ((RecyclerView.Adapter)this.a).notifyDataSetChanged();
        this.i();
    }
    
    @Override
    public void f(final q q, final int n, final int n2) {
        ((RecyclerView.Adapter)this.a).notifyItemRangeRemoved(n + this.k(q), n2);
    }
    
    boolean g(final int n, final RecyclerView.Adapter<RecyclerView.c0> adapter) {
        if (n < 0 || n > this.e.size()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Index must be between 0 and ");
            sb.append(this.e.size());
            sb.append(". Given:");
            sb.append(n);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (this.s()) {
            androidx.core.util.h.b(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        }
        else if (adapter.hasStableIds()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (this.m(adapter) != null) {
            return false;
        }
        final q q = new q(adapter, (q.b)this, this.b, this.h.a());
        this.e.add(n, q);
        final Iterator<WeakReference<RecyclerView>> iterator = this.c.iterator();
        while (iterator.hasNext()) {
            final RecyclerView recyclerView = iterator.next().get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (q.a() > 0) {
            ((RecyclerView.Adapter)this.a).notifyItemRangeInserted(this.k(q), q.a());
        }
        this.i();
        return true;
    }
    
    boolean h(final RecyclerView.Adapter<RecyclerView.c0> adapter) {
        return this.g(this.e.size(), adapter);
    }
    
    public long n(final int n) {
        final a l = this.l(n);
        final long b = l.a.b(l.b);
        this.D(l);
        return b;
    }
    
    public int o(int c) {
        final a l = this.l(c);
        c = l.a.c(l.b);
        this.D(l);
        return c;
    }
    
    public int p(final RecyclerView.Adapter<? extends RecyclerView.c0> adapter, final RecyclerView.c0 c0, int itemCount) {
        final q q = this.d.get(c0);
        if (q == null) {
            return -1;
        }
        final int n = itemCount - this.k(q);
        itemCount = q.c.getItemCount();
        if (n >= 0 && n < itemCount) {
            return q.c.findRelativeAdapterPositionIn(adapter, c0, n);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Detected inconsistent adapter updates. The local position of the view holder maps to ");
        sb.append(n);
        sb.append(" which is out of bounds for the adapter with size ");
        sb.append(itemCount);
        sb.append(".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        sb.append(c0);
        sb.append("adapter:");
        sb.append(adapter);
        throw new IllegalStateException(sb.toString());
    }
    
    public int q() {
        final Iterator<q> iterator = this.e.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += iterator.next().a();
        }
        return n;
    }
    
    public boolean s() {
        return this.g != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }
    
    public void v(final RecyclerView recyclerView) {
        if (this.u(recyclerView)) {
            return;
        }
        this.c.add(new WeakReference<RecyclerView>(recyclerView));
        final Iterator<q> iterator = this.e.iterator();
        while (iterator.hasNext()) {
            iterator.next().c.onAttachedToRecyclerView(recyclerView);
        }
    }
    
    public void w(final RecyclerView.c0 c0, final int n) {
        final a l = this.l(n);
        this.d.put(c0, l.a);
        l.a.d(c0, l.b);
        this.D(l);
    }
    
    public RecyclerView.c0 x(final ViewGroup viewGroup, final int n) {
        return this.b.a(n).e(viewGroup, n);
    }
    
    public void y(final RecyclerView recyclerView) {
        for (int i = this.c.size() - 1; i >= 0; --i) {
            final WeakReference weakReference = this.c.get(i);
            if (weakReference.get() == null) {
                this.c.remove(i);
            }
            else if (weakReference.get() == recyclerView) {
                this.c.remove(i);
                break;
            }
        }
        final Iterator<q> iterator = this.e.iterator();
        while (iterator.hasNext()) {
            iterator.next().c.onDetachedFromRecyclerView(recyclerView);
        }
    }
    
    public boolean z(final RecyclerView.c0 c0) {
        final q q = this.d.get(c0);
        if (q != null) {
            final boolean onFailedToRecycleView = q.c.onFailedToRecycleView(c0);
            this.d.remove(c0);
            return onFailedToRecycleView;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot find wrapper for ");
        sb.append(c0);
        sb.append(", seems like it is not bound by this adapter: ");
        sb.append(this);
        throw new IllegalStateException(sb.toString());
    }
    
    static class a
    {
        q a;
        int b;
        boolean c;
    }
}
