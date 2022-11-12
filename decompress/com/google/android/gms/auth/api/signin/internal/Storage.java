// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import org.json.JSONException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;
import android.content.SharedPreferences;
import javax.annotation.concurrent.GuardedBy;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class Storage
{
    private static final Lock c;
    @GuardedBy
    private static Storage d;
    private final Lock a;
    @GuardedBy
    private final SharedPreferences b;
    
    static {
        c = new ReentrantLock();
    }
    
    @VisibleForTesting
    Storage(final Context context) {
        this.a = new ReentrantLock();
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }
    
    @KeepForSdk
    public static Storage b(final Context context) {
        Preconditions.k(context);
        final Lock c = Storage.c;
        c.lock();
        try {
            if (Storage.d == null) {
                Storage.d = new Storage(context.getApplicationContext());
            }
            final Storage d = Storage.d;
            c.unlock();
            return d;
        }
        finally {
            Storage.c.unlock();
        }
    }
    
    private static final String i(final String s, final String s2) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(":");
        sb.append(s2);
        return sb.toString();
    }
    
    @KeepForSdk
    public void a() {
        this.a.lock();
        try {
            this.b.edit().clear().apply();
        }
        finally {
            this.a.unlock();
        }
    }
    
    @KeepForSdk
    public GoogleSignInAccount c() {
        final String g = this.g("defaultGoogleSignInAccount");
        final boolean empty = TextUtils.isEmpty((CharSequence)g);
        final GoogleSignInAccount googleSignInAccount = null;
        if (empty) {
            return googleSignInAccount;
        }
        final String g2 = this.g(i("googleSignInAccount", g));
        GoogleSignInAccount v1 = googleSignInAccount;
        if (g2 == null) {
            return v1;
        }
        try {
            v1 = GoogleSignInAccount.V1(g2);
            return v1;
        }
        catch (final JSONException ex) {
            v1 = googleSignInAccount;
            return v1;
        }
    }
    
    @KeepForSdk
    public GoogleSignInOptions d() {
        final String g = this.g("defaultGoogleSignInAccount");
        final boolean empty = TextUtils.isEmpty((CharSequence)g);
        final GoogleSignInOptions googleSignInOptions = null;
        if (empty) {
            return googleSignInOptions;
        }
        final String g2 = this.g(i("googleSignInOptions", g));
        GoogleSignInOptions s1 = googleSignInOptions;
        if (g2 == null) {
            return s1;
        }
        try {
            s1 = GoogleSignInOptions.S1(g2);
            return s1;
        }
        catch (final JSONException ex) {
            s1 = googleSignInOptions;
            return s1;
        }
    }
    
    @KeepForSdk
    public String e() {
        return this.g("refreshToken");
    }
    
    @KeepForSdk
    public void f(final GoogleSignInAccount googleSignInAccount, final GoogleSignInOptions googleSignInOptions) {
        Preconditions.k(googleSignInAccount);
        Preconditions.k(googleSignInOptions);
        this.h("defaultGoogleSignInAccount", googleSignInAccount.W1());
        Preconditions.k(googleSignInAccount);
        Preconditions.k(googleSignInOptions);
        final String w1 = googleSignInAccount.W1();
        this.h(i("googleSignInAccount", w1), googleSignInAccount.X1());
        this.h(i("googleSignInOptions", w1), googleSignInOptions.W1());
    }
    
    protected final String g(String string) {
        this.a.lock();
        try {
            string = this.b.getString(string, (String)null);
            return string;
        }
        finally {
            this.a.unlock();
        }
    }
    
    protected final void h(final String s, final String s2) {
        this.a.lock();
        try {
            this.b.edit().putString(s, s2).apply();
        }
        finally {
            this.a.unlock();
        }
    }
}
