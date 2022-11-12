// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import android.os.Looper;
import android.os.Handler;
import java.util.Iterator;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class d<T>
{
    private static final Executor h;
    private final p a;
    final androidx.recyclerview.widget.c<T> b;
    Executor c;
    private final List<b<T>> d;
    private List<T> e;
    private List<T> f;
    int g;
    
    static {
        h = new c();
    }
    
    public d(final p a, final androidx.recyclerview.widget.c<T> b) {
        this.d = new CopyOnWriteArrayList<b<T>>();
        this.f = Collections.emptyList();
        this.a = a;
        this.b = b;
        if (b.c() != null) {
            this.c = b.c();
        }
        else {
            this.c = androidx.recyclerview.widget.d.h;
        }
    }
    
    private void d(final List<T> list, final Runnable runnable) {
        final Iterator<b<T>> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(list, this.f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }
    
    public void a(final b<T> b) {
        this.d.add(b);
    }
    
    public List<T> b() {
        return this.f;
    }
    
    void c(final List<T> e, final i.e e2, final Runnable runnable) {
        final List<T> f = this.f;
        this.e = e;
        this.f = Collections.unmodifiableList((List<? extends T>)e);
        e2.c(this.a);
        this.d(f, runnable);
    }
    
    public void e(final List<T> list) {
        this.f(list, null);
    }
    
    public void f(final List<T> e, final Runnable runnable) {
        final int g = this.g + 1;
        this.g = g;
        final List<T> e2 = this.e;
        if (e == e2) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        final List<T> f = this.f;
        if (e == null) {
            final int size = e2.size();
            this.e = null;
            this.f = Collections.emptyList();
            this.a.b(0, size);
            this.d(f, runnable);
            return;
        }
        if (e2 == null) {
            this.e = e;
            this.f = Collections.unmodifiableList((List<? extends T>)e);
            this.a.a(0, e.size());
            this.d(f, runnable);
            return;
        }
        this.b.a().execute(new Runnable(this, e2, e, g, runnable) {
            final List a;
            final List b;
            final int c;
            final Runnable d;
            final d e;
            
            @Override
            public void run() {
                this.e.c.execute(new Runnable(this, i.b((i.b)new i.b(this) {
                    final d$a a;
                    
                    @Override
                    public boolean a(final int n, final int n2) {
                        final T value = this.a.a.get(n);
                        final T value2 = this.a.b.get(n2);
                        if (value != null && value2 != null) {
                            return this.a.e.b.b().areContentsTheSame(value, value2);
                        }
                        if (value == null && value2 == null) {
                            return true;
                        }
                        throw new AssertionError();
                    }
                    
                    @Override
                    public boolean b(final int n, final int n2) {
                        final T value = this.a.a.get(n);
                        final T value2 = this.a.b.get(n2);
                        if (value != null && value2 != null) {
                            return this.a.e.b.b().areItemsTheSame(value, value2);
                        }
                        return value == null && value2 == null;
                    }
                    
                    @Override
                    public Object c(final int n, final int n2) {
                        final T value = this.a.a.get(n);
                        final T value2 = this.a.b.get(n2);
                        if (value != null && value2 != null) {
                            return this.a.e.b.b().getChangePayload(value, value2);
                        }
                        throw new AssertionError();
                    }
                    
                    @Override
                    public int d() {
                        return this.a.b.size();
                    }
                    
                    @Override
                    public int e() {
                        return this.a.a.size();
                    }
                })) {
                    final i.e a;
                    final d$a b;
                    
                    @Override
                    public void run() {
                        final Runnable b = this.b;
                        final d e = b.e;
                        if (e.g == b.c) {
                            e.c(b.b, this.a, b.d);
                        }
                    }
                });
            }
        });
    }
    
    public interface b<T>
    {
        void a(final List<T> p0, final List<T> p1);
    }
    
    private static class c implements Executor
    {
        final Handler a;
        
        c() {
            this.a = new Handler(Looper.getMainLooper());
        }
        
        @Override
        public void execute(final Runnable runnable) {
            this.a.post(runnable);
        }
    }
}
