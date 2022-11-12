// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzfnu;
import com.google.android.gms.ads.internal.zzt;
import android.net.Uri;
import java.util.concurrent.Callable;

public final class zzl implements Callable
{
    public final Uri a;
    
    public zzl(final Uri a) {
        this.a = a;
    }
    
    @Override
    public final Object call() {
        final Uri a = this.a;
        final zzfnu i = zzs.i;
        zzt.q();
        return zzs.k(a);
    }
}
