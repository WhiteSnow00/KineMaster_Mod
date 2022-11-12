// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E>
{
    private final Thread a;
    private final Object b;
    private final ArrayDeque<I> c;
    private final ArrayDeque<O> d;
    private final I[] e;
    private final O[] f;
    private int g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;
    
    protected SimpleDecoder(final I[] e, final O[] f) {
        this.b = new Object();
        this.c = new ArrayDeque<I>();
        this.d = new ArrayDeque<O>();
        this.e = e;
        this.g = e.length;
        final int n = 0;
        for (int i = 0; i < this.g; ++i) {
            this.e[i] = this.g();
        }
        this.f = f;
        this.h = f.length;
        for (int j = n; j < this.h; ++j) {
            this.f[j] = this.h();
        }
        (this.a = new Thread(this, "ExoPlayer:SimpleDecoder") {
            final SimpleDecoder a;
            
            @Override
            public void run() {
                SimpleDecoder.e(this.a);
            }
        }).start();
    }
    
    static void e(final SimpleDecoder simpleDecoder) {
        simpleDecoder.t();
    }
    
    private boolean f() {
        return !this.c.isEmpty() && this.h > 0;
    }
    
    private boolean k() throws InterruptedException {
        Object j = this.b;
        synchronized (j) {
            while (!this.l && !this.f()) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            final DecoderInputBuffer decoderInputBuffer = this.c.removeFirst();
            final O[] f = this.f;
            final int h = this.h - 1;
            this.h = h;
            final DecoderOutputBuffer decoderOutputBuffer = f[h];
            final boolean k = this.k;
            this.k = false;
            monitorexit(j);
            if (decoderInputBuffer.n()) {
                decoderOutputBuffer.g(4);
            }
            else {
                if (decoderInputBuffer.m()) {
                    decoderOutputBuffer.g(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer.o()) {
                    decoderOutputBuffer.g(134217728);
                }
                try {
                    j = this.j((I)decoderInputBuffer, (O)decoderOutputBuffer, k);
                }
                catch (OutOfMemoryError j) {
                    j = this.i((Throwable)j);
                }
                catch (RuntimeException j) {
                    j = this.i((Throwable)j);
                }
                if (j != null) {
                    synchronized (this.b) {
                        this.j = (E)j;
                        return false;
                    }
                }
            }
            synchronized (this.b) {
                if (this.k) {
                    decoderOutputBuffer.r();
                }
                else if (decoderOutputBuffer.m()) {
                    ++this.m;
                    decoderOutputBuffer.r();
                }
                else {
                    decoderOutputBuffer.c = this.m;
                    this.m = 0;
                    this.d.addLast((O)decoderOutputBuffer);
                }
                this.q((I)decoderInputBuffer);
                return true;
            }
        }
    }
    
    private void n() {
        if (this.f()) {
            this.b.notify();
        }
    }
    
    private void o() throws E, DecoderException {
        final DecoderException j = this.j;
        if (j == null) {
            return;
        }
        throw j;
    }
    
    private void q(final I n) {
        n.h();
        this.e[this.g++] = n;
    }
    
    private void s(final O o) {
        o.h();
        this.f[this.h++] = o;
    }
    
    private void t() {
        try {
            while (this.k()) {}
        }
        catch (final InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    @Override
    public /* bridge */ Object b() throws DecoderException {
        return this.m();
    }
    
    @Override
    public /* bridge */ void c(final Object o) throws DecoderException {
        this.p((DecoderInputBuffer)o);
    }
    
    @Override
    public /* bridge */ Object d() throws DecoderException {
        return this.l();
    }
    
    @Override
    public final void flush() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            final DecoderInputBuffer i = this.i;
            if (i != null) {
                this.q((I)i);
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                this.q(this.c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                this.d.removeFirst().r();
            }
        }
    }
    
    protected abstract I g();
    
    protected abstract O h();
    
    protected abstract E i(final Throwable p0);
    
    protected abstract E j(final I p0, final O p1, final boolean p2);
    
    public final I l() throws E, DecoderException {
        synchronized (this.b) {
            this.o();
            Assertions.g(this.i == null);
            int g = this.g;
            DecoderInputBuffer i;
            if (g == 0) {
                i = null;
            }
            else {
                final I[] e = this.e;
                --g;
                this.g = g;
                i = e[g];
            }
            return this.i = (I)i;
        }
    }
    
    public final O m() throws E, DecoderException {
        synchronized (this.b) {
            this.o();
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }
    
    public final void p(final I n) throws E, DecoderException {
        synchronized (this.b) {
            this.o();
            Assertions.a(n == this.i);
            this.c.addLast(n);
            this.n();
            this.i = null;
        }
    }
    
    protected void r(final O o) {
        synchronized (this.b) {
            this.s(o);
            this.n();
        }
    }
    
    @Override
    public void release() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
            monitorexit(this.b);
            try {
                this.a.join();
            }
            catch (final InterruptedException o) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    protected final void u(final int n) {
        final int g = this.g;
        final int length = this.e.length;
        int i = 0;
        Assertions.g(g == length);
        for (I[] e = this.e; i < e.length; ++i) {
            e[i].s(n);
        }
    }
}
