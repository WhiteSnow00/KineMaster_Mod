// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Class
public class EmailAuthCredential extends AuthCredential
{
    public static final Parcelable$Creator<EmailAuthCredential> CREATOR;
    @Field
    private String a;
    @Field
    private String b;
    @Field
    private final String c;
    @Field
    private String d;
    @Field
    private boolean e;
    
    static {
        CREATOR = (Parcelable$Creator)new zzg();
    }
    
    @Constructor
    EmailAuthCredential(@Param final String s, @Param final String b, @Param final String c, @Param final String d, @Param final boolean e) {
        this.a = Preconditions.g(s);
        if (TextUtils.isEmpty((CharSequence)b) && TextUtils.isEmpty((CharSequence)c)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static boolean O1(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return false;
        }
        final ActionCodeUrl c = ActionCodeUrl.c(s);
        return c != null && c.b() == 4;
    }
    
    @Override
    public String K1() {
        return "password";
    }
    
    @Override
    public final AuthCredential L1() {
        return new EmailAuthCredential(this.a, this.b, this.c, this.d, this.e);
    }
    
    public String M1() {
        if (!TextUtils.isEmpty((CharSequence)this.b)) {
            return "password";
        }
        return "emailLink";
    }
    
    public final EmailAuthCredential N1(final FirebaseUser firebaseUser) {
        this.d = firebaseUser.zzf();
        this.e = true;
        return this;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.B(parcel, 4, this.d, false);
        SafeParcelWriter.g(parcel, 5, this.e);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zzc() {
        return this.d;
    }
    
    public final String zzd() {
        return this.a;
    }
    
    public final String zze() {
        return this.b;
    }
    
    public final String zzf() {
        return this.c;
    }
    
    public final boolean zzg() {
        return !TextUtils.isEmpty((CharSequence)this.c);
    }
    
    public final boolean zzh() {
        return this.e;
    }
}
