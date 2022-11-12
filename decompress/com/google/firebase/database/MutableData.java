// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;

public class MutableData
{
    private final SnapshotHolder a;
    private final Path b;
    
    private MutableData(final SnapshotHolder a, final Path b) {
        this.a = a;
        ValidationPath.g(this.b = b, this.b());
    }
    
    MutableData(final Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }
    
    Node a() {
        return this.a.a(this.b);
    }
    
    public Object b() {
        return this.a().getValue();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof MutableData) {
            final SnapshotHolder a = this.a;
            final MutableData mutableData = (MutableData)o;
            if (a.equals(mutableData.a) && this.b.equals(mutableData.b)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        final ChildKey t = this.b.t();
        final StringBuilder sb = new StringBuilder();
        sb.append("MutableData { key = ");
        String c;
        if (t != null) {
            c = t.c();
        }
        else {
            c = "<none>";
        }
        sb.append(c);
        sb.append(", value = ");
        sb.append(this.a.b().t0(true));
        sb.append(" }");
        return sb.toString();
    }
}
