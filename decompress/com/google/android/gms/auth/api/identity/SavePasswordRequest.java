// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class SavePasswordRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<SavePasswordRequest> CREATOR;
    @Field
    private final SignInPassword a;
    @Field
    private final String b;
    @Field
    private final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new zbk();
    }
    
    @Constructor
    SavePasswordRequest(@Param final SignInPassword signInPassword, @Param final String b, @Param final int c) {
        this.a = Preconditions.k(signInPassword);
        this.b = b;
        this.c = c;
    }
    
    public static Builder K1() {
        return new Builder();
    }
    
    public static Builder M1(final SavePasswordRequest savePasswordRequest) {
        Preconditions.k(savePasswordRequest);
        final Builder k1 = K1();
        k1.b(savePasswordRequest.L1());
        k1.d(savePasswordRequest.c);
        final String b = savePasswordRequest.b;
        if (b != null) {
            k1.c(b);
        }
        return k1;
    }
    
    public SignInPassword L1() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof SavePasswordRequest)) {
            return false;
        }
        final SavePasswordRequest savePasswordRequest = (SavePasswordRequest)o;
        return Objects.b(this.a, savePasswordRequest.a) && Objects.b(this.b, savePasswordRequest.b) && this.c == savePasswordRequest.c;
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.L1(), n, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private SignInPassword a;
        private String b;
        private int c;
        
        public SavePasswordRequest a() {
            return new SavePasswordRequest(this.a, this.b, this.c);
        }
        
        public Builder b(final SignInPassword a) {
            this.a = a;
            return this;
        }
        
        public final Builder c(final String b) {
            this.b = b;
            return this;
        }
        
        public final Builder d(final int c) {
            this.c = c;
            return this;
        }
    }
}
