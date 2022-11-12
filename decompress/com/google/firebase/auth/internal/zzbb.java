// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzbb extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzbb> CREATOR;
    @Field
    private final List a;
    
    static {
        CREATOR = (Parcelable$Creator)new zzbc();
    }
    
    @Constructor
    zzbb(@Param final List list) {
        List a = list;
        if (list == null) {
            a = new ArrayList();
        }
        this.a = a;
    }
    
    public final List K1() {
        final ArrayList list = new ArrayList();
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, (List<Parcelable>)this.a, false);
        SafeParcelWriter.b(parcel, a);
    }
}
