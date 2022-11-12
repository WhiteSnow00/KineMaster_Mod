// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.common.internal.zzy;
import android.os.IBinder;
import javax.annotation.Nullable;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzs extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzs> CREATOR;
    @Field
    private final String a;
    @Nullable
    @Field
    private final h b;
    @Field
    private final boolean c;
    @Field
    private final boolean d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzt();
    }
    
    @Constructor
    zzs(@Param final String a, @Nullable @Param final IBinder binder, @Param final boolean c, @Param final boolean d) {
        this.a = a;
        final h h = null;
        h b;
        if (binder == null) {
            b = h;
        }
        else {
            try {
                final IObjectWrapper zzd = zzy.M0(binder).zzd();
                byte[] array;
                if (zzd == null) {
                    array = null;
                }
                else {
                    array = ObjectWrapper.p1(zzd);
                }
                if (array != null) {
                    b = new i(array);
                }
                else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                    b = h;
                }
            }
            catch (final RemoteException ex) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", (Throwable)ex);
                b = h;
            }
        }
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    zzs(final String a, @Nullable final h b, final boolean c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        Object b;
        if ((b = this.b) == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            b = null;
        }
        SafeParcelWriter.r(parcel, 2, (IBinder)b, false);
        SafeParcelWriter.g(parcel, 3, this.c);
        SafeParcelWriter.g(parcel, 4, this.d);
        SafeParcelWriter.b(parcel, a);
    }
}
