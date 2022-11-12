// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.List;

public final class e0 implements Runnable
{
    public final h0 a;
    public final String b;
    public final List c;
    
    public e0(final h0 a, final String b, final List c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        h0.e(this.a, this.b, this.c);
    }
}
