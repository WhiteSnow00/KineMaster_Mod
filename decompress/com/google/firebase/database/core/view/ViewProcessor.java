// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.KeyIndex;
import java.util.Collection;
import java.util.ArrayList;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Operation;
import java.util.List;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.Iterator;
import java.util.Map;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.core.view.filter.NodeFilter;

public class ViewProcessor
{
    private static NodeFilter.CompleteChildSource b;
    private final NodeFilter a;
    
    static {
        ViewProcessor.b = new NodeFilter.CompleteChildSource() {
            @Override
            public Node a(final ChildKey childKey) {
                return null;
            }
            
            @Override
            public NamedNode b(final Index index, final NamedNode namedNode, final boolean b) {
                return null;
            }
        };
    }
    
    public ViewProcessor(final NodeFilter a) {
        this.a = a;
    }
    
    private ViewCache a(final ViewCache viewCache, final Path path, final ImmutableTree<Boolean> immutableTree, final WriteTreeRef writeTreeRef, final Node node, final ChildChangeAccumulator childChangeAccumulator) {
        if (writeTreeRef.i(path) != null) {
            return viewCache;
        }
        final boolean e = viewCache.d().e();
        final CacheNode d = viewCache.d();
        if (immutableTree.getValue() == null) {
            final CompoundWrite n = CompoundWrite.n();
            final Iterator<Map.Entry<Path, Boolean>> iterator = immutableTree.iterator();
            CompoundWrite a = n;
            while (iterator.hasNext()) {
                final Path path2 = ((Map.Entry<Path, V>)iterator.next()).getKey();
                final Path m = path.m(path2);
                if (d.d(m)) {
                    a = a.a(path2, d.b().F(m));
                }
            }
            return this.c(viewCache, path, a, writeTreeRef, node, e, childChangeAccumulator);
        }
        if ((path.isEmpty() && d.f()) || d.d(path)) {
            return this.d(viewCache, path, d.b().F(path), writeTreeRef, node, e, childChangeAccumulator);
        }
        ViewCache c = viewCache;
        if (path.isEmpty()) {
            CompoundWrite compoundWrite = CompoundWrite.n();
            for (final NamedNode namedNode : d.b()) {
                compoundWrite = compoundWrite.b(namedNode.c(), namedNode.d());
            }
            c = this.c(viewCache, path, compoundWrite, writeTreeRef, node, e, childChangeAccumulator);
        }
        return c;
    }
    
    private ViewCache c(final ViewCache viewCache, final Path path, final CompoundWrite compoundWrite, final WriteTreeRef writeTreeRef, final Node node, final boolean b, final ChildChangeAccumulator childChangeAccumulator) {
        if (viewCache.d().b().isEmpty() && !viewCache.d().f()) {
            return viewCache;
        }
        Utilities.g(compoundWrite.x() == null, "Can't have a merge that is an overwrite");
        CompoundWrite e;
        if (path.isEmpty()) {
            e = compoundWrite;
        }
        else {
            e = CompoundWrite.n().e(path, compoundWrite);
        }
        final Node b2 = viewCache.d().b();
        final Map<ChildKey, CompoundWrite> m = e.m();
        final Iterator<Map.Entry<ChildKey, CompoundWrite>> iterator = m.entrySet().iterator();
        ViewCache viewCache2 = viewCache;
        while (iterator.hasNext()) {
            final Map.Entry<ChildKey, V> entry = (Map.Entry<ChildKey, V>)iterator.next();
            final ChildKey childKey = entry.getKey();
            if (b2.m0(childKey)) {
                viewCache2 = this.d(viewCache2, new Path(new ChildKey[] { childKey }), ((CompoundWrite)entry.getValue()).f(b2.c0(childKey)), writeTreeRef, node, b, childChangeAccumulator);
            }
        }
        for (final Map.Entry<ChildKey, V> entry2 : m.entrySet()) {
            final ChildKey childKey2 = entry2.getKey();
            final CompoundWrite compoundWrite2 = (CompoundWrite)entry2.getValue();
            final boolean b3 = !viewCache.d().c(childKey2) && compoundWrite2.x() == null;
            if (!b2.m0(childKey2) && !b3) {
                viewCache2 = this.d(viewCache2, new Path(new ChildKey[] { childKey2 }), ((CompoundWrite)entry2.getValue()).f(b2.c0(childKey2)), writeTreeRef, node, b, childChangeAccumulator);
            }
        }
        return viewCache2;
    }
    
    private ViewCache d(ViewCache f, final Path path, Node node, final WriteTreeRef writeTreeRef, final Node node2, final boolean b, final ChildChangeAccumulator childChangeAccumulator) {
        final CacheNode d = f.d();
        NodeFilter nodeFilter = this.a;
        if (!b) {
            nodeFilter = nodeFilter.i();
        }
        final boolean empty = path.isEmpty();
        final boolean b2 = true;
        IndexedNode indexedNode;
        if (empty) {
            indexedNode = nodeFilter.m(d.a(), IndexedNode.e(node, nodeFilter.h()), null);
        }
        else if (nodeFilter.l() && !d.e()) {
            Utilities.g(path.isEmpty() ^ true, "An empty path should have been caught in the other branch");
            final ChildKey t = path.t();
            node = d.b().c0(t).V(path.y(), node);
            indexedNode = nodeFilter.m(d.a(), d.a().o(t, node), null);
        }
        else {
            final ChildKey t2 = path.t();
            if (!d.d(path) && path.size() > 1) {
                return f;
            }
            final Path y = path.y();
            node = d.b().c0(t2).V(y, node);
            if (t2.m()) {
                indexedNode = nodeFilter.j(d.a(), node);
            }
            else {
                indexedNode = nodeFilter.k(d.a(), t2, node, y, ViewProcessor.b, null);
            }
        }
        boolean b3 = b2;
        if (!d.f()) {
            b3 = (path.isEmpty() && b2);
        }
        f = f.f(indexedNode, b3, nodeFilter.l());
        return this.h(f, path, writeTreeRef, new c(writeTreeRef, f, node2), childChangeAccumulator);
    }
    
    private ViewCache e(final ViewCache viewCache, final Path path, final CompoundWrite compoundWrite, final WriteTreeRef writeTreeRef, final Node node, final ChildChangeAccumulator childChangeAccumulator) {
        Utilities.g(compoundWrite.x() == null, "Can't have a merge that is an overwrite");
        final Iterator<Map.Entry<Path, Node>> iterator = compoundWrite.iterator();
        ViewCache f = viewCache;
        while (iterator.hasNext()) {
            final Map.Entry<Path, V> entry = (Map.Entry<Path, V>)iterator.next();
            final Path m = path.m(entry.getKey());
            if (g(viewCache, m.t())) {
                f = this.f(f, m, (Node)entry.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        final Iterator<Map.Entry<Path, Node>> iterator2 = compoundWrite.iterator();
        ViewCache f2 = f;
        while (iterator2.hasNext()) {
            final Map.Entry<Path, V> entry2 = (Map.Entry<Path, V>)iterator2.next();
            final Path i = path.m(entry2.getKey());
            if (!g(viewCache, i.t())) {
                f2 = this.f(f2, i, (Node)entry2.getValue(), writeTreeRef, node, childChangeAccumulator);
            }
        }
        return f2;
    }
    
    private ViewCache f(final ViewCache viewCache, final Path path, Node node, final WriteTreeRef writeTreeRef, final Node node2, final ChildChangeAccumulator childChangeAccumulator) {
        final CacheNode c = viewCache.c();
        final c c2 = new c(writeTreeRef, viewCache, node2);
        ViewCache viewCache2;
        if (path.isEmpty()) {
            viewCache2 = viewCache.e(this.a.m(viewCache.c().a(), IndexedNode.e(node, this.a.h()), childChangeAccumulator), true, this.a.l());
        }
        else {
            final ChildKey t = path.t();
            if (t.m()) {
                viewCache2 = viewCache.e(this.a.j(viewCache.c().a(), node), c.f(), c.e());
            }
            else {
                final Path y = path.y();
                final Node c3 = c.b().c0(t);
                if (!y.isEmpty()) {
                    final Node a = ((NodeFilter.CompleteChildSource)c2).a(t);
                    if (a != null) {
                        if (y.q().m() && a.F(y.w()).isEmpty()) {
                            node = a;
                        }
                        else {
                            node = a.V(y, node);
                        }
                    }
                    else {
                        node = EmptyNode.p();
                    }
                }
                viewCache2 = viewCache;
                if (!c3.equals(node)) {
                    viewCache2 = viewCache.e(this.a.k(c.a(), t, node, y, (NodeFilter.CompleteChildSource)c2, childChangeAccumulator), c.f(), this.a.l());
                }
            }
        }
        return viewCache2;
    }
    
    private static boolean g(final ViewCache viewCache, final ChildKey childKey) {
        return viewCache.c().c(childKey);
    }
    
    private ViewCache h(final ViewCache viewCache, final Path path, final WriteTreeRef writeTreeRef, final NodeFilter.CompleteChildSource completeChildSource, final ChildChangeAccumulator childChangeAccumulator) {
        final CacheNode c = viewCache.c();
        if (writeTreeRef.i(path) != null) {
            return viewCache;
        }
        final boolean empty = path.isEmpty();
        final boolean b = false;
        IndexedNode indexedNode;
        if (empty) {
            Utilities.g(viewCache.d().f(), "If change path is empty, we must have complete server data");
            Node node2;
            if (viewCache.d().e()) {
                Node node = viewCache.b();
                if (!(node instanceof ChildrenNode)) {
                    node = EmptyNode.p();
                }
                node2 = writeTreeRef.e(node);
            }
            else {
                node2 = writeTreeRef.b(viewCache.b());
            }
            indexedNode = this.a.m(viewCache.c().a(), IndexedNode.e(node2, this.a.h()), childChangeAccumulator);
        }
        else {
            final ChildKey t = path.t();
            if (t.m()) {
                Utilities.g(path.size() == 1, "Can't have a priority with additional path components");
                final Node f = writeTreeRef.f(path, c.b(), viewCache.d().b());
                if (f != null) {
                    indexedNode = this.a.j(c.a(), f);
                }
                else {
                    indexedNode = c.a();
                }
            }
            else {
                final Path y = path.y();
                Node node3;
                if (c.c(t)) {
                    final Node f2 = writeTreeRef.f(path, c.b(), viewCache.d().b());
                    if (f2 != null) {
                        node3 = c.b().c0(t).V(y, f2);
                    }
                    else {
                        node3 = c.b().c0(t);
                    }
                }
                else {
                    node3 = writeTreeRef.a(t, viewCache.d());
                }
                if (node3 != null) {
                    indexedNode = this.a.k(c.a(), t, node3, y, completeChildSource, childChangeAccumulator);
                }
                else {
                    indexedNode = c.a();
                }
            }
        }
        if (!c.f()) {
            final boolean b2 = b;
            if (!path.isEmpty()) {
                return viewCache.e(indexedNode, b2, this.a.l());
            }
        }
        final boolean b2 = true;
        return viewCache.e(indexedNode, b2, this.a.l());
    }
    
    private ViewCache i(final ViewCache viewCache, final Path path, final WriteTreeRef writeTreeRef, final Node node, final ChildChangeAccumulator childChangeAccumulator) {
        final CacheNode d = viewCache.d();
        return this.h(viewCache.f(d.a(), d.f() || path.isEmpty(), d.e()), path, writeTreeRef, ViewProcessor.b, childChangeAccumulator);
    }
    
    private void j(final ViewCache viewCache, final ViewCache viewCache2, final List<Change> list) {
        final CacheNode c = viewCache2.c();
        if (c.f()) {
            final boolean b = c.b().p1() || c.b().isEmpty();
            if (!list.isEmpty() || !viewCache.c().f() || (b && !c.b().equals(viewCache.a())) || !c.b().C0().equals(viewCache.a().C0())) {
                list.add(Change.n(c.a()));
            }
        }
    }
    
    public ProcessorResult b(final ViewCache viewCache, final Operation operation, final WriteTreeRef writeTreeRef, final Node node) {
        final ChildChangeAccumulator childChangeAccumulator = new ChildChangeAccumulator();
        final int n = ViewProcessor$b.a[operation.c().ordinal()];
        ViewCache viewCache2;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown operation: ");
                        sb.append(operation.c());
                        throw new AssertionError((Object)sb.toString());
                    }
                    viewCache2 = this.i(viewCache, operation.a(), writeTreeRef, node, childChangeAccumulator);
                }
                else {
                    final AckUserWrite ackUserWrite = (AckUserWrite)operation;
                    if (!ackUserWrite.f()) {
                        viewCache2 = this.a(viewCache, ackUserWrite.a(), ackUserWrite.e(), writeTreeRef, node, childChangeAccumulator);
                    }
                    else {
                        viewCache2 = this.k(viewCache, ackUserWrite.a(), writeTreeRef, node, childChangeAccumulator);
                    }
                }
            }
            else {
                final Merge merge = (Merge)operation;
                if (merge.b().d()) {
                    viewCache2 = this.e(viewCache, merge.a(), merge.e(), writeTreeRef, node, childChangeAccumulator);
                }
                else {
                    Utilities.f(merge.b().c());
                    viewCache2 = this.c(viewCache, merge.a(), merge.e(), writeTreeRef, node, merge.b().e() || viewCache.d().e(), childChangeAccumulator);
                }
            }
        }
        else {
            final Overwrite overwrite = (Overwrite)operation;
            if (overwrite.b().d()) {
                viewCache2 = this.f(viewCache, overwrite.a(), overwrite.e(), writeTreeRef, node, childChangeAccumulator);
            }
            else {
                Utilities.f(overwrite.b().c());
                viewCache2 = this.d(viewCache, overwrite.a(), overwrite.e(), writeTreeRef, node, overwrite.b().e() || (viewCache.d().e() && !overwrite.a().isEmpty()), childChangeAccumulator);
            }
        }
        final ArrayList list = new ArrayList<Change>(childChangeAccumulator.a());
        this.j(viewCache, viewCache2, (List<Change>)list);
        return new ProcessorResult(viewCache2, (List<Change>)list);
    }
    
    public ViewCache k(final ViewCache viewCache, final Path path, final WriteTreeRef writeTreeRef, Node a, final ChildChangeAccumulator childChangeAccumulator) {
        if (writeTreeRef.i(path) != null) {
            return viewCache;
        }
        final c c = new c(writeTreeRef, viewCache, a);
        final IndexedNode a2 = viewCache.c().a();
        IndexedNode indexedNode2;
        if (!path.isEmpty() && !path.t().m()) {
            final ChildKey t = path.t();
            a = writeTreeRef.a(t, viewCache.d());
            Node c2;
            if ((c2 = a) == null) {
                c2 = a;
                if (viewCache.d().c(t)) {
                    c2 = a2.k().c0(t);
                }
            }
            IndexedNode indexedNode;
            if (c2 != null) {
                indexedNode = this.a.k(a2, t, c2, path.y(), (NodeFilter.CompleteChildSource)c, childChangeAccumulator);
            }
            else {
                indexedNode = a2;
                if (c2 == null) {
                    indexedNode = a2;
                    if (viewCache.c().b().m0(t)) {
                        indexedNode = this.a.k(a2, t, EmptyNode.p(), path.y(), (NodeFilter.CompleteChildSource)c, childChangeAccumulator);
                    }
                }
            }
            indexedNode2 = indexedNode;
            if (indexedNode.k().isEmpty()) {
                indexedNode2 = indexedNode;
                if (viewCache.d().f()) {
                    final Node b = writeTreeRef.b(viewCache.b());
                    indexedNode2 = indexedNode;
                    if (b.p1()) {
                        indexedNode2 = this.a.m(indexedNode, IndexedNode.e(b, this.a.h()), childChangeAccumulator);
                    }
                }
            }
        }
        else {
            Node node;
            if (viewCache.d().f()) {
                node = writeTreeRef.b(viewCache.b());
            }
            else {
                node = writeTreeRef.e(viewCache.d().b());
            }
            indexedNode2 = this.a.m(a2, IndexedNode.e(node, this.a.h()), childChangeAccumulator);
        }
        return viewCache.e(indexedNode2, viewCache.d().f() || writeTreeRef.i(Path.s()) != null, this.a.l());
    }
    
    public static class ProcessorResult
    {
        public final ViewCache a;
        public final List<Change> b;
        
        public ProcessorResult(final ViewCache a, final List<Change> b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static class c implements CompleteChildSource
    {
        private final WriteTreeRef a;
        private final ViewCache b;
        private final Node c;
        
        public c(final WriteTreeRef a, final ViewCache b, final Node c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public Node a(final ChildKey childKey) {
            final CacheNode c = this.b.c();
            if (c.c(childKey)) {
                return c.b().c0(childKey);
            }
            final Node c2 = this.c;
            CacheNode d;
            if (c2 != null) {
                d = new CacheNode(IndexedNode.e(c2, KeyIndex.j()), true, false);
            }
            else {
                d = this.b.d();
            }
            return this.a.a(childKey, d);
        }
        
        @Override
        public NamedNode b(final Index index, final NamedNode namedNode, final boolean b) {
            Node node = this.c;
            if (node == null) {
                node = this.b.b();
            }
            return this.a.g(node, namedNode, b, index);
        }
    }
}
