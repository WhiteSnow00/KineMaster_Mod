// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.view;

public interface Event
{
    void a();
    
    String toString();
    
    public enum EventType
    {
        private static final EventType[] $VALUES;
        
        CHILD_ADDED, 
        CHILD_CHANGED, 
        CHILD_MOVED, 
        CHILD_REMOVED, 
        VALUE;
    }
}
