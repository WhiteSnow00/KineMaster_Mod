// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.stats;

import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import javax.annotation.Nullable;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;

@Deprecated
@KeepForSdk
@Class
public final class WakeLockEvent extends StatsEvent
{
    public static final Parcelable$Creator<WakeLockEvent> CREATOR;
    private long A;
    @VersionField
    final int a;
    @Field
    private final long b;
    @Field
    private int c;
    @Field
    private final String d;
    @Field
    private final String e;
    @Field
    private final String f;
    @Field
    private final int g;
    @Nullable
    @Field
    private final List h;
    @Field
    private final String i;
    @Field
    private final long j;
    @Field
    private int p;
    @Field
    private final String w;
    @Field
    private final float x;
    @Field
    private final long y;
    @Field
    private final boolean z;
    
    static {
        CREATOR = (Parcelable$Creator)new zza();
    }
    
    @Constructor
    WakeLockEvent(@Param final int a, @Param final long b, @Param final int c, @Param final String d, @Param final int g, @Nullable @Param final List h, @Param final String i, @Param final long j, @Param final int p15, @Param final String e, @Param final String w, @Param final float x, @Param final long y, @Param final String f, @Param final boolean z) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.A = -1L;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p15;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public final int K1() {
        return this.c;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.v(parcel, 2, this.b);
        SafeParcelWriter.B(parcel, 4, this.d, false);
        SafeParcelWriter.s(parcel, 5, this.g);
        SafeParcelWriter.D(parcel, 6, this.h, false);
        SafeParcelWriter.v(parcel, 8, this.j);
        SafeParcelWriter.B(parcel, 10, this.e, false);
        SafeParcelWriter.s(parcel, 11, this.c);
        SafeParcelWriter.B(parcel, 12, this.i, false);
        SafeParcelWriter.B(parcel, 13, this.w, false);
        SafeParcelWriter.s(parcel, 14, this.p);
        SafeParcelWriter.o(parcel, 15, this.x);
        SafeParcelWriter.v(parcel, 16, this.y);
        SafeParcelWriter.B(parcel, 17, this.f, false);
        SafeParcelWriter.g(parcel, 18, this.z);
        SafeParcelWriter.b(parcel, a);
    }
    
    @Override
    public final long zzb() {
        return this.A;
    }
    
    @Override
    public final long zzc() {
        return this.b;
    }
    
    @Override
    public final String zzd() {
        final List h = this.h;
        final String d = this.d;
        final int g = this.g;
        String s = "";
        String join;
        if (h == null) {
            join = "";
        }
        else {
            join = TextUtils.join((CharSequence)",", (Iterable)h);
        }
        final int p = this.p;
        String e;
        if ((e = this.e) == null) {
            e = "";
        }
        String w;
        if ((w = this.w) == null) {
            w = "";
        }
        final float x = this.x;
        final String f = this.f;
        if (f != null) {
            s = f;
        }
        final boolean z = this.z;
        final StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(d);
        sb.append("\t");
        sb.append(g);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(p);
        sb.append("\t");
        sb.append(e);
        sb.append("\t");
        sb.append(w);
        sb.append("\t");
        sb.append(x);
        sb.append("\t");
        sb.append(s);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
