// 
// Decompiled by Procyon v0.6.0
// 

package j1;

import java.util.Iterator;
import m1.p;
import java.util.ArrayList;
import k1.d;
import java.util.List;
import i1.a;

public abstract class c<T> implements i1.a<T>
{
    private final List<String> a;
    private T b;
    private d<T> c;
    private a d;
    
    c(final d<T> c) {
        this.a = new ArrayList<String>();
        this.c = c;
    }
    
    private void h(final a a, final T t) {
        if (!this.a.isEmpty()) {
            if (a != null) {
                if (t != null && !this.c(t)) {
                    a.a(this.a);
                }
                else {
                    a.b(this.a);
                }
            }
        }
    }
    
    @Override
    public void a(final T b) {
        this.b = b;
        this.h(this.d, b);
    }
    
    abstract boolean b(final p p0);
    
    abstract boolean c(final T p0);
    
    public boolean d(final String s) {
        final T b = this.b;
        return b != null && this.c(b) && this.a.contains(s);
    }
    
    public void e(final Iterable<p> iterable) {
        this.a.clear();
        for (final p p : iterable) {
            if (this.b(p)) {
                this.a.add(p.a);
            }
        }
        if (this.a.isEmpty()) {
            this.c.c(this);
        }
        else {
            this.c.a(this);
        }
        this.h(this.d, this.b);
    }
    
    public void f() {
        if (!this.a.isEmpty()) {
            this.a.clear();
            this.c.c(this);
        }
    }
    
    public void g(final a d) {
        if (this.d != d) {
            this.h(this.d = d, this.b);
        }
    }
    
    public interface a
    {
        void a(final List<String> p0);
        
        void b(final List<String> p0);
    }
}
