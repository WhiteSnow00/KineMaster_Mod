// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import android.util.Log;
import java.io.IOException;
import t0.e;
import android.os.SystemClock;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import v0.g;
import java.util.concurrent.Executor;
import android.os.Handler;
import v0.h;

final class a
{
    private h a;
    private final Handler b;
    Runnable c;
    final Object d;
    final long e;
    final Executor f;
    int g;
    long h;
    g i;
    private boolean j;
    private final Runnable k;
    final Runnable l;
    
    a(final long n, final TimeUnit timeUnit, final Executor f) {
        this.a = null;
        this.b = new Handler(Looper.getMainLooper());
        this.c = null;
        this.d = new Object();
        this.g = 0;
        this.h = SystemClock.uptimeMillis();
        this.j = false;
        this.k = new Runnable() {
            final a a;
            
            @Override
            public void run() {
                final a a = this.a;
                a.f.execute(a.l);
            }
        };
        this.l = new Runnable() {
            final a a;
            
            @Override
            public void run() {
                synchronized (this.a.d) {
                    final long uptimeMillis = SystemClock.uptimeMillis();
                    final a a = this.a;
                    if (uptimeMillis - a.h < a.e) {
                        return;
                    }
                    if (a.g != 0) {
                        return;
                    }
                    final Runnable c = a.c;
                    if (c != null) {
                        c.run();
                        final g i = this.a.i;
                        if (i != null && i.isOpen()) {
                            try {
                                this.a.i.close();
                            }
                            catch (final IOException ex) {
                                t0.e.a(ex);
                            }
                            this.a.i = null;
                        }
                        return;
                    }
                    throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
            }
        };
        this.e = timeUnit.toMillis(n);
        this.f = f;
    }
    
    public void a() throws IOException {
        synchronized (this.d) {
            this.j = true;
            try (final g i = this.i) {}
            this.i = null;
        }
    }
    
    public void b() {
        synchronized (this.d) {
            int g = this.g;
            if (g > 0) {
                --g;
                if ((this.g = g) == 0) {
                    if (this.i == null) {
                        return;
                    }
                    this.b.postDelayed(this.k, this.e);
                }
                return;
            }
            throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
        }
    }
    
    public <V> V c(final k.a<g, V> a) {
        try {
            return a.apply(this.e());
        }
        finally {
            this.b();
        }
    }
    
    public g d() {
        synchronized (this.d) {
            return this.i;
        }
    }
    
    public g e() {
        synchronized (this.d) {
            this.b.removeCallbacks(this.k);
            ++this.g;
            if (this.j) {
                throw new IllegalStateException("Attempting to open already closed database.");
            }
            final g i = this.i;
            if (i != null && i.isOpen()) {
                return this.i;
            }
            final h a = this.a;
            if (a != null) {
                return this.i = a.getWritableDatabase();
            }
            throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        }
    }
    
    public void f(final h a) {
        if (this.a != null) {
            Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            return;
        }
        this.a = a;
    }
    
    public boolean g() {
        return this.j ^ true;
    }
    
    public void h(final Runnable c) {
        this.c = c;
    }
}
