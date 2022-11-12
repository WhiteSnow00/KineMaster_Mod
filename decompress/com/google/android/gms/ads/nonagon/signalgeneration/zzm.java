// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.List;
import com.google.android.gms.internal.ads.zzfoi;

public final class zzm implements zzfoi
{
    public final zzz a;
    public final List b;
    
    public zzm(final zzz a, final List b) {
        this.a = a;
        this.b = b;
    }
    
    public final Object apply(final Object o) {
        return this.a.M0(this.b, (String)o);
    }
}
