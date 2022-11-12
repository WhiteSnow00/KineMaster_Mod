// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import java.util.Iterator;
import java.util.HashMap;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;

public class TreeNode<T>
{
    public Map<ChildKey, TreeNode<T>> a;
    public T b;
    
    public TreeNode() {
        this.a = new HashMap<ChildKey, TreeNode<T>>();
    }
    
    String a(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("<value>: ");
        sb.append(this.b);
        sb.append("\n");
        String s2 = sb.toString();
        if (this.a.isEmpty()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s2);
            sb2.append(s);
            sb2.append("<empty>");
            return sb2.toString();
        }
        for (final Map.Entry<Object, V> entry : this.a.entrySet()) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(s2);
            sb3.append(s);
            sb3.append(entry.getKey());
            sb3.append(":\n");
            final TreeNode treeNode = (TreeNode)entry.getValue();
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(s);
            sb4.append("\t");
            sb3.append(treeNode.a(sb4.toString()));
            sb3.append("\n");
            s2 = sb3.toString();
        }
        return s2;
    }
}
