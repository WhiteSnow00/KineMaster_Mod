// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.identifier;

import java.util.Iterator;
import android.net.Uri$Builder;
import android.net.Uri;
import java.util.Map;

final class a extends Thread
{
    final Map a;
    
    a(final AdvertisingIdClient advertisingIdClient, final Map a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final Map a = this.a;
        final Uri$Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (final String s : a.keySet()) {
            buildUpon.appendQueryParameter(s, (String)a.get(s));
        }
        zzc.a(buildUpon.build().toString());
    }
}
