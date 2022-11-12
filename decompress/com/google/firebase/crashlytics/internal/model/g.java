// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class g extends Application
{
    private final String a;
    private final String b;
    private final String c;
    private final Organization d;
    private final String e;
    private final String f;
    private final String g;
    
    private g(final String a, final String b, final String c, final Organization d, final String e, final String f, final String g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    g(final String s, final String s2, final String s3, final Organization organization, final String s4, final String s5, final String s6, final g$a object) {
        this(s, s2, s3, organization, s4, s5, s6);
    }
    
    @Override
    public String b() {
        return this.f;
    }
    
    @Override
    public String c() {
        return this.g;
    }
    
    @Override
    public String d() {
        return this.c;
    }
    
    @Override
    public String e() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Application) {
            final Application application = (Application)o;
            if (this.a.equals(application.e()) && this.b.equals(application.h())) {
                final String c = this.c;
                if (c == null) {
                    if (application.d() != null) {
                        return false;
                    }
                }
                else if (!c.equals(application.d())) {
                    return false;
                }
                final Organization d = this.d;
                if (d == null) {
                    if (application.g() != null) {
                        return false;
                    }
                }
                else if (!d.equals(application.g())) {
                    return false;
                }
                final String e = this.e;
                if (e == null) {
                    if (application.f() != null) {
                        return false;
                    }
                }
                else if (!e.equals(application.f())) {
                    return false;
                }
                final String f = this.f;
                if (f == null) {
                    if (application.b() != null) {
                        return false;
                    }
                }
                else if (!f.equals(application.b())) {
                    return false;
                }
                final String g = this.g;
                if (g == null) {
                    if (application.c() == null) {
                        return b;
                    }
                }
                else if (g.equals(application.c())) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public String f() {
        return this.e;
    }
    
    @Override
    public Organization g() {
        return this.d;
    }
    
    @Override
    public String h() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int hashCode2 = this.b.hashCode();
        final String c = this.c;
        int hashCode3 = 0;
        int hashCode4;
        if (c == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = c.hashCode();
        }
        final Organization d = this.d;
        int hashCode5;
        if (d == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = d.hashCode();
        }
        final String e = this.e;
        int hashCode6;
        if (e == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = e.hashCode();
        }
        final String f = this.f;
        int hashCode7;
        if (f == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = f.hashCode();
        }
        final String g = this.g;
        if (g != null) {
            hashCode3 = g.hashCode();
        }
        return ((((((hashCode ^ 0xF4243) * 1000003 ^ hashCode2) * 1000003 ^ hashCode4) * 1000003 ^ hashCode5) * 1000003 ^ hashCode6) * 1000003 ^ hashCode7) * 1000003 ^ hashCode3;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Application{identifier=");
        sb.append(this.a);
        sb.append(", version=");
        sb.append(this.b);
        sb.append(", displayVersion=");
        sb.append(this.c);
        sb.append(", organization=");
        sb.append(this.d);
        sb.append(", installationUuid=");
        sb.append(this.e);
        sb.append(", developmentPlatform=");
        sb.append(this.f);
        sb.append(", developmentPlatformVersion=");
        sb.append(this.g);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private String b;
        private String c;
        private Organization d;
        private String e;
        private String f;
        private String g;
        
        @Override
        public Application a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" identifier");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" version");
                string2 = sb2.toString();
            }
            if (string2.isEmpty()) {
                return new g(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Missing required properties:");
            sb3.append(string2);
            throw new IllegalStateException(sb3.toString());
        }
        
        @Override
        public Builder b(final String f) {
            this.f = f;
            return this;
        }
        
        @Override
        public Builder c(final String g) {
            this.g = g;
            return this;
        }
        
        @Override
        public Builder d(final String c) {
            this.c = c;
            return this;
        }
        
        @Override
        public Builder e(final String a) {
            Objects.requireNonNull(a, "Null identifier");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder f(final String e) {
            this.e = e;
            return this;
        }
        
        @Override
        public Builder g(final String b) {
            Objects.requireNonNull(b, "Null version");
            this.b = b;
            return this;
        }
    }
}
