// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.text.TextUtils;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public class UserProfileChangeRequest extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<UserProfileChangeRequest> CREATOR;
    @Field
    private String a;
    @Field
    private String b;
    @Field
    private boolean c;
    @Field
    private boolean d;
    private Uri e;
    
    static {
        CREATOR = (Parcelable$Creator)new zzaj();
    }
    
    @Constructor
    UserProfileChangeRequest(@Param final String a, @Param final String b, @Param final boolean c, @Param final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        Uri parse;
        if (TextUtils.isEmpty((CharSequence)b)) {
            parse = null;
        }
        else {
            parse = Uri.parse(b);
        }
        this.e = parse;
    }
    
    public String K1() {
        return this.a;
    }
    
    public Uri L1() {
        return this.e;
    }
    
    public final boolean M1() {
        return this.c;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 2, this.K1(), false);
        SafeParcelWriter.B(parcel, 3, this.b, false);
        SafeParcelWriter.g(parcel, 4, this.c);
        SafeParcelWriter.g(parcel, 5, this.d);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zza() {
        return this.b;
    }
    
    public final boolean zzc() {
        return this.d;
    }
    
    public static class Builder
    {
        private String a;
        private Uri b;
        private boolean c;
        private boolean d;
        
        public UserProfileChangeRequest a() {
            final String a = this.a;
            final Uri b = this.b;
            String string;
            if (b == null) {
                string = null;
            }
            else {
                string = b.toString();
            }
            return new UserProfileChangeRequest(a, string, this.c, this.d);
        }
        
        public Builder b(final String a) {
            if (a == null) {
                this.c = true;
            }
            else {
                this.a = a;
            }
            return this;
        }
        
        public Builder c(final Uri b) {
            if (b == null) {
                this.d = true;
            }
            else {
                this.b = b;
            }
            return this;
        }
    }
}
