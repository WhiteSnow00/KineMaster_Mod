// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import android.text.TextUtils;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Class
public class PhoneAuthCredential extends AuthCredential implements Cloneable
{
    public static final Parcelable$Creator<PhoneAuthCredential> CREATOR;
    @Field
    private String a;
    @Field
    private String b;
    @Field
    private boolean c;
    @Field
    private String d;
    @Field
    private boolean e;
    @Field
    private String f;
    @Field
    private String g;
    
    static {
        CREATOR = (Parcelable$Creator)new zzae();
    }
    
    @Constructor
    PhoneAuthCredential(@Param final String a, @Param final String b, @Param final boolean c, @Param final String d, @Param final boolean e, @Param final String f, @Param final String g) {
        final boolean b2 = false;
        boolean b3 = false;
        Label_0097: {
            if ((!c || TextUtils.isEmpty((CharSequence)d) || !TextUtils.isEmpty((CharSequence)g)) && ((!c || !TextUtils.isEmpty((CharSequence)d) || TextUtils.isEmpty((CharSequence)g)) && (TextUtils.isEmpty((CharSequence)a) || TextUtils.isEmpty((CharSequence)b)))) {
                b3 = b2;
                if (TextUtils.isEmpty((CharSequence)d)) {
                    break Label_0097;
                }
                b3 = b2;
                if (TextUtils.isEmpty((CharSequence)f)) {
                    break Label_0097;
                }
            }
            b3 = true;
        }
        Preconditions.b(b3, "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public static PhoneAuthCredential O1(final String s, final String s2) {
        return new PhoneAuthCredential(s, s2, false, null, true, null, null);
    }
    
    public static PhoneAuthCredential P1(final String s, final String s2) {
        return new PhoneAuthCredential(null, null, false, s, true, s2, null);
    }
    
    @Override
    public String K1() {
        return "phone";
    }
    
    @Override
    public final AuthCredential L1() {
        return this.N1();
    }
    
    public String M1() {
        return this.b;
    }
    
    public final PhoneAuthCredential N1() {
        return new PhoneAuthCredential(this.a, this.M1(), this.c, this.d, this.e, this.f, this.g);
    }
    
    public final PhoneAuthCredential Q1(final boolean b) {
        this.e = false;
        return this;
    }
    
    public final /* bridge */ Object clone() throws CloneNotSupportedException {
        return this.N1();
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.M1(), false);
        SafeParcelWriter.g(parcel, 3, this.c);
        SafeParcelWriter.B(parcel, 4, this.d, false);
        SafeParcelWriter.g(parcel, 5, this.e);
        SafeParcelWriter.B(parcel, 6, this.f, false);
        SafeParcelWriter.B(parcel, 7, this.g, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zzf() {
        return this.d;
    }
    
    public final String zzg() {
        return this.a;
    }
    
    public final String zzh() {
        return this.f;
    }
    
    public final boolean zzi() {
        return this.e;
    }
}
