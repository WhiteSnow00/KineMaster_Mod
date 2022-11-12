// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Predicate;

public class PruneForest
{
    private static final Predicate<Boolean> b;
    private static final Predicate<Boolean> c;
    private static final ImmutableTree<Boolean> d;
    private static final ImmutableTree<Boolean> e;
    private final ImmutableTree<Boolean> a;
    
    static {
        b = new Predicate<Boolean>() {
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.b((Boolean)o);
            }
            
            public boolean b(final Boolean b) {
                return b ^ true;
            }
        };
        c = new Predicate<Boolean>() {
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.b((Boolean)o);
            }
            
            public boolean b(final Boolean b) {
                return b;
            }
        };
        d = new ImmutableTree<Boolean>(Boolean.TRUE);
        e = new ImmutableTree<Boolean>(Boolean.FALSE);
    }
    
    public PruneForest() {
        this.a = ImmutableTree.b();
    }
    
    private PruneForest(final ImmutableTree<Boolean> a) {
        this.a = a;
    }
    
    public PruneForest a(final ChildKey childKey) {
        final ImmutableTree<Boolean> o = this.a.o(childKey);
        ImmutableTree<Boolean> w;
        if (o == null) {
            w = new ImmutableTree<Boolean>(this.a.getValue());
        }
        else {
            w = o;
            if (o.getValue() == null) {
                w = o;
                if (this.a.getValue() != null) {
                    w = o.w(Path.s(), this.a.getValue());
                }
            }
        }
        return new PruneForest(w);
    }
    
    public <T> T b(final T t, final ImmutableTree.TreeVisitor<Void, T> treeVisitor) {
        return this.a.k(t, (ImmutableTree.TreeVisitor<? super Boolean, T>)new ImmutableTree.TreeVisitor<Boolean, T>(this, treeVisitor) {
            final TreeVisitor a;
            final PruneForest b;
            
            @Override
            public /* bridge */ Object a(final Path path, final Object o, final Object o2) {
                return this.b(path, (Boolean)o, o2);
            }
            
            public T b(final Path path, final Boolean b, final T t) {
                if (!b) {
                    return this.a.a(path, null, t);
                }
                return t;
            }
        });
    }
    
    public PruneForest c(final Path path) {
        if (this.a.v(path, PruneForest.b) != null) {
            return this;
        }
        return new PruneForest(this.a.x(path, PruneForest.e));
    }
    
    public PruneForest d(final Path path) {
        if (this.a.v(path, PruneForest.b) != null) {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        }
        if (this.a.v(path, PruneForest.c) != null) {
            return this;
        }
        return new PruneForest(this.a.x(path, PruneForest.d));
    }
    
    public boolean e() {
        return this.a.a(PruneForest.c);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof PruneForest && this.a.equals(((PruneForest)o).a));
    }
    
    public boolean f(final Path path) {
        final Boolean b = this.a.q(path);
        return b != null && !b;
    }
    
    public boolean g(final Path path) {
        final Boolean b = this.a.q(path);
        return b != null && b;
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{PruneForest:");
        sb.append(this.a.toString());
        sb.append("}");
        return sb.toString();
    }
}
