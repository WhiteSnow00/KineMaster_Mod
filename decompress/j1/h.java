// 
// Decompiled by Procyon v0.6.0
// 

package j1;

import m1.p;
import k1.d;
import k1.g;
import o1.a;
import android.content.Context;

public class h extends c<Boolean>
{
    public h(final Context context, final o1.a a) {
        super(g.c(context, a).e());
    }
    
    @Override
    boolean b(final p p) {
        return p.j.i();
    }
    
    @Override
    /* bridge */ boolean c(final Object o) {
        return this.i((Boolean)o);
    }
    
    boolean i(final Boolean b) {
        return b ^ true;
    }
}
