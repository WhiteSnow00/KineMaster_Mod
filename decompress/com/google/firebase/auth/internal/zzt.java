// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import org.json.JSONException;
import com.google.android.gms.internal.firebase_auth_api.zznp;
import android.util.Log;
import org.json.JSONObject;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.util.VisibleForTesting;
import android.text.TextUtils;
import com.google.android.gms.internal.firebase-auth-api.zzww;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase-auth-api.zzwj;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.UserInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzt extends AbstractSafeParcelable implements UserInfo
{
    public static final Parcelable$Creator<zzt> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    @Field
    private final String c;
    @Field
    private String d;
    private Uri e;
    @Field
    private final String f;
    @Field
    private final String g;
    @Field
    private final boolean h;
    @Field
    private final String i;
    
    static {
        CREATOR = (Parcelable$Creator)new zzu();
    }
    
    public zzt(final zzwj zzwj, final String s) {
        Preconditions.k(zzwj);
        Preconditions.g("firebase");
        this.a = Preconditions.g(((com.google.android.gms.internal.firebase_auth_api.zzwj)zzwj).zzo());
        this.b = "firebase";
        this.f = ((com.google.android.gms.internal.firebase_auth_api.zzwj)zzwj).zzn();
        this.c = ((com.google.android.gms.internal.firebase_auth_api.zzwj)zzwj).zzm();
        final Uri zzc = ((com.google.android.gms.internal.firebase_auth_api.zzwj)zzwj).zzc();
        if (zzc != null) {
            this.d = zzc.toString();
            this.e = zzc;
        }
        this.h = ((com.google.android.gms.internal.firebase_auth_api.zzwj)zzwj).zzs();
        this.i = null;
        this.g = ((com.google.android.gms.internal.firebase_auth_api.zzwj)zzwj).zzp();
    }
    
    public zzt(final zzww zzww) {
        Preconditions.k(zzww);
        this.a = ((com.google.android.gms.internal.firebase_auth_api.zzww)zzww).zzd();
        this.b = Preconditions.g(((com.google.android.gms.internal.firebase_auth_api.zzww)zzww).zzf());
        this.c = ((com.google.android.gms.internal.firebase_auth_api.zzww)zzww).zzb();
        final Uri zza = ((com.google.android.gms.internal.firebase_auth_api.zzww)zzww).zza();
        if (zza != null) {
            this.d = zza.toString();
            this.e = zza;
        }
        this.f = ((com.google.android.gms.internal.firebase_auth_api.zzww)zzww).zzc();
        this.g = ((com.google.android.gms.internal.firebase_auth_api.zzww)zzww).zze();
        this.h = false;
        this.i = ((com.google.android.gms.internal.firebase_auth_api.zzww)zzww).zzg();
    }
    
    @Constructor
    @VisibleForTesting
    public zzt(@Param final String a, @Param final String b, @Param final String f, @Param final String g, @Param final String c, @Param final String d, @Param final boolean h, @Param final String i) {
        this.a = a;
        this.b = b;
        this.f = f;
        this.g = g;
        this.c = c;
        this.d = d;
        if (!TextUtils.isEmpty((CharSequence)d)) {
            this.e = Uri.parse(this.d);
        }
        this.h = h;
        this.i = i;
    }
    
    public final String K1() {
        return this.c;
    }
    
    public final String L1() {
        return this.f;
    }
    
    public final String M1() {
        return this.g;
    }
    
    public final Uri N1() {
        if (!TextUtils.isEmpty((CharSequence)this.d) && this.e == null) {
            this.e = Uri.parse(this.d);
        }
        return this.e;
    }
    
    public final String O1() {
        return this.a;
    }
    
    @Override
    public final String e() {
        return this.b;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.B(parcel, 4, this.d, false);
        SafeParcelWriter.B(parcel, 5, this.f, false);
        SafeParcelWriter.B(parcel, 6, this.g, false);
        SafeParcelWriter.g(parcel, 7, this.h);
        SafeParcelWriter.B(parcel, 8, this.i, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zza() {
        return this.i;
    }
    
    public final String zzb() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt("userId", (Object)this.a);
            jsonObject.putOpt("providerId", (Object)this.b);
            jsonObject.putOpt("displayName", (Object)this.c);
            jsonObject.putOpt("photoUrl", (Object)this.d);
            jsonObject.putOpt("email", (Object)this.f);
            jsonObject.putOpt("phoneNumber", (Object)this.g);
            jsonObject.putOpt("isEmailVerified", (Object)this.h);
            jsonObject.putOpt("rawUserInfo", (Object)this.i);
            return jsonObject.toString();
        }
        catch (final JSONException ex) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zznp((Throwable)ex);
        }
    }
}
