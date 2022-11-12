// 
// Decompiled by Procyon v0.6.0
// 

package j1;

import android.os.Build$VERSION;
import androidx.work.NetworkType;
import m1.p;
import k1.d;
import o1.a;
import android.content.Context;
import i1.b;

public class g extends c<b>
{
    public g(final Context context, final o1.a a) {
        super(k1.g.c(context, a).d());
    }
    
    @Override
    boolean b(final p p) {
        return p.j.b() == NetworkType.UNMETERED || (Build$VERSION.SDK_INT >= 30 && p.j.b() == NetworkType.TEMPORARILY_UNMETERED);
    }
    
    @Override
    /* bridge */ boolean c(final Object o) {
        return this.i((b)o);
    }
    
    boolean i(final b b) {
        return !b.a() || b.b();
    }
}
