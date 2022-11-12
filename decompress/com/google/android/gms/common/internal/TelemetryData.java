// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.ArrayList;
import javax.annotation.Nullable;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
public class TelemetryData extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<TelemetryData> CREATOR;
    @Field
    private final int a;
    @Nullable
    @Field
    private List b;
    
    static {
        CREATOR = (Parcelable$Creator)new zaab();
    }
    
    @Constructor
    public TelemetryData(@Param final int a, @Nullable @Param final List b) {
        this.a = a;
        this.b = b;
    }
    
    public final int K1() {
        return this.a;
    }
    
    public final List L1() {
        return this.b;
    }
    
    public final void M1(final MethodInvocation methodInvocation) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(methodInvocation);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.F(parcel, 2, (List<Parcelable>)this.b, false);
        SafeParcelWriter.b(parcel, a);
    }
}
