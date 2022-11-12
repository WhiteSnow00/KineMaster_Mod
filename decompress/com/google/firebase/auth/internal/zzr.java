// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.List;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zze;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AuthResult;

@Class
public final class zzr implements AuthResult
{
    public static final Parcelable$Creator<zzr> CREATOR;
    @Field
    private zzx a;
    @Field
    private zzp b;
    @Field
    private zze c;
    
    static {
        CREATOR = (Parcelable$Creator)new zzs();
    }
    
    public zzr(final zzx zzx) {
        final zzx a = Preconditions.k(zzx);
        this.a = a;
        final List j2 = a.j2();
        this.b = null;
        for (int i = 0; i < j2.size(); ++i) {
            if (!TextUtils.isEmpty((CharSequence)((zzt)j2.get(i)).zza())) {
                this.b = new zzp(((zzt)j2.get(i)).e(), ((zzt)j2.get(i)).zza(), zzx.zzs());
            }
        }
        if (this.b == null) {
            this.b = new zzp(zzx.zzs());
        }
        this.c = zzx.f2();
    }
    
    @Constructor
    zzr(@Param final zzx a, @Param final zzp b, @Param final zze c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final AdditionalUserInfo d1() {
        return this.b;
    }
    
    public final int describeContents() {
        return 0;
    }
    
    @Override
    public final AuthCredential getCredential() {
        return this.c;
    }
    
    @Override
    public final FirebaseUser l0() {
        return this.a;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.a, n, false);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.b, n, false);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.c, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
