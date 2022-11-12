// 
// Decompiled by Procyon v0.6.0
// 

package j1;

import m1.p;
import k1.d;
import k1.g;
import android.content.Context;

public class a extends c<Boolean>
{
    public a(final Context context, final o1.a a) {
        super(g.c(context, a).a());
    }
    
    @Override
    boolean b(final p p) {
        return p.j.g();
    }
    
    @Override
    /* bridge */ boolean c(final Object o) {
        return this.i((Boolean)o);
    }
    
    boolean i(final Boolean b) {
        return b ^ true;
    }
}
