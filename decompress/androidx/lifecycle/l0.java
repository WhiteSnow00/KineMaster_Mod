// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.Iterator;
import java.io.IOException;
import java.util.Collection;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.io.Closeable;
import java.util.Set;
import java.util.Map;

public abstract class l0
{
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;
    private final Set<Closeable> mCloseables;
    
    public l0() {
        this.mBagOfTags = new HashMap<String, Object>();
        this.mCloseables = new LinkedHashSet<Closeable>();
        this.mCleared = false;
    }
    
    public l0(final Closeable... array) {
        this.mBagOfTags = new HashMap<String, Object>();
        final LinkedHashSet mCloseables = new LinkedHashSet();
        this.mCloseables = mCloseables;
        this.mCleared = false;
        mCloseables.addAll(Arrays.asList(array));
    }
    
    private static void closeWithRuntimeException(final Object o) {
        if (o instanceof Closeable) {
            try {
                ((Closeable)o).close();
            }
            catch (final IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    public void addCloseable(final Closeable closeable) {
        final Set<Closeable> mCloseables = this.mCloseables;
        if (mCloseables != null) {
            synchronized (mCloseables) {
                this.mCloseables.add(closeable);
            }
        }
    }
    
    final void clear() {
        this.mCleared = true;
        final Map<String, Object> mBagOfTags = this.mBagOfTags;
        if (mBagOfTags != null) {
            synchronized (mBagOfTags) {
                final Iterator<Object> iterator = this.mBagOfTags.values().iterator();
                while (iterator.hasNext()) {
                    closeWithRuntimeException(iterator.next());
                }
            }
        }
        final Set<Closeable> mCloseables = this.mCloseables;
        if (mCloseables != null) {
            synchronized (mCloseables) {
                final Iterator<Closeable> iterator2 = this.mCloseables.iterator();
                while (iterator2.hasNext()) {
                    closeWithRuntimeException(iterator2.next());
                }
            }
        }
        this.onCleared();
    }
    
     <T> T getTag(final String s) {
        final Map<String, Object> mBagOfTags = this.mBagOfTags;
        if (mBagOfTags == null) {
            return null;
        }
        synchronized (mBagOfTags) {
            return (T)this.mBagOfTags.get(s);
        }
    }
    
    protected void onCleared() {
    }
    
     <T> T setTagIfAbsent(final String s, T t) {
        synchronized (this.mBagOfTags) {
            final Object value = this.mBagOfTags.get(s);
            if (value == null) {
                this.mBagOfTags.put(s, t);
            }
            monitorexit(this.mBagOfTags);
            if (value != null) {
                t = (T)value;
            }
            if (this.mCleared) {
                closeWithRuntimeException(t);
            }
            return t;
        }
    }
}
