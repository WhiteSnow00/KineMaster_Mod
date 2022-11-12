// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.OnSuccessListener;

final class p implements OnSuccessListener
{
    final TaskCompletionSource a;
    
    p(final zzf zzf, final TaskCompletionSource a) {
        this.a = a;
    }
    
    public final /* bridge */ void onSuccess(final Object o) {
        this.a.c((Object)new zze(null, (String)o));
    }
}
