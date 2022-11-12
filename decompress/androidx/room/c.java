// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.g;
import k.a;

public final class c implements a
{
    public final String a;
    public final Object[] b;
    
    public c(final String a, final Object[] b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object apply(final Object o) {
        return i.a.a(this.a, this.b, (g)o);
    }
}
