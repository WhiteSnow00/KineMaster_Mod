// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.common.primitives.Ints;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Bundle;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import d4.k;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.Bundleable;

public final class TrackSelectionOverride implements Bundleable
{
    public static final Creator<TrackSelectionOverride> c;
    public final TrackGroup a;
    public final ImmutableList<Integer> b;
    
    static {
        c = (Creator)k.a;
    }
    
    public TrackSelectionOverride(final TrackGroup a, final List<Integer> list) {
        if (!list.isEmpty() && (Collections.min((Collection<? extends Integer>)list) < 0 || Collections.max((Collection<? extends Integer>)list) >= a.a)) {
            throw new IndexOutOfBoundsException();
        }
        this.a = a;
        this.b = (ImmutableList<Integer>)ImmutableList.copyOf((Collection)list);
    }
    
    public static TrackSelectionOverride a(final Bundle bundle) {
        return d(bundle);
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static TrackSelectionOverride d(final Bundle bundle) {
        return new TrackSelectionOverride(TrackGroup.f.a(Assertions.e(bundle.getBundle(c(0)))), Ints.c((int[])Assertions.e(bundle.getIntArray(c(1)))));
    }
    
    public int b() {
        return this.a.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && TrackSelectionOverride.class == o.getClass()) {
            final TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride)o;
            if (!this.a.equals(trackSelectionOverride.a) || !this.b.equals((Object)trackSelectionOverride.b)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() + this.b.hashCode() * 31;
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putBundle(c(0), this.a.toBundle());
        bundle.putIntArray(c(1), Ints.n((Collection)this.b));
        return bundle;
    }
}
