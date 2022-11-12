// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.converter;

import java.util.Iterator;
import android.os.Parcelable;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import android.util.SparseArray;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
public final class StringToIntConverter extends AbstractSafeParcelable implements FieldConverter<String, Integer>
{
    public static final Parcelable$Creator<StringToIntConverter> CREATOR;
    @VersionField
    final int a;
    private final HashMap b;
    private final SparseArray c;
    
    static {
        CREATOR = (Parcelable$Creator)new zad();
    }
    
    @KeepForSdk
    public StringToIntConverter() {
        this.a = 1;
        this.b = new HashMap();
        this.c = new SparseArray();
    }
    
    @Constructor
    StringToIntConverter(@Param int i, @Param final ArrayList list) {
        this.a = i;
        this.b = new HashMap();
        this.c = new SparseArray();
        int size;
        zac zac;
        for (size = list.size(), i = 0; i < size; ++i) {
            zac = (zac)list.get(i);
            this.K1(zac.b, zac.c);
        }
    }
    
    @Override
    public final /* bridge */ Object K0(final Object o) {
        final String s = (String)this.c.get((int)o);
        if (s == null && this.b.containsKey("gms_unknown")) {
            return "gms_unknown";
        }
        return s;
    }
    
    @KeepForSdk
    @CanIgnoreReturnValue
    public StringToIntConverter K1(final String s, final int n) {
        this.b.put(s, n);
        this.c.put(n, (Object)s);
        return this;
    }
    
    @Override
    public final /* bridge */ Object R0(final Object o) {
        Integer n;
        if ((n = this.b.get(o)) == null) {
            n = this.b.get("gms_unknown");
        }
        return n;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        final ArrayList list = new ArrayList();
        for (final String s : this.b.keySet()) {
            list.add(new zac(s, (int)this.b.get(s)));
        }
        SafeParcelWriter.F(parcel, 2, (List<Parcelable>)list, false);
        SafeParcelWriter.b(parcel, a);
    }
}
