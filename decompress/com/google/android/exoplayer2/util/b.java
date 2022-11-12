// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.concurrent.CopyOnWriteArraySet;

public final class b implements Runnable
{
    public final CopyOnWriteArraySet a;
    public final int b;
    public final ListenerSet.Event c;
    
    public b(final CopyOnWriteArraySet a, final int b, final ListenerSet.Event c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        ListenerSet.a(this.a, this.b, this.c);
    }
}
