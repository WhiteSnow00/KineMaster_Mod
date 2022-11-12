// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.Iterator;
import v0.k;

public abstract class q<T> extends x0
{
    public q(final RoomDatabase roomDatabase) {
        super(roomDatabase);
    }
    
    protected abstract void bind(final k p0, final T p1);
    
    @Override
    protected abstract String createQuery();
    
    public final int handle(final T t) {
        final k acquire = this.acquire();
        try {
            this.bind(acquire, t);
            return acquire.C();
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final int handleMultiple(final Iterable<? extends T> iterable) {
        final k acquire = this.acquire();
        int n = 0;
        try {
            final Iterator<? extends T> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                this.bind(acquire, iterator.next());
                n += acquire.C();
            }
            return n;
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final int handleMultiple(final T[] array) {
        final k acquire = this.acquire();
        try {
            final int length = array.length;
            int i = 0;
            int n = 0;
            while (i < length) {
                this.bind(acquire, array[i]);
                n += acquire.C();
                ++i;
            }
            return n;
        }
        finally {
            this.release(acquire);
        }
    }
}
