// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.text.TextUtils;
import android.accounts.Account;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class AccountChangeEventsRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<AccountChangeEventsRequest> CREATOR;
    @VersionField
    final int a;
    @Field
    int b;
    @Deprecated
    @Field
    String c;
    @Field
    Account d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzb();
    }
    
    public AccountChangeEventsRequest() {
        this.a = 1;
    }
    
    @Constructor
    AccountChangeEventsRequest(@Param final int a, @Param final int b, @Param final String c, @Param final Account d) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (d == null && !TextUtils.isEmpty((CharSequence)c)) {
            this.d = new Account(c, "com.google");
            return;
        }
        this.d = d;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.d, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
