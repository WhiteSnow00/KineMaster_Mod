// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import java.util.HashMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.Path;
import java.util.Iterator;
import java.util.Map;
import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.Comparator;

public class ChildrenNode implements Node
{
    public static Comparator<ChildKey> d;
    private final ImmutableSortedMap<ChildKey, Node> a;
    private final Node b;
    private String c;
    
    static {
        ChildrenNode.d = new Comparator<ChildKey>() {
            public int a(final ChildKey childKey, final ChildKey childKey2) {
                return childKey.d(childKey2);
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((ChildKey)o, (ChildKey)o2);
            }
        };
    }
    
    protected ChildrenNode() {
        this.c = null;
        this.a = ImmutableSortedMap.Builder.c(ChildrenNode.d);
        this.b = PriorityUtilities.a();
    }
    
    protected ChildrenNode(final ImmutableSortedMap<ChildKey, Node> a, final Node b) {
        this.c = null;
        if (a.isEmpty() && !b.isEmpty()) {
            throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
        }
        this.b = b;
        this.a = a;
    }
    
    private static void a(final StringBuilder sb, final int n) {
        for (int i = 0; i < n; ++i) {
            sb.append(" ");
        }
    }
    
    private void o(final StringBuilder sb, final int n) {
        if (this.a.isEmpty() && this.b.isEmpty()) {
            sb.append("{ }");
        }
        else {
            sb.append("{\n");
            for (final Map.Entry<ChildKey, ChildrenNode> entry : this.a) {
                final int n2 = n + 2;
                a(sb, n2);
                sb.append(entry.getKey().c());
                sb.append("=");
                if (entry.getValue() instanceof ChildrenNode) {
                    entry.getValue().o(sb, n2);
                }
                else {
                    sb.append(entry.getValue().toString());
                }
                sb.append("\n");
            }
            if (!this.b.isEmpty()) {
                a(sb, n + 2);
                sb.append(".priority=");
                sb.append(this.b.toString());
                sb.append("\n");
            }
            a(sb, n);
            sb.append("}");
        }
    }
    
    @Override
    public Node C0() {
        return this.b;
    }
    
    @Override
    public Node F(final Path path) {
        final ChildKey t = path.t();
        if (t == null) {
            return this;
        }
        return this.c0(t).F(path.y());
    }
    
    @Override
    public Iterator<NamedNode> F1() {
        return new c(this.a.F1());
    }
    
    @Override
    public Node L(final Node node) {
        if (this.a.isEmpty()) {
            return EmptyNode.p();
        }
        return new ChildrenNode(this.a, node);
    }
    
    @Override
    public ChildKey S0(final ChildKey childKey) {
        return this.a.k(childKey);
    }
    
    @Override
    public Node V(final Path path, final Node node) {
        final ChildKey t = path.t();
        if (t == null) {
            return node;
        }
        if (t.m()) {
            Utilities.f(PriorityUtilities.b(node));
            return this.L(node);
        }
        return this.r0(t, this.c0(t).V(path.y(), node));
    }
    
    @Override
    public String a0(final HashVersion hashVersion) {
        final HashVersion v1 = HashVersion.V1;
        if (hashVersion == v1) {
            final StringBuilder sb = new StringBuilder();
            if (!this.b.isEmpty()) {
                sb.append("priority:");
                sb.append(this.b.a0(v1));
                sb.append(":");
            }
            final ArrayList list = new ArrayList();
            final Iterator<NamedNode> iterator = this.iterator();
            int n = 0;
        Label_0073:
            while (true) {
                n = 0;
                while (iterator.hasNext()) {
                    final NamedNode namedNode = iterator.next();
                    list.add(namedNode);
                    if (n == 0 && namedNode.d().C0().isEmpty()) {
                        continue Label_0073;
                    }
                    n = 1;
                }
                break;
            }
            if (n != 0) {
                Collections.sort((List<Object>)list, (Comparator<? super Object>)PriorityIndex.j());
            }
            for (final NamedNode namedNode2 : list) {
                final String hash = namedNode2.d().getHash();
                if (!hash.equals("")) {
                    sb.append(":");
                    sb.append(namedNode2.c().c());
                    sb.append(":");
                    sb.append(hash);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
    }
    
    @Override
    public Node c0(final ChildKey childKey) {
        if (childKey.m() && !this.b.isEmpty()) {
            return this.b;
        }
        if (this.a.a(childKey)) {
            return this.a.b(childKey);
        }
        return EmptyNode.p();
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.f((Node)o);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof ChildrenNode)) {
            return false;
        }
        final ChildrenNode childrenNode = (ChildrenNode)o;
        if (!this.C0().equals(childrenNode.C0())) {
            return false;
        }
        if (this.a.size() != childrenNode.a.size()) {
            return false;
        }
        final Iterator<Map.Entry<ChildKey, Node>> iterator = this.a.iterator();
        final Iterator<Map.Entry<ChildKey, Node>> iterator2 = childrenNode.a.iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            final Map.Entry<ChildKey, V> entry = iterator.next();
            final Map.Entry<K, Object> entry2 = iterator2.next();
            if (!entry.getKey().equals(entry2.getKey()) || !entry.getValue().equals(entry2.getValue())) {
                return false;
            }
        }
        if (!iterator.hasNext() && !iterator2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }
    
    public int f(final Node node) {
        if (this.isEmpty()) {
            if (node.isEmpty()) {
                return 0;
            }
            return -1;
        }
        else {
            if (node.p1()) {
                return 1;
            }
            if (node.isEmpty()) {
                return 1;
            }
            if (node == Node.q) {
                return -1;
            }
            return 0;
        }
    }
    
    public void g(final ChildVisitor childVisitor) {
        this.k(childVisitor, false);
    }
    
    @Override
    public String getHash() {
        if (this.c == null) {
            final String a0 = this.a0(HashVersion.V1);
            String i;
            if (a0.isEmpty()) {
                i = "";
            }
            else {
                i = Utilities.i(a0);
            }
            this.c = i;
        }
        return this.c;
    }
    
    @Override
    public Object getValue() {
        return this.t0(false);
    }
    
    @Override
    public int hashCode() {
        final Iterator<NamedNode> iterator = this.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final NamedNode namedNode = iterator.next();
            n = (n * 31 + namedNode.c().hashCode()) * 17 + namedNode.d().hashCode();
        }
        return n;
    }
    
    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
    
    @Override
    public Iterator<NamedNode> iterator() {
        return new c(this.a.iterator());
    }
    
    @Override
    public int j() {
        return this.a.size();
    }
    
    public void k(final ChildVisitor childVisitor, final boolean b) {
        if (b && !this.C0().isEmpty()) {
            this.a.m(new LLRBNode.NodeVisitor<ChildKey, Node>(this, childVisitor) {
                boolean a = false;
                final ChildVisitor b;
                final ChildrenNode c;
                
                @Override
                public /* bridge */ void a(final Object o, final Object o2) {
                    this.b((ChildKey)o, (Node)o2);
                }
                
                public void b(final ChildKey childKey, final Node node) {
                    if (!this.a && childKey.d(ChildKey.i()) > 0) {
                        this.a = true;
                        this.b.b(ChildKey.i(), this.c.C0());
                    }
                    this.b.b(childKey, node);
                }
            });
        }
        else {
            this.a.m(childVisitor);
        }
    }
    
    public ChildKey m() {
        return this.a.g();
    }
    
    @Override
    public boolean m0(final ChildKey childKey) {
        return this.c0(childKey).isEmpty() ^ true;
    }
    
    public ChildKey n() {
        return this.a.f();
    }
    
    @Override
    public boolean p1() {
        return false;
    }
    
    @Override
    public Node r0(final ChildKey childKey, final Node node) {
        if (childKey.m()) {
            return this.L(node);
        }
        Iterable<Map.Entry<K, V>> iterable;
        final ImmutableSortedMap<ChildKey, Node> immutableSortedMap = (ImmutableSortedMap<ChildKey, Node>)(iterable = (Iterable<Map.Entry<K, V>>)this.a);
        if (immutableSortedMap.a(childKey)) {
            iterable = (Iterable<Map.Entry<K, V>>)immutableSortedMap.o(childKey);
        }
        Object n = iterable;
        if (!node.isEmpty()) {
            n = ((ImmutableSortedMap<ChildKey, Node>)iterable).n(childKey, node);
        }
        if (((ImmutableSortedMap)n).isEmpty()) {
            return EmptyNode.p();
        }
        return new ChildrenNode((ImmutableSortedMap<ChildKey, Node>)n, this.b);
    }
    
    @Override
    public Object t0(final boolean b) {
        if (this.isEmpty()) {
            return null;
        }
        final HashMap hashMap = new HashMap();
        final Iterator<Map.Entry<ChildKey, Node>> iterator = this.a.iterator();
        final int n = 0;
        int n2 = 1;
        int n3 = 0;
        int intValue = 0;
        while (iterator.hasNext()) {
            final Map.Entry<ChildKey, V> entry = (Map.Entry<ChildKey, V>)iterator.next();
            final String c = entry.getKey().c();
            hashMap.put(c, ((Node)entry.getValue()).t0(b));
            final int n4 = ++n3;
            if (n2 != 0) {
                if (c.length() <= 1 || c.charAt(0) != '0') {
                    final Integer k = Utilities.k(c);
                    if (k != null && k >= 0) {
                        n3 = n4;
                        if (k > intValue) {
                            intValue = k;
                            n3 = n4;
                            continue;
                        }
                        continue;
                    }
                }
                n2 = 0;
                n3 = n4;
            }
        }
        if (!b && n2 != 0 && intValue < n3 * 2) {
            final ArrayList list = new ArrayList(intValue + 1);
            for (int i = n; i <= intValue; ++i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i);
                list.add(hashMap.get(sb.toString()));
            }
            return list;
        }
        if (b && !this.b.isEmpty()) {
            hashMap.put(".priority", this.b.getValue());
        }
        return hashMap;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        this.o(sb, 0);
        return sb.toString();
    }
    
    public abstract static class ChildVisitor extends NodeVisitor<ChildKey, Node>
    {
        @Override
        public /* bridge */ void a(final Object o, final Object o2) {
            this.c((ChildKey)o, (Node)o2);
        }
        
        public abstract void b(final ChildKey p0, final Node p1);
        
        public void c(final ChildKey childKey, final Node node) {
            this.b(childKey, node);
        }
    }
    
    private static class c implements Iterator<NamedNode>
    {
        private final Iterator<Map.Entry<ChildKey, Node>> a;
        
        public c(final Iterator<Map.Entry<ChildKey, Node>> a) {
            this.a = a;
        }
        
        public NamedNode b() {
            final Map.Entry entry = this.a.next();
            return new NamedNode((ChildKey)entry.getKey(), (Node)entry.getValue());
        }
        
        @Override
        public boolean hasNext() {
            return this.a.hasNext();
        }
        
        @Override
        public /* bridge */ Object next() {
            return this.b();
        }
        
        @Override
        public void remove() {
            this.a.remove();
        }
    }
}
