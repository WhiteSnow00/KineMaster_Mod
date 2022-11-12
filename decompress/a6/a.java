// 
// Decompiled by Procyon v0.6.0
// 

package a6;

import com.kinemaster.app.screen.base.mvp.BasePresenter;
import com.kinemaster.app.screen.base.mvp.BasePresenter$a;

public final class a implements ba.a
{
    public final BasePresenter$a a;
    public final boolean b;
    public final BasePresenter c;
    
    public a(final BasePresenter$a a, final boolean b, final BasePresenter c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void run() {
        BasePresenter.r(this.a, this.b, this.c);
    }
}
