// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.util.AbstractCollection;
import com.google.common.collect.ImmutableCollection;
import java.util.Collection;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayList;
import java.util.List;
import com.google.android.exoplayer2.util.BundleableUtil;
import android.os.Bundle;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Bundleable;

public final class TrackGroupArray implements Bundleable
{
    public static final TrackGroupArray d;
    public static final Creator<TrackGroupArray> e;
    public final int a;
    private final ImmutableList<TrackGroup> b;
    private int c;
    
    static {
        d = new TrackGroupArray(new TrackGroup[0]);
        e = b0.a;
    }
    
    public TrackGroupArray(final TrackGroup... array) {
        this.b = (ImmutableList<TrackGroup>)ImmutableList.copyOf((Object[])array);
        this.a = array.length;
        this.f();
    }
    
    public static TrackGroupArray a(final Bundle bundle) {
        return e(bundle);
    }
    
    private static String d(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static TrackGroupArray e(final Bundle bundle) {
        final ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        if (parcelableArrayList == null) {
            return new TrackGroupArray(new TrackGroup[0]);
        }
        return new TrackGroupArray((TrackGroup[])((ImmutableCollection)BundleableUtil.b(TrackGroup.f, parcelableArrayList)).toArray((Object[])new TrackGroup[0]));
    }
    
    private void f() {
        int n;
        for (int i = 0; i < ((AbstractCollection)this.b).size(); i = n) {
            int j;
            for (n = (j = i + 1); j < ((AbstractCollection)this.b).size(); ++j) {
                if (((List<TrackGroup>)this.b).get(i).equals(this.b.get(j))) {
                    Log.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
        }
    }
    
    public TrackGroup b(final int n) {
        return ((List<TrackGroup>)this.b).get(n);
    }
    
    public int c(final TrackGroup trackGroup) {
        int index = this.b.indexOf((Object)trackGroup);
        if (index < 0) {
            index = -1;
        }
        return index;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && TrackGroupArray.class == o.getClass()) {
            final TrackGroupArray trackGroupArray = (TrackGroupArray)o;
            if (this.a != trackGroupArray.a || !this.b.equals((Object)trackGroupArray.b)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        if (this.c == 0) {
            this.c = this.b.hashCode();
        }
        return this.c;
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), (ArrayList)BundleableUtil.d((Collection<Bundleable>)this.b));
        return bundle;
    }
}
