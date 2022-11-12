// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.snapshot;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.List;
import com.google.firebase.database.core.Path;

public class RangeMerge
{
    private final Path a;
    private final Path b;
    private final Node c;
    
    public RangeMerge(final com.google.firebase.database.connection.RangeMerge rangeMerge) {
        final List<String> a = rangeMerge.a();
        final Path path = null;
        Path a2;
        if (a != null) {
            a2 = new Path(a);
        }
        else {
            a2 = null;
        }
        this.a = a2;
        final List<String> b = rangeMerge.b();
        Path b2 = path;
        if (b != null) {
            b2 = new Path(b);
        }
        this.b = b2;
        this.c = NodeUtilities.a(rangeMerge.c());
    }
    
    private Node b(final Path path, final Node node, final Node node2) {
        final Path a = this.a;
        final boolean b = true;
        int o;
        if (a == null) {
            o = 1;
        }
        else {
            o = path.o(a);
        }
        final Path b2 = this.b;
        int o2;
        if (b2 == null) {
            o2 = -1;
        }
        else {
            o2 = path.o(b2);
        }
        final Path a2 = this.a;
        final boolean b3 = a2 != null && path.p(a2);
        final Path b4 = this.b;
        final boolean b5 = b4 != null && path.p(b4);
        if (o > 0 && o2 < 0 && !b5) {
            return node2;
        }
        if (o > 0 && b5 && node2.p1()) {
            return node2;
        }
        if (o > 0 && o2 == 0) {
            Utilities.f(b5);
            Utilities.f(node2.p1() ^ true);
            if (node.p1()) {
                return EmptyNode.p();
            }
            return node;
        }
        else {
            if (!b3 && !b5) {
                boolean b6 = b;
                if (o2 <= 0) {
                    b6 = (o <= 0 && b);
                }
                Utilities.f(b6);
                return node;
            }
            final HashSet set = new HashSet();
            final Iterator<NamedNode> iterator = node.iterator();
            while (iterator.hasNext()) {
                set.add(iterator.next().c());
            }
            final Iterator<NamedNode> iterator2 = node2.iterator();
            while (iterator2.hasNext()) {
                set.add(iterator2.next().c());
            }
            final ArrayList list = new ArrayList(set.size() + 1);
            list.addAll(set);
            if (!node2.C0().isEmpty() || !node.C0().isEmpty()) {
                list.add((Object)ChildKey.i());
            }
            final Iterator iterator3 = list.iterator();
            Node r0 = node;
            while (iterator3.hasNext()) {
                final ChildKey childKey = (ChildKey)iterator3.next();
                final Node c0 = node.c0(childKey);
                final Node b7 = this.b(path.n(childKey), node.c0(childKey), node2.c0(childKey));
                if (b7 != c0) {
                    r0 = r0.r0(childKey, b7);
                }
            }
            return r0;
        }
    }
    
    public Node a(final Node node) {
        return this.b(Path.s(), node, this.c);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("RangeMerge{optExclusiveStart=");
        sb.append(this.a);
        sb.append(", optInclusiveEnd=");
        sb.append(this.b);
        sb.append(", snap=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
}
