// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class u extends User
{
    private final String a;
    
    private u(final String a) {
        this.a = a;
    }
    
    u(final String s, final u$a object) {
        this(s);
    }
    
    @Override
    public String b() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o instanceof User && this.a.equals(((User)o).b()));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() ^ 0xF4243;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User{identifier=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        
        @Override
        public User a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" identifier");
                string = sb.toString();
            }
            if (string.isEmpty()) {
                return new u(this.a, null);
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Missing required properties:");
            sb2.append(string);
            throw new IllegalStateException(sb2.toString());
        }
        
        @Override
        public Builder b(final String a) {
            Objects.requireNonNull(a, "Null identifier");
            this.a = a;
            return this;
        }
    }
}
