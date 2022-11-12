// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.auth.zzbz;

@SafeParcelable.Class
public final class zzn extends zzbz
{
    public static final Parcelable$Creator<zzn> CREATOR;
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f;
    @SafeParcelable.Indicator
    final Set<Integer> a;
    @SafeParcelable.VersionField
    final int b;
    @SafeParcelable.Field
    private ArrayList<zzt> c;
    @SafeParcelable.Field
    private int d;
    @SafeParcelable.Field
    private zzr e;
    
    static {
        CREATOR = (Parcelable$Creator)new zzo();
        final HashMap f2 = new HashMap();
        (f = f2).put("authenticatorData", FastJsonResponse.Field.M1("authenticatorData", 2, zzt.class));
        f2.put("progress", FastJsonResponse.Field.L1("progress", 4, zzr.class));
    }
    
    public zzn() {
        this.a = new HashSet<Integer>(1);
        this.b = 1;
    }
    
    @SafeParcelable.Constructor
    zzn(@SafeParcelable.Indicator final Set<Integer> a, @SafeParcelable.Param final int b, @SafeParcelable.Param final ArrayList<zzt> c, @SafeParcelable.Param final int d, @SafeParcelable.Param final zzr e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(final FastJsonResponse.Field field, final String s, final ArrayList<T> c) {
        final int q1 = field.Q1();
        if (q1 == 2) {
            this.c = (ArrayList<zzt>)c;
            this.a.add(q1);
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", q1, c.getClass().getCanonicalName()));
    }
    
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(final FastJsonResponse.Field field, final String s, final T t) {
        final int q1 = field.Q1();
        if (q1 == 4) {
            this.e = (zzr)t;
            this.a.add(q1);
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", q1, t.getClass().getCanonicalName()));
    }
    
    public final /* bridge */ Map getFieldMappings() {
        return zzn.f;
    }
    
    protected final Object getFieldValue(final FastJsonResponse.Field field) {
        final int q1 = field.Q1();
        if (q1 == 1) {
            return this.b;
        }
        if (q1 == 2) {
            return this.c;
        }
        if (q1 == 4) {
            return this.e;
        }
        final int q2 = field.Q1();
        final StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(q2);
        throw new IllegalStateException(sb.toString());
    }
    
    protected final boolean isFieldSet(final FastJsonResponse.Field field) {
        return this.a.contains(field.Q1());
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        final Set<Integer> a2 = this.a;
        if (a2.contains(1)) {
            SafeParcelWriter.s(parcel, 1, this.b);
        }
        if (a2.contains(2)) {
            SafeParcelWriter.F(parcel, 2, this.c, true);
        }
        if (a2.contains(3)) {
            SafeParcelWriter.s(parcel, 3, this.d);
        }
        if (a2.contains(4)) {
            SafeParcelWriter.A(parcel, 4, (Parcelable)this.e, n, true);
        }
        SafeParcelWriter.b(parcel, a);
    }
}
