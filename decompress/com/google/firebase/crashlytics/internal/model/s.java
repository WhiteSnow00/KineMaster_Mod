// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class s extends Log
{
    private final String a;
    
    private s(final String a) {
        this.a = a;
    }
    
    s(final String s, final s$a object) {
        this(s);
    }
    
    @Override
    public String b() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o instanceof Log && this.a.equals(((Log)o).b()));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() ^ 0xF4243;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Log{content=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        
        @Override
        public Log a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" content");
                string = sb.toString();
            }
            if (string.isEmpty()) {
                return new s(this.a, null);
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Missing required properties:");
            sb2.append(string);
            throw new IllegalStateException(sb2.toString());
        }
        
        @Override
        public Builder b(final String a) {
            Objects.requireNonNull(a, "Null content");
            this.a = a;
            return this;
        }
    }
}
