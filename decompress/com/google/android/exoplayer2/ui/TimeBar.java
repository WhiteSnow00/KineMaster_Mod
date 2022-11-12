// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

public interface TimeBar
{
    void a(final OnScrubListener p0);
    
    void b(final long[] p0, final boolean[] p1, final int p2);
    
    long getPreferredUpdateDelay();
    
    void setBufferedPosition(final long p0);
    
    void setDuration(final long p0);
    
    void setEnabled(final boolean p0);
    
    void setPosition(final long p0);
    
    public interface OnScrubListener
    {
        void k(final TimeBar p0, final long p1);
        
        void t(final TimeBar p0, final long p1, final boolean p2);
        
        void u(final TimeBar p0, final long p1);
    }
}
