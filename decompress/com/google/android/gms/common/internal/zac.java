// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.GooglePlayServicesUtil;
import androidx.core.os.f;
import android.util.Log;
import com.google.android.gms.common.util.DeviceProperties;
import android.content.res.Resources;
import com.google.android.gms.base.R;
import android.content.pm.PackageManager$NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import android.content.Context;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
import androidx.collection.g;

public final class zac
{
    @GuardedBy
    private static final g a;
    @GuardedBy
    private static Locale b;
    
    static {
        a = new g();
    }
    
    public static String a(final Context context) {
        final String packageName = context.getPackageName();
        try {
            return Wrappers.a(context).d(packageName).toString();
        }
        catch (final PackageManager$NameNotFoundException | NullPointerException ex) {
            final String name = context.getApplicationInfo().name;
            if (TextUtils.isEmpty((CharSequence)name)) {
                return packageName;
            }
            return name;
        }
    }
    
    public static String b(final Context context) {
        return context.getResources().getString(R.string.g);
    }
    
    public static String c(final Context context, final int n) {
        final Resources resources = context.getResources();
        if (n == 1) {
            return resources.getString(R.string.d);
        }
        if (n == 2) {
            return resources.getString(R.string.j);
        }
        if (n != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R.string.a);
    }
    
    public static String d(final Context context, final int n) {
        final Resources resources = context.getResources();
        final String a = a(context);
        if (n == 1) {
            return resources.getString(R.string.e, new Object[] { a });
        }
        if (n != 2) {
            if (n == 3) {
                return resources.getString(R.string.b, new Object[] { a });
            }
            if (n == 5) {
                return h(context, "common_google_play_services_invalid_account_text", a);
            }
            if (n == 7) {
                return h(context, "common_google_play_services_network_error_text", a);
            }
            if (n == 9) {
                return resources.getString(R.string.i, new Object[] { a });
            }
            if (n == 20) {
                return h(context, "common_google_play_services_restricted_profile_text", a);
            }
            switch (n) {
                default: {
                    return resources.getString(com.google.android.gms.common.R.string.a, new Object[] { a });
                }
                case 18: {
                    return resources.getString(R.string.m, new Object[] { a });
                }
                case 17: {
                    return h(context, "common_google_play_services_sign_in_failed_text", a);
                }
                case 16: {
                    return h(context, "common_google_play_services_api_unavailable_text", a);
                }
            }
        }
        else {
            if (DeviceProperties.f(context)) {
                return resources.getString(R.string.n);
            }
            return resources.getString(R.string.k, new Object[] { a });
        }
    }
    
    public static String e(final Context context, final int n) {
        if (n != 6 && n != 19) {
            return d(context, n);
        }
        return h(context, "common_google_play_services_resolution_required_text", a(context));
    }
    
    public static String f(final Context context, final int n) {
        String s;
        if (n == 6) {
            s = i(context, "common_google_play_services_resolution_required_title");
        }
        else {
            s = g(context, n);
        }
        if (s == null) {
            return context.getResources().getString(R.string.h);
        }
        return s;
    }
    
    public static String g(final Context context, final int n) {
        final Resources resources = context.getResources();
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected error code ");
                sb.append(n);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            }
            case 20: {
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
            }
            case 17: {
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            }
            case 16: {
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            }
            case 11: {
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            }
            case 10: {
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            }
            case 9: {
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            }
            case 8: {
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            }
            case 7: {
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            }
            case 5: {
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            }
            case 4:
            case 6:
            case 18: {
                return null;
            }
            case 3: {
                return resources.getString(R.string.c);
            }
            case 2: {
                return resources.getString(R.string.l);
            }
            case 1: {
                return resources.getString(R.string.f);
            }
        }
    }
    
    private static String h(final Context context, String s, final String s2) {
        final Resources resources = context.getResources();
        String s3;
        s = (s3 = i(context, s));
        if (s == null) {
            s3 = resources.getString(com.google.android.gms.common.R.string.a);
        }
        return String.format(resources.getConfiguration().locale, s3, s2);
    }
    
    private static String i(final Context context, final String s) {
        final g a = zac.a;
        synchronized (a) {
            final Locale b = f.a(context.getResources().getConfiguration()).b(0);
            if (!b.equals(zac.b)) {
                a.clear();
                zac.b = b;
            }
            final String s2 = a.get(s);
            if (s2 != null) {
                return s2;
            }
            final Resources f = GooglePlayServicesUtil.f(context);
            if (f == null) {
                return null;
            }
            final int identifier = f.getIdentifier(s, "string", "com.google.android.gms");
            if (identifier == 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Missing resource: ");
                sb.append(s);
                Log.w("GoogleApiAvailability", sb.toString());
                return null;
            }
            final String string = f.getString(identifier);
            if (TextUtils.isEmpty((CharSequence)string)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Got empty resource: ");
                sb2.append(s);
                Log.w("GoogleApiAvailability", sb2.toString());
                return null;
            }
            a.put(s, string);
            return string;
        }
    }
}
