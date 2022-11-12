// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.os.Handler;
import android.app.Notification;
import android.content.res.Resources;
import android.app.NotificationChannel;
import com.google.android.gms.base.R;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.DeviceProperties;
import androidx.core.app.l;
import android.app.NotificationManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.h;
import android.content.BroadcastReceiver;
import com.google.android.gms.internal.base.zao;
import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zabw;
import android.app.AlertDialog;
import android.view.View;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.util.Log;
import android.content.DialogInterface$OnClickListener;
import com.google.android.gms.common.internal.zac;
import android.app.AlertDialog$Builder;
import android.util.TypedValue;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.content.Intent;
import android.app.PendingIntent;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.wrappers.InstantApps;
import android.app.Dialog;
import com.google.android.gms.common.internal.zag;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import android.app.Activity;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zad;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = { zad.class, zae.class }, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GoogleApiAvailability extends GoogleApiAvailabilityLight
{
    public static final int d;
    private static final Object e;
    private static final GoogleApiAvailability f;
    private String c;
    
    static {
        e = new Object();
        f = new GoogleApiAvailability();
        d = GoogleApiAvailabilityLight.a;
    }
    
    public static GoogleApiAvailability q() {
        return GoogleApiAvailability.f;
    }
    
    public final boolean A(final Activity activity, final LifecycleFragment lifecycleFragment, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final Dialog u = this.u((Context)activity, n, zag.c(lifecycleFragment, this.d((Context)activity, n, "d"), 2), dialogInterface$OnCancelListener);
        if (u == null) {
            return false;
        }
        this.x(activity, u, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener);
        return true;
    }
    
    public final boolean B(final Context context, final ConnectionResult connectionResult, final int n) {
        if (InstantApps.a(context)) {
            return false;
        }
        final PendingIntent p3 = this.p(context, connectionResult);
        if (p3 != null) {
            this.y(context, connectionResult.K1(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, p3, n, true), zap.zaa | 0x8000000));
            return true;
        }
        return false;
    }
    
    @KeepForSdk
    @ShowFirstParty
    @Override
    public Intent d(final Context context, final int n, final String s) {
        return super.d(context, n, s);
    }
    
    @Override
    public PendingIntent e(final Context context, final int n, final int n2) {
        return super.e(context, n, n2);
    }
    
    @Override
    public final String g(final int n) {
        return super.g(n);
    }
    
    @HideFirstParty
    @Override
    public int i(final Context context) {
        return super.i(context);
    }
    
    @KeepForSdk
    @ShowFirstParty
    @Override
    public int j(final Context context, final int n) {
        return super.j(context, n);
    }
    
    @Override
    public final boolean m(final int n) {
        return super.m(n);
    }
    
    public Dialog o(final Activity activity, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return this.u((Context)activity, n, zag.b(activity, this.d((Context)activity, n, "d"), n2), dialogInterface$OnCancelListener);
    }
    
    public PendingIntent p(final Context context, final ConnectionResult connectionResult) {
        if (connectionResult.N1()) {
            return connectionResult.M1();
        }
        return this.e(context, connectionResult.K1(), 0);
    }
    
    public Task<Void> r(final Activity activity) {
        final int d = GoogleApiAvailability.d;
        Preconditions.f("makeGooglePlayServicesAvailable must be called from the main thread");
        final int j = this.j((Context)activity, d);
        Task task;
        if (j == 0) {
            task = Tasks.e((Object)null);
        }
        else {
            final zacc t = zacc.t(activity);
            t.s(new ConnectionResult(j, null), 0);
            task = t.u();
        }
        return (Task<Void>)task;
    }
    
    public boolean s(final Activity activity, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final Dialog o = this.o(activity, n, n2, dialogInterface$OnCancelListener);
        if (o == null) {
            return false;
        }
        this.x(activity, o, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener);
        return true;
    }
    
    public void t(final Context context, final int n) {
        this.y(context, n, null, this.f(context, n, 0, "n"));
    }
    
    final Dialog u(final Context context, final int n, final zag zag, final DialogInterface$OnCancelListener onCancelListener) {
        AlertDialog$Builder alertDialog$Builder = null;
        if (n == 0) {
            return null;
        }
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            alertDialog$Builder = new AlertDialog$Builder(context, 5);
        }
        AlertDialog$Builder alertDialog$Builder2;
        if ((alertDialog$Builder2 = alertDialog$Builder) == null) {
            alertDialog$Builder2 = new AlertDialog$Builder(context);
        }
        alertDialog$Builder2.setMessage((CharSequence)zac.d(context, n));
        if (onCancelListener != null) {
            alertDialog$Builder2.setOnCancelListener(onCancelListener);
        }
        final String c = zac.c(context, n);
        if (c != null) {
            alertDialog$Builder2.setPositiveButton((CharSequence)c, (DialogInterface$OnClickListener)zag);
        }
        final String g = zac.g(context, n);
        if (g != null) {
            alertDialog$Builder2.setTitle((CharSequence)g);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", n), (Throwable)new IllegalArgumentException());
        return (Dialog)alertDialog$Builder2.create();
    }
    
    public final Dialog v(final Activity activity, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final ProgressBar view = new ProgressBar((Context)activity, (AttributeSet)null, 16842874);
        view.setIndeterminate(true);
        view.setVisibility(0);
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)activity);
        alertDialog$Builder.setView((View)view);
        alertDialog$Builder.setMessage((CharSequence)zac.d((Context)activity, 18));
        alertDialog$Builder.setPositiveButton((CharSequence)"", (DialogInterface$OnClickListener)null);
        final AlertDialog create = alertDialog$Builder.create();
        this.x(activity, (Dialog)create, "GooglePlayServicesUpdatingDialog", dialogInterface$OnCancelListener);
        return (Dialog)create;
    }
    
    public final zabx w(final Context context, final zabw zabw) {
        final IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        final zabx zabx = new zabx(zabw);
        zao.zaa(context, (BroadcastReceiver)zabx, intentFilter);
        zabx.a(context);
        if (!this.l(context, "com.google.android.gms")) {
            zabw.a();
            zabx.b();
            return null;
        }
        return zabx;
    }
    
    final void x(Activity activity, final Dialog dialog, final String s, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        while (true) {
            try {
                if (activity instanceof h) {
                    activity = (Activity)((h)activity).getSupportFragmentManager();
                    SupportErrorDialogFragment.g4(dialog, dialogInterface$OnCancelListener).show((FragmentManager)activity, s);
                    return;
                }
                activity = (Activity)activity.getFragmentManager();
                ErrorDialogFragment.a(dialog, dialogInterface$OnCancelListener).show((android.app.FragmentManager)activity, s);
            }
            catch (final NoClassDefFoundError noClassDefFoundError) {
                continue;
            }
            break;
        }
    }
    
    final void y(final Context context, int n, String s, final PendingIntent pendingIntent) {
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", n, null), (Throwable)new IllegalArgumentException());
        if (n == 18) {
            this.z(context);
            return;
        }
        if (pendingIntent == null) {
            if (n == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
            return;
        }
        final String f = zac.f(context, n);
        s = zac.e(context, n);
        final Resources resources = context.getResources();
        final NotificationManager notificationManager = Preconditions.k(context.getSystemService("notification"));
        final l.e w = new l.e(context).q(true).f(true).k(f).w(new l.c().h(s));
        if (DeviceProperties.e(context)) {
            Preconditions.o(PlatformVersion.e());
            w.u(context.getApplicationInfo().icon).s(2);
            if (DeviceProperties.f(context)) {
                w.a(R.drawable.a, resources.getString(R.string.o), pendingIntent);
            }
            else {
                w.i(pendingIntent);
            }
        }
        else {
            w.u(17301642).x(resources.getString(R.string.h)).A(System.currentTimeMillis()).i(pendingIntent).j(s);
        }
        Label_0366: {
            if (!PlatformVersion.i()) {
                break Label_0366;
            }
            Preconditions.o(PlatformVersion.i());
            s = (String)GoogleApiAvailability.e;
            synchronized (s) {
                final String c = this.c;
                monitorexit(s);
                s = c;
                if (c == null) {
                    final String s2 = "com.google.android.gms.availability";
                    final NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    final String b = zac.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", (CharSequence)b, 4));
                        s = s2;
                    }
                    else {
                        s = s2;
                        if (!b.contentEquals(notificationChannel.getName())) {
                            notificationChannel.setName((CharSequence)b);
                            notificationManager.createNotificationChannel(notificationChannel);
                            s = s2;
                        }
                    }
                }
                w.g(s);
                final Notification b2 = w.b();
                if (n != 1 && n != 2 && n != 3) {
                    n = 39789;
                }
                else {
                    GooglePlayServicesUtilLight.b.set(false);
                    n = 10436;
                }
                notificationManager.notify(n, b2);
            }
        }
    }
    
    final void z(final Context context) {
        ((Handler)new a(this, context)).sendEmptyMessageDelayed(1, 120000L);
    }
}
