// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.view.MotionEvent;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zzas;
import com.google.android.gms.common.util.VisibleForTesting;
import android.widget.RelativeLayout;

@VisibleForTesting
final class a extends RelativeLayout
{
    @VisibleForTesting
    final zzas a;
    @VisibleForTesting
    boolean b;
    
    public a(final Context context, final String s, final String s2, final String s3) {
        super(context);
        final zzas a = new zzas(context, s);
        (this.a = a).o(s2);
        a.n(s3);
    }
    
    public final boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        if (!this.b) {
            this.a.m(motionEvent);
        }
        return false;
    }
}
