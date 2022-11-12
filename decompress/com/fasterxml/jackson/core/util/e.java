// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;

class e
{
    private final Object a;
    private final Map<SoftReference<com.fasterxml.jackson.core.util.a>, Boolean> b;
    private final ReferenceQueue<com.fasterxml.jackson.core.util.a> c;
    
    e() {
        this.a = new Object();
        this.b = new ConcurrentHashMap<SoftReference<com.fasterxml.jackson.core.util.a>, Boolean>();
        this.c = new ReferenceQueue<com.fasterxml.jackson.core.util.a>();
    }
    
    public static e a() {
        return a.a;
    }
    
    private void b() {
        while (true) {
            final SoftReference softReference = (SoftReference)this.c.poll();
            if (softReference == null) {
                break;
            }
            this.b.remove(softReference);
        }
    }
    
    public SoftReference<com.fasterxml.jackson.core.util.a> c(final com.fasterxml.jackson.core.util.a a) {
        final SoftReference softReference = new SoftReference((T)a, (ReferenceQueue<? super T>)this.c);
        this.b.put(softReference, Boolean.TRUE);
        this.b();
        return softReference;
    }
    
    private static final class a
    {
        static final e a;
        
        static {
            a = new e();
        }
    }
}
