// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class f
{
    private final Map<Class<?>, Object> a;
    
    f(final a a) {
        this.a = Collections.unmodifiableMap((Map<? extends Class<?>, ?>)new HashMap<Class<?>, Object>(f.a.a(a)));
    }
    
    public boolean a(final Class<Object> clazz) {
        return this.a.containsKey(clazz);
    }
    
    static final class a
    {
        private final Map<Class<?>, Object> a;
        
        a() {
            this.a = new HashMap<Class<?>, Object>();
        }
        
        static Map a(final a a) {
            return a.a;
        }
        
        f b() {
            return new f(this);
        }
    }
}
