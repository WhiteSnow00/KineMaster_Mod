// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import java.io.Serializable;
import java.util.List;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbi implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        PendingIntent pendingIntent = null;
        String p2;
        String p = p2 = null;
        String p3;
        Serializable r = p3 = p2;
        int e = 0;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 6: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 5: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 4: {
                    r = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 3: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 1: {
                    pendingIntent = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<PendingIntent>)PendingIntent.CREATOR);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new SaveAccountLinkingTokenRequest(pendingIntent, p, p2, (List)r, p3, e);
    }
    
    public final Object[] newArray(final int n) {
        return new SaveAccountLinkingTokenRequest[n];
    }
}
