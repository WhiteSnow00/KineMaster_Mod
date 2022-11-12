// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.auth_api.zbc;
import com.google.android.gms.common.api.Status;
import android.os.Parcel;
import com.google.android.gms.internal.auth_api.zbb;

public abstract class zbq extends zbb implements zbr
{
    public zbq() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }
    
    protected final boolean zba(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 103: {
                final Status status = (Status)zbc.zba(parcel, (Parcelable$Creator)Status.CREATOR);
                zbc.zbb(parcel);
                this.N0(status);
                break;
            }
            case 102: {
                final Status status2 = (Status)zbc.zba(parcel, (Parcelable$Creator)Status.CREATOR);
                zbc.zbb(parcel);
                this.zbc(status2);
                break;
            }
            case 101: {
                final GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount)zbc.zba(parcel, (Parcelable$Creator)GoogleSignInAccount.CREATOR);
                final Status status3 = (Status)zbc.zba(parcel, (Parcelable$Creator)Status.CREATOR);
                zbc.zbb(parcel);
                this.D(googleSignInAccount, status3);
                break;
            }
        }
        parcel2.writeNoException();
        return true;
    }
}
