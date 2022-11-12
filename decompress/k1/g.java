// 
// Decompiled by Procyon v0.6.0
// 

package k1;

import android.content.Context;

public class g
{
    private static g e;
    private a a;
    private b b;
    private e c;
    private f d;
    
    private g(Context applicationContext, final o1.a a) {
        applicationContext = applicationContext.getApplicationContext();
        this.a = new a(applicationContext, a);
        this.b = new b(applicationContext, a);
        this.c = new e(applicationContext, a);
        this.d = new f(applicationContext, a);
    }
    
    public static g c(final Context context, final o1.a a) {
        synchronized (g.class) {
            if (g.e == null) {
                g.e = new g(context, a);
            }
            return g.e;
        }
    }
    
    public a a() {
        return this.a;
    }
    
    public b b() {
        return this.b;
    }
    
    public e d() {
        return this.c;
    }
    
    public f e() {
        return this.d;
    }
}
