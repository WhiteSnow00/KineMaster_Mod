// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import java.io.IOException;

public final class SampleQueueMappingException extends IOException
{
    public SampleQueueMappingException(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Unable to bind a sample queue to TrackGroup with mime type ");
        sb.append(s);
        sb.append(".");
        super(sb.toString());
    }
}
