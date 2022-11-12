// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;
import i.a;
import j.b;

public abstract class LiveData<T>
{
    static final Object NOT_SET;
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private j.b<a0<? super T>, c> mObservers;
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;
    
    static {
        NOT_SET = new Object();
    }
    
    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new j.b<a0<? super T>, c>();
        this.mActiveCount = 0;
        final Object not_SET = LiveData.NOT_SET;
        this.mPendingData = not_SET;
        this.mPostValueRunnable = new Runnable() {
            final LiveData a;
            
            @Override
            public void run() {
                synchronized (this.a.mDataLock) {
                    final Object mPendingData = this.a.mPendingData;
                    this.a.mPendingData = LiveData.NOT_SET;
                    monitorexit(this.a.mDataLock);
                    this.a.setValue(mPendingData);
                }
            }
        };
        this.mData = not_SET;
        this.mVersion = -1;
    }
    
    public LiveData(final T mData) {
        this.mDataLock = new Object();
        this.mObservers = new j.b<a0<? super T>, c>();
        this.mActiveCount = 0;
        this.mPendingData = LiveData.NOT_SET;
        this.mPostValueRunnable = new Runnable() {
            final LiveData a;
            
            @Override
            public void run() {
                synchronized (this.a.mDataLock) {
                    final Object mPendingData = this.a.mPendingData;
                    this.a.mPendingData = LiveData.NOT_SET;
                    monitorexit(this.a.mDataLock);
                    this.a.setValue(mPendingData);
                }
            }
        };
        this.mData = mData;
        this.mVersion = 0;
    }
    
    static void assertMainThread(final String s) {
        if (a.f().c()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot invoke ");
        sb.append(s);
        sb.append(" on a background thread");
        throw new IllegalStateException(sb.toString());
    }
    
    private void considerNotify(final c c) {
        if (!c.b) {
            return;
        }
        if (!c.k()) {
            c.g(false);
            return;
        }
        final int c2 = c.c;
        final int mVersion = this.mVersion;
        if (c2 >= mVersion) {
            return;
        }
        c.c = mVersion;
        c.a.onChanged((Object)this.mData);
    }
    
    void changeActiveCounter(int n) {
        int mActiveCount = this.mActiveCount;
        this.mActiveCount = n + mActiveCount;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        try {
            while (true) {
                final int mActiveCount2 = this.mActiveCount;
                if (mActiveCount == mActiveCount2) {
                    break;
                }
                if (mActiveCount == 0 && mActiveCount2 > 0) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                final boolean b = mActiveCount > 0 && mActiveCount2 == 0;
                if (n != 0) {
                    this.onActive();
                }
                else if (b) {
                    this.onInactive();
                }
                mActiveCount = mActiveCount2;
            }
        }
        finally {
            this.mChangingActiveState = false;
        }
    }
    
    void dispatchingValue(c c) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            c c2 = null;
            Label_0086: {
                if (c != null) {
                    this.considerNotify(c);
                    c2 = null;
                }
                else {
                    final j.b.d e = this.mObservers.e();
                    do {
                        c2 = c;
                        if (!e.hasNext()) {
                            break Label_0086;
                        }
                        this.considerNotify(((Iterator<Map.Entry<K, c>>)e).next().getValue());
                    } while (!this.mDispatchInvalidated);
                    c2 = c;
                }
            }
            c = c2;
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }
    
    public T getValue() {
        final Object mData = this.mData;
        if (mData != LiveData.NOT_SET) {
            return (T)mData;
        }
        return null;
    }
    
    int getVersion() {
        return this.mVersion;
    }
    
    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }
    
    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }
    
    public void observe(final r r, final a0<? super T> a0) {
        assertMainThread("observe");
        if (r.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        final LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(r, a0);
        final c c = this.mObservers.k(a0, (c)lifecycleBoundObserver);
        if (c != null && !c.j(r)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (c != null) {
            return;
        }
        r.getLifecycle().a(lifecycleBoundObserver);
    }
    
    public void observeForever(final a0<? super T> a0) {
        assertMainThread("observeForever");
        final b b = new b(a0);
        final c c = this.mObservers.k(a0, (c)b);
        if (c instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (c != null) {
            return;
        }
        ((c)b).g(true);
    }
    
    protected void onActive() {
    }
    
    protected void onInactive() {
    }
    
    protected void postValue(final T mPendingData) {
        synchronized (this.mDataLock) {
            final boolean b = this.mPendingData == LiveData.NOT_SET;
            this.mPendingData = mPendingData;
            monitorexit(this.mDataLock);
            if (!b) {
                return;
            }
            a.f().d(this.mPostValueRunnable);
        }
    }
    
    public void removeObserver(final a0<? super T> a0) {
        assertMainThread("removeObserver");
        final c c = this.mObservers.m(a0);
        if (c == null) {
            return;
        }
        c.h();
        c.g(false);
    }
    
    public void removeObservers(final r r) {
        assertMainThread("removeObservers");
        for (final Map.Entry<K, c> entry : this.mObservers) {
            if (entry.getValue().j(r)) {
                this.removeObserver((a0<? super T>)entry.getKey());
            }
        }
    }
    
    protected void setValue(final T mData) {
        assertMainThread("setValue");
        ++this.mVersion;
        this.mData = mData;
        this.dispatchingValue(null);
    }
    
    class LifecycleBoundObserver extends c implements o
    {
        final r e;
        final LiveData f;
        
        LifecycleBoundObserver(final LiveData f, final r e, final a0<? super T> a0) {
            super(a0);
            this.e = e;
        }
        
        @Override
        public void f(final r r, final Lifecycle.Event event) {
            Enum<Lifecycle.State> b = this.e.getLifecycle().b();
            if (b == Lifecycle.State.DESTROYED) {
                this.f.removeObserver(super.a);
                return;
            }
            Lifecycle.State b2;
            for (Enum<Lifecycle.State> enum1 = null; enum1 != b; enum1 = b, b = b2) {
                ((c)this).g(this.k());
                b2 = this.e.getLifecycle().b();
            }
        }
        
        @Override
        void h() {
            this.e.getLifecycle().c(this);
        }
        
        @Override
        boolean j(final r r) {
            return this.e == r;
        }
        
        @Override
        boolean k() {
            return this.e.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }
    }
    
    private abstract class c
    {
        final a0<? super T> a;
        boolean b;
        int c;
        final LiveData d;
        
        c(final LiveData d, final a0<? super T> a) {
            this.d = d;
            this.c = -1;
            this.a = a;
        }
        
        void g(final boolean b) {
            if (b == this.b) {
                return;
            }
            this.b = b;
            final LiveData d = this.d;
            int n;
            if (b) {
                n = 1;
            }
            else {
                n = -1;
            }
            d.changeActiveCounter(n);
            if (this.b) {
                this.d.dispatchingValue(this);
            }
        }
        
        void h() {
        }
        
        boolean j(final r r) {
            return false;
        }
        
        abstract boolean k();
    }
    
    private class b extends c
    {
        final LiveData e;
        
        b(final LiveData e, final a0<? super T> a0) {
            super(a0);
        }
        
        @Override
        boolean k() {
            return true;
        }
    }
}
