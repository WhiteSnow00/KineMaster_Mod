// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import java.util.Collections;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import android.net.Uri;
import javax.annotation.Nonnull;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@Class
@Reserved
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<Credential> CREATOR;
    @Nonnull
    @Field
    private final String a;
    @Field
    private final String b;
    @Field
    private final Uri c;
    @Nonnull
    @Field
    private final List d;
    @Field
    private final String e;
    @Field
    private final String f;
    @Field
    private final String g;
    @Field
    private final String h;
    
    static {
        CREATOR = (Parcelable$Creator)new zba();
    }
    
    @Constructor
    Credential(@Param String b, @Param final String s, @Param final Uri c, @Param final List list, @Param final String e, @Param final String f, @Param final String g, @Param final String h) {
        final String trim = Preconditions.l(b, "credential identifier cannot be null").trim();
        Preconditions.h(trim, "credential identifier cannot be empty");
        if (e != null && TextUtils.isEmpty((CharSequence)e)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (f != null) {
            Boolean b2;
            if (TextUtils.isEmpty((CharSequence)f)) {
                b2 = Boolean.FALSE;
            }
            else {
                final Uri parse = Uri.parse(f);
                if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty((CharSequence)parse.getScheme()) && !TextUtils.isEmpty((CharSequence)parse.getAuthority())) {
                    final boolean equalsIgnoreCase = "http".equalsIgnoreCase(parse.getScheme());
                    boolean b3 = true;
                    if (!equalsIgnoreCase) {
                        b3 = ("https".equalsIgnoreCase(parse.getScheme()) && b3);
                    }
                    b2 = b3;
                }
                else {
                    b2 = Boolean.FALSE;
                }
            }
            if (!b2) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty((CharSequence)f) && !TextUtils.isEmpty((CharSequence)e)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if ((b = s) != null) {
            b = s;
            if (TextUtils.isEmpty((CharSequence)s.trim())) {
                b = null;
            }
        }
        this.b = b;
        this.c = c;
        List<Object> d;
        if (list == null) {
            d = Collections.emptyList();
        }
        else {
            d = Collections.unmodifiableList((List<?>)list);
        }
        this.d = d;
        this.a = trim;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public String K1() {
        return this.f;
    }
    
    public String L1() {
        return this.h;
    }
    
    public String M1() {
        return this.g;
    }
    
    @Nonnull
    public String N1() {
        return this.a;
    }
    
    @Nonnull
    public List<IdToken> O1() {
        return this.d;
    }
    
    public String P1() {
        return this.b;
    }
    
    public String Q1() {
        return this.e;
    }
    
    public Uri R1() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Credential)) {
            return false;
        }
        final Credential credential = (Credential)o;
        return TextUtils.equals((CharSequence)this.a, (CharSequence)credential.a) && TextUtils.equals((CharSequence)this.b, (CharSequence)credential.b) && Objects.b(this.c, credential.c) && TextUtils.equals((CharSequence)this.e, (CharSequence)credential.e) && TextUtils.equals((CharSequence)this.f, (CharSequence)credential.f);
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.e, this.f);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.N1(), false);
        SafeParcelWriter.B(parcel, 2, this.P1(), false);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.R1(), n, false);
        SafeParcelWriter.F(parcel, 4, this.O1(), false);
        SafeParcelWriter.B(parcel, 5, this.Q1(), false);
        SafeParcelWriter.B(parcel, 6, this.K1(), false);
        SafeParcelWriter.B(parcel, 9, this.M1(), false);
        SafeParcelWriter.B(parcel, 10, this.L1(), false);
        SafeParcelWriter.b(parcel, a);
    }
    
    @Deprecated
    public static class Builder
    {
        private final String a;
        private String b;
        private Uri c;
        private List d;
        private String e;
        private String f;
        private String g;
        private String h;
        
        public Builder(final String a) {
            this.a = a;
        }
        
        public Credential a() {
            return new Credential(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
        
        public Builder b(final String f) {
            this.f = f;
            return this;
        }
        
        public Builder c(final String b) {
            this.b = b;
            return this;
        }
        
        public Builder d(final String e) {
            this.e = e;
            return this;
        }
        
        public Builder e(final Uri c) {
            this.c = c;
            return this;
        }
    }
}
