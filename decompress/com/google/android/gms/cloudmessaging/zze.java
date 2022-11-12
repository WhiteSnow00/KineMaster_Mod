// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver$PendingResult;
import android.content.Context;
import android.content.Intent;

public final class zze implements Runnable
{
    public final CloudMessagingReceiver a;
    public final Intent b;
    public final Context c;
    public final boolean d;
    public final BroadcastReceiver$PendingResult e;
    
    public zze(final CloudMessagingReceiver a, final Intent b, final Context c, final boolean d, final BroadcastReceiver$PendingResult e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public final void run() {
        this.a.d(this.b, this.c, this.d, this.e);
    }
}
