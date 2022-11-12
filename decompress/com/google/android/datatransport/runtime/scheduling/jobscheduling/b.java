// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Objects;
import java.util.Set;

final class b extends ConfigValue
{
    private final long a;
    private final long b;
    private final Set<Flag> c;
    
    private b(final long a, final long b, final Set<Flag> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    b(final long n, final long n2, final Set set, final b$a object) {
        this(n, n2, set);
    }
    
    @Override
    long b() {
        return this.a;
    }
    
    @Override
    Set<Flag> c() {
        return this.c;
    }
    
    @Override
    long d() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof ConfigValue) {
            final ConfigValue configValue = (ConfigValue)o;
            if (this.a != configValue.b() || this.b != configValue.d() || !this.c.equals(configValue.c())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        final int n = (int)(a ^ a >>> 32);
        final long b = this.b;
        return ((n ^ 0xF4243) * 1000003 ^ (int)(b >>> 32 ^ b)) * 1000003 ^ this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ConfigValue{delta=");
        sb.append(this.a);
        sb.append(", maxAllowedDelay=");
        sb.append(this.b);
        sb.append(", flags=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Long a;
        private Long b;
        private Set<Flag> c;
        
        @Override
        public ConfigValue a() {
            final Long a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" delta");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" maxAllowedDelay");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" flags");
                string3 = sb3.toString();
            }
            if (string3.isEmpty()) {
                return new com.google.android.datatransport.runtime.scheduling.jobscheduling.b(this.a, this.b, this.c, null);
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Missing required properties:");
            sb4.append(string3);
            throw new IllegalStateException(sb4.toString());
        }
        
        @Override
        public Builder b(final long n) {
            this.a = n;
            return this;
        }
        
        @Override
        public Builder c(final Set<Flag> c) {
            Objects.requireNonNull(c, "Null flags");
            this.c = c;
            return this;
        }
        
        @Override
        public Builder d(final long n) {
            this.b = n;
            return this;
        }
    }
}
