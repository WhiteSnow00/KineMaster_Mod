// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import android.app.Activity;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.common.internal.Preconditions;
import android.content.SharedPreferences$Editor;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import android.content.Context;
import com.google.android.gms.tasks.Task;

public final class zzbm
{
    private static final zzbm c;
    private final zzbd a;
    private final zzax b;
    
    static {
        c = new zzbm();
    }
    
    private zzbm() {
        final zzbd c = zzbd.c();
        final zzax a = zzax.a();
        this.a = c;
        this.b = a;
    }
    
    public static zzbm c() {
        return zzbm.c;
    }
    
    public final Task a() {
        return this.a.a();
    }
    
    public final Task b() {
        return this.a.b();
    }
    
    public final void d(final Context context) {
        this.a.d(context);
    }
    
    public final void e(final FirebaseAuth firebaseAuth) {
        this.a.e(firebaseAuth);
    }
    
    public final void f(final Context context, final Status status) {
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.M1());
        edit.putString("statusMessage", status.N1());
        edit.putLong("timestamp", DefaultClock.d().a());
        edit.commit();
    }
    
    public final void g(final Context context, final FirebaseAuth firebaseAuth) {
        Preconditions.k(context);
        Preconditions.k(firebaseAuth);
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.g().o());
        edit.commit();
    }
    
    public final void h(final Context context, final FirebaseAuth firebaseAuth, final FirebaseUser firebaseUser) {
        Preconditions.k(context);
        Preconditions.k(firebaseAuth);
        Preconditions.k(firebaseUser);
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.g().o());
        edit.putString("firebaseUserUid", firebaseUser.S1());
        edit.commit();
    }
    
    public final boolean i(final Activity activity, final TaskCompletionSource taskCompletionSource, final FirebaseAuth firebaseAuth) {
        return this.b.f(activity, taskCompletionSource, firebaseAuth, null);
    }
    
    public final boolean j(final Activity activity, final TaskCompletionSource taskCompletionSource, final FirebaseAuth firebaseAuth, final FirebaseUser firebaseUser) {
        return this.b.f(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}
