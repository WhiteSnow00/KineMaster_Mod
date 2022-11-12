// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T>
{
    private static final String[] c;
    private final Parcelable$Creator b;
    
    static {
        c = new String[] { "data" };
    }
    
    @KeepForSdk
    public T a(final int n) {
        final DataHolder dataHolder = Preconditions.k(super.a);
        final byte[] k1 = dataHolder.K1("data", n, dataHolder.O1(n));
        final Parcel obtain = Parcel.obtain();
        obtain.unmarshall(k1, 0, k1.length);
        obtain.setDataPosition(0);
        final SafeParcelable safeParcelable = (SafeParcelable)this.b.createFromParcel(obtain);
        obtain.recycle();
        return (T)safeParcelable;
    }
    
    @KeepForSdk
    @Override
    public final /* bridge */ Object get(final int n) {
        return this.a(n);
    }
}
