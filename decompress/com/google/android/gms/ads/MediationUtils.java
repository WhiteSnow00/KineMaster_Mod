// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import java.util.Iterator;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import java.util.List;
import android.content.Context;

public class MediationUtils
{
    public static AdSize a(final Context context, AdSize adSize, final List<AdSize> list) {
        final AdSize adSize2 = null;
        final AdSize adSize3 = null;
        AdSize adSize4 = adSize2;
        if (list != null) {
            if (adSize == null) {
                adSize4 = adSize2;
            }
            else {
                AdSize adSize5 = adSize;
                if (!adSize.m()) {
                    adSize5 = adSize;
                    if (!adSize.n()) {
                        final float density = context.getResources().getDisplayMetrics().density;
                        adSize5 = new AdSize(Math.round(adSize.d(context) / density), Math.round(adSize.b(context) / density));
                    }
                }
                final Iterator<AdSize> iterator = list.iterator();
                AdSize adSize6 = adSize3;
                while (true) {
                    adSize4 = adSize6;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    adSize = iterator.next();
                    if (adSize == null) {
                        continue;
                    }
                    final int c = adSize5.c();
                    final int c2 = adSize.c();
                    final int a = adSize5.a();
                    final int a2 = adSize.a();
                    if (c * 0.5 > c2 || c < c2) {
                        continue;
                    }
                    if (adSize5.n()) {
                        final int f = adSize5.f();
                        if ((int)zzay.c().zzb(zzbhy.zzgA) > c2 || (int)zzay.c().zzb(zzbhy.zzgB) > a2 || f < a2) {
                            continue;
                        }
                    }
                    else if (adSize5.m()) {
                        if (adSize5.g() < a2) {
                            continue;
                        }
                    }
                    else {
                        if (a * 0.7 > a2) {
                            continue;
                        }
                        if (a < a2) {
                            continue;
                        }
                    }
                    if (adSize6 != null) {
                        if (adSize6.c() * adSize6.a() > adSize.c() * adSize.a()) {
                            continue;
                        }
                    }
                    adSize6 = adSize;
                }
            }
        }
        return adSize4;
    }
}
