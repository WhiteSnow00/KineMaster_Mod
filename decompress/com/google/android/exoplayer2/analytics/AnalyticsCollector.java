// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.source.MediaSource;
import java.util.List;
import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.Player;

public interface AnalyticsCollector extends Listener, MediaSourceEventListener, EventListener, DrmSessionEventListener
{
    void D(final Player p0, final Looper p1);
    
    void J(final AnalyticsListener p0);
    
    void P(final List<MediaSource.MediaPeriodId> p0, final MediaSource.MediaPeriodId p1);
    
    void a(final Exception p0);
    
    void b(final String p0);
    
    void c(final DecoderCounters p0);
    
    void d(final String p0, final long p1, final long p2);
    
    void e(final String p0);
    
    void f(final String p0, final long p1, final long p2);
    
    void g(final Format p0, final DecoderReuseEvaluation p1);
    
    void h(final long p0);
    
    void i(final Exception p0);
    
    void j(final DecoderCounters p0);
    
    void l(final DecoderCounters p0);
    
    void m(final int p0, final long p1);
    
    void n(final Format p0, final DecoderReuseEvaluation p1);
    
    void o(final Object p0, final long p1);
    
    void p(final DecoderCounters p0);
    
    void q(final Exception p0);
    
    void r(final int p0, final long p1, final long p2);
    
    void release();
    
    void s(final long p0, final int p1);
    
    void z();
}
