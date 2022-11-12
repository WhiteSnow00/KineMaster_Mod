// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.Format;
import java.util.List;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.source.chunk.ChunkSource;

public interface DashChunkSource extends ChunkSource
{
    void b(final ExoTrackSelection p0);
    
    void h(final DashManifest p0, final int p1);
    
    public interface Factory
    {
        DashChunkSource a(final LoaderErrorThrower p0, final DashManifest p1, final BaseUrlExclusionList p2, final int p3, final int[] p4, final ExoTrackSelection p5, final int p6, final long p7, final boolean p8, final List<Format> p9, final PlayerEmsgHandler.PlayerTrackEmsgHandler p10, final TransferListener p11, final PlayerId p12);
    }
}
