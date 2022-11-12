// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class l extends Execution
{
    private final ImmutableList<Thread> a;
    private final Exception b;
    private final ApplicationExitInfo c;
    private final Signal d;
    private final ImmutableList<BinaryImage> e;
    
    private l(final ImmutableList<Thread> a, final Exception b, final ApplicationExitInfo c, final Signal d, final ImmutableList<BinaryImage> e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    l(final ImmutableList list, final Exception ex, final ApplicationExitInfo applicationExitInfo, final Signal signal, final ImmutableList list2, final l$a object) {
        this(list, ex, applicationExitInfo, signal, list2);
    }
    
    @Override
    public ApplicationExitInfo b() {
        return this.c;
    }
    
    @Override
    public ImmutableList<BinaryImage> c() {
        return this.e;
    }
    
    @Override
    public Exception d() {
        return this.b;
    }
    
    @Override
    public Signal e() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Execution) {
            final Execution execution = (Execution)o;
            final ImmutableList<Thread> a = this.a;
            if (a == null) {
                if (execution.f() != null) {
                    return false;
                }
            }
            else if (!a.equals(execution.f())) {
                return false;
            }
            final Exception b2 = this.b;
            if (b2 == null) {
                if (execution.d() != null) {
                    return false;
                }
            }
            else if (!b2.equals(execution.d())) {
                return false;
            }
            final ApplicationExitInfo c = this.c;
            if (c == null) {
                if (execution.b() != null) {
                    return false;
                }
            }
            else if (!c.equals(execution.b())) {
                return false;
            }
            if (this.d.equals(execution.e()) && this.e.equals(execution.c())) {
                return b;
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public ImmutableList<Thread> f() {
        return this.a;
    }
    
    @Override
    public int hashCode() {
        final ImmutableList<Thread> a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = a.hashCode();
        }
        final Exception b = this.b;
        int hashCode3;
        if (b == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = b.hashCode();
        }
        final ApplicationExitInfo c = this.c;
        if (c != null) {
            hashCode = c.hashCode();
        }
        return ((((hashCode2 ^ 0xF4243) * 1000003 ^ hashCode3) * 1000003 ^ hashCode) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Execution{threads=");
        sb.append(this.a);
        sb.append(", exception=");
        sb.append(this.b);
        sb.append(", appExitInfo=");
        sb.append(this.c);
        sb.append(", signal=");
        sb.append(this.d);
        sb.append(", binaries=");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private ImmutableList<Thread> a;
        private Exception b;
        private ApplicationExitInfo c;
        private Signal d;
        private ImmutableList<BinaryImage> e;
        
        @Override
        public Execution a() {
            final Signal d = this.d;
            String string = "";
            if (d == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" signal");
                string = sb.toString();
            }
            String string2 = string;
            if (this.e == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" binaries");
                string2 = sb2.toString();
            }
            if (string2.isEmpty()) {
                return new l(this.a, this.b, this.c, this.d, this.e, null);
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing required properties:");
            sb3.append(string2);
            throw new IllegalStateException(sb3.toString());
        }
        
        @Override
        public Builder b(final ApplicationExitInfo c) {
            this.c = c;
            return this;
        }
        
        @Override
        public Builder c(final ImmutableList<BinaryImage> e) {
            Objects.requireNonNull(e, "Null binaries");
            this.e = e;
            return this;
        }
        
        @Override
        public Builder d(final Exception b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder e(final Signal d) {
            Objects.requireNonNull(d, "Null signal");
            this.d = d;
            return this;
        }
        
        @Override
        public Builder f(final ImmutableList<Thread> a) {
            this.a = a;
            return this;
        }
    }
}
