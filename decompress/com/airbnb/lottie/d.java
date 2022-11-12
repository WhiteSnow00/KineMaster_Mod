// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import java.util.Iterator;
import android.graphics.Rect;
import t1.c;
import androidx.collection.h;
import t1.b;
import com.airbnb.lottie.model.layer.Layer;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

public class d
{
    private final n a;
    private final HashSet<String> b;
    private Map<String, List<Layer>> c;
    private Map<String, g> d;
    private Map<String, b> e;
    private List<t1.g> f;
    private h<c> g;
    private androidx.collection.d<Layer> h;
    private List<Layer> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private int o;
    
    public d() {
        this.a = new n();
        this.b = new HashSet<String>();
        this.o = 0;
    }
    
    public void a(final String s) {
        y1.d.c(s);
        this.b.add(s);
    }
    
    public Rect b() {
        return this.j;
    }
    
    public h<c> c() {
        return this.g;
    }
    
    public float d() {
        return (float)(long)(this.e() / this.m * 1000.0f);
    }
    
    public float e() {
        return this.l - this.k;
    }
    
    public float f() {
        return this.l;
    }
    
    public Map<String, b> g() {
        return this.e;
    }
    
    public float h() {
        return this.m;
    }
    
    public Map<String, g> i() {
        return this.d;
    }
    
    public List<Layer> j() {
        return this.i;
    }
    
    public t1.g k(final String s) {
        for (int size = this.f.size(), i = 0; i < size; ++i) {
            final t1.g g = this.f.get(i);
            if (g.a(s)) {
                return g;
            }
        }
        return null;
    }
    
    public int l() {
        return this.o;
    }
    
    public n m() {
        return this.a;
    }
    
    public List<Layer> n(final String s) {
        return this.c.get(s);
    }
    
    public float o() {
        return this.k;
    }
    
    public boolean p() {
        return this.n;
    }
    
    public void q(final int n) {
        this.o += n;
    }
    
    public void r(final Rect j, final float k, final float l, final float m, final List<Layer> i, final androidx.collection.d<Layer> h, final Map<String, List<Layer>> c, final Map<String, g> d, final h<c> g, final Map<String, b> e, final List<t1.g> f) {
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.i = i;
        this.h = h;
        this.c = c;
        this.d = d;
        this.g = g;
        this.e = e;
        this.f = f;
    }
    
    public Layer s(final long n) {
        return this.h.f(n);
    }
    
    public void t(final boolean n) {
        this.n = n;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LottieComposition:\n");
        final Iterator<Layer> iterator = this.i.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().w("\t"));
        }
        return sb.toString();
    }
    
    public void u(final boolean b) {
        this.a.b(b);
    }
}
