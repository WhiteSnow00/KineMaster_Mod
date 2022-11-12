// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import java.util.concurrent.Future;
import e1.f;
import java.util.concurrent.Executor;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import n1.k;
import n1.l;
import n1.m;
import java.util.UUID;
import java.util.ArrayList;
import n1.d;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.Collection;
import androidx.work.WorkInfo;
import java.util.LinkedList;
import java.util.Iterator;
import e1.h;
import m1.t;
import m1.q;
import androidx.work.impl.WorkDatabase;
import o1.a;
import m1.p;
import androidx.work.WorkerParameters;
import java.util.List;
import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import androidx.work.impl.utils.futures.b;

public class j implements Runnable
{
    static final String E;
    private String A;
    b<Boolean> B;
    ListenableFuture<ListenableWorker.a> C;
    private volatile boolean D;
    Context a;
    private String b;
    private List<e> c;
    private WorkerParameters.a d;
    p e;
    ListenableWorker f;
    a g;
    ListenableWorker.a h;
    private androidx.work.a i;
    private l1.a j;
    private WorkDatabase p;
    private q w;
    private m1.b x;
    private t y;
    private List<String> z;
    
    static {
        E = h.f("WorkerWrapper");
    }
    
    j(final c c) {
        this.h = ListenableWorker.a.a();
        this.B = androidx.work.impl.utils.futures.b.t();
        this.C = null;
        this.a = c.a;
        this.g = c.d;
        this.j = c.c;
        this.b = c.g;
        this.c = c.h;
        this.d = c.i;
        this.f = c.b;
        this.i = c.e;
        final WorkDatabase f = c.f;
        this.p = f;
        this.w = f.l();
        this.x = this.p.d();
        this.y = this.p.m();
    }
    
    private String a(final List<String> list) {
        final StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.b);
        sb.append(", tags={ ");
        final Iterator<String> iterator = list.iterator();
        int n = 1;
        while (iterator.hasNext()) {
            final String s = iterator.next();
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append(", ");
            }
            sb.append(s);
        }
        sb.append(" } ]");
        return sb.toString();
    }
    
    private void c(final ListenableWorker.a a) {
        if (a instanceof ListenableWorker.a.c) {
            e1.h.c().d(f1.j.E, String.format("Worker result SUCCESS for %s", this.A), new Throwable[0]);
            if (this.e.d()) {
                this.h();
            }
            else {
                this.m();
            }
        }
        else if (a instanceof ListenableWorker.a.b) {
            e1.h.c().d(f1.j.E, String.format("Worker result RETRY for %s", this.A), new Throwable[0]);
            this.g();
        }
        else {
            e1.h.c().d(f1.j.E, String.format("Worker result FAILURE for %s", this.A), new Throwable[0]);
            if (this.e.d()) {
                this.h();
            }
            else {
                this.l();
            }
        }
    }
    
    private void e(String s) {
        final LinkedList list = new LinkedList();
        list.add(s);
        while (!list.isEmpty()) {
            s = (String)list.remove();
            if (this.w.f(s) != WorkInfo.State.CANCELLED) {
                this.w.b(WorkInfo.State.FAILED, s);
            }
            list.addAll(this.x.a(s));
        }
    }
    
    private void g() {
        this.p.beginTransaction();
        try {
            this.w.b(WorkInfo.State.ENQUEUED, this.b);
            this.w.u(this.b, System.currentTimeMillis());
            this.w.l(this.b, -1L);
            this.p.setTransactionSuccessful();
        }
        finally {
            this.p.endTransaction();
            this.i(true);
        }
    }
    
    private void h() {
        this.p.beginTransaction();
        try {
            this.w.u(this.b, System.currentTimeMillis());
            this.w.b(WorkInfo.State.ENQUEUED, this.b);
            this.w.s(this.b);
            this.w.l(this.b, -1L);
            this.p.setTransactionSuccessful();
        }
        finally {
            this.p.endTransaction();
            this.i(false);
        }
    }
    
    private void i(final boolean b) {
        this.p.beginTransaction();
        try {
            if (!this.p.l().r()) {
                n1.d.a(this.a, RescheduleReceiver.class, false);
            }
            if (b) {
                this.w.b(WorkInfo.State.ENQUEUED, this.b);
                this.w.l(this.b, -1L);
            }
            if (this.e != null) {
                final ListenableWorker f = this.f;
                if (f != null && f.isRunInForeground()) {
                    this.j.a(this.b);
                }
            }
            this.p.setTransactionSuccessful();
            this.p.endTransaction();
            this.B.p(b);
        }
        finally {
            this.p.endTransaction();
        }
    }
    
    private void j() {
        final WorkInfo.State f = this.w.f(this.b);
        if (f == WorkInfo.State.RUNNING) {
            e1.h.c().a(f1.j.E, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.b), new Throwable[0]);
            this.i(true);
        }
        else {
            e1.h.c().a(f1.j.E, String.format("Status for %s is %s; not doing any work", this.b, f), new Throwable[0]);
            this.i(false);
        }
    }
    
    private void k() {
        if (this.n()) {
            return;
        }
        this.p.beginTransaction();
        try {
            final p g = this.w.g(this.b);
            this.e = g;
            if (g == null) {
                e1.h.c().b(f1.j.E, String.format("Didn't find WorkSpec for id %s", this.b), new Throwable[0]);
                this.i(false);
                this.p.setTransactionSuccessful();
                return;
            }
            if (g.b != WorkInfo.State.ENQUEUED) {
                this.j();
                this.p.setTransactionSuccessful();
                e1.h.c().a(f1.j.E, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.e.c), new Throwable[0]);
                return;
            }
            if (g.d() || this.e.c()) {
                final long currentTimeMillis = System.currentTimeMillis();
                final p e = this.e;
                if (e.n != 0L && currentTimeMillis < e.a()) {
                    e1.h.c().a(f1.j.E, String.format("Delaying execution for %s because it is being executed before schedule.", this.e.c), new Throwable[0]);
                    this.i(true);
                    this.p.setTransactionSuccessful();
                    return;
                }
            }
            this.p.setTransactionSuccessful();
            this.p.endTransaction();
            androidx.work.b b;
            if (this.e.d()) {
                b = this.e.e;
            }
            else {
                final f b2 = this.i.f().b(this.e.d);
                if (b2 == null) {
                    e1.h.c().b(f1.j.E, String.format("Could not create Input Merger %s", this.e.d), new Throwable[0]);
                    this.l();
                    return;
                }
                final ArrayList list = new ArrayList();
                list.add(this.e.e);
                list.addAll(this.w.i(this.b));
                b = b2.b(list);
            }
            final WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.b), b, this.z, this.d, this.e.k, this.i.e(), this.g, this.i.m(), new m(this.p, this.g), new l(this.p, this.j, this.g));
            if (this.f == null) {
                this.f = this.i.m().b(this.a, this.e.c, workerParameters);
            }
            final ListenableWorker f = this.f;
            if (f == null) {
                e1.h.c().b(f1.j.E, String.format("Could not create Worker %s", this.e.c), new Throwable[0]);
                this.l();
                return;
            }
            if (f.isUsed()) {
                e1.h.c().b(f1.j.E, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.e.c), new Throwable[0]);
                this.l();
                return;
            }
            this.f.setUsed();
            if (this.o()) {
                if (this.n()) {
                    return;
                }
                final b<Object> t = androidx.work.impl.utils.futures.b.t();
                final k k = new k(this.a, this.e, this.f, workerParameters.b(), this.g);
                this.g.a().execute(k);
                final ListenableFuture<Void> a = k.a();
                a.f((Runnable)new Runnable(this, a, t) {
                    final ListenableFuture a;
                    final b b;
                    final j c;
                    
                    @Override
                    public void run() {
                        try {
                            ((Future<Object>)this.a).get();
                            e1.h.c().a(f1.j.E, String.format("Starting work for %s", this.c.e.c), new Throwable[0]);
                            final j c = this.c;
                            c.C = c.f.startWork();
                            this.b.r(this.c.C);
                        }
                        finally {
                            final Throwable t;
                            this.b.q(t);
                        }
                    }
                }, this.g.a());
                t.f(new Runnable(this, t, this.A) {
                    final b a;
                    final String b;
                    final j c;
                    
                    @Override
                    public void run() {
                        try {
                            try {
                                final ListenableWorker.a h = (ListenableWorker.a)this.a.get();
                                if (h == null) {
                                    e1.h.c().b(f1.j.E, String.format("%s returned a null result. Treating it as a failure.", this.c.e.c), new Throwable[0]);
                                }
                                e1.h.c().a(f1.j.E, String.format("%s returned a %s result.", this.c.e.c, h), new Throwable[0]);
                                this.c.h = h;
                            }
                            finally {}
                        }
                        catch (final ExecutionException t) {
                            goto Label_0112;
                        }
                        catch (final InterruptedException ex) {}
                        catch (final CancellationException ex2) {
                            e1.h.c().d(f1.j.E, String.format("%s was cancelled", this.b), ex2);
                        }
                        this.c.f();
                        return;
                        this.c.f();
                    }
                }, this.g.c());
            }
            else {
                this.j();
            }
        }
        finally {
            this.p.endTransaction();
        }
    }
    
    private void m() {
        this.p.beginTransaction();
        try {
            this.w.b(WorkInfo.State.SUCCEEDED, this.b);
            this.w.p(this.b, ((ListenableWorker.a.c)this.h).e());
            final long currentTimeMillis = System.currentTimeMillis();
            for (final String s : this.x.a(this.b)) {
                if (this.w.f(s) == WorkInfo.State.BLOCKED && this.x.b(s)) {
                    e1.h.c().d(f1.j.E, String.format("Setting status to enqueued for %s", s), new Throwable[0]);
                    this.w.b(WorkInfo.State.ENQUEUED, s);
                    this.w.u(s, currentTimeMillis);
                }
            }
            this.p.setTransactionSuccessful();
        }
        finally {
            this.p.endTransaction();
            this.i(false);
        }
    }
    
    private boolean n() {
        if (this.D) {
            e1.h.c().a(f1.j.E, String.format("Work interrupted for %s", this.A), new Throwable[0]);
            final WorkInfo.State f = this.w.f(this.b);
            if (f == null) {
                this.i(false);
            }
            else {
                this.i(f.isFinished() ^ true);
            }
            return true;
        }
        return false;
    }
    
    private boolean o() {
        this.p.beginTransaction();
        try {
            final WorkInfo.State f = this.w.f(this.b);
            final WorkInfo.State enqueued = WorkInfo.State.ENQUEUED;
            boolean b = true;
            if (f == enqueued) {
                this.w.b(WorkInfo.State.RUNNING, this.b);
                this.w.t(this.b);
            }
            else {
                b = false;
            }
            this.p.setTransactionSuccessful();
            return b;
        }
        finally {
            this.p.endTransaction();
        }
    }
    
    public ListenableFuture<Boolean> b() {
        return (ListenableFuture<Boolean>)this.B;
    }
    
    public void d() {
        this.D = true;
        this.n();
        final ListenableFuture<ListenableWorker.a> c = this.C;
        boolean done;
        if (c != null) {
            done = ((Future)c).isDone();
            ((Future)this.C).cancel(true);
        }
        else {
            done = false;
        }
        final ListenableWorker f = this.f;
        if (f != null && !done) {
            f.stop();
        }
        else {
            e1.h.c().a(f1.j.E, String.format("WorkSpec %s is already done. Not interrupting.", this.e), new Throwable[0]);
        }
    }
    
    void f() {
        if (!this.n()) {
            this.p.beginTransaction();
            try {
                final WorkInfo.State f = this.w.f(this.b);
                this.p.k().a(this.b);
                if (f == null) {
                    this.i(false);
                }
                else if (f == WorkInfo.State.RUNNING) {
                    this.c(this.h);
                }
                else if (!f.isFinished()) {
                    this.g();
                }
                this.p.setTransactionSuccessful();
            }
            finally {
                this.p.endTransaction();
            }
        }
        final List<e> c = this.c;
        if (c != null) {
            final Iterator<e> iterator = c.iterator();
            while (iterator.hasNext()) {
                iterator.next().a(this.b);
            }
            f1.f.b(this.i, this.p, this.c);
        }
    }
    
    void l() {
        this.p.beginTransaction();
        try {
            this.e(this.b);
            this.w.p(this.b, ((ListenableWorker.a.a)this.h).e());
            this.p.setTransactionSuccessful();
        }
        finally {
            this.p.endTransaction();
            this.i(false);
        }
    }
    
    @Override
    public void run() {
        final List<String> b = this.y.b(this.b);
        this.z = b;
        this.A = this.a(b);
        this.k();
    }
    
    public static class c
    {
        Context a;
        ListenableWorker b;
        l1.a c;
        a d;
        androidx.work.a e;
        WorkDatabase f;
        String g;
        List<e> h;
        WorkerParameters.a i;
        
        public c(final Context context, final androidx.work.a e, final a d, final l1.a c, final WorkDatabase f, final String g) {
            this.i = new WorkerParameters.a();
            this.a = context.getApplicationContext();
            this.d = d;
            this.c = c;
            this.e = e;
            this.f = f;
            this.g = g;
        }
        
        public j a() {
            return new j(this);
        }
        
        public c b(final WorkerParameters.a i) {
            if (i != null) {
                this.i = i;
            }
            return this;
        }
        
        public c c(final List<e> h) {
            this.h = h;
            return this;
        }
    }
}
