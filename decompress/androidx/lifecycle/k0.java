// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import android.os.Handler;

public class k0
{
    private final t a;
    private final Handler b;
    private a c;
    
    public k0(final r r) {
        this.a = new t(r);
        this.b = new Handler();
    }
    
    private void f(final Lifecycle.Event event) {
        final a c = this.c;
        if (c != null) {
            c.run();
        }
        final a c2 = new a(this.a, event);
        this.c = c2;
        this.b.postAtFrontOfQueue((Runnable)c2);
    }
    
    public Lifecycle a() {
        return this.a;
    }
    
    public void b() {
        this.f(Lifecycle.Event.ON_START);
    }
    
    public void c() {
        this.f(Lifecycle.Event.ON_CREATE);
    }
    
    public void d() {
        this.f(Lifecycle.Event.ON_STOP);
        this.f(Lifecycle.Event.ON_DESTROY);
    }
    
    public void e() {
        this.f(Lifecycle.Event.ON_START);
    }
    
    static class a implements Runnable
    {
        private final t a;
        final Lifecycle.Event b;
        private boolean c;
        
        a(final t a, final Lifecycle.Event b) {
            this.c = false;
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void run() {
            if (!this.c) {
                this.a.h(this.b);
                this.c = true;
            }
        }
    }
}
