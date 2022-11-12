// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import java.io.IOException;
import android.net.Uri;

public interface HlsPlaylistTracker
{
    void a(final PlaylistEventListener p0);
    
    void b(final Uri p0) throws IOException;
    
    long c();
    
    HlsMultivariantPlaylist d();
    
    void e(final Uri p0);
    
    void f(final PlaylistEventListener p0);
    
    boolean g(final Uri p0);
    
    boolean h();
    
    boolean i(final Uri p0, final long p1);
    
    void j(final Uri p0, final MediaSourceEventListener.EventDispatcher p1, final PrimaryPlaylistListener p2);
    
    void k() throws IOException;
    
    HlsMediaPlaylist l(final Uri p0, final boolean p1);
    
    void stop();
    
    public interface Factory
    {
        HlsPlaylistTracker a(final HlsDataSourceFactory p0, final LoadErrorHandlingPolicy p1, final HlsPlaylistParserFactory p2);
    }
    
    public interface PlaylistEventListener
    {
        void a();
        
        boolean e(final Uri p0, final LoadErrorHandlingPolicy.LoadErrorInfo p1, final boolean p2);
    }
    
    public static final class PlaylistResetException extends IOException
    {
        public final Uri url;
        
        public PlaylistResetException(final Uri url) {
            this.url = url;
        }
    }
    
    public static final class PlaylistStuckException extends IOException
    {
        public final Uri url;
        
        public PlaylistStuckException(final Uri url) {
            this.url = url;
        }
    }
    
    public interface PrimaryPlaylistListener
    {
        void y(final HlsMediaPlaylist p0);
    }
}
