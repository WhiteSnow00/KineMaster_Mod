// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.auto.value.AutoValue$Builder;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class c
{
    static final c a;
    
    static {
        a = a().f(10485760L).d(200).b(10000).c(604800000L).e(81920).a();
    }
    
    static a a() {
        return (a)new com.google.android.datatransport.runtime.scheduling.persistence.a.b();
    }
    
    abstract int b();
    
    abstract long c();
    
    abstract int d();
    
    abstract int e();
    
    abstract long f();
    
    @AutoValue$Builder
    abstract static class a
    {
        abstract c a();
        
        abstract a b(final int p0);
        
        abstract a c(final long p0);
        
        abstract a d(final int p0);
        
        abstract a e(final int p0);
        
        abstract a f(final long p0);
    }
}
