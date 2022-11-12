// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.List;

public abstract class o<T, VH extends c0> extends Adapter<VH>
{
    final d<T> mDiffer;
    private final d.b<T> mListener;
    
    protected o(final c<T> c) {
        final d.b<T> mListener = new d.b<T>() {
            final o a;
            
            @Override
            public void a(final List<T> list, final List<T> list2) {
                this.a.onCurrentListChanged(list, list2);
            }
        };
        this.mListener = mListener;
        (this.mDiffer = new d<T>(new b(this), c)).a((d.b<T>)mListener);
    }
    
    protected o(final androidx.recyclerview.widget.i.f<T> f) {
        final d.b<T> mListener = new d.b<T>() {
            final o a;
            
            @Override
            public void a(final List<T> list, final List<T> list2) {
                this.a.onCurrentListChanged(list, list2);
            }
        };
        this.mListener = mListener;
        (this.mDiffer = new d<T>(new b(this), new c.a<T>(f).a())).a((d.b<T>)mListener);
    }
    
    public List<T> getCurrentList() {
        return this.mDiffer.b();
    }
    
    protected T getItem(final int n) {
        return this.mDiffer.b().get(n);
    }
    
    @Override
    public int getItemCount() {
        return this.mDiffer.b().size();
    }
    
    public void onCurrentListChanged(final List<T> list, final List<T> list2) {
    }
    
    public void submitList(final List<T> list) {
        this.mDiffer.e(list);
    }
    
    public void submitList(final List<T> list, final Runnable runnable) {
        this.mDiffer.f(list, runnable);
    }
}
