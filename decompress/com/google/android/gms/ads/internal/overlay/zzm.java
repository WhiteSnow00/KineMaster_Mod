// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.ads.zzdjf;
import com.google.android.gms.ads.internal.util.zzs;
import android.app.Activity;
import com.google.android.gms.common.util.PlatformVersion;
import android.os.Parcelable;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzt;
import android.content.Context;

public final class zzm
{
    public static final void a(final Context context, final AdOverlayInfoParcel adOverlayInfoParcel, final boolean b) {
        if (adOverlayInfoParcel.p == 4 && adOverlayInfoParcel.c == null) {
            final com.google.android.gms.ads.internal.client.zza b2 = adOverlayInfoParcel.b;
            if (b2 != null) {
                b2.onAdClicked();
            }
            final zzdjf j = adOverlayInfoParcel.J;
            if (j != null) {
                j.zzq();
            }
            final Activity zzk = adOverlayInfoParcel.d.zzk();
            final zzc a = adOverlayInfoParcel.a;
            Object o = context;
            if (a != null) {
                o = context;
                if (a.j) {
                    o = context;
                    if (zzk != null) {
                        o = zzk;
                    }
                }
            }
            zzt.j();
            final zzc a2 = adOverlayInfoParcel.a;
            final zzw i = adOverlayInfoParcel.i;
            zzu k;
            if (a2 != null) {
                k = a2.i;
            }
            else {
                k = null;
            }
            zza.b((Context)o, a2, i, k);
            return;
        }
        final Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.x.zzd);
        intent.putExtra("shouldCallOnOverlayOpened", b);
        final Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", (Parcelable)adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!PlatformVersion.f()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzt.q();
        zzs.i(context, intent);
    }
}
