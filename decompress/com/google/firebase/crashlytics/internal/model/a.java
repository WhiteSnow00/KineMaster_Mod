// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class a extends CrashlyticsReport
{
    private final String b;
    private final String c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final Session h;
    private final FilesPayload i;
    
    private a(final String b, final String c, final int d, final String e, final String f, final String g, final Session h, final FilesPayload i) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    a(final String s, final String s2, final int n, final String s3, final String s4, final String s5, final Session session, final FilesPayload filesPayload, final a$a object) {
        this(s, s2, n, s3, s4, s5, session, filesPayload);
    }
    
    @Override
    public String c() {
        return this.f;
    }
    
    @Override
    public String d() {
        return this.g;
    }
    
    @Override
    public String e() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof CrashlyticsReport) {
            final CrashlyticsReport crashlyticsReport = (CrashlyticsReport)o;
            if (this.b.equals(crashlyticsReport.i()) && this.c.equals(crashlyticsReport.e()) && this.d == crashlyticsReport.h() && this.e.equals(crashlyticsReport.f()) && this.f.equals(crashlyticsReport.c()) && this.g.equals(crashlyticsReport.d())) {
                final Session h = this.h;
                if (h == null) {
                    if (crashlyticsReport.j() != null) {
                        return false;
                    }
                }
                else if (!h.equals(crashlyticsReport.j())) {
                    return false;
                }
                final FilesPayload i = this.i;
                if (i == null) {
                    if (crashlyticsReport.g() == null) {
                        return b;
                    }
                }
                else if (i.equals(crashlyticsReport.g())) {
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
    public FilesPayload g() {
        return this.i;
    }
    
    @Override
    public int h() {
        return this.d;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.b.hashCode();
        final int hashCode2 = this.c.hashCode();
        final int d = this.d;
        final int hashCode3 = this.e.hashCode();
        final int hashCode4 = this.f.hashCode();
        final int hashCode5 = this.g.hashCode();
        final Session h = this.h;
        int hashCode6 = 0;
        int hashCode7;
        if (h == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = h.hashCode();
        }
        final FilesPayload i = this.i;
        if (i != null) {
            hashCode6 = i.hashCode();
        }
        return (((((((hashCode ^ 0xF4243) * 1000003 ^ hashCode2) * 1000003 ^ d) * 1000003 ^ hashCode3) * 1000003 ^ hashCode4) * 1000003 ^ hashCode5) * 1000003 ^ hashCode7) * 1000003 ^ hashCode6;
    }
    
    @Override
    public String i() {
        return this.b;
    }
    
    @Override
    public Session j() {
        return this.h;
    }
    
    @Override
    protected Builder k() {
        return new b(this, null);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CrashlyticsReport{sdkVersion=");
        sb.append(this.b);
        sb.append(", gmpAppId=");
        sb.append(this.c);
        sb.append(", platform=");
        sb.append(this.d);
        sb.append(", installationUuid=");
        sb.append(this.e);
        sb.append(", buildVersion=");
        sb.append(this.f);
        sb.append(", displayVersion=");
        sb.append(this.g);
        sb.append(", session=");
        sb.append(this.h);
        sb.append(", ndkPayload=");
        sb.append(this.i);
        sb.append("}");
        return sb.toString();
    }
    
    static final class b extends Builder
    {
        private String a;
        private String b;
        private Integer c;
        private String d;
        private String e;
        private String f;
        private Session g;
        private FilesPayload h;
        
        b() {
        }
        
        private b(final CrashlyticsReport crashlyticsReport) {
            this.a = crashlyticsReport.i();
            this.b = crashlyticsReport.e();
            this.c = crashlyticsReport.h();
            this.d = crashlyticsReport.f();
            this.e = crashlyticsReport.c();
            this.f = crashlyticsReport.d();
            this.g = crashlyticsReport.j();
            this.h = crashlyticsReport.g();
        }
        
        b(final CrashlyticsReport crashlyticsReport, final a$a object) {
            this(crashlyticsReport);
        }
        
        @Override
        public CrashlyticsReport a() {
            final String a = this.a;
            String string = "";
            if (a == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(" sdkVersion");
                string = sb.toString();
            }
            String string2 = string;
            if (this.b == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(" gmpAppId");
                string2 = sb2.toString();
            }
            String string3 = string2;
            if (this.c == null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(" platform");
                string3 = sb3.toString();
            }
            String string4 = string3;
            if (this.d == null) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(" installationUuid");
                string4 = sb4.toString();
            }
            String string5 = string4;
            if (this.e == null) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append(string4);
                sb5.append(" buildVersion");
                string5 = sb5.toString();
            }
            String string6 = string5;
            if (this.f == null) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append(string5);
                sb6.append(" displayVersion");
                string6 = sb6.toString();
            }
            if (string6.isEmpty()) {
                return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
            }
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("Missing required properties:");
            sb7.append(string6);
            throw new IllegalStateException(sb7.toString());
        }
        
        @Override
        public Builder b(final String e) {
            Objects.requireNonNull(e, "Null buildVersion");
            this.e = e;
            return this;
        }
        
        @Override
        public Builder c(final String f) {
            Objects.requireNonNull(f, "Null displayVersion");
            this.f = f;
            return this;
        }
        
        @Override
        public Builder d(final String b) {
            Objects.requireNonNull(b, "Null gmpAppId");
            this.b = b;
            return this;
        }
        
        @Override
        public Builder e(final String d) {
            Objects.requireNonNull(d, "Null installationUuid");
            this.d = d;
            return this;
        }
        
        @Override
        public Builder f(final FilesPayload h) {
            this.h = h;
            return this;
        }
        
        @Override
        public Builder g(final int n) {
            this.c = n;
            return this;
        }
        
        @Override
        public Builder h(final String a) {
            Objects.requireNonNull(a, "Null sdkVersion");
            this.a = a;
            return this;
        }
        
        @Override
        public Builder i(final Session g) {
            this.g = g;
            return this;
        }
    }
}
