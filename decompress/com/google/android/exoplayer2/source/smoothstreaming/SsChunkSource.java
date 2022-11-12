// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.source.chunk.ChunkSource;

public interface SsChunkSource extends ChunkSource
{
    void b(final ExoTrackSelection p0);
    
    void e(final SsManifest p0);
    
    public interface Factory
    {
        SsChunkSource a(final LoaderErrorThrower p0, final SsManifest p1, final int p2, final ExoTrackSelection p3, final TransferListener p4);
    }
}
