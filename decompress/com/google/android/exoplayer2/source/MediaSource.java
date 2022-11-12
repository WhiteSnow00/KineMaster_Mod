// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.Timeline;
import java.io.IOException;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.upstream.TransferListener;
import android.os.Handler;

public interface MediaSource
{
    void B(final Handler p0, final MediaSourceEventListener p1);
    
    void C(final MediaSourceEventListener p0);
    
    void E(final MediaSourceCaller p0, final TransferListener p1, final PlayerId p2);
    
    MediaItem F();
    
    void I(final MediaPeriod p0);
    
    void K(final MediaSourceCaller p0);
    
    void Q(final MediaSourceCaller p0);
    
    void S(final Handler p0, final DrmSessionEventListener p1);
    
    void T(final DrmSessionEventListener p0);
    
    void U() throws IOException;
    
    default boolean V() {
        return true;
    }
    
    default Timeline W() {
        return null;
    }
    
    MediaPeriod u(final MediaPeriodId p0, final Allocator p1, final long p2);
    
    void x(final MediaSourceCaller p0);
    
    public interface Factory
    {
        MediaSource a(final MediaItem p0);
        
        int[] b();
        
        Factory c(final DrmSessionManagerProvider p0);
        
        Factory d(final LoadErrorHandlingPolicy p0);
    }
    
    public static final class MediaPeriodId extends com.google.android.exoplayer2.source.MediaPeriodId
    {
        public MediaPeriodId(final com.google.android.exoplayer2.source.MediaPeriodId mediaPeriodId) {
            super(mediaPeriodId);
        }
        
        public MediaPeriodId(final Object o) {
            super(o);
        }
        
        public MediaPeriodId(final Object o, final int n, final int n2, final long n3) {
            super(o, n, n2, n3);
        }
        
        public MediaPeriodId(final Object o, final long n) {
            super(o, n);
        }
        
        public MediaPeriodId(final Object o, final long n, final int n2) {
            super(o, n, n2);
        }
        
        public MediaPeriodId c(final Object o) {
            return new MediaPeriodId(super.a(o));
        }
    }
    
    public interface MediaSourceCaller
    {
        void N(final MediaSource p0, final Timeline p1);
    }
}
