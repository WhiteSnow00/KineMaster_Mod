// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class a extends zag
{
    final Intent a;
    final Activity b;
    final int c;
    
    a(final Intent a, final Activity b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final void a() {
        final Intent a = this.a;
        if (a != null) {
            this.b.startActivityForResult(a, this.c);
        }
    }
}
