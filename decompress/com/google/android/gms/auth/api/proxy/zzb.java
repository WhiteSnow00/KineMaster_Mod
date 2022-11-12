// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzb implements Parcelable$Creator<ProxyResponse>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        PendingIntent pendingIntent = null;
        byte[] g;
        Object f = g = null;
        int e = 0;
        int e3;
        int e2 = e3 = 0;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            if (v != 5) {
                                if (v != 1000) {
                                    SafeParcelReader.I(parcel, c);
                                }
                                else {
                                    e = SafeParcelReader.E(parcel, c);
                                }
                            }
                            else {
                                g = SafeParcelReader.g(parcel, c);
                            }
                        }
                        else {
                            f = SafeParcelReader.f(parcel, c);
                        }
                    }
                    else {
                        e3 = SafeParcelReader.E(parcel, c);
                    }
                }
                else {
                    pendingIntent = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<PendingIntent>)PendingIntent.CREATOR);
                }
            }
            else {
                e2 = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new ProxyResponse(e, e2, pendingIntent, e3, (Bundle)f, g);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new ProxyResponse[n];
    }
}
