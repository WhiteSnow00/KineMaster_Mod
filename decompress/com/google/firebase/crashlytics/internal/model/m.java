// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;
import com.google.firebase.encoders.annotations.Encodable$Ignore;

final class m extends BinaryImage
{
    private final long a;
    private final long b;
    private final String c;
    private final String d;
    
    private m(final long a, final long b, final String c, final String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    m(final long n, final long n2, final String s, final String s2, final m$a object) {
        this(n, n2, s, s2);
    }
    
    @Override
    public long b() {
        return this.a;
    }
    
    @Override
    public String c() {
        return this.c;
    }
    
    @Override
    public long d() {
        return this.b;
    }
    
    @Encodable$Ignore
    @Override
    public String e() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof BinaryImage) {
            final BinaryImage binaryImage = (BinaryImage)o;
            if (this.a == binaryImage.b() && this.b == binaryImage.d() && this.c.equals(binaryImage.c())) {
                final String d = this.d;
                if (d == null) {
                    if (binaryImage.e() == null) {
                        return b;
                    }
                }
                else if (d.equals(binaryImage.e())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final long a = this.a;
        final int n = (int)(a ^ a >>> 32);
        final long b = this.b;
        final int n2 = (int)(b >>> 32 ^ b);
        final int hashCode = this.c.hashCode();
        final String d = this.d;
        int hashCode2;
        if (d == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = d.hashCode();
        }
        return (((n ^ 0xF4243) * 1000003 ^ n2) * 1000003 ^ hashCode) * 1000003 ^ hashCode2;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BinaryImage{baseAddress=");
        sb.append(this.a);
        sb.append(", size=");
        sb.append(this.b);
        sb.append(", name=");
        sb.append(this.c);
        sb.append(", uuid=");
        sb.append(this.d);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Long a;
        private Long b;
        private String c;
        private String d;
        
        @Override
        public BinaryImage a() {
            final Long a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" baseAddress");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" size");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" name");
                string3 = sb3.toString();
            }
            if (string3.isEmpty()) {
                return new m(this.a, this.b, this.c, this.d, null);
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
        public Builder c(final String c) {
            Objects.requireNonNull(c, "Null name");
            this.c = c;
            return this;
        }
        
        @Override
        public Builder d(final long n) {
            this.b = n;
            return this;
        }
        
        @Override
        public Builder e(final String d) {
            this.d = d;
            return this;
        }
    }
}
