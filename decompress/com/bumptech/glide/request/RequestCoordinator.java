// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.request;

public interface RequestCoordinator
{
    boolean a();
    
    boolean b(final e p0);
    
    boolean c(final e p0);
    
    void d(final e p0);
    
    void f(final e p0);
    
    RequestCoordinator getRoot();
    
    boolean j(final e p0);
    
    public enum RequestState
    {
        private static final RequestState[] $VALUES;
        
        CLEARED(false), 
        FAILED(true), 
        PAUSED(false), 
        RUNNING(false), 
        SUCCESS(true);
        
        private final boolean isComplete;
        
        private RequestState(final boolean isComplete) {
            this.isComplete = isComplete;
        }
        
        boolean isComplete() {
            return this.isComplete;
        }
    }
}
