// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

public final class t1 implements Runnable
{
    public final StreamVolumeManager a;
    
    public t1(final StreamVolumeManager a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        StreamVolumeManager.b.a(this.a);
    }
}
