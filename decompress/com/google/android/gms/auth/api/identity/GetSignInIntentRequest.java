// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class GetSignInIntentRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<GetSignInIntentRequest> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    @Field
    private String c;
    @Field
    private final String d;
    @Field
    private final boolean e;
    @Field
    private final int f;
    
    static {
        CREATOR = (Parcelable$Creator)new zbf();
    }
    
    @Constructor
    GetSignInIntentRequest(@Param final String a, @Param final String b, @Param final String c, @Param final String d, @Param final boolean e, @Param final int f) {
        Preconditions.k(a);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public static Builder K1() {
        return new Builder();
    }
    
    public static Builder O1(final GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.k(getSignInIntentRequest);
        final Builder k1 = K1();
        k1.d(getSignInIntentRequest.N1());
        k1.c(getSignInIntentRequest.M1());
        k1.b(getSignInIntentRequest.L1());
        k1.e(getSignInIntentRequest.e);
        k1.g(getSignInIntentRequest.f);
        final String c = getSignInIntentRequest.c;
        if (c != null) {
            k1.f(c);
        }
        return k1;
    }
    
    public String L1() {
        return this.b;
    }
    
    public String M1() {
        return this.d;
    }
    
    public String N1() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof GetSignInIntentRequest)) {
            return false;
        }
        final GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest)o;
        return Objects.b(this.a, getSignInIntentRequest.a) && Objects.b(this.d, getSignInIntentRequest.d) && Objects.b(this.b, getSignInIntentRequest.b) && Objects.b(this.e, getSignInIntentRequest.e) && this.f == getSignInIntentRequest.f;
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b, this.d, this.e, this.f);
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.N1(), false);
        SafeParcelWriter.B(parcel, 2, this.L1(), false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.B(parcel, 4, this.M1(), false);
        SafeParcelWriter.g(parcel, 5, this.e);
        SafeParcelWriter.s(parcel, 6, this.f);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private int f;
        
        public GetSignInIntentRequest a() {
            return new GetSignInIntentRequest(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        
        public Builder b(final String b) {
            this.b = b;
            return this;
        }
        
        public Builder c(final String d) {
            this.d = d;
            return this;
        }
        
        public Builder d(final String a) {
            Preconditions.k(a);
            this.a = a;
            return this;
        }
        
        public final Builder e(final boolean e) {
            this.e = e;
            return this;
        }
        
        public final Builder f(final String c) {
            this.c = c;
            return this;
        }
        
        public final Builder g(final int f) {
            this.f = f;
            return this;
        }
    }
}
