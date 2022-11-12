// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.converter;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zaa extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zaa> CREATOR;
    @VersionField
    final int a;
    @Field
    private final StringToIntConverter b;
    
    static {
        CREATOR = (Parcelable$Creator)new zab();
    }
    
    @Constructor
    zaa(@Param final int a, @Param final StringToIntConverter b) {
        this.a = a;
        this.b = b;
    }
    
    private zaa(final StringToIntConverter b) {
        this.a = 1;
        this.b = b;
    }
    
    public static zaa K1(final FastJsonResponse.FieldConverter fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter)fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }
    
    public final FastJsonResponse.FieldConverter L1() {
        final StringToIntConverter b = this.b;
        if (b != null) {
            return b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.b, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
