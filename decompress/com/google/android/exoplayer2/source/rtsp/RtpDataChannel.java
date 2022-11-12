// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSource;

interface RtpDataChannel extends DataSource
{
    String c();
    
    int d();
    
    RtspMessageChannel.InterleavedBinaryDataListener l();
    
    public interface Factory
    {
        RtpDataChannel a(final int p0) throws IOException;
        
        default Factory b() {
            return null;
        }
    }
}
