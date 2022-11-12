// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.ads.VideoOptions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class zzfg extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzfg> CREATOR;
    @Field
    public final boolean a;
    @Field
    public final boolean b;
    @Field
    public final boolean c;
    
    static {
        CREATOR = (Parcelable$Creator)new zzfh();
    }
    
    public zzfg(final VideoOptions videoOptions) {
        this(videoOptions.c(), videoOptions.b(), videoOptions.a());
    }
    
    @Constructor
    public zzfg(@Param final boolean a, @Param final boolean b, @Param final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 2, this.a);
        SafeParcelWriter.g(parcel, 3, this.b);
        SafeParcelWriter.g(parcel, 4, this.c);
        SafeParcelWriter.b(parcel, a);
    }
}
