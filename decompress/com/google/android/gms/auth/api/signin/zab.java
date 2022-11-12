// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import java.util.List;
import android.net.Uri;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zab implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        Object p2 = null;
        Object p4;
        String p3 = (String)(p4 = p2);
        Object p5;
        Object o = p5 = p4;
        Object t;
        String p6 = (String)(t = p5);
        Object p8;
        Object p7 = p8 = t;
        int e = 0;
        long f = 0L;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 12: {
                    p8 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 11: {
                    p7 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 10: {
                    t = SafeParcelReader.t(parcel, c, Scope.CREATOR);
                    continue;
                }
                case 9: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 8: {
                    f = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 7: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                    continue;
                }
                case 5: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 4: {
                    p3 = SafeParcelReader.p(parcel, c);
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
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new GoogleSignInAccount(e, p, (String)p2, p3, (String)p4, (Uri)o, (String)p5, f, p6, (List)t, (String)p7, (String)p8);
    }
    
    public final Object[] newArray(final int n) {
        return new GoogleSignInAccount[n];
    }
}
