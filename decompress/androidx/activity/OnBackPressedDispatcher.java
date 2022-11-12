// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import androidx.lifecycle.q;
import androidx.lifecycle.o;
import java.util.Iterator;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import java.util.ArrayDeque;

public final class OnBackPressedDispatcher
{
    private final Runnable a;
    final ArrayDeque<g> b;
    
    public OnBackPressedDispatcher(final Runnable a) {
        this.b = new ArrayDeque<g>();
        this.a = a;
    }
    
    public void a(final g g) {
        this.c(g);
    }
    
    public void b(final r r, final g g) {
        final Lifecycle lifecycle = r.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        g.addCancellable(new LifecycleOnBackPressedCancellable(lifecycle, g));
    }
    
    androidx.activity.a c(final g g) {
        this.b.add(g);
        final a a = new a(g);
        g.addCancellable(a);
        return a;
    }
    
    public void d() {
        final Iterator<g> descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext()) {
            final g g = descendingIterator.next();
            if (g.isEnabled()) {
                g.handleOnBackPressed();
                return;
            }
        }
        final Runnable a = this.a;
        if (a != null) {
            a.run();
        }
    }
    
    private class LifecycleOnBackPressedCancellable implements o, a
    {
        private final Lifecycle a;
        private final g b;
        private a c;
        final OnBackPressedDispatcher d;
        
        LifecycleOnBackPressedCancellable(final OnBackPressedDispatcher d, final Lifecycle a, final g b) {
            this.d = d;
            this.a = a;
            this.b = b;
            a.a(this);
        }
        
        @Override
        public void cancel() {
            this.a.c(this);
            this.b.removeCancellable(this);
            final a c = this.c;
            if (c != null) {
                c.cancel();
                this.c = null;
            }
        }
        
        @Override
        public void f(final r r, final Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.c = this.d.c(this.b);
            }
            else if (event == Lifecycle.Event.ON_STOP) {
                final a c = this.c;
                if (c != null) {
                    c.cancel();
                }
            }
            else if (event == Lifecycle.Event.ON_DESTROY) {
                this.cancel();
            }
        }
    }
    
    private class a implements androidx.activity.a
    {
        private final g a;
        final OnBackPressedDispatcher b;
        
        a(final OnBackPressedDispatcher b, final g a) {
            this.b = b;
            this.a = a;
        }
        
        @Override
        public void cancel() {
            this.b.b.remove(this.a);
            this.a.removeCancellable(this);
        }
    }
}
