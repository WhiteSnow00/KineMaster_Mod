// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

public final class OnDemandCounter
{
    private final AtomicInteger a;
    private final AtomicInteger b;
    
    public OnDemandCounter() {
        this.a = new AtomicInteger();
        this.b = new AtomicInteger();
    }
    
    public void a() {
        this.b.getAndIncrement();
    }
    
    public void b() {
        this.a.getAndIncrement();
    }
    
    public void c() {
        this.b.set(0);
    }
}
