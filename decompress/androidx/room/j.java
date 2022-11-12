// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.g;
import k.a;

public final class j implements a
{
    public final i.b a;
    public final a b;
    
    public j(final i.b a, final a b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object apply(final Object o) {
        return i.b.a(this.a, this.b, (g)o);
    }
}
