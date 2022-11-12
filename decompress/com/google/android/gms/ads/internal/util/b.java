// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.client.zze;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzcx;

final class b extends zzcx
{
    final Context a;
    final zzaw b;
    
    b(final zzaw b, final Context a) {
        this.b = b;
        this.a = a;
    }
    
    public final void y(final zze zze) {
        if (zze == null) {
            return;
        }
        this.b.i(this.a, zze.b, true, true);
    }
}
