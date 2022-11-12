// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import android.os.Build$VERSION;
import android.os.Build;
import java.util.Locale;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.UUID;
import android.content.SharedPreferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import android.content.Context;
import java.util.regex.Pattern;

public class IdManager implements InstallIdProvider
{
    private static final Pattern g;
    private static final String h;
    private final k a;
    private final Context b;
    private final String c;
    private final FirebaseInstallationsApi d;
    private final DataCollectionArbiter e;
    private String f;
    
    static {
        g = Pattern.compile("[^\\p{Alnum}]");
        h = Pattern.quote("/");
    }
    
    public IdManager(final Context b, final String c, final FirebaseInstallationsApi d, final DataCollectionArbiter e) {
        if (b == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (c != null) {
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.a = new k();
            return;
        }
        throw new IllegalArgumentException("appIdentifier must not be null");
    }
    
    private String b(final String s, final SharedPreferences sharedPreferences) {
        synchronized (this) {
            final String e = e(UUID.randomUUID().toString());
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Created new Crashlytics installation ID: ");
            sb.append(e);
            sb.append(" for FID: ");
            sb.append(s);
            f.i(sb.toString());
            sharedPreferences.edit().putString("crashlytics.installation.id", e).putString("firebase.installation.id", s).apply();
            return e;
        }
    }
    
    static String c() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SYN_");
        sb.append(UUID.randomUUID().toString());
        return sb.toString();
    }
    
    private String d() {
        final Task id = this.d.getId();
        String s;
        try {
            s = Utils.d((com.google.android.gms.tasks.Task<String>)id);
        }
        catch (final Exception ex) {
            Logger.f().l("Failed to retrieve Firebase Installations ID.", ex);
            s = null;
        }
        return s;
    }
    
    private static String e(String lowerCase) {
        if (lowerCase == null) {
            lowerCase = null;
        }
        else {
            lowerCase = IdManager.g.matcher(lowerCase).replaceAll("").toLowerCase(Locale.US);
        }
        return lowerCase;
    }
    
    static boolean k(final String s) {
        return s != null && s.startsWith("SYN_");
    }
    
    private String l(final SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", (String)null);
    }
    
    private String m(final String s) {
        return s.replaceAll(IdManager.h, "");
    }
    
    @Override
    public String a() {
        synchronized (this) {
            final String f = this.f;
            if (f != null) {
                return f;
            }
            Logger.f().i("Determining Crashlytics installation ID...");
            final SharedPreferences r = CommonUtils.r(this.b);
            final String string = r.getString("firebase.installation.id", (String)null);
            final Logger f2 = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Cached Firebase Installation ID: ");
            sb.append(string);
            f2.i(sb.toString());
            if (this.e.d()) {
                final String d = this.d();
                final Logger f3 = Logger.f();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Fetched Firebase Installation ID: ");
                sb2.append(d);
                f3.i(sb2.toString());
                String c;
                if ((c = d) == null) {
                    if (string == null) {
                        c = c();
                    }
                    else {
                        c = string;
                    }
                }
                if (c.equals(string)) {
                    this.f = this.l(r);
                }
                else {
                    this.f = this.b(c, r);
                }
            }
            else if (k(string)) {
                this.f = this.l(r);
            }
            else {
                this.f = this.b(c(), r);
            }
            if (this.f == null) {
                Logger.f().k("Unable to determine Crashlytics Install Id, creating a new one.");
                this.f = this.b(c(), r);
            }
            final Logger f4 = Logger.f();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Crashlytics installation ID: ");
            sb3.append(this.f);
            f4.i(sb3.toString());
            return this.f;
        }
    }
    
    public String f() {
        return this.c;
    }
    
    public String g() {
        return this.a.a(this.b);
    }
    
    public String h() {
        return String.format(Locale.US, "%s/%s", this.m(Build.MANUFACTURER), this.m(Build.MODEL));
    }
    
    public String i() {
        return this.m(Build$VERSION.INCREMENTAL);
    }
    
    public String j() {
        return this.m(Build$VERSION.RELEASE);
    }
}
