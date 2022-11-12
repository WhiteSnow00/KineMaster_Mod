// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzt;
import android.os.Message;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzfnu;

public final class zzf extends zzfnu
{
    public zzf(final Looper looper) {
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        try {
            super.handleMessage(message);
        }
        catch (final Exception ex) {
            zzt.p().zzt((Throwable)ex, "AdMobHandler.handleMessage");
        }
    }
    
    protected final void zza(final Message message) {
        try {
            super.zza(message);
        }
        finally {
            zzt.q();
            final Throwable t;
            zzs.h(zzt.p().zzc(), t);
        }
    }
}
