// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.concurrent.Executor;
import v0.h;

final class j0 implements c
{
    private final c a;
    private final RoomDatabase.e b;
    private final Executor c;
    
    j0(final c a, final RoomDatabase.e b, final Executor c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public h a(final b b) {
        return new i0(this.a.a(b), this.b, this.c);
    }
}
