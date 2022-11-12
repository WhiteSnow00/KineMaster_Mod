// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import v0.j;

public final class g0 implements Runnable
{
    public final h0 a;
    public final j b;
    public final k0 c;
    
    public g0(final h0 a, final j b, final k0 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        h0.k(this.a, this.b, this.c);
    }
}
