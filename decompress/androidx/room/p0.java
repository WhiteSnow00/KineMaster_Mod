// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.g;
import k.a;

public final class p0 implements a
{
    public final RoomDatabase a;
    
    public p0(final RoomDatabase a) {
        this.a = a;
    }
    
    @Override
    public final Object apply(final Object o) {
        return RoomDatabase.a(this.a, (g)o);
    }
}
