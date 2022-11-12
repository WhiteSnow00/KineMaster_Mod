// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.source.TrackGroupArray;

public interface LoadControl
{
    void b();
    
    boolean c();
    
    long d();
    
    void e(final Renderer[] p0, final TrackGroupArray p1, final ExoTrackSelection[] p2);
    
    boolean f(final long p0, final float p1, final boolean p2, final long p3);
    
    Allocator g();
    
    void h();
    
    boolean i(final long p0, final long p1, final float p2);
    
    void onPrepared();
}
