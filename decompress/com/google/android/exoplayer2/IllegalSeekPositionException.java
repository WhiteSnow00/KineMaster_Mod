// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException
{
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;
    
    public IllegalSeekPositionException(final Timeline timeline, final int windowIndex, final long positionMs) {
        this.timeline = timeline;
        this.windowIndex = windowIndex;
        this.positionMs = positionMs;
    }
}
