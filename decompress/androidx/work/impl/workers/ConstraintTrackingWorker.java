// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.workers;

import o1.a;
import com.google.common.util.concurrent.ListenableFuture;
import m1.p;
import java.util.Collections;
import i1.d;
import android.text.TextUtils;
import java.util.List;
import f1.i;
import androidx.work.impl.WorkDatabase;
import android.content.Context;
import e1.h;
import androidx.work.impl.utils.futures.b;
import androidx.work.WorkerParameters;
import i1.c;
import androidx.work.ListenableWorker;

public class ConstraintTrackingWorker extends ListenableWorker implements c
{
    private static final String p;
    private WorkerParameters f;
    final Object g;
    volatile boolean h;
    b<a> i;
    private ListenableWorker j;
    
    static {
        p = h.f("ConstraintTrkngWrkr");
    }
    
    public ConstraintTrackingWorker(final Context context, final WorkerParameters f) {
        super(context, f);
        this.f = f;
        this.g = new Object();
        this.h = false;
        this.i = androidx.work.impl.utils.futures.b.t();
    }
    
    public WorkDatabase a() {
        return f1.i.k(this.getApplicationContext()).o();
    }
    
    @Override
    public void b(final List<String> list) {
        e1.h.c().a(ConstraintTrackingWorker.p, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.g) {
            this.h = true;
        }
    }
    
    void c() {
        this.i.p(ListenableWorker.a.a());
    }
    
    void d() {
        this.i.p(ListenableWorker.a.b());
    }
    
    void e() {
        final String i = this.getInputData().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty((CharSequence)i)) {
            e1.h.c().b(ConstraintTrackingWorker.p, "No worker to delegate to.", new Throwable[0]);
            this.c();
            return;
        }
        if ((this.j = this.getWorkerFactory().b(this.getApplicationContext(), i, this.f)) == null) {
            e1.h.c().a(ConstraintTrackingWorker.p, "No worker to delegate to.", new Throwable[0]);
            this.c();
            return;
        }
        final p g = this.a().l().g(this.getId().toString());
        if (g == null) {
            this.c();
            return;
        }
        final d d = new d(this.getApplicationContext(), this.getTaskExecutor(), this);
        d.d(Collections.singletonList(g));
        if (d.c(this.getId().toString())) {
            e1.h.c().a(ConstraintTrackingWorker.p, String.format("Constraints met for delegate %s", i), new Throwable[0]);
            try {
                final ListenableFuture<a> startWork = this.j.startWork();
                startWork.f((Runnable)new Runnable(this, startWork) {
                    final ListenableFuture a;
                    final ConstraintTrackingWorker b;
                    
                    @Override
                    public void run() {
                        synchronized (this.b.g) {
                            if (this.b.h) {
                                this.b.d();
                            }
                            else {
                                this.b.i.r((com.google.common.util.concurrent.ListenableFuture<? extends a>)this.a);
                            }
                        }
                    }
                }, this.getBackgroundExecutor());
                return;
            }
            finally {
                final h c = e1.h.c();
                final String p = ConstraintTrackingWorker.p;
                final Throwable t;
                c.a(p, String.format("Delegated worker %s threw exception in startWork.", i), t);
                synchronized (this.g) {
                    if (this.h) {
                        e1.h.c().a(p, "Constraints were unmet, Retrying.", new Throwable[0]);
                        this.d();
                    }
                    else {
                        this.c();
                    }
                }
            }
        }
        e1.h.c().a(ConstraintTrackingWorker.p, String.format("Constraints not met for delegate %s. Requesting retry.", i), new Throwable[0]);
        this.d();
    }
    
    @Override
    public void f(final List<String> list) {
    }
    
    @Override
    public o1.a getTaskExecutor() {
        return f1.i.k(this.getApplicationContext()).p();
    }
    
    @Override
    public boolean isRunInForeground() {
        final ListenableWorker j = this.j;
        return j != null && j.isRunInForeground();
    }
    
    @Override
    public void onStopped() {
        super.onStopped();
        final ListenableWorker j = this.j;
        if (j != null && !j.isStopped()) {
            this.j.stop();
        }
    }
    
    @Override
    public ListenableFuture<a> startWork() {
        this.getBackgroundExecutor().execute(new Runnable(this) {
            final ConstraintTrackingWorker a;
            
            @Override
            public void run() {
                this.a.e();
            }
        });
        return (ListenableFuture<a>)this.i;
    }
}
