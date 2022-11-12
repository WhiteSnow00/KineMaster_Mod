// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import com.google.android.gms.common.internal.Objects;
import android.text.TextUtils;
import com.google.android.gms.common.internal.StringResourceValueReader;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;

public final class FirebaseOptions
{
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    
    private FirebaseOptions(final String b, final String a, final String c, final String d, final String e, final String f, final String g) {
        Preconditions.p(Strings.b(b) ^ true, "ApplicationId must be set.");
        this.b = b;
        this.a = a;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public static FirebaseOptions a(final Context context) {
        final StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        final String a = stringResourceValueReader.a("google_app_id");
        if (TextUtils.isEmpty((CharSequence)a)) {
            return null;
        }
        return new FirebaseOptions(a, stringResourceValueReader.a("google_api_key"), stringResourceValueReader.a("firebase_database_url"), stringResourceValueReader.a("ga_trackingId"), stringResourceValueReader.a("gcm_defaultSenderId"), stringResourceValueReader.a("google_storage_bucket"), stringResourceValueReader.a("project_id"));
    }
    
    public String b() {
        return this.a;
    }
    
    public String c() {
        return this.b;
    }
    
    public String d() {
        return this.c;
    }
    
    public String e() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof FirebaseOptions;
        final boolean b2 = false;
        if (!b) {
            return false;
        }
        final FirebaseOptions firebaseOptions = (FirebaseOptions)o;
        boolean b3 = b2;
        if (Objects.b(this.b, firebaseOptions.b)) {
            b3 = b2;
            if (Objects.b(this.a, firebaseOptions.a)) {
                b3 = b2;
                if (Objects.b(this.c, firebaseOptions.c)) {
                    b3 = b2;
                    if (Objects.b(this.d, firebaseOptions.d)) {
                        b3 = b2;
                        if (Objects.b(this.e, firebaseOptions.e)) {
                            b3 = b2;
                            if (Objects.b(this.f, firebaseOptions.f)) {
                                b3 = b2;
                                if (Objects.b(this.g, firebaseOptions.g)) {
                                    b3 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return b3;
    }
    
    public String f() {
        return this.g;
    }
    
    public String g() {
        return this.f;
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.b, this.a, this.c, this.d, this.e, this.f, this.g);
    }
    
    @Override
    public String toString() {
        return Objects.d(this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).a("projectId", this.g).toString();
    }
    
    public static final class Builder
    {
    }
}
