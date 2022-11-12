// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import javax.inject.Inject;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.time.Clock;
import android.content.Context;

class d
{
    private final Context a;
    private final Clock b;
    private final Clock c;
    
    @Inject
    d(final Context a, @WallTime final Clock b, @Monotonic final Clock c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    CreationContext a(final String s) {
        return CreationContext.a(this.a, this.b, this.c, s);
    }
}
