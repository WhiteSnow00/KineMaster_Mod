// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.Context;

public final class zzh implements Runnable
{
    public final zzj a;
    public final Context b;
    public final String c;
    
    public zzh(final zzj a, final Context b, final String s) {
        this.a = a;
        this.b = b;
        this.c = "admob";
    }
    
    @Override
    public final void run() {
        this.a.t(this.b, this.c);
    }
}
