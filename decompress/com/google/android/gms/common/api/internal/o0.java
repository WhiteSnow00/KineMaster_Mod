// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class o0 extends zabw
{
    final Dialog a;
    final p0 b;
    
    o0(final p0 b, final Dialog a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void a() {
        zap.r(this.b.b);
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
