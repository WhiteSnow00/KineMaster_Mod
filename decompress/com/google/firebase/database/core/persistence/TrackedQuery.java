// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

public final class TrackedQuery
{
    public final long a;
    public final QuerySpec b;
    public final long c;
    public final boolean d;
    public final boolean e;
    
    public TrackedQuery(final long a, final QuerySpec b, final long c, final boolean d, final boolean e) {
        this.a = a;
        if (b.g() && !b.f()) {
            throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
        }
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public TrackedQuery a(final boolean b) {
        return new TrackedQuery(this.a, this.b, this.c, this.d, b);
    }
    
    public TrackedQuery b() {
        return new TrackedQuery(this.a, this.b, this.c, true, this.e);
    }
    
    public TrackedQuery c(final long n) {
        return new TrackedQuery(this.a, this.b, n, this.d, this.e);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o != null && o.getClass() == TrackedQuery.class) {
            final TrackedQuery trackedQuery = (TrackedQuery)o;
            if (this.a != trackedQuery.a || !this.b.equals(trackedQuery.b) || this.c != trackedQuery.c || this.d != trackedQuery.d || this.e != trackedQuery.e) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (((Long.valueOf(this.a).hashCode() * 31 + this.b.hashCode()) * 31 + Long.valueOf(this.c).hashCode()) * 31 + Boolean.valueOf(this.d).hashCode()) * 31 + Boolean.valueOf(this.e).hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TrackedQuery{id=");
        sb.append(this.a);
        sb.append(", querySpec=");
        sb.append(this.b);
        sb.append(", lastUse=");
        sb.append(this.c);
        sb.append(", complete=");
        sb.append(this.d);
        sb.append(", active=");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
}
