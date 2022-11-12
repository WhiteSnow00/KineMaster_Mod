// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class zzfc extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzfc> CREATOR;
    @Field
    public final String a;
    
    static {
        CREATOR = (Parcelable$Creator)new zzfd();
    }
    
    public zzfc(final SearchAdRequest searchAdRequest) {
        this.a = searchAdRequest.a();
    }
    
    @Constructor
    zzfc(@Param final String a) {
        this.a = a;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 15, this.a, false);
        SafeParcelWriter.b(parcel, a);
    }
}
