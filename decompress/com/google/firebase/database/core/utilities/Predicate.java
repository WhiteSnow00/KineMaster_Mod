// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

public interface Predicate<T>
{
    public static final Predicate<Object> a = new Predicate<Object>() {
        @Override
        public boolean a(final Object o) {
            return true;
        }
    };
    
    boolean a(final T p0);
}
