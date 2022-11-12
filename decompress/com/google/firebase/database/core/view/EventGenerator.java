// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.Comparator;
import com.google.firebase.database.snapshot.Index;

public class EventGenerator
{
    private final QuerySpec a;
    private final Index b;
    
    public EventGenerator(final QuerySpec a) {
        this.a = a;
        this.b = a.c();
    }
    
    static Index a(final EventGenerator eventGenerator) {
        return eventGenerator.b;
    }
    
    private Comparator<Change> b() {
        return new Comparator<Change>(this) {
            final EventGenerator a;
            
            public int a(final Change change, final Change change2) {
                Utilities.f(change.i() != null && change2.i() != null);
                return EventGenerator.a(this.a).compare(new NamedNode(change.i(), change.k().k()), new NamedNode(change2.i(), change2.k().k()));
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((Change)o, (Change)o2);
            }
        };
    }
    
    private DataEvent c(final Change change, final EventRegistration eventRegistration, final IndexedNode indexedNode) {
        Change a = change;
        if (!change.j().equals(Event.EventType.VALUE)) {
            if (change.j().equals(Event.EventType.CHILD_REMOVED)) {
                a = change;
            }
            else {
                a = change.a(indexedNode.m(change.i(), change.k().k(), this.b));
            }
        }
        return eventRegistration.b(a, this.a);
    }
    
    private void e(final List<DataEvent> list, final Event.EventType eventType, final List<Change> list2, final List<EventRegistration> list3, final IndexedNode indexedNode) {
        final ArrayList list4 = new ArrayList();
        for (final Change change : list2) {
            if (change.j().equals(eventType)) {
                list4.add(change);
            }
        }
        Collections.sort((List<Object>)list4, (Comparator<? super Object>)this.b());
        for (final Change change2 : list4) {
            for (final EventRegistration eventRegistration : list3) {
                if (eventRegistration.i(eventType)) {
                    list.add(this.c(change2, eventRegistration, indexedNode));
                }
            }
        }
    }
    
    public List<DataEvent> d(final List<Change> list, final IndexedNode indexedNode, final List<EventRegistration> list2) {
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        for (final Change change : list) {
            if (change.j().equals(Event.EventType.CHILD_CHANGED) && this.b.d(change.l().k(), change.k().k())) {
                list4.add(Change.f(change.i(), change.k()));
            }
        }
        this.e(list3, Event.EventType.CHILD_REMOVED, list, list2, indexedNode);
        this.e(list3, Event.EventType.CHILD_ADDED, list, list2, indexedNode);
        this.e(list3, Event.EventType.CHILD_MOVED, list4, list2, indexedNode);
        this.e(list3, Event.EventType.CHILD_CHANGED, list, list2, indexedNode);
        this.e(list3, Event.EventType.VALUE, list, list2, indexedNode);
        return list3;
    }
}
