// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.common.api.Status;
import android.os.Parcel;
import com.google.android.gms.internal.base.zab;

public abstract class zad extends zab implements zae
{
    public zad() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }
    
    protected final boolean zaa(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        return false;
                    }
                    final Status status = (Status)zac.zaa(parcel, (Parcelable$Creator)Status.CREATOR);
                    zac.zab(parcel);
                    this.e1(status);
                }
                else {
                    final Status status2 = (Status)zac.zaa(parcel, (Parcelable$Creator)Status.CREATOR);
                    final ModuleInstallIntentResponse moduleInstallIntentResponse = (ModuleInstallIntentResponse)zac.zaa(parcel, (Parcelable$Creator)ModuleInstallIntentResponse.CREATOR);
                    zac.zab(parcel);
                    this.t(status2, moduleInstallIntentResponse);
                }
            }
            else {
                final Status status3 = (Status)zac.zaa(parcel, (Parcelable$Creator)Status.CREATOR);
                final ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse)zac.zaa(parcel, (Parcelable$Creator)ModuleInstallResponse.CREATOR);
                zac.zab(parcel);
                this.R0(status3, moduleInstallResponse);
            }
        }
        else {
            final Status status4 = (Status)zac.zaa(parcel, (Parcelable$Creator)Status.CREATOR);
            final ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse)zac.zaa(parcel, (Parcelable$Creator)ModuleAvailabilityResponse.CREATOR);
            zac.zab(parcel);
            this.T0(status4, moduleAvailabilityResponse);
        }
        return true;
    }
}
