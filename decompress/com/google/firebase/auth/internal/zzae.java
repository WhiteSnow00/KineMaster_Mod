// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Iterator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.ArrayList;
import com.google.firebase.auth.zze;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.MultiFactorResolver;

@Class
public final class zzae extends MultiFactorResolver
{
    public static final Parcelable$Creator<zzae> CREATOR;
    @Field
    private final List a;
    @Field
    private final zzag b;
    @Field
    private final String c;
    @Field
    private final zze d;
    @Field
    private final zzx e;
    
    static {
        CREATOR = (Parcelable$Creator)new zzaf();
    }
    
    @Constructor
    public zzae(@Param final List list, @Param final zzag zzag, @Param final String s, @Param final zze d, @Param final zzx e) {
        this.a = new ArrayList();
        for (final MultiFactorInfo multiFactorInfo : list) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                this.a.add(multiFactorInfo);
            }
        }
        this.b = Preconditions.k(zzag);
        this.c = Preconditions.g(s);
        this.d = d;
        this.e = e;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, (List<Parcelable>)this.a, false);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.b, n, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.d, n, false);
        SafeParcelWriter.A(parcel, 5, (Parcelable)this.e, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
