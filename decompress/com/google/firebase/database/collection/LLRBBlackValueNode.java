// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

public class LLRBBlackValueNode<K, V> extends LLRBValueNode<K, V>
{
    private int e;
    
    LLRBBlackValueNode(final K k, final V v, final LLRBNode<K, V> llrbNode, final LLRBNode<K, V> llrbNode2) {
        super(k, v, llrbNode, llrbNode2);
        this.e = -1;
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    protected LLRBValueNode<K, V> l(final K k, final V v, LLRBNode<K, V> f, final LLRBNode<K, V> llrbNode) {
        K key = k;
        if (k == null) {
            key = this.getKey();
        }
        V value;
        if ((value = v) == null) {
            value = this.getValue();
        }
        Object a;
        if ((a = f) == null) {
            a = this.a();
        }
        if ((f = (LLRBNode<Object, Object>)llrbNode) == null) {
            f = this.f();
        }
        return new LLRBBlackValueNode(key, value, (LLRBNode<Object, Object>)a, f);
    }
    
    @Override
    protected Color n() {
        return Color.BLACK;
    }
    
    @Override
    public int size() {
        if (this.e == -1) {
            this.e = this.a().size() + 1 + this.f().size();
        }
        return this.e;
    }
    
    @Override
    void u(final LLRBNode<K, V> llrbNode) {
        if (this.e == -1) {
            super.u(llrbNode);
            return;
        }
        throw new IllegalStateException("Can't set left after using size");
    }
}
