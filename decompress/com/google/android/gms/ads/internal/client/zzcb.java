// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.internal.ads.zzblk;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbpj;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbtz;
import android.os.Parcelable$Creator;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.internal.ads.zzbpf;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzcb extends zzaqw implements zzcc
{
    public zzcb() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }
    
    protected final boolean zzbI(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 16: {
                final IObjectWrapper m0 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzbtz zzf = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                final zzbpg zzc = zzbpf.zzc(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                final zzbpj i0 = this.I0(m0, zzf, n, zzc);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)i0);
                break;
            }
            case 15: {
                final IObjectWrapper m2 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzbtz zzf2 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzbxk v = this.V(m2, zzf2, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)v);
                break;
            }
            case 14: {
                final IObjectWrapper m3 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzbtz zzf3 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzcdz o = this.o(m3, zzf3, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)o);
                break;
            }
            case 13: {
                final IObjectWrapper m4 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzq zzq = (zzq)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzq.CREATOR);
                final String string = parcel.readString();
                final zzbtz zzf4 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzbs f = this.f(m4, zzq, string, zzf4, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)f);
                break;
            }
            case 12: {
                final IObjectWrapper m5 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final String string2 = parcel.readString();
                final zzbtz zzf5 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzcbd q0 = this.Q0(m5, string2, zzf5, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)q0);
                break;
            }
            case 11: {
                final IObjectWrapper m6 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final IObjectWrapper m7 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final IObjectWrapper m8 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                final zzblk n3 = this.n1(m6, m7, m8);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)n3);
                break;
            }
            case 10: {
                final IObjectWrapper m9 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzq zzq2 = (zzq)zzaqx.zza(parcel, (Parcelable$Creator)zzq.CREATOR);
                final String string3 = parcel.readString();
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzbs s0 = this.S0(m9, zzq2, string3, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)s0);
                break;
            }
            case 9: {
                final IObjectWrapper m10 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzcm zzg = this.zzg(m10, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzg);
                break;
            }
            case 8: {
                final IObjectWrapper m11 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                final zzbxu zzl = this.zzl(m11);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzl);
                break;
            }
            case 7: {
                IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)null);
                break;
            }
            case 6: {
                final IObjectWrapper m12 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzbtz zzf6 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzcan z = this.z(m12, zzf6, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)z);
                break;
            }
            case 5: {
                final IObjectWrapper m13 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final IObjectWrapper m14 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                final zzble p4 = this.P(m13, m14);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)p4);
                break;
            }
            case 4: {
                IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)null);
                break;
            }
            case 3: {
                final IObjectWrapper m15 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final String string4 = parcel.readString();
                final zzbtz zzf7 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzbo c0 = this.c0(m15, string4, zzf7, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)c0);
                break;
            }
            case 2: {
                final IObjectWrapper m16 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzq zzq3 = (zzq)zzaqx.zza(parcel, (Parcelable$Creator)zzq.CREATOR);
                final String string5 = parcel.readString();
                final zzbtz zzf8 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzbs f2 = this.f1(m16, zzq3, string5, zzf8, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)f2);
                break;
            }
            case 1: {
                final IObjectWrapper m17 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final zzq zzq4 = (zzq)zzaqx.zza(parcel, (Parcelable$Creator)zzq.CREATOR);
                final String string6 = parcel.readString();
                final zzbtz zzf9 = zzbty.zzf(parcel.readStrongBinder());
                n = parcel.readInt();
                zzaqx.zzc(parcel);
                final zzbs p5 = this.p(m17, zzq4, string6, zzf9, n);
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)p5);
                break;
            }
        }
        return true;
    }
}
