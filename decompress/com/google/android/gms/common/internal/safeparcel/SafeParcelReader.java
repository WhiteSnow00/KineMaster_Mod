// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import android.os.Parcelable$Creator;
import java.util.ArrayList;
import android.os.Bundle;
import java.math.BigInteger;
import java.math.BigDecimal;
import android.os.IBinder;
import android.os.Parcel;

public class SafeParcelReader
{
    private SafeParcelReader() {
    }
    
    public static float A(final Parcel parcel, final int n) {
        L(parcel, n, 4);
        return parcel.readFloat();
    }
    
    public static Float B(final Parcel parcel, final int n) {
        final int h = H(parcel, n);
        if (h == 0) {
            return null;
        }
        K(parcel, n, h, 4);
        return parcel.readFloat();
    }
    
    public static int C(final Parcel parcel) {
        return parcel.readInt();
    }
    
    public static IBinder D(final Parcel parcel, int dataPosition) {
        final int h = H(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + h);
        return strongBinder;
    }
    
    public static int E(final Parcel parcel, final int n) {
        L(parcel, n, 4);
        return parcel.readInt();
    }
    
    public static long F(final Parcel parcel, final int n) {
        L(parcel, n, 8);
        return parcel.readLong();
    }
    
    public static Long G(final Parcel parcel, final int n) {
        final int h = H(parcel, n);
        if (h == 0) {
            return null;
        }
        K(parcel, n, h, 8);
        return parcel.readLong();
    }
    
    public static int H(final Parcel parcel, final int n) {
        if ((n & 0xFFFF0000) != 0xFFFF0000) {
            return (char)(n >> 16);
        }
        return parcel.readInt();
    }
    
    public static void I(final Parcel parcel, int h) {
        h = H(parcel, h);
        parcel.setDataPosition(parcel.dataPosition() + h);
    }
    
    public static int J(final Parcel parcel) {
        final int c = C(parcel);
        final int h = H(parcel, c);
        final int dataPosition = parcel.dataPosition();
        if (v(c) != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(c))), parcel);
        }
        final int n = h + dataPosition;
        if (n >= dataPosition && n <= parcel.dataSize()) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(n);
        throw new ParseException(sb.toString(), parcel);
    }
    
    private static void K(final Parcel parcel, final int n, final int n2, final int n3) {
        if (n2 == n3) {
            return;
        }
        final String hexString = Integer.toHexString(n2);
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected size ");
        sb.append(n3);
        sb.append(" got ");
        sb.append(n2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }
    
    private static void L(final Parcel parcel, int h, final int n) {
        h = H(parcel, h);
        if (h == n) {
            return;
        }
        final String hexString = Integer.toHexString(h);
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected size ");
        sb.append(n);
        sb.append(" got ");
        sb.append(h);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new ParseException(sb.toString(), parcel);
    }
    
    public static BigDecimal a(final Parcel parcel, int int1) {
        final int h = H(parcel, int1);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        int1 = parcel.readInt();
        parcel.setDataPosition(dataPosition + h);
        return new BigDecimal(new BigInteger(byteArray), int1);
    }
    
    public static BigDecimal[] b(final Parcel parcel, int i) {
        final int h = H(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final BigDecimal[] array = new BigDecimal[int1];
        for (i = 0; i < int1; ++i) {
            array[i] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + h);
        return array;
    }
    
    public static BigInteger c(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + h);
        return new BigInteger(byteArray);
    }
    
    public static BigInteger[] d(final Parcel parcel, int i) {
        final int h = H(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final BigInteger[] array = new BigInteger[int1];
        for (i = 0; i < int1; ++i) {
            array[i] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + h);
        return array;
    }
    
    public static boolean[] e(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final boolean[] booleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + h);
        return booleanArray;
    }
    
    public static Bundle f(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + h);
        return bundle;
    }
    
    public static byte[] g(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + h);
        return byteArray;
    }
    
    public static double[] h(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final double[] doubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + h);
        return doubleArray;
    }
    
    public static float[] i(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final float[] floatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + h);
        return floatArray;
    }
    
    public static int[] j(final Parcel parcel, int dataPosition) {
        final int h = H(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final int[] intArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + h);
        return intArray;
    }
    
    public static ArrayList<Integer> k(final Parcel parcel, int i) {
        final int h = H(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final ArrayList list = new ArrayList();
        int int1;
        for (int1 = parcel.readInt(), i = 0; i < int1; ++i) {
            list.add(parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + h);
        return list;
    }
    
    public static long[] l(final Parcel parcel, int dataPosition) {
        final int h = H(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final long[] longArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + h);
        return longArray;
    }
    
    public static Parcel m(final Parcel parcel, int dataPosition) {
        final int h = H(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, h);
        parcel.setDataPosition(dataPosition + h);
        return obtain;
    }
    
    public static Parcel[] n(final Parcel parcel, int i) {
        final int h = H(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final Parcel[] array = new Parcel[int1];
        int int2;
        int dataPosition2;
        Parcel obtain;
        for (i = 0; i < int1; ++i) {
            int2 = parcel.readInt();
            if (int2 != 0) {
                dataPosition2 = parcel.dataPosition();
                obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, int2);
                array[i] = obtain;
                parcel.setDataPosition(dataPosition2 + int2);
            }
            else {
                array[i] = null;
            }
        }
        parcel.setDataPosition(dataPosition + h);
        return array;
    }
    
    public static <T extends Parcelable> T o(final Parcel parcel, int h, final Parcelable$Creator<T> parcelable$Creator) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final Parcelable parcelable = (Parcelable)parcelable$Creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + h);
        return (T)parcelable;
    }
    
    public static String p(final Parcel parcel, int dataPosition) {
        final int h = H(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final String string = parcel.readString();
        parcel.setDataPosition(dataPosition + h);
        return string;
    }
    
    public static String[] q(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final String[] stringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + h);
        return stringArray;
    }
    
    public static ArrayList<String> r(final Parcel parcel, int h) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final ArrayList stringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + h);
        return stringArrayList;
    }
    
    public static <T> T[] s(final Parcel parcel, int h, final Parcelable$Creator<T> parcelable$Creator) {
        h = H(parcel, h);
        final int dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final Object[] typedArray = parcel.createTypedArray((Parcelable$Creator)parcelable$Creator);
        parcel.setDataPosition(dataPosition + h);
        return (T[])typedArray;
    }
    
    public static <T> ArrayList<T> t(final Parcel parcel, int dataPosition, final Parcelable$Creator<T> parcelable$Creator) {
        final int h = H(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (h == 0) {
            return null;
        }
        final ArrayList typedArrayList = parcel.createTypedArrayList((Parcelable$Creator)parcelable$Creator);
        parcel.setDataPosition(dataPosition + h);
        return typedArrayList;
    }
    
    public static void u(final Parcel parcel, final int n) {
        if (parcel.dataPosition() == n) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Overread allowed size end=");
        sb.append(n);
        throw new ParseException(sb.toString(), parcel);
    }
    
    public static int v(final int n) {
        return (char)n;
    }
    
    public static boolean w(final Parcel parcel, final int n) {
        L(parcel, n, 4);
        return parcel.readInt() != 0;
    }
    
    public static Boolean x(final Parcel parcel, final int n) {
        final int h = H(parcel, n);
        if (h == 0) {
            return null;
        }
        K(parcel, n, h, 4);
        return parcel.readInt() != 0;
    }
    
    public static double y(final Parcel parcel, final int n) {
        L(parcel, n, 8);
        return parcel.readDouble();
    }
    
    public static Double z(final Parcel parcel, final int n) {
        final int h = H(parcel, n);
        if (h == 0) {
            return null;
        }
        K(parcel, n, h, 8);
        return parcel.readDouble();
    }
    
    public static class ParseException extends RuntimeException
    {
        public ParseException(final String s, final Parcel parcel) {
            final int dataPosition = parcel.dataPosition();
            final int dataSize = parcel.dataSize();
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(" Parcel: pos=");
            sb.append(dataPosition);
            sb.append(" size=");
            sb.append(dataSize);
            super(sb.toString());
        }
    }
}
