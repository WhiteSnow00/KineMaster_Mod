// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Iterator;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.ArrayList;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.MultiFactorSession;

@Class
public final class zzag extends MultiFactorSession
{
    public static final Parcelable$Creator<zzag> CREATOR;
    @Field
    private String a;
    @Field
    private String b;
    @Field
    private List c;
    
    static {
        CREATOR = (Parcelable$Creator)new zzah();
    }
    
    private zzag() {
    }
    
    @Constructor
    zzag(@Param final String a, @Param final String b, @Param final List c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static zzag K1(final List list, final String b) {
        Preconditions.k(list);
        Preconditions.g(b);
        final zzag zzag = new zzag();
        zzag.c = new ArrayList();
        for (final MultiFactorInfo multiFactorInfo : list) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzag.c.add(multiFactorInfo);
            }
        }
        zzag.b = b;
        return zzag;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.F(parcel, 3, (List<Parcelable>)this.c, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zzc() {
        return this.a;
    }
    
    public final String zzd() {
        return this.b;
    }
    
    public final boolean zze() {
        return this.a != null;
    }
}
