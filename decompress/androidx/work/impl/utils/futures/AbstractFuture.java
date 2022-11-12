// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work.impl.utils.futures;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeoutException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.Executor;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Logger;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class AbstractFuture<V> implements ListenableFuture<V>
{
    static final boolean d;
    private static final Logger e;
    static final b f;
    private static final Object g;
    volatile Object a;
    volatile d b;
    volatile h c;
    
    static {
        d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        e = Logger.getLogger(AbstractFuture.class.getName());
        g f2;
        try {
            final e e2 = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), (AtomicReferenceFieldUpdater<AbstractFuture, h>)AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, h.class, "c"), (AtomicReferenceFieldUpdater<AbstractFuture, d>)AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "b"), (AtomicReferenceFieldUpdater<AbstractFuture, Object>)AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
        }
        finally {
            f2 = new g();
        }
        f = (b)f2;
        final Throwable t;
        if (t != null) {
            AbstractFuture.e.log(Level.SEVERE, "SafeAtomicHelper is broken!", t);
        }
        g = new Object();
    }
    
    protected AbstractFuture() {
    }
    
    private void a(final StringBuilder sb) {
        try {
            final Object k = k((Future<Object>)this);
            sb.append("SUCCESS, result=[");
            sb.append(this.s(k));
            sb.append("]");
        }
        catch (final RuntimeException ex) {
            sb.append("UNKNOWN, cause=[");
            sb.append(ex.getClass());
            sb.append(" thrown from get()]");
        }
        catch (final CancellationException ex2) {
            sb.append("CANCELLED");
        }
        catch (final ExecutionException ex3) {
            sb.append("FAILURE, cause=[");
            sb.append(ex3.getCause());
            sb.append("]");
        }
    }
    
    private static CancellationException c(final String s, final Throwable t) {
        final CancellationException ex = new CancellationException(s);
        ex.initCause(t);
        return ex;
    }
    
    static <T> T d(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    private d e(d d) {
        d b;
        do {
            b = this.b;
        } while (!AbstractFuture.f.a(this, b, AbstractFuture.d.d));
        d c = d;
        d c2;
        for (d = b; d != null; d = c2) {
            c2 = d.c;
            d.c = c;
            c = d;
        }
        return c;
    }
    
    static void g(AbstractFuture<?> abstractFuture) {
        d d = null;
    Label_0002:
        while (true) {
            abstractFuture.n();
            abstractFuture.b();
            d c;
            for (d e = abstractFuture.e(d); e != null; e = c) {
                c = e.c;
                final Runnable a = e.a;
                if (a instanceof f) {
                    final f f = (f)a;
                    final AbstractFuture<V> a2 = f.a;
                    if (a2.a == f && AbstractFuture.f.b(a2, f, j(f.b))) {
                        d = c;
                        abstractFuture = a2;
                        continue Label_0002;
                    }
                }
                else {
                    h(a, e.b);
                }
            }
            break;
        }
    }
    
    private static void h(final Runnable runnable, final Executor executor) {
        try {
            executor.execute(runnable);
        }
        catch (final RuntimeException ex) {
            final Logger e = AbstractFuture.e;
            final Level severe = Level.SEVERE;
            final StringBuilder sb = new StringBuilder();
            sb.append("RuntimeException while executing runnable ");
            sb.append(runnable);
            sb.append(" with executor ");
            sb.append(executor);
            e.log(severe, sb.toString(), ex);
        }
    }
    
    private V i(final Object o) throws ExecutionException {
        if (o instanceof c) {
            throw c("Task was cancelled.", ((c)o).b);
        }
        if (!(o instanceof Failure)) {
            Object o2;
            if ((o2 = o) == AbstractFuture.g) {
                o2 = null;
            }
            return (V)o2;
        }
        throw new ExecutionException(((Failure)o).a);
    }
    
    static Object j(final ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object o2;
            final Object o = o2 = ((AbstractFuture)listenableFuture).a;
            if (o instanceof c) {
                final c c = (c)o;
                o2 = o;
                if (c.a) {
                    if (c.b != null) {
                        o2 = new c(false, c.b);
                    }
                    else {
                        o2 = AbstractFuture.c.d;
                    }
                }
            }
            return o2;
        }
        final boolean cancelled = ((Future)listenableFuture).isCancelled();
        if ((AbstractFuture.d ^ true) & cancelled) {
            return c.d;
        }
        try {
            Object o3;
            if ((o3 = k((Future<Object>)listenableFuture)) == null) {
                o3 = AbstractFuture.g;
            }
            return o3;
        }
        catch (final CancellationException ex) {
            if (!cancelled) {
                final StringBuilder sb = new StringBuilder();
                sb.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb.append(listenableFuture);
                return new Failure(new IllegalArgumentException(sb.toString(), ex));
            }
            return new c(false, ex);
        }
        catch (final ExecutionException ex2) {
            return new Failure(ex2.getCause());
        }
        finally {
            final Throwable t;
            return new Failure(t);
        }
    }
    
    private static <V> V k(final Future<V> future) throws ExecutionException {
        boolean b = false;
        try {
            return future.get();
        }
        catch (final InterruptedException ex) {
            b = true;
            return future.get();
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    private void n() {
        h h;
        do {
            h = this.c;
        } while (!AbstractFuture.f.c(this, h, AbstractFuture.h.c));
        while (h != null) {
            h.b();
            h = h.b;
        }
    }
    
    private void o(h c) {
        c.a = null;
    Label_0005:
        while (true) {
            c = this.c;
            if (c == h.c) {
                return;
            }
            h h = null;
            while (c != null) {
                final h b = c.b;
                h h2;
                if (c.a != null) {
                    h2 = c;
                }
                else if (h != null) {
                    h.b = b;
                    h2 = h;
                    if (h.a == null) {
                        continue Label_0005;
                    }
                }
                else {
                    h2 = h;
                    if (!AbstractFuture.f.c(this, c, b)) {
                        continue Label_0005;
                    }
                }
                c = b;
                h = h2;
            }
        }
    }
    
    private String s(final Object o) {
        if (o == this) {
            return "this future";
        }
        return String.valueOf(o);
    }
    
    protected void b() {
    }
    
    public final boolean cancel(final boolean b) {
        Object o = this.a;
        final boolean b2 = true;
        boolean b3;
        if (o == null | o instanceof f) {
            c c;
            if (AbstractFuture.d) {
                c = new c(b, new CancellationException("Future.cancel() was called."));
            }
            else if (b) {
                c = AbstractFuture.c.c;
            }
            else {
                c = AbstractFuture.c.d;
            }
            AbstractFuture<? extends V> abstractFuture = (AbstractFuture<? extends V>)this;
            b3 = false;
            while (true) {
                if (AbstractFuture.f.b(abstractFuture, o, c)) {
                    if (b) {
                        abstractFuture.l();
                    }
                    g(abstractFuture);
                    b3 = b2;
                    if (!(o instanceof f)) {
                        break;
                    }
                    final ListenableFuture<? extends V> b4 = ((f)o).b;
                    if (!(b4 instanceof AbstractFuture)) {
                        ((Future)b4).cancel(b);
                        b3 = b2;
                        break;
                    }
                    abstractFuture = (AbstractFuture<? extends V>)b4;
                    o = abstractFuture.a;
                    final boolean b5 = o == null;
                    b3 = b2;
                    if (!(b5 | o instanceof f)) {
                        break;
                    }
                    b3 = true;
                }
                else {
                    if (!((o = abstractFuture.a) instanceof f)) {
                        break;
                    }
                    continue;
                }
            }
        }
        else {
            b3 = false;
        }
        return b3;
    }
    
    public final void f(final Runnable runnable, final Executor executor) {
        d(runnable);
        d(executor);
        d c = this.b;
        if (c != AbstractFuture.d.d) {
            final d d = new d(runnable, executor);
            do {
                d.c = c;
                if (AbstractFuture.f.a(this, c, d)) {
                    return;
                }
            } while ((c = this.b) != AbstractFuture.d.d);
        }
        h(runnable, executor);
    }
    
    public final V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        final Object a = this.a;
        if (a != null & (a instanceof f ^ true)) {
            return this.i(a);
        }
        h h = this.c;
        if (h != AbstractFuture.h.c) {
            final h h2 = new h();
            do {
                h2.a(h);
                if (AbstractFuture.f.c(this, h, h2)) {
                    Object a2;
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            this.o(h2);
                            throw new InterruptedException();
                        }
                        a2 = this.a;
                    } while (!(a2 != null & (a2 instanceof f ^ true)));
                    return this.i(a2);
                }
            } while ((h = this.c) != AbstractFuture.h.c);
        }
        return this.i(this.a);
    }
    
    public final V get(long convert, final TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(convert);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        final Object a = this.a;
        if (a != null & (a instanceof f ^ true)) {
            return this.i(a);
        }
        long n;
        if (nanos > 0L) {
            n = System.nanoTime() + nanos;
        }
        else {
            n = 0L;
        }
        long n2 = nanos;
        Label_0254: {
            if (nanos >= 1000L) {
                h h = this.c;
                if (h != AbstractFuture.h.c) {
                    final h h2 = new h();
                    do {
                        h2.a(h);
                        if (AbstractFuture.f.c(this, h, h2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (Thread.interrupted()) {
                                    this.o(h2);
                                    throw new InterruptedException();
                                }
                                final Object a2 = this.a;
                                if (a2 != null & (a2 instanceof f ^ true)) {
                                    return this.i(a2);
                                }
                                n2 = (nanos = n - System.nanoTime());
                            } while (n2 >= 1000L);
                            this.o(h2);
                            break Label_0254;
                        }
                    } while ((h = this.c) != AbstractFuture.h.c);
                }
                return this.i(this.a);
            }
        }
        while (n2 > 0L) {
            final Object a3 = this.a;
            if (a3 != null & (a3 instanceof f ^ true)) {
                return this.i(a3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            n2 = n - System.nanoTime();
        }
        final String string = this.toString();
        final String string2 = timeUnit.toString();
        final Locale root = Locale.ROOT;
        final String lowerCase = string2.toLowerCase(root);
        final StringBuilder sb = new StringBuilder();
        sb.append("Waited ");
        sb.append(convert);
        sb.append(" ");
        sb.append(timeUnit.toString().toLowerCase(root));
        String s2;
        final String s = s2 = sb.toString();
        if (n2 + 1000L < 0L) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(" (plus ");
            final String string3 = sb2.toString();
            final long n3 = -n2;
            convert = timeUnit.convert(n3, TimeUnit.NANOSECONDS);
            final long n4 = n3 - timeUnit.toNanos(convert);
            final long n5 = lcmp(convert, 0L);
            final boolean b = n5 == 0 || n4 > 1000L;
            String string4 = string3;
            if (n5 > 0) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string3);
                sb3.append(convert);
                sb3.append(" ");
                sb3.append(lowerCase);
                String s3 = sb3.toString();
                if (b) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append(s3);
                    sb4.append(",");
                    s3 = sb4.toString();
                }
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(s3);
                sb5.append(" ");
                string4 = sb5.toString();
            }
            String string5 = string4;
            if (b) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append(string4);
                sb6.append(n4);
                sb6.append(" nanoseconds ");
                string5 = sb6.toString();
            }
            final StringBuilder sb7 = new StringBuilder();
            sb7.append(string5);
            sb7.append("delay)");
            s2 = sb7.toString();
        }
        if (this.isDone()) {
            final StringBuilder sb8 = new StringBuilder();
            sb8.append(s2);
            sb8.append(" but future completed as timeout expired");
            throw new TimeoutException(sb8.toString());
        }
        final StringBuilder sb9 = new StringBuilder();
        sb9.append(s2);
        sb9.append(" for ");
        sb9.append(string);
        throw new TimeoutException(sb9.toString());
    }
    
    public final boolean isCancelled() {
        return this.a instanceof c;
    }
    
    public final boolean isDone() {
        final Object a = this.a;
        return (a instanceof f ^ true) & a != null;
    }
    
    protected void l() {
    }
    
    protected String m() {
        final Object a = this.a;
        if (a instanceof f) {
            final StringBuilder sb = new StringBuilder();
            sb.append("setFuture=[");
            sb.append(this.s(((f)a).b));
            sb.append("]");
            return sb.toString();
        }
        if (this instanceof ScheduledFuture) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("remaining delay=[");
            sb2.append(((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS));
            sb2.append(" ms]");
            return sb2.toString();
        }
        return null;
    }
    
    protected boolean p(final V v) {
        Object g = v;
        if (v == null) {
            g = AbstractFuture.g;
        }
        if (AbstractFuture.f.b(this, null, g)) {
            g(this);
            return true;
        }
        return false;
    }
    
    protected boolean q(final Throwable t) {
        if (AbstractFuture.f.b(this, null, new Failure(d(t)))) {
            g(this);
            return true;
        }
        return false;
    }
    
    protected boolean r(final ListenableFuture<? extends V> listenableFuture) {
        d(listenableFuture);
        Object o;
        if ((o = this.a) == null) {
            if (((Future)listenableFuture).isDone()) {
                if (AbstractFuture.f.b(this, null, j(listenableFuture))) {
                    g(this);
                    return true;
                }
                return false;
            }
            else {
                final f f = new f((AbstractFuture<V>)this, (ListenableFuture<? extends V>)listenableFuture);
                if (AbstractFuture.f.b(this, null, f)) {
                    try {
                        listenableFuture.f((Runnable)f, (Executor)DirectExecutor.INSTANCE);
                    }
                    finally {
                        Failure b = null;
                        try {
                            final Throwable t;
                            final Failure failure = new Failure(t);
                        }
                        finally {
                            b = Failure.b;
                        }
                        AbstractFuture.f.b(this, f, b);
                    }
                    return true;
                }
                o = this.a;
            }
        }
        if (o instanceof c) {
            ((Future)listenableFuture).cancel(((c)o).a);
        }
        return false;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.isCancelled()) {
            sb.append("CANCELLED");
        }
        else if (this.isDone()) {
            this.a(sb);
        }
        else {
            String s;
            try {
                s = this.m();
            }
            catch (final RuntimeException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Exception thrown from implementation: ");
                sb2.append(ex.getClass());
                s = sb2.toString();
            }
            if (s != null && !s.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(s);
                sb.append("]");
            }
            else if (this.isDone()) {
                this.a(sb);
            }
            else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    private static final class Failure
    {
        static final Failure b;
        final Throwable a;
        
        static {
            b = new Failure(new Throwable() {
                @Override
                public Throwable fillInStackTrace() {
                    monitorenter(this);
                    monitorexit(this);
                    return this;
                }
            });
        }
        
        Failure(final Throwable t) {
            this.a = AbstractFuture.d(t);
        }
    }
    
    private abstract static class b
    {
        private b() {
        }
        
        b(final AbstractFuture$a object) {
            this();
        }
        
        abstract boolean a(final AbstractFuture<?> p0, final d p1, final d p2);
        
        abstract boolean b(final AbstractFuture<?> p0, final Object p1, final Object p2);
        
        abstract boolean c(final AbstractFuture<?> p0, final h p1, final h p2);
        
        abstract void d(final h p0, final h p1);
        
        abstract void e(final h p0, final Thread p1);
    }
    
    private static final class c
    {
        static final c c;
        static final c d;
        final boolean a;
        final Throwable b;
        
        static {
            if (AbstractFuture.d) {
                d = null;
                c = null;
            }
            else {
                d = new c(false, null);
                c = new c(true, null);
            }
        }
        
        c(final boolean a, final Throwable b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static final class d
    {
        static final d d;
        final Runnable a;
        final Executor b;
        d c;
        
        static {
            d = new d(null, null);
        }
        
        d(final Runnable a, final Executor b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static final class e extends b
    {
        final AtomicReferenceFieldUpdater<h, Thread> a;
        final AtomicReferenceFieldUpdater<h, h> b;
        final AtomicReferenceFieldUpdater<AbstractFuture, h> c;
        final AtomicReferenceFieldUpdater<AbstractFuture, d> d;
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> e;
        
        e(final AtomicReferenceFieldUpdater<h, Thread> a, final AtomicReferenceFieldUpdater<h, h> b, final AtomicReferenceFieldUpdater<AbstractFuture, h> c, final AtomicReferenceFieldUpdater<AbstractFuture, d> d, final AtomicReferenceFieldUpdater<AbstractFuture, Object> e) {
            super(null);
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        @Override
        boolean a(final AbstractFuture<?> abstractFuture, final d d, final d d2) {
            return androidx.work.impl.utils.futures.a.a(this.d, abstractFuture, d, d2);
        }
        
        @Override
        boolean b(final AbstractFuture<?> abstractFuture, final Object o, final Object o2) {
            return androidx.work.impl.utils.futures.a.a(this.e, abstractFuture, o, o2);
        }
        
        @Override
        boolean c(final AbstractFuture<?> abstractFuture, final h h, final h h2) {
            return androidx.work.impl.utils.futures.a.a(this.c, abstractFuture, h, h2);
        }
        
        @Override
        void d(final h h, final h h2) {
            this.b.lazySet(h, h2);
        }
        
        @Override
        void e(final h h, final Thread thread) {
            this.a.lazySet(h, thread);
        }
    }
    
    private static final class f<V> implements Runnable
    {
        final AbstractFuture<V> a;
        final ListenableFuture<? extends V> b;
        
        f(final AbstractFuture<V> a, final ListenableFuture<? extends V> b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void run() {
            if (this.a.a != this) {
                return;
            }
            if (AbstractFuture.f.b(this.a, this, AbstractFuture.j(this.b))) {
                AbstractFuture.g(this.a);
            }
        }
    }
    
    private static final class g extends b
    {
        g() {
            super(null);
        }
        
        @Override
        boolean a(final AbstractFuture<?> abstractFuture, final d d, final d b) {
            synchronized (abstractFuture) {
                if (abstractFuture.b == d) {
                    abstractFuture.b = b;
                    return true;
                }
                return false;
            }
        }
        
        @Override
        boolean b(final AbstractFuture<?> abstractFuture, final Object o, final Object a) {
            synchronized (abstractFuture) {
                if (abstractFuture.a == o) {
                    abstractFuture.a = a;
                    return true;
                }
                return false;
            }
        }
        
        @Override
        boolean c(final AbstractFuture<?> abstractFuture, final h h, final h c) {
            synchronized (abstractFuture) {
                if (abstractFuture.c == h) {
                    abstractFuture.c = c;
                    return true;
                }
                return false;
            }
        }
        
        @Override
        void d(final h h, final h b) {
            h.b = b;
        }
        
        @Override
        void e(final h h, final Thread a) {
            h.a = a;
        }
    }
    
    private static final class h
    {
        static final h c;
        volatile Thread a;
        volatile h b;
        
        static {
            c = new h(false);
        }
        
        h() {
            AbstractFuture.f.e(this, Thread.currentThread());
        }
        
        h(final boolean b) {
        }
        
        void a(final h h) {
            AbstractFuture.f.d(this, h);
        }
        
        void b() {
            final Thread a = this.a;
            if (a != null) {
                this.a = null;
                LockSupport.unpark(a);
            }
        }
    }
}
