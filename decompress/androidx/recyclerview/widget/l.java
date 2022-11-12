// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

final class l implements Runnable
{
    static final ThreadLocal<l> e;
    static Comparator<c> f;
    ArrayList<RecyclerView> a;
    long b;
    long c;
    private ArrayList<c> d;
    
    static {
        e = new ThreadLocal<l>();
        l.f = new Comparator<c>() {
            public int a(final c c, final c c2) {
                final RecyclerView d = c.d;
                final int n = 1;
                final int n2 = 1;
                if (d == null != (c2.d == null)) {
                    int n3;
                    if (d == null) {
                        n3 = n2;
                    }
                    else {
                        n3 = -1;
                    }
                    return n3;
                }
                final boolean a = c.a;
                if (a != c2.a) {
                    int n4 = n;
                    if (a) {
                        n4 = -1;
                    }
                    return n4;
                }
                final int n5 = c2.b - c.b;
                if (n5 != 0) {
                    return n5;
                }
                final int n6 = c.c - c2.c;
                if (n6 != 0) {
                    return n6;
                }
                return 0;
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((c)o, (c)o2);
            }
        };
    }
    
    l() {
        this.a = new ArrayList<RecyclerView>();
        this.d = new ArrayList<c>();
    }
    
    private void b() {
        final int size = this.a.size();
        int i = 0;
        int n = 0;
        while (i < size) {
            final RecyclerView recyclerView = this.a.get(i);
            int n2 = n;
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                n2 = n + recyclerView.mPrefetchRegistry.d;
            }
            ++i;
            n = n2;
        }
        this.d.ensureCapacity(n);
        int j = 0;
        int n3 = 0;
        while (j < size) {
            final RecyclerView d = this.a.get(j);
            int n4;
            if (d.getWindowVisibility() != 0) {
                n4 = n3;
            }
            else {
                final b mPrefetchRegistry = d.mPrefetchRegistry;
                final int b = Math.abs(mPrefetchRegistry.a) + Math.abs(mPrefetchRegistry.b);
                int n5 = 0;
                while (true) {
                    n4 = n3;
                    if (n5 >= mPrefetchRegistry.d * 2) {
                        break;
                    }
                    c c;
                    if (n3 >= this.d.size()) {
                        c = new c();
                        this.d.add(c);
                    }
                    else {
                        c = this.d.get(n3);
                    }
                    final int[] c2 = mPrefetchRegistry.c;
                    final int c3 = c2[n5 + 1];
                    c.a = (c3 <= b);
                    c.b = b;
                    c.c = c3;
                    c.d = d;
                    c.e = c2[n5];
                    ++n3;
                    n5 += 2;
                }
            }
            ++j;
            n3 = n4;
        }
        Collections.sort(this.d, l.f);
    }
    
    private void c(final c c, final long n) {
        long n2;
        if (c.a) {
            n2 = Long.MAX_VALUE;
        }
        else {
            n2 = n;
        }
        final RecyclerView.c0 i = this.i(c.d, c.e, n2);
        if (i != null && i.mNestedRecyclerView != null && i.isBound() && !i.isInvalid()) {
            this.h((RecyclerView)i.mNestedRecyclerView.get(), n);
        }
    }
    
    private void d(final long n) {
        for (int i = 0; i < this.d.size(); ++i) {
            final c c = this.d.get(i);
            if (c.d == null) {
                break;
            }
            this.c(c, n);
            c.a();
        }
    }
    
    static boolean e(final RecyclerView recyclerView, final int n) {
        for (int j = recyclerView.mChildHelper.j(), i = 0; i < j; ++i) {
            final RecyclerView.c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i));
            if (childViewHolderInt.mPosition == n && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }
    
    private void h(final RecyclerView recyclerView, final long n) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        final b mPrefetchRegistry = recyclerView.mPrefetchRegistry;
        mPrefetchRegistry.c(recyclerView, true);
        if (mPrefetchRegistry.d != 0) {
            try {
                androidx.core.os.l.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i = 0; i < mPrefetchRegistry.d * 2; i += 2) {
                    this.i(recyclerView, mPrefetchRegistry.c[i], n);
                }
            }
            finally {
                androidx.core.os.l.b();
            }
        }
    }
    
    private RecyclerView.c0 i(final RecyclerView recyclerView, final int n, final long n2) {
        if (e(recyclerView, n)) {
            return null;
        }
        final RecyclerView.v mRecycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            final RecyclerView.c0 i = mRecycler.I(n, false, n2);
            if (i != null) {
                if (i.isBound() && !i.isInvalid()) {
                    mRecycler.B(i.itemView);
                }
                else {
                    mRecycler.a(i, false);
                }
            }
            return i;
        }
        finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }
    
    public void a(final RecyclerView recyclerView) {
        this.a.add(recyclerView);
    }
    
    void f(final RecyclerView recyclerView, final int n, final int n2) {
        if (recyclerView.isAttachedToWindow() && this.b == 0L) {
            this.b = recyclerView.getNanoTime();
            recyclerView.post((Runnable)this);
        }
        recyclerView.mPrefetchRegistry.e(n, n2);
    }
    
    void g(final long n) {
        this.b();
        this.d(n);
    }
    
    public void j(final RecyclerView recyclerView) {
        this.a.remove(recyclerView);
    }
    
    @Override
    public void run() {
        try {
            androidx.core.os.l.a("RV Prefetch");
            if (!this.a.isEmpty()) {
                final int size = this.a.size();
                int i = 0;
                long n = 0L;
                while (i < size) {
                    final RecyclerView recyclerView = this.a.get(i);
                    long max = n;
                    if (recyclerView.getWindowVisibility() == 0) {
                        max = Math.max(recyclerView.getDrawingTime(), n);
                    }
                    ++i;
                    n = max;
                }
                if (n != 0L) {
                    this.g(TimeUnit.MILLISECONDS.toNanos(n) + this.c);
                }
            }
        }
        finally {
            this.b = 0L;
            androidx.core.os.l.b();
        }
    }
    
    static class b implements o.c
    {
        int a;
        int b;
        int[] c;
        int d;
        
        @Override
        public void a(final int n, final int n2) {
            if (n < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (n2 >= 0) {
                final int n3 = this.d * 2;
                final int[] c = this.c;
                if (c == null) {
                    Arrays.fill(this.c = new int[4], -1);
                }
                else if (n3 >= c.length) {
                    System.arraycopy(c, 0, this.c = new int[n3 * 2], 0, c.length);
                }
                final int[] c2 = this.c;
                c2[n3] = n;
                c2[n3 + 1] = n2;
                ++this.d;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        
        void b() {
            final int[] c = this.c;
            if (c != null) {
                Arrays.fill(c, -1);
            }
            this.d = 0;
        }
        
        void c(final RecyclerView recyclerView, final boolean mPrefetchMaxObservedInInitialPrefetch) {
            this.d = 0;
            final int[] c = this.c;
            if (c != null) {
                Arrays.fill(c, -1);
            }
            final RecyclerView.o mLayout = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && mLayout != null && mLayout.isItemPrefetchEnabled()) {
                if (mPrefetchMaxObservedInInitialPrefetch) {
                    if (!recyclerView.mAdapterHelper.p()) {
                        mLayout.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), (RecyclerView.o.c)this);
                    }
                }
                else if (!recyclerView.hasPendingAdapterUpdates()) {
                    mLayout.collectAdjacentPrefetchPositions(this.a, this.b, recyclerView.mState, (RecyclerView.o.c)this);
                }
                final int d = this.d;
                if (d > mLayout.mPrefetchMaxCountObserved) {
                    mLayout.mPrefetchMaxCountObserved = d;
                    mLayout.mPrefetchMaxObservedInInitialPrefetch = mPrefetchMaxObservedInInitialPrefetch;
                    recyclerView.mRecycler.K();
                }
            }
        }
        
        boolean d(final int n) {
            if (this.c != null) {
                for (int d = this.d, i = 0; i < d * 2; i += 2) {
                    if (this.c[i] == n) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        void e(final int a, final int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    static class c
    {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;
        
        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }
}
