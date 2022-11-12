// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.request;

public final class b implements RequestCoordinator, e
{
    private final Object a;
    private final RequestCoordinator b;
    private volatile e c;
    private volatile e d;
    private RequestState e;
    private RequestState f;
    
    public b(final Object a, final RequestCoordinator b) {
        final RequestState cleared = RequestState.CLEARED;
        this.e = cleared;
        this.f = cleared;
        this.a = a;
        this.b = b;
    }
    
    private boolean k(final e e) {
        return e.equals(this.c) || (this.e == RequestState.FAILED && e.equals(this.d));
    }
    
    private boolean l() {
        final RequestCoordinator b = this.b;
        return b == null || b.j(this);
    }
    
    private boolean m() {
        final RequestCoordinator b = this.b;
        return b == null || b.b(this);
    }
    
    private boolean n() {
        final RequestCoordinator b = this.b;
        return b == null || b.c(this);
    }
    
    @Override
    public boolean a() {
        synchronized (this.a) {
            return this.c.a() || this.d.a();
        }
    }
    
    @Override
    public boolean b(final e e) {
        synchronized (this.a) {
            return this.m() && this.k(e);
        }
    }
    
    @Override
    public boolean c(final e e) {
        synchronized (this.a) {
            return this.n() && this.k(e);
        }
    }
    
    @Override
    public void clear() {
        synchronized (this.a) {
            final RequestState cleared = RequestState.CLEARED;
            this.e = cleared;
            this.c.clear();
            if (this.f != cleared) {
                this.f = cleared;
                this.d.clear();
            }
        }
    }
    
    @Override
    public void d(final e e) {
        synchronized (this.a) {
            if (!e.equals(this.d)) {
                this.e = RequestState.FAILED;
                final RequestState f = this.f;
                final RequestState running = RequestState.RUNNING;
                if (f != running) {
                    this.f = running;
                    this.d.i();
                }
                return;
            }
            this.f = RequestState.FAILED;
            final RequestCoordinator b = this.b;
            if (b != null) {
                b.d(this);
            }
        }
    }
    
    @Override
    public boolean e() {
        synchronized (this.a) {
            final RequestState e = this.e;
            final RequestState cleared = RequestState.CLEARED;
            return e == cleared && this.f == cleared;
        }
    }
    
    @Override
    public void f(final e e) {
        synchronized (this.a) {
            if (e.equals(this.c)) {
                this.e = RequestState.SUCCESS;
            }
            else if (e.equals(this.d)) {
                this.f = RequestState.SUCCESS;
            }
            final RequestCoordinator b = this.b;
            if (b != null) {
                b.f(this);
            }
        }
    }
    
    @Override
    public boolean g() {
        synchronized (this.a) {
            final RequestState e = this.e;
            final RequestState success = RequestState.SUCCESS;
            return e == success || this.f == success;
        }
    }
    
    @Override
    public RequestCoordinator getRoot() {
        synchronized (this.a) {
            final RequestCoordinator b = this.b;
            RequestCoordinator root;
            if (b != null) {
                root = b.getRoot();
            }
            else {
                root = this;
            }
            return root;
        }
    }
    
    @Override
    public boolean h(final e e) {
        final boolean b = e instanceof b;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final b b4 = (b)e;
            b3 = b2;
            if (this.c.h(b4.c)) {
                b3 = b2;
                if (this.d.h(b4.d)) {
                    b3 = true;
                }
            }
        }
        return b3;
    }
    
    @Override
    public void i() {
        synchronized (this.a) {
            final RequestState e = this.e;
            final RequestState running = RequestState.RUNNING;
            if (e != running) {
                this.e = running;
                this.c.i();
            }
        }
    }
    
    @Override
    public boolean isRunning() {
        synchronized (this.a) {
            final RequestState e = this.e;
            final RequestState running = RequestState.RUNNING;
            return e == running || this.f == running;
        }
    }
    
    @Override
    public boolean j(final e e) {
        synchronized (this.a) {
            return this.l() && this.k(e);
        }
    }
    
    public void o(final e c, final e d) {
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void pause() {
        synchronized (this.a) {
            final RequestState e = this.e;
            final RequestState running = RequestState.RUNNING;
            if (e == running) {
                this.e = RequestState.PAUSED;
                this.c.pause();
            }
            if (this.f == running) {
                this.f = RequestState.PAUSED;
                this.d.pause();
            }
        }
    }
}
