// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.collection;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Iterator;

public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>>
{
    private final ArrayDeque<LLRBValueNode<K, V>> a;
    private final boolean b;
    
    ImmutableSortedMapIterator(LLRBNode<K, V> llrbNode, final K k, final Comparator<K> comparator, final boolean b) {
        this.a = new ArrayDeque<LLRBValueNode<K, V>>();
        this.b = b;
        while (!llrbNode.isEmpty()) {
            int n;
            if (k != null) {
                if (b) {
                    n = comparator.compare(k, llrbNode.getKey());
                }
                else {
                    n = comparator.compare(llrbNode.getKey(), k);
                }
            }
            else {
                n = 1;
            }
            if (n < 0) {
                if (b) {
                    llrbNode = llrbNode.a();
                }
                else {
                    llrbNode = llrbNode.f();
                }
            }
            else {
                if (n == 0) {
                    this.a.push((LLRBValueNode<K, V>)llrbNode);
                    break;
                }
                this.a.push((LLRBValueNode<K, V>)llrbNode);
                if (b) {
                    llrbNode = llrbNode.f();
                }
                else {
                    llrbNode = llrbNode.a();
                }
            }
        }
    }
    
    public Map.Entry<K, V> b() {
        try {
            final LLRBValueNode llrbValueNode = this.a.pop();
            final AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(llrbValueNode.getKey(), llrbValueNode.getValue());
            if (this.b) {
                for (LLRBNode<K, V> llrbNode = llrbValueNode.a(); !llrbNode.isEmpty(); llrbNode = llrbNode.f()) {
                    this.a.push((LLRBValueNode<K, V>)llrbNode);
                }
            }
            else {
                for (LLRBNode<K, V> llrbNode2 = llrbValueNode.f(); !llrbNode2.isEmpty(); llrbNode2 = llrbNode2.a()) {
                    this.a.push((LLRBValueNode<K, V>)llrbNode2);
                }
            }
            return (Map.Entry<K, V>)simpleEntry;
        }
        catch (final EmptyStackException ex) {
            throw new NoSuchElementException();
        }
    }
    
    @Override
    public boolean hasNext() {
        return this.a.size() > 0;
    }
    
    @Override
    public /* bridge */ Object next() {
        return this.b();
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
