// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
@Reserved
public class ClientIdentity extends AbstractSafeParcelable
{
    @KeepForSdk
    public static final Parcelable$Creator<ClientIdentity> CREATOR;
    @KeepForSdk
    @Field
    public final int a;
    @KeepForSdk
    @Field
    public final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new zaa();
    }
    
    @Constructor
    public ClientIdentity(@Param final int a, @Param final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientIdentity)) {
            return false;
        }
        final ClientIdentity clientIdentity = (ClientIdentity)o;
        return clientIdentity.a == this.a && Objects.b(clientIdentity.b, this.b);
    }
    
    @Override
    public final int hashCode() {
        return this.a;
    }
    
    @Override
    public final String toString() {
        final int a = this.a;
        final String b = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(":");
        sb.append(b);
        return sb.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.b(parcel, a);
    }
}
