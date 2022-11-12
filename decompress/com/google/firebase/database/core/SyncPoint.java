// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.view.ViewCache;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.EmptyNode;
import java.util.Collection;
import java.util.ArrayList;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.annotations.NotNull;
import java.util.Iterator;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Set;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.Change;
import java.util.HashSet;
import com.google.firebase.database.core.view.DataEvent;
import java.util.List;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.operation.Operation;
import java.util.HashMap;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.core.view.QueryParams;
import java.util.Map;

public class SyncPoint
{
    private final Map<QueryParams, View> a;
    private final PersistenceManager b;
    
    public SyncPoint(final PersistenceManager b) {
        this.a = new HashMap<QueryParams, View>();
        this.b = b;
    }
    
    private List<DataEvent> c(final View view, final Operation operation, final WriteTreeRef writeTreeRef, final Node node) {
        final View.OperationResult b = view.b(operation, writeTreeRef, node);
        if (!view.g().g()) {
            final HashSet set = new HashSet();
            final HashSet set2 = new HashSet();
            for (final Change change : b.b) {
                final Event.EventType j = change.j();
                if (j == Event.EventType.CHILD_ADDED) {
                    set2.add(change.i());
                }
                else {
                    if (j != Event.EventType.CHILD_REMOVED) {
                        continue;
                    }
                    set.add(change.i());
                }
            }
            if (!set2.isEmpty() || !set.isEmpty()) {
                this.b.j(view.g(), set2, set);
            }
        }
        return b.a;
    }
    
    public List<DataEvent> a(@NotNull final EventRegistration eventRegistration, final WriteTreeRef writeTreeRef, final CacheNode cacheNode) {
        final QuerySpec e = eventRegistration.e();
        final View g = this.g(e, writeTreeRef, cacheNode);
        if (!e.g()) {
            final HashSet set = new HashSet();
            final Iterator<NamedNode> iterator = g.e().iterator();
            while (iterator.hasNext()) {
                set.add(iterator.next().c());
            }
            this.b.e(e, set);
        }
        if (!this.a.containsKey(e.d())) {
            this.a.put(e.d(), g);
        }
        this.a.put(e.d(), g);
        g.a(eventRegistration);
        return g.f(eventRegistration);
    }
    
    public List<DataEvent> b(final Operation operation, final WriteTreeRef writeTreeRef, final Node node) {
        final QueryParams b = operation.b().b();
        if (b != null) {
            final View view = this.a.get(b);
            Utilities.f(view != null);
            return this.c(view, operation, writeTreeRef, node);
        }
        final ArrayList list = new ArrayList();
        final Iterator<Map.Entry<QueryParams, View>> iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            list.addAll(this.c(((Map.Entry<K, View>)iterator.next()).getValue(), operation, writeTreeRef, node));
        }
        return list;
    }
    
    public Node d(final Path path) {
        for (final View view : this.a.values()) {
            if (view.d(path) != null) {
                return view.d(path);
            }
        }
        return null;
    }
    
    public View e() {
        final Iterator<Map.Entry<QueryParams, View>> iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            final View view = ((Map.Entry<K, View>)iterator.next()).getValue();
            if (view.g().g()) {
                return view;
            }
        }
        return null;
    }
    
    public List<View> f() {
        final ArrayList list = new ArrayList();
        final Iterator<Map.Entry<QueryParams, View>> iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            final View view = ((Map.Entry<K, View>)iterator.next()).getValue();
            if (!view.g().g()) {
                list.add(view);
            }
        }
        return list;
    }
    
    public View g(final QuerySpec querySpec, final WriteTreeRef writeTreeRef, final CacheNode cacheNode) {
        final View view = this.a.get(querySpec.d());
        if (view == null) {
            Node b;
            if (cacheNode.f()) {
                b = cacheNode.b();
            }
            else {
                b = null;
            }
            final Node b2 = writeTreeRef.b(b);
            boolean b3;
            Node e;
            if (b2 != null) {
                b3 = true;
                e = b2;
            }
            else {
                Node node;
                if (cacheNode.b() != null) {
                    node = cacheNode.b();
                }
                else {
                    node = EmptyNode.p();
                }
                e = writeTreeRef.e(node);
                b3 = false;
            }
            return new View(querySpec, new ViewCache(new CacheNode(IndexedNode.e(e, querySpec.c()), b3, false), cacheNode));
        }
        return view;
    }
    
    public boolean h() {
        return this.e() != null;
    }
    
    public boolean i() {
        return this.a.isEmpty();
    }
    
    public Pair<List<QuerySpec>, List<Event>> j(@NotNull final QuerySpec querySpec, @Nullable final EventRegistration eventRegistration, @Nullable final DatabaseError databaseError) {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final boolean h = this.h();
        if (querySpec.f()) {
            final Iterator<Map.Entry<QueryParams, View>> iterator = this.a.entrySet().iterator();
            while (iterator.hasNext()) {
                final View view = ((Map.Entry<K, View>)iterator.next()).getValue();
                list2.addAll(view.j(eventRegistration, databaseError));
                if (view.i()) {
                    iterator.remove();
                    if (view.g().g()) {
                        continue;
                    }
                    list.add(view.g());
                }
            }
        }
        else {
            final View view2 = this.a.get(querySpec.d());
            if (view2 != null) {
                list2.addAll(view2.j(eventRegistration, databaseError));
                if (view2.i()) {
                    this.a.remove(querySpec.d());
                    if (!view2.g().g()) {
                        list.add(view2.g());
                    }
                }
            }
        }
        if (h && !this.h()) {
            list.add(QuerySpec.a(querySpec.e()));
        }
        return new Pair<List<QuerySpec>, List<Event>>(list, list2);
    }
    
    public boolean k(final QuerySpec querySpec) {
        return this.l(querySpec) != null;
    }
    
    public View l(final QuerySpec querySpec) {
        if (querySpec.g()) {
            return this.e();
        }
        return this.a.get(querySpec.d());
    }
}
