// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.Comparator;
import java.util.TreeSet;

final class d
{
    private final TreeSet<a> a;
    private int b;
    private int c;
    private boolean d;
    
    public d() {
        this.a = new TreeSet<a>(com.google.android.exoplayer2.source.rtsp.c.a);
        this.g();
    }
    
    public static int a(final a a, final a a2) {
        return d(a, a2);
    }
    
    private void b(final a a) {
        synchronized (this) {
            this.b = a.a.g;
            this.a.add(a);
        }
    }
    
    private static int c(int n, final int n2) {
        final int n3 = n - n2;
        if (Math.abs(n3) > 1000) {
            final int n4 = Math.min(n, n2) - Math.max(n, n2) + 65535;
            if (n4 < 1000) {
                if (n < n2) {
                    n = n4;
                }
                else {
                    n = -n4;
                }
                return n;
            }
        }
        return n3;
    }
    
    private static int d(final a a, final a a2) {
        return c(a.a.g, a2.a.g);
    }
    
    public boolean e(final RtpPacket rtpPacket, final long n) {
        synchronized (this) {
            if (this.a.size() >= 5000) {
                throw new IllegalStateException("Queue size limit of 5000 reached.");
            }
            final int g = rtpPacket.g;
            if (!this.d) {
                this.g();
                this.c = RtpPacket.c(g);
                this.d = true;
                this.b(new a(rtpPacket, n));
                return true;
            }
            if (Math.abs(c(g, RtpPacket.b(this.b))) >= 1000) {
                this.c = RtpPacket.c(g);
                this.a.clear();
                this.b(new a(rtpPacket, n));
                return true;
            }
            if (c(g, this.c) > 0) {
                this.b(new a(rtpPacket, n));
                return true;
            }
            return false;
        }
    }
    
    public RtpPacket f(final long n) {
        synchronized (this) {
            if (this.a.isEmpty()) {
                return null;
            }
            final a a = this.a.first();
            final int g = a.a.g;
            if (g != RtpPacket.b(this.c) && n < a.b) {
                return null;
            }
            this.a.pollFirst();
            this.c = g;
            return a.a;
        }
    }
    
    public void g() {
        synchronized (this) {
            this.a.clear();
            this.d = false;
            this.c = -1;
            this.b = -1;
        }
    }
    
    private static final class a
    {
        public final RtpPacket a;
        public final long b;
        
        public a(final RtpPacket a, final long b) {
            this.a = a;
            this.b = b;
        }
    }
}
