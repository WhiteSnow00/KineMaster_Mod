// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;

@Class
public final class zzp implements AdditionalUserInfo
{
    public static final Parcelable$Creator<zzp> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    private final Map c;
    @Field
    private final boolean d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzq();
    }
    
    @Constructor
    public zzp(@Param final String a, @Param final String b, @Param final boolean d) {
        Preconditions.g(a);
        Preconditions.g(b);
        this.a = a;
        this.b = b;
        this.c = l.c(b);
        this.d = d;
    }
    
    public zzp(final boolean d) {
        this.d = d;
        this.b = null;
        this.a = null;
        this.c = null;
    }
    
    public final int describeContents() {
        return 0;
    }
    
    @Override
    public final boolean isNewUser() {
        return this.d;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.g(parcel, 3, this.d);
        SafeParcelWriter.b(parcel, a);
    }
}
