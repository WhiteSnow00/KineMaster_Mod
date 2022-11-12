// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

public final class zzi implements Runnable
{
    public final b a;
    public final Drawable b;
    
    public zzi(final b a, final Drawable b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.a.a.getWindow().setBackgroundDrawable(this.b);
    }
}
