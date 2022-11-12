// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import java.util.Map;
import com.google.firebase.database.snapshot.ChildKey;

public class Tree<T>
{
    private ChildKey a;
    private Tree<T> b;
    private TreeNode<T> c;
    
    public Tree() {
        this(null, null, (TreeNode)new TreeNode());
    }
    
    public Tree(final ChildKey a, final Tree<T> b, final TreeNode<T> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void m(final ChildKey childKey, final Tree<T> tree) {
        final boolean i = tree.i();
        final boolean containsKey = this.c.a.containsKey(childKey);
        if (i && containsKey) {
            this.c.a.remove(childKey);
            this.n();
        }
        else if (!i && !containsKey) {
            this.c.a.put(childKey, tree.c);
            this.n();
        }
    }
    
    private void n() {
        final Tree<T> b = this.b;
        if (b != null) {
            b.m(this.a, this);
        }
    }
    
    public boolean a(final TreeFilter<T> treeFilter) {
        return this.b(treeFilter, false);
    }
    
    public boolean b(final TreeFilter<T> treeFilter, final boolean b) {
        Tree tree;
        if (b) {
            tree = this;
        }
        else {
            tree = this.b;
        }
        while (tree != null) {
            if (treeFilter.a(tree)) {
                return true;
            }
            tree = tree.b;
        }
        return false;
    }
    
    public void c(final TreeVisitor<T> treeVisitor) {
        final Object[] array = this.c.a.entrySet().toArray();
        for (int i = 0; i < array.length; ++i) {
            final Map.Entry entry = (Map.Entry)array[i];
            treeVisitor.a(new Tree<T>((ChildKey)entry.getKey(), (Tree<Object>)this, (TreeNode<Object>)entry.getValue()));
        }
    }
    
    public void d(final TreeVisitor<T> treeVisitor) {
        this.e(treeVisitor, false, false);
    }
    
    public void e(final TreeVisitor<T> treeVisitor, final boolean b, final boolean b2) {
        if (b && !b2) {
            treeVisitor.a(this);
        }
        this.c((TreeVisitor<T>)new TreeVisitor<T>(this, treeVisitor, b2) {
            final TreeVisitor a;
            final boolean b;
            final Tree c;
            
            @Override
            public void a(final Tree<T> tree) {
                tree.e(this.a, true, this.b);
            }
        });
        if (b && b2) {
            treeVisitor.a(this);
        }
    }
    
    public Path f() {
        final Tree<T> b = this.b;
        boolean b2 = false;
        if (b != null) {
            if (this.a != null) {
                b2 = true;
            }
            Utilities.f(b2);
            return this.b.f().n(this.a);
        }
        Path s;
        if (this.a != null) {
            s = new Path(new ChildKey[] { this.a });
        }
        else {
            s = Path.s();
        }
        return s;
    }
    
    public T g() {
        return this.c.b;
    }
    
    public boolean h() {
        return this.c.a.isEmpty() ^ true;
    }
    
    public boolean i() {
        final TreeNode<T> c = this.c;
        return c.b == null && c.a.isEmpty();
    }
    
    public void j(final T b) {
        this.c.b = b;
        this.n();
    }
    
    public Tree<T> k(Path y) {
        ChildKey childKey = y.t();
        Tree tree = this;
        while (childKey != null) {
            TreeNode treeNode;
            if (tree.c.a.containsKey(childKey)) {
                treeNode = tree.c.a.get(childKey);
            }
            else {
                treeNode = new TreeNode();
            }
            tree = new Tree<Object>(childKey, (Tree<Object>)tree, treeNode);
            y = y.y();
            childKey = y.t();
        }
        return tree;
    }
    
    String l(final String s) {
        final ChildKey a = this.a;
        String c;
        if (a == null) {
            c = "<anon>";
        }
        else {
            c = a.c();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(c);
        sb.append("\n");
        final TreeNode<T> c2 = this.c;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append("\t");
        sb.append(c2.a(sb2.toString()));
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return this.l("");
    }
    
    public interface TreeFilter<T>
    {
        boolean a(final Tree<T> p0);
    }
    
    public interface TreeVisitor<T>
    {
        void a(final Tree<T> p0);
    }
}
