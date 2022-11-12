// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

import java.io.IOException;

public final class DownloadException extends IOException
{
    public DownloadException(final String s) {
        super(s);
    }
    
    public DownloadException(final Throwable t) {
        super(t);
    }
}
