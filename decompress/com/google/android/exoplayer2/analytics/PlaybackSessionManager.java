// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.Timeline;

public interface PlaybackSessionManager
{
    String a();
    
    void b(final Listener p0);
    
    void c(final AnalyticsListener.EventTime p0);
    
    void d(final AnalyticsListener.EventTime p0);
    
    boolean e(final AnalyticsListener.EventTime p0, final String p1);
    
    void f(final AnalyticsListener.EventTime p0, final int p1);
    
    void g(final AnalyticsListener.EventTime p0);
    
    String h(final Timeline p0, final MediaSource.MediaPeriodId p1);
    
    public interface Listener
    {
        void e0(final AnalyticsListener.EventTime p0, final String p1, final boolean p2);
        
        void f0(final AnalyticsListener.EventTime p0, final String p1);
        
        void r0(final AnalyticsListener.EventTime p0, final String p1);
        
        void z0(final AnalyticsListener.EventTime p0, final String p1, final String p2);
    }
}
