// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.Collection;
import v2.k;
import com.bumptech.glide.Priority;
import java.util.Arrays;
import c2.b;
import com.bumptech.glide.load.data.d;
import java.util.ArrayList;
import java.util.Iterator;
import androidx.core.util.e;
import java.util.List;

class q<Model, Data> implements n<Model, Data>
{
    private final List<n<Model, Data>> a;
    private final e<List<Throwable>> b;
    
    q(final List<n<Model, Data>> a, final e<List<Throwable>> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean a(final Model model) {
        final Iterator<n<Model, Data>> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            if (((n<Model, Data>)iterator.next()).a(model)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public n.a<Data> b(final Model model, final int n, final int n2, final c2.e e) {
        final int size = this.a.size();
        final ArrayList list = new ArrayList(size);
        final n.a<Data> a = null;
        int i = 0;
        b b = null;
        while (i < size) {
            final n n3 = this.a.get(i);
            b a2 = b;
            if (n3.a(model)) {
                final n.a b2 = n3.b(model, n, n2, e);
                a2 = b;
                if (b2 != null) {
                    a2 = ((n.a)b2).a;
                    list.add((Object)((n.a)b2).c);
                }
            }
            ++i;
            b = a2;
        }
        Object o = a;
        if (!list.isEmpty()) {
            o = a;
            if (b != null) {
                o = new n.a(b, new a<Object>((List<d<Object>>)list, this.b));
            }
        }
        return (n.a<Data>)o;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MultiModelLoader{modelLoaders=");
        sb.append(Arrays.toString(this.a.toArray()));
        sb.append('}');
        return sb.toString();
    }
    
    static class a<Data> implements d<Data>, d.a<Data>
    {
        private final List<d<Data>> a;
        private final e<List<Throwable>> b;
        private int c;
        private Priority d;
        private d.a<? super Data> e;
        private List<Throwable> f;
        private boolean g;
        
        a(final List<d<Data>> a, final e<List<Throwable>> b) {
            this.b = b;
            k.c(a);
            this.a = a;
            this.c = 0;
        }
        
        private void g() {
            if (this.g) {
                return;
            }
            if (this.c < this.a.size() - 1) {
                ++this.c;
                this.e(this.d, this.e);
            }
            else {
                k.d(this.f);
                this.e.c(new GlideException("Fetch failed", new ArrayList<Throwable>(this.f)));
            }
        }
        
        @Override
        public Class<Data> a() {
            return this.a.get(0).a();
        }
        
        @Override
        public void b() {
            final List<Throwable> f = this.f;
            if (f != null) {
                this.b.b(f);
            }
            this.f = null;
            final Iterator<d<Data>> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().b();
            }
        }
        
        @Override
        public void c(final Exception ex) {
            k.d(this.f).add(ex);
            this.g();
        }
        
        @Override
        public void cancel() {
            this.g = true;
            final Iterator<d<Data>> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().cancel();
            }
        }
        
        @Override
        public DataSource d() {
            return this.a.get(0).d();
        }
        
        @Override
        public void e(final Priority d, final d.a<? super Data> e) {
            this.d = d;
            this.e = e;
            this.f = this.b.a();
            this.a.get(this.c).e(d, (d.a)this);
            if (this.g) {
                this.cancel();
            }
        }
        
        @Override
        public void f(final Data data) {
            if (data != null) {
                this.e.f(data);
            }
            else {
                this.g();
            }
        }
    }
}
