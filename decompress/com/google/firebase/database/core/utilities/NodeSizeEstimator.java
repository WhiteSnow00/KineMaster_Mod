// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import java.util.Iterator;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.LongNode;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.LeafNode;

public class NodeSizeEstimator
{
    private static long a(final LeafNode<?> leafNode) {
        final boolean b = leafNode instanceof DoubleNode;
        long n = 8L;
        if (!b) {
            if (!(leafNode instanceof LongNode)) {
                if (leafNode instanceof BooleanNode) {
                    n = 4L;
                }
                else {
                    if (!(leafNode instanceof StringNode)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown leaf node type: ");
                        sb.append(leafNode.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                    n = ((String)leafNode.getValue()).length() + 2L;
                }
            }
        }
        if (leafNode.C0().isEmpty()) {
            return n;
        }
        return n + 24L + a((LeafNode<?>)leafNode.C0());
    }
    
    public static long b(final Node node) {
        if (node.isEmpty()) {
            return 4L;
        }
        if (node.p1()) {
            return a((LeafNode<?>)node);
        }
        final boolean b = node instanceof ChildrenNode;
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected node type: ");
        sb.append(node.getClass());
        Utilities.g(b, sb.toString());
        long n = 1L;
        for (final NamedNode namedNode : node) {
            n = n + namedNode.c().c().length() + 4L + b(namedNode.d());
        }
        long n2 = n;
        if (!node.C0().isEmpty()) {
            n2 = n + 12L + a((LeafNode<?>)node.C0());
        }
        return n2;
    }
    
    public static int c(final Node node) {
        final boolean empty = node.isEmpty();
        int n = 0;
        if (empty) {
            return 0;
        }
        if (node.p1()) {
            return 1;
        }
        final boolean b = node instanceof ChildrenNode;
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected node type: ");
        sb.append(node.getClass());
        Utilities.g(b, sb.toString());
        final Iterator<NamedNode> iterator = node.iterator();
        while (iterator.hasNext()) {
            n += c(iterator.next().d());
        }
        return n;
    }
}
