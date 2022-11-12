// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class ConnectionResult extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ConnectionResult> CREATOR;
    @KeepForSdk
    @ShowFirstParty
    public static final ConnectionResult e;
    @VersionField
    final int a;
    @Field
    private final int b;
    @Field
    private final PendingIntent c;
    @Field
    private final String d;
    
    static {
        e = new ConnectionResult(0);
        CREATOR = (Parcelable$Creator)new zzb();
    }
    
    public ConnectionResult(final int n) {
        this(n, null, null);
    }
    
    @Constructor
    ConnectionResult(@Param final int a, @Param final int b, @Param final PendingIntent c, @Param final String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public ConnectionResult(final int n, final PendingIntent pendingIntent) {
        this(n, pendingIntent, null);
    }
    
    public ConnectionResult(final int n, final PendingIntent pendingIntent, final String s) {
        this(1, n, pendingIntent, s);
    }
    
    static String P1(final int n) {
        if (n == 99) {
            return "UNFINISHED";
        }
        if (n == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(n);
                        sb.append(")");
                        return sb.toString();
                    }
                    case 24: {
                        return "API_DISABLED_FOR_CONNECTION";
                    }
                    case 23: {
                        return "API_DISABLED";
                    }
                    case 22: {
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    }
                    case 21: {
                        return "API_VERSION_UPDATE_REQUIRED";
                    }
                    case 20: {
                        return "RESTRICTED_PROFILE";
                    }
                    case 19: {
                        return "SERVICE_MISSING_PERMISSION";
                    }
                    case 18: {
                        return "SERVICE_UPDATING";
                    }
                    case 17: {
                        return "SIGN_IN_FAILED";
                    }
                    case 16: {
                        return "API_UNAVAILABLE";
                    }
                    case 15: {
                        return "INTERRUPTED";
                    }
                    case 14: {
                        return "TIMEOUT";
                    }
                    case 13: {
                        return "CANCELED";
                    }
                }
                break;
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 0: {
                return "SUCCESS";
            }
            case -1: {
                return "UNKNOWN";
            }
        }
    }
    
    public int K1() {
        return this.b;
    }
    
    public String L1() {
        return this.d;
    }
    
    public PendingIntent M1() {
        return this.c;
    }
    
    public boolean N1() {
        return this.b != 0 && this.c != null;
    }
    
    public boolean O1() {
        return this.b == 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConnectionResult)) {
            return false;
        }
        final ConnectionResult connectionResult = (ConnectionResult)o;
        return this.b == connectionResult.b && Objects.b(this.c, connectionResult.c) && Objects.b(this.d, connectionResult.d);
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.b, this.c, this.d);
    }
    
    @Override
    public String toString() {
        final Objects.ToStringHelper d = Objects.d(this);
        d.a("statusCode", P1(this.b));
        d.a("resolution", this.c);
        d.a("message", this.d);
        return d.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.K1());
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.M1(), n, false);
        SafeParcelWriter.B(parcel, 4, this.L1(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
