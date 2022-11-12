// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import java.util.Collection;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<SaveAccountLinkingTokenRequest> CREATOR;
    @Field
    private final PendingIntent a;
    @Field
    private final String b;
    @Field
    private final String c;
    @Field
    private final List d;
    @Field
    private final String e;
    @Field
    private final int f;
    
    static {
        CREATOR = (Parcelable$Creator)new zbi();
    }
    
    @Constructor
    SaveAccountLinkingTokenRequest(@Param final PendingIntent a, @Param final String b, @Param final String c, @Param final List d, @Param final String e, @Param final int f) {
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
    
    public static Builder P1(final SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Preconditions.k(saveAccountLinkingTokenRequest);
        final Builder k1 = K1();
        k1.c(saveAccountLinkingTokenRequest.M1());
        k1.d(saveAccountLinkingTokenRequest.N1());
        k1.b(saveAccountLinkingTokenRequest.L1());
        k1.e(saveAccountLinkingTokenRequest.O1());
        k1.g(saveAccountLinkingTokenRequest.f);
        final String e = saveAccountLinkingTokenRequest.e;
        if (!TextUtils.isEmpty((CharSequence)e)) {
            k1.f(e);
        }
        return k1;
    }
    
    public PendingIntent L1() {
        return this.a;
    }
    
    public List<String> M1() {
        return this.d;
    }
    
    public String N1() {
        return this.c;
    }
    
    public String O1() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        final SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest)o;
        if (this.d.size() == saveAccountLinkingTokenRequest.d.size()) {
            if (this.d.containsAll(saveAccountLinkingTokenRequest.d)) {
                if (Objects.b(this.a, saveAccountLinkingTokenRequest.a) && Objects.b(this.b, saveAccountLinkingTokenRequest.b) && Objects.b(this.c, saveAccountLinkingTokenRequest.c) && Objects.b(this.e, saveAccountLinkingTokenRequest.e) && this.f == saveAccountLinkingTokenRequest.f) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d, this.e);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.L1(), n, false);
        SafeParcelWriter.B(parcel, 2, this.O1(), false);
        SafeParcelWriter.B(parcel, 3, this.N1(), false);
        SafeParcelWriter.D(parcel, 4, this.M1(), false);
        SafeParcelWriter.B(parcel, 5, this.e, false);
        SafeParcelWriter.s(parcel, 6, this.f);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private PendingIntent a;
        private String b;
        private String c;
        private List d;
        private String e;
        private int f;
        
        public Builder() {
            this.d = new ArrayList();
        }
        
        public SaveAccountLinkingTokenRequest a() {
            final PendingIntent a = this.a;
            final boolean b = false;
            Preconditions.b(a != null, "Consent PendingIntent cannot be null");
            Preconditions.b("auth_code".equals(this.b), "Invalid tokenType");
            Preconditions.b(TextUtils.isEmpty((CharSequence)this.c) ^ true, "serviceId cannot be null or empty");
            boolean b2 = b;
            if (this.d != null) {
                b2 = true;
            }
            Preconditions.b(b2, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        
        public Builder b(final PendingIntent a) {
            this.a = a;
            return this;
        }
        
        public Builder c(final List<String> d) {
            this.d = d;
            return this;
        }
        
        public Builder d(final String c) {
            this.c = c;
            return this;
        }
        
        public Builder e(final String b) {
            this.b = b;
            return this;
        }
        
        public final Builder f(final String e) {
            this.e = e;
            return this;
        }
        
        public final Builder g(final int f) {
            this.f = f;
            return this;
        }
    }
}
