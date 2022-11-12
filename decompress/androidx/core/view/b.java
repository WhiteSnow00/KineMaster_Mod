// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.util.Log;
import android.view.SubMenu;
import android.view.MenuItem;
import android.view.View;
import android.content.Context;

public abstract class b
{
    private final Context a;
    private a b;
    private b c;
    
    public b(final Context a) {
        this.a = a;
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return true;
    }
    
    public abstract View c();
    
    public View d(final MenuItem menuItem) {
        return this.c();
    }
    
    public boolean e() {
        return false;
    }
    
    public void f(final SubMenu subMenu) {
    }
    
    public boolean g() {
        return false;
    }
    
    public void h() {
        this.c = null;
        this.b = null;
    }
    
    public void i(final a b) {
        this.b = b;
    }
    
    public void j(final b c) {
        if (this.c != null && c != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(this.getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", sb.toString());
        }
        this.c = c;
    }
    
    public interface a
    {
    }
    
    public interface b
    {
        void onActionProviderVisibilityChanged(final boolean p0);
    }
}
