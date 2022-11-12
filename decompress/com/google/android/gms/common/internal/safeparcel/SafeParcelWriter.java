// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.IBinder;
import android.os.Bundle;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;

public class SafeParcelWriter
{
    private SafeParcelWriter() {
    }
    
    public static void A(final Parcel parcel, int g, final Parcelable parcelable, final int n, final boolean b) {
        if (parcelable == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcelable.writeToParcel(parcel, n);
        H(parcel, g);
    }
    
    public static void B(final Parcel parcel, int g, final String s, final boolean b) {
        if (s == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeString(s);
        H(parcel, g);
    }
    
    public static void C(final Parcel parcel, int g, final String[] array, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeStringArray(array);
        H(parcel, g);
    }
    
    public static void D(final Parcel parcel, int g, final List<String> list, final boolean b) {
        if (list == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeStringList((List)list);
        H(parcel, g);
    }
    
    public static <T extends Parcelable> void E(final Parcel parcel, int i, final T[] array, final int n, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, i, 0);
            }
            return;
        }
        final int g = G(parcel, i);
        final int length = array.length;
        parcel.writeInt(length);
        Parcelable parcelable;
        for (i = 0; i < length; ++i) {
            parcelable = array[i];
            if (parcelable == null) {
                parcel.writeInt(0);
            }
            else {
                J(parcel, parcelable, n);
            }
        }
        H(parcel, g);
    }
    
    public static <T extends Parcelable> void F(final Parcel parcel, int i, final List<T> list, final boolean b) {
        if (list == null) {
            if (b) {
                I(parcel, i, 0);
            }
            return;
        }
        final int g = G(parcel, i);
        final int size = list.size();
        parcel.writeInt(size);
        Parcelable parcelable;
        for (i = 0; i < size; ++i) {
            parcelable = list.get(i);
            if (parcelable == null) {
                parcel.writeInt(0);
            }
            else {
                J(parcel, parcelable, 0);
            }
        }
        H(parcel, g);
    }
    
    private static int G(final Parcel parcel, final int n) {
        parcel.writeInt(n | 0xFFFF0000);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }
    
    private static void H(final Parcel parcel, final int n) {
        final int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(n - 4);
        parcel.writeInt(dataPosition - n);
        parcel.setDataPosition(dataPosition);
    }
    
    private static void I(final Parcel parcel, final int n, final int n2) {
        parcel.writeInt(n | n2 << 16);
    }
    
    private static void J(final Parcel parcel, final Parcelable parcelable, int dataPosition) {
        final int dataPosition2 = parcel.dataPosition();
        parcel.writeInt(1);
        final int dataPosition3 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        parcel.setDataPosition(dataPosition2);
        parcel.writeInt(dataPosition - dataPosition3);
        parcel.setDataPosition(dataPosition);
    }
    
    public static int a(final Parcel parcel) {
        return G(parcel, 20293);
    }
    
    public static void b(final Parcel parcel, final int n) {
        H(parcel, n);
    }
    
    public static void c(final Parcel parcel, int g, final BigDecimal bigDecimal, final boolean b) {
        if (bigDecimal == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        H(parcel, g);
    }
    
    public static void d(final Parcel parcel, int i, final BigDecimal[] array, final boolean b) {
        final int n = 0;
        if (array == null) {
            if (b) {
                I(parcel, i, 0);
            }
            return;
        }
        final int g = G(parcel, i);
        final int length = array.length;
        parcel.writeInt(length);
        for (i = n; i < length; ++i) {
            parcel.writeByteArray(array[i].unscaledValue().toByteArray());
            parcel.writeInt(array[i].scale());
        }
        H(parcel, g);
    }
    
    public static void e(final Parcel parcel, int g, final BigInteger bigInteger, final boolean b) {
        if (bigInteger == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeByteArray(bigInteger.toByteArray());
        H(parcel, g);
    }
    
    public static void f(final Parcel parcel, int i, final BigInteger[] array, final boolean b) {
        final int n = 0;
        if (array == null) {
            if (b) {
                I(parcel, i, 0);
            }
            return;
        }
        final int g = G(parcel, i);
        final int length = array.length;
        parcel.writeInt(length);
        for (i = n; i < length; ++i) {
            parcel.writeByteArray(array[i].toByteArray());
        }
        H(parcel, g);
    }
    
    public static void g(final Parcel parcel, final int n, final boolean b) {
        I(parcel, n, 4);
        parcel.writeInt((int)(b ? 1 : 0));
    }
    
    public static void h(final Parcel parcel, int g, final boolean[] array, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeBooleanArray(array);
        H(parcel, g);
    }
    
    public static void i(final Parcel parcel, final int n, final Boolean b, final boolean b2) {
        if (b == null) {
            if (b2) {
                I(parcel, n, 0);
            }
            return;
        }
        I(parcel, n, 4);
        parcel.writeInt((int)(((boolean)b) ? 1 : 0));
    }
    
    public static void j(final Parcel parcel, int g, final Bundle bundle, final boolean b) {
        if (bundle == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeBundle(bundle);
        H(parcel, g);
    }
    
    public static void k(final Parcel parcel, int g, final byte[] array, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeByteArray(array);
        H(parcel, g);
    }
    
    public static void l(final Parcel parcel, final int n, final double n2) {
        I(parcel, n, 8);
        parcel.writeDouble(n2);
    }
    
    public static void m(final Parcel parcel, int g, final double[] array, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeDoubleArray(array);
        H(parcel, g);
    }
    
    public static void n(final Parcel parcel, final int n, final Double n2, final boolean b) {
        if (n2 == null) {
            if (b) {
                I(parcel, n, 0);
            }
            return;
        }
        I(parcel, n, 8);
        parcel.writeDouble((double)n2);
    }
    
    public static void o(final Parcel parcel, final int n, final float n2) {
        I(parcel, n, 4);
        parcel.writeFloat(n2);
    }
    
    public static void p(final Parcel parcel, int g, final float[] array, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeFloatArray(array);
        H(parcel, g);
    }
    
    public static void q(final Parcel parcel, final int n, final Float n2, final boolean b) {
        if (n2 == null) {
            if (b) {
                I(parcel, n, 0);
            }
            return;
        }
        I(parcel, n, 4);
        parcel.writeFloat((float)n2);
    }
    
    public static void r(final Parcel parcel, int g, final IBinder binder, final boolean b) {
        if (binder == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeStrongBinder(binder);
        H(parcel, g);
    }
    
    public static void s(final Parcel parcel, final int n, final int n2) {
        I(parcel, n, 4);
        parcel.writeInt(n2);
    }
    
    public static void t(final Parcel parcel, int g, final int[] array, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeIntArray(array);
        H(parcel, g);
    }
    
    public static void u(final Parcel parcel, int i, final List<Integer> list, final boolean b) {
        final int n = 0;
        if (list == null) {
            if (b) {
                I(parcel, i, 0);
            }
            return;
        }
        final int g = G(parcel, i);
        final int size = list.size();
        parcel.writeInt(size);
        for (i = n; i < size; ++i) {
            parcel.writeInt((int)list.get(i));
        }
        H(parcel, g);
    }
    
    public static void v(final Parcel parcel, final int n, final long n2) {
        I(parcel, n, 8);
        parcel.writeLong(n2);
    }
    
    public static void w(final Parcel parcel, int g, final long[] array, final boolean b) {
        if (array == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.writeLongArray(array);
        H(parcel, g);
    }
    
    public static void x(final Parcel parcel, final int n, final Long n2, final boolean b) {
        if (n2 == null) {
            if (b) {
                I(parcel, n, 0);
            }
            return;
        }
        I(parcel, n, 8);
        parcel.writeLong((long)n2);
    }
    
    public static void y(final Parcel parcel, int g, final Parcel parcel2, final boolean b) {
        if (parcel2 == null) {
            if (b) {
                I(parcel, g, 0);
            }
            return;
        }
        g = G(parcel, g);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        H(parcel, g);
    }
    
    public static void z(final Parcel parcel, int i, final List<Parcel> list, final boolean b) {
        if (list == null) {
            if (b) {
                I(parcel, i, 0);
            }
            return;
        }
        final int g = G(parcel, i);
        final int size = list.size();
        parcel.writeInt(size);
        Parcel parcel2;
        for (i = 0; i < size; ++i) {
            parcel2 = list.get(i);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            }
            else {
                parcel.writeInt(0);
            }
        }
        H(parcel, g);
    }
}
