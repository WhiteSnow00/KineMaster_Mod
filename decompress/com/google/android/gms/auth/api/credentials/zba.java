// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import java.util.List;
import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zba implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        Object p2 = null;
        Object t;
        Object o = t = p2;
        Object p4;
        Object p3 = p4 = t;
        Object p6;
        String p5 = (String)(p6 = p4);
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 10: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 9: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 4: {
                    t = SafeParcelReader.t(parcel, c, IdToken.CREATOR);
                    continue;
                }
                case 3: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 2: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 1: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new Credential(p, (String)p2, (Uri)o, (List)t, (String)p3, (String)p4, p5, (String)p6);
    }
    
    public final Object[] newArray(final int n) {
        return new Credential[n];
    }
}
