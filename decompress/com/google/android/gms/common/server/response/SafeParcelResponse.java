// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import java.math.BigInteger;
import java.math.BigDecimal;
import android.os.Parcelable;
import java.util.List;
import java.util.ArrayList;
import com.google.android.gms.common.util.MapUtils;
import java.util.Set;
import android.os.Bundle;
import java.util.Iterator;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.ArrayUtils;
import java.util.HashMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.util.SparseArray;
import java.util.Map;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Class
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse
{
    @KeepForSdk
    public static final Parcelable$Creator<SafeParcelResponse> CREATOR;
    @VersionField
    private final int a;
    @SafeParcelable.Field
    private final Parcel b;
    private final int c;
    @SafeParcelable.Field
    private final zan d;
    private final String e;
    private int f;
    private int g;
    
    static {
        CREATOR = (Parcelable$Creator)new zaq();
    }
    
    @Constructor
    SafeParcelResponse(@Param final int a, @Param final Parcel parcel, @Param final zan d) {
        this.a = a;
        this.b = Preconditions.k(parcel);
        this.c = 2;
        this.d = d;
        String k1;
        if (d == null) {
            k1 = null;
        }
        else {
            k1 = d.K1();
        }
        this.e = k1;
        this.f = 2;
    }
    
    private final void b(final FastJsonResponse.Field field) {
        if (field.g == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        final Parcel b = this.b;
        if (b == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        final int f = this.f;
        if (f == 0) {
            this.g = SafeParcelWriter.a(b);
            this.f = 1;
            return;
        }
        if (f == 1) {
            return;
        }
        throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
    }
    
    private final void c(final StringBuilder sb, final Map map, final Parcel parcel) {
        final SparseArray sparseArray = new SparseArray();
        for (final Map.Entry<K, FastJsonResponse.Field> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().Q1(), (Object)entry);
        }
        sb.append('{');
        final int j = SafeParcelReader.J(parcel);
        int n = 0;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final Map.Entry entry2 = (Map.Entry)sparseArray.get(SafeParcelReader.v(c));
            if (entry2 != null) {
                if (n != 0) {
                    sb.append(",");
                }
                final String s = (String)entry2.getKey();
                final FastJsonResponse.Field field = (FastJsonResponse.Field)entry2.getValue();
                sb.append("\"");
                sb.append(s);
                sb.append("\":");
                if (field.Y1()) {
                    final int d = field.d;
                    switch (d) {
                        default: {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unknown field out type = ");
                            sb2.append(d);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        case 11: {
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        }
                        case 10: {
                            final Bundle f = SafeParcelReader.f(parcel, c);
                            final HashMap<String, String> hashMap = new HashMap<String, String>();
                            for (final String s2 : f.keySet()) {
                                hashMap.put(s2, Preconditions.k(f.getString(s2)));
                            }
                            e(sb, field, FastJsonResponse.zaD(field, hashMap));
                            break;
                        }
                        case 8:
                        case 9: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.g(parcel, c)));
                            break;
                        }
                        case 7: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.p(parcel, c)));
                            break;
                        }
                        case 6: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.w(parcel, c)));
                            break;
                        }
                        case 5: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.a(parcel, c)));
                            break;
                        }
                        case 4: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.y(parcel, c)));
                            break;
                        }
                        case 3: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.A(parcel, c)));
                            break;
                        }
                        case 2: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.F(parcel, c)));
                            break;
                        }
                        case 1: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.c(parcel, c)));
                            break;
                        }
                        case 0: {
                            e(sb, field, FastJsonResponse.zaD(field, SafeParcelReader.E(parcel, c)));
                            break;
                        }
                    }
                }
                else if (field.e) {
                    sb.append("[");
                    switch (field.d) {
                        default: {
                            throw new IllegalStateException("Unknown field type out.");
                        }
                        case 11: {
                            final Parcel[] n2 = SafeParcelReader.n(parcel, c);
                            for (int length = n2.length, i = 0; i < length; ++i) {
                                if (i > 0) {
                                    sb.append(",");
                                }
                                n2[i].setDataPosition(0);
                                this.c(sb, field.W1(), n2[i]);
                            }
                            break;
                        }
                        case 8:
                        case 9:
                        case 10: {
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        }
                        case 7: {
                            ArrayUtils.j(sb, SafeParcelReader.q(parcel, c));
                            break;
                        }
                        case 6: {
                            ArrayUtils.i(sb, SafeParcelReader.e(parcel, c));
                            break;
                        }
                        case 5: {
                            ArrayUtils.h(sb, SafeParcelReader.b(parcel, c));
                            break;
                        }
                        case 4: {
                            ArrayUtils.d(sb, SafeParcelReader.h(parcel, c));
                            break;
                        }
                        case 3: {
                            ArrayUtils.e(sb, SafeParcelReader.i(parcel, c));
                            break;
                        }
                        case 2: {
                            ArrayUtils.g(sb, SafeParcelReader.l(parcel, c));
                            break;
                        }
                        case 1: {
                            ArrayUtils.h(sb, SafeParcelReader.d(parcel, c));
                            break;
                        }
                        case 0: {
                            ArrayUtils.f(sb, SafeParcelReader.j(parcel, c));
                            break;
                        }
                    }
                    sb.append("]");
                }
                else {
                    switch (field.d) {
                        default: {
                            throw new IllegalStateException("Unknown field type out");
                        }
                        case 11: {
                            final Parcel m = SafeParcelReader.m(parcel, c);
                            m.setDataPosition(0);
                            this.c(sb, field.W1(), m);
                            break;
                        }
                        case 10: {
                            final Bundle f2 = SafeParcelReader.f(parcel, c);
                            final Set keySet = f2.keySet();
                            sb.append("{");
                            final Iterator iterator3 = keySet.iterator();
                            int n3 = 1;
                            while (iterator3.hasNext()) {
                                final String s3 = (String)iterator3.next();
                                if (n3 == 0) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(s3);
                                sb.append("\":\"");
                                sb.append(JsonUtils.a(f2.getString(s3)));
                                sb.append("\"");
                                n3 = 0;
                            }
                            sb.append("}");
                            break;
                        }
                        case 9: {
                            final byte[] g = SafeParcelReader.g(parcel, c);
                            sb.append("\"");
                            sb.append(Base64Utils.d(g));
                            sb.append("\"");
                            break;
                        }
                        case 8: {
                            final byte[] g2 = SafeParcelReader.g(parcel, c);
                            sb.append("\"");
                            sb.append(Base64Utils.c(g2));
                            sb.append("\"");
                            break;
                        }
                        case 7: {
                            final String p3 = SafeParcelReader.p(parcel, c);
                            sb.append("\"");
                            sb.append(JsonUtils.a(p3));
                            sb.append("\"");
                            break;
                        }
                        case 6: {
                            sb.append(SafeParcelReader.w(parcel, c));
                            break;
                        }
                        case 5: {
                            sb.append(SafeParcelReader.a(parcel, c));
                            break;
                        }
                        case 4: {
                            sb.append(SafeParcelReader.y(parcel, c));
                            break;
                        }
                        case 3: {
                            sb.append(SafeParcelReader.A(parcel, c));
                            break;
                        }
                        case 2: {
                            sb.append(SafeParcelReader.F(parcel, c));
                            break;
                        }
                        case 1: {
                            sb.append(SafeParcelReader.c(parcel, c));
                            break;
                        }
                        case 0: {
                            sb.append(SafeParcelReader.E(parcel, c));
                            break;
                        }
                    }
                }
                n = 1;
            }
        }
        if (parcel.dataPosition() == j) {
            sb.append('}');
            return;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Overread allowed size end=");
        sb3.append(j);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }
    
    private static final void d(StringBuilder sb, final int n, final Object o) {
        switch (n) {
            default: {
                sb = new StringBuilder();
                sb.append("Unknown type = ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            }
            case 11: {
                throw new IllegalArgumentException("Method does not accept concrete type.");
            }
            case 10: {
                MapUtils.a(sb, Preconditions.k(o));
                return;
            }
            case 9: {
                sb.append("\"");
                sb.append(Base64Utils.d((byte[])o));
                sb.append("\"");
                return;
            }
            case 8: {
                sb.append("\"");
                sb.append(Base64Utils.c((byte[])o));
                sb.append("\"");
                return;
            }
            case 7: {
                sb.append("\"");
                sb.append(JsonUtils.a(Preconditions.k(o).toString()));
                sb.append("\"");
                return;
            }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                sb.append(o);
            }
        }
    }
    
    private static final void e(final StringBuilder sb, final FastJsonResponse.Field field, final Object o) {
        if (field.c) {
            final ArrayList list = (ArrayList)o;
            sb.append("[");
            for (int size = list.size(), i = 0; i < size; ++i) {
                if (i != 0) {
                    sb.append(",");
                }
                d(sb, field.b, list.get(i));
            }
            sb.append("]");
            return;
        }
        d(sb, field.b, o);
    }
    
    public final Parcel a() {
        final int f = this.f;
        if (f != 0) {
            if (f == 1) {
                SafeParcelWriter.b(this.b, this.g);
                this.f = 2;
            }
        }
        else {
            final int a = SafeParcelWriter.a(this.b);
            this.g = a;
            SafeParcelWriter.b(this.b, a);
            this.f = 2;
        }
        return this.b;
    }
    
    @Override
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(final FastJsonResponse.Field field, final String s, final ArrayList<T> list) {
        this.b(field);
        final ArrayList list2 = new ArrayList();
        Preconditions.k(list).size();
        for (int size = list.size(), i = 0; i < size; ++i) {
            list2.add(((SafeParcelResponse)list.get(i)).a());
        }
        SafeParcelWriter.z(this.b, field.Q1(), list2, true);
    }
    
    @Override
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(final FastJsonResponse.Field field, final String s, final T t) {
        this.b(field);
        SafeParcelWriter.y(this.b, field.Q1(), ((SafeParcelResponse)t).a(), true);
    }
    
    @Override
    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        final zan d = this.d;
        if (d == null) {
            return null;
        }
        return d.L1(Preconditions.k(this.e));
    }
    
    @Override
    public final Object getValueObject(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    @Override
    public final boolean isPrimitiveFieldSet(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    @Override
    protected final void setBooleanInternal(final FastJsonResponse.Field<?, ?> field, final String s, final boolean b) {
        this.b(field);
        SafeParcelWriter.g(this.b, field.Q1(), b);
    }
    
    @Override
    protected final void setDecodedBytesInternal(final FastJsonResponse.Field<?, ?> field, final String s, final byte[] array) {
        this.b(field);
        SafeParcelWriter.k(this.b, field.Q1(), array, true);
    }
    
    @Override
    protected final void setIntegerInternal(final FastJsonResponse.Field<?, ?> field, final String s, final int n) {
        this.b(field);
        SafeParcelWriter.s(this.b, field.Q1(), n);
    }
    
    @Override
    protected final void setLongInternal(final FastJsonResponse.Field<?, ?> field, final String s, final long n) {
        this.b(field);
        SafeParcelWriter.v(this.b, field.Q1(), n);
    }
    
    @Override
    protected final void setStringInternal(final FastJsonResponse.Field<?, ?> field, final String s, final String s2) {
        this.b(field);
        SafeParcelWriter.B(this.b, field.Q1(), s2, true);
    }
    
    @Override
    protected final void setStringMapInternal(final FastJsonResponse.Field<?, ?> field, final String s, final Map<String, String> map) {
        this.b(field);
        final Bundle bundle = new Bundle();
        for (final String s2 : Preconditions.k(map).keySet()) {
            bundle.putString(s2, (String)map.get(s2));
        }
        SafeParcelWriter.j(this.b, field.Q1(), bundle, true);
    }
    
    @Override
    protected final void setStringsInternal(final FastJsonResponse.Field<?, ?> field, final String s, final ArrayList<String> list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final String[] array = new String[size];
        for (int i = 0; i < size; ++i) {
            array[i] = list.get(i);
        }
        SafeParcelWriter.C(this.b, field.Q1(), array, true);
    }
    
    @Override
    public final String toString() {
        Preconditions.l(this.d, "Cannot convert to JSON on client side.");
        final Parcel a = this.a();
        a.setDataPosition(0);
        final StringBuilder sb = new StringBuilder(100);
        this.c(sb, Preconditions.k(this.d.L1(Preconditions.k(this.e))), a);
        return sb.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.y(parcel, 2, this.a(), false);
        final int c = this.c;
        Object o;
        if (c != 0) {
            if (c != 1) {
                o = this.d;
            }
            else {
                o = this.d;
            }
        }
        else {
            o = null;
        }
        SafeParcelWriter.A(parcel, 3, (Parcelable)o, n, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    @Override
    protected final void zab(final FastJsonResponse.Field field, final String s, final BigDecimal bigDecimal) {
        this.b(field);
        SafeParcelWriter.c(this.b, field.Q1(), bigDecimal, true);
    }
    
    @Override
    protected final void zad(final FastJsonResponse.Field field, final String s, final ArrayList list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final BigDecimal[] array = new BigDecimal[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (BigDecimal)list.get(i);
        }
        SafeParcelWriter.d(this.b, field.Q1(), array, true);
    }
    
    @Override
    protected final void zaf(final FastJsonResponse.Field field, final String s, final BigInteger bigInteger) {
        this.b(field);
        SafeParcelWriter.e(this.b, field.Q1(), bigInteger, true);
    }
    
    @Override
    protected final void zah(final FastJsonResponse.Field field, final String s, final ArrayList list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final BigInteger[] array = new BigInteger[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (BigInteger)list.get(i);
        }
        SafeParcelWriter.f(this.b, field.Q1(), array, true);
    }
    
    @Override
    protected final void zak(final FastJsonResponse.Field field, final String s, final ArrayList list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final boolean[] array = new boolean[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (boolean)list.get(i);
        }
        SafeParcelWriter.h(this.b, field.Q1(), array, true);
    }
    
    @Override
    protected final void zan(final FastJsonResponse.Field field, final String s, final double n) {
        this.b(field);
        SafeParcelWriter.l(this.b, field.Q1(), n);
    }
    
    @Override
    protected final void zap(final FastJsonResponse.Field field, final String s, final ArrayList list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final double[] array = new double[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (double)list.get(i);
        }
        SafeParcelWriter.m(this.b, field.Q1(), array, true);
    }
    
    @Override
    protected final void zar(final FastJsonResponse.Field field, final String s, final float n) {
        this.b(field);
        SafeParcelWriter.o(this.b, field.Q1(), n);
    }
    
    @Override
    protected final void zat(final FastJsonResponse.Field field, final String s, final ArrayList list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final float[] array = new float[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (float)list.get(i);
        }
        SafeParcelWriter.p(this.b, field.Q1(), array, true);
    }
    
    @Override
    protected final void zaw(final FastJsonResponse.Field field, final String s, final ArrayList list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (int)list.get(i);
        }
        SafeParcelWriter.t(this.b, field.Q1(), array, true);
    }
    
    @Override
    protected final void zaz(final FastJsonResponse.Field field, final String s, final ArrayList list) {
        this.b(field);
        final int size = Preconditions.k(list).size();
        final long[] array = new long[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (long)list.get(i);
        }
        SafeParcelWriter.w(this.b, field.Q1(), array, true);
    }
}
