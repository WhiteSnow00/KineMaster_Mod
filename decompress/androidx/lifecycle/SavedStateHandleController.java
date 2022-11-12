// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import u0.c;

final class SavedStateHandleController implements o
{
    private final String a;
    private boolean b;
    private final g0 c;
    
    SavedStateHandleController(final String a, final g0 c) {
        this.b = false;
        this.a = a;
        this.c = c;
    }
    
    @Override
    public void f(final r r, final Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.b = false;
            r.getLifecycle().c(this);
        }
    }
    
    void g(final c c, final Lifecycle lifecycle) {
        if (!this.b) {
            this.b = true;
            lifecycle.a(this);
            c.h(this.a, this.c.f());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }
    
    g0 h() {
        return this.c;
    }
    
    boolean j() {
        return this.b;
    }
}
