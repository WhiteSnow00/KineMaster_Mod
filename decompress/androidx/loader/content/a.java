// 
// Decompiled by Procyon v0.6.0
// 

package androidx.loader.content;

import androidx.core.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;
import android.os.SystemClock;
import androidx.core.util.i;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Executor;

public abstract class a<D> extends b<D>
{
    private final Executor j;
    volatile a k;
    volatile a l;
    long m;
    long n;
    Handler o;
    
    public a(final Context context) {
        this(context, ModernAsyncTask.h);
    }
    
    private a(final Context context, final Executor j) {
        super(context);
        this.n = -10000L;
        this.j = j;
    }
    
    public abstract D A();
    
    public void B(final D n) {
    }
    
    protected D C() {
        return this.A();
    }
    
    @Deprecated
    @Override
    public void g(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.g(s, fileDescriptor, printWriter, array);
        if (this.k != null) {
            printWriter.print(s);
            printWriter.print("mTask=");
            printWriter.print(this.k);
            printWriter.print(" waiting=");
            printWriter.println(this.k.w);
        }
        if (this.l != null) {
            printWriter.print(s);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.l);
            printWriter.print(" waiting=");
            printWriter.println(this.l.w);
        }
        if (this.m != 0L) {
            printWriter.print(s);
            printWriter.print("mUpdateThrottle=");
            androidx.core.util.i.c(this.m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            androidx.core.util.i.b(this.n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
    
    @Override
    protected boolean k() {
        if (this.k == null) {
            return false;
        }
        if (!super.e) {
            super.h = true;
        }
        if (this.l != null) {
            if (this.k.w) {
                this.k.w = false;
                this.o.removeCallbacks((Runnable)this.k);
            }
            this.k = null;
            return false;
        }
        if (this.k.w) {
            this.k.w = false;
            this.o.removeCallbacks((Runnable)this.k);
            this.k = null;
            return false;
        }
        final boolean a = this.k.a(false);
        if (a) {
            this.l = this.k;
            this.w();
        }
        this.k = null;
        return a;
    }
    
    @Override
    protected void m() {
        super.m();
        this.b();
        this.k = new a();
        this.z();
    }
    
    public void w() {
    }
    
    void x(final a a, final D n) {
        this.B(n);
        if (this.l == a) {
            this.s();
            this.n = SystemClock.uptimeMillis();
            this.l = null;
            this.e();
            this.z();
        }
    }
    
    void y(final a a, final D n) {
        if (this.k != a) {
            this.x(a, n);
        }
        else if (this.i()) {
            this.B(n);
        }
        else {
            this.c();
            this.n = SystemClock.uptimeMillis();
            this.k = null;
            this.f(n);
        }
    }
    
    void z() {
        if (this.l == null && this.k != null) {
            if (this.k.w) {
                this.k.w = false;
                this.o.removeCallbacks((Runnable)this.k);
            }
            if (this.m > 0L && SystemClock.uptimeMillis() < this.n + this.m) {
                this.k.w = true;
                this.o.postAtTime((Runnable)this.k, this.n + this.m);
                return;
            }
            ((ModernAsyncTask<Void, Object, Object>)this.k).c(this.j, (Void[])null);
        }
    }
    
    final class a extends ModernAsyncTask<Void, Void, D> implements Runnable
    {
        private final CountDownLatch p;
        boolean w;
        final androidx.loader.content.a x;
        
        a(final androidx.loader.content.a x) {
            this.x = x;
            this.p = new CountDownLatch(1);
        }
        
        @Override
        protected /* bridge */ Object b(final Object[] array) {
            return this.n((Void[])array);
        }
        
        @Override
        protected void h(final D n) {
            try {
                this.x.x(this, n);
            }
            finally {
                this.p.countDown();
            }
        }
        
        @Override
        protected void i(final D n) {
            try {
                this.x.y(this, n);
            }
            finally {
                this.p.countDown();
            }
        }
        
        protected D n(final Void... array) {
            try {
                return this.x.C();
            }
            catch (final OperationCanceledException ex) {
                if (this.f()) {
                    return null;
                }
                throw ex;
            }
        }
        
        @Override
        public void run() {
            this.w = false;
            this.x.z();
        }
    }
}
