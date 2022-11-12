// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class ModuleInstallIntentResponse extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ModuleInstallIntentResponse> CREATOR;
    @Field
    private final PendingIntent a;
    
    static {
        CREATOR = (Parcelable$Creator)new zab();
    }
    
    @KeepForSdk
    @Constructor
    public ModuleInstallIntentResponse(@Param final PendingIntent a) {
        this.a = a;
    }
    
    public PendingIntent K1() {
        return this.a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.K1(), n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
