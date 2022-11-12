// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

public final class e implements ThreadFactory
{
    public final String a;
    
    public e(final String a) {
        this.a = a;
    }
    
    @Override
    public final Thread newThread(final Runnable runnable) {
        return Util.a(this.a, runnable);
    }
}
