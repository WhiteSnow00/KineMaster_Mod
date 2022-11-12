// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.core.widgets.analyzer;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import s.a;

public class DependencyNode implements a
{
    public a a;
    public boolean b;
    public boolean c;
    WidgetRun d;
    Type e;
    int f;
    public int g;
    int h;
    e i;
    public boolean j;
    List<a> k;
    List<DependencyNode> l;
    
    public DependencyNode(final WidgetRun d) {
        this.a = null;
        this.b = false;
        this.c = false;
        this.e = Type.UNKNOWN;
        this.h = 1;
        this.i = null;
        this.j = false;
        this.k = new ArrayList<a>();
        this.l = new ArrayList<DependencyNode>();
        this.d = d;
    }
    
    @Override
    public void a(a a) {
        final Iterator<DependencyNode> iterator = this.l.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().j) {
                return;
            }
        }
        this.c = true;
        a = this.a;
        if (a != null) {
            a.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int n = 0;
        for (final DependencyNode dependencyNode2 : this.l) {
            if (dependencyNode2 instanceof e) {
                continue;
            }
            ++n;
            dependencyNode = dependencyNode2;
        }
        if (dependencyNode != null && n == 1 && dependencyNode.j) {
            final e i = this.i;
            if (i != null) {
                if (!i.j) {
                    return;
                }
                this.f = this.h * i.g;
            }
            this.d(dependencyNode.g + this.f);
        }
        a = this.a;
        if (a != null) {
            a.a(this);
        }
    }
    
    public void b(final a a) {
        this.k.add(a);
        if (this.j) {
            a.a(a);
        }
    }
    
    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }
    
    public void d(final int g) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = g;
        for (final a a : this.k) {
            a.a(a);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.r());
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        Serializable value;
        if (this.j) {
            value = this.g;
        }
        else {
            value = "unresolved";
        }
        sb.append(value);
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
    
    enum Type
    {
        private static final Type[] $VALUES;
        
        BASELINE, 
        BOTTOM, 
        HORIZONTAL_DIMENSION, 
        LEFT, 
        RIGHT, 
        TOP, 
        UNKNOWN, 
        VERTICAL_DIMENSION;
    }
}
