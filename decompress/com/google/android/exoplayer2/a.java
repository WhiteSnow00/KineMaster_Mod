// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

public final class a implements Runnable
{
    public final AudioFocusManager.a a;
    public final int b;
    
    public a(final AudioFocusManager.a a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        AudioFocusManager.a.a(this.a, this.b);
    }
}
