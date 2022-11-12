// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class p extends Thread
{
    private final String a;
    private final int b;
    private final ImmutableList<Frame> c;
    
    private p(final String a, final int b, final ImmutableList<Frame> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    p(final String s, final int n, final ImmutableList list, final p$a object) {
        this(s, n, list);
    }
    
    @Override
    public ImmutableList<Frame> b() {
        return this.c;
    }
    
    @Override
    public int c() {
        return this.b;
    }
    
    @Override
    public String d() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Thread) {
            final Thread thread = (Thread)o;
            if (!this.a.equals(thread.d()) || this.b != thread.c() || !this.c.equals(thread.b())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b) * 1000003 ^ this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Thread{name=");
        sb.append(this.a);
        sb.append(", importance=");
        sb.append(this.b);
        sb.append(", frames=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private Integer b;
        private ImmutableList<Frame> c;
        
        @Override
        public Thread a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" name");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" importance");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" frames");
                string3 = sb3.toString();
            }
            if (string3.isEmpty()) {
                return new p(this.a, this.b, this.c, null);
            }
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Missing required properties:");
            sb4.append(string3);
            throw new IllegalStateException(sb4.toString());
        }
        
        @Override
        public Builder b(final ImmutableList<Frame> c) {
            Objects.requireNonNull(c, "Null frames");
            this.c = c;
            return this;
        }
        
        @Override
        public Builder c(final int n) {
            this.b = n;
            return this;
        }
        
        @Override
        public Builder d(final String a) {
            Objects.requireNonNull(a, "Null name");
            this.a = a;
            return this;
        }
    }
}
