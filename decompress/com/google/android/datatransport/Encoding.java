// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport;

import java.util.Objects;

public final class Encoding
{
    private final String a;
    
    private Encoding(final String a) {
        Objects.requireNonNull(a, "name is null");
        this.a = a;
    }
    
    public static Encoding b(final String s) {
        return new Encoding(s);
    }
    
    public String a() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof Encoding && this.a.equals(((Encoding)o).a));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() ^ 0xF4243;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Encoding{name=\"");
        sb.append(this.a);
        sb.append("\"}");
        return sb.toString();
    }
}
