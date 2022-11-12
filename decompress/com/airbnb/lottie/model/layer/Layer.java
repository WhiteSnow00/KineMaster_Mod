// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.layer;

import java.util.Iterator;
import java.util.Locale;
import z1.a;
import u1.k;
import u1.j;
import u1.l;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.d;
import v1.b;
import java.util.List;

public class Layer
{
    private final List<b> a;
    private final d b;
    private final String c;
    private final long d;
    private final LayerType e;
    private final long f;
    private final String g;
    private final List<Mask> h;
    private final l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final j q;
    private final k r;
    private final u1.b s;
    private final List<a<Float>> t;
    private final MatteType u;
    private final boolean v;
    
    public Layer(final List<b> a, final d b, final String c, final long d, final LayerType e, final long f, final String g, final List<Mask> h, final l i, final int j, final int k, final int l, final float m, final float n, final int o, final int p22, final j q, final k r, final List<a<Float>> t, final MatteType u, final u1.b s, final boolean v) {
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
        this.n = n;
        this.o = o;
        this.p = p22;
        this.q = q;
        this.r = r;
        this.t = t;
        this.u = u;
        this.s = s;
        this.v = v;
    }
    
    d a() {
        return this.b;
    }
    
    public long b() {
        return this.d;
    }
    
    List<a<Float>> c() {
        return this.t;
    }
    
    public LayerType d() {
        return this.e;
    }
    
    List<Mask> e() {
        return this.h;
    }
    
    MatteType f() {
        return this.u;
    }
    
    String g() {
        return this.c;
    }
    
    long h() {
        return this.f;
    }
    
    int i() {
        return this.p;
    }
    
    int j() {
        return this.o;
    }
    
    String k() {
        return this.g;
    }
    
    List<b> l() {
        return this.a;
    }
    
    int m() {
        return this.l;
    }
    
    int n() {
        return this.k;
    }
    
    int o() {
        return this.j;
    }
    
    float p() {
        return this.n / this.b.e();
    }
    
    j q() {
        return this.q;
    }
    
    k r() {
        return this.r;
    }
    
    u1.b s() {
        return this.s;
    }
    
    float t() {
        return this.m;
    }
    
    @Override
    public String toString() {
        return this.w("");
    }
    
    l u() {
        return this.i;
    }
    
    public boolean v() {
        return this.v;
    }
    
    public String w(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(this.g());
        sb.append("\n");
        final Layer s2 = this.b.s(this.h());
        if (s2 != null) {
            sb.append("\t\tParents: ");
            sb.append(s2.g());
            for (Layer layer = this.b.s(s2.h()); layer != null; layer = this.b.s(layer.h())) {
                sb.append("->");
                sb.append(layer.g());
            }
            sb.append(s);
            sb.append("\n");
        }
        if (!this.e().isEmpty()) {
            sb.append(s);
            sb.append("\tMasks: ");
            sb.append(this.e().size());
            sb.append("\n");
        }
        if (this.o() != 0 && this.n() != 0) {
            sb.append(s);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", this.o(), this.n(), this.m()));
        }
        if (!this.a.isEmpty()) {
            sb.append(s);
            sb.append("\tShapes:\n");
            for (final b next : this.a) {
                sb.append(s);
                sb.append("\t\t");
                sb.append(next);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    public enum LayerType
    {
        private static final LayerType[] $VALUES;
        
        IMAGE, 
        NULL, 
        PRE_COMP, 
        SHAPE, 
        SOLID, 
        TEXT, 
        UNKNOWN;
    }
    
    public enum MatteType
    {
        private static final MatteType[] $VALUES;
        
        ADD, 
        INVERT, 
        LUMA, 
        LUMA_INVERTED, 
        NONE, 
        UNKNOWN;
    }
}
