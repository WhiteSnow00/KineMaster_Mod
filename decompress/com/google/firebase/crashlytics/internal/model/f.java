// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;
import com.google.firebase.encoders.annotations.Encodable$Ignore;

final class f extends Session
{
    private final String a;
    private final String b;
    private final long c;
    private final Long d;
    private final boolean e;
    private final Application f;
    private final User g;
    private final OperatingSystem h;
    private final Device i;
    private final ImmutableList<Event> j;
    private final int k;
    
    private f(final String a, final String b, final long c, final Long d, final boolean e, final Application f, final User g, final OperatingSystem h, final Device i, final ImmutableList<Event> j, final int k) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
    }
    
    f(final String s, final String s2, final long n, final Long n2, final boolean b, final Application application, final User user, final OperatingSystem operatingSystem, final Device device, final ImmutableList list, final int n3, final f$a object) {
        this(s, s2, n, n2, b, application, user, operatingSystem, device, list, n3);
    }
    
    @Override
    public Application b() {
        return this.f;
    }
    
    @Override
    public Device c() {
        return this.i;
    }
    
    @Override
    public Long d() {
        return this.d;
    }
    
    @Override
    public ImmutableList<Event> e() {
        return this.j;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Session) {
            final Session session = (Session)o;
            if (this.a.equals(session.f()) && this.b.equals(session.h()) && this.c == session.k()) {
                final Long d = this.d;
                if (d == null) {
                    if (session.d() != null) {
                        return false;
                    }
                }
                else if (!d.equals(session.d())) {
                    return false;
                }
                if (this.e == session.m() && this.f.equals(session.b())) {
                    final User g = this.g;
                    if (g == null) {
                        if (session.l() != null) {
                            return false;
                        }
                    }
                    else if (!g.equals(session.l())) {
                        return false;
                    }
                    final OperatingSystem h = this.h;
                    if (h == null) {
                        if (session.j() != null) {
                            return false;
                        }
                    }
                    else if (!h.equals(session.j())) {
                        return false;
                    }
                    final Device i = this.i;
                    if (i == null) {
                        if (session.c() != null) {
                            return false;
                        }
                    }
                    else if (!i.equals(session.c())) {
                        return false;
                    }
                    final ImmutableList<Event> j = this.j;
                    if (j == null) {
                        if (session.e() != null) {
                            return false;
                        }
                    }
                    else if (!j.equals(session.e())) {
                        return false;
                    }
                    if (this.k == session.g()) {
                        return b;
                    }
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public String f() {
        return this.a;
    }
    
    @Override
    public int g() {
        return this.k;
    }
    
    @Encodable$Ignore
    @Override
    public String h() {
        return this.b;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int hashCode2 = this.b.hashCode();
        final long c = this.c;
        final int n = (int)(c ^ c >>> 32);
        final Long d = this.d;
        int hashCode3 = 0;
        int hashCode4;
        if (d == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = d.hashCode();
        }
        int n2;
        if (this.e) {
            n2 = 1231;
        }
        else {
            n2 = 1237;
        }
        final int hashCode5 = this.f.hashCode();
        final User g = this.g;
        int hashCode6;
        if (g == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = g.hashCode();
        }
        final OperatingSystem h = this.h;
        int hashCode7;
        if (h == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = h.hashCode();
        }
        final Device i = this.i;
        int hashCode8;
        if (i == null) {
            hashCode8 = 0;
        }
        else {
            hashCode8 = i.hashCode();
        }
        final ImmutableList<Event> j = this.j;
        if (j != null) {
            hashCode3 = j.hashCode();
        }
        return ((((((((((hashCode ^ 0xF4243) * 1000003 ^ hashCode2) * 1000003 ^ n) * 1000003 ^ hashCode4) * 1000003 ^ n2) * 1000003 ^ hashCode5) * 1000003 ^ hashCode6) * 1000003 ^ hashCode7) * 1000003 ^ hashCode8) * 1000003 ^ hashCode3) * 1000003 ^ this.k;
    }
    
    @Override
    public OperatingSystem j() {
        return this.h;
    }
    
    @Override
    public long k() {
        return this.c;
    }
    
    @Override
    public User l() {
        return this.g;
    }
    
    @Override
    public boolean m() {
        return this.e;
    }
    
    @Override
    public Builder n() {
        return new b(this, null);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Session{generator=");
        sb.append(this.a);
        sb.append(", identifier=");
        sb.append(this.b);
        sb.append(", startedAt=");
        sb.append(this.c);
        sb.append(", endedAt=");
        sb.append(this.d);
        sb.append(", crashed=");
        sb.append(this.e);
        sb.append(", app=");
        sb.append(this.f);
        sb.append(", user=");
        sb.append(this.g);
        sb.append(", os=");
        sb.append(this.h);
        sb.append(", device=");
        sb.append(this.i);
        sb.append(", events=");
        sb.append(this.j);
        sb.append(", generatorType=");
        sb.append(this.k);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private String b;
        private Long c;
        private Long d;
        private Boolean e;
        private Application f;
        private User g;
        private OperatingSystem h;
        private Device i;
        private ImmutableList<Event> j;
        private Integer k;
        
        b() {
        }
        
        private b(final Session session) {
            this.a = session.f();
            this.b = session.h();
            this.c = session.k();
            this.d = session.d();
            this.e = session.m();
            this.f = session.b();
            this.g = session.l();
            this.h = session.j();
            this.i = session.c();
            this.j = session.e();
            this.k = session.g();
        }
        
        b(final Session session, final f$a object) {
            this(session);
        }
        
        @Override
        public Session a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" generator");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" identifier");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" startedAt");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.e == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" crashed");
                string4 = sb4.toString();
            }
            String string5 = string4;
            if (this.f == null) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string4);
                sb5.append(" app");
                string5 = sb5.toString();
            }
            String string6 = string5;
            if (this.k == null) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append(string5);
                sb6.append(" generatorType");
                string6 = sb6.toString();
            }
            if (string6.isEmpty()) {
                return new f(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, null);
            }
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("Missing required properties:");
            sb7.append(string6);
            throw new IllegalStateException(sb7.toString());
        }
        
        @Override
        public Builder b(final Application f) {
            Objects.requireNonNull(f, "Null app");
            this.f = f;
            return this;
        }
        
        @Override
        public Builder c(final boolean b) {
            this.e = b;
            return this;
        }
        
        @Override
        public Builder d(final Device i) {
            this.i = i;
            return this;
        }
        
        @Override
        public Builder e(final Long d) {
            this.d = d;
            return this;
        }
        
        @Override
        public Builder f(final ImmutableList<Event> j) {
            this.j = j;
            return this;
        }
        
        @Override
        public Builder g(final String a) {
            Objects.requireNonNull(a, "Null generator");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder h(final int n) {
            this.k = n;
            return this;
        }
        
        @Override
        public Builder i(final String b) {
            Objects.requireNonNull(b, "Null identifier");
            this.b = b;
            return this;
        }
        
        @Override
        public Builder k(final OperatingSystem h) {
            this.h = h;
            return this;
        }
        
        @Override
        public Builder l(final long n) {
            this.c = n;
            return this;
        }
        
        @Override
        public Builder m(final User g) {
            this.g = g;
            return this;
        }
    }
}
