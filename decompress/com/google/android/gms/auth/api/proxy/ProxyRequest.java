// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdkWithMembers
@ShowFirstParty
@Class
public class ProxyRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ProxyRequest> CREATOR;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int p;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    @Field
    public final String a;
    @Field
    public final int b;
    @Field
    public final long c;
    @Field
    public final byte[] d;
    @VersionField
    final int e;
    @Field
    Bundle f;
    
    static {
        CREATOR = (Parcelable$Creator)new zza();
        g = 0;
        h = 1;
        i = 2;
        j = 3;
        p = 4;
        w = 5;
        x = 6;
        y = 7;
        z = 7;
    }
    
    @Constructor
    ProxyRequest(@Param final int e, @Param final String a, @Param final int b, @Param final long c, @Param final byte[] d, @Param final Bundle f) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
    }
    
    @Override
    public String toString() {
        final String a = this.a;
        final int b = this.b;
        final StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(a);
        sb.append(", method: ");
        sb.append(b);
        sb.append(" ]");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.v(parcel, 3, this.c);
        SafeParcelWriter.k(parcel, 4, this.d, false);
        SafeParcelWriter.j(parcel, 5, this.f, false);
        SafeParcelWriter.s(parcel, 1000, this.e);
        SafeParcelWriter.b(parcel, a);
    }
    
    @KeepForSdkWithMembers
    @ShowFirstParty
    public static class Builder
    {
    }
}
