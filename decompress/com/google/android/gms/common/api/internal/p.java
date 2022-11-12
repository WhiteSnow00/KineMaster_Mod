// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class p implements Runnable
{
    final zaaw a;
    
    p(final zaaw a, final zaau zaau) {
        this.a = a;
    }
    
    protected abstract void a();
    
    @Override
    public final void run() {
        zaaw.z(this.a).lock();
        while (true) {
            try {
                try {
                    Lock lock;
                    if (Thread.interrupted()) {
                        lock = zaaw.z(this.a);
                    }
                    else {
                        this.a();
                        lock = zaaw.z(this.a);
                    }
                    lock.unlock();
                    return;
                }
                finally {}
            }
            catch (final RuntimeException ex) {
                zaaw.u(this.a).q(ex);
                final Lock lock = zaaw.z(this.a);
                continue;
            }
            break;
        }
        zaaw.z(this.a).unlock();
    }
}
