// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics.drawable;

import android.os.Parcelable;
import android.content.res.ColorStateList;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer
{
    public static IconCompat read(final VersionedParcel versionedParcel) {
        final IconCompat iconCompat = new IconCompat();
        iconCompat.a = versionedParcel.p(iconCompat.a, 1);
        iconCompat.c = versionedParcel.j(iconCompat.c, 2);
        iconCompat.d = versionedParcel.r(iconCompat.d, 3);
        iconCompat.e = versionedParcel.p(iconCompat.e, 4);
        iconCompat.f = versionedParcel.p(iconCompat.f, 5);
        iconCompat.g = versionedParcel.r(iconCompat.g, 6);
        iconCompat.i = versionedParcel.t(iconCompat.i, 7);
        iconCompat.j = versionedParcel.t(iconCompat.j, 8);
        iconCompat.n();
        return iconCompat;
    }
    
    public static void write(final IconCompat iconCompat, final VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.o(versionedParcel.f());
        final int a = iconCompat.a;
        if (-1 != a) {
            versionedParcel.F(a, 1);
        }
        final byte[] c = iconCompat.c;
        if (c != null) {
            versionedParcel.B(c, 2);
        }
        final Parcelable d = iconCompat.d;
        if (d != null) {
            versionedParcel.H(d, 3);
        }
        final int e = iconCompat.e;
        if (e != 0) {
            versionedParcel.F(e, 4);
        }
        final int f = iconCompat.f;
        if (f != 0) {
            versionedParcel.F(f, 5);
        }
        final ColorStateList g = iconCompat.g;
        if (g != null) {
            versionedParcel.H((Parcelable)g, 6);
        }
        final String i = iconCompat.i;
        if (i != null) {
            versionedParcel.J(i, 7);
        }
        final String j = iconCompat.j;
        if (j != null) {
            versionedParcel.J(j, 8);
        }
    }
}
