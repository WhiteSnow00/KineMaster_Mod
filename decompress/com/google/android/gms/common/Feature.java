// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
public class Feature extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<Feature> CREATOR;
    @Field
    private final String a;
    @Deprecated
    @Field
    private final int b;
    @Field
    private final long c;
    
    static {
        CREATOR = (Parcelable$Creator)new zzc();
    }
    
    @Constructor
    public Feature(@Param final String a, @Param final int b, @Param final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @KeepForSdk
    public Feature(final String a, final long c) {
        this.a = a;
        this.c = c;
        this.b = -1;
    }
    
    @KeepForSdk
    public String K1() {
        return this.a;
    }
    
    @KeepForSdk
    public long L1() {
        long c;
        if ((c = this.c) == -1L) {
            c = this.b;
        }
        return c;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o instanceof Feature) {
            final Feature feature = (Feature)o;
            if (((this.K1() != null && this.K1().equals(feature.K1())) || (this.K1() == null && feature.K1() == null)) && this.L1() == feature.L1()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.K1(), this.L1());
    }
    
    @Override
    public final String toString() {
        final Objects.ToStringHelper d = Objects.d(this);
        d.a("name", this.K1());
        d.a("version", this.L1());
        return d.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.K1(), false);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.v(parcel, 3, this.L1());
        SafeParcelWriter.b(parcel, a);
    }
}
