// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import c2.b;
import u2.d;
import c2.e;

public class v<Model> implements n<Model, Model>
{
    private static final v<?> a;
    
    static {
        a = new v<Object>();
    }
    
    @Deprecated
    public v() {
    }
    
    public static <T> v<T> c() {
        return (v<T>)v.a;
    }
    
    @Override
    public boolean a(final Model model) {
        return true;
    }
    
    @Override
    public n.a<Model> b(final Model model, final int n, final int n2, final e e) {
        return (n.a<Model>)new n.a(new d(model), new b<Object>(model));
    }
    
    public static class a<Model> implements o<Model, Model>
    {
        private static final a<?> a;
        
        static {
            a = new a<Object>();
        }
        
        @Deprecated
        public a() {
        }
        
        public static <T> a<T> a() {
            return (a<T>)v.a.a;
        }
        
        @Override
        public n<Model, Model> b(final r r) {
            return (n<Model, Model>)v.c();
        }
    }
    
    private static class b<Model> implements d<Model>
    {
        private final Model a;
        
        b(final Model a) {
            this.a = a;
        }
        
        @Override
        public Class<Model> a() {
            return (Class<Model>)this.a.getClass();
        }
        
        @Override
        public void b() {
        }
        
        @Override
        public void cancel() {
        }
        
        @Override
        public DataSource d() {
            return DataSource.LOCAL;
        }
        
        @Override
        public void e(final Priority priority, final d.a<? super Model> a) {
            a.f(this.a);
        }
    }
}
