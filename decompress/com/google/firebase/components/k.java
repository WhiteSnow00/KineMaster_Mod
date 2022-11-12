// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import com.google.firebase.events.Event;
import java.util.Map;

public final class k implements Runnable
{
    public final Map.Entry a;
    public final Event b;
    
    public k(final Map.Entry a, final Event b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        l.d(this.a, this.b);
    }
}
