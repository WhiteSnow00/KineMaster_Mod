// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.internal.zzip;
import java.util.Iterator;
import com.google.android.gms.measurement.internal.zzhb;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzha;
import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.internal.zzhd;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class zzc
{
    private static final Set a;
    private static final List b;
    private static final List c;
    private static final List d;
    private static final List e;
    private static final List f;
    
    static {
        a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));
        b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
        c = Arrays.asList("auto", "app", "am");
        d = Arrays.asList("_r", "_dbg");
        e = Arrays.asList((Object[])ArrayUtils.a((T[][])new String[][] { zzhd.a, zzhd.b }));
        f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }
    
    public static Bundle a(final AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        final Bundle bundle = new Bundle();
        final String a = conditionalUserProperty.a;
        if (a != null) {
            bundle.putString("origin", a);
        }
        final String b = conditionalUserProperty.b;
        if (b != null) {
            bundle.putString("name", b);
        }
        final Object c = conditionalUserProperty.c;
        if (c != null) {
            zzha.b(bundle, c);
        }
        final String d = conditionalUserProperty.d;
        if (d != null) {
            bundle.putString("trigger_event_name", d);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.e);
        final String f = conditionalUserProperty.f;
        if (f != null) {
            bundle.putString("timed_out_event_name", f);
        }
        final Bundle g = conditionalUserProperty.g;
        if (g != null) {
            bundle.putBundle("timed_out_event_params", g);
        }
        final String h = conditionalUserProperty.h;
        if (h != null) {
            bundle.putString("triggered_event_name", h);
        }
        final Bundle i = conditionalUserProperty.i;
        if (i != null) {
            bundle.putBundle("triggered_event_params", i);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.j);
        final String k = conditionalUserProperty.k;
        if (k != null) {
            bundle.putString("expired_event_name", k);
        }
        final Bundle l = conditionalUserProperty.l;
        if (l != null) {
            bundle.putBundle("expired_event_params", l);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.m);
        bundle.putBoolean("active", conditionalUserProperty.n);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.o);
        return bundle;
    }
    
    public static AnalyticsConnector.ConditionalUserProperty b(final Bundle bundle) {
        Preconditions.k(bundle);
        final AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.a = Preconditions.k(zzha.a(bundle, "origin", (Class)String.class, (Object)null));
        conditionalUserProperty.b = Preconditions.k(zzha.a(bundle, "name", (Class)String.class, (Object)null));
        conditionalUserProperty.c = zzha.a(bundle, "value", (Class)Object.class, (Object)null);
        conditionalUserProperty.d = (String)zzha.a(bundle, "trigger_event_name", (Class)String.class, (Object)null);
        final Long value = 0L;
        conditionalUserProperty.e = (long)zzha.a(bundle, "trigger_timeout", (Class)Long.class, (Object)value);
        conditionalUserProperty.f = (String)zzha.a(bundle, "timed_out_event_name", (Class)String.class, (Object)null);
        conditionalUserProperty.g = (Bundle)zzha.a(bundle, "timed_out_event_params", (Class)Bundle.class, (Object)null);
        conditionalUserProperty.h = (String)zzha.a(bundle, "triggered_event_name", (Class)String.class, (Object)null);
        conditionalUserProperty.i = (Bundle)zzha.a(bundle, "triggered_event_params", (Class)Bundle.class, (Object)null);
        conditionalUserProperty.j = (long)zzha.a(bundle, "time_to_live", (Class)Long.class, (Object)value);
        conditionalUserProperty.k = (String)zzha.a(bundle, "expired_event_name", (Class)String.class, (Object)null);
        conditionalUserProperty.l = (Bundle)zzha.a(bundle, "expired_event_params", (Class)Bundle.class, (Object)null);
        conditionalUserProperty.n = (boolean)zzha.a(bundle, "active", (Class)Boolean.class, (Object)Boolean.FALSE);
        conditionalUserProperty.m = (long)zzha.a(bundle, "creation_timestamp", (Class)Long.class, (Object)value);
        conditionalUserProperty.o = (long)zzha.a(bundle, "triggered_timestamp", (Class)Long.class, (Object)value);
        return conditionalUserProperty;
    }
    
    public static String c(final String s) {
        final String a = zzhb.a(s);
        if (a != null) {
            return a;
        }
        return s;
    }
    
    public static String d(final String s) {
        final String b = zzhb.b(s);
        if (b != null) {
            return b;
        }
        return s;
    }
    
    public static void e(final String s, final String s2, final Bundle bundle) {
        if ("clx".equals(s) && "_ae".equals(s2)) {
            bundle.putLong("_r", 1L);
        }
    }
    
    public static boolean f(final String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        final int codePoint = s.codePointAt(0);
        if (!Character.isLetter(codePoint) && codePoint != 95) {
            return false;
        }
        int codePoint2;
        for (int length = s.length(), i = Character.charCount(codePoint); i < length; i += Character.charCount(codePoint2)) {
            codePoint2 = s.codePointAt(i);
            if (codePoint2 != 95 && !Character.isLetterOrDigit(codePoint2)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean g(final String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        final int codePoint = s.codePointAt(0);
        if (!Character.isLetter(codePoint)) {
            return false;
        }
        int codePoint2;
        for (int length = s.length(), i = Character.charCount(codePoint); i < length; i += Character.charCount(codePoint2)) {
            codePoint2 = s.codePointAt(i);
            if (codePoint2 != 95 && !Character.isLetterOrDigit(codePoint2)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean h(final String s, final String s2, final Bundle bundle) {
        if (!"_cmp".equals(s2)) {
            return true;
        }
        if (!l(s)) {
            return false;
        }
        if (bundle == null) {
            return false;
        }
        final Iterator iterator = zzc.d.iterator();
        while (iterator.hasNext()) {
            if (bundle.containsKey((String)iterator.next())) {
                return false;
            }
        }
        final int hashCode = s.hashCode();
        int n = 0;
        Label_0139: {
            if (hashCode != 101200) {
                if (hashCode != 101230) {
                    if (hashCode == 3142703) {
                        if (s.equals("fiam")) {
                            n = 2;
                            break Label_0139;
                        }
                    }
                }
                else if (s.equals("fdl")) {
                    n = 1;
                    break Label_0139;
                }
            }
            else if (s.equals("fcm")) {
                n = 0;
                break Label_0139;
            }
            n = -1;
        }
        if (n == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        if (n == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        if (n != 2) {
            return false;
        }
        bundle.putString("_cis", "fiam_integration");
        return true;
    }
    
    public static boolean i(final AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (conditionalUserProperty == null) {
            return false;
        }
        final String a = conditionalUserProperty.a;
        if (a == null || a.isEmpty()) {
            return false;
        }
        final Object c = conditionalUserProperty.c;
        if (c != null && zzip.a(c) == null) {
            return false;
        }
        if (!l(a)) {
            return false;
        }
        if (!m(a, conditionalUserProperty.b)) {
            return false;
        }
        final String k = conditionalUserProperty.k;
        if (k != null) {
            if (!j(k, conditionalUserProperty.l)) {
                return false;
            }
            if (!h(a, conditionalUserProperty.k, conditionalUserProperty.l)) {
                return false;
            }
        }
        final String h = conditionalUserProperty.h;
        if (h != null) {
            if (!j(h, conditionalUserProperty.i)) {
                return false;
            }
            if (!h(a, conditionalUserProperty.h, conditionalUserProperty.i)) {
                return false;
            }
        }
        final String f = conditionalUserProperty.f;
        if (f != null) {
            if (!j(f, conditionalUserProperty.g)) {
                return false;
            }
            if (!h(a, conditionalUserProperty.f, conditionalUserProperty.g)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean j(final String s, final Bundle bundle) {
        if (zzc.b.contains(s)) {
            return false;
        }
        if (bundle != null) {
            final Iterator iterator = zzc.d.iterator();
            while (iterator.hasNext()) {
                if (bundle.containsKey((String)iterator.next())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean k(final String s) {
        return !zzc.a.contains(s);
    }
    
    public static boolean l(final String s) {
        return !zzc.c.contains(s);
    }
    
    public static boolean m(final String s, final String s2) {
        if ("_ce1".equals(s2) || "_ce2".equals(s2)) {
            return s.equals("fcm") || s.equals("frc");
        }
        if ("_ln".equals(s2)) {
            return s.equals("fcm") || s.equals("fiam");
        }
        if (zzc.e.contains(s2)) {
            return false;
        }
        final Iterator iterator = zzc.f.iterator();
        while (iterator.hasNext()) {
            if (s2.matches((String)iterator.next())) {
                return false;
            }
        }
        return true;
    }
}
