// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V>
{
    LLRBRedValueNode(final K k, final V v) {
        super(k, v, LLRBEmptyNode.j(), LLRBEmptyNode.j());
    }
    
    LLRBRedValueNode(final K k, final V v, final LLRBNode<K, V> llrbNode, final LLRBNode<K, V> llrbNode2) {
        super(k, v, llrbNode, llrbNode2);
    }
    
    @Override
    public boolean c() {
        return true;
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
        return new LLRBRedValueNode(key, value, (LLRBNode<Object, Object>)a, f);
    }
    
    @Override
    protected Color n() {
        return Color.RED;
    }
    
    @Override
    public int size() {
        return this.a().size() + 1 + this.f().size();
    }
}
