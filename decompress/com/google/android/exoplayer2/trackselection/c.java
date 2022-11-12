// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import java.util.List;
import java.util.Comparator;

public final class c implements Comparator
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return DefaultTrackSelector.f.i((List<DefaultTrackSelector.f>)o, (List<DefaultTrackSelector.f>)o2);
    }
}
