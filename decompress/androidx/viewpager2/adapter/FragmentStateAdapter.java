// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager2.adapter;

import androidx.viewpager2.widget.ViewPager2;
import android.os.Parcelable;
import androidx.fragment.app.c0;
import android.view.View$OnLayoutChangeListener;
import androidx.core.view.b0;
import java.util.Iterator;
import android.view.ViewGroup;
import android.os.Bundle;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.o;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.view.View;
import androidx.fragment.app.h;
import androidx.lifecycle.Lifecycle;
import androidx.fragment.app.Fragment;
import androidx.collection.d;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FragmentStateAdapter extends Adapter<a> implements b
{
    private static final long GRACE_WINDOW_TIME_MS = 10000L;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final androidx.collection.d<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final androidx.collection.d<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final androidx.collection.d<Fragment.SavedState> mSavedStates;
    
    public FragmentStateAdapter(final Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }
    
    public FragmentStateAdapter(final FragmentManager mFragmentManager, final Lifecycle mLifecycle) {
        this.mFragments = new androidx.collection.d<Fragment>();
        this.mSavedStates = new androidx.collection.d<Fragment.SavedState>();
        this.mItemIdToViewHolder = new androidx.collection.d<Integer>();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = mFragmentManager;
        this.mLifecycle = mLifecycle;
        super.setHasStableIds(true);
    }
    
    public FragmentStateAdapter(final androidx.fragment.app.h h) {
        this(h.getSupportFragmentManager(), h.getLifecycle());
    }
    
    private static String createKey(final String s, final long n) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(n);
        return sb.toString();
    }
    
    private void ensureFragment(final int n) {
        final long itemId = this.getItemId(n);
        if (!this.mFragments.d(itemId)) {
            final Fragment fragment = this.createFragment(n);
            fragment.setInitialSavedState(this.mSavedStates.f(itemId));
            this.mFragments.l(itemId, fragment);
        }
    }
    
    private boolean isFragmentViewBound(final long n) {
        final boolean d = this.mItemIdToViewHolder.d(n);
        boolean b = true;
        if (d) {
            return true;
        }
        final Fragment fragment = this.mFragments.f(n);
        if (fragment == null) {
            return false;
        }
        final View view = fragment.getView();
        if (view == null) {
            return false;
        }
        if (view.getParent() == null) {
            b = false;
        }
        return b;
    }
    
    private static boolean isValidKey(final String s, final String s2) {
        return s.startsWith(s2) && s.length() > s2.length();
    }
    
    private Long itemForViewHolder(final int n) {
        Long n2 = null;
        Long value;
        for (int i = 0; i < this.mItemIdToViewHolder.o(); ++i, n2 = value) {
            value = n2;
            if (this.mItemIdToViewHolder.p(i) == n) {
                if (n2 != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                value = this.mItemIdToViewHolder.j(i);
            }
        }
        return n2;
    }
    
    private static long parseIdFromKey(final String s, final String s2) {
        return Long.parseLong(s.substring(s2.length()));
    }
    
    private void removeFragment(final long n) {
        final Fragment fragment = this.mFragments.f(n);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null) {
            final ViewParent parent = fragment.getView().getParent();
            if (parent != null) {
                ((FrameLayout)parent).removeAllViews();
            }
        }
        if (!this.containsItem(n)) {
            this.mSavedStates.m(n);
        }
        if (!fragment.isAdded()) {
            this.mFragments.m(n);
            return;
        }
        if (this.shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (fragment.isAdded() && this.containsItem(n)) {
            this.mSavedStates.l(n, this.mFragmentManager.D1(fragment));
        }
        this.mFragmentManager.q().p(fragment).k();
        this.mFragments.m(n);
    }
    
    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable(this) {
            final FragmentStateAdapter a;
            
            @Override
            public void run() {
                final FragmentStateAdapter a = this.a;
                a.mIsInGracePeriod = false;
                a.gcFragments();
            }
        };
        this.mLifecycle.a(new androidx.lifecycle.o(this, handler, runnable) {
            final Handler a;
            final Runnable b;
            final FragmentStateAdapter c;
            
            @Override
            public void f(final androidx.lifecycle.r r, final Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    this.a.removeCallbacks(this.b);
                    r.getLifecycle().c(this);
                }
            }
        });
        handler.postDelayed((Runnable)runnable, 10000L);
    }
    
    private void scheduleViewAttach(final Fragment fragment, final FrameLayout frameLayout) {
        this.mFragmentManager.p1((FragmentManager.l)new FragmentManager.l(this, fragment, frameLayout) {
            final Fragment a;
            final FrameLayout b;
            final FragmentStateAdapter c;
            
            @Override
            public void m(final FragmentManager fragmentManager, final Fragment fragment, final View view, final Bundle bundle) {
                if (fragment == this.a) {
                    fragmentManager.O1((FragmentManager.l)this);
                    this.c.addViewToContainer(view, this.b);
                }
            }
        }, false);
    }
    
    void addViewToContainer(final View view, final FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup)view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }
    
    public boolean containsItem(final long n) {
        return n >= 0L && n < ((RecyclerView.Adapter)this).getItemCount();
    }
    
    public abstract Fragment createFragment(final int p0);
    
    void gcFragments() {
        if (this.mHasStaleFragments) {
            if (!this.shouldDelayFragmentTransactions()) {
                final androidx.collection.b b = new androidx.collection.b();
                final int n = 0;
                for (int i = 0; i < this.mFragments.o(); ++i) {
                    final long j = this.mFragments.j(i);
                    if (!this.containsItem(j)) {
                        b.add(j);
                        this.mItemIdToViewHolder.m(j);
                    }
                }
                if (!this.mIsInGracePeriod) {
                    this.mHasStaleFragments = false;
                    for (int k = n; k < this.mFragments.o(); ++k) {
                        final long l = this.mFragments.j(k);
                        if (!this.isFragmentViewBound(l)) {
                            b.add(l);
                        }
                    }
                }
                final Iterator iterator = b.iterator();
                while (iterator.hasNext()) {
                    this.removeFragment((long)iterator.next());
                }
            }
        }
    }
    
    @Override
    public long getItemId(final int n) {
        return n;
    }
    
    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        androidx.core.util.h.a(this.mFragmentMaxLifecycleEnforcer == null);
        (this.mFragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer()).b(recyclerView);
    }
    
    @Override
    public /* bridge */ void onBindViewHolder(final c0 c0, final int n) {
        this.onBindViewHolder((a)c0, n);
    }
    
    public final void onBindViewHolder(final a a, final int n) {
        final long itemId = ((RecyclerView.c0)a).getItemId();
        final int id = a.b().getId();
        final Long itemForViewHolder = this.itemForViewHolder(id);
        if (itemForViewHolder != null && itemForViewHolder != itemId) {
            this.removeFragment(itemForViewHolder);
            this.mItemIdToViewHolder.m(itemForViewHolder);
        }
        this.mItemIdToViewHolder.l(itemId, id);
        this.ensureFragment(n);
        final FrameLayout b = a.b();
        if (androidx.core.view.b0.S((View)b)) {
            if (b.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            b.addOnLayoutChangeListener((View$OnLayoutChangeListener)new View$OnLayoutChangeListener(this, b, a) {
                final FrameLayout a;
                final a b;
                final FragmentStateAdapter c;
                
                public void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
                    if (this.a.getParent() != null) {
                        this.a.removeOnLayoutChangeListener((View$OnLayoutChangeListener)this);
                        this.c.placeFragmentInViewHolder(this.b);
                    }
                }
            });
        }
        this.gcFragments();
    }
    
    @Override
    public /* bridge */ c0 onCreateViewHolder(final ViewGroup viewGroup, final int n) {
        return this.onCreateViewHolder(viewGroup, n);
    }
    
    public final a onCreateViewHolder(final ViewGroup viewGroup, final int n) {
        return a.a(viewGroup);
    }
    
    @Override
    public void onDetachedFromRecyclerView(final RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.c(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }
    
    @Override
    public /* bridge */ boolean onFailedToRecycleView(final c0 c0) {
        return this.onFailedToRecycleView((a)c0);
    }
    
    public final boolean onFailedToRecycleView(final a a) {
        return true;
    }
    
    @Override
    public /* bridge */ void onViewAttachedToWindow(final c0 c0) {
        this.onViewAttachedToWindow((a)c0);
    }
    
    public final void onViewAttachedToWindow(final a a) {
        this.placeFragmentInViewHolder(a);
        this.gcFragments();
    }
    
    @Override
    public /* bridge */ void onViewRecycled(final c0 c0) {
        this.onViewRecycled((a)c0);
    }
    
    public final void onViewRecycled(final a a) {
        final Long itemForViewHolder = this.itemForViewHolder(a.b().getId());
        if (itemForViewHolder != null) {
            this.removeFragment(itemForViewHolder);
            this.mItemIdToViewHolder.m(itemForViewHolder);
        }
    }
    
    void placeFragmentInViewHolder(final a a) {
        final Fragment fragment = this.mFragments.f(((RecyclerView.c0)a).getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        final FrameLayout b = a.b();
        final View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            this.scheduleViewAttach(fragment, b);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != b) {
                this.addViewToContainer(view, b);
            }
            return;
        }
        if (fragment.isAdded()) {
            this.addViewToContainer(view, b);
            return;
        }
        if (!this.shouldDelayFragmentTransactions()) {
            this.scheduleViewAttach(fragment, b);
            final androidx.fragment.app.c0 q = this.mFragmentManager.q();
            final StringBuilder sb = new StringBuilder();
            sb.append("f");
            sb.append(((RecyclerView.c0)a).getItemId());
            q.e(fragment, sb.toString()).u(fragment, Lifecycle.State.STARTED).k();
            this.mFragmentMaxLifecycleEnforcer.d(false);
        }
        else {
            if (this.mFragmentManager.M0()) {
                return;
            }
            this.mLifecycle.a(new androidx.lifecycle.o(this, a) {
                final a a;
                final FragmentStateAdapter b;
                
                @Override
                public void f(final androidx.lifecycle.r r, final Lifecycle.Event event) {
                    if (this.b.shouldDelayFragmentTransactions()) {
                        return;
                    }
                    r.getLifecycle().c(this);
                    if (androidx.core.view.b0.S((View)this.a.b())) {
                        this.b.placeFragmentInViewHolder(this.a);
                    }
                }
            });
        }
    }
    
    @Override
    public final void restoreState(final Parcelable parcelable) {
        if (this.mSavedStates.i() && this.mFragments.i()) {
            final Bundle bundle = (Bundle)parcelable;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(this.getClass().getClassLoader());
            }
            for (final String s : bundle.keySet()) {
                if (isValidKey(s, "f#")) {
                    this.mFragments.l(parseIdFromKey(s, "f#"), this.mFragmentManager.v0(bundle, s));
                }
                else {
                    if (!isValidKey(s, "s#")) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected key in savedState: ");
                        sb.append(s);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    final long idFromKey = parseIdFromKey(s, "s#");
                    final Fragment.SavedState savedState = (Fragment.SavedState)bundle.getParcelable(s);
                    if (!this.containsItem(idFromKey)) {
                        continue;
                    }
                    this.mSavedStates.l(idFromKey, savedState);
                }
            }
            if (!this.mFragments.i()) {
                this.mHasStaleFragments = true;
                this.mIsInGracePeriod = true;
                this.gcFragments();
                this.scheduleGracePeriodEnd();
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }
    
    @Override
    public final Parcelable saveState() {
        final Bundle bundle = new Bundle(this.mFragments.o() + this.mSavedStates.o());
        final int n = 0;
        int n2 = 0;
        int i;
        while (true) {
            i = n;
            if (n2 >= this.mFragments.o()) {
                break;
            }
            final long j = this.mFragments.j(n2);
            final Fragment fragment = this.mFragments.f(j);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.o1(bundle, createKey("f#", j), fragment);
            }
            ++n2;
        }
        while (i < this.mSavedStates.o()) {
            final long k = this.mSavedStates.j(i);
            if (this.containsItem(k)) {
                bundle.putParcelable(createKey("s#", k), (Parcelable)this.mSavedStates.f(k));
            }
            ++i;
        }
        return (Parcelable)bundle;
    }
    
    @Override
    public final void setHasStableIds(final boolean b) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }
    
    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.T0();
    }
    
    class FragmentMaxLifecycleEnforcer
    {
        private ViewPager2.i a;
        private i b;
        private androidx.lifecycle.o c;
        private ViewPager2 d;
        private long e;
        final FragmentStateAdapter f;
        
        FragmentMaxLifecycleEnforcer(final FragmentStateAdapter f) {
            this.f = f;
            this.e = -1L;
        }
        
        private ViewPager2 a(final RecyclerView recyclerView) {
            final ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2)parent;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected ViewPager2 instance. Got: ");
            sb.append(parent);
            throw new IllegalStateException(sb.toString());
        }
        
        void b(final RecyclerView recyclerView) {
            this.d = this.a(recyclerView);
            final ViewPager2.i a = new ViewPager2.i(this) {
                final FragmentMaxLifecycleEnforcer a;
                
                @Override
                public void onPageScrollStateChanged(final int n) {
                    this.a.d(false);
                }
                
                @Override
                public void onPageSelected(final int n) {
                    this.a.d(false);
                }
            };
            this.a = a;
            this.d.g((ViewPager2.i)a);
            final d b = new d(this) {
                final FragmentMaxLifecycleEnforcer a;
                
                @Override
                public void onChanged() {
                    this.a.d(true);
                }
            };
            this.b = b;
            ((RecyclerView.Adapter)this.f).registerAdapterDataObserver(b);
            final androidx.lifecycle.o c = new androidx.lifecycle.o(this) {
                final FragmentMaxLifecycleEnforcer a;
                
                @Override
                public void f(final androidx.lifecycle.r r, final Lifecycle.Event event) {
                    this.a.d(false);
                }
            };
            this.c = c;
            this.f.mLifecycle.a(c);
        }
        
        void c(final RecyclerView recyclerView) {
            this.a(recyclerView).n(this.a);
            ((RecyclerView.Adapter)this.f).unregisterAdapterDataObserver(this.b);
            this.f.mLifecycle.c(this.c);
            this.d = null;
        }
        
        void d(final boolean b) {
            if (this.f.shouldDelayFragmentTransactions()) {
                return;
            }
            if (this.d.getScrollState() != 0) {
                return;
            }
            if (!this.f.mFragments.i()) {
                if (((RecyclerView.Adapter)this.f).getItemCount() != 0) {
                    final int currentItem = this.d.getCurrentItem();
                    if (currentItem >= ((RecyclerView.Adapter)this.f).getItemCount()) {
                        return;
                    }
                    final long itemId = this.f.getItemId(currentItem);
                    if (itemId == this.e && !b) {
                        return;
                    }
                    final Fragment fragment = this.f.mFragments.f(itemId);
                    if (fragment != null) {
                        if (fragment.isAdded()) {
                            this.e = itemId;
                            final androidx.fragment.app.c0 q = this.f.mFragmentManager.q();
                            Fragment fragment2 = null;
                            for (int i = 0; i < this.f.mFragments.o(); ++i) {
                                final long j = this.f.mFragments.j(i);
                                final Fragment fragment3 = this.f.mFragments.p(i);
                                if (fragment3.isAdded()) {
                                    if (j != this.e) {
                                        q.u(fragment3, Lifecycle.State.STARTED);
                                    }
                                    else {
                                        fragment2 = fragment3;
                                    }
                                    fragment3.setMenuVisibility(j == this.e);
                                }
                            }
                            if (fragment2 != null) {
                                q.u(fragment2, Lifecycle.State.RESUMED);
                            }
                            if (!q.o()) {
                                q.k();
                            }
                        }
                    }
                }
            }
        }
    }
    
    private abstract static class d extends i
    {
        private d() {
        }
        
        d(final FragmentStateAdapter$a view$OnLayoutChangeListener) {
            this();
        }
        
        @Override
        public abstract void onChanged();
        
        @Override
        public final void onItemRangeChanged(final int n, final int n2) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeChanged(final int n, final int n2, final Object o) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeInserted(final int n, final int n2) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeMoved(final int n, final int n2, final int n3) {
            this.onChanged();
        }
        
        @Override
        public final void onItemRangeRemoved(final int n, final int n2) {
            this.onChanged();
        }
    }
}
