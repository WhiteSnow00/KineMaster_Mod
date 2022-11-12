// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Iterator;
import java.util.HashMap;
import com.google.firebase.database.core.utilities.Clock;
import java.util.Map;
import com.google.firebase.database.snapshot.Node;

public class ServerValues
{
    static Node a(final Node node, final ValueProvider valueProvider, final Map map) {
        return h(node, valueProvider, map);
    }
    
    private static boolean b(final Number n) {
        return !(n instanceof Double) && !(n instanceof Float);
    }
    
    public static Map<String, Object> c(final Clock clock) {
        final HashMap hashMap = new HashMap();
        hashMap.put("timestamp", clock.a());
        return hashMap;
    }
    
    static Object d(final Map<String, Object> map, final ValueProvider valueProvider, final Map<String, Object> map2) {
        if (!map.containsKey("increment")) {
            return null;
        }
        final Number value = map.get("increment");
        if (!(value instanceof Number)) {
            return null;
        }
        final Number n = value;
        final Node b = valueProvider.b();
        Number value2 = n;
        if (b.p1()) {
            if (!(b.getValue() instanceof Number)) {
                value2 = n;
            }
            else {
                final Number n2 = (Number)b.getValue();
                if (b(n) && b(n2)) {
                    final long longValue = n.longValue();
                    final long longValue2 = n2.longValue();
                    final long n3 = longValue + longValue2;
                    if (((longValue ^ n3) & (longValue2 ^ n3)) >= 0L) {
                        return n3;
                    }
                }
                value2 = n.doubleValue() + n2.doubleValue();
            }
        }
        return value2;
    }
    
    public static Object e(final Object o, final ValueProvider valueProvider, final Map<String, Object> map) {
        if (!(o instanceof Map)) {
            return o;
        }
        final Map map2 = (Map)o;
        if (!map2.containsKey(".sv")) {
            return o;
        }
        final Object value = map2.get(".sv");
        Object o2 = null;
        if (value instanceof String) {
            o2 = j((String)value, map);
        }
        else if (value instanceof Map) {
            o2 = d((Map<String, Object>)value, valueProvider, map);
        }
        if (o2 == null) {
            return o;
        }
        return o2;
    }
    
    public static CompoundWrite f(CompoundWrite a, final SyncTree syncTree, final Path path, final Map<String, Object> map) {
        final CompoundWrite n = CompoundWrite.n();
        final Iterator<Map.Entry<Path, Node>> iterator = a.iterator();
        a = n;
        while (iterator.hasNext()) {
            final Map.Entry<Path, V> entry = (Map.Entry<Path, V>)iterator.next();
            a = a.a(entry.getKey(), h((Node)entry.getValue(), new ValueProvider.DeferredValueProvider(syncTree, path.m(entry.getKey())), map));
        }
        return a;
    }
    
    public static Node g(final Node node, final SyncTree syncTree, final Path path, final Map<String, Object> map) {
        return h(node, new ValueProvider.DeferredValueProvider(syncTree, path), map);
    }
    
    private static Node h(final Node node, final ValueProvider valueProvider, final Map<String, Object> map) {
        final Object value = node.C0().getValue();
        final Object e = e(value, valueProvider.a(ChildKey.f(".priority")), map);
        if (node.p1()) {
            final Object e2 = e(node.getValue(), valueProvider, map);
            if (e2.equals(node.getValue()) && Utilities.d(e, value)) {
                return node;
            }
            return NodeUtilities.b(e2, PriorityUtilities.d(e));
        }
        else {
            if (node.isEmpty()) {
                return node;
            }
            final ChildrenNode childrenNode = (ChildrenNode)node;
            final SnapshotHolder snapshotHolder = new SnapshotHolder(childrenNode);
            childrenNode.g((ChildrenNode.ChildVisitor)new ChildrenNode.ChildVisitor(valueProvider, map, snapshotHolder) {
                final ValueProvider a;
                final Map b;
                final SnapshotHolder c;
                
                @Override
                public void b(final ChildKey childKey, final Node node) {
                    final Node a = ServerValues.a(node, this.a.a(childKey), this.b);
                    if (a != node) {
                        this.c.c(new Path(childKey.c()), a);
                    }
                }
            });
            if (!snapshotHolder.b().C0().equals(e)) {
                return snapshotHolder.b().L(PriorityUtilities.d(e));
            }
            return snapshotHolder.b();
        }
    }
    
    public static Node i(final Node node, final Node node2, final Map<String, Object> map) {
        return h(node, new ValueProvider.ExistingValueProvider(node2), map);
    }
    
    static Object j(final String s, final Map<String, Object> map) {
        if ("timestamp".equals(s) && map.containsKey(s)) {
            return map.get(s);
        }
        return null;
    }
}
