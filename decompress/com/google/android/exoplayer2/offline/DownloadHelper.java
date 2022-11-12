// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import java.io.IOException;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

public final class DownloadHelper
{
    public static final DefaultTrackSelector.Parameters a;
    
    static {
        a = DefaultTrackSelector.Parameters.d0.j().u0(true).q0(false).c0();
    }
    
    public interface Callback
    {
    }
    
    public static class LiveContentUnsupportedException extends IOException
    {
    }
}
