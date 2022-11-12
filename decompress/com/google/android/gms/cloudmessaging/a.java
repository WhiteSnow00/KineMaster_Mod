// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Message;
import android.os.Looper;
import com.google.android.gms.internal.cloudmessaging.zzf;

final class a extends zzf
{
    final Rpc a;
    
    a(final Rpc a, final Looper looper) {
        this.a = a;
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        Rpc.d(this.a, message);
    }
}
