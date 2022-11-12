// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.util.ListIterator;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.RandomAccess;
import java.util.List;

public final class ImmutableList<E> implements List<E>, RandomAccess
{
    private final List<E> a;
    
    private ImmutableList(final List<E> list) {
        this.a = Collections.unmodifiableList((List<? extends E>)list);
    }
    
    public static <E> ImmutableList<E> a(final List<E> list) {
        return new ImmutableList<E>(list);
    }
    
    public static <E> ImmutableList<E> b(final E... array) {
        return new ImmutableList<E>(Arrays.asList(array));
    }
    
    @Override
    public void add(final int n, final E e) {
        this.a.add(n, e);
    }
    
    @Override
    public boolean add(final E e) {
        return this.a.add(e);
    }
    
    @Override
    public boolean addAll(final int n, final Collection<? extends E> collection) {
        return this.a.addAll(n, collection);
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        return this.a.addAll(collection);
    }
    
    @Override
    public void clear() {
        this.a.clear();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.a.contains(o);
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        return this.a.containsAll(collection);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.a.equals(o);
    }
    
    @Override
    public E get(final int n) {
        return this.a.get(n);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public int indexOf(final Object o) {
        return this.a.indexOf(o);
    }
    
    @Override
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
    
    @Override
    public Iterator<E> iterator() {
        return this.a.iterator();
    }
    
    @Override
    public int lastIndexOf(final Object o) {
        return this.a.lastIndexOf(o);
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return this.a.listIterator();
    }
    
    @Override
    public ListIterator<E> listIterator(final int n) {
        return this.a.listIterator(n);
    }
    
    @Override
    public E remove(final int n) {
        return this.a.remove(n);
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.a.remove(o);
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        return this.a.removeAll(collection);
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        return this.a.retainAll(collection);
    }
    
    @Override
    public E set(final int n, final E e) {
        return this.a.set(n, e);
    }
    
    @Override
    public int size() {
        return this.a.size();
    }
    
    @Override
    public List<E> subList(final int n, final int n2) {
        return this.a.subList(n, n2);
    }
    
    @Override
    public Object[] toArray() {
        return this.a.toArray();
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        return this.a.toArray(array);
    }
}
