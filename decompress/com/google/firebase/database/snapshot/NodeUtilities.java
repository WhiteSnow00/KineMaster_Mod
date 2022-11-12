// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import java.util.Iterator;
import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.firebase.database.DatabaseException;

public class NodeUtilities
{
    public static Node a(final Object o) throws DatabaseException {
        return b(o, PriorityUtilities.a());
    }
    
    public static Node b(Object o, Node d) throws DatabaseException {
        Object value = o;
        Node node = d;
        try {
            if (o instanceof Map) {
                final Map map = (Map)o;
                if (map.containsKey(".priority")) {
                    d = PriorityUtilities.d(map.get(".priority"));
                }
                value = o;
                node = d;
                if (map.containsKey(".value")) {
                    value = map.get(".value");
                    node = d;
                }
            }
            if (value == null) {
                return EmptyNode.p();
            }
            if (value instanceof String) {
                return new StringNode((String)value, node);
            }
            if (value instanceof Long) {
                return new LongNode((Long)value, node);
            }
            if (value instanceof Integer) {
                return new LongNode((long)(int)value, node);
            }
            if (value instanceof Double) {
                return new DoubleNode((Double)value, node);
            }
            if (value instanceof Boolean) {
                return new BooleanNode((Boolean)value, node);
            }
            if (!(value instanceof Map) && !(value instanceof List)) {
                o = new(com.google.firebase.database.DatabaseException.class)();
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to parse node with class ");
                sb.append(((Boolean)value).getClass().toString());
                new DatabaseException(sb.toString());
                throw o;
            }
            if (value instanceof Map) {
                final Map map2 = (Map)value;
                if (map2.containsKey(".sv")) {
                    return new DeferredValueNode(map2, node);
                }
                final Map<ChildKey, Node> map3 = new HashMap<ChildKey, Node>(map2.size());
                final Iterator iterator = map2.keySet().iterator();
                while (true) {
                    o = map3;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    final String s = (String)iterator.next();
                    if (s.startsWith(".")) {
                        continue;
                    }
                    final Node a = a(map2.get(s));
                    if (a.isEmpty()) {
                        continue;
                    }
                    map3.put(ChildKey.f(s), a);
                }
            }
            else {
                final List list = (List)value;
                final Map<ChildKey, Node> map4 = new HashMap<ChildKey, Node>(list.size());
                int n = 0;
                while (true) {
                    o = map4;
                    if (n >= list.size()) {
                        break;
                    }
                    o = new StringBuilder();
                    ((StringBuilder)o).append("");
                    ((StringBuilder)o).append(n);
                    final String string = ((StringBuilder)o).toString();
                    final Node a2 = a(list.get(n));
                    if (!a2.isEmpty()) {
                        map4.put(ChildKey.f(string), a2);
                    }
                    ++n;
                }
            }
            if (((Map)o).isEmpty()) {
                return EmptyNode.p();
            }
            o = new ChildrenNode(ImmutableSortedMap.Builder.d((Map<ChildKey, Node>)o, ChildrenNode.d), node);
            return (Node)o;
        }
        catch (final ClassCastException ex) {
            throw new DatabaseException("Failed to parse node", ex);
        }
    }
    
    public static int c(final ChildKey childKey, final Node node, final ChildKey childKey2, final Node node2) {
        final int compareTo = node.compareTo(node2);
        if (compareTo != 0) {
            return compareTo;
        }
        return childKey.d(childKey2);
    }
}
