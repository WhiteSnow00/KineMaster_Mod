// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Bundle;
import android.os.IInterface;
import android.os.IBinder;
import android.content.ComponentName;
import com.google.android.gms.common.util.VisibleForTesting;
import android.content.ServiceConnection;

@VisibleForTesting
public final class zze implements ServiceConnection
{
    private final int a;
    final BaseGmsClient b;
    
    public zze(final BaseGmsClient b, final int a) {
        this.b = b;
        this.a = a;
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        final BaseGmsClient b = this.b;
        if (binder == null) {
            BaseGmsClient.zzk((BaseGmsClient<IInterface>)b, 16);
            return;
        }
        synchronized (BaseGmsClient.zzd((BaseGmsClient<IInterface>)b)) {
            final BaseGmsClient b2 = this.b;
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IGmsServiceBroker gmsServiceBroker;
            if (queryLocalInterface != null && queryLocalInterface instanceof IGmsServiceBroker) {
                gmsServiceBroker = (IGmsServiceBroker)queryLocalInterface;
            }
            else {
                gmsServiceBroker = new j(binder);
            }
            BaseGmsClient.zzh((BaseGmsClient<IInterface>)b2, gmsServiceBroker);
            monitorexit(BaseGmsClient.zzd((BaseGmsClient<IInterface>)b));
            this.b.zzl(0, null, this.a);
        }
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        synchronized (BaseGmsClient.zzd((BaseGmsClient<IInterface>)this.b)) {
            BaseGmsClient.zzh((BaseGmsClient<IInterface>)this.b, (IGmsServiceBroker)null);
            monitorexit(BaseGmsClient.zzd((BaseGmsClient<IInterface>)this.b));
            final Handler zzb = this.b.zzb;
            zzb.sendMessage(zzb.obtainMessage(6, this.a, 1));
        }
    }
}
