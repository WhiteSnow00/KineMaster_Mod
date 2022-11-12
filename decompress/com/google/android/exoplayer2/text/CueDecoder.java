// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import java.util.List;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import android.os.Bundle;
import android.os.Parcel;
import com.google.common.collect.ImmutableList;

public final class CueDecoder
{
    public ImmutableList<Cue> a(final byte[] array) {
        final Parcel obtain = Parcel.obtain();
        obtain.unmarshall(array, 0, array.length);
        obtain.setDataPosition(0);
        final Bundle bundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return BundleableUtil.b(Cue.D, Assertions.e(bundle.getParcelableArrayList("c")));
    }
}
