// 
// Decompiled by Procyon v0.6.0
// 

package r1;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import z1.c;
import java.util.List;

public abstract class a<K, A>
{
    final List<b> a;
    private boolean b;
    private final d<K> c;
    protected float d;
    protected z1.c<A> e;
    private A f;
    private float g;
    private float h;
    
    a(final List<? extends z1.a<K>> list) {
        this.a = new ArrayList<b>(1);
        this.b = false;
        this.d = 0.0f;
        this.f = null;
        this.g = -1.0f;
        this.h = -1.0f;
        this.c = o(list);
    }
    
    private float g() {
        if (this.g == -1.0f) {
            this.g = this.c.d();
        }
        return this.g;
    }
    
    private static <T> d<T> o(final List<? extends z1.a<T>> list) {
        if (list.isEmpty()) {
            return (d<T>)new c(null);
        }
        if (list.size() != 0) {
            return (d<T>)new f((List<? extends z1.a<Object>>)list);
        }
        return (d<T>)new e((List<? extends z1.a<Object>>)list);
    }
    
    public void a(final b b) {
        this.a.add(b);
    }
    
    protected z1.a<K> b() {
        com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        final z1.a<K> b = this.c.b();
        com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b;
    }
    
    float c() {
        if (this.h == -1.0f) {
            this.h = this.c.e();
        }
        return this.h;
    }
    
    protected float d() {
        final z1.a<K> b = this.b();
        if (b.h()) {
            return 0.0f;
        }
        return b.d.getInterpolation(this.e());
    }
    
    float e() {
        if (this.b) {
            return 0.0f;
        }
        final z1.a<K> b = this.b();
        if (b.h()) {
            return 0.0f;
        }
        return (this.d - b.e()) / (b.b() - b.e());
    }
    
    public float f() {
        return this.d;
    }
    
    public A h() {
        final float e = this.e();
        if (this.e == null && this.c.a(e)) {
            return this.f;
        }
        final z1.a<K> b = this.b();
        final Interpolator e2 = b.e;
        A f;
        if (e2 != null && b.f != null) {
            f = this.j(b, e, e2.getInterpolation(e), b.f.getInterpolation(e));
        }
        else {
            f = this.i(b, this.d());
        }
        return this.f = f;
    }
    
    abstract A i(final z1.a<K> p0, final float p1);
    
    protected A j(final z1.a<K> a, final float n, final float n2, final float n3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }
    
    public void k() {
        for (int i = 0; i < this.a.size(); ++i) {
            this.a.get(i).a();
        }
    }
    
    public void l() {
        this.b = true;
    }
    
    public void m(final float n) {
        if (this.c.isEmpty()) {
            return;
        }
        float d;
        if (n < this.g()) {
            d = this.g();
        }
        else {
            d = n;
            if (n > this.c()) {
                d = this.c();
            }
        }
        if (d == this.d) {
            return;
        }
        this.d = d;
        if (this.c.c(d)) {
            this.k();
        }
    }
    
    public void n(final z1.c<A> e) {
        final z1.c<A> e2 = this.e;
        if (e2 != null) {
            e2.c(null);
        }
        if ((this.e = e) != null) {
            e.c(this);
        }
    }
    
    public interface b
    {
        void a();
    }
    
    private static final class c<T> implements d<T>
    {
        private c() {
        }
        
        c(final a$a object) {
            this();
        }
        
        @Override
        public boolean a(final float n) {
            throw new IllegalStateException("not implemented");
        }
        
        @Override
        public z1.a<T> b() {
            throw new IllegalStateException("not implemented");
        }
        
        @Override
        public boolean c(final float n) {
            return false;
        }
        
        @Override
        public float d() {
            return 0.0f;
        }
        
        @Override
        public float e() {
            return 1.0f;
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }
    }
    
    private interface d<T>
    {
        boolean a(final float p0);
        
        z1.a<T> b();
        
        boolean c(final float p0);
        
        float d();
        
        float e();
        
        boolean isEmpty();
    }
    
    private static final class e<T> implements d<T>
    {
        private final List<? extends z1.a<T>> a;
        private z1.a<T> b;
        private z1.a<T> c;
        private float d;
        
        e(final List<? extends z1.a<T>> a) {
            this.c = null;
            this.d = -1.0f;
            this.a = a;
            this.b = this.f(0.0f);
        }
        
        private z1.a<T> f(final float n) {
            final List<? extends z1.a<T>> a = this.a;
            final z1.a a2 = a.get(a.size() - 1);
            if (n >= a2.e()) {
                return a2;
            }
            for (int i = this.a.size() - 2; i >= 1; --i) {
                final z1.a a3 = (z1.a)this.a.get(i);
                if (this.b != a3) {
                    if (a3.a(n)) {
                        return a3;
                    }
                }
            }
            return (z1.a)this.a.get(0);
        }
        
        @Override
        public boolean a(final float d) {
            final z1.a<T> c = this.c;
            final z1.a<T> b = this.b;
            if (c == b && this.d == d) {
                return true;
            }
            this.c = b;
            this.d = d;
            return false;
        }
        
        @Override
        public z1.a<T> b() {
            return this.b;
        }
        
        @Override
        public boolean c(final float n) {
            if (this.b.a(n)) {
                return this.b.h() ^ true;
            }
            this.b = this.f(n);
            return true;
        }
        
        @Override
        public float d() {
            return ((z1.a)this.a.get(0)).e();
        }
        
        @Override
        public float e() {
            final List<? extends z1.a<T>> a = this.a;
            return ((z1.a)a.get(a.size() - 1)).b();
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
    }
    
    private static final class f<T> implements d<T>
    {
        private final z1.a<T> a;
        private float b;
        
        f(final List<? extends z1.a<T>> list) {
            this.b = -1.0f;
            this.a = (z1.a)list.get(0);
        }
        
        @Override
        public boolean a(final float b) {
            if (this.b == b) {
                return true;
            }
            this.b = b;
            return false;
        }
        
        @Override
        public z1.a<T> b() {
            return this.a;
        }
        
        @Override
        public boolean c(final float n) {
            return this.a.h() ^ true;
        }
        
        @Override
        public float d() {
            return this.a.e();
        }
        
        @Override
        public float e() {
            return this.a.b();
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
