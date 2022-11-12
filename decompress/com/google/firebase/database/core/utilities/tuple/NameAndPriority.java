// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.ChildKey;

public class NameAndPriority implements Comparable<NameAndPriority>
{
    private ChildKey a;
    private Node b;
    
    public int a(final NameAndPriority nameAndPriority) {
        return NodeUtilities.c(this.a, this.b, nameAndPriority.a, nameAndPriority.b);
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.a((NameAndPriority)o);
    }
}
