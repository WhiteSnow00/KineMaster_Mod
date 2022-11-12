// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import android.content.Context;

public final class zzdy implements Runnable
{
    public final zzee a;
    public final Context b;
    public final OnInitializationCompleteListener c;
    
    public zzdy(final zzee a, final Context b, final String s, final OnInitializationCompleteListener c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        this.a.n(this.b, null, this.c);
    }
}
