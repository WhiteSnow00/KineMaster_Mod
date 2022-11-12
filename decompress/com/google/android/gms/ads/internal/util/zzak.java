// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

public final class zzak implements DialogInterface$OnClickListener
{
    public final zzas a;
    
    public zzak(final zzas a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.r();
    }
}
