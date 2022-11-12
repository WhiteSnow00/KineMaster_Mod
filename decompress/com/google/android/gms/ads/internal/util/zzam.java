// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;

public final class zzam implements DialogInterface$OnCancelListener
{
    public final zzas a;
    
    public zzam(final zzas a) {
        this.a = a;
    }
    
    public final void onCancel(final DialogInterface dialogInterface) {
        this.a.r();
    }
}
