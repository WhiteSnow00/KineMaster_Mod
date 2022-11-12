// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbm implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        String p2 = null;
        String p4;
        String p3 = p4 = p2;
        String p5;
        Object o = p5 = p4;
        String p7;
        String p6 = p7 = p5;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 8: {
                    p7 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 7: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 4: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    p3 = SafeParcelReader.p(parcel, c);
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
        return new SignInCredential(p, p2, p3, p4, (Uri)o, p5, p6, p7);
    }
    
    public final Object[] newArray(final int n) {
        return new SignInCredential[n];
    }
}
