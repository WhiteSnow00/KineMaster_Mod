// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@Class
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<CredentialPickerConfig> CREATOR;
    @Field
    final int a;
    @Field
    private final boolean b;
    @Field
    private final boolean c;
    @Field
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new zbb();
    }
    
    @Constructor
    CredentialPickerConfig(@Param int n, @Param final boolean b, @Param final boolean c, @Param final boolean b2, @Param final int d) {
        this.a = n;
        this.b = b;
        this.c = c;
        if (n < 2) {
            n = 1;
            if (b2) {
                n = 3;
            }
            this.d = n;
            return;
        }
        this.d = d;
    }
    
    @Deprecated
    public boolean K1() {
        return this.d == 3;
    }
    
    public boolean L1() {
        return this.b;
    }
    
    public boolean M1() {
        return this.c;
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.L1());
        SafeParcelWriter.g(parcel, 2, this.M1());
        SafeParcelWriter.g(parcel, 3, this.K1());
        SafeParcelWriter.s(parcel, 4, this.d);
        SafeParcelWriter.s(parcel, 1000, this.a);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static class Builder
    {
        private boolean a;
        private boolean b;
        private int c;
        
        public Builder() {
            this.a = false;
            this.b = true;
            this.c = 1;
        }
        
        public CredentialPickerConfig a() {
            return new CredentialPickerConfig(2, this.a, this.b, false, this.c);
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
    }
}
