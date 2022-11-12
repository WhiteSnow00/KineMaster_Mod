// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.RendererConfiguration;

public final class TrackSelectorResult
{
    public final int a;
    public final RendererConfiguration[] b;
    public final ExoTrackSelection[] c;
    public final Tracks d;
    public final Object e;
    
    public TrackSelectorResult(final RendererConfiguration[] b, final ExoTrackSelection[] array, final Tracks d, final Object e) {
        this.b = b;
        this.c = array.clone();
        this.d = d;
        this.e = e;
        this.a = b.length;
    }
    
    public boolean a(final TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult != null && trackSelectorResult.c.length == this.c.length) {
            for (int i = 0; i < this.c.length; ++i) {
                if (!this.b(trackSelectorResult, i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean b(final TrackSelectorResult trackSelectorResult, final int n) {
        final boolean b = false;
        if (trackSelectorResult == null) {
            return false;
        }
        boolean b2 = b;
        if (Util.c(this.b[n], trackSelectorResult.b[n])) {
            b2 = b;
            if (Util.c(this.c[n], trackSelectorResult.c[n])) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public boolean c(final int n) {
        return this.b[n] != null;
    }
}
