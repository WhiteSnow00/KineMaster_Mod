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
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@ShowFirstParty
@Class
public final class zan extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zan> CREATOR;
    @VersionField
    final int a;
    private final HashMap b;
    @Field
    private final String c;
    
    static {
        CREATOR = (Parcelable$Creator)new zao();
    }
    
    @Constructor
    zan(@Param int i, @Param final ArrayList list, @Param final String s) {
        this.a = i;
        final HashMap b = new HashMap();
        int size;
        zal zal;
        String b2;
        HashMap<String, FastJsonResponse.Field> hashMap;
        int size2;
        int j;
        zam zam;
        for (size = list.size(), i = 0; i < size; ++i) {
            zal = list.get(i);
            b2 = zal.b;
            hashMap = new HashMap<String, FastJsonResponse.Field>();
            for (size2 = Preconditions.k(zal.c).size(), j = 0; j < size2; ++j) {
                zam = zal.c.get(j);
                hashMap.put(zam.b, zam.c);
            }
            b.put(b2, hashMap);
        }
        this.b = b;
        this.c = Preconditions.k(s);
        this.M1();
    }
    
    public final String K1() {
        return this.c;
    }
    
    public final Map L1(final String s) {
        return this.b.get(s);
    }
    
    public final void M1() {
        final Iterator iterator = this.b.keySet().iterator();
        while (iterator.hasNext()) {
            final Map map = this.b.get(iterator.next());
            final Iterator iterator2 = map.keySet().iterator();
            while (iterator2.hasNext()) {
                ((FastJsonResponse.Field)map.get(iterator2.next())).X1(this);
            }
        }
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final String s : this.b.keySet()) {
            sb.append(s);
            sb.append(":\n");
            final Map map = this.b.get(s);
            for (final String s2 : map.keySet()) {
                sb.append("  ");
                sb.append(s2);
                sb.append(": ");
                sb.append(map.get(s2));
            }
        }
        return sb.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        final ArrayList list = new ArrayList();
        for (final String s : this.b.keySet()) {
            list.add(new zal(s, (Map)this.b.get(s)));
        }
        SafeParcelWriter.F(parcel, 2, (List<Parcelable>)list, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.b(parcel, a);
    }
}
