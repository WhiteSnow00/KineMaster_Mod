// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import com.google.android.gms.common.server.response.FastJsonResponse;
import androidx.collection.a;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.auth.zzbz;

@SafeParcelable.Class
public final class zzr extends zzbz
{
    public static final Parcelable$Creator<zzr> CREATOR;
    private static final a<String, FastJsonResponse.Field<?, ?>> g;
    @SafeParcelable.VersionField
    final int a;
    @SafeParcelable.Field
    private List<String> b;
    @SafeParcelable.Field
    private List<String> c;
    @SafeParcelable.Field
    private List<String> d;
    @SafeParcelable.Field
    private List<String> e;
    @SafeParcelable.Field
    private List<String> f;
    
    static {
        CREATOR = (Parcelable$Creator)new zzs();
        final a g2 = new a();
        (g = g2).put("registered", FastJsonResponse.Field.P1("registered", 2));
        g2.put("in_progress", FastJsonResponse.Field.P1("in_progress", 3));
        g2.put("success", FastJsonResponse.Field.P1("success", 4));
        g2.put("failed", FastJsonResponse.Field.P1("failed", 5));
        g2.put("escrowed", FastJsonResponse.Field.P1("escrowed", 6));
    }
    
    public zzr() {
        this.a = 1;
    }
    
    @SafeParcelable.Constructor
    zzr(@SafeParcelable.Param final int a, @SafeParcelable.Param final List<String> b, @SafeParcelable.Param final List<String> c, @SafeParcelable.Param final List<String> d, @SafeParcelable.Param final List<String> e, @SafeParcelable.Param final List<String> f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        return zzr.g;
    }
    
    protected final Object getFieldValue(final FastJsonResponse.Field field) {
        switch (field.Q1()) {
            default: {
                final int q1 = field.Q1();
                final StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(q1);
                throw new IllegalStateException(sb.toString());
            }
            case 6: {
                return this.f;
            }
            case 5: {
                return this.e;
            }
            case 4: {
                return this.d;
            }
            case 3: {
                return this.c;
            }
            case 2: {
                return this.b;
            }
            case 1: {
                return this.a;
            }
        }
    }
    
    protected final boolean isFieldSet(final FastJsonResponse.Field field) {
        return true;
    }
    
    protected final void setStringsInternal(final FastJsonResponse.Field<?, ?> field, final String s, final ArrayList<String> f) {
        final int q1 = field.Q1();
        if (q1 == 2) {
            this.b = f;
            return;
        }
        if (q1 == 3) {
            this.c = f;
            return;
        }
        if (q1 == 4) {
            this.d = f;
            return;
        }
        if (q1 == 5) {
            this.e = f;
            return;
        }
        if (q1 == 6) {
            this.f = f;
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", q1));
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.D(parcel, 2, this.b, false);
        SafeParcelWriter.D(parcel, 3, this.c, false);
        SafeParcelWriter.D(parcel, 4, this.d, false);
        SafeParcelWriter.D(parcel, 5, this.e, false);
        SafeParcelWriter.D(parcel, 6, this.f, false);
        SafeParcelWriter.b(parcel, a);
    }
}
