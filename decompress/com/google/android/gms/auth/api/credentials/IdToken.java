// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.text.TextUtils;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@Class
@Reserved
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<IdToken> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new zbf();
    }
    
    @Constructor
    public IdToken(@Param final String a, @Param final String b) {
        Preconditions.b(TextUtils.isEmpty((CharSequence)a) ^ true, "account type string cannot be null or empty");
        Preconditions.b(TextUtils.isEmpty((CharSequence)b) ^ true, "id token string cannot be null or empty");
        this.a = a;
        this.b = b;
    }
    
    public String K1() {
        return this.a;
    }
    
    public String L1() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IdToken)) {
            return false;
        }
        final IdToken idToken = (IdToken)o;
        return Objects.b(this.a, idToken.a) && Objects.b(this.b, idToken.b);
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.K1(), false);
        SafeParcelWriter.B(parcel, 2, this.L1(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
