// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class v extends StaticSessionData
{
    private final AppData a;
    private final OsData b;
    private final DeviceData c;
    
    v(final AppData a, final OsData b, final DeviceData c) {
        Objects.requireNonNull(a, "Null appData");
        this.a = a;
        Objects.requireNonNull(b, "Null osData");
        this.b = b;
        Objects.requireNonNull(c, "Null deviceData");
        this.c = c;
    }
    
    @Override
    public AppData a() {
        return this.a;
    }
    
    @Override
    public DeviceData c() {
        return this.c;
    }
    
    @Override
    public OsData d() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof StaticSessionData) {
            final StaticSessionData staticSessionData = (StaticSessionData)o;
            if (!this.a.equals(staticSessionData.a()) || !this.b.equals(staticSessionData.d()) || !this.c.equals(staticSessionData.c())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("StaticSessionData{appData=");
        sb.append(this.a);
        sb.append(", osData=");
        sb.append(this.b);
        sb.append(", deviceData=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
