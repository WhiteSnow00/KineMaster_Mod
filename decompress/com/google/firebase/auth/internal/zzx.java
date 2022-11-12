// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.firebase.auth.FirebaseUserMetadata;
import java.util.Iterator;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.ArrayList;
import java.util.Map;
import com.google.firebase.auth.UserInfo;
import android.net.Uri;
import com.google.firebase.auth.MultiFactor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.zze;
import java.util.List;
import com.google.android.gms.internal.firebase-auth-api.zzwq;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUser;

@Class
public final class zzx extends FirebaseUser
{
    public static final Parcelable$Creator<zzx> CREATOR;
    @Field
    private zzwq a;
    @Field
    private zzt b;
    @Field
    private final String c;
    @Field
    private String d;
    @Field
    private List e;
    @Field
    private List f;
    @Field
    private String g;
    @Field
    private Boolean h;
    @Field
    private zzz i;
    @Field
    private boolean j;
    @Field
    private zze p;
    @Field
    private zzbb w;
    
    static {
        CREATOR = (Parcelable$Creator)new zzy();
    }
    
    @Constructor
    zzx(@Param final zzwq a, @Param final zzt b, @Param final String c, @Param final String d, @Param final List e, @Param final List f, @Param final String g, @Param final Boolean h, @Param final zzz i, @Param final boolean j, @Param final zze p12, @Param final zzbb w) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p12;
        this.w = w;
    }
    
    public zzx(final FirebaseApp firebaseApp, final List list) {
        Preconditions.k(firebaseApp);
        this.c = firebaseApp.o();
        this.d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.g = "2";
        this.a2(list);
    }
    
    @Override
    public final String L1() {
        return this.b.K1();
    }
    
    @Override
    public final String M1() {
        return this.b.L1();
    }
    
    @Override
    public final MultiFactor N1() {
        return new zzac(this);
    }
    
    @Override
    public final String O1() {
        return this.b.M1();
    }
    
    @Override
    public final Uri P1() {
        return this.b.N1();
    }
    
    @Override
    public final List<? extends UserInfo> Q1() {
        return this.e;
    }
    
    @Override
    public final String R1() {
        final zzwq a = this.a;
        if (a != null && ((com.google.android.gms.internal.firebase_auth_api.zzwq)a).zze() != null) {
            final Map map = zzay.a(((com.google.android.gms.internal.firebase_auth_api.zzwq)a).zze()).a().get("firebase");
            if (map != null) {
                return (String)map.get("tenant");
            }
        }
        return null;
    }
    
    @Override
    public final String S1() {
        return this.b.O1();
    }
    
    @Override
    public final boolean T1() {
        final Boolean h = this.h;
        if (h == null || h) {
            final zzwq a = this.a;
            String b;
            if (a != null) {
                b = zzay.a(((com.google.android.gms.internal.firebase_auth_api.zzwq)a).zze()).b();
            }
            else {
                b = "";
            }
            final int size = this.e.size();
            boolean b2 = false;
            Label_0088: {
                if (size <= 1) {
                    if (b != null) {
                        b2 = b2;
                        if (b.equals("custom")) {
                            break Label_0088;
                        }
                    }
                    b2 = true;
                }
            }
            this.h = b2;
        }
        return this.h;
    }
    
    @Override
    public final FirebaseApp Y1() {
        return FirebaseApp.n(this.c);
    }
    
    @Override
    public final /* bridge */ FirebaseUser Z1() {
        this.h2();
        return this;
    }
    
    @Override
    public final FirebaseUser a2(final List list) {
        synchronized (this) {
            Preconditions.k(list);
            this.e = new ArrayList(list.size());
            this.f = new ArrayList(list.size());
            for (int i = 0; i < list.size(); ++i) {
                final UserInfo userInfo = list.get(i);
                if (userInfo.e().equals("firebase")) {
                    this.b = (zzt)userInfo;
                }
                else {
                    this.f.add(userInfo.e());
                }
                this.e.add(userInfo);
            }
            if (this.b == null) {
                this.b = this.e.get(0);
            }
            return this;
        }
    }
    
    @Override
    public final zzwq b2() {
        return this.a;
    }
    
    @Override
    public final void c2(final zzwq zzwq) {
        this.a = (zzwq)Preconditions.k((com.google.android.gms.internal.firebase_auth_api.zzwq)zzwq);
    }
    
    @Override
    public final void d2(final List list) {
        final Parcelable$Creator<zzbb> creator = zzbb.CREATOR;
        zzbb w = null;
        if (list != null) {
            if (list.isEmpty()) {
                w = w;
            }
            else {
                final ArrayList list2 = new ArrayList();
                for (final MultiFactorInfo multiFactorInfo : list) {
                    if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                        list2.add(multiFactorInfo);
                    }
                }
                w = new zzbb(list2);
            }
        }
        this.w = w;
    }
    
    @Override
    public final String e() {
        return this.b.e();
    }
    
    public final FirebaseUserMetadata e2() {
        return this.i;
    }
    
    public final zze f2() {
        return this.p;
    }
    
    public final zzx g2(final String g) {
        this.g = g;
        return this;
    }
    
    public final zzx h2() {
        this.h = Boolean.FALSE;
        return this;
    }
    
    public final List i2() {
        final zzbb w = this.w;
        List k1;
        if (w != null) {
            k1 = w.K1();
        }
        else {
            k1 = new ArrayList();
        }
        return k1;
    }
    
    public final List j2() {
        return this.e;
    }
    
    public final void k2(final zze p) {
        this.p = p;
    }
    
    public final void l2(final boolean j) {
        this.j = j;
    }
    
    public final void m2(final zzz i) {
        this.i = i;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.a, n, false);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.b, n, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.B(parcel, 4, this.d, false);
        SafeParcelWriter.F(parcel, 5, (List<Parcelable>)this.e, false);
        SafeParcelWriter.D(parcel, 6, this.f, false);
        SafeParcelWriter.B(parcel, 7, this.g, false);
        SafeParcelWriter.i(parcel, 8, this.T1(), false);
        SafeParcelWriter.A(parcel, 9, (Parcelable)this.i, n, false);
        SafeParcelWriter.g(parcel, 10, this.j);
        SafeParcelWriter.A(parcel, 11, (Parcelable)this.p, n, false);
        SafeParcelWriter.A(parcel, 12, (Parcelable)this.w, n, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    @Override
    public final String zze() {
        return ((com.google.android.gms.internal.firebase_auth_api.zzwq)this.a).zze();
    }
    
    @Override
    public final String zzf() {
        return ((com.google.android.gms.internal.firebase_auth_api.zzwq)this.a).zzh();
    }
    
    @Override
    public final List zzg() {
        return this.f;
    }
    
    public final boolean zzs() {
        return this.j;
    }
}
