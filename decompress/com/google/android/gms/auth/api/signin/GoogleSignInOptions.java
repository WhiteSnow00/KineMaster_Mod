// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import java.util.Arrays;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import java.util.Collections;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.HashMap;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONObject;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import android.accounts.Account;
import java.util.ArrayList;
import java.util.Comparator;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class GoogleSignInOptions extends AbstractSafeParcelable implements Optional, ReflectedParcelable
{
    @VisibleForTesting
    public static final Scope A;
    @VisibleForTesting
    public static final Scope B;
    @VisibleForTesting
    public static final Scope C;
    public static final Parcelable$Creator<GoogleSignInOptions> CREATOR;
    private static Comparator D;
    public static final GoogleSignInOptions w;
    public static final GoogleSignInOptions x;
    @VisibleForTesting
    public static final Scope y;
    @VisibleForTesting
    public static final Scope z;
    @VersionField
    final int a;
    @Field
    private final ArrayList b;
    @Field
    private Account c;
    @Field
    private boolean d;
    @Field
    private final boolean e;
    @Field
    private final boolean f;
    @Field
    private String g;
    @Field
    private String h;
    @Field
    private ArrayList i;
    @Field
    private String j;
    private Map p;
    
    static {
        y = new Scope("profile");
        z = new Scope("email");
        A = new Scope("openid");
        final Scope scope = B = new Scope("https://www.googleapis.com/auth/games_lite");
        C = new Scope("https://www.googleapis.com/auth/games");
        final Builder builder = new Builder();
        builder.c();
        builder.e();
        w = builder.a();
        final Builder builder2 = new Builder();
        builder2.f(scope, new Scope[0]);
        x = builder2.a();
        CREATOR = (Parcelable$Creator)new zae();
        GoogleSignInOptions.D = new a();
    }
    
    @Constructor
    GoogleSignInOptions(@Param final int n, @Param final ArrayList list, @Param final Account account, @Param final boolean b, @Param final boolean b2, @Param final boolean b3, @Param final String s, @Param final String s2, @Param final ArrayList list2, @Param final String s3) {
        this(n, list, account, b, b2, b3, s, s2, d2(list2), s3);
    }
    
    private GoogleSignInOptions(final int a, final ArrayList b, final Account c, final boolean d, final boolean e, final boolean f, final String g, final String h, final Map p10, final String j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = new ArrayList(p10.values());
        this.p = p10;
        this.j = j;
    }
    
    GoogleSignInOptions(final int n, final ArrayList list, final Account account, final boolean b, final boolean b2, final boolean b3, final String s, final String s2, final Map map, final String s3, final zad zad) {
        this(3, list, account, b, b2, b3, s, s2, map, s3);
    }
    
    static /* bridge */ Account R1(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.c;
    }
    
    public static GoogleSignInOptions S1(String optString) throws JSONException {
        final boolean empty = TextUtils.isEmpty((CharSequence)optString);
        String optString2 = null;
        if (empty) {
            return null;
        }
        final JSONObject jsonObject = new JSONObject(optString);
        final HashSet set = new HashSet();
        final JSONArray jsonArray = jsonObject.getJSONArray("scopes");
        for (int length = jsonArray.length(), i = 0; i < length; ++i) {
            set.add(new Scope(jsonArray.getString(i)));
        }
        if (jsonObject.has("accountName")) {
            optString = jsonObject.optString("accountName");
        }
        else {
            optString = null;
        }
        Account account;
        if (!TextUtils.isEmpty((CharSequence)optString)) {
            account = new Account(optString, "com.google");
        }
        else {
            account = null;
        }
        final ArrayList list = new ArrayList(set);
        final boolean boolean1 = jsonObject.getBoolean("idTokenRequested");
        final boolean boolean2 = jsonObject.getBoolean("serverAuthRequested");
        final boolean boolean3 = jsonObject.getBoolean("forceCodeForRefreshToken");
        String optString3;
        if (jsonObject.has("serverClientId")) {
            optString3 = jsonObject.optString("serverClientId");
        }
        else {
            optString3 = null;
        }
        if (jsonObject.has("hostedDomain")) {
            optString2 = jsonObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, list, account, boolean1, boolean2, boolean3, optString3, optString2, new HashMap(), null);
    }
    
    static /* bridge */ String T1(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.h;
    }
    
    static /* bridge */ String U1(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.j;
    }
    
    static /* bridge */ String V1(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.g;
    }
    
    static /* bridge */ ArrayList X1(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.i;
    }
    
    static /* bridge */ ArrayList Y1(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.b;
    }
    
    static /* bridge */ Map Z1(final List list) {
        return d2(list);
    }
    
    static /* bridge */ boolean a2(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.f;
    }
    
    static /* bridge */ boolean b2(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.d;
    }
    
    static /* bridge */ boolean c2(final GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.e;
    }
    
    private static Map d2(final List list) {
        final HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (final GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(googleSignInOptionsExtensionParcelable.K1(), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }
    
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> K1() {
        return this.i;
    }
    
    @KeepForSdk
    public String L1() {
        return this.j;
    }
    
    @KeepForSdk
    public ArrayList<Scope> M1() {
        return new ArrayList<Scope>(this.b);
    }
    
    @KeepForSdk
    public String N1() {
        return this.g;
    }
    
    @KeepForSdk
    public boolean O1() {
        return this.f;
    }
    
    @KeepForSdk
    public boolean P1() {
        return this.d;
    }
    
    @KeepForSdk
    public boolean Q1() {
        return this.e;
    }
    
    public final String W1() {
        final JSONObject jsonObject = new JSONObject();
        try {
            final JSONArray jsonArray = new JSONArray();
            Collections.sort((List<Object>)this.b, GoogleSignInOptions.D);
            final Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                jsonArray.put((Object)((Scope)iterator.next()).K1());
            }
            jsonObject.put("scopes", (Object)jsonArray);
            final Account c = this.c;
            if (c != null) {
                jsonObject.put("accountName", (Object)c.name);
            }
            jsonObject.put("idTokenRequested", this.d);
            jsonObject.put("forceCodeForRefreshToken", this.f);
            jsonObject.put("serverAuthRequested", this.e);
            if (!TextUtils.isEmpty((CharSequence)this.g)) {
                jsonObject.put("serverClientId", (Object)this.g);
            }
            if (!TextUtils.isEmpty((CharSequence)this.h)) {
                jsonObject.put("hostedDomain", (Object)this.h);
            }
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
        try {
            final GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions)o;
            if (this.i.size() <= 0) {
                if (googleSignInOptions.i.size() <= 0) {
                    if (this.b.size() == googleSignInOptions.M1().size()) {
                        if (this.b.containsAll(googleSignInOptions.M1())) {
                            final Account c = this.c;
                            if (c == null) {
                                if (googleSignInOptions.k1() != null) {
                                    return false;
                                }
                            }
                            else if (!c.equals((Object)googleSignInOptions.k1())) {
                                return false;
                            }
                            if (TextUtils.isEmpty((CharSequence)this.g)) {
                                if (!TextUtils.isEmpty((CharSequence)googleSignInOptions.N1())) {
                                    return false;
                                }
                            }
                            else if (!this.g.equals(googleSignInOptions.N1())) {
                                return false;
                            }
                            if (this.f == googleSignInOptions.O1() && this.d == googleSignInOptions.P1() && this.e == googleSignInOptions.Q1() && TextUtils.equals((CharSequence)this.j, (CharSequence)googleSignInOptions.L1())) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        catch (final ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        final ArrayList list = new ArrayList();
        final ArrayList b = this.b;
        for (int size = b.size(), i = 0; i < size; ++i) {
            list.add(((Scope)b.get(i)).K1());
        }
        Collections.sort((List<Comparable>)list);
        final HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.a(list);
        hashAccumulator.a(this.c);
        hashAccumulator.a(this.g);
        hashAccumulator.c(this.f);
        hashAccumulator.c(this.d);
        hashAccumulator.c(this.e);
        hashAccumulator.a(this.j);
        return hashAccumulator.b();
    }
    
    @KeepForSdk
    public Account k1() {
        return this.c;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.F(parcel, 2, this.M1(), false);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.k1(), n, false);
        SafeParcelWriter.g(parcel, 4, this.P1());
        SafeParcelWriter.g(parcel, 5, this.Q1());
        SafeParcelWriter.g(parcel, 6, this.O1());
        SafeParcelWriter.B(parcel, 7, this.N1(), false);
        SafeParcelWriter.B(parcel, 8, this.h, false);
        SafeParcelWriter.F(parcel, 9, this.K1(), false);
        SafeParcelWriter.B(parcel, 10, this.L1(), false);
        SafeParcelWriter.b(parcel, a);
    }
    
    public static final class Builder
    {
        private Set a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;
        private String g;
        private Map h;
        private String i;
        
        public Builder() {
            this.a = new HashSet();
            this.h = new HashMap();
        }
        
        public Builder(final GoogleSignInOptions googleSignInOptions) {
            this.a = new HashSet();
            this.h = new HashMap();
            Preconditions.k(googleSignInOptions);
            this.a = new HashSet(GoogleSignInOptions.Y1(googleSignInOptions));
            this.b = GoogleSignInOptions.c2(googleSignInOptions);
            this.c = GoogleSignInOptions.a2(googleSignInOptions);
            this.d = GoogleSignInOptions.b2(googleSignInOptions);
            this.e = GoogleSignInOptions.V1(googleSignInOptions);
            this.f = GoogleSignInOptions.R1(googleSignInOptions);
            this.g = GoogleSignInOptions.T1(googleSignInOptions);
            this.h = GoogleSignInOptions.Z1((List)GoogleSignInOptions.X1(googleSignInOptions));
            this.i = GoogleSignInOptions.U1(googleSignInOptions);
        }
        
        private final String i(final String s) {
            Preconditions.g(s);
            final String e = this.e;
            boolean b = true;
            if (e != null) {
                b = (e.equals(s) && b);
            }
            Preconditions.b(b, "two different server client ids provided");
            return s;
        }
        
        public GoogleSignInOptions a() {
            if (this.a.contains(GoogleSignInOptions.C)) {
                final Set a = this.a;
                final Scope b = GoogleSignInOptions.B;
                if (a.contains(b)) {
                    this.a.remove(b);
                }
            }
            if (this.d && (this.f == null || !this.a.isEmpty())) {
                this.c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f, this.d, this.b, this.c, this.e, this.g, this.h, this.i, null);
        }
        
        @CanIgnoreReturnValue
        public Builder b() {
            this.a.add(GoogleSignInOptions.z);
            return this;
        }
        
        @CanIgnoreReturnValue
        public Builder c() {
            this.a.add(GoogleSignInOptions.A);
            return this;
        }
        
        @CanIgnoreReturnValue
        public Builder d(final String e) {
            this.d = true;
            this.i(e);
            this.e = e;
            return this;
        }
        
        @CanIgnoreReturnValue
        public Builder e() {
            this.a.add(GoogleSignInOptions.y);
            return this;
        }
        
        @CanIgnoreReturnValue
        public Builder f(final Scope scope, final Scope... array) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(array));
            return this;
        }
        
        @CanIgnoreReturnValue
        public Builder g(final String s) {
            this.f = new Account(Preconditions.g(s), "com.google");
            return this;
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public Builder h(final String i) {
            this.i = i;
            return this;
        }
    }
}
