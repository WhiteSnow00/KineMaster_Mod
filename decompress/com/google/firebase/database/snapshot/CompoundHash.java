// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import java.util.Iterator;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import com.google.firebase.database.core.Path;
import java.util.List;

public class CompoundHash
{
    private final List<Path> a;
    private final List<String> b;
    
    private CompoundHash(final List<Path> a, final List<String> b) {
        if (a.size() == b.size() - 1) {
            this.a = a;
            this.b = b;
            return;
        }
        throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
    }
    
    static void a(final Node node, final b b) {
        f(node, b);
    }
    
    public static CompoundHash b(final Node node) {
        return c(node, (SplitStrategy)new c(node));
    }
    
    public static CompoundHash c(final Node node, final SplitStrategy splitStrategy) {
        if (node.isEmpty()) {
            return new CompoundHash(Collections.emptyList(), Collections.singletonList(""));
        }
        final b b = new b(splitStrategy);
        f(node, b);
        CompoundHash.b.a(b);
        return new CompoundHash(CompoundHash.b.b(b), CompoundHash.b.c(b));
    }
    
    private static void f(final Node node, final b b) {
        if (node.p1()) {
            CompoundHash.b.d(b, (LeafNode)node);
        }
        else {
            if (node.isEmpty()) {
                throw new IllegalArgumentException("Can't calculate hash on empty node!");
            }
            if (!(node instanceof ChildrenNode)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected children node, but got: ");
                sb.append(node);
                throw new IllegalStateException(sb.toString());
            }
            ((ChildrenNode)node).k((ChildrenNode.ChildVisitor)new ChildrenNode.ChildVisitor(b) {
                final b a;
                
                @Override
                public void b(final ChildKey childKey, final Node node) {
                    CompoundHash.b.e(this.a, childKey);
                    CompoundHash.a(node, this.a);
                    CompoundHash.b.f(this.a);
                }
            }, true);
        }
    }
    
    public List<String> d() {
        return Collections.unmodifiableList((List<? extends String>)this.b);
    }
    
    public List<Path> e() {
        return Collections.unmodifiableList((List<? extends Path>)this.a);
    }
    
    public interface SplitStrategy
    {
        boolean a(final b p0);
    }
    
    static class b
    {
        private StringBuilder a;
        private Stack<ChildKey> b;
        private int c;
        private int d;
        private boolean e;
        private final List<Path> f;
        private final List<String> g;
        private final SplitStrategy h;
        
        public b(final SplitStrategy h) {
            this.a = null;
            this.b = new Stack<ChildKey>();
            this.c = -1;
            this.e = true;
            this.f = new ArrayList<Path>();
            this.g = new ArrayList<String>();
            this.h = h;
        }
        
        static void a(final b b) {
            b.o();
        }
        
        static List b(final b b) {
            return b.f;
        }
        
        static List c(final b b) {
            return b.g;
        }
        
        static void d(final b b, final LeafNode leafNode) {
            b.p(leafNode);
        }
        
        static void e(final b b, final ChildKey childKey) {
            b.q(childKey);
        }
        
        static void f(final b b) {
            b.l();
        }
        
        private void g(final StringBuilder sb, final ChildKey childKey) {
            sb.append(Utilities.j(childKey.c()));
        }
        
        private Path k(final int n) {
            final ChildKey[] array = new ChildKey[n];
            for (int i = 0; i < n; ++i) {
                array[i] = (ChildKey)this.b.get(i);
            }
            return new Path(array);
        }
        
        private void l() {
            --this.d;
            if (this.h()) {
                this.a.append(")");
            }
            this.e = true;
        }
        
        private void m() {
            Utilities.g(this.h(), "Can't end range without starting a range!");
            for (int i = 0; i < this.d; ++i) {
                this.a.append(")");
            }
            this.a.append(")");
            final Path k = this.k(this.c);
            this.g.add(Utilities.i(this.a.toString()));
            this.f.add(k);
            this.a = null;
        }
        
        private void n() {
            if (!this.h()) {
                (this.a = new StringBuilder()).append("(");
                final Iterator<ChildKey> iterator = this.k(this.d).iterator();
                while (iterator.hasNext()) {
                    this.g(this.a, iterator.next());
                    this.a.append(":(");
                }
                this.e = false;
            }
        }
        
        private void o() {
            Utilities.g(this.d == 0, "Can't finish hashing in the middle processing a child");
            if (this.h()) {
                this.m();
            }
            this.g.add("");
        }
        
        private void p(final LeafNode<?> leafNode) {
            this.n();
            this.c = this.d;
            this.a.append(leafNode.a0(Node.HashVersion.V2));
            this.e = true;
            if (this.h.a(this)) {
                this.m();
            }
        }
        
        private void q(final ChildKey childKey) {
            this.n();
            if (this.e) {
                this.a.append(",");
            }
            this.g(this.a, childKey);
            this.a.append(":(");
            if (this.d == this.b.size()) {
                this.b.add(childKey);
            }
            else {
                this.b.set(this.d, childKey);
            }
            ++this.d;
            this.e = false;
        }
        
        public boolean h() {
            return this.a != null;
        }
        
        public int i() {
            return this.a.length();
        }
        
        public Path j() {
            return this.k(this.d);
        }
    }
    
    private static class c implements SplitStrategy
    {
        private final long a;
        
        public c(final Node node) {
            this.a = Math.max(512L, (long)Math.sqrt((double)(NodeSizeEstimator.b(node) * 100L)));
        }
        
        @Override
        public boolean a(final b b) {
            return b.i() > this.a && (b.j().isEmpty() || !b.j().q().equals(ChildKey.i()));
        }
    }
}
