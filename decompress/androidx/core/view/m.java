// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import androidx.lifecycle.q;
import android.view.MenuItem;
import java.util.Iterator;
import android.view.MenuInflater;
import android.view.Menu;
import androidx.lifecycle.r;
import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class m
{
    private final Runnable a;
    private final CopyOnWriteArrayList<o> b;
    private final Map<o, a> c;
    
    public m(final Runnable a) {
        this.b = new CopyOnWriteArrayList<o>();
        this.c = new HashMap<o, a>();
        this.a = a;
    }
    
    public static void a(final m m, final Lifecycle.State state, final o o, final r r, final Lifecycle.Event event) {
        m.g(state, o, r, event);
    }
    
    public static void b(final m m, final o o, final r r, final Lifecycle.Event event) {
        m.f(o, r, event);
    }
    
    private void f(final o o, final r r, final Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.l(o);
        }
    }
    
    private void g(final Lifecycle.State state, final o o, final r r, final Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            this.c(o);
        }
        else if (event == Lifecycle.Event.ON_DESTROY) {
            this.l(o);
        }
        else if (event == Lifecycle.Event.downFrom(state)) {
            this.b.remove(o);
            this.a.run();
        }
    }
    
    public void c(final o o) {
        this.b.add(o);
        this.a.run();
    }
    
    public void d(final o o, final r r) {
        this.c(o);
        final Lifecycle lifecycle = r.getLifecycle();
        final a a = this.c.remove(o);
        if (a != null) {
            a.a();
        }
        this.c.put(o, new a(lifecycle, new k(this, o)));
    }
    
    public void e(final o o, final r r, final Lifecycle.State state) {
        final Lifecycle lifecycle = r.getLifecycle();
        final a a = this.c.remove(o);
        if (a != null) {
            a.a();
        }
        this.c.put(o, new a(lifecycle, new l(this, state, o)));
    }
    
    public void h(final Menu menu, final MenuInflater menuInflater) {
        final Iterator<o> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().d(menu, menuInflater);
        }
    }
    
    public void i(final Menu menu) {
        final Iterator<o> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(menu);
        }
    }
    
    public boolean j(final MenuItem menuItem) {
        final Iterator<o> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().c(menuItem)) {
                return true;
            }
        }
        return false;
    }
    
    public void k(final Menu menu) {
        final Iterator<o> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            iterator.next().b(menu);
        }
    }
    
    public void l(final o o) {
        this.b.remove(o);
        final a a = this.c.remove(o);
        if (a != null) {
            a.a();
        }
        this.a.run();
    }
    
    private static class a
    {
        final Lifecycle a;
        private androidx.lifecycle.o b;
        
        a(final Lifecycle a, final androidx.lifecycle.o b) {
            (this.a = a).a(this.b = b);
        }
        
        void a() {
            this.a.c(this.b);
            this.b = null;
        }
    }
}
