// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

final class c implements View$OnTouchListener
{
    final zzs a;
    
    c(final zzs a) {
        this.a = a;
    }
    
    public final boolean onTouch(final View view, final MotionEvent motionEvent) {
        final zzs a = this.a;
        if (zzs.r1(a) != null) {
            zzs.r1(a).zzd(motionEvent);
        }
        return false;
    }
}
