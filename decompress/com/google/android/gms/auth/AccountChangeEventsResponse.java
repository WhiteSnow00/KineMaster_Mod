// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class AccountChangeEventsResponse extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<AccountChangeEventsResponse> CREATOR;
    @VersionField
    final int a;
    @Field
    final List<AccountChangeEvent> b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzc();
    }
    
    @Constructor
    AccountChangeEventsResponse(@Param final int a, @Param final List<AccountChangeEvent> list) {
        this.a = a;
        this.b = Preconditions.k(list);
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.F(parcel, 2, this.b, false);
        SafeParcelWriter.b(parcel, a);
    }
}
