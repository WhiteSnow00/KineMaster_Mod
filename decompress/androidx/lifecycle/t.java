// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import j.b;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.lang.ref.WeakReference;
import j.a;

public class t extends Lifecycle
{
    private j.a<q, a> b;
    private State c;
    private final WeakReference<r> d;
    private int e;
    private boolean f;
    private boolean g;
    private ArrayList<State> h;
    private final boolean i;
    
    public t(final r r) {
        this(r, true);
    }
    
    private t(final r r, final boolean i) {
        this.b = new j.a<q, a>();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = new ArrayList<State>();
        this.d = new WeakReference<r>(r);
        this.c = State.INITIALIZED;
        this.i = i;
    }
    
    private void d(final r r) {
        final Iterator<Map.Entry<Object, Object>> descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext() && !this.g) {
            final Map.Entry<K, a> entry = descendingIterator.next();
            final a a = entry.getValue();
            while (a.a.compareTo(this.c) > 0 && !this.g && this.b.contains((q)entry.getKey())) {
                final Event down = Event.downFrom(a.a);
                if (down == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("no event down from ");
                    sb.append(a.a);
                    throw new IllegalStateException(sb.toString());
                }
                this.n(down.getTargetState());
                a.a(r, down);
                this.m();
            }
        }
    }
    
    private State e(final q q) {
        final Map.Entry<q, a> n = this.b.n(q);
        State state = null;
        State a;
        if (n != null) {
            a = n.getValue().a;
        }
        else {
            a = null;
        }
        if (!this.h.isEmpty()) {
            final ArrayList<State> h = this.h;
            state = h.get(h.size() - 1);
        }
        return k(k(this.c, a), state);
    }
    
    private void f(final String s) {
        if (this.i && !i.a.f().c()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Method ");
            sb.append(s);
            sb.append(" must be called on the main thread");
            throw new IllegalStateException(sb.toString());
        }
    }
    
    private void g(final r r) {
        final b.d e = this.b.e();
        while (e.hasNext() && !this.g) {
            final Map.Entry<K, a> entry = ((Iterator<Map.Entry<K, a>>)e).next();
            final a a = entry.getValue();
            while (a.a.compareTo(this.c) < 0 && !this.g && this.b.contains((q)entry.getKey())) {
                this.n(a.a);
                final Event up = Event.upFrom(a.a);
                if (up == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("no event up from ");
                    sb.append(a.a);
                    throw new IllegalStateException(sb.toString());
                }
                a.a(r, up);
                this.m();
            }
        }
    }
    
    private boolean i() {
        final int size = this.b.size();
        boolean b = true;
        if (size == 0) {
            return true;
        }
        final State a = this.b.a().getValue().a;
        final State a2 = this.b.f().getValue().a;
        if (a != a2 || this.c != a2) {
            b = false;
        }
        return b;
    }
    
    static State k(final State state, final State state2) {
        State state3 = state;
        if (state2 != null) {
            state3 = state;
            if (state2.compareTo(state) < 0) {
                state3 = state2;
            }
        }
        return state3;
    }
    
    private void l(final State c) {
        final State c2 = this.c;
        if (c2 == c) {
            return;
        }
        if (c2 == State.INITIALIZED && c == State.DESTROYED) {
            final StringBuilder sb = new StringBuilder();
            sb.append("no event down from ");
            sb.append(this.c);
            throw new IllegalStateException(sb.toString());
        }
        this.c = c;
        if (!this.f && this.e == 0) {
            this.f = true;
            this.p();
            this.f = false;
            if (this.c == State.DESTROYED) {
                this.b = new j.a<q, a>();
            }
            return;
        }
        this.g = true;
    }
    
    private void m() {
        final ArrayList<State> h = this.h;
        h.remove(h.size() - 1);
    }
    
    private void n(final State state) {
        this.h.add(state);
    }
    
    private void p() {
        final r r = this.d.get();
        if (r != null) {
            while (!this.i()) {
                this.g = false;
                if (this.c.compareTo(this.b.a().getValue().a) < 0) {
                    this.d(r);
                }
                final Map.Entry<q, a> f = this.b.f();
                if (!this.g && f != null && this.c.compareTo(f.getValue().a) > 0) {
                    this.g(r);
                }
            }
            this.g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }
    
    @Override
    public void a(final q q) {
        this.f("addObserver");
        final State c = this.c;
        State state = State.DESTROYED;
        if (c != state) {
            state = State.INITIALIZED;
        }
        final a a = new a(q, state);
        if (this.b.k(q, a) != null) {
            return;
        }
        final r r = this.d.get();
        if (r == null) {
            return;
        }
        final boolean b = this.e != 0 || this.f;
        State state2 = this.e(q);
        ++this.e;
        while (a.a.compareTo(state2) < 0 && this.b.contains(q)) {
            this.n(a.a);
            final Event up = Event.upFrom(a.a);
            if (up == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("no event up from ");
                sb.append(a.a);
                throw new IllegalStateException(sb.toString());
            }
            a.a(r, up);
            this.m();
            state2 = this.e(q);
        }
        if (!b) {
            this.p();
        }
        --this.e;
    }
    
    @Override
    public State b() {
        return this.c;
    }
    
    @Override
    public void c(final q q) {
        this.f("removeObserver");
        this.b.m(q);
    }
    
    public void h(final Event event) {
        this.f("handleLifecycleEvent");
        this.l(event.getTargetState());
    }
    
    @Deprecated
    public void j(final State state) {
        this.f("markState");
        this.o(state);
    }
    
    public void o(final State state) {
        this.f("setCurrentState");
        this.l(state);
    }
    
    static class a
    {
        State a;
        o b;
        
        a(final q q, final State a) {
            this.b = w.f(q);
            this.a = a;
        }
        
        void a(final r r, final Event event) {
            final State targetState = event.getTargetState();
            this.a = t.k(this.a, targetState);
            this.b.f(r, event);
            this.a = targetState;
        }
    }
}
