// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.android.gms.common.internal.Objects;
import android.content.IntentSender$SendIntentException;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import android.app.Activity;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.android.gms.common.ConnectionResult;
import android.app.PendingIntent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable
{
    public static final Parcelable$Creator<Status> CREATOR;
    @KeepForSdk
    @ShowFirstParty
    @VisibleForTesting
    public static final Status f;
    @KeepForSdk
    @ShowFirstParty
    @VisibleForTesting
    public static final Status g;
    @KeepForSdk
    @ShowFirstParty
    public static final Status h;
    @KeepForSdk
    @ShowFirstParty
    public static final Status i;
    @KeepForSdk
    @ShowFirstParty
    public static final Status j;
    @KeepForSdk
    @ShowFirstParty
    public static final Status p;
    @KeepForSdk
    public static final Status w;
    @ShowFirstParty
    public static final Status x;
    @VersionField
    final int a;
    @Field
    private final int b;
    @Field
    private final String c;
    @Field
    private final PendingIntent d;
    @Field
    private final ConnectionResult e;
    
    static {
        f = new Status(-1);
        g = new Status(0);
        h = new Status(14);
        i = new Status(8);
        j = new Status(15);
        p = new Status(16);
        x = new Status(17);
        w = new Status(18);
        CREATOR = (Parcelable$Creator)new zzb();
    }
    
    public Status(final int n) {
        this(n, null);
    }
    
    @Constructor
    Status(@Param final int a, @Param final int b, @Param final String c, @Param final PendingIntent d, @Param final ConnectionResult e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public Status(final int n, final String s) {
        this(1, n, s, null, null);
    }
    
    public Status(final int n, final String s, final PendingIntent pendingIntent) {
        this(1, n, s, pendingIntent, null);
    }
    
    public Status(final ConnectionResult connectionResult, final String s) {
        this(connectionResult, s, 17);
    }
    
    @Deprecated
    @KeepForSdk
    public Status(final ConnectionResult connectionResult, final String s, final int n) {
        this(1, n, s, connectionResult.M1(), connectionResult);
    }
    
    public ConnectionResult K1() {
        return this.e;
    }
    
    public PendingIntent L1() {
        return this.d;
    }
    
    public int M1() {
        return this.b;
    }
    
    public String N1() {
        return this.c;
    }
    
    @VisibleForTesting
    public boolean O1() {
        return this.d != null;
    }
    
    @CheckReturnValue
    public boolean P1() {
        return this.b <= 0;
    }
    
    public void Q1(final Activity activity, final int n) throws IntentSender$SendIntentException {
        if (!this.O1()) {
            return;
        }
        final PendingIntent d = this.d;
        Preconditions.k(d);
        activity.startIntentSenderForResult(d.getIntentSender(), n, (Intent)null, 0, 0, 0);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Status)) {
            return false;
        }
        final Status status = (Status)o;
        return this.a == status.a && this.b == status.b && Objects.b(this.c, status.c) && Objects.b(this.d, status.d) && Objects.b(this.e, status.e);
    }
    
    @CanIgnoreReturnValue
    @Override
    public Status getStatus() {
        return this;
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d, this.e);
    }
    
    public boolean t() {
        return this.b == 16;
    }
    
    @Override
    public String toString() {
        final Objects.ToStringHelper d = Objects.d(this);
        d.a("statusCode", this.zza());
        d.a("resolution", this.d);
        return d.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.M1());
        SafeParcelWriter.B(parcel, 2, this.N1(), false);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.d, n, false);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.K1(), n, false);
        SafeParcelWriter.s(parcel, 1000, this.a);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zza() {
        final String c = this.c;
        if (c != null) {
            return c;
        }
        return CommonStatusCodes.a(this.b);
    }
}
