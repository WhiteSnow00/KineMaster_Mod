// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;

final class b implements StatusListener
{
    final BasePendingResult a;
    final zaad b;
    
    b(final zaad b, final BasePendingResult a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void a(final Status status) {
        zaad.a(this.b).remove(this.a);
    }
}
