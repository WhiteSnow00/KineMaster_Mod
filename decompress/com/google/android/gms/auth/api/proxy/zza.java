// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zza implements Parcelable$Creator<ProxyRequest>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int e2 = 0;
        String p = null;
        Bundle f;
        Object g = f = null;
        long f2 = 0L;
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
                                f = SafeParcelReader.f(parcel, c);
                            }
                        }
                        else {
                            g = SafeParcelReader.g(parcel, c);
                        }
                    }
                    else {
                        f2 = SafeParcelReader.F(parcel, c);
                    }
                }
                else {
                    e2 = SafeParcelReader.E(parcel, c);
                }
            }
            else {
                p = SafeParcelReader.p(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new ProxyRequest(e, p, e2, f2, (byte[])g, f);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new ProxyRequest[n];
    }
}
