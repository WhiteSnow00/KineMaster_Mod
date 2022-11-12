// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.OnCompleteListener;

final class c implements OnCompleteListener
{
    final TaskCompletionSource a;
    final zaad b;
    
    c(final zaad b, final TaskCompletionSource a) {
        this.b = b;
        this.a = a;
    }
    
    public final void onComplete(final Task task) {
        zaad.b(this.b).remove(this.a);
    }
}
