// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zax extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zax> CREATOR;
    @VersionField
    final int a;
    @Field
    private final int b;
    @Field
    private final int c;
    @Deprecated
    @Field
    private final Scope[] d;
    
    static {
        CREATOR = (Parcelable$Creator)new zay();
    }
    
    @Constructor
    zax(@Param final int a, @Param final int b, @Param final int c, @Param final Scope[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.E(parcel, 4, this.d, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
