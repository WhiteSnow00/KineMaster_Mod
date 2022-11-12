// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.OnSuccessListener;

final class g implements OnSuccessListener
{
    final TaskCompletionSource a;
    final Context b;
    
    g(final zzax zzax, final TaskCompletionSource a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    public final /* bridge */ void onSuccess(final Object o) {
        this.a.c((Object)o);
        zzax.e(this.b);
    }
}
