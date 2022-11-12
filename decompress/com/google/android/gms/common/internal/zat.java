// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.accounts.Account;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zat extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zat> CREATOR;
    @VersionField
    final int a;
    @Field
    private final Account b;
    @Field
    private final int c;
    @Field
    private final GoogleSignInAccount d;
    
    static {
        CREATOR = (Parcelable$Creator)new zau();
    }
    
    @Constructor
    zat(@Param final int a, @Param final Account b, @Param final int c, @Param final GoogleSignInAccount d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public zat(final Account account, final int n, final GoogleSignInAccount googleSignInAccount) {
        this(2, account, n, googleSignInAccount);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.b, n, false);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.d, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
