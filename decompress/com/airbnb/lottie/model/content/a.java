// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.content;

import q1.i;
import java.util.List;
import u1.f;
import u1.d;
import u1.c;
import v1.b;

public class a implements b
{
    private final String a;
    private final GradientType b;
    private final c c;
    private final d d;
    private final f e;
    private final f f;
    private final u1.b g;
    private final ShapeStroke.LineCapType h;
    private final ShapeStroke.LineJoinType i;
    private final float j;
    private final List<u1.b> k;
    private final u1.b l;
    private final boolean m;
    
    public a(final String a, final GradientType b, final c c, final d d, final f e, final f f, final u1.b g, final ShapeStroke.LineCapType h, final ShapeStroke.LineJoinType i, final float j, final List<u1.b> k, final u1.b l, final boolean m) {
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
        this.l = l;
        this.m = m;
    }
    
    @Override
    public q1.c a(final com.airbnb.lottie.f f, final com.airbnb.lottie.model.layer.a a) {
        return new i(f, a, this);
    }
    
    public ShapeStroke.LineCapType b() {
        return this.h;
    }
    
    public u1.b c() {
        return this.l;
    }
    
    public f d() {
        return this.f;
    }
    
    public c e() {
        return this.c;
    }
    
    public GradientType f() {
        return this.b;
    }
    
    public ShapeStroke.LineJoinType g() {
        return this.i;
    }
    
    public List<u1.b> h() {
        return this.k;
    }
    
    public float i() {
        return this.j;
    }
    
    public String j() {
        return this.a;
    }
    
    public d k() {
        return this.d;
    }
    
    public f l() {
        return this.e;
    }
    
    public u1.b m() {
        return this.g;
    }
    
    public boolean n() {
        return this.m;
    }
}
