// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.os.Message;
import android.os.Handler$Callback;

public final class a implements Handler$Callback
{
    public final ListenerSet a;
    
    public a(final ListenerSet a) {
        this.a = a;
    }
    
    public final boolean handleMessage(final Message message) {
        return ListenerSet.b(this.a, message);
    }
}
