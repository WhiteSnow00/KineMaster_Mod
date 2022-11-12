// 
// Decompiled by Procyon v0.6.0
// 

package a6;

import com.kinemaster.app.screen.base.mvp.BasePresenter;
import com.kinemaster.app.screen.base.mvp.BasePresenter$a;
import ba.e;

public final class d implements e
{
    public final BasePresenter$a a;
    public final BasePresenter b;
    public final boolean c;
    
    public d(final BasePresenter$a a, final BasePresenter b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void accept(final Object o) {
        BasePresenter.t(this.a, this.b, this.c, (Throwable)o);
    }
}
