// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import com.google.android.gms.internal.ads.zzgqi;
import androidx.browser.customtabs.d;
import android.net.Uri;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbiw;
import com.google.android.gms.internal.ads.zzbiu;

final class m implements zzbiu
{
    final zzbiw a;
    final Context b;
    final Uri c;
    
    m(final zzs zzs, final zzbiw a, final Context b, final Uri c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void zza() {
        final d a = new d.a(this.a.zza()).a();
        a.a.setPackage(zzgqi.zza(this.b));
        a.a(this.b, this.c);
        this.a.zzf((Activity)this.b);
    }
}
