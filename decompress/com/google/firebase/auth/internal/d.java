// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.OnFailureListener;

final class d implements OnFailureListener
{
    final TaskCompletionSource a;
    final Context b;
    
    d(final zzax zzax, final TaskCompletionSource a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onFailure(final Exception ex) {
        this.a.b(ex);
        zzax.e(this.b);
    }
}
