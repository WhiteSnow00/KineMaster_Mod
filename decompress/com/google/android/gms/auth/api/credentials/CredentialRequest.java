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
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@Class
public final class CredentialRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<CredentialRequest> CREATOR;
    @Field
    final int a;
    @Field
    private final boolean b;
    @Field
    private final String[] c;
    @Field
    private final CredentialPickerConfig d;
    @Field
    private final CredentialPickerConfig e;
    @Field
    private final boolean f;
    @Field
    private final String g;
    @Field
    private final String h;
    @Field
    private final boolean i;
    
    static {
        CREATOR = (Parcelable$Creator)new zbc();
    }
    
    @Constructor
    CredentialRequest(@Param final int a, @Param final boolean b, @Param final String[] array, @Param final CredentialPickerConfig credentialPickerConfig, @Param final CredentialPickerConfig credentialPickerConfig2, @Param final boolean f, @Param final String g, @Param final String h, @Param final boolean i) {
        this.a = a;
        this.b = b;
        this.c = Preconditions.k(array);
        CredentialPickerConfig a2 = credentialPickerConfig;
        if (credentialPickerConfig == null) {
            a2 = new CredentialPickerConfig.Builder().a();
        }
        this.d = a2;
        CredentialPickerConfig a3;
        if ((a3 = credentialPickerConfig2) == null) {
            a3 = new CredentialPickerConfig.Builder().a();
        }
        this.e = a3;
        if (a < 3) {
            this.f = true;
            this.g = null;
            this.h = null;
        }
        else {
            this.f = f;
            this.g = g;
            this.h = h;
        }
        this.i = i;
    }
    
    public String[] K1() {
        return this.c;
    }
    
    public CredentialPickerConfig L1() {
        return this.e;
    }
    
    public CredentialPickerConfig M1() {
        return this.d;
    }
    
    public String N1() {
        return this.h;
    }
    
    public String O1() {
        return this.g;
    }
    
    public boolean P1() {
        return this.f;
    }
    
    public boolean Q1() {
        return this.b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.Q1());
        SafeParcelWriter.C(parcel, 2, this.K1(), false);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.M1(), n, false);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.L1(), n, false);
        SafeParcelWriter.g(parcel, 5, this.P1());
        SafeParcelWriter.B(parcel, 6, this.O1(), false);
        SafeParcelWriter.B(parcel, 7, this.N1(), false);
        SafeParcelWriter.g(parcel, 8, this.i);
        SafeParcelWriter.s(parcel, 1000, this.a);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private boolean a;
        private String[] b;
        private CredentialPickerConfig c;
        private CredentialPickerConfig d;
        private boolean e;
        private String f;
        private String g;
        
        public Builder() {
            this.e = false;
            this.f = null;
        }
        
        public CredentialRequest a() {
            if (this.b == null) {
                this.b = new String[0];
            }
            if (!this.a && this.b.length == 0) {
                throw new IllegalStateException("At least one authentication method must be specified");
            }
            return new CredentialRequest(4, this.a, this.b, this.c, this.d, this.e, this.f, this.g, false);
        }
        
        public Builder b(final String... array) {
            String[] b = array;
            if (array == null) {
                b = new String[0];
            }
            this.b = b;
            return this;
        }
        
        public Builder c(final boolean a) {
            this.a = a;
            return this;
        }
    }
}
