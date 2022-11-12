// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.request;

public class j implements RequestCoordinator, e
{
    private final RequestCoordinator a;
    private final Object b;
    private volatile e c;
    private volatile e d;
    private RequestState e;
    private RequestState f;
    private boolean g;
    
    public j(final Object b, final RequestCoordinator a) {
        final RequestState cleared = RequestState.CLEARED;
        this.e = cleared;
        this.f = cleared;
        this.b = b;
        this.a = a;
    }
    
    private boolean k() {
        final RequestCoordinator a = this.a;
        return a == null || a.j(this);
    }
    
    private boolean l() {
        final RequestCoordinator a = this.a;
        return a == null || a.b(this);
    }
    
    private boolean m() {
        final RequestCoordinator a = this.a;
        return a == null || a.c(this);
    }
    
    @Override
    public boolean a() {
        synchronized (this.b) {
            return this.d.a() || this.c.a();
        }
    }
    
    @Override
    public boolean b(final e e) {
        synchronized (this.b) {
            return this.l() && e.equals(this.c) && !this.a();
        }
    }
    
    @Override
    public boolean c(final e e) {
        synchronized (this.b) {
            return this.m() && (e.equals(this.c) || this.e != RequestState.SUCCESS);
        }
    }
    
    @Override
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            final RequestState cleared = RequestState.CLEARED;
            this.e = cleared;
            this.f = cleared;
            this.d.clear();
            this.c.clear();
        }
    }
    
    @Override
    public void d(final e e) {
        synchronized (this.b) {
            if (!e.equals(this.c)) {
                this.f = RequestState.FAILED;
                return;
            }
            this.e = RequestState.FAILED;
            final RequestCoordinator a = this.a;
            if (a != null) {
                a.d(this);
            }
        }
    }
    
    @Override
    public boolean e() {
        synchronized (this.b) {
            return this.e == RequestState.CLEARED;
        }
    }
    
    @Override
    public void f(final e e) {
        synchronized (this.b) {
            if (e.equals(this.d)) {
                this.f = RequestState.SUCCESS;
                return;
            }
            this.e = RequestState.SUCCESS;
            final RequestCoordinator a = this.a;
            if (a != null) {
                a.f(this);
            }
            if (!this.f.isComplete()) {
                this.d.clear();
            }
        }
    }
    
    @Override
    public boolean g() {
        synchronized (this.b) {
            return this.e == RequestState.SUCCESS;
        }
    }
    
    @Override
    public RequestCoordinator getRoot() {
        synchronized (this.b) {
            final RequestCoordinator a = this.a;
            RequestCoordinator root;
            if (a != null) {
                root = a.getRoot();
            }
            else {
                root = this;
            }
            return root;
        }
    }
    
    @Override
    public boolean h(final e e) {
        final boolean b = e instanceof j;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final j j = (j)e;
            if (this.c == null) {
                b3 = b2;
                if (j.c != null) {
                    return b3;
                }
            }
            else {
                b3 = b2;
                if (!this.c.h(j.c)) {
                    return b3;
                }
            }
            if (this.d == null) {
                b3 = b2;
                if (j.d != null) {
                    return b3;
                }
            }
            else {
                b3 = b2;
                if (!this.d.h(j.d)) {
                    return b3;
                }
            }
            b3 = true;
        }
        return b3;
    }
    
    @Override
    public void i() {
        synchronized (this.b) {
            this.g = true;
            try {
                if (this.e != RequestState.SUCCESS) {
                    final RequestState f = this.f;
                    final RequestState running = RequestState.RUNNING;
                    if (f != running) {
                        this.f = running;
                        this.d.i();
                    }
                }
                if (this.g) {
                    final RequestState e = this.e;
                    final RequestState running2 = RequestState.RUNNING;
                    if (e != running2) {
                        this.e = running2;
                        this.c.i();
                    }
                }
            }
            finally {
                this.g = false;
            }
        }
    }
    
    @Override
    public boolean isRunning() {
        synchronized (this.b) {
            return this.e == RequestState.RUNNING;
        }
    }
    
    @Override
    public boolean j(final e e) {
        synchronized (this.b) {
            return this.k() && e.equals(this.c) && this.e != RequestState.PAUSED;
        }
    }
    
    public void n(final e c, final e d) {
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void pause() {
        synchronized (this.b) {
            if (!this.f.isComplete()) {
                this.f = RequestState.PAUSED;
                this.d.pause();
            }
            if (!this.e.isComplete()) {
                this.e = RequestState.PAUSED;
                this.c.pause();
            }
        }
    }
}
