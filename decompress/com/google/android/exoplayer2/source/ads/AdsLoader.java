// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.MediaItem;
import java.io.IOException;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSpec;

public interface AdsLoader
{
    void a(final AdsMediaSource p0, final int p1, final int p2);
    
    void b(final AdsMediaSource p0, final DataSpec p1, final Object p2, final AdViewProvider p3, final EventListener p4);
    
    void c(final AdsMediaSource p0, final int p1, final int p2, final IOException p3);
    
    void d(final AdsMediaSource p0, final EventListener p1);
    
    void e(final int... p0);
    
    public interface EventListener
    {
    }
    
    public interface Provider
    {
        AdsLoader a(final MediaItem.AdsConfiguration p0);
    }
}
