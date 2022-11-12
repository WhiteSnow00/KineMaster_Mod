// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.FirebaseApp;
import com.google.android.gms.common.internal.Preconditions;

final class c implements Runnable
{
    private final String a;
    final zzam b;
    
    c(final zzam b, final String s) {
        this.b = b;
        this.a = Preconditions.g(s);
    }
    
    @Override
    public final void run() {
        final FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.n(this.a));
        if (instance.h() != null) {
            final Task a = instance.a(true);
            zzam.a().g("Token refreshing started", new Object[0]);
            a.f((OnFailureListener)new b(this));
        }
    }
}
