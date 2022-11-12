// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

final class x implements Runnable
{
    final int a;
    final zabq b;
    
    x(final zabq b, final int a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        zabq.x(this.b, this.a);
    }
}
