// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import android.view.ViewGroup;
import kotlin.jvm.internal.o;
import kotlin.Metadata;
import androidx.recyclerview.widget.RecyclerView;

@Metadata(bv = {}, d1 = { "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u001f\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\b\u0010\u0013J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\r\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f" }, d2 = { "Landroidx/paging/m;", "Landroidx/recyclerview/widget/RecyclerView$c0;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$c0;", "holder", "position", "Lka/r;", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$c0;I)V", "getItemViewType", "getItemCount", "Landroidx/paging/l;", "loadState", "(Landroid/view/ViewGroup;Landroidx/paging/l;)Landroidx/recyclerview/widget/RecyclerView$c0;", "(Landroidx/recyclerview/widget/RecyclerView$c0;Landroidx/paging/l;)V", "getStateViewType", "", "displayLoadStateAsItem", "Landroidx/paging/l;", "getLoadState", "()Landroidx/paging/l;", "setLoadState", "(Landroidx/paging/l;)V", "<init>", "()V", "paging-runtime_release" }, k = 1, mv = { 1, 5, 1 })
public abstract class m<VH extends c0> extends Adapter<VH>
{
    private androidx.paging.l loadState;
    
    public m() {
        this.loadState = new androidx.paging.l.c(false);
    }
    
    public boolean displayLoadStateAsItem(final androidx.paging.l l) {
        kotlin.jvm.internal.o.g((Object)l, "loadState");
        return l instanceof androidx.paging.l.b || l instanceof androidx.paging.l.a;
    }
    
    @Override
    public final int getItemCount() {
        return this.displayLoadStateAsItem(this.loadState) ? 1 : 0;
    }
    
    @Override
    public final int getItemViewType(final int n) {
        return this.getStateViewType(this.loadState);
    }
    
    public final androidx.paging.l getLoadState() {
        return this.loadState;
    }
    
    public int getStateViewType(final androidx.paging.l l) {
        kotlin.jvm.internal.o.g((Object)l, "loadState");
        return 0;
    }
    
    @Override
    public final void onBindViewHolder(final VH vh, final int n) {
        kotlin.jvm.internal.o.g((Object)vh, "holder");
        this.onBindViewHolder(vh, this.loadState);
    }
    
    public abstract void onBindViewHolder(final VH p0, final androidx.paging.l p1);
    
    @Override
    public final VH onCreateViewHolder(final ViewGroup viewGroup, final int n) {
        kotlin.jvm.internal.o.g((Object)viewGroup, "parent");
        return this.onCreateViewHolder(viewGroup, this.loadState);
    }
    
    public abstract VH onCreateViewHolder(final ViewGroup p0, final androidx.paging.l p1);
    
    public final void setLoadState(final androidx.paging.l loadState) {
        kotlin.jvm.internal.o.g((Object)loadState, "loadState");
        if (!kotlin.jvm.internal.o.b((Object)this.loadState, (Object)loadState)) {
            final boolean displayLoadStateAsItem = this.displayLoadStateAsItem(this.loadState);
            final boolean displayLoadStateAsItem2 = this.displayLoadStateAsItem(loadState);
            if (displayLoadStateAsItem && !displayLoadStateAsItem2) {
                this.notifyItemRemoved(0);
            }
            else if (displayLoadStateAsItem2 && !displayLoadStateAsItem) {
                this.notifyItemInserted(0);
            }
            else if (displayLoadStateAsItem && displayLoadStateAsItem2) {
                this.notifyItemChanged(0);
            }
            this.loadState = loadState;
        }
    }
}
