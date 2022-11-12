// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import java.util.Collections;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.Nullable;
import java.util.Iterator;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.annotations.NotNull;
import java.util.Arrays;
import com.google.firebase.database.core.view.filter.NodeFilter;
import java.util.ArrayList;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.EventRegistration;
import java.util.List;

public class View
{
    private final QuerySpec a;
    private final ViewProcessor b;
    private ViewCache c;
    private final List<EventRegistration> d;
    private final EventGenerator e;
    
    public View(final QuerySpec a, final ViewCache viewCache) {
        this.a = a;
        final IndexedFilter indexedFilter = new IndexedFilter(a.c());
        final NodeFilter h = a.d().h();
        this.b = new ViewProcessor(h);
        final CacheNode d = viewCache.d();
        final CacheNode c = viewCache.c();
        final IndexedNode e = IndexedNode.e(EmptyNode.p(), a.c());
        this.c = new ViewCache(new CacheNode(h.m(e, c.a(), null), c.f(), h.l()), new CacheNode(indexedFilter.m(e, d.a(), null), d.f(), indexedFilter.l()));
        this.d = new ArrayList<EventRegistration>();
        this.e = new EventGenerator(a);
    }
    
    private List<DataEvent> c(final List<Change> list, final IndexedNode indexedNode, final EventRegistration eventRegistration) {
        List<EventRegistration> list2;
        if (eventRegistration == null) {
            list2 = this.d;
        }
        else {
            list2 = Arrays.asList(eventRegistration);
        }
        return this.e.d(list, indexedNode, list2);
    }
    
    public void a(@NotNull final EventRegistration eventRegistration) {
        this.d.add(eventRegistration);
    }
    
    public OperationResult b(final Operation operation, final WriteTreeRef writeTreeRef, final Node node) {
        final Operation.OperationType c = operation.c();
        final Operation.OperationType merge = Operation.OperationType.Merge;
        final boolean b = false;
        if (c == merge && operation.b().b() != null) {
            Utilities.g(this.c.b() != null, "We should always have a full cache before handling merges");
            Utilities.g(this.c.a() != null, "Missing event cache, even though we have a server cache");
        }
        final ViewCache c2 = this.c;
        final ViewProcessor.ProcessorResult b2 = this.b.b(c2, operation, writeTreeRef, node);
        boolean b3 = false;
        Label_0133: {
            if (!b2.a.d().f()) {
                b3 = b;
                if (c2.d().f()) {
                    break Label_0133;
                }
            }
            b3 = true;
        }
        Utilities.g(b3, "Once a server snap is complete, it should never go back");
        final ViewCache a = b2.a;
        this.c = a;
        return new OperationResult(this.c(b2.b, a.c().a(), null), b2.b);
    }
    
    public Node d(final Path path) {
        final Node b = this.c.b();
        if (b != null && (this.a.g() || (!path.isEmpty() && !b.c0(path.t()).isEmpty()))) {
            return b.F(path);
        }
        return null;
    }
    
    public Node e() {
        return this.c.c().b();
    }
    
    public List<DataEvent> f(final EventRegistration eventRegistration) {
        final CacheNode c = this.c.c();
        final ArrayList list = new ArrayList();
        for (final NamedNode namedNode : c.b()) {
            list.add(Change.c(namedNode.c(), namedNode.d()));
        }
        if (c.f()) {
            list.add(Change.n(c.a()));
        }
        return this.c(list, c.a(), eventRegistration);
    }
    
    public QuerySpec g() {
        return this.a;
    }
    
    public Node h() {
        return this.c.d().b();
    }
    
    public boolean i() {
        return this.d.isEmpty();
    }
    
    public List<Event> j(@Nullable EventRegistration eventRegistration, final DatabaseError databaseError) {
        int i = 0;
        List<Object> emptyList;
        if (databaseError != null) {
            final ArrayList list = new ArrayList();
            Utilities.g(eventRegistration == null, "A cancel should cancel all event registrations");
            final Path e = this.a.e();
            final Iterator<EventRegistration> iterator = this.d.iterator();
            while (true) {
                emptyList = list;
                if (!iterator.hasNext()) {
                    break;
                }
                list.add(new CancelEvent(iterator.next(), databaseError, e));
            }
        }
        else {
            emptyList = Collections.emptyList();
        }
        if (eventRegistration != null) {
            int n = -1;
            while (true) {
                while (i < this.d.size()) {
                    final EventRegistration eventRegistration2 = this.d.get(i);
                    if (eventRegistration2.f(eventRegistration)) {
                        if (eventRegistration2.h()) {
                            if (i != -1) {
                                eventRegistration = this.d.get(i);
                                this.d.remove(i);
                                eventRegistration.l();
                                return (List<Event>)emptyList;
                            }
                            return (List<Event>)emptyList;
                        }
                        else {
                            n = i;
                        }
                    }
                    ++i;
                }
                i = n;
                continue;
            }
        }
        final Iterator<EventRegistration> iterator2 = this.d.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().l();
        }
        this.d.clear();
        return (List<Event>)emptyList;
    }
    
    public static class OperationResult
    {
        public final List<DataEvent> a;
        public final List<Change> b;
        
        public OperationResult(final List<DataEvent> a, final List<Change> b) {
            this.a = a;
            this.b = b;
        }
    }
}
