// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;
import android.content.DialogInterface$OnClickListener;

public final class zzal implements DialogInterface$OnClickListener
{
    public final zzas a;
    public final AtomicInteger b;
    public final int c;
    public final int d;
    public final int e;
    
    public zzal(final zzas a, final AtomicInteger b, final int c, final int d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.h(this.b, this.c, this.d, this.e, dialogInterface, n);
    }
}
