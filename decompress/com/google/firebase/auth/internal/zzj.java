// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import java.util.Iterator;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;

public final class zzj
{
    private static final zzj a;
    
    static {
        a = new zzj();
    }
    
    private zzj() {
    }
    
    public static zzj b() {
        return zzj.a;
    }
    
    private static void f(final SharedPreferences sharedPreferences) {
        final SharedPreferences$Editor edit = sharedPreferences.edit();
        final Iterator iterator = sharedPreferences.getAll().keySet().iterator();
        while (iterator.hasNext()) {
            edit.remove((String)iterator.next());
        }
        edit.apply();
    }
    
    private static final SharedPreferences g(final Context context, final String s) {
        return context.getSharedPreferences(String.format("com.google.firebase.auth.internal.browserSignInSessionStore.%s", s), 0);
    }
    
    public final zzi a(final Context context, String format, String string) {
        synchronized (this) {
            Preconditions.g(format);
            Preconditions.g(string);
            final SharedPreferences g = g(context, format);
            final String format2 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", string);
            format = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", string);
            final String format3 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", string);
            final String format4 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", string);
            final String string2 = g.getString(format2, (String)null);
            final String string3 = g.getString(format, (String)null);
            final String string4 = g.getString(format3, (String)null);
            string = g.getString("com.google.firebase.auth.api.gms.config.tenant.id", (String)null);
            final String string5 = g.getString(format4, (String)null);
            final SharedPreferences$Editor edit = g.edit();
            edit.remove(format2);
            edit.remove(format);
            edit.remove(format3);
            edit.remove(format4);
            edit.apply();
            if (string2 != null && string3 != null && string4 != null) {
                return new zzi(string2, string3, string4, string, string5);
            }
            return null;
        }
    }
    
    public final String c(final Context context, String string, String format) {
        synchronized (this) {
            Preconditions.g(string);
            Preconditions.g(format);
            final SharedPreferences g = g(context, string);
            final String format2 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", format);
            string = g.getString(format2, (String)null);
            format = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", format);
            final String string2 = g.getString(format, (String)null);
            final SharedPreferences$Editor edit = g.edit();
            edit.remove(format2);
            edit.remove(format);
            edit.apply();
            final boolean empty = TextUtils.isEmpty((CharSequence)string);
            monitorexit(this);
            if (empty) {
                return null;
            }
            return string2;
        }
    }
    
    public final void d(final Context context, final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7) {
        synchronized (this) {
            Preconditions.g(s);
            Preconditions.g(s2);
            Preconditions.g(s3);
            Preconditions.g(s7);
            final SharedPreferences g = g(context, s);
            f(g);
            final SharedPreferences$Editor edit = g.edit();
            edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", s2), s3);
            edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", s2), s4);
            edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", s2), s5);
            edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", s2), s7);
            edit.putString("com.google.firebase.auth.api.gms.config.tenant.id", s6);
            edit.apply();
        }
    }
    
    public final void e(final Context context, final String s, final String s2, final String s3, final String s4) {
        synchronized (this) {
            Preconditions.g(s);
            Preconditions.g(s2);
            final SharedPreferences g = g(context, s);
            f(g);
            final SharedPreferences$Editor edit = g.edit();
            edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", s2), "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            edit.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", s2), s4);
            edit.apply();
        }
    }
}
