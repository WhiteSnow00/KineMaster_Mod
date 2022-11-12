// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public final class MediaDrmCallbackException extends IOException
{
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uriAfterRedirects;
    
    public MediaDrmCallbackException(final DataSpec dataSpec, final Uri uriAfterRedirects, final Map<String, List<String>> responseHeaders, final long bytesLoaded, final Throwable t) {
        super(t);
        this.dataSpec = dataSpec;
        this.uriAfterRedirects = uriAfterRedirects;
        this.responseHeaders = responseHeaders;
        this.bytesLoaded = bytesLoaded;
    }
}
