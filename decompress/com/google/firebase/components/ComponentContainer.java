// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import java.util.Set;
import com.google.firebase.inject.Provider;

public interface ComponentContainer
{
     <T> T a(final Class<T> p0);
    
     <T> Provider<Set<T>> b(final Class<T> p0);
    
     <T> Set<T> c(final Class<T> p0);
    
     <T> Provider<T> d(final Class<T> p0);
    
     <T> Deferred<T> e(final Class<T> p0);
}
