// 
// Decompiled by Procyon v0.6.0
// 

package a6;

import com.kinemaster.app.screen.base.mvp.BasePresenter;
import sa.a;

public final class h implements Runnable
{
    public final a a;
    
    public h(final a a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        BasePresenter.o(this.a);
    }
}
