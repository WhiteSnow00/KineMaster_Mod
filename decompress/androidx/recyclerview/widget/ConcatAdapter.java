// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ConcatAdapter extends Adapter<c0>
{
    private final g a;
    
    public ConcatAdapter(final Config config, final List<? extends Adapter<? extends c0>> list) {
        this.a = new g(this, config);
        final Iterator<? extends Adapter<? extends c0>> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.l((Adapter<? extends c0>)iterator.next());
        }
        super.setHasStableIds(this.a.s());
    }
    
    @SafeVarargs
    public ConcatAdapter(final Config config, final Adapter<? extends c0>... array) {
        this(config, Arrays.asList(array));
    }
    
    @SafeVarargs
    public ConcatAdapter(final Adapter<? extends c0>... array) {
        this(Config.c, array);
    }
    
    @Override
    public int findRelativeAdapterPositionIn(final Adapter<? extends c0> adapter, final c0 c0, final int n) {
        return this.a.p(adapter, c0, n);
    }
    
    @Override
    public int getItemCount() {
        return this.a.q();
    }
    
    @Override
    public long getItemId(final int n) {
        return this.a.n(n);
    }
    
    @Override
    public int getItemViewType(final int n) {
        return this.a.o(n);
    }
    
    public boolean l(final Adapter<? extends c0> adapter) {
        return this.a.h((Adapter<c0>)adapter);
    }
    
    void m(final StateRestorationPolicy stateRestorationPolicy) {
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }
    
    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        this.a.v(recyclerView);
    }
    
    @Override
    public void onBindViewHolder(final c0 c0, final int n) {
        this.a.w(c0, n);
    }
    
    @Override
    public c0 onCreateViewHolder(final ViewGroup viewGroup, final int n) {
        return this.a.x(viewGroup, n);
    }
    
    @Override
    public void onDetachedFromRecyclerView(final RecyclerView recyclerView) {
        this.a.y(recyclerView);
    }
    
    @Override
    public boolean onFailedToRecycleView(final c0 c0) {
        return this.a.z(c0);
    }
    
    @Override
    public void onViewAttachedToWindow(final c0 c0) {
        this.a.A(c0);
    }
    
    @Override
    public void onViewDetachedFromWindow(final c0 c0) {
        this.a.B(c0);
    }
    
    @Override
    public void onViewRecycled(final c0 c0) {
        this.a.C(c0);
    }
    
    @Override
    public void setHasStableIds(final boolean b) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }
    
    @Override
    public void setStateRestorationPolicy(final StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }
    
    public static final class Config
    {
        public static final Config c;
        public final boolean a;
        public final StableIdMode b;
        
        static {
            c = new Config(true, StableIdMode.NO_STABLE_IDS);
        }
        
        Config(final boolean a, final StableIdMode b) {
            this.a = a;
            this.b = b;
        }
        
        public enum StableIdMode
        {
            private static final StableIdMode[] $VALUES;
            
            ISOLATED_STABLE_IDS, 
            NO_STABLE_IDS, 
            SHARED_STABLE_IDS;
        }
    }
}
