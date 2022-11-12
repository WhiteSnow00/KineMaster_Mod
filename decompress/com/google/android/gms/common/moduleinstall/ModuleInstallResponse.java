// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class ModuleInstallResponse extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ModuleInstallResponse> CREATOR;
    @Field
    private final int a;
    @Field
    private final boolean b;
    
    static {
        CREATOR = (Parcelable$Creator)new zad();
    }
    
    @Constructor
    public ModuleInstallResponse(@Param final int a, @Param final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public int K1() {
        return this.a;
    }
    
    public final boolean L1() {
        return this.b;
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.K1());
        SafeParcelWriter.g(parcel, 2, this.b);
        SafeParcelWriter.b(parcel, a);
    }
}
