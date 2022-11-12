// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;

public final class h implements TransportScheduleCallback
{
    public static final h a;
    
    static {
        a = new h();
    }
    
    private h() {
    }
    
    @Override
    public final void a(final Exception ex) {
        i.c(ex);
    }
}
