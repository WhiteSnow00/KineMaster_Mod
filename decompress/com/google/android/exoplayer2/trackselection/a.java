// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import java.util.List;
import java.util.Comparator;

public final class a implements Comparator
{
    public static final a a;
    
    static {
        a = new a();
    }
    
    private a() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return DefaultTrackSelector.b.d((List<DefaultTrackSelector.b>)o, (List<DefaultTrackSelector.b>)o2);
    }
}
