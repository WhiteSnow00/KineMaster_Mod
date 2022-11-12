// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

public interface Allocator
{
    void a(final AllocationNode p0);
    
    Allocation b();
    
    void c(final Allocation p0);
    
    void d();
    
    int e();
    
    public interface AllocationNode
    {
        Allocation a();
        
        AllocationNode next();
    }
}
