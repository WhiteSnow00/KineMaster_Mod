// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.Comparator;

public interface LLRBNode<K, V>
{
    LLRBNode<K, V> a();
    
    void b(final NodeVisitor<K, V> p0);
    
    boolean c();
    
    LLRBNode<K, V> d(final K p0, final V p1, final Comparator<K> p2);
    
    LLRBNode<K, V> e(final K p0, final Comparator<K> p1);
    
    LLRBNode<K, V> f();
    
    LLRBNode<K, V> g(final K p0, final V p1, final Color p2, final LLRBNode<K, V> p3, final LLRBNode<K, V> p4);
    
    K getKey();
    
    V getValue();
    
    LLRBNode<K, V> h();
    
    LLRBNode<K, V> i();
    
    boolean isEmpty();
    
    int size();
    
    public enum Color
    {
        private static final Color[] $VALUES;
        
        BLACK, 
        RED;
    }
    
    public abstract static class NodeVisitor<K, V> implements ShortCircuitingNodeVisitor<K, V>
    {
        public abstract void a(final K p0, final V p1);
    }
    
    public interface ShortCircuitingNodeVisitor<K, V>
    {
    }
}
