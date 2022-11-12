// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

public final class TrackSelectionArray
{
    private final TrackSelection[] a;
    private int b;
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && TrackSelectionArray.class == o.getClass() && Arrays.equals(this.a, ((TrackSelectionArray)o).a));
    }
    
    @Override
    public int hashCode() {
        if (this.b == 0) {
            this.b = 527 + Arrays.hashCode(this.a);
        }
        return this.b;
    }
}
