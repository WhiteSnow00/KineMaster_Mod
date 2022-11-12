// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

public final class Tag
{
    private final long a;
    
    public Tag(final long a) {
        this.a = a;
    }
    
    public long a() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && Tag.class == o.getClass() && this.a == ((Tag)o).a);
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        return (int)(a ^ a >>> 32);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Tag{tagNumber=");
        sb.append(this.a);
        sb.append('}');
        return sb.toString();
    }
}
