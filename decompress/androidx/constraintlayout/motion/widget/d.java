// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.util.AttributeSet;
import android.content.Context;
import java.util.HashSet;
import t.c;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;

public abstract class d
{
    public static int f = -1;
    int a;
    int b;
    String c;
    protected int d;
    HashMap<String, ConstraintAttribute> e;
    
    public d() {
        final int f = androidx.constraintlayout.motion.widget.d.f;
        this.a = f;
        this.b = f;
        this.c = null;
    }
    
    public abstract void a(final HashMap<String, c> p0);
    
    public abstract d b();
    
    public d c(final d d) {
        this.a = d.a;
        this.b = d.b;
        this.c = d.c;
        this.d = d.d;
        this.e = d.e;
        return this;
    }
    
    public /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.b();
    }
    
    abstract void d(final HashSet<String> p0);
    
    abstract void e(final Context p0, final AttributeSet p1);
    
    public void f(final HashMap<String, Integer> hashMap) {
    }
    
    public d g(final int b) {
        this.b = b;
        return this;
    }
}
