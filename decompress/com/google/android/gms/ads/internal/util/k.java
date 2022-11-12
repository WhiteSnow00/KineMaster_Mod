// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcfh;
import com.google.android.gms.internal.ads.zzcfi;
import java.io.IOException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import android.content.Context;

final class k extends zzb
{
    private final Context a;
    
    k(final Context a) {
        this.a = a;
    }
    
    @Override
    public final void zza() {
        boolean b = false;
        Label_0032: {
            try {
                b = AdvertisingIdClient.b(this.a);
                break Label_0032;
            }
            catch (final GooglePlayServicesRepairableException ex) {}
            catch (final GooglePlayServicesNotAvailableException ex) {}
            catch (final IllegalStateException ex) {}
            catch (final IOException ex2) {}
            final GooglePlayServicesRepairableException ex;
            zzcfi.zzh("Fail to get isAdIdFakeForDebugLogging", (Throwable)ex);
            b = false;
        }
        zzcfh.zzj(b);
        final StringBuilder sb = new StringBuilder();
        sb.append("Update ad debug logging enablement as ");
        sb.append(b);
        zzcfi.zzj(sb.toString());
    }
}
