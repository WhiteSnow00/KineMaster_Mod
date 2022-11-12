// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Log;
import android.os.Message;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Looper;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements LoaderErrorThrower
{
    public static final LoadErrorAction d;
    public static final LoadErrorAction e;
    public static final LoadErrorAction f;
    public static final LoadErrorAction g;
    private final ExecutorService a;
    private b<? extends Loadable> b;
    private IOException c;
    
    static {
        d = h(false, -9223372036854775807L);
        e = h(true, -9223372036854775807L);
        f = new LoadErrorAction(2, -9223372036854775807L, null);
        g = new LoadErrorAction(3, -9223372036854775807L, null);
    }
    
    public Loader(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("ExoPlayer:Loader:");
        sb.append(s);
        this.a = Util.D0(sb.toString());
    }
    
    static b b(final Loader loader) {
        return loader.b;
    }
    
    static b c(final Loader loader, final b b) {
        return loader.b = b;
    }
    
    static IOException d(final Loader loader, final IOException c) {
        return loader.c = c;
    }
    
    static ExecutorService e(final Loader loader) {
        return loader.a;
    }
    
    public static LoadErrorAction h(final boolean b, final long n) {
        return new LoadErrorAction(b ? 1 : 0, n, null);
    }
    
    @Override
    public void a() throws IOException {
        this.k(Integer.MIN_VALUE);
    }
    
    public void f() {
        Assertions.i(this.b).a(false);
    }
    
    public void g() {
        this.c = null;
    }
    
    public boolean i() {
        return this.c != null;
    }
    
    public boolean j() {
        return this.b != null;
    }
    
    public void k(final int n) throws IOException {
        final IOException c = this.c;
        if (c == null) {
            final b<? extends Loadable> b = this.b;
            if (b != null) {
                int a;
                if ((a = n) == Integer.MIN_VALUE) {
                    a = b.a;
                }
                b.e(a);
            }
            return;
        }
        throw c;
    }
    
    public void l() {
        this.m(null);
    }
    
    public void m(final ReleaseCallback releaseCallback) {
        final b<? extends Loadable> b = this.b;
        if (b != null) {
            b.a(true);
        }
        if (releaseCallback != null) {
            this.a.execute(new c(releaseCallback));
        }
        this.a.shutdown();
    }
    
    public <T extends Loadable> long n(final T t, final Callback<T> callback, final int n) {
        final Looper looper = Assertions.i(Looper.myLooper());
        this.c = null;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(looper, (Loadable)t, (Callback<Loadable>)callback, n, elapsedRealtime).f(0L);
        return elapsedRealtime;
    }
    
    public interface Callback<T extends Loadable>
    {
        void A(final T p0, final long p1, final long p2);
        
        LoadErrorAction L(final T p0, final long p1, final long p2, final IOException p3, final int p4);
        
        void v(final T p0, final long p1, final long p2, final boolean p3);
    }
    
    public static final class LoadErrorAction
    {
        private final int a;
        private final long b;
        
        private LoadErrorAction(final int a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        LoadErrorAction(final int n, final long n2, final Loader$a object) {
            this(n, n2);
        }
        
        static int a(final LoadErrorAction loadErrorAction) {
            return loadErrorAction.a;
        }
        
        static long b(final LoadErrorAction loadErrorAction) {
            return loadErrorAction.b;
        }
        
        public boolean c() {
            final int a = this.a;
            boolean b = true;
            if (a != 0) {
                b = (a == 1 && b);
            }
            return b;
        }
    }
    
    public interface Loadable
    {
        void a() throws IOException;
        
        void c();
    }
    
    public interface ReleaseCallback
    {
        void m();
    }
    
    public static final class UnexpectedLoaderException extends IOException
    {
        public UnexpectedLoaderException(final Throwable t) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected ");
            sb.append(t.getClass().getSimpleName());
            sb.append(": ");
            sb.append(t.getMessage());
            super(sb.toString(), t);
        }
    }
    
    private final class b<T extends Loadable> extends Handler implements Runnable
    {
        public final int a;
        private final T b;
        private final long c;
        private Callback<T> d;
        private IOException e;
        private int f;
        private Thread g;
        private boolean h;
        private volatile boolean i;
        final Loader j;
        
        public b(final Loader j, final Looper looper, final T b, final Callback<T> d, final int a, final long c) {
            this.j = j;
            super(looper);
            this.b = b;
            this.d = d;
            this.a = a;
            this.c = c;
        }
        
        private void b() {
            this.e = null;
            Loader.e(this.j).execute(Assertions.e(Loader.b(this.j)));
        }
        
        private void c() {
            Loader.c(this.j, null);
        }
        
        private long d() {
            return Math.min((this.f - 1) * 1000, 5000);
        }
        
        public void a(final boolean i) {
            this.i = i;
            this.e = null;
            Label_0075: {
                if (this.hasMessages(0)) {
                    this.h = true;
                    this.removeMessages(0);
                    if (!i) {
                        this.sendEmptyMessage(1);
                        break Label_0075;
                    }
                    break Label_0075;
                }
                synchronized (this) {
                    this.h = true;
                    this.b.c();
                    final Thread g = this.g;
                    if (g != null) {
                        g.interrupt();
                    }
                    monitorexit(this);
                    if (i) {
                        this.c();
                        final long elapsedRealtime = SystemClock.elapsedRealtime();
                        Assertions.e(this.d).v(this.b, elapsedRealtime, elapsedRealtime - this.c, true);
                        this.d = null;
                    }
                }
            }
        }
        
        public void e(final int n) throws IOException {
            final IOException e = this.e;
            if (e != null && this.f > n) {
                throw e;
            }
        }
        
        public void f(final long n) {
            Assertions.g(Loader.b(this.j) == null);
            Loader.c(this.j, this);
            if (n > 0L) {
                this.sendEmptyMessageDelayed(0, n);
            }
            else {
                this.b();
            }
        }
        
        public void handleMessage(final Message message) {
            if (this.i) {
                return;
            }
            final int what = message.what;
            if (what == 0) {
                this.b();
                return;
            }
            if (what == 3) {
                throw (Error)message.obj;
            }
            this.c();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final long n = elapsedRealtime - this.c;
            final Callback<T> callback = Assertions.e(this.d);
            if (this.h) {
                callback.v(this.b, elapsedRealtime, n, false);
                return;
            }
            final int what2 = message.what;
            if (what2 != 1) {
                if (what2 == 2) {
                    final IOException e = (IOException)message.obj;
                    this.e = e;
                    final int f = this.f + 1;
                    this.f = f;
                    final LoadErrorAction l = callback.L(this.b, elapsedRealtime, n, e, f);
                    if (LoadErrorAction.a(l) == 3) {
                        Loader.d(this.j, this.e);
                    }
                    else if (LoadErrorAction.a(l) != 2) {
                        if (LoadErrorAction.a(l) == 1) {
                            this.f = 1;
                        }
                        long n2;
                        if (LoadErrorAction.b(l) != -9223372036854775807L) {
                            n2 = LoadErrorAction.b(l);
                        }
                        else {
                            n2 = this.d();
                        }
                        this.f(n2);
                    }
                }
            }
            else {
                try {
                    callback.A(this.b, elapsedRealtime, n);
                }
                catch (final RuntimeException ex) {
                    Log.d("LoadTask", "Unexpected exception handling load completed", ex);
                    Loader.d(this.j, new UnexpectedLoaderException(ex));
                }
            }
        }
        
        public void run() {
            try {
                synchronized (this) {
                    final boolean b = !this.h;
                    this.g = Thread.currentThread();
                    monitorexit(this);
                    if (b) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("load:");
                        sb.append(this.b.getClass().getSimpleName());
                        TraceUtil.a(sb.toString());
                        try {
                            this.b.a();
                        }
                        finally {
                            TraceUtil.c();
                        }
                    }
                    synchronized (this) {
                        this.g = null;
                        Thread.interrupted();
                        monitorexit(this);
                        if (!this.i) {
                            this.sendEmptyMessage(1);
                        }
                    }
                }
            }
            catch (final Error error) {
                if (!this.i) {
                    Log.d("LoadTask", "Unexpected error loading stream", error);
                    this.obtainMessage(3, (Object)error).sendToTarget();
                }
                throw error;
            }
            catch (final OutOfMemoryError outOfMemoryError) {
                if (!this.i) {
                    Log.d("LoadTask", "OutOfMemory error loading stream", outOfMemoryError);
                    this.obtainMessage(2, (Object)new UnexpectedLoaderException(outOfMemoryError)).sendToTarget();
                }
            }
            catch (final Exception ex) {
                if (!this.i) {
                    Log.d("LoadTask", "Unexpected exception loading stream", ex);
                    this.obtainMessage(2, (Object)new UnexpectedLoaderException(ex)).sendToTarget();
                }
            }
            catch (final IOException ex2) {
                if (!this.i) {
                    this.obtainMessage(2, (Object)ex2).sendToTarget();
                }
            }
        }
    }
    
    private static final class c implements Runnable
    {
        private final ReleaseCallback a;
        
        public c(final ReleaseCallback a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            this.a.m();
        }
    }
}
