// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.view.WindowInsets;
import android.view.View;
import android.app.Activity;
import android.view.View$OnApplyWindowInsetsListener;

public final class zzw implements View$OnApplyWindowInsetsListener
{
    public final zzx a;
    public final Activity b;
    
    public zzw(final zzx a, final Activity b) {
        this.a = a;
        this.b = b;
    }
    
    public final WindowInsets onApplyWindowInsets(final View view, final WindowInsets windowInsets) {
        return zzx.l(this.b, view, windowInsets);
    }
}
