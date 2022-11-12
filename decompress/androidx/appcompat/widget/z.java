// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import androidx.appcompat.view.menu.g;
import android.view.Window$Callback;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.core.view.i0;
import android.content.Context;
import androidx.appcompat.view.menu.m;
import android.view.Menu;

public interface z
{
    boolean a();
    
    boolean b();
    
    boolean c();
    
    void collapseActionView();
    
    void d(final Menu p0, final m.a p1);
    
    boolean e();
    
    void f();
    
    boolean g();
    
    Context getContext();
    
    CharSequence getTitle();
    
    boolean h();
    
    void i(final int p0);
    
    Menu j();
    
    int k();
    
    i0 l(final int p0, final long p1);
    
    ViewGroup m();
    
    void n(final boolean p0);
    
    void o();
    
    void p(final boolean p0);
    
    void q();
    
    void r(final k0 p0);
    
    void s(final int p0);
    
    void setIcon(final int p0);
    
    void setIcon(final Drawable p0);
    
    void setWindowCallback(final Window$Callback p0);
    
    void setWindowTitle(final CharSequence p0);
    
    void t(final m.a p0, final g.a p1);
    
    void u(final int p0);
    
    int v();
    
    void w();
}
