// 
// Decompiled by Procyon v0.6.0
// 

package a6;

import com.kinemaster.app.screen.base.mvp.BasePresenter;
import sa.l;
import ba.e;

public final class g implements e
{
    public final l a;
    
    public g(final l a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        BasePresenter.p(this.a, o);
    }
}
