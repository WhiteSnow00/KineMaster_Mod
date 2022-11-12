// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.IndexedNode;

public class DataSnapshot
{
    private final IndexedNode a;
    private final DatabaseReference b;
    
    DataSnapshot(final DatabaseReference b, final IndexedNode a) {
        this.a = a;
        this.b = b;
    }
    
    public DataSnapshot a(final String s) {
        return new DataSnapshot(this.b.h(s), IndexedNode.b(this.a.k().F(new Path(s))));
    }
    
    public boolean b() {
        return this.a.k().isEmpty() ^ true;
    }
    
    public String c() {
        return this.b.i();
    }
    
    public DatabaseReference d() {
        return this.b;
    }
    
    public <T> T e(final Class<T> clazz) {
        return CustomClassMapper.i(this.a.k().getValue(), clazz);
    }
    
    public Object f(final boolean b) {
        return this.a.k().t0(b);
    }
    
    public boolean g(final String s) {
        if (this.b.j() == null) {
            Validation.f(s);
        }
        else {
            Validation.e(s);
        }
        return this.a.k().F(new Path(s)).isEmpty() ^ true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DataSnapshot { key = ");
        sb.append(this.b.i());
        sb.append(", value = ");
        sb.append(this.a.k().t0(true));
        sb.append(" }");
        return sb.toString();
    }
}
