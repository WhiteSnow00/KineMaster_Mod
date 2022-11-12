// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbmq;
import com.google.android.gms.internal.ads.zzbmr;
import android.os.IBinder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class AdManagerAdViewOptions extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<AdManagerAdViewOptions> CREATOR;
    @Field
    private final boolean a;
    @Field
    private final IBinder b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzc();
    }
    
    @Constructor
    AdManagerAdViewOptions(@Param final boolean a, @Param final IBinder b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean K1() {
        return this.a;
    }
    
    public final zzbmr L1() {
        final IBinder b = this.b;
        if (b == null) {
            return null;
        }
        return zzbmq.zzc(b);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.K1());
        SafeParcelWriter.r(parcel, 2, this.b, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private boolean a;
        
        public Builder() {
            this.a = false;
        }
    }
}
