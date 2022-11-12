// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzfoi;

public final class zzl implements zzfoi
{
    public final zzz a;
    public final Uri b;
    
    public zzl(final zzz a, final Uri b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return zzz.C1(this.b, (String)o);
    }
}
