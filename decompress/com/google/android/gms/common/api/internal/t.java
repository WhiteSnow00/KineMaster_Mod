// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class t
{
    private final zabf a;
    
    protected t(final zabf a) {
        this.a = a;
    }
    
    protected abstract void a();
    
    public final void b(zabi o) {
        zabi.l((zabi)o).lock();
        try {
            if (zabi.k((zabi)o) != this.a) {
                o = zabi.l((zabi)o);
            }
            else {
                this.a();
                o = zabi.l((zabi)o);
            }
            ((Lock)o).unlock();
        }
        finally {
            zabi.l((zabi)o).unlock();
        }
    }
}
