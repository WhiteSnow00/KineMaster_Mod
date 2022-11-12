// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.Comparator;

public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V>
{
    private final K a;
    private final V b;
    private LLRBNode<K, V> c;
    private final LLRBNode<K, V> d;
    
    LLRBValueNode(final K a, final V b, final LLRBNode<K, V> llrbNode, final LLRBNode<K, V> llrbNode2) {
        this.a = a;
        this.b = b;
        Object j = llrbNode;
        if (llrbNode == null) {
            j = LLRBEmptyNode.j();
        }
        this.c = (LLRBNode<K, V>)j;
        Object i;
        if ((i = llrbNode2) == null) {
            i = LLRBEmptyNode.j();
        }
        this.d = (LLRBNode<K, V>)i;
    }
    
    private LLRBValueNode<K, V> j() {
        final LLRBNode<K, V> c = this.c;
        final LLRBNode<K, V> g = c.g(null, null, q(c), null, null);
        final LLRBNode<K, V> d = this.d;
        return this.k(null, null, q(this), g, d.g(null, null, q(d), null, null));
    }
    
    private LLRBValueNode<K, V> m() {
        LLRBValueNode<K, V> s;
        if (this.d.c() && !this.c.c()) {
            s = this.s();
        }
        else {
            s = this;
        }
        LLRBValueNode<K, V> t = s;
        if (s.c.c()) {
            t = s;
            if (((LLRBValueNode)s.c).c.c()) {
                t = s.t();
            }
        }
        LLRBValueNode j = t;
        if (t.c.c()) {
            j = t;
            if (t.d.c()) {
                j = t.j();
            }
        }
        return j;
    }
    
    private LLRBValueNode<K, V> o() {
        LLRBNode<K, V> llrbNode;
        final LLRBValueNode<K, V> llrbValueNode = (LLRBValueNode<K, V>)(llrbNode = this.j());
        if (llrbValueNode.f().a().c()) {
            llrbNode = (LLRBNode<K, V>)llrbValueNode.l((Object)null, (Object)null, (LLRBNode<Object, Object>)null, (LLRBNode<Object, Object>)((LLRBValueNode)llrbValueNode.f()).t()).s().j();
        }
        return (LLRBValueNode<K, V>)llrbNode;
    }
    
    private LLRBValueNode<K, V> p() {
        LLRBValueNode<K, V> llrbValueNode2;
        final LLRBValueNode<K, V> llrbValueNode = llrbValueNode2 = this.j();
        if (llrbValueNode.a().a().c()) {
            llrbValueNode2 = llrbValueNode.t().j();
        }
        return llrbValueNode2;
    }
    
    private static Color q(final LLRBNode llrbNode) {
        Color color;
        if (llrbNode.c()) {
            color = Color.BLACK;
        }
        else {
            color = Color.RED;
        }
        return color;
    }
    
    private LLRBNode<K, V> r() {
        if (this.c.isEmpty()) {
            return (LLRBNode<K, V>)LLRBEmptyNode.j();
        }
        LLRBValueNode<K, V> o;
        if (!this.a().c() && !this.a().a().c()) {
            o = this.o();
        }
        else {
            o = this;
        }
        return (LLRBNode<K, V>)o.l((Object)null, (Object)null, (LLRBNode<Object, Object>)((LLRBValueNode)o.c).r(), (LLRBNode<Object, Object>)null).m();
    }
    
    private LLRBValueNode<K, V> s() {
        return (LLRBValueNode)this.d.g(null, null, this.n(), this.k(null, null, Color.RED, null, ((LLRBValueNode)this.d).c), null);
    }
    
    private LLRBValueNode<K, V> t() {
        return (LLRBValueNode)this.c.g(null, null, this.n(), null, this.k(null, null, Color.RED, ((LLRBValueNode)this.c).d, null));
    }
    
    @Override
    public LLRBNode<K, V> a() {
        return this.c;
    }
    
    @Override
    public void b(final NodeVisitor<K, V> nodeVisitor) {
        this.c.b(nodeVisitor);
        nodeVisitor.a(this.a, this.b);
        this.d.b(nodeVisitor);
    }
    
    @Override
    public LLRBNode<K, V> d(final K k, final V v, final Comparator<K> comparator) {
        final int compare = comparator.compare(k, this.a);
        LLRBValueNode<K, V> llrbValueNode;
        if (compare < 0) {
            llrbValueNode = this.l(null, null, this.c.d(k, v, comparator), null);
        }
        else if (compare == 0) {
            llrbValueNode = this.l(k, v, null, null);
        }
        else {
            llrbValueNode = this.l(null, null, null, this.d.d(k, v, comparator));
        }
        return llrbValueNode.m();
    }
    
    @Override
    public LLRBNode<K, V> e(final K k, final Comparator<K> comparator) {
        LLRBValueNode<Object, Object> llrbValueNode;
        if (comparator.compare(k, this.a) < 0) {
            LLRBValueNode<K, V> o;
            if (!this.c.isEmpty() && !this.c.c() && !((LLRBValueNode)this.c).c.c()) {
                o = this.o();
            }
            else {
                o = this;
            }
            llrbValueNode = o.l((Object)null, (Object)null, o.c.e((Object)k, (Comparator<Object>)comparator), (LLRBNode<Object, Object>)null);
        }
        else {
            LLRBValueNode<K, V> t;
            if (this.c.c()) {
                t = this.t();
            }
            else {
                t = this;
            }
            LLRBValueNode p2 = t;
            if (!t.d.isEmpty()) {
                p2 = t;
                if (!t.d.c()) {
                    p2 = t;
                    if (!((LLRBValueNode)t.d).c.c()) {
                        p2 = t.p();
                    }
                }
            }
            LLRBValueNode<Object, Object> l = p2;
            if (comparator.compare(k, p2.a) == 0) {
                if (p2.d.isEmpty()) {
                    return (LLRBNode<K, V>)LLRBEmptyNode.j();
                }
                final LLRBNode<K, V> h = p2.d.h();
                l = p2.l(h.getKey(), h.getValue(), null, ((LLRBValueNode)p2.d).r());
            }
            llrbValueNode = l.l(null, null, null, l.d.e(k, (Comparator<Object>)comparator));
        }
        return (LLRBNode<K, V>)llrbValueNode.m();
    }
    
    @Override
    public LLRBNode<K, V> f() {
        return this.d;
    }
    
    @Override
    public /* bridge */ LLRBNode g(final Object o, final Object o2, final Color color, final LLRBNode llrbNode, final LLRBNode llrbNode2) {
        return this.k(o, o2, color, llrbNode, llrbNode2);
    }
    
    @Override
    public K getKey() {
        return this.a;
    }
    
    @Override
    public V getValue() {
        return this.b;
    }
    
    @Override
    public LLRBNode<K, V> h() {
        if (this.c.isEmpty()) {
            return this;
        }
        return this.c.h();
    }
    
    @Override
    public LLRBNode<K, V> i() {
        if (this.d.isEmpty()) {
            return this;
        }
        return this.d.i();
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    public LLRBValueNode<K, V> k(final K k, final V v, final Color color, LLRBNode<K, V> d, final LLRBNode<K, V> llrbNode) {
        K a = k;
        if (k == null) {
            a = this.a;
        }
        V b;
        if ((b = v) == null) {
            b = this.b;
        }
        LLRBNode<K, V> c;
        if ((c = (LLRBNode<K, V>)d) == null) {
            c = this.c;
        }
        if ((d = llrbNode) == null) {
            d = this.d;
        }
        if (color == Color.RED) {
            return new LLRBRedValueNode<K, V>(a, b, (LLRBNode<Object, Object>)c, (LLRBNode<Object, Object>)d);
        }
        return new LLRBBlackValueNode<K, V>(a, b, (LLRBNode<Object, Object>)c, (LLRBNode<Object, Object>)d);
    }
    
    protected abstract LLRBValueNode<K, V> l(final K p0, final V p1, final LLRBNode<K, V> p2, final LLRBNode<K, V> p3);
    
    protected abstract Color n();
    
    void u(final LLRBNode<K, V> c) {
        this.c = c;
    }
}
