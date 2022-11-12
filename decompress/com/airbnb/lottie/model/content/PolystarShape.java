// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.content;

import q1.n;
import q1.c;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.f;
import android.graphics.PointF;
import u1.m;
import v1.b;

public class PolystarShape implements b
{
    private final String a;
    private final Type b;
    private final u1.b c;
    private final m<PointF, PointF> d;
    private final u1.b e;
    private final u1.b f;
    private final u1.b g;
    private final u1.b h;
    private final u1.b i;
    private final boolean j;
    
    public PolystarShape(final String a, final Type b, final u1.b c, final m<PointF, PointF> d, final u1.b e, final u1.b f, final u1.b g, final u1.b h, final u1.b i, final boolean j) {
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
    }
    
    @Override
    public c a(final f f, final a a) {
        return new n(f, a, this);
    }
    
    public u1.b b() {
        return this.f;
    }
    
    public u1.b c() {
        return this.h;
    }
    
    public String d() {
        return this.a;
    }
    
    public u1.b e() {
        return this.g;
    }
    
    public u1.b f() {
        return this.i;
    }
    
    public u1.b g() {
        return this.c;
    }
    
    public m<PointF, PointF> h() {
        return this.d;
    }
    
    public u1.b i() {
        return this.e;
    }
    
    public Type j() {
        return this.b;
    }
    
    public boolean k() {
        return this.j;
    }
    
    public enum Type
    {
        private static final Type[] $VALUES;
        
        POLYGON(2), 
        STAR(1);
        
        private final int value;
        
        private Type(final int value) {
            this.value = value;
        }
        
        public static Type forValue(final int n) {
            for (final Type type : values()) {
                if (type.value == n) {
                    return type;
                }
            }
            return null;
        }
    }
}
