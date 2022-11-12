// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.util.Log;
import android.app.PendingIntent;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import android.os.Message;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;

final class k extends zzi
{
    final BaseGmsClient a;
    
    public k(final BaseGmsClient a, final Looper looper) {
        this.a = a;
        super(looper);
    }
    
    private static final void a(final Message message) {
        final zzc zzc = (zzc)message.obj;
        zzc.b();
        zzc.e();
    }
    
    private static final boolean b(final Message message) {
        final int what = message.what;
        return what == 2 || what == 1 || what == 7;
    }
    
    public final void handleMessage(final Message message) {
        if (this.a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
            }
            return;
        }
        final int what = message.what;
        if ((what == 1 || what == 7 || (what == 4 && !this.a.enableLocalFallback()) || message.what == 5) && !this.a.isConnecting()) {
            a(message);
            return;
        }
        final int what2 = message.what;
        PendingIntent pendingIntent = null;
        if (what2 == 4) {
            BaseGmsClient.zzg((BaseGmsClient<IInterface>)this.a, new ConnectionResult(message.arg2));
            if (BaseGmsClient.zzo((BaseGmsClient<IInterface>)this.a)) {
                final BaseGmsClient a = this.a;
                if (!BaseGmsClient.zzm((BaseGmsClient<IInterface>)a)) {
                    BaseGmsClient.zzi((BaseGmsClient<IInterface>)a, 3, (IInterface)null);
                    return;
                }
            }
            final BaseGmsClient a2 = this.a;
            ConnectionResult zza;
            if (BaseGmsClient.zza((BaseGmsClient<IInterface>)a2) != null) {
                zza = BaseGmsClient.zza((BaseGmsClient<IInterface>)a2);
            }
            else {
                zza = new ConnectionResult(8);
            }
            this.a.zzc.a(zza);
            this.a.onConnectionFailed(zza);
            return;
        }
        if (what2 == 5) {
            final BaseGmsClient a3 = this.a;
            ConnectionResult zza2;
            if (BaseGmsClient.zza((BaseGmsClient<IInterface>)a3) != null) {
                zza2 = BaseGmsClient.zza((BaseGmsClient<IInterface>)a3);
            }
            else {
                zza2 = new ConnectionResult(8);
            }
            this.a.zzc.a(zza2);
            this.a.onConnectionFailed(zza2);
            return;
        }
        if (what2 == 3) {
            final Object obj = message.obj;
            if (obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent)obj;
            }
            final ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
            this.a.zzc.a(connectionResult);
            this.a.onConnectionFailed(connectionResult);
            return;
        }
        if (what2 == 6) {
            BaseGmsClient.zzi((BaseGmsClient<IInterface>)this.a, 5, (IInterface)null);
            final BaseGmsClient a4 = this.a;
            if (BaseGmsClient.zzb((BaseGmsClient<IInterface>)a4) != null) {
                BaseGmsClient.zzb((BaseGmsClient<IInterface>)a4).onConnectionSuspended(message.arg2);
            }
            this.a.onConnectionSuspended(message.arg2);
            BaseGmsClient.zzn((BaseGmsClient<IInterface>)this.a, 5, 1, (IInterface)null);
            return;
        }
        if (what2 == 2 && !this.a.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((zzc)message.obj).c();
            return;
        }
        final int what3 = message.what;
        final StringBuilder sb = new StringBuilder();
        sb.append("Don't know how to handle message: ");
        sb.append(what3);
        Log.wtf("GmsClient", sb.toString(), (Throwable)new Exception());
    }
}
