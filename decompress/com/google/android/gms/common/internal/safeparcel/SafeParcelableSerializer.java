// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import com.google.android.gms.common.util.Base64Utils;
import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public final class SafeParcelableSerializer
{
    private SafeParcelableSerializer() {
    }
    
    @KeepForSdk
    public static <T extends SafeParcelable> T a(final byte[] array, final Parcelable$Creator<T> parcelable$Creator) {
        Preconditions.k(parcelable$Creator);
        final Parcel obtain = Parcel.obtain();
        obtain.unmarshall(array, 0, array.length);
        obtain.setDataPosition(0);
        final SafeParcelable safeParcelable = (SafeParcelable)parcelable$Creator.createFromParcel(obtain);
        obtain.recycle();
        return (T)safeParcelable;
    }
    
    @KeepForSdk
    public static <T extends SafeParcelable> T b(final Intent intent, final String s, final Parcelable$Creator<T> parcelable$Creator) {
        final byte[] byteArrayExtra = intent.getByteArrayExtra(s);
        if (byteArrayExtra == null) {
            return null;
        }
        return a(byteArrayExtra, parcelable$Creator);
    }
    
    @KeepForSdk
    public static <T extends SafeParcelable> T c(final String s, final Parcelable$Creator<T> parcelable$Creator) {
        return a(Base64Utils.a(s), parcelable$Creator);
    }
    
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] d(final T t) {
        final Parcel obtain = Parcel.obtain();
        ((Parcelable)t).writeToParcel(obtain, 0);
        final byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
    
    @KeepForSdk
    public static <T extends SafeParcelable> void e(final T t, final Intent intent, final String s) {
        intent.putExtra(s, d(t));
    }
    
    @KeepForSdk
    public static <T extends SafeParcelable> String f(final T t) {
        return Base64Utils.d(d(t));
    }
}
