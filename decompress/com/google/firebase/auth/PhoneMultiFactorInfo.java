// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import org.json.JSONException;
import com.google.android.gms.internal.firebase_auth_api.zznp;
import android.util.Log;
import org.json.JSONObject;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nullable;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Class
public class PhoneMultiFactorInfo extends MultiFactorInfo
{
    public static final Parcelable$Creator<PhoneMultiFactorInfo> CREATOR;
    @Field
    private final String a;
    @Nullable
    @Field
    private final String b;
    @Field
    private final long c;
    @Field
    private final String d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzag();
    }
    
    @Constructor
    public PhoneMultiFactorInfo(@Param final String s, @Nullable @Param final String b, @Param final long c, @Param final String s2) {
        this.a = Preconditions.g(s);
        this.b = b;
        this.c = c;
        this.d = Preconditions.g(s2);
    }
    
    @Override
    public JSONObject K1() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt("factorIdKey", (Object)"phone");
            jsonObject.putOpt("uid", (Object)this.a);
            jsonObject.putOpt("displayName", (Object)this.b);
            jsonObject.putOpt("enrollmentTimestamp", (Object)this.c);
            jsonObject.putOpt("phoneNumber", (Object)this.d);
            return jsonObject;
        }
        catch (final JSONException ex) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zznp((Throwable)ex);
        }
    }
    
    public String L1() {
        return this.b;
    }
    
    public long M1() {
        return this.c;
    }
    
    public String N1() {
        return this.d;
    }
    
    public String O1() {
        return this.a;
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.O1(), false);
        SafeParcelWriter.B(parcel, 2, this.L1(), false);
        SafeParcelWriter.v(parcel, 3, this.M1());
        SafeParcelWriter.B(parcel, 4, this.N1(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
