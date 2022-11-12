// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class y extends OsData
{
    private final String a;
    private final String b;
    private final boolean c;
    
    y(final String a, final String b, final boolean c) {
        Objects.requireNonNull(a, "Null osRelease");
        this.a = a;
        Objects.requireNonNull(b, "Null osCodeName");
        this.b = b;
        this.c = c;
    }
    
    @Override
    public boolean b() {
        return this.c;
    }
    
    @Override
    public String c() {
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
        if (o instanceof OsData) {
            final OsData osData = (OsData)o;
            if (!this.a.equals(osData.d()) || !this.b.equals(osData.c()) || this.c != osData.b()) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final int hashCode = this.a.hashCode();
        final int hashCode2 = this.b.hashCode();
        int n;
        if (this.c) {
            n = 1231;
        }
        else {
            n = 1237;
        }
        return ((hashCode ^ 0xF4243) * 1000003 ^ hashCode2) * 1000003 ^ n;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OsData{osRelease=");
        sb.append(this.a);
        sb.append(", osCodeName=");
        sb.append(this.b);
        sb.append(", isRooted=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
