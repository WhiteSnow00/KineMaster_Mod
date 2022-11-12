// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<Scope> CREATOR;
    @VersionField
    final int a;
    @Field
    private final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new zza();
    }
    
    @Constructor
    Scope(@Param final int a, @Param final String b) {
        Preconditions.h(b, "scopeUri must not be null or empty");
        this.a = a;
        this.b = b;
    }
    
    public Scope(final String s) {
        this(1, s);
    }
    
    @KeepForSdk
    public String K1() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof Scope && this.b.equals(((Scope)o).b));
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
    
    @Override
    public String toString() {
        return this.b;
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.K1(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
