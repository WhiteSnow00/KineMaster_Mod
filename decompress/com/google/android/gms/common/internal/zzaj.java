// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@Class
public final class zzaj extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzaj> CREATOR;
    @VersionField
    final int a;
    
    static {
        CREATOR = (Parcelable$Creator)new zzak();
    }
    
    @Constructor
    zzaj(@Param final int a) {
        this.a = a;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.b(parcel, a);
    }
}
