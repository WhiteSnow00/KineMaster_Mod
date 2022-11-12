// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Comparator;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
public class ApiFeatureRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ApiFeatureRequest> CREATOR;
    private static final Comparator e;
    @Field
    private final List a;
    @Field
    private final boolean b;
    @Field
    private final String c;
    @Field
    private final String d;
    
    static {
        CREATOR = (Parcelable$Creator)new zac();
        e = zab.a;
    }
    
    @Constructor
    public ApiFeatureRequest(@Param final List a, @Param final boolean b, @Param final String c, @Param final String d) {
        Preconditions.k(a);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @KeepForSdk
    public List<Feature> K1() {
        return this.a;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof ApiFeatureRequest)) {
            return false;
        }
        final ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest)o;
        return this.b == apiFeatureRequest.b && Objects.b(this.a, apiFeatureRequest.a) && Objects.b(this.c, apiFeatureRequest.c) && Objects.b(this.d, apiFeatureRequest.d);
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.b, this.a, this.c, this.d);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.K1(), false);
        SafeParcelWriter.g(parcel, 2, this.b);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.B(parcel, 4, this.d, false);
        SafeParcelWriter.b(parcel, a);
    }
}
