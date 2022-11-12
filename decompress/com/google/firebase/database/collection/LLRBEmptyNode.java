// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.Comparator;

public class LLRBEmptyNode<K, V> implements LLRBNode<K, V>
{
    private static final LLRBEmptyNode a;
    
    static {
        a = new LLRBEmptyNode();
    }
    
    private LLRBEmptyNode() {
    }
    
    public static <K, V> LLRBEmptyNode<K, V> j() {
        return LLRBEmptyNode.a;
    }
    
    @Override
    public LLRBNode<K, V> a() {
        return this;
    }
    
    @Override
    public void b(final NodeVisitor<K, V> nodeVisitor) {
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public LLRBNode<K, V> d(final K k, final V v, final Comparator<K> comparator) {
        return new LLRBRedValueNode<K, V>(k, v);
    }
    
    @Override
    public LLRBNode<K, V> e(final K k, final Comparator<K> comparator) {
        return this;
    }
    
    @Override
    public LLRBNode<K, V> f() {
        return this;
    }
    
    @Override
    public LLRBNode<K, V> g(final K k, final V v, final Color color, final LLRBNode<K, V> llrbNode, final LLRBNode<K, V> llrbNode2) {
        return this;
    }
    
    @Override
    public K getKey() {
        return null;
    }
    
    @Override
    public V getValue() {
        return null;
    }
    
    @Override
    public LLRBNode<K, V> h() {
        return this;
    }
    
    @Override
    public LLRBNode<K, V> i() {
        return this;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public int size() {
        return 0;
    }
}
