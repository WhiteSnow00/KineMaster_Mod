// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.MapUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import android.util.Log;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.math.BigDecimal;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@ShowFirstParty
public abstract class FastJsonResponse
{
    protected static final Object zaD(final Field field, final Object o) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            return field.U1(o);
        }
        return o;
    }
    
    private final void zaE(final Field field, Object t1) {
        final String f = field.f;
        t1 = field.T1(t1);
        final int d = field.d;
        switch (d) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unsupported type for conversion: ");
                sb.append(d);
                throw new IllegalStateException(sb.toString());
            }
            case 8:
            case 9: {
                if (t1 != null) {
                    this.setDecodedBytesInternal(field, f, (byte[])t1);
                    return;
                }
                zaG(f);
                return;
            }
            case 7: {
                this.setStringInternal(field, f, (String)t1);
                return;
            }
            case 6: {
                if (t1 != null) {
                    this.setBooleanInternal(field, f, (boolean)t1);
                    return;
                }
                zaG(f);
                return;
            }
            case 5: {
                this.zab(field, f, (BigDecimal)t1);
                return;
            }
            case 4: {
                if (t1 != null) {
                    this.zan(field, f, (double)t1);
                    return;
                }
                zaG(f);
                return;
            }
            case 2: {
                if (t1 != null) {
                    this.setLongInternal(field, f, (long)t1);
                    return;
                }
                zaG(f);
                return;
            }
            case 1: {
                this.zaf(field, f, (BigInteger)t1);
                return;
            }
            case 0: {
                if (t1 != null) {
                    this.setIntegerInternal(field, f, (int)t1);
                    return;
                }
                zaG(f);
            }
        }
    }
    
    private static final void zaF(final StringBuilder sb, final Field field, final Object o) {
        final int b = field.b;
        if (b == 11) {
            final Class h = field.h;
            Preconditions.k(h);
            sb.append(((FastJsonResponse)h.cast(o)).toString());
            return;
        }
        if (b == 7) {
            sb.append("\"");
            sb.append(JsonUtils.a((String)o));
            sb.append("\"");
            return;
        }
        sb.append(o);
    }
    
    private static final void zaG(final String s) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Output field (");
            sb.append(s);
            sb.append(") has a null value, but expected a primitive");
            Log.e("FastJsonResponse", sb.toString());
        }
    }
    
    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(final Field field, final String s, final ArrayList<T> list) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }
    
    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(final Field field, final String s, final T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }
    
    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();
    
    @KeepForSdk
    protected Object getFieldValue(final Field field) {
        final String f = field.f;
        if (field.h != null) {
            Preconditions.q(this.getValueObject(f) == null, "Concrete field shouldn't be value object: %s", field.f);
            try {
                final char upperCase = Character.toUpperCase(f.charAt(0));
                final String substring = f.substring(1);
                final StringBuilder sb = new StringBuilder();
                sb.append("get");
                sb.append(upperCase);
                sb.append(substring);
                return this.getClass().getMethod(sb.toString(), (Class<?>[])new Class[0]).invoke(this, new Object[0]);
            }
            catch (final Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return this.getValueObject(f);
    }
    
    @KeepForSdk
    protected abstract Object getValueObject(final String p0);
    
    @KeepForSdk
    protected boolean isFieldSet(final Field field) {
        if (field.d != 11) {
            return this.isPrimitiveFieldSet(field.f);
        }
        if (field.e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }
    
    @KeepForSdk
    protected abstract boolean isPrimitiveFieldSet(final String p0);
    
    @KeepForSdk
    protected void setBooleanInternal(final Field<?, ?> field, final String s, final boolean b) {
        throw new UnsupportedOperationException("Boolean not supported");
    }
    
    @KeepForSdk
    protected void setDecodedBytesInternal(final Field<?, ?> field, final String s, final byte[] array) {
        throw new UnsupportedOperationException("byte[] not supported");
    }
    
    @KeepForSdk
    protected void setIntegerInternal(final Field<?, ?> field, final String s, final int n) {
        throw new UnsupportedOperationException("Integer not supported");
    }
    
    @KeepForSdk
    protected void setLongInternal(final Field<?, ?> field, final String s, final long n) {
        throw new UnsupportedOperationException("Long not supported");
    }
    
    @KeepForSdk
    protected void setStringInternal(final Field<?, ?> field, final String s, final String s2) {
        throw new UnsupportedOperationException("String not supported");
    }
    
    @KeepForSdk
    protected void setStringMapInternal(final Field<?, ?> field, final String s, final Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }
    
    @KeepForSdk
    protected void setStringsInternal(final Field<?, ?> field, final String s, final ArrayList<String> list) {
        throw new UnsupportedOperationException("String list not supported");
    }
    
    @KeepForSdk
    @Override
    public String toString() {
        final Map<String, Field<?, ?>> fieldMappings = this.getFieldMappings();
        final StringBuilder sb = new StringBuilder(100);
        for (final String s : fieldMappings.keySet()) {
            final Field field = fieldMappings.get(s);
            if (this.isFieldSet(field)) {
                final Object zaD = zaD(field, this.getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                }
                else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(s);
                sb.append("\":");
                if (zaD == null) {
                    sb.append("null");
                }
                else {
                    switch (field.d) {
                        default: {
                            if (field.c) {
                                final ArrayList list = (ArrayList)zaD;
                                sb.append("[");
                                for (int size = list.size(), i = 0; i < size; ++i) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    final Object value = list.get(i);
                                    if (value != null) {
                                        zaF(sb, field, value);
                                    }
                                }
                                sb.append("]");
                                continue;
                            }
                            zaF(sb, field, zaD);
                            continue;
                        }
                        case 10: {
                            MapUtils.a(sb, (HashMap<String, String>)zaD);
                            continue;
                        }
                        case 9: {
                            sb.append("\"");
                            sb.append(Base64Utils.d((byte[])zaD));
                            sb.append("\"");
                            continue;
                        }
                        case 8: {
                            sb.append("\"");
                            sb.append(Base64Utils.c((byte[])zaD));
                            sb.append("\"");
                            continue;
                        }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        }
        else {
            sb.append("{}");
        }
        return sb.toString();
    }
    
    public final void zaA(final Field field, final String s) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, s);
            return;
        }
        this.setStringInternal(field, field.f, s);
    }
    
    public final void zaB(final Field field, final Map map) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, map);
            return;
        }
        this.setStringMapInternal(field, field.f, map);
    }
    
    public final void zaC(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.setStringsInternal(field, field.f, list);
    }
    
    public final void zaa(final Field field, final BigDecimal bigDecimal) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, bigDecimal);
            return;
        }
        this.zab(field, field.f, bigDecimal);
    }
    
    protected void zab(final Field field, final String s, final BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }
    
    public final void zac(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.zad(field, field.f, list);
    }
    
    protected void zad(final Field field, final String s, final ArrayList list) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }
    
    public final void zae(final Field field, final BigInteger bigInteger) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, bigInteger);
            return;
        }
        this.zaf(field, field.f, bigInteger);
    }
    
    protected void zaf(final Field field, final String s, final BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }
    
    public final void zag(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.zah(field, field.f, list);
    }
    
    protected void zah(final Field field, final String s, final ArrayList list) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }
    
    public final void zai(final Field field, final boolean b) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, b);
            return;
        }
        this.setBooleanInternal(field, field.f, b);
    }
    
    public final void zaj(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.zak(field, field.f, list);
    }
    
    protected void zak(final Field field, final String s, final ArrayList list) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }
    
    public final void zal(final Field field, final byte[] array) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, array);
            return;
        }
        this.setDecodedBytesInternal(field, field.f, array);
    }
    
    public final void zam(final Field field, final double n) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, n);
            return;
        }
        this.zan(field, field.f, n);
    }
    
    protected void zan(final Field field, final String s, final double n) {
        throw new UnsupportedOperationException("Double not supported");
    }
    
    public final void zao(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.zap(field, field.f, list);
    }
    
    protected void zap(final Field field, final String s, final ArrayList list) {
        throw new UnsupportedOperationException("Double list not supported");
    }
    
    public final void zaq(final Field field, final float n) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, n);
            return;
        }
        this.zar(field, field.f, n);
    }
    
    protected void zar(final Field field, final String s, final float n) {
        throw new UnsupportedOperationException("Float not supported");
    }
    
    public final void zas(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.zat(field, field.f, list);
    }
    
    protected void zat(final Field field, final String s, final ArrayList list) {
        throw new UnsupportedOperationException("Float list not supported");
    }
    
    public final void zau(final Field field, final int n) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, n);
            return;
        }
        this.setIntegerInternal(field, field.f, n);
    }
    
    public final void zav(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.zaw(field, field.f, list);
    }
    
    protected void zaw(final Field field, final String s, final ArrayList list) {
        throw new UnsupportedOperationException("Integer list not supported");
    }
    
    public final void zax(final Field field, final long n) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, n);
            return;
        }
        this.setLongInternal(field, field.f, n);
    }
    
    public final void zay(final Field field, final ArrayList list) {
        if (Field.S1((Field<Object, Object>)field) != null) {
            this.zaE(field, list);
            return;
        }
        this.zaz(field, field.f, list);
    }
    
    protected void zaz(final Field field, final String s, final ArrayList list) {
        throw new UnsupportedOperationException("Long list not supported");
    }
    
    @KeepForSdk
    @ShowFirstParty
    @Class
    @VisibleForTesting
    public static class Field<I, O> extends AbstractSafeParcelable
    {
        public static final zaj CREATOR;
        @VersionField
        private final int a;
        @SafeParcelable.Field
        protected final int b;
        @SafeParcelable.Field
        protected final boolean c;
        @SafeParcelable.Field
        protected final int d;
        @SafeParcelable.Field
        protected final boolean e;
        @SafeParcelable.Field
        protected final String f;
        @SafeParcelable.Field
        protected final int g;
        protected final java.lang.Class h;
        @SafeParcelable.Field
        protected final String i;
        private zan j;
        @SafeParcelable.Field
        private FieldConverter p;
        
        static {
            CREATOR = new zaj();
        }
        
        @Constructor
        Field(@Param final int a, @Param final int b, @Param final boolean c, @Param final int d, @Param final boolean e, @Param final String f, @Param final int g, @Param final String i, @Param final zaa zaa) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            if (i == null) {
                this.h = null;
                this.i = null;
            }
            else {
                this.h = SafeParcelResponse.class;
                this.i = i;
            }
            if (zaa == null) {
                this.p = null;
                return;
            }
            this.p = zaa.L1();
        }
        
        protected Field(final int b, final boolean c, final int d, final boolean e, final String f, final int g, final java.lang.Class h, final FieldConverter p8) {
            this.a = 1;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            if (h == null) {
                this.i = null;
            }
            else {
                this.i = h.getCanonicalName();
            }
            this.p = p8;
        }
        
        @KeepForSdk
        @VisibleForTesting
        public static Field<byte[], byte[]> K1(final String s, final int n) {
            return new Field<byte[], byte[]>(8, false, 8, false, s, n, null, null);
        }
        
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> L1(final String s, final int n, final java.lang.Class<T> clazz) {
            return new Field<T, T>(11, false, 11, false, s, n, clazz, null);
        }
        
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> M1(final String s, final int n, final java.lang.Class<T> clazz) {
            return new Field<ArrayList<T>, ArrayList<T>>(11, true, 11, true, s, n, clazz, null);
        }
        
        @KeepForSdk
        @VisibleForTesting
        public static Field<Integer, Integer> N1(final String s, final int n) {
            return new Field<Integer, Integer>(0, false, 0, false, s, n, null, null);
        }
        
        @KeepForSdk
        public static Field<String, String> O1(final String s, final int n) {
            return new Field<String, String>(7, false, 7, false, s, n, null, null);
        }
        
        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> P1(final String s, final int n) {
            return new Field<ArrayList<String>, ArrayList<String>>(7, true, 7, true, s, n, null, null);
        }
        
        static /* bridge */ FieldConverter S1(final Field field) {
            return field.p;
        }
        
        @KeepForSdk
        public int Q1() {
            return this.g;
        }
        
        final zaa R1() {
            final FieldConverter p = this.p;
            if (p == null) {
                return null;
            }
            return zaa.K1(p);
        }
        
        public final Object T1(final Object o) {
            Preconditions.k(this.p);
            return Preconditions.k(this.p.R0(o));
        }
        
        public final Object U1(final Object o) {
            Preconditions.k(this.p);
            return this.p.K0(o);
        }
        
        final String V1() {
            String i;
            if ((i = this.i) == null) {
                i = null;
            }
            return i;
        }
        
        public final Map W1() {
            Preconditions.k(this.i);
            Preconditions.k(this.j);
            return Preconditions.k(this.j.L1(this.i));
        }
        
        public final void X1(final zan j) {
            this.j = j;
        }
        
        public final boolean Y1() {
            return this.p != null;
        }
        
        @Override
        public final String toString() {
            final Objects.ToStringHelper a = Objects.d(this).a("versionCode", this.a).a("typeIn", this.b).a("typeInArray", this.c).a("typeOut", this.d).a("typeOutArray", this.e).a("outputFieldName", this.f).a("safeParcelFieldId", this.g).a("concreteTypeName", this.V1());
            final java.lang.Class h = this.h;
            if (h != null) {
                a.a("concreteType.class", h.getCanonicalName());
            }
            final FieldConverter p = this.p;
            if (p != null) {
                a.a("converterName", p.getClass().getCanonicalName());
            }
            return a.toString();
        }
        
        public final void writeToParcel(final Parcel parcel, final int n) {
            final int a = SafeParcelWriter.a(parcel);
            SafeParcelWriter.s(parcel, 1, this.a);
            SafeParcelWriter.s(parcel, 2, this.b);
            SafeParcelWriter.g(parcel, 3, this.c);
            SafeParcelWriter.s(parcel, 4, this.d);
            SafeParcelWriter.g(parcel, 5, this.e);
            SafeParcelWriter.B(parcel, 6, this.f, false);
            SafeParcelWriter.s(parcel, 7, this.Q1());
            SafeParcelWriter.B(parcel, 8, this.V1(), false);
            SafeParcelWriter.A(parcel, 9, (Parcelable)this.R1(), n, false);
            SafeParcelWriter.b(parcel, a);
        }
    }
    
    @ShowFirstParty
    public interface FieldConverter<I, O>
    {
        Object K0(final Object p0);
        
        Object R0(final Object p0);
    }
}
