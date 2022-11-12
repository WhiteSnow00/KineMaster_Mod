// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.persistence;

public class LRUCachePolicy implements CachePolicy
{
    public final long a;
    
    public LRUCachePolicy(final long a) {
        this.a = a;
    }
    
    @Override
    public boolean a(final long n, final long n2) {
        return n > this.a || n2 > 1000L;
    }
    
    @Override
    public float b() {
        return 0.2f;
    }
    
    @Override
    public long c() {
        return 1000L;
    }
    
    @Override
    public boolean d(final long n) {
        return n > 1000L;
    }
}
