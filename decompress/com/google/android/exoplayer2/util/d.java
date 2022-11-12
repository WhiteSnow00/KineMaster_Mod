// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.os.Message;
import java.util.ArrayList;
import android.os.Handler;
import java.util.List;

final class d implements HandlerWrapper
{
    private static final List<b> b;
    private final Handler a;
    
    static {
        b = new ArrayList<b>(50);
    }
    
    public d(final Handler a) {
        this.a = a;
    }
    
    static void l(final b b) {
        n(b);
    }
    
    private static b m() {
        final List<b> b = d.b;
        synchronized (b) {
            b b2;
            if (b.isEmpty()) {
                b2 = new b(null);
            }
            else {
                b2 = b.remove(b.size() - 1);
            }
            return b2;
        }
    }
    
    private static void n(final b b) {
        final List<b> b2 = d.b;
        synchronized (b2) {
            if (b2.size() < 50) {
                b2.add(b);
            }
        }
    }
    
    @Override
    public Message a(final int n) {
        return m().d(this.a.obtainMessage(n), this);
    }
    
    @Override
    public boolean b(final Message message) {
        return ((b)message).c(this.a);
    }
    
    @Override
    public boolean c(final int n) {
        return this.a.hasMessages(n);
    }
    
    @Override
    public Message d(final int n, final int n2, final int n3, final Object o) {
        return m().d(this.a.obtainMessage(n, n2, n3, o), this);
    }
    
    @Override
    public Message e(final int n, final Object o) {
        return m().d(this.a.obtainMessage(n, o), this);
    }
    
    @Override
    public void f(final Object o) {
        this.a.removeCallbacksAndMessages(o);
    }
    
    @Override
    public Message g(final int n, final int n2, final int n3) {
        return m().d(this.a.obtainMessage(n, n2, n3), this);
    }
    
    @Override
    public boolean h(final Runnable runnable) {
        return this.a.post(runnable);
    }
    
    @Override
    public boolean i(final int n) {
        return this.a.sendEmptyMessage(n);
    }
    
    @Override
    public boolean j(final int n, final long n2) {
        return this.a.sendEmptyMessageAtTime(n, n2);
    }
    
    @Override
    public void k(final int n) {
        this.a.removeMessages(n);
    }
    
    private static final class b implements Message
    {
        private android.os.Message a;
        private d b;
        
        private b() {
        }
        
        b(final d$a object) {
            this();
        }
        
        private void b() {
            this.a = null;
            this.b = null;
            d.l(this);
        }
        
        @Override
        public void a() {
            Assertions.e(this.a).sendToTarget();
            this.b();
        }
        
        public boolean c(final Handler handler) {
            final boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((android.os.Message)Assertions.e(this.a));
            this.b();
            return sendMessageAtFrontOfQueue;
        }
        
        public b d(final android.os.Message a, final d b) {
            this.a = a;
            this.b = b;
            return this;
        }
    }
}
