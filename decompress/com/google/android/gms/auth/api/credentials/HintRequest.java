// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@Class
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<HintRequest> CREATOR;
    @Field
    final int a;
    @Field
    private final CredentialPickerConfig b;
    @Field
    private final boolean c;
    @Field
    private final boolean d;
    @Field
    private final String[] e;
    @Field
    private final boolean f;
    @Field
    private final String g;
    @Field
    private final String h;
    
    static {
        CREATOR = (Parcelable$Creator)new zbe();
    }
    
    @Constructor
    HintRequest(@Param final int a, @Param final CredentialPickerConfig credentialPickerConfig, @Param final boolean c, @Param final boolean d, @Param final String[] array, @Param final boolean f, @Param final String g, @Param final String h) {
        this.a = a;
        this.b = Preconditions.k(credentialPickerConfig);
        this.c = c;
        this.d = d;
        this.e = Preconditions.k(array);
        if (a < 2) {
            this.f = true;
            this.g = null;
            this.h = null;
            return;
        }
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public String[] K1() {
        return this.e;
    }
    
    public CredentialPickerConfig L1() {
        return this.b;
    }
    
    public String M1() {
        return this.h;
    }
    
    public String N1() {
        return this.g;
    }
    
    public boolean O1() {
        return this.c;
    }
    
    public boolean P1() {
        return this.f;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.L1(), n, false);
        SafeParcelWriter.g(parcel, 2, this.O1());
        SafeParcelWriter.g(parcel, 3, this.d);
        SafeParcelWriter.C(parcel, 4, this.K1(), false);
        SafeParcelWriter.g(parcel, 5, this.P1());
        SafeParcelWriter.B(parcel, 6, this.N1(), false);
        SafeParcelWriter.B(parcel, 7, this.M1(), false);
        SafeParcelWriter.s(parcel, 1000, this.a);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private boolean a;
        private boolean b;
        private String[] c;
        private CredentialPickerConfig d;
        private boolean e;
        private String f;
        private String g;
        
        public Builder() {
            this.d = new CredentialPickerConfig.Builder().a();
            this.e = false;
        }
        
        public HintRequest a() {
            if (this.c == null) {
                this.c = new String[0];
            }
            if (!this.a && !this.b && this.c.length == 0) {
                throw new IllegalStateException("At least one authentication method must be specified");
            }
            return new HintRequest(2, this.d, this.a, this.b, this.c, this.e, this.f, this.g);
        }
        
        public Builder b(final boolean a) {
            this.a = a;
            return this;
        }
        
        public Builder c(final boolean b) {
            this.b = b;
            return this;
        }
    }
}
