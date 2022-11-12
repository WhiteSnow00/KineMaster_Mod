// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public final class zzbw
{
    final Map a;
    private final AtomicInteger b;
    
    public zzbw() {
        this.a = new ConcurrentHashMap();
        this.b = new AtomicInteger(0);
    }
    
    public final Bitmap a(final Integer n) {
        return this.a.get(n);
    }
}
