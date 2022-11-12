// 
// Decompiled by Procyon v0.6.0
// 

package androidx.coordinatorlayout.widget;

import java.util.List;
import androidx.core.util.f;
import java.util.HashSet;
import androidx.collection.g;
import java.util.ArrayList;
import androidx.core.util.e;

public final class a<T>
{
    private final e<ArrayList<T>> a;
    private final g<T, ArrayList<T>> b;
    private final ArrayList<T> c;
    private final HashSet<T> d;
    
    public a() {
        this.a = new f<ArrayList<T>>(10);
        this.b = new g<T, ArrayList<T>>();
        this.c = new ArrayList<T>();
        this.d = new HashSet<T>();
    }
    
    private void e(final T t, final ArrayList<T> list, final HashSet<T> set) {
        if (list.contains(t)) {
            return;
        }
        if (!set.contains(t)) {
            set.add(t);
            final ArrayList list2 = this.b.get(t);
            if (list2 != null) {
                for (int i = 0; i < list2.size(); ++i) {
                    this.e(list2.get(i), (ArrayList<Object>)list, (HashSet<Object>)set);
                }
            }
            set.remove(t);
            list.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }
    
    private ArrayList<T> f() {
        ArrayList list;
        if ((list = this.a.a()) == null) {
            list = new ArrayList();
        }
        return list;
    }
    
    private void k(final ArrayList<T> list) {
        list.clear();
        this.a.b(list);
    }
    
    public void a(final T t, final T t2) {
        if (this.b.containsKey(t) && this.b.containsKey(t2)) {
            ArrayList<T> f;
            if ((f = this.b.get(t)) == null) {
                f = this.f();
                this.b.put(t, f);
            }
            f.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }
    
    public void b(final T t) {
        if (!this.b.containsKey(t)) {
            this.b.put(t, null);
        }
    }
    
    public void c() {
        for (int size = this.b.size(), i = 0; i < size; ++i) {
            final ArrayList list = this.b.m(i);
            if (list != null) {
                this.k(list);
            }
        }
        this.b.clear();
    }
    
    public boolean d(final T t) {
        return this.b.containsKey(t);
    }
    
    public List g(final T t) {
        return this.b.get(t);
    }
    
    public List<T> h(final T t) {
        final int size = this.b.size();
        ArrayList<T> list = null;
        ArrayList<T> list3;
        for (int i = 0; i < size; ++i, list = list3) {
            final ArrayList list2 = this.b.m(i);
            list3 = list;
            if (list2 != null) {
                list3 = list;
                if (list2.contains(t)) {
                    if ((list3 = list) == null) {
                        list3 = new ArrayList<T>();
                    }
                    list3.add(this.b.i(i));
                }
            }
        }
        return list;
    }
    
    public ArrayList<T> i() {
        this.c.clear();
        this.d.clear();
        for (int size = this.b.size(), i = 0; i < size; ++i) {
            this.e(this.b.i(i), this.c, this.d);
        }
        return this.c;
    }
    
    public boolean j(final T t) {
        for (int size = this.b.size(), i = 0; i < size; ++i) {
            final ArrayList list = this.b.m(i);
            if (list != null && list.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
