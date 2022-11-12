// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.internal.firebase_auth_api.zztq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;

final class g implements OnCompleteListener
{
    final PhoneAuthOptions a;
    final FirebaseAuth b;
    
    g(final FirebaseAuth b, final PhoneAuthOptions a) {
        this.b = b;
        this.a = a;
    }
    
    public final void onComplete(final Task task) {
        String b;
        String a;
        if (!task.t()) {
            String concat = "Error while validating application identity: ";
            if (task.o() != null) {
                concat = "Error while validating application identity: ".concat(String.valueOf(task.o().getMessage()));
            }
            Log.e("FirebaseAuth", concat);
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            b = null;
            a = null;
        }
        else {
            b = ((zze)task.p()).b();
            a = ((zze)task.p()).a();
        }
        final long longValue = this.a.h();
        final PhoneAuthProvider.OnVerificationStateChangedCallbacks t = FirebaseAuth.T(this.b, this.a.i(), this.a.f());
        final zzag zzag = Preconditions.k(this.a.d());
        if (zzag.zze()) {
            ((zztq)FirebaseAuth.U(this.b)).zzD(zzag, (String)Preconditions.k(this.a.i()), FirebaseAuth.Z(this.b), longValue, this.a.e() != null, this.a.k(), b, a, this.b.J(), t, this.a.j(), this.a.b());
            return;
        }
        ((zztq)FirebaseAuth.U(this.b)).zzE(zzag, (PhoneMultiFactorInfo)Preconditions.k(this.a.g()), FirebaseAuth.Z(this.b), longValue, this.a.e() != null, this.a.k(), b, a, this.b.J(), t, this.a.j(), this.a.b());
    }
}
