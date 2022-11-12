// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@ParametersAreNonnullByDefault
@Class
public final class zzs extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzs> CREATOR;
    @Field
    public final int a;
    @Field
    public final int b;
    @Field
    public final String c;
    @Field
    public final long d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzt();
    }
    
    @Constructor
    public zzs(@Param final int a, @Param final int b, @Param final String c, @Param final long d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static zzs K1(final JSONObject jsonObject) throws JSONException {
        return new zzs(jsonObject.getInt("type_num"), jsonObject.getInt("precision_num"), jsonObject.getString("currency"), jsonObject.getLong("value"));
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.v(parcel, 4, this.d);
        SafeParcelWriter.b(parcel, a);
    }
}
