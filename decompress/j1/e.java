// 
// Decompiled by Procyon v0.6.0
// 

package j1;

import androidx.work.NetworkType;
import m1.p;
import k1.d;
import k1.g;
import o1.a;
import android.content.Context;
import e1.h;
import i1.b;

public class e extends c<b>
{
    private static final String e;
    
    static {
        e = h.f("NetworkMeteredCtrlr");
    }
    
    public e(final Context context, final o1.a a) {
        super(g.c(context, a).d());
    }
    
    @Override
    boolean b(final p p) {
        return p.j.b() == NetworkType.METERED;
    }
    
    @Override
    /* bridge */ boolean c(final Object o) {
        return this.i((b)o);
    }
    
    boolean i(final b b) {
        return !b.a() || !b.b();
    }
}
