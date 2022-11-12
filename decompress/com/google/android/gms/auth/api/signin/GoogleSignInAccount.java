// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.accounts.Account;
import java.util.Comparator;
import java.util.Arrays;
import com.google.android.gms.common.annotation.KeepForSdk;
import org.json.JSONException;
import org.json.JSONArray;
import com.google.android.gms.common.api.Scope;
import org.json.JSONObject;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashSet;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Set;
import java.util.List;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<GoogleSignInAccount> CREATOR;
    @VisibleForTesting
    public static Clock y;
    @VersionField
    final int a;
    @Field
    private String b;
    @Field
    private String c;
    @Field
    private String d;
    @Field
    private String e;
    @Field
    private Uri f;
    @Field
    private String g;
    @Field
    private long h;
    @Field
    private String i;
    @Field
    List j;
    @Field
    private String p;
    @Field
    private String w;
    private Set x;
    
    static {
        CREATOR = (Parcelable$Creator)new zab();
        GoogleSignInAccount.y = DefaultClock.d();
    }
    
    @Constructor
    GoogleSignInAccount(@Param final int a, @Param final String b, @Param final String c, @Param final String d, @Param final String e, @Param final Uri f, @Param final String g, @Param final long h, @Param final String i, @Param final List j, @Param final String p12, @Param final String w) {
        this.x = new HashSet();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p12;
        this.w = w;
    }
    
    public static GoogleSignInAccount U1(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final Uri uri, final Long n, final String s7, final Set set) {
        return new GoogleSignInAccount(3, s, s2, s3, s4, uri, null, n, Preconditions.g(s7), new ArrayList(Preconditions.k(set)), s5, s6);
    }
    
    public static GoogleSignInAccount V1(String g) throws JSONException {
        final boolean empty = TextUtils.isEmpty((CharSequence)g);
        final String s = null;
        if (empty) {
            return null;
        }
        final JSONObject jsonObject = new JSONObject(g);
        g = jsonObject.optString("photoUrl");
        Uri parse;
        if (!TextUtils.isEmpty((CharSequence)g)) {
            parse = Uri.parse(g);
        }
        else {
            parse = null;
        }
        final long long1 = Long.parseLong(jsonObject.getString("expirationTime"));
        final HashSet set = new HashSet();
        final JSONArray jsonArray = jsonObject.getJSONArray("grantedScopes");
        for (int length = jsonArray.length(), i = 0; i < length; ++i) {
            set.add(new Scope(jsonArray.getString(i)));
        }
        final String optString = jsonObject.optString("id");
        String optString2;
        if (jsonObject.has("tokenId")) {
            optString2 = jsonObject.optString("tokenId");
        }
        else {
            optString2 = null;
        }
        String optString3;
        if (jsonObject.has("email")) {
            optString3 = jsonObject.optString("email");
        }
        else {
            optString3 = null;
        }
        String optString4;
        if (jsonObject.has("displayName")) {
            optString4 = jsonObject.optString("displayName");
        }
        else {
            optString4 = null;
        }
        String optString5;
        if (jsonObject.has("givenName")) {
            optString5 = jsonObject.optString("givenName");
        }
        else {
            optString5 = null;
        }
        String optString6;
        if (jsonObject.has("familyName")) {
            optString6 = jsonObject.optString("familyName");
        }
        else {
            optString6 = null;
        }
        final GoogleSignInAccount u1 = U1(optString, optString2, optString3, optString4, optString5, optString6, parse, long1, jsonObject.getString("obfuscatedIdentifier"), set);
        g = s;
        if (jsonObject.has("serverAuthCode")) {
            g = jsonObject.optString("serverAuthCode");
        }
        u1.g = g;
        return u1;
    }
    
    public String K1() {
        return this.e;
    }
    
    public String L1() {
        return this.d;
    }
    
    public String M1() {
        return this.w;
    }
    
    public String N1() {
        return this.p;
    }
    
    public String O1() {
        return this.b;
    }
    
    public String P1() {
        return this.c;
    }
    
    public Uri Q1() {
        return this.f;
    }
    
    @KeepForSdk
    public Set<Scope> R1() {
        final HashSet set = new HashSet(this.j);
        set.addAll(this.x);
        return set;
    }
    
    public String S1() {
        return this.g;
    }
    
    @KeepForSdk
    public boolean T1() {
        return GoogleSignInAccount.y.a() / 1000L >= this.h - 300L;
    }
    
    public final String W1() {
        return this.i;
    }
    
    public final String X1() {
        final JSONObject jsonObject = new JSONObject();
        try {
            if (this.O1() != null) {
                jsonObject.put("id", (Object)this.O1());
            }
            if (this.P1() != null) {
                jsonObject.put("tokenId", (Object)this.P1());
            }
            if (this.L1() != null) {
                jsonObject.put("email", (Object)this.L1());
            }
            if (this.K1() != null) {
                jsonObject.put("displayName", (Object)this.K1());
            }
            if (this.N1() != null) {
                jsonObject.put("givenName", (Object)this.N1());
            }
            if (this.M1() != null) {
                jsonObject.put("familyName", (Object)this.M1());
            }
            final Uri q1 = this.Q1();
            if (q1 != null) {
                jsonObject.put("photoUrl", (Object)q1.toString());
            }
            if (this.S1() != null) {
                jsonObject.put("serverAuthCode", (Object)this.S1());
            }
            jsonObject.put("expirationTime", this.h);
            jsonObject.put("obfuscatedIdentifier", (Object)this.i);
            final JSONArray jsonArray = new JSONArray();
            final List j = this.j;
            final Scope[] array = j.toArray(new Scope[j.size()]);
            Arrays.sort(array, zaa.a);
            for (int length = array.length, i = 0; i < length; ++i) {
                jsonArray.put((Object)array[i].K1());
            }
            jsonObject.put("grantedScopes", (Object)jsonArray);
            jsonObject.remove("serverAuthCode");
            return jsonObject.toString();
        }
        catch (final JSONException ex) {
            throw new RuntimeException((Throwable)ex);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof GoogleSignInAccount)) {
            return false;
        }
        final GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount)o;
        return googleSignInAccount.i.equals(this.i) && googleSignInAccount.R1().equals(this.R1());
    }
    
    @Override
    public int hashCode() {
        return (this.i.hashCode() + 527) * 31 + this.R1().hashCode();
    }
    
    public Account k1() {
        final String d = this.d;
        if (d == null) {
            return null;
        }
        return new Account(d, "com.google");
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.O1(), false);
        SafeParcelWriter.B(parcel, 3, this.P1(), false);
        SafeParcelWriter.B(parcel, 4, this.L1(), false);
        SafeParcelWriter.B(parcel, 5, this.K1(), false);
        SafeParcelWriter.A(parcel, 6, (Parcelable)this.Q1(), n, false);
        SafeParcelWriter.B(parcel, 7, this.S1(), false);
        SafeParcelWriter.v(parcel, 8, this.h);
        SafeParcelWriter.B(parcel, 9, this.i, false);
        SafeParcelWriter.F(parcel, 10, (List<Parcelable>)this.j, false);
        SafeParcelWriter.B(parcel, 11, this.N1(), false);
        SafeParcelWriter.B(parcel, 12, this.M1(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
