// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import android.os.Parcelable;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@ShowFirstParty
@Class
public final class zal extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zal> CREATOR;
    @VersionField
    final int a;
    @Field
    final String b;
    @Field
    final ArrayList c;
    
    static {
        CREATOR = (Parcelable$Creator)new zap();
    }
    
    @Constructor
    zal(@Param final int a, @Param final String b, @Param final ArrayList c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    zal(String b, final Map map) {
        this.a = 1;
        this.b = b;
        ArrayList c;
        if (map == null) {
            c = null;
        }
        else {
            final ArrayList list = new ArrayList();
            final Iterator iterator = map.keySet().iterator();
            while (true) {
                c = list;
                if (!iterator.hasNext()) {
                    break;
                }
                b = (String)iterator.next();
                list.add(new zam(b, (FastJsonResponse.Field)map.get(b)));
            }
        }
        this.c = c;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.F(parcel, 3, (List<Parcelable>)this.c, false);
        SafeParcelWriter.b(parcel, a);
    }
}
