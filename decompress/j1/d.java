// 
// Decompiled by Procyon v0.6.0
// 

package j1;

import androidx.work.NetworkType;
import m1.p;
import k1.g;
import o1.a;
import android.content.Context;
import i1.b;

public class d extends c<b>
{
    public d(final Context context, final o1.a a) {
        super(g.c(context, a).d());
    }
    
    @Override
    boolean b(final p p) {
        return p.j.b() == NetworkType.CONNECTED;
    }
    
    @Override
    /* bridge */ boolean c(final Object o) {
        return this.i((b)o);
    }
    
    boolean i(final b b) {
        return !b.a() || !b.d();
    }
}
