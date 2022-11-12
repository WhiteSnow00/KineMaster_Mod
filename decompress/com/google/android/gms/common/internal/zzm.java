// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.Scope;
import android.accounts.Account;
import com.google.android.gms.common.Feature;
import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzm implements Parcelable$Creator
{
    static void a(final GetServiceRequest getServiceRequest, final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, getServiceRequest.a);
        SafeParcelWriter.s(parcel, 2, getServiceRequest.b);
        SafeParcelWriter.s(parcel, 3, getServiceRequest.c);
        SafeParcelWriter.B(parcel, 4, getServiceRequest.d, false);
        SafeParcelWriter.r(parcel, 5, getServiceRequest.e, false);
        SafeParcelWriter.E(parcel, 6, getServiceRequest.f, n, false);
        SafeParcelWriter.j(parcel, 7, getServiceRequest.g, false);
        SafeParcelWriter.A(parcel, 8, (Parcelable)getServiceRequest.h, n, false);
        SafeParcelWriter.E(parcel, 10, getServiceRequest.i, n, false);
        SafeParcelWriter.E(parcel, 11, getServiceRequest.j, n, false);
        SafeParcelWriter.g(parcel, 12, getServiceRequest.p);
        SafeParcelWriter.s(parcel, 13, getServiceRequest.w);
        SafeParcelWriter.g(parcel, 14, getServiceRequest.x);
        SafeParcelWriter.B(parcel, 15, getServiceRequest.zza(), false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        Scope[] z = GetServiceRequest.z;
        Bundle f = new Bundle();
        Feature[] a;
        Feature[] array = a = GetServiceRequest.A;
        String p = null;
        Object d = null;
        Object p2;
        Object o = p2 = d;
        int e = 0;
        int e2 = 0;
        int w;
        int e3 = w = e2;
        int w2;
        int e4 = w2 = w;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 15: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 14: {
                    w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 13: {
                    e4 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 12: {
                    w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 11: {
                    a = SafeParcelReader.s(parcel, c, Feature.CREATOR);
                    continue;
                }
                case 10: {
                    array = SafeParcelReader.s(parcel, c, Feature.CREATOR);
                    continue;
                }
                case 8: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Account>)Account.CREATOR);
                    continue;
                }
                case 7: {
                    f = SafeParcelReader.f(parcel, c);
                    continue;
                }
                case 6: {
                    z = SafeParcelReader.s(parcel, c, Scope.CREATOR);
                    continue;
                }
                case 5: {
                    d = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 4: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    e3 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 2: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new GetServiceRequest(e, e2, e3, p, (IBinder)d, z, f, (Account)o, array, a, (boolean)(w != 0), e4, (boolean)(w2 != 0), (String)p2);
    }
    
    public final Object[] newArray(final int n) {
        return new GetServiceRequest[n];
    }
}
