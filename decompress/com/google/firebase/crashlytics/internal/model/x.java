// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

final class x extends DeviceData
{
    private final int a;
    private final String b;
    private final int c;
    private final long d;
    private final long e;
    private final boolean f;
    private final int g;
    private final String h;
    private final String i;
    
    x(final int a, final String b, final int c, final long d, final long e, final boolean f, final int g, final String h, final String i) {
        this.a = a;
        Objects.requireNonNull(b, "Null model");
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        Objects.requireNonNull(h, "Null manufacturer");
        this.h = h;
        Objects.requireNonNull(i, "Null modelClass");
        this.i = i;
    }
    
    @Override
    public int a() {
        return this.a;
    }
    
    @Override
    public int b() {
        return this.c;
    }
    
    @Override
    public long d() {
        return this.e;
    }
    
    @Override
    public boolean e() {
        return this.f;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof DeviceData) {
            final DeviceData deviceData = (DeviceData)o;
            if (this.a != deviceData.a() || !this.b.equals(deviceData.g()) || this.c != deviceData.b() || this.d != deviceData.j() || this.e != deviceData.d() || this.f != deviceData.e() || this.g != deviceData.i() || !this.h.equals(deviceData.f()) || !this.i.equals(deviceData.h())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public String f() {
        return this.h;
    }
    
    @Override
    public String g() {
        return this.b;
    }
    
    @Override
    public String h() {
        return this.i;
    }
    
    @Override
    public int hashCode() {
        final int a = this.a;
        final int hashCode = this.b.hashCode();
        final int c = this.c;
        final long d = this.d;
        final int n = (int)(d ^ d >>> 32);
        final long e = this.e;
        final int n2 = (int)(e ^ e >>> 32);
        int n3;
        if (this.f) {
            n3 = 1231;
        }
        else {
            n3 = 1237;
        }
        return ((((((((a ^ 0xF4243) * 1000003 ^ hashCode) * 1000003 ^ c) * 1000003 ^ n) * 1000003 ^ n2) * 1000003 ^ n3) * 1000003 ^ this.g) * 1000003 ^ this.h.hashCode()) * 1000003 ^ this.i.hashCode();
    }
    
    @Override
    public int i() {
        return this.g;
    }
    
    @Override
    public long j() {
        return this.d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DeviceData{arch=");
        sb.append(this.a);
        sb.append(", model=");
        sb.append(this.b);
        sb.append(", availableProcessors=");
        sb.append(this.c);
        sb.append(", totalRam=");
        sb.append(this.d);
        sb.append(", diskSpace=");
        sb.append(this.e);
        sb.append(", isEmulator=");
        sb.append(this.f);
        sb.append(", state=");
        sb.append(this.g);
        sb.append(", manufacturer=");
        sb.append(this.h);
        sb.append(", modelClass=");
        sb.append(this.i);
        sb.append("}");
        return sb.toString();
    }
}
