// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.List;
import android.util.SparseIntArray;
import android.util.SparseArray;

interface b0
{
    q a(final int p0);
    
    c b(final q p0);
    
    public static class a implements b0
    {
        SparseArray<q> a;
        int b;
        
        public a() {
            this.a = (SparseArray<q>)new SparseArray();
            this.b = 0;
        }
        
        @Override
        public q a(final int n) {
            final q q = (q)this.a.get(n);
            if (q != null) {
                return q;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot find the wrapper for global view type ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        
        @Override
        public c b(final q q) {
            return new b0.a.a(q);
        }
        
        int c(final q q) {
            final int n = this.b++;
            this.a.put(n, (Object)q);
            return n;
        }
        
        class a implements c
        {
            private SparseIntArray a;
            private SparseIntArray b;
            final q c;
            final b0.a d;
            
            a(final b0.a d, final q c) {
                this.d = d;
                this.a = new SparseIntArray(1);
                this.b = new SparseIntArray(1);
                this.c = c;
            }
            
            @Override
            public int a(final int n) {
                final int indexOfKey = this.b.indexOfKey(n);
                if (indexOfKey >= 0) {
                    return this.b.valueAt(indexOfKey);
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("requested global type ");
                sb.append(n);
                sb.append(" does not belong to the adapter:");
                sb.append(this.c.c);
                throw new IllegalStateException(sb.toString());
            }
            
            @Override
            public int b(final int n) {
                final int indexOfKey = this.a.indexOfKey(n);
                if (indexOfKey > -1) {
                    return this.a.valueAt(indexOfKey);
                }
                final int c = this.d.c(this.c);
                this.a.put(n, c);
                this.b.put(c, n);
                return c;
            }
        }
    }
    
    public static class b implements b0
    {
        SparseArray<List<q>> a;
        
        public b() {
            this.a = (SparseArray<List<q>>)new SparseArray();
        }
        
        @Override
        public q a(final int n) {
            final List list = (List)this.a.get(n);
            if (list != null && !list.isEmpty()) {
                return (q)list.get(0);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot find the wrapper for global view type ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
        
        @Override
        public c b(final q q) {
            return new a(q);
        }
        
        class a implements c
        {
            final q a;
            final b b;
            
            a(final b b, final q a) {
                this.b = b;
                this.a = a;
            }
            
            @Override
            public int a(final int n) {
                return n;
            }
            
            @Override
            public int b(final int n) {
                List list;
                if ((list = (List)this.b.a.get(n)) == null) {
                    list = new ArrayList();
                    this.b.a.put(n, (Object)list);
                }
                if (!list.contains(this.a)) {
                    list.add(this.a);
                }
                return n;
            }
        }
    }
    
    public interface c
    {
        int a(final int p0);
        
        int b(final int p0);
    }
}
