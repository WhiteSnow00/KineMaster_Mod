// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

public final class b implements p
{
    private final RecyclerView.Adapter a;
    
    public b(final RecyclerView.Adapter a) {
        this.a = a;
    }
    
    @Override
    public void a(final int n, final int n2) {
        this.a.notifyItemRangeInserted(n, n2);
    }
    
    @Override
    public void b(final int n, final int n2) {
        this.a.notifyItemRangeRemoved(n, n2);
    }
    
    @Override
    public void c(final int n, final int n2, final Object o) {
        this.a.notifyItemRangeChanged(n, n2, o);
    }
    
    @Override
    public void d(final int n, final int n2) {
        this.a.notifyItemMoved(n, n2);
    }
}
