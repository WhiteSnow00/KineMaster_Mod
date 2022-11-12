// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.os.Parcelable;
import b1.b;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public class RemoteActionCompatParcelizer
{
    public static RemoteActionCompat read(final VersionedParcel versionedParcel) {
        final RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.a = versionedParcel.v(remoteActionCompat.a, 1);
        remoteActionCompat.b = versionedParcel.l(remoteActionCompat.b, 2);
        remoteActionCompat.c = versionedParcel.l(remoteActionCompat.c, 3);
        remoteActionCompat.d = versionedParcel.r(remoteActionCompat.d, 4);
        remoteActionCompat.e = versionedParcel.h(remoteActionCompat.e, 5);
        remoteActionCompat.f = versionedParcel.h(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }
    
    public static void write(final RemoteActionCompat remoteActionCompat, final VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.a, 1);
        versionedParcel.D(remoteActionCompat.b, 2);
        versionedParcel.D(remoteActionCompat.c, 3);
        versionedParcel.H((Parcelable)remoteActionCompat.d, 4);
        versionedParcel.z(remoteActionCompat.e, 5);
        versionedParcel.z(remoteActionCompat.f, 6);
    }
}
