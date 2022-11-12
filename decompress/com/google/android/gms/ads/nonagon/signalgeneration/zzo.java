// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.dynamic.IObjectWrapper;
import android.net.Uri;
import java.util.concurrent.Callable;

public final class zzo implements Callable
{
    public final zzz a;
    public final Uri b;
    public final IObjectWrapper c;
    
    public zzo(final zzz a, final Uri b, final IObjectWrapper c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object call() {
        return this.a.N1(this.b, this.c);
    }
}
