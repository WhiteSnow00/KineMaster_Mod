// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager
{
    private final Object a;
    private final PriorityQueue<Integer> b;
    private int c;
    
    public PriorityTaskManager() {
        this.a = new Object();
        this.b = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        this.c = Integer.MIN_VALUE;
    }
    
    public void a(final int n) {
        synchronized (this.a) {
            this.b.add(n);
            this.c = Math.max(this.c, n);
        }
    }
    
    public void b(final int n) throws InterruptedException {
        synchronized (this.a) {
            while (this.c != n) {
                this.a.wait();
            }
        }
    }
    
    public void c(final int n) throws PriorityTooLowException {
        synchronized (this.a) {
            if (this.c == n) {
                return;
            }
            throw new PriorityTooLowException(n, this.c);
        }
    }
    
    public void d(int intValue) {
        synchronized (this.a) {
            this.b.remove(intValue);
            if (this.b.isEmpty()) {
                intValue = Integer.MIN_VALUE;
            }
            else {
                intValue = Util.j(this.b.peek());
            }
            this.c = intValue;
            this.a.notifyAll();
        }
    }
    
    public static class PriorityTooLowException extends IOException
    {
        public PriorityTooLowException(final int n, final int n2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Priority too low [priority=");
            sb.append(n);
            sb.append(", highest=");
            sb.append(n2);
            sb.append("]");
            super(sb.toString());
        }
    }
}
