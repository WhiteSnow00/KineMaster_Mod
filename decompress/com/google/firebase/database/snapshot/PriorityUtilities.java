// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.Path;

public class PriorityUtilities
{
    public static Node a() {
        return EmptyNode.p();
    }
    
    public static boolean b(final Node node) {
        return node.C0().isEmpty() && (node.isEmpty() || node instanceof DoubleNode || node instanceof StringNode || node instanceof DeferredValueNode);
    }
    
    public static Node c(final Path path, Object o) {
        DoubleNode a;
        final Node node = a = (DoubleNode)NodeUtilities.a(o);
        if (node instanceof LongNode) {
            a = new DoubleNode(Double.valueOf((long)node.getValue()), a());
        }
        if (!b(a)) {
            o = new StringBuilder();
            String string;
            if (path != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Path '");
                sb.append(path);
                sb.append("'");
                string = sb.toString();
            }
            else {
                string = "Node";
            }
            ((StringBuilder)o).append(string);
            ((StringBuilder)o).append(" contains invalid priority: Must be a string, double, ServerValue, or null");
            throw new DatabaseException(((StringBuilder)o).toString());
        }
        return a;
    }
    
    public static Node d(final Object o) {
        return c(null, o);
    }
}
