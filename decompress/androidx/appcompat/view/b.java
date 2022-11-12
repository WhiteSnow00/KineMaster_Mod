// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view;

import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.View;

public abstract class b
{
    private Object a;
    private boolean b;
    
    public abstract void c();
    
    public abstract View d();
    
    public abstract Menu e();
    
    public abstract MenuInflater f();
    
    public abstract CharSequence g();
    
    public Object h() {
        return this.a;
    }
    
    public abstract CharSequence i();
    
    public boolean j() {
        return this.b;
    }
    
    public abstract void k();
    
    public abstract boolean l();
    
    public abstract void m(final View p0);
    
    public abstract void n(final int p0);
    
    public abstract void o(final CharSequence p0);
    
    public void p(final Object a) {
        this.a = a;
    }
    
    public abstract void q(final int p0);
    
    public abstract void r(final CharSequence p0);
    
    public void s(final boolean b) {
        this.b = b;
    }
    
    public interface a
    {
        void a(final b p0);
        
        boolean b(final b p0, final Menu p1);
        
        boolean c(final b p0, final MenuItem p1);
        
        boolean d(final b p0, final Menu p1);
    }
}
