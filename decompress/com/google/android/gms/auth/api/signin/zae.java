// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import java.io.Serializable;
import java.util.ArrayList;
import com.google.android.gms.common.api.Scope;
import android.accounts.Account;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zae implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int w = 0;
        int w3;
        int w2 = w3 = w;
        ArrayList<Scope> t = null;
        Object o = null;
        Object p2;
        Object p = p2 = o;
        Object p3;
        Serializable t2 = (Serializable)(p3 = p2);
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 10: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 9: {
                    t2 = SafeParcelReader.t(parcel, c, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    continue;
                }
                case 8: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 7: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    w3 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 5: {
                    w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 4: {
                    w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 3: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Account>)Account.CREATOR);
                    continue;
                }
                case 2: {
                    t = SafeParcelReader.t(parcel, c, Scope.CREATOR);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new GoogleSignInOptions(e, t, (Account)o, (boolean)(w != 0), (boolean)(w2 != 0), (boolean)(w3 != 0), (String)p, (String)p2, (ArrayList)t2, (String)p3);
    }
    
    public final Object[] newArray(final int n) {
        return new GoogleSignInOptions[n];
    }
}
