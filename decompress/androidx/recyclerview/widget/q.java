// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.util.h;

class q
{
    private final b0.c a;
    private final y.d b;
    public final RecyclerView.Adapter<RecyclerView.c0> c;
    final b d;
    int e;
    private RecyclerView.i f;
    
    q(final RecyclerView.Adapter<RecyclerView.c0> c, final b d, final b0 b0, final y.d b2) {
        this.f = new RecyclerView.i() {
            final q a;
            
            @Override
            public void onChanged() {
                final q a = this.a;
                a.e = a.c.getItemCount();
                final q a2 = this.a;
                a2.d.e(a2);
            }
            
            @Override
            public void onItemRangeChanged(final int n, final int n2) {
                final q a = this.a;
                a.d.a(a, n, n2, null);
            }
            
            @Override
            public void onItemRangeChanged(final int n, final int n2, final Object o) {
                final q a = this.a;
                a.d.a(a, n, n2, o);
            }
            
            @Override
            public void onItemRangeInserted(final int n, final int n2) {
                final q a = this.a;
                a.e += n2;
                a.d.b(a, n, n2);
                final q a2 = this.a;
                if (a2.e > 0 && a2.c.getStateRestorationPolicy() == Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                    final q a3 = this.a;
                    a3.d.d(a3);
                }
            }
            
            @Override
            public void onItemRangeMoved(final int n, final int n2, final int n3) {
                boolean b = true;
                if (n3 != 1) {
                    b = false;
                }
                androidx.core.util.h.b(b, "moving more than 1 item is not supported in RecyclerView");
                final q a = this.a;
                a.d.c(a, n, n2);
            }
            
            @Override
            public void onItemRangeRemoved(final int n, final int n2) {
                final q a = this.a;
                a.e -= n2;
                a.d.f(a, n, n2);
                final q a2 = this.a;
                if (a2.e < 1 && a2.c.getStateRestorationPolicy() == Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                    final q a3 = this.a;
                    a3.d.d(a3);
                }
            }
            
            @Override
            public void onStateRestorationPolicyChanged() {
                final q a = this.a;
                a.d.d(a);
            }
        };
        this.c = c;
        this.d = d;
        this.a = b0.b(this);
        this.b = b2;
        this.e = c.getItemCount();
        c.registerAdapterDataObserver(this.f);
    }
    
    int a() {
        return this.e;
    }
    
    public long b(final int n) {
        return this.b.a(this.c.getItemId(n));
    }
    
    int c(final int n) {
        return this.a.b(this.c.getItemViewType(n));
    }
    
    void d(final RecyclerView.c0 c0, final int n) {
        this.c.bindViewHolder(c0, n);
    }
    
    RecyclerView.c0 e(final ViewGroup viewGroup, int a) {
        a = this.a.a(a);
        return this.c.onCreateViewHolder(viewGroup, a);
    }
    
    interface b
    {
        void a(final q p0, final int p1, final int p2, final Object p3);
        
        void b(final q p0, final int p1, final int p2);
        
        void c(final q p0, final int p1, final int p2);
        
        void d(final q p0);
        
        void e(final q p0);
        
        void f(final q p0, final int p1, final int p2);
    }
}
