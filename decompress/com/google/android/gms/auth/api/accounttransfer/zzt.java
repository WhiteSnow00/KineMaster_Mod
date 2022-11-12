// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.auth.zzbz;

@SafeParcelable.Class
public final class zzt extends zzbz
{
    public static final Parcelable$Creator<zzt> CREATOR;
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> g;
    @SafeParcelable.Indicator
    final Set<Integer> a;
    @SafeParcelable.VersionField
    final int b;
    @SafeParcelable.Field
    private zzv c;
    @SafeParcelable.Field
    private String d;
    @SafeParcelable.Field
    private String e;
    @SafeParcelable.Field
    private String f;
    
    static {
        CREATOR = (Parcelable$Creator)new zzu();
        final HashMap g2 = new HashMap();
        (g = g2).put("authenticatorInfo", FastJsonResponse.Field.L1("authenticatorInfo", 2, zzv.class));
        g2.put("signature", FastJsonResponse.Field.O1("signature", 3));
        g2.put("package", FastJsonResponse.Field.O1("package", 4));
    }
    
    public zzt() {
        this.a = new HashSet<Integer>(3);
        this.b = 1;
    }
    
    @SafeParcelable.Constructor
    zzt(@SafeParcelable.Indicator final Set<Integer> a, @SafeParcelable.Param final int b, @SafeParcelable.Param final zzv c, @SafeParcelable.Param final String d, @SafeParcelable.Param final String e, @SafeParcelable.Param final String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(final FastJsonResponse.Field field, final String s, final T t) {
        final int q1 = field.Q1();
        if (q1 == 2) {
            this.c = (zzv)t;
            this.a.add(q1);
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", q1, t.getClass().getCanonicalName()));
    }
    
    public final /* bridge */ Map getFieldMappings() {
        return zzt.g;
    }
    
    protected final Object getFieldValue(final FastJsonResponse.Field field) {
        final int q1 = field.Q1();
        if (q1 == 1) {
            return this.b;
        }
        if (q1 == 2) {
            return this.c;
        }
        if (q1 == 3) {
            return this.d;
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
    
    protected final void setStringInternal(final FastJsonResponse.Field<?, ?> field, final String s, final String s2) {
        final int q1 = field.Q1();
        if (q1 != 3) {
            if (q1 != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", q1));
            }
            this.e = s2;
        }
        else {
            this.d = s2;
        }
        this.a.add(q1);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        final Set<Integer> a2 = this.a;
        if (a2.contains(1)) {
            SafeParcelWriter.s(parcel, 1, this.b);
        }
        if (a2.contains(2)) {
            SafeParcelWriter.A(parcel, 2, (Parcelable)this.c, n, true);
        }
        if (a2.contains(3)) {
            SafeParcelWriter.B(parcel, 3, this.d, true);
        }
        if (a2.contains(4)) {
            SafeParcelWriter.B(parcel, 4, this.e, true);
        }
        if (a2.contains(5)) {
            SafeParcelWriter.B(parcel, 5, this.f, true);
        }
        SafeParcelWriter.b(parcel, a);
    }
}
