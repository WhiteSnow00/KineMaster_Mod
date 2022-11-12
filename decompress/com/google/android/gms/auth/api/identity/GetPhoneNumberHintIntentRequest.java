// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class GetPhoneNumberHintIntentRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<GetPhoneNumberHintIntentRequest> CREATOR;
    @Field
    private final int a;
    
    static {
        CREATOR = (Parcelable$Creator)new zbe();
    }
    
    @Constructor
    GetPhoneNumberHintIntentRequest(@Param final int a) {
        this.a = a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof GetPhoneNumberHintIntentRequest && Objects.b(this.a, ((GetPhoneNumberHintIntentRequest)o).a);
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a);
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private Builder() {
        }
    }
}
