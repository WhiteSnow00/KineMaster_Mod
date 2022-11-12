// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class SaveAccountLinkingTokenResult extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<SaveAccountLinkingTokenResult> CREATOR;
    @Field
    private final PendingIntent a;
    
    static {
        CREATOR = (Parcelable$Creator)new zbj();
    }
    
    @Constructor
    public SaveAccountLinkingTokenResult(@Param final PendingIntent a) {
        this.a = a;
    }
    
    public PendingIntent K1() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof SaveAccountLinkingTokenResult && Objects.b(this.a, ((SaveAccountLinkingTokenResult)o).a);
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.K1(), n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
