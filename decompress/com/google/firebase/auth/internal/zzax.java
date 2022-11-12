// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.auth.zze;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth_api.zzxq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import android.content.IntentFilter;
import android.app.Activity;
import l0.a;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import android.content.Context;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.TaskCompletionSource;
import android.content.Intent;
import android.content.BroadcastReceiver;

public final class zzax
{
    private static zzax c;
    private boolean a;
    private BroadcastReceiver b;
    
    private zzax() {
        this.a = false;
    }
    
    public static zzax a() {
        if (zzax.c == null) {
            zzax.c = new zzax();
        }
        return zzax.c;
    }
    
    static /* bridge */ void b(final zzax zzax, final Intent intent, final TaskCompletionSource taskCompletionSource, final FirebaseUser firebaseUser, final Context context) {
        firebaseUser.U1(i(intent)).i((OnSuccessListener)new g(zzax, taskCompletionSource, context)).f((OnFailureListener)new f(zzax, taskCompletionSource, context));
    }
    
    static /* bridge */ void c(final zzax zzax, final Intent intent, final TaskCompletionSource taskCompletionSource, final FirebaseUser firebaseUser, final Context context) {
        firebaseUser.V1(i(intent)).i((OnSuccessListener)new i(zzax, taskCompletionSource, context)).f((OnFailureListener)new h(zzax, taskCompletionSource, context));
    }
    
    static /* bridge */ void d(final zzax zzax, final Intent intent, final TaskCompletionSource taskCompletionSource, final FirebaseAuth firebaseAuth, final Context context) {
        firebaseAuth.t(i(intent)).i((OnSuccessListener)new e(zzax, taskCompletionSource, context)).f((OnFailureListener)new d(zzax, taskCompletionSource, context));
    }
    
    static void e(final Context context) {
        final zzax c = zzax.c;
        c.a = false;
        if (c.b != null) {
            a.b(context).e(zzax.c.b);
        }
        zzax.c.b = null;
    }
    
    private final void h(final Activity activity, final BroadcastReceiver b) {
        this.b = b;
        l0.a.b((Context)activity).c(b, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }
    
    private static final AuthCredential i(final Intent intent) {
        Preconditions.k(intent);
        final zzxq zzxq = SafeParcelableSerializer.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", (android.os.Parcelable$Creator<zzxq>)com.google.android.gms.internal.firebase_auth_api.zzxq.CREATOR);
        zzxq.zze(true);
        return zze.P1((com.google.android.gms.internal.firebase-auth-api.zzxq)zzxq);
    }
    
    public final boolean f(final Activity activity, final TaskCompletionSource taskCompletionSource, final FirebaseAuth firebaseAuth, final FirebaseUser firebaseUser) {
        if (!this.a) {
            this.h(activity, new j(this, activity, taskCompletionSource, firebaseAuth, firebaseUser));
            return this.a = true;
        }
        return false;
    }
    
    public final boolean g(final Activity activity, final TaskCompletionSource taskCompletionSource) {
        if (!this.a) {
            this.h(activity, new k(this, activity, taskCompletionSource));
            return this.a = true;
        }
        return false;
    }
}
