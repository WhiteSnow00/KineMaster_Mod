// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import android.os.Message;
import android.os.Handler$Callback;

public final class b implements Handler$Callback
{
    public final ConcatenatingMediaSource a;
    
    public b(final ConcatenatingMediaSource a) {
        this.a = a;
    }
    
    public final boolean handleMessage(final Message message) {
        return ConcatenatingMediaSource.z0(this.a, message);
    }
}
