// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

public final class zzap implements DialogInterface$OnClickListener
{
    public final zzas a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    
    public zzap(final zzas a, final int b, final int c, final int d, final int e, final int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.j(this.b, this.c, this.d, this.e, this.f, dialogInterface, n);
    }
}
