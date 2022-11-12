// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import v0.k;

public abstract class r<T> extends x0
{
    public r(final RoomDatabase roomDatabase) {
        super(roomDatabase);
    }
    
    protected abstract void bind(final k p0, final T p1);
    
    public final void insert(final Iterable<? extends T> iterable) {
        final k acquire = this.acquire();
        try {
            final Iterator<? extends T> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                this.bind(acquire, iterator.next());
                acquire.A0();
            }
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final void insert(final T t) {
        final k acquire = this.acquire();
        try {
            this.bind(acquire, t);
            acquire.A0();
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final void insert(final T[] array) {
        final k acquire = this.acquire();
        try {
            for (int length = array.length, i = 0; i < length; ++i) {
                this.bind(acquire, array[i]);
                acquire.A0();
            }
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final long insertAndReturnId(final T t) {
        final k acquire = this.acquire();
        try {
            this.bind(acquire, t);
            return acquire.A0();
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final long[] insertAndReturnIdsArray(final Collection<? extends T> collection) {
        final k acquire = this.acquire();
        try {
            final long[] array = new long[collection.size()];
            int n = 0;
            final Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                this.bind(acquire, iterator.next());
                array[n] = acquire.A0();
                ++n;
            }
            return array;
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final long[] insertAndReturnIdsArray(final T[] array) {
        final k acquire = this.acquire();
        try {
            final long[] array2 = new long[array.length];
            final int length = array.length;
            int i = 0;
            int n = 0;
            while (i < length) {
                this.bind(acquire, array[i]);
                array2[n] = acquire.A0();
                ++n;
                ++i;
            }
            return array2;
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final Long[] insertAndReturnIdsArrayBox(final Collection<? extends T> collection) {
        final k acquire = this.acquire();
        try {
            final Long[] array = new Long[collection.size()];
            int n = 0;
            final Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                this.bind(acquire, iterator.next());
                array[n] = acquire.A0();
                ++n;
            }
            return array;
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final Long[] insertAndReturnIdsArrayBox(final T[] array) {
        final k acquire = this.acquire();
        try {
            final Long[] array2 = new Long[array.length];
            final int length = array.length;
            int i = 0;
            int n = 0;
            while (i < length) {
                this.bind(acquire, array[i]);
                array2[n] = acquire.A0();
                ++n;
                ++i;
            }
            return array2;
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final List<Long> insertAndReturnIdsList(final Collection<? extends T> collection) {
        final k acquire = this.acquire();
        try {
            final ArrayList list = new ArrayList(collection.size());
            int n = 0;
            final Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                this.bind(acquire, iterator.next());
                list.add(n, acquire.A0());
                ++n;
            }
            return list;
        }
        finally {
            this.release(acquire);
        }
    }
    
    public final List<Long> insertAndReturnIdsList(final T[] array) {
        final k acquire = this.acquire();
        try {
            final ArrayList list = new ArrayList(array.length);
            final int length = array.length;
            int i = 0;
            int n = 0;
            while (i < length) {
                this.bind(acquire, array[i]);
                list.add(n, acquire.A0());
                ++n;
                ++i;
            }
            return list;
        }
        finally {
            this.release(acquire);
        }
    }
}
