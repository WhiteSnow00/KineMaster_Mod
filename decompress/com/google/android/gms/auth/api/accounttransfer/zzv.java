// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Map;
import androidx.collection.b;
import android.app.PendingIntent;
import java.util.Set;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.auth.zzbz;

@SafeParcelable.Class
public final class zzv extends zzbz
{
    public static final Parcelable$Creator<zzv> CREATOR;
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> h;
    @SafeParcelable.Indicator
    final Set<Integer> a;
    @SafeParcelable.VersionField
    final int b;
    @SafeParcelable.Field
    private String c;
    @SafeParcelable.Field
    private int d;
    @SafeParcelable.Field
    private byte[] e;
    @SafeParcelable.Field
    private PendingIntent f;
    @SafeParcelable.Field
    private DeviceMetaData g;
    
    static {
        CREATOR = (Parcelable$Creator)new zzw();
        final HashMap h2 = new HashMap();
        (h = h2).put("accountType", FastJsonResponse.Field.O1("accountType", 2));
        h2.put("status", FastJsonResponse.Field.N1("status", 3));
        h2.put("transferBytes", FastJsonResponse.Field.K1("transferBytes", 4));
    }
    
    public zzv() {
        this.a = new b<Integer>(3);
        this.b = 1;
    }
    
    @SafeParcelable.Constructor
    zzv(@SafeParcelable.Indicator final Set<Integer> a, @SafeParcelable.Param final int b, @SafeParcelable.Param final String c, @SafeParcelable.Param final int d, @SafeParcelable.Param final byte[] e, @SafeParcelable.Param final PendingIntent f, @SafeParcelable.Param final DeviceMetaData g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public final /* bridge */ Map getFieldMappings() {
        return zzv.h;
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
    
    protected final void setDecodedBytesInternal(final FastJsonResponse.Field<?, ?> field, final String s, final byte[] e) {
        final int q1 = field.Q1();
        if (q1 == 4) {
            this.e = e;
            this.a.add(q1);
            return;
        }
        final StringBuilder sb = new StringBuilder(59);
        sb.append("Field with id=");
        sb.append(q1);
        sb.append(" is not known to be an byte array.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    protected final void setIntegerInternal(final FastJsonResponse.Field<?, ?> field, final String s, final int d) {
        final int q1 = field.Q1();
        if (q1 == 3) {
            this.d = d;
            this.a.add(q1);
            return;
        }
        final StringBuilder sb = new StringBuilder(52);
        sb.append("Field with id=");
        sb.append(q1);
        sb.append(" is not known to be an int.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    protected final void setStringInternal(final FastJsonResponse.Field<?, ?> field, final String s, final String c) {
        final int q1 = field.Q1();
        if (q1 == 2) {
            this.c = c;
            this.a.add(q1);
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", q1));
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        final Set<Integer> a2 = this.a;
        if (a2.contains(1)) {
            SafeParcelWriter.s(parcel, 1, this.b);
        }
        if (a2.contains(2)) {
            SafeParcelWriter.B(parcel, 2, this.c, true);
        }
        if (a2.contains(3)) {
            SafeParcelWriter.s(parcel, 3, this.d);
        }
        if (a2.contains(4)) {
            SafeParcelWriter.k(parcel, 4, this.e, true);
        }
        if (a2.contains(5)) {
            SafeParcelWriter.A(parcel, 5, (Parcelable)this.f, n, true);
        }
        if (a2.contains(6)) {
            SafeParcelWriter.A(parcel, 6, (Parcelable)this.g, n, true);
        }
        SafeParcelWriter.b(parcel, a);
    }
}
