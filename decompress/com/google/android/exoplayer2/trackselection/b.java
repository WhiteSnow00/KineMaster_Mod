// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import java.util.List;
import java.util.Comparator;

public final class b implements Comparator
{
    public static final b a;
    
    static {
        a = new b();
    }
    
    private b() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return DefaultTrackSelector.e.d((List<DefaultTrackSelector.e>)o, (List<DefaultTrackSelector.e>)o2);
    }
}
