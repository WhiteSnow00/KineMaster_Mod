// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import androidx.core.content.a;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.content.Context;

public class j
{
    private final Context a;
    private long b;
    private SharedPreferences c;
    private SharedPreferences$Editor d;
    private boolean e;
    private String f;
    private int g;
    private int h;
    private PreferenceScreen i;
    private c j;
    private a k;
    private b l;
    
    public j(final Context a) {
        this.b = 0L;
        this.h = 0;
        this.a = a;
        this.s(d(a));
    }
    
    public static SharedPreferences b(final Context context) {
        return context.getSharedPreferences(d(context), c());
    }
    
    private static int c() {
        return 0;
    }
    
    private static String d(final Context context) {
        final StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append("_preferences");
        return sb.toString();
    }
    
    private void n(final boolean e) {
        if (!e) {
            final SharedPreferences$Editor d = this.d;
            if (d != null) {
                d.apply();
            }
        }
        this.e = e;
    }
    
    public <T extends Preference> T a(final CharSequence charSequence) {
        final PreferenceScreen i = this.i;
        if (i == null) {
            return null;
        }
        return (T)i.X0(charSequence);
    }
    
    SharedPreferences$Editor e() {
        if (this.e) {
            if (this.d == null) {
                this.d = this.l().edit();
            }
            return this.d;
        }
        return this.l().edit();
    }
    
    long f() {
        synchronized (this) {
            final long b = this.b;
            this.b = 1L + b;
            return b;
        }
    }
    
    public b g() {
        return this.l;
    }
    
    public c h() {
        return this.j;
    }
    
    public d i() {
        return null;
    }
    
    public e j() {
        return null;
    }
    
    public PreferenceScreen k() {
        return this.i;
    }
    
    public SharedPreferences l() {
        this.j();
        if (this.c == null) {
            Context context;
            if (this.h != 1) {
                context = this.a;
            }
            else {
                context = androidx.core.content.a.createDeviceProtectedStorageContext(this.a);
            }
            this.c = context.getSharedPreferences(this.f, this.g);
        }
        return this.c;
    }
    
    public PreferenceScreen m(final Context context, final int n, final PreferenceScreen preferenceScreen) {
        this.n(true);
        final PreferenceScreen preferenceScreen2 = (PreferenceScreen)new i(context, this).d(n, preferenceScreen);
        preferenceScreen2.W(this);
        this.n(false);
        return preferenceScreen2;
    }
    
    public void o(final a k) {
        this.k = k;
    }
    
    public void p(final b l) {
        this.l = l;
    }
    
    public void q(final c j) {
        this.j = j;
    }
    
    public boolean r(final PreferenceScreen i) {
        final PreferenceScreen j = this.i;
        if (i != j) {
            if (j != null) {
                j.d0();
            }
            this.i = i;
            return true;
        }
        return false;
    }
    
    public void s(final String f) {
        this.f = f;
        this.c = null;
    }
    
    boolean t() {
        return this.e ^ true;
    }
    
    public void u(final Preference preference) {
        final a k = this.k;
        if (k != null) {
            k.G3(preference);
        }
    }
    
    public interface a
    {
        void G3(final Preference p0);
    }
    
    public interface b
    {
        void q1(final PreferenceScreen p0);
    }
    
    public interface c
    {
        boolean S3(final Preference p0);
    }
    
    public abstract static class d
    {
    }
}
