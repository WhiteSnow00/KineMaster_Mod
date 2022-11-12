// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

final class s0 implements Runnable
{
    final a a;
    
    s0(final a a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        com.google.android.gms.common.api.internal.a.t(this.a).lock();
        try {
            com.google.android.gms.common.api.internal.a.z(this.a);
        }
        finally {
            com.google.android.gms.common.api.internal.a.t(this.a).unlock();
        }
    }
}
