// 
// Decompiled by Procyon v0.6.0
// 

package a6;

import io.reactivex.disposables.b;
import com.kinemaster.app.screen.base.mvp.BasePresenter;
import com.kinemaster.app.screen.base.mvp.BasePresenter$a;

public final class e implements ba.e
{
    public final BasePresenter$a a;
    public final boolean b;
    public final BasePresenter c;
    
    public e(final BasePresenter$a a, final boolean b, final BasePresenter c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void accept(final Object o) {
        BasePresenter.q(this.a, this.b, this.c, (b)o);
    }
}
