// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class BeginSignInRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<BeginSignInRequest> CREATOR;
    @Field
    private final PasswordRequestOptions a;
    @Field
    private final GoogleIdTokenRequestOptions b;
    @Field
    private final String c;
    @Field
    private final boolean d;
    @Field
    private final int e;
    
    static {
        CREATOR = (Parcelable$Creator)new zba();
    }
    
    @Constructor
    BeginSignInRequest(@Param final PasswordRequestOptions passwordRequestOptions, @Param final GoogleIdTokenRequestOptions googleIdTokenRequestOptions, @Param final String c, @Param final boolean d, @Param final int e) {
        this.a = Preconditions.k(passwordRequestOptions);
        this.b = Preconditions.k(googleIdTokenRequestOptions);
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static Builder K1() {
        return new Builder();
    }
    
    public static Builder O1(final BeginSignInRequest beginSignInRequest) {
        Preconditions.k(beginSignInRequest);
        final Builder k1 = K1();
        k1.c(beginSignInRequest.L1());
        k1.d(beginSignInRequest.M1());
        k1.b(beginSignInRequest.d);
        k1.f(beginSignInRequest.e);
        final String c = beginSignInRequest.c;
        if (c != null) {
            k1.e(c);
        }
        return k1;
    }
    
    public GoogleIdTokenRequestOptions L1() {
        return this.b;
    }
    
    public PasswordRequestOptions M1() {
        return this.a;
    }
    
    public boolean N1() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof BeginSignInRequest)) {
            return false;
        }
        final BeginSignInRequest beginSignInRequest = (BeginSignInRequest)o;
        return Objects.b(this.a, beginSignInRequest.a) && Objects.b(this.b, beginSignInRequest.b) && Objects.b(this.c, beginSignInRequest.c) && this.d == beginSignInRequest.d && this.e == beginSignInRequest.e;
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.M1(), n, false);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.L1(), n, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.g(parcel, 4, this.N1());
        SafeParcelWriter.s(parcel, 5, this.e);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private PasswordRequestOptions a;
        private GoogleIdTokenRequestOptions b;
        private String c;
        private boolean d;
        private int e;
        
        public Builder() {
            final PasswordRequestOptions.Builder k1 = PasswordRequestOptions.K1();
            k1.b(false);
            this.a = k1.a();
            final GoogleIdTokenRequestOptions.Builder k2 = GoogleIdTokenRequestOptions.K1();
            k2.b(false);
            this.b = k2.a();
        }
        
        public BeginSignInRequest a() {
            return new BeginSignInRequest(this.a, this.b, this.c, this.d, this.e);
        }
        
        public Builder b(final boolean d) {
            this.d = d;
            return this;
        }
        
        public Builder c(final GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.b = Preconditions.k(googleIdTokenRequestOptions);
            return this;
        }
        
        public Builder d(final PasswordRequestOptions passwordRequestOptions) {
            this.a = Preconditions.k(passwordRequestOptions);
            return this;
        }
        
        public final Builder e(final String c) {
            this.c = c;
            return this;
        }
        
        public final Builder f(final int e) {
            this.e = e;
            return this;
        }
    }
    
    @Class
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable
    {
        public static final Parcelable$Creator<GoogleIdTokenRequestOptions> CREATOR;
        @Field
        private final boolean a;
        @Field
        private final String b;
        @Field
        private final String c;
        @Field
        private final boolean d;
        @Field
        private final String e;
        @Field
        private final List f;
        @Field
        private final boolean g;
        
        static {
            CREATOR = (Parcelable$Creator)new zbg();
        }
        
        @Constructor
        GoogleIdTokenRequestOptions(@Param final boolean a, @Param final String b, @Param final String c, @Param final boolean d, @Param final String e, @Param final List list, @Param final boolean g) {
            boolean b2 = true;
            if (d) {
                b2 = (!g && b2);
            }
            Preconditions.b(b2, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.a = a;
            if (a) {
                Preconditions.l(b, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.b = b;
            this.c = c;
            this.d = d;
            final Parcelable$Creator<BeginSignInRequest> creator = BeginSignInRequest.CREATOR;
            List<Comparable> f;
            final List<Comparable> list2 = f = null;
            if (list != null) {
                if (list.isEmpty()) {
                    f = list2;
                }
                else {
                    f = new ArrayList<Comparable>(list);
                    Collections.sort(f);
                }
            }
            this.f = f;
            this.e = e;
            this.g = g;
        }
        
        public static Builder K1() {
            return new Builder();
        }
        
        public boolean L1() {
            return this.d;
        }
        
        public List<String> M1() {
            return this.f;
        }
        
        public String N1() {
            return this.e;
        }
        
        public String O1() {
            return this.c;
        }
        
        public String P1() {
            return this.b;
        }
        
        public boolean Q1() {
            return this.a;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (!(o instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            final GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions)o;
            return this.a == googleIdTokenRequestOptions.a && Objects.b(this.b, googleIdTokenRequestOptions.b) && Objects.b(this.c, googleIdTokenRequestOptions.c) && this.d == googleIdTokenRequestOptions.d && Objects.b(this.e, googleIdTokenRequestOptions.e) && Objects.b(this.f, googleIdTokenRequestOptions.f) && this.g == googleIdTokenRequestOptions.g;
        }
        
        @Override
        public int hashCode() {
            return Objects.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
        
        public void writeToParcel(final Parcel parcel, int a) {
            a = SafeParcelWriter.a(parcel);
            SafeParcelWriter.g(parcel, 1, this.Q1());
            SafeParcelWriter.B(parcel, 2, this.P1(), false);
            SafeParcelWriter.B(parcel, 3, this.O1(), false);
            SafeParcelWriter.g(parcel, 4, this.L1());
            SafeParcelWriter.B(parcel, 5, this.N1(), false);
            SafeParcelWriter.D(parcel, 6, this.M1(), false);
            SafeParcelWriter.g(parcel, 7, this.g);
            SafeParcelWriter.b(parcel, a);
        }
        
        public static final class Builder
        {
            private boolean a;
            private String b;
            private String c;
            private boolean d;
            private String e;
            private List f;
            
            public Builder() {
                this.a = false;
                this.b = null;
                this.c = null;
                this.d = true;
                this.e = null;
                this.f = null;
            }
            
            public GoogleIdTokenRequestOptions a() {
                return new GoogleIdTokenRequestOptions(this.a, this.b, this.c, this.d, this.e, this.f, false);
            }
            
            public Builder b(final boolean a) {
                this.a = a;
                return this;
            }
        }
    }
    
    @Class
    public static final class PasswordRequestOptions extends AbstractSafeParcelable
    {
        public static final Parcelable$Creator<PasswordRequestOptions> CREATOR;
        @Field
        private final boolean a;
        
        static {
            CREATOR = (Parcelable$Creator)new zbh();
        }
        
        @Constructor
        PasswordRequestOptions(@Param final boolean a) {
            this.a = a;
        }
        
        public static Builder K1() {
            return new Builder();
        }
        
        public boolean L1() {
            return this.a;
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof PasswordRequestOptions && this.a == ((PasswordRequestOptions)o).a;
        }
        
        @Override
        public int hashCode() {
            return Objects.c(this.a);
        }
        
        public void writeToParcel(final Parcel parcel, int a) {
            a = SafeParcelWriter.a(parcel);
            SafeParcelWriter.g(parcel, 1, this.L1());
            SafeParcelWriter.b(parcel, a);
        }
        
        public static final class Builder
        {
            private boolean a;
            
            public Builder() {
                this.a = false;
            }
            
            public PasswordRequestOptions a() {
                return new PasswordRequestOptions(this.a);
            }
            
            public Builder b(final boolean a) {
                this.a = a;
                return this;
            }
        }
    }
}
