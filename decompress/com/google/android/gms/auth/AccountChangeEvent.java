// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class AccountChangeEvent extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<AccountChangeEvent> CREATOR;
    @VersionField
    final int a;
    @Field
    final long b;
    @Field
    final String c;
    @Field
    final int d;
    @Field
    final int e;
    @Field
    final String f;
    
    static {
        CREATOR = (Parcelable$Creator)new zza();
    }
    
    @Constructor
    AccountChangeEvent(@Param final int a, @Param final long b, @Param final String s, @Param final int d, @Param final int e, @Param final String f) {
        this.a = a;
        this.b = b;
        this.c = Preconditions.k(s);
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof AccountChangeEvent)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        final AccountChangeEvent accountChangeEvent = (AccountChangeEvent)o;
        return this.a == accountChangeEvent.a && this.b == accountChangeEvent.b && Objects.b(this.c, accountChangeEvent.c) && this.d == accountChangeEvent.d && this.e == accountChangeEvent.e && Objects.b(this.f, accountChangeEvent.f);
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d, this.e, this.f);
    }
    
    @Override
    public String toString() {
        final int d = this.d;
        String s;
        if (d != 1) {
            if (d != 2) {
                if (d != 3) {
                    if (d != 4) {
                        s = "UNKNOWN";
                    }
                    else {
                        s = "RENAMED_TO";
                    }
                }
                else {
                    s = "RENAMED_FROM";
                }
            }
            else {
                s = "REMOVED";
            }
        }
        else {
            s = "ADDED";
        }
        final String c = this.c;
        final String f = this.f;
        final int e = this.e;
        final StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 91 + s.length() + String.valueOf(f).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(c);
        sb.append(", changeType = ");
        sb.append(s);
        sb.append(", changeData = ");
        sb.append(f);
        sb.append(", eventIndex = ");
        sb.append(e);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.v(parcel, 2, this.b);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.s(parcel, 4, this.d);
        SafeParcelWriter.s(parcel, 5, this.e);
        SafeParcelWriter.B(parcel, 6, this.f, false);
        SafeParcelWriter.b(parcel, a);
    }
}
