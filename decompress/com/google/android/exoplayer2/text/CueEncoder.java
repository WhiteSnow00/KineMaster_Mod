// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import android.os.Parcel;
import java.util.ArrayList;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import java.util.Collection;
import com.google.android.exoplayer2.util.BundleableUtil;
import java.util.List;

public final class CueEncoder
{
    public byte[] a(final List<Cue> list) {
        final ArrayList<Bundle> d = BundleableUtil.d((Collection<Bundleable>)list);
        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", (ArrayList)d);
        final Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        final byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
