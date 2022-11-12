// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class j extends h
{
    private static final WeakReference c;
    private WeakReference b;
    
    static {
        c = new WeakReference(null);
    }
    
    j(final byte[] array) {
        super(array);
        this.b = j.c;
    }
    
    @Override
    final byte[] q1() {
        synchronized (this) {
            byte[] r1;
            if ((r1 = (byte[])this.b.get()) == null) {
                r1 = this.r1();
                this.b = new WeakReference(r1);
            }
            return r1;
        }
    }
    
    protected abstract byte[] r1();
}
