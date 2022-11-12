// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.concurrent.Callable;
import java.util.Map;
import java.util.Collections;
import java.util.IdentityHashMap;
import androidx.lifecycle.LiveData;
import java.util.Set;

class u
{
    final Set<LiveData> a;
    private final RoomDatabase b;
    
    u(final RoomDatabase b) {
        this.a = (Set<LiveData>)Collections.newSetFromMap(new IdentityHashMap<LiveData, Boolean>());
        this.b = b;
    }
    
     <T> LiveData<T> a(final String[] array, final boolean b, final Callable<T> callable) {
        return new u0<T>(this.b, this, b, callable, array);
    }
    
    void b(final LiveData liveData) {
        this.a.add(liveData);
    }
    
    void c(final LiveData liveData) {
        this.a.remove(liveData);
    }
}
