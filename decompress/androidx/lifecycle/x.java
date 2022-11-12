// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import j.b;

public class x<T> extends z<T>
{
    private j.b<LiveData<?>, a<?>> mSources;
    
    public x() {
        this.mSources = new j.b<LiveData<?>, a<?>>();
    }
    
    public <S> void addSource(final LiveData<S> liveData, final a0<? super S> a0) {
        Objects.requireNonNull(liveData, "source cannot be null");
        final a a2 = new a((LiveData<V>)liveData, (a0<? super V>)a0);
        final a a3 = this.mSources.k(liveData, a2);
        if (a3 != null && a3.b != a0) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (a3 != null) {
            return;
        }
        if (this.hasActiveObservers()) {
            a2.a();
        }
    }
    
    @Override
    protected void onActive() {
        final Iterator<Map.Entry<LiveData<?>, a<?>>> iterator = this.mSources.iterator();
        while (iterator.hasNext()) {
            ((Map.Entry<K, a>)iterator.next()).getValue().a();
        }
    }
    
    @Override
    protected void onInactive() {
        final Iterator<Map.Entry<LiveData<?>, a<?>>> iterator = this.mSources.iterator();
        while (iterator.hasNext()) {
            ((Map.Entry<K, a>)iterator.next()).getValue().b();
        }
    }
    
    public <S> void removeSource(final LiveData<S> liveData) {
        final a a = this.mSources.m(liveData);
        if (a != null) {
            a.b();
        }
    }
    
    private static class a<V> implements a0<V>
    {
        final LiveData<V> a;
        final a0<? super V> b;
        int c;
        
        a(final LiveData<V> a, final a0<? super V> b) {
            this.c = -1;
            this.a = a;
            this.b = b;
        }
        
        void a() {
            this.a.observeForever(this);
        }
        
        void b() {
            this.a.removeObserver(this);
        }
        
        @Override
        public void onChanged(final V v) {
            if (this.c != this.a.getVersion()) {
                this.c = this.a.getVersion();
                this.b.onChanged(v);
            }
        }
    }
}
