// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@ShowFirstParty
@Class
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<TokenData> CREATOR;
    @VersionField
    final int a;
    @Field
    private final String b;
    @Field
    private final Long c;
    @Field
    private final boolean d;
    @Field
    private final boolean e;
    @Field
    private final List<String> f;
    @Field
    private final String g;
    
    static {
        CREATOR = (Parcelable$Creator)new zzm();
    }
    
    @Constructor
    TokenData(@Param final int a, @Param final String s, @Param final Long c, @Param final boolean d, @Param final boolean e, @Param final List<String> f, @Param final String g) {
        this.a = a;
        this.b = Preconditions.g(s);
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof TokenData)) {
            return false;
        }
        final TokenData tokenData = (TokenData)o;
        return TextUtils.equals((CharSequence)this.b, (CharSequence)tokenData.b) && Objects.b(this.c, tokenData.c) && this.d == tokenData.d && this.e == tokenData.e && Objects.b(this.f, tokenData.f) && Objects.b(this.g, tokenData.g);
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.b, this.c, this.d, this.e, this.f, this.g);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.x(parcel, 3, this.c, false);
        SafeParcelWriter.g(parcel, 4, this.d);
        SafeParcelWriter.g(parcel, 5, this.e);
        SafeParcelWriter.D(parcel, 6, this.f, false);
        SafeParcelWriter.B(parcel, 7, this.g, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zza() {
        return this.b;
    }
}
