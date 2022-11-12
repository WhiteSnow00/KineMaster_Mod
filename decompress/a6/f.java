// 
// Decompiled by Procyon v0.6.0
// 

package a6;

import com.kinemaster.app.screen.base.mvp.BasePresenter;
import sa.l;
import ba.e;

public final class f implements e
{
    public final l a;
    
    public f(final l a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        BasePresenter.s(this.a, (Throwable)o);
    }
}
