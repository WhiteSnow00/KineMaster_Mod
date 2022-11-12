// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.FirebaseNetworkException;
import com.google.android.gms.tasks.OnFailureListener;

final class b implements OnFailureListener
{
    final c a;
    
    b(final c a) {
        this.a = a;
    }
    
    public final void onFailure(final Exception ex) {
        if (ex instanceof FirebaseNetworkException) {
            zzam.a().g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.a.b.d();
        }
    }
}
