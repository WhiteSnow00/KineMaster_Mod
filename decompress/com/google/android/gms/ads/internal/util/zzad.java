// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

public final class zzad implements DialogInterface$OnClickListener
{
    public final zzas a;
    public final String b;
    
    public zzad(final zzas a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.i(this.b, dialogInterface, n);
    }
}
