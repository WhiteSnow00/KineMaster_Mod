// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import java.util.Comparator;

public final class d implements Comparator
{
    public static final d a;
    
    static {
        a = new d();
    }
    
    private d() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return DefaultTrackSelector.f.d((DefaultTrackSelector.f)o, (DefaultTrackSelector.f)o2);
    }
}
