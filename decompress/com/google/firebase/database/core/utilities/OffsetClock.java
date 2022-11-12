// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

public class OffsetClock implements Clock
{
    private final Clock a;
    private long b;
    
    public OffsetClock(final Clock a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public long a() {
        return this.a.a() + this.b;
    }
    
    public void b(final long b) {
        this.b = b;
    }
}
