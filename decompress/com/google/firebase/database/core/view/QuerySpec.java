// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.Index;
import java.util.Map;
import com.google.firebase.database.core.Path;

public final class QuerySpec
{
    private final Path a;
    private final QueryParams b;
    
    public QuerySpec(final Path a, final QueryParams b) {
        this.a = a;
        this.b = b;
    }
    
    public static QuerySpec a(final Path path) {
        return new QuerySpec(path, QueryParams.i);
    }
    
    public static QuerySpec b(final Path path, final Map<String, Object> map) {
        return new QuerySpec(path, QueryParams.a(map));
    }
    
    public Index c() {
        return this.b.b();
    }
    
    public QueryParams d() {
        return this.b;
    }
    
    public Path e() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && QuerySpec.class == o.getClass()) {
            final QuerySpec querySpec = (QuerySpec)o;
            return this.a.equals(querySpec.a) && this.b.equals(querySpec.b);
        }
        return false;
    }
    
    public boolean f() {
        return this.b.m();
    }
    
    public boolean g() {
        return this.b.o();
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(":");
        sb.append(this.b);
        return sb.toString();
    }
}
