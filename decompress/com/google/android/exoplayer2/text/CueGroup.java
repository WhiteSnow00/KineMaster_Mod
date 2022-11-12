// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import java.util.ArrayList;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.common.collect.ImmutableList$Builder;
import android.os.Bundle;
import java.util.Collection;
import c4.b;
import java.util.List;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.Bundleable;

public final class CueGroup implements Bundleable
{
    public static final CueGroup b;
    public static final Creator<CueGroup> c;
    public final ImmutableList<Cue> a;
    
    static {
        b = new CueGroup((List<Cue>)ImmutableList.of());
        c = c4.b.a;
    }
    
    public CueGroup(final List<Cue> list) {
        this.a = (ImmutableList<Cue>)ImmutableList.copyOf((Collection)list);
    }
    
    public static CueGroup a(final Bundle bundle) {
        return c(bundle);
    }
    
    private static ImmutableList<Cue> b(final List<Cue> list) {
        final ImmutableList$Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); ++i) {
            if (((Cue)list.get(i)).d == null) {
                builder.i((Object)list.get(i));
            }
        }
        return (ImmutableList<Cue>)builder.l();
    }
    
    private static final CueGroup c(final Bundle bundle) {
        final ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        ImmutableList list;
        if (parcelableArrayList == null) {
            list = ImmutableList.of();
        }
        else {
            list = BundleableUtil.b(Cue.D, parcelableArrayList);
        }
        return new CueGroup((List<Cue>)list);
    }
    
    private static String d(final int n) {
        return Integer.toString(n, 36);
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), (ArrayList)BundleableUtil.d((Collection<Bundleable>)b((List<Cue>)this.a)));
        return bundle;
    }
}
