// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model;

public class DocumentData
{
    public final String a;
    public final String b;
    public final float c;
    public final Justification d;
    public final int e;
    public final float f;
    public final float g;
    public final int h;
    public final int i;
    public final float j;
    public final boolean k;
    
    public DocumentData(final String a, final String b, final float c, final Justification d, final int e, final float f, final float g, final int h, final int i, final float j, final boolean k) {
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
    
    @Override
    public int hashCode() {
        final int n = (int)((this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c);
        final int ordinal = this.d.ordinal();
        final int e = this.e;
        final long n2 = Float.floatToRawIntBits(this.f);
        return (((n * 31 + ordinal) * 31 + e) * 31 + (int)(n2 ^ n2 >>> 32)) * 31 + this.h;
    }
    
    public enum Justification
    {
        private static final Justification[] $VALUES;
        
        CENTER, 
        LEFT_ALIGN, 
        RIGHT_ALIGN;
    }
}
