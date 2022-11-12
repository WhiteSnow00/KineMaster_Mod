// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.Iterator;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzfhq;
import android.net.Uri;
import java.util.List;
import javax.annotation.Nonnull;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzfuw;

final class e implements zzfuw
{
    final zzbyj a;
    final boolean b;
    final zzz c;
    
    e(final zzz c, final zzbyj a, final boolean b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public final void zza(final Throwable t) {
        try {
            final zzbyj a = this.a;
            final String message = t.getMessage();
            final StringBuilder sb = new StringBuilder();
            sb.append("Internal error: ");
            sb.append(message);
            a.zze(sb.toString());
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("", (Throwable)ex);
        }
    }
    
    public final /* bridge */ void zzb(@Nonnull final Object o) {
        final List list = (List)o;
        try {
            zzz.s1(this.c, list);
            this.a.zzf(list);
            if (zzz.y1(this.c) || this.b) {
                for (final Uri uri : list) {
                    if (this.c.A1(uri)) {
                        final zzz c = this.c;
                        zzz.R1(this.c).zzc(zzz.M1(c, uri, zzz.X1(c), "1").toString(), (zzfhq)null);
                    }
                    else {
                        if (!(boolean)zzay.c().zzb(zzbhy.zzgt)) {
                            continue;
                        }
                        zzz.R1(this.c).zzc(uri.toString(), (zzfhq)null);
                    }
                }
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("", (Throwable)ex);
        }
    }
}
