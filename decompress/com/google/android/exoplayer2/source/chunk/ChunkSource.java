// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;
import com.google.android.exoplayer2.SeekParameters;
import java.io.IOException;

public interface ChunkSource
{
    void a() throws IOException;
    
    long c(final long p0, final SeekParameters p1);
    
    boolean d(final long p0, final Chunk p1, final List<? extends MediaChunk> p2);
    
    void f(final Chunk p0);
    
    boolean g(final Chunk p0, final boolean p1, final LoadErrorHandlingPolicy.LoadErrorInfo p2, final LoadErrorHandlingPolicy p3);
    
    int i(final long p0, final List<? extends MediaChunk> p1);
    
    void j(final long p0, final long p1, final List<? extends MediaChunk> p2, final ChunkHolder p3);
    
    void release();
}
