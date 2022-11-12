// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class c extends CustomAttribute
{
    private final String a;
    private final String b;
    
    private c(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    c(final String s, final String s2, final c$a object) {
        this(s, s2);
    }
    
    @Override
    public String b() {
        return this.a;
    }
    
    @Override
    public String c() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof CustomAttribute) {
            final CustomAttribute customAttribute = (CustomAttribute)o;
            if (!this.a.equals(customAttribute.b()) || !this.b.equals(customAttribute.c())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CustomAttribute{key=");
        sb.append(this.a);
        sb.append(", value=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private String b;
        
        @Override
        public CustomAttribute a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" key");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" value");
                string2 = sb2.toString();
            }
            if (string2.isEmpty()) {
                return new c(this.a, this.b, null);
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing required properties:");
            sb3.append(string2);
            throw new IllegalStateException(sb3.toString());
        }
        
        @Override
        public Builder b(final String a) {
            Objects.requireNonNull(a, "Null key");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder c(final String b) {
            Objects.requireNonNull(b, "Null value");
            this.b = b;
            return this;
        }
    }
}
