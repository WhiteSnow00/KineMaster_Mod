// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import java.util.Collection;
import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.Path;
import java.util.Map;

public final class ImmutableTree<T> implements Iterable<Map.Entry<Path, T>>
{
    private static final ImmutableSortedMap c;
    private static final ImmutableTree d;
    private final T a;
    private final ImmutableSortedMap<ChildKey, ImmutableTree<T>> b;
    
    static {
        d = new ImmutableTree(null, c = ImmutableSortedMap.Builder.c(StandardComparator.b(ChildKey.class)));
    }
    
    public ImmutableTree(final T t) {
        this(t, ImmutableTree.c);
    }
    
    public ImmutableTree(final T a, final ImmutableSortedMap<ChildKey, ImmutableTree<T>> b) {
        this.a = a;
        this.b = b;
    }
    
    public static <V> ImmutableTree<V> b() {
        return ImmutableTree.d;
    }
    
    private <R> R g(final Path path, final TreeVisitor<? super T, R> treeVisitor, R g) {
        for (final Map.Entry<K, ImmutableTree> entry : this.b) {
            g = (R)entry.getValue().g(path.n((ChildKey)entry.getKey()), treeVisitor, g);
        }
        final T a = this.a;
        R a2 = g;
        if (a != null) {
            a2 = treeVisitor.a(path, a, g);
        }
        return a2;
    }
    
    public boolean a(final Predicate<? super T> predicate) {
        final T a = this.a;
        if (a != null && predicate.a(a)) {
            return true;
        }
        final Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            if (((Map.Entry<K, ImmutableTree>)iterator.next()).getValue().a(predicate)) {
                return true;
            }
        }
        return false;
    }
    
    public Path e(Path e, final Predicate<? super T> predicate) {
        final T a = this.a;
        if (a != null && predicate.a(a)) {
            return Path.s();
        }
        if (e.isEmpty()) {
            return null;
        }
        final ChildKey t = e.t();
        final ImmutableTree immutableTree = this.b.b(t);
        if (immutableTree != null) {
            e = immutableTree.e(e.y(), predicate);
            if (e != null) {
                return new Path(new ChildKey[] { t }).m(e);
            }
        }
        return null;
    }
    
    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a != null && ImmutableTree.class == a.getClass()) {
            final ImmutableTree immutableTree = (ImmutableTree)a;
            final ImmutableSortedMap<ChildKey, ImmutableTree<T>> b = this.b;
            Label_0060: {
                if (b != null) {
                    if (b.equals(immutableTree.b)) {
                        break Label_0060;
                    }
                }
                else if (immutableTree.b == null) {
                    break Label_0060;
                }
                return false;
            }
            final T a2 = this.a;
            a = immutableTree.a;
            if (a2 != null) {
                if (a2.equals(a)) {
                    return true;
                }
            }
            else if (a == null) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public Path f(final Path path) {
        return this.e(path, Predicate.a);
    }
    
    public T getValue() {
        return this.a;
    }
    
    @Override
    public int hashCode() {
        final T a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a != null) {
            hashCode2 = a.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final ImmutableSortedMap<ChildKey, ImmutableTree<T>> b = this.b;
        if (b != null) {
            hashCode = b.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    public boolean isEmpty() {
        return this.a == null && this.b.isEmpty();
    }
    
    @Override
    public Iterator<Map.Entry<Path, T>> iterator() {
        final ArrayList list = new ArrayList();
        this.m((TreeVisitor<T, Void>)new TreeVisitor<T, Void>(this, list) {
            final List a;
            final ImmutableTree b;
            
            @Override
            public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                return this.b(path, o, (Void)o2);
            }
            
            public Void b(final Path path, final T t, final Void void1) {
                this.a.add(new AbstractMap.SimpleImmutableEntry<Path, T>(path, t));
                return null;
            }
        });
        return list.iterator();
    }
    
    public <R> R k(final R r, final TreeVisitor<? super T, R> treeVisitor) {
        return this.g(Path.s(), treeVisitor, r);
    }
    
    public void m(final TreeVisitor<T, Void> treeVisitor) {
        this.g(Path.s(), (TreeVisitor<? super T, Object>)treeVisitor, null);
    }
    
    public T n(final Path path) {
        if (path.isEmpty()) {
            return this.a;
        }
        final ImmutableTree immutableTree = this.b.b(path.t());
        if (immutableTree != null) {
            return (T)immutableTree.n(path.y());
        }
        return null;
    }
    
    public ImmutableTree<T> o(final ChildKey childKey) {
        final ImmutableTree immutableTree = this.b.b(childKey);
        if (immutableTree != null) {
            return immutableTree;
        }
        return b();
    }
    
    public ImmutableSortedMap<ChildKey, ImmutableTree<T>> p() {
        return this.b;
    }
    
    public T q(final Path path) {
        return this.s(path, Predicate.a);
    }
    
    public T s(final Path path, final Predicate<? super T> predicate) {
        final T a = this.a;
        T t;
        if (a != null && predicate.a(a)) {
            t = this.a;
        }
        else {
            t = null;
        }
        final Iterator<ChildKey> iterator = path.iterator();
        ImmutableTree immutableTree = this;
        while (iterator.hasNext()) {
            final ImmutableTree immutableTree2 = immutableTree.b.b(iterator.next());
            if (immutableTree2 == null) {
                return t;
            }
            final T a2 = immutableTree2.a;
            immutableTree = immutableTree2;
            if (a2 == null) {
                continue;
            }
            immutableTree = immutableTree2;
            if (!predicate.a(a2)) {
                continue;
            }
            t = immutableTree2.a;
            immutableTree = immutableTree2;
        }
        return t;
    }
    
    public ImmutableTree<T> t(final Path path) {
        if (path.isEmpty()) {
            if (this.b.isEmpty()) {
                return b();
            }
            return new ImmutableTree<T>(null, this.b);
        }
        else {
            final ChildKey t = path.t();
            final ImmutableTree immutableTree = this.b.b(t);
            if (immutableTree == null) {
                return this;
            }
            final ImmutableTree t2 = immutableTree.t(path.y());
            Iterable<Map.Entry<K, V>> iterable;
            if (t2.isEmpty()) {
                iterable = (Iterable<Map.Entry<K, V>>)this.b.o(t);
            }
            else {
                iterable = (Iterable<Map.Entry<K, V>>)this.b.n(t, t2);
            }
            if (this.a == null && ((ImmutableSortedMap)iterable).isEmpty()) {
                return b();
            }
            return new ImmutableTree<T>(this.a, (ImmutableSortedMap<ChildKey, ImmutableTree<Object>>)iterable);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ImmutableTree { value=");
        sb.append(this.getValue());
        sb.append(", children={");
        for (final Map.Entry<ChildKey, V> entry : this.b) {
            sb.append(entry.getKey().c());
            sb.append("=");
            sb.append(entry.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }
    
    public T v(final Path path, final Predicate<? super T> predicate) {
        final T a = this.a;
        if (a != null && predicate.a(a)) {
            return this.a;
        }
        final Iterator<ChildKey> iterator = path.iterator();
        ImmutableTree immutableTree = this;
        while (iterator.hasNext()) {
            final ImmutableTree immutableTree2 = immutableTree.b.b(iterator.next());
            if (immutableTree2 == null) {
                return null;
            }
            final T a2 = immutableTree2.a;
            immutableTree = immutableTree2;
            if (a2 == null) {
                continue;
            }
            immutableTree = immutableTree2;
            if (predicate.a(a2)) {
                return immutableTree2.a;
            }
        }
        return null;
    }
    
    public ImmutableTree<T> w(final Path path, final T t) {
        if (path.isEmpty()) {
            return new ImmutableTree<T>(t, this.b);
        }
        final ChildKey t2 = path.t();
        ImmutableTree<Object> b;
        if ((b = (ImmutableTree)this.b.b(t2)) == null) {
            b = b();
        }
        return new ImmutableTree<T>(this.a, (ImmutableSortedMap<ChildKey, ImmutableTree<Object>>)this.b.n(t2, (ImmutableTree<T>)b.w(path.y(), t)));
    }
    
    public ImmutableTree<T> x(final Path path, final ImmutableTree<T> immutableTree) {
        if (path.isEmpty()) {
            return immutableTree;
        }
        final ChildKey t = path.t();
        ImmutableTree<Object> b;
        if ((b = (ImmutableTree)this.b.b(t)) == null) {
            b = b();
        }
        final ImmutableTree<Object> x = b.x(path.y(), (ImmutableTree<Object>)immutableTree);
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap;
        if (x.isEmpty()) {
            immutableSortedMap = this.b.o(t);
        }
        else {
            immutableSortedMap = this.b.n(t, (ImmutableTree<T>)x);
        }
        return new ImmutableTree<T>(this.a, (ImmutableSortedMap<ChildKey, ImmutableTree<Object>>)immutableSortedMap);
    }
    
    public ImmutableTree<T> y(final Path path) {
        if (path.isEmpty()) {
            return this;
        }
        final ImmutableTree immutableTree = this.b.b(path.t());
        if (immutableTree != null) {
            return immutableTree.y(path.y());
        }
        return b();
    }
    
    public Collection<T> z() {
        final ArrayList list = new ArrayList();
        this.m((TreeVisitor<T, Void>)new TreeVisitor<T, Void>(this, list) {
            final ArrayList a;
            final ImmutableTree b;
            
            @Override
            public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                return this.b(path, o, (Void)o2);
            }
            
            public Void b(final Path path, final T t, final Void void1) {
                this.a.add(t);
                return null;
            }
        });
        return list;
    }
    
    public interface TreeVisitor<T, R>
    {
        R a(final Path p0, final T p1, final R p2);
    }
}
