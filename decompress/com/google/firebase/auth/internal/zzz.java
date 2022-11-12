// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUserMetadata;

@Class
public final class zzz implements FirebaseUserMetadata
{
    public static final Parcelable$Creator<zzz> CREATOR;
    @Field
    private final long a;
    @Field
    private final long b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzaa();
    }
    
    @Constructor
    public zzz(@Param final long a, @Param final long b) {
        this.a = a;
        this.b = b;
    }
    
    public final JSONObject a() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("lastSignInTimestamp", this.a);
            jsonObject.put("creationTimestamp", this.b);
            return jsonObject;
        }
        catch (final JSONException ex) {
            return jsonObject;
        }
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.v(parcel, 1, this.a);
        SafeParcelWriter.v(parcel, 2, this.b);
        SafeParcelWriter.b(parcel, a);
    }
}
