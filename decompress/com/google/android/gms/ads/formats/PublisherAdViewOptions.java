// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

import android.os.IInterface;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbmq;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.ads.internal.client.zzby;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zzbz;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@Class
public final class PublisherAdViewOptions extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<PublisherAdViewOptions> CREATOR;
    @Field
    private final boolean a;
    @Field
    private final zzbz b;
    @Field
    private final IBinder c;
    
    static {
        CREATOR = (Parcelable$Creator)new zzf();
    }
    
    @Constructor
    PublisherAdViewOptions(@Param final boolean a, @Param final IBinder binder, @Param final IBinder c) {
        this.a = a;
        zzbz zzd;
        if (binder != null) {
            zzd = zzby.zzd(binder);
        }
        else {
            zzd = null;
        }
        this.b = zzd;
        this.c = c;
    }
    
    public final zzbz K1() {
        return this.b;
    }
    
    public final zzbmr L1() {
        final IBinder c = this.c;
        if (c == null) {
            return null;
        }
        return zzbmq.zzc(c);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.a);
        final zzbz b = this.b;
        IBinder binder;
        if (b == null) {
            binder = null;
        }
        else {
            binder = ((IInterface)b).asBinder();
        }
        SafeParcelWriter.r(parcel, 2, binder, false);
        SafeParcelWriter.r(parcel, 3, this.c, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final boolean zzc() {
        return this.a;
    }
    
    @Deprecated
    public static final class Builder
    {
    }
}
