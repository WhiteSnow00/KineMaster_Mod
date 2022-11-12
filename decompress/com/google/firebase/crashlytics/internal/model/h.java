// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

final class h extends Organization
{
    private final String a;
    
    @Override
    public String a() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o instanceof Organization && this.a.equals(((Organization)o).a()));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() ^ 0xF4243;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Organization{clsId=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
