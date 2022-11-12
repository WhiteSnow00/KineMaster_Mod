// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import androidx.collection.d;

interface y
{
    d a();
    
    public static class a implements y
    {
        long a;
        
        public a() {
            this.a = 0L;
        }
        
        @Override
        public d a() {
            return new y.a.a();
        }
        
        long b() {
            final long a = this.a;
            this.a = 1L + a;
            return a;
        }
        
        class a implements d
        {
            private final androidx.collection.d<Long> a;
            final y.a b;
            
            a(final y.a b) {
                this.b = b;
                this.a = new androidx.collection.d<Long>();
            }
            
            @Override
            public long a(final long n) {
                Long value;
                if ((value = this.a.f(n)) == null) {
                    value = this.b.b();
                    this.a.l(n, value);
                }
                return value;
            }
        }
    }
    
    public static class b implements y
    {
        private final d a;
        
        public b() {
            this.a = new d() {
                final b a;
                
                @Override
                public long a(final long n) {
                    return -1L;
                }
            };
        }
        
        @Override
        public d a() {
            return this.a;
        }
    }
    
    public static class c implements y
    {
        private final d a;
        
        public c() {
            this.a = new d() {
                final c a;
                
                @Override
                public long a(final long n) {
                    return n;
                }
            };
        }
        
        @Override
        public d a() {
            return this.a;
        }
    }
    
    public interface d
    {
        long a(final long p0);
    }
}
