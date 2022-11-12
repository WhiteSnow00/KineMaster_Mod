// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class k extends Application
{
    private final Execution a;
    private final ImmutableList<CustomAttribute> b;
    private final ImmutableList<CustomAttribute> c;
    private final Boolean d;
    private final int e;
    
    private k(final Execution a, final ImmutableList<CustomAttribute> b, final ImmutableList<CustomAttribute> c, final Boolean d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    k(final Execution execution, final ImmutableList list, final ImmutableList list2, final Boolean b, final int n, final k$a object) {
        this(execution, list, list2, b, n);
    }
    
    @Override
    public Boolean b() {
        return this.d;
    }
    
    @Override
    public ImmutableList<CustomAttribute> c() {
        return this.b;
    }
    
    @Override
    public Execution d() {
        return this.a;
    }
    
    @Override
    public ImmutableList<CustomAttribute> e() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Application) {
            final Application application = (Application)o;
            if (this.a.equals(application.d())) {
                final ImmutableList<CustomAttribute> b2 = this.b;
                if (b2 == null) {
                    if (application.c() != null) {
                        return false;
                    }
                }
                else if (!b2.equals(application.c())) {
                    return false;
                }
                final ImmutableList<CustomAttribute> c = this.c;
                if (c == null) {
                    if (application.e() != null) {
                        return false;
                    }
                }
                else if (!c.equals(application.e())) {
                    return false;
                }
                final Boolean d = this.d;
                if (d == null) {
                    if (application.b() != null) {
                        return false;
                    }
                }
                else if (!d.equals(application.b())) {
                    return false;
                }
                if (this.e == application.f()) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int f() {
        return this.e;
    }
    
    @Override
    public Builder g() {
        return new b(this, null);
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final ImmutableList<CustomAttribute> b = this.b;
        int hashCode2 = 0;
        int hashCode3;
        if (b == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = b.hashCode();
        }
        final ImmutableList<CustomAttribute> c = this.c;
        int hashCode4;
        if (c == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = c.hashCode();
        }
        final Boolean d = this.d;
        if (d != null) {
            hashCode2 = d.hashCode();
        }
        return ((((hashCode ^ 0xF4243) * 1000003 ^ hashCode3) * 1000003 ^ hashCode4) * 1000003 ^ hashCode2) * 1000003 ^ this.e;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Application{execution=");
        sb.append(this.a);
        sb.append(", customAttributes=");
        sb.append(this.b);
        sb.append(", internalKeys=");
        sb.append(this.c);
        sb.append(", background=");
        sb.append(this.d);
        sb.append(", uiOrientation=");
        sb.append(this.e);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private Execution a;
        private ImmutableList<CustomAttribute> b;
        private ImmutableList<CustomAttribute> c;
        private Boolean d;
        private Integer e;
        
        b() {
        }
        
        private b(final Application application) {
            this.a = application.d();
            this.b = application.c();
            this.c = application.e();
            this.d = application.b();
            this.e = application.f();
        }
        
        b(final Application application, final k$a object) {
            this(application);
        }
        
        @Override
        public Application a() {
            final Execution a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" execution");
                string = sb.toString();
            }
            String string2 = string;
            if (this.e == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" uiOrientation");
                string2 = sb2.toString();
            }
            if (string2.isEmpty()) {
                return new k(this.a, this.b, this.c, this.d, this.e, null);
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing required properties:");
            sb3.append(string2);
            throw new IllegalStateException(sb3.toString());
        }
        
        @Override
        public Builder b(final Boolean d) {
            this.d = d;
            return this;
        }
        
        @Override
        public Builder c(final ImmutableList<CustomAttribute> b) {
            this.b = b;
            return this;
        }
        
        @Override
        public Builder d(final Execution a) {
            Objects.requireNonNull(a, "Null execution");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder e(final ImmutableList<CustomAttribute> c) {
            this.c = c;
            return this;
        }
        
        @Override
        public Builder f(final int n) {
            this.e = n;
            return this;
        }
    }
}
