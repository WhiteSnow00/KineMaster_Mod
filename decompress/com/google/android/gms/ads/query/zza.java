// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.query;

import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdFormat;
import android.content.Context;

public final class zza implements Runnable
{
    public final Context a;
    public final AdFormat b;
    public final AdRequest c;
    public final QueryInfoGenerationCallback d;
    
    public zza(final Context a, final AdFormat b, final AdRequest c, final QueryInfoGenerationCallback d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        final Context a = this.a;
        final AdFormat b = this.b;
        final AdRequest c = this.c;
        final QueryInfoGenerationCallback d = this.d;
        zzdr a2;
        if (c == null) {
            a2 = null;
        }
        else {
            a2 = c.a();
        }
        new zzbyl(a, b, a2).zzb(d);
    }
}
