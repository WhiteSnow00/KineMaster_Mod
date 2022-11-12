// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.firebase.auth.internal.zze;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import android.app.Activity;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.tasks.OnCompleteListener;

final class f implements OnCompleteListener
{
    final String a;
    final long b;
    final TimeUnit c;
    final PhoneAuthProvider.OnVerificationStateChangedCallbacks d;
    final Activity e;
    final Executor f;
    final boolean g;
    final FirebaseAuth h;
    
    f(final FirebaseAuth h, final String a, final long b, final TimeUnit c, final PhoneAuthProvider.OnVerificationStateChangedCallbacks d, final Activity e, final Executor f, final boolean g) {
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public final void onComplete(final Task task) {
        String a;
        String b;
        if (!task.t()) {
            String message;
            if (task.o() != null) {
                message = task.o().getMessage();
            }
            else {
                message = "";
            }
            Log.e("FirebaseAuth", "Error while validating application identity: ".concat(String.valueOf(message)));
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            a = null;
            b = null;
        }
        else {
            b = ((zze)task.p()).b();
            a = ((zze)task.p()).a();
        }
        this.h.I(this.a, this.b, this.c, this.d, this.e, this.f, this.g, a, b);
    }
}
