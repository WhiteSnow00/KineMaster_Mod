// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class ActionCodeSettings extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ActionCodeSettings> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    @Field
    private final String c;
    @Field
    private final String d;
    @Field
    private final boolean e;
    @Field
    private final String f;
    @Field
    private final boolean g;
    @Field
    private String h;
    @Field
    private int i;
    @Field
    private String j;
    
    static {
        CREATOR = (Parcelable$Creator)new zzc();
    }
    
    private ActionCodeSettings(final Builder builder) {
        this.a = Builder.j(builder);
        this.b = Builder.i(builder);
        this.c = null;
        this.d = Builder.g(builder);
        this.e = Builder.k(builder);
        this.f = Builder.f(builder);
        this.g = Builder.l(builder);
        this.j = Builder.h(builder);
    }
    
    ActionCodeSettings(final Builder builder, final zzb zzb) {
        this(builder);
    }
    
    @Constructor
    ActionCodeSettings(@Param final String a, @Param final String b, @Param final String c, @Param final String d, @Param final boolean e, @Param final String f, @Param final boolean g, @Param final String h, @Param final int i, @Param final String j) {
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
    }
    
    public static Builder Q1() {
        return new Builder(null);
    }
    
    public static ActionCodeSettings S1() {
        return new ActionCodeSettings(new Builder(null));
    }
    
    public boolean K1() {
        return this.g;
    }
    
    public boolean L1() {
        return this.e;
    }
    
    public String M1() {
        return this.f;
    }
    
    public String N1() {
        return this.d;
    }
    
    public String O1() {
        return this.b;
    }
    
    public String P1() {
        return this.a;
    }
    
    public final int R1() {
        return this.i;
    }
    
    public final void T1(final String h) {
        this.h = h;
    }
    
    public final void U1(final int i) {
        this.i = i;
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.P1(), false);
        SafeParcelWriter.B(parcel, 2, this.O1(), false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.B(parcel, 4, this.N1(), false);
        SafeParcelWriter.g(parcel, 5, this.L1());
        SafeParcelWriter.B(parcel, 6, this.M1(), false);
        SafeParcelWriter.g(parcel, 7, this.K1());
        SafeParcelWriter.B(parcel, 8, this.h, false);
        SafeParcelWriter.s(parcel, 9, this.i);
        SafeParcelWriter.B(parcel, 10, this.j, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zzc() {
        return this.j;
    }
    
    public final String zzd() {
        return this.c;
    }
    
    public final String zze() {
        return this.h;
    }
    
    public static class Builder
    {
        private String a;
        private String b;
        private String c;
        private boolean d;
        private String e;
        private boolean f;
        private String g;
        
        private Builder() {
            this.f = false;
        }
        
        Builder(final zza zza) {
            this.f = false;
        }
        
        static /* bridge */ String f(final Builder builder) {
            return builder.e;
        }
        
        static /* bridge */ String g(final Builder builder) {
            return builder.c;
        }
        
        static /* bridge */ String h(final Builder builder) {
            return builder.g;
        }
        
        static /* bridge */ String i(final Builder builder) {
            return builder.b;
        }
        
        static /* bridge */ String j(final Builder builder) {
            return builder.a;
        }
        
        static /* bridge */ boolean k(final Builder builder) {
            return builder.d;
        }
        
        static /* bridge */ boolean l(final Builder builder) {
            return builder.f;
        }
        
        public ActionCodeSettings a() {
            if (this.a != null) {
                return new ActionCodeSettings(this, null);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }
        
        public Builder b(final String c, final boolean d, final String e) {
            this.c = c;
            this.d = d;
            this.e = e;
            return this;
        }
        
        public Builder c(final boolean f) {
            this.f = f;
            return this;
        }
        
        public Builder d(final String b) {
            this.b = b;
            return this;
        }
        
        public Builder e(final String a) {
            this.a = a;
            return this;
        }
    }
}
