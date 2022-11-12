// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.auth.api.signin.internal.zbt;
import android.util.Log;
import android.os.IBinder;
import android.content.Intent;
import android.app.Service;

public final class RevocationBoundService extends Service
{
    public IBinder onBind(final Intent intent) {
        if (!"com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) && !"com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            Log.w("RevocationService", "Unknown action sent to RevocationBoundService: ".concat(String.valueOf(intent.getAction())));
            return null;
        }
        if (Log.isLoggable("RevocationService", 2)) {
            Log.v("RevocationService", "RevocationBoundService handling ".concat(String.valueOf(intent.getAction())));
        }
        return (IBinder)new zbt((Context)this);
    }
}
