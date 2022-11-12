// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import s2.i;
import android.graphics.drawable.Drawable;
import s2.h;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import v2.l;
import com.bumptech.glide.load.engine.GlideException;

public class f<R> implements d<R>, g<R>
{
    private static final a p;
    private final int a;
    private final int b;
    private final boolean c;
    private final a d;
    private R e;
    private e f;
    private boolean g;
    private boolean h;
    private boolean i;
    private GlideException j;
    
    static {
        p = new a();
    }
    
    public f(final int n, final int n2) {
        this(n, n2, true, com.bumptech.glide.request.f.p);
    }
    
    f(final int a, final int b, final boolean c, final a d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    private R a(final Long n) throws ExecutionException, InterruptedException, TimeoutException {
        synchronized (this) {
            if (this.c && !this.isDone()) {
                l.a();
            }
            if (this.g) {
                throw new CancellationException();
            }
            if (this.i) {
                throw new ExecutionException(this.j);
            }
            if (this.h) {
                return this.e;
            }
            if (n == null) {
                this.d.b(this, 0L);
            }
            else if (n > 0L) {
                for (long n2 = System.currentTimeMillis(), n3 = n + n2; !this.isDone() && n2 < n3; n2 = System.currentTimeMillis()) {
                    this.d.b(this, n3 - n2);
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.i) {
                throw new ExecutionException(this.j);
            }
            if (this.g) {
                throw new CancellationException();
            }
            if (this.h) {
                return this.e;
            }
            throw new TimeoutException();
        }
    }
    
    @Override
    public boolean cancel(final boolean b) {
        synchronized (this) {
            if (this.isDone()) {
                return false;
            }
            this.g = true;
            this.d.a(this);
            e f = null;
            if (b) {
                f = this.f;
                this.f = null;
            }
            monitorexit(this);
            if (f != null) {
                f.clear();
            }
            return true;
        }
    }
    
    @Override
    public R get() throws InterruptedException, ExecutionException {
        try {
            return this.a(null);
        }
        catch (final TimeoutException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    @Override
    public R get(final long n, final TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.a(timeUnit.toMillis(n));
    }
    
    @Override
    public e getRequest() {
        synchronized (this) {
            return this.f;
        }
    }
    
    @Override
    public void getSize(final h h) {
        h.d(this.a, this.b);
    }
    
    @Override
    public boolean isCancelled() {
        synchronized (this) {
            return this.g;
        }
    }
    
    @Override
    public boolean isDone() {
        synchronized (this) {
            return this.g || this.h || this.i;
        }
    }
    
    @Override
    public void onDestroy() {
    }
    
    @Override
    public void onLoadCleared(final Drawable drawable) {
    }
    
    @Override
    public void onLoadFailed(final Drawable drawable) {
        monitorenter(this);
        monitorexit(this);
    }
    
    @Override
    public boolean onLoadFailed(final GlideException j, final Object o, final i<R> i, final boolean b) {
        synchronized (this) {
            this.i = true;
            this.j = j;
            this.d.a(this);
            return false;
        }
    }
    
    @Override
    public void onLoadStarted(final Drawable drawable) {
    }
    
    @Override
    public void onResourceReady(final R r, final t2.d<? super R> d) {
        monitorenter(this);
        monitorexit(this);
    }
    
    @Override
    public boolean onResourceReady(final R e, final Object o, final i<R> i, final DataSource dataSource, final boolean b) {
        synchronized (this) {
            this.h = true;
            this.e = e;
            this.d.a(this);
            return false;
        }
    }
    
    @Override
    public void onStart() {
    }
    
    @Override
    public void onStop() {
    }
    
    @Override
    public void removeCallback(final h h) {
    }
    
    @Override
    public void setRequest(final e f) {
        synchronized (this) {
            this.f = f;
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        final String string = sb.toString();
        synchronized (this) {
            final boolean g = this.g;
            Object f = null;
            String s;
            if (g) {
                s = "CANCELLED";
            }
            else if (this.i) {
                s = "FAILURE";
            }
            else if (this.h) {
                s = "SUCCESS";
            }
            else {
                s = "PENDING";
                f = this.f;
            }
            monitorexit(this);
            if (f != null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(s);
                sb2.append(", request=[");
                sb2.append(f);
                sb2.append("]]");
                return sb2.toString();
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append(s);
            sb3.append("]");
            return sb3.toString();
        }
    }
    
    static class a
    {
        void a(final Object o) {
            o.notifyAll();
        }
        
        void b(final Object o, final long n) throws InterruptedException {
            o.wait(n);
        }
    }
}
