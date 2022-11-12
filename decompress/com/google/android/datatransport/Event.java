// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Event<T>
{
    public static <T> Event<T> d(final T t) {
        return new a<T>(null, t, Priority.DEFAULT);
    }
    
    public static <T> Event<T> e(final T t) {
        return new a<T>(null, t, Priority.HIGHEST);
    }
    
    public abstract Integer a();
    
    public abstract T b();
    
    public abstract Priority c();
}
