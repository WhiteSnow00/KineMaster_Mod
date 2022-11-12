// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase_auth_api.zztu;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.zze;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth_api.zzxq;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Iterator;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final class zzbd
{
    private static final List d;
    private static final zzbd e;
    private Task a;
    private Task b;
    private long c;
    
    static {
        d = new ArrayList(Arrays.asList("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp"));
        e = new zzbd();
    }
    
    private zzbd() {
        this.c = 0L;
    }
    
    public static zzbd c() {
        return zzbd.e;
    }
    
    private static final void f(final SharedPreferences sharedPreferences) {
        final SharedPreferences$Editor edit = sharedPreferences.edit();
        final Iterator iterator = zzbd.d.iterator();
        while (iterator.hasNext()) {
            edit.remove((String)iterator.next());
        }
        edit.commit();
    }
    
    public final Task a() {
        if (DefaultClock.d().a() - this.c < 3600000L) {
            return this.a;
        }
        return null;
    }
    
    public final Task b() {
        if (DefaultClock.d().a() - this.c < 3600000L) {
            return this.b;
        }
        return null;
    }
    
    public final void d(final Context context) {
        Preconditions.k(context);
        f(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.a = null;
        this.c = 0L;
    }
    
    public final void e(final FirebaseAuth firebaseAuth) {
        Preconditions.k(firebaseAuth);
        final Context l = firebaseAuth.g().l();
        final int n = 0;
        int n2 = 0;
        final SharedPreferences sharedPreferences = l.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (!firebaseAuth.g().o().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            return;
        }
        if (sharedPreferences.contains("verifyAssertionRequest")) {
            final zzxq zzxq = SafeParcelableSerializer.c(sharedPreferences.getString("verifyAssertionRequest", ""), (android.os.Parcelable$Creator<zzxq>)com.google.android.gms.internal.firebase_auth_api.zzxq.CREATOR);
            final String string = sharedPreferences.getString("operation", "");
            final String string2 = sharedPreferences.getString("tenantId", (String)null);
            final String string3 = sharedPreferences.getString("firebaseUserUid", "");
            this.c = sharedPreferences.getLong("timestamp", 0L);
            if (string2 != null) {
                firebaseAuth.r(string2);
                zzxq.zzf(string2);
            }
            final int hashCode = string.hashCode();
            Label_0234: {
                if (hashCode != -98509410) {
                    if (hashCode != 175006864) {
                        if (hashCode == 1450464913) {
                            if (string.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN")) {
                                break Label_0234;
                            }
                        }
                    }
                    else if (string.equals("com.google.firebase.auth.internal.NONGMSCORE_LINK")) {
                        n2 = 1;
                        break Label_0234;
                    }
                }
                else if (string.equals("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE")) {
                    n2 = 2;
                    break Label_0234;
                }
                n2 = -1;
            }
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        this.a = null;
                    }
                    else if (firebaseAuth.h().S1().equals(string3)) {
                        this.a = firebaseAuth.P(firebaseAuth.h(), zze.P1((com.google.android.gms.internal.firebase-auth-api.zzxq)zzxq));
                    }
                    else {
                        this.a = null;
                    }
                }
                else if (firebaseAuth.h().S1().equals(string3)) {
                    this.a = firebaseAuth.O(firebaseAuth.h(), zze.P1((com.google.android.gms.internal.firebase-auth-api.zzxq)zzxq));
                }
                else {
                    this.a = null;
                }
            }
            else {
                this.a = firebaseAuth.t(zze.P1((com.google.android.gms.internal.firebase-auth-api.zzxq)zzxq));
            }
            f(sharedPreferences);
            return;
        }
        if (sharedPreferences.contains("recaptchaToken")) {
            final String string4 = sharedPreferences.getString("recaptchaToken", "");
            final String string5 = sharedPreferences.getString("operation", "");
            this.c = sharedPreferences.getLong("timestamp", 0L);
            int n3 = 0;
            Label_0442: {
                if (string5.hashCode() == -214796028) {
                    if (string5.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA")) {
                        n3 = n;
                        break Label_0442;
                    }
                }
                n3 = -1;
            }
            if (n3 != 0) {
                this.b = null;
            }
            else {
                this.b = Tasks.e((Object)string4);
            }
            f(sharedPreferences);
            return;
        }
        if (sharedPreferences.contains("statusCode")) {
            final Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
            this.c = sharedPreferences.getLong("timestamp", 0L);
            f(sharedPreferences);
            this.a = Tasks.d((Exception)zztu.zza(status));
        }
    }
}
