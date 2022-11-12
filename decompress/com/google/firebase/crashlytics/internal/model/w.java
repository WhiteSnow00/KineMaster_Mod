// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

final class w extends AppData
{
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final DevelopmentPlatformProvider f;
    
    w(final String a, final String b, final String c, final String d, final int e, final DevelopmentPlatformProvider f) {
        Objects.requireNonNull(a, "Null appIdentifier");
        this.a = a;
        Objects.requireNonNull(b, "Null versionCode");
        this.b = b;
        Objects.requireNonNull(c, "Null versionName");
        this.c = c;
        Objects.requireNonNull(d, "Null installUuid");
        this.d = d;
        this.e = e;
        Objects.requireNonNull(f, "Null developmentPlatformProvider");
        this.f = f;
    }
    
    @Override
    public String a() {
        return this.a;
    }
    
    @Override
    public int c() {
        return this.e;
    }
    
    @Override
    public DevelopmentPlatformProvider d() {
        return this.f;
    }
    
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
        if (o instanceof AppData) {
            final AppData appData = (AppData)o;
            if (!this.a.equals(appData.a()) || !this.b.equals(appData.f()) || !this.c.equals(appData.g()) || !this.d.equals(appData.e()) || this.e != appData.c() || !this.f.equals(appData.d())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public String f() {
        return this.b;
    }
    
    @Override
    public String g() {
        return this.c;
    }
    
    @Override
    public int hashCode() {
        return (((((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e) * 1000003 ^ this.f.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("AppData{appIdentifier=");
        sb.append(this.a);
        sb.append(", versionCode=");
        sb.append(this.b);
        sb.append(", versionName=");
        sb.append(this.c);
        sb.append(", installUuid=");
        sb.append(this.d);
        sb.append(", deliveryMechanism=");
        sb.append(this.e);
        sb.append(", developmentPlatformProvider=");
        sb.append(this.f);
        sb.append("}");
        return sb.toString();
    }
}
