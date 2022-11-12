// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.math.IntMath;

public final class RtpPacket
{
    private static final byte[] l;
    public final byte a;
    public final boolean b;
    public final boolean c;
    public final byte d;
    public final boolean e;
    public final byte f;
    public final int g;
    public final long h;
    public final int i;
    public final byte[] j;
    public final byte[] k;
    
    static {
        l = new byte[0];
    }
    
    private RtpPacket(final Builder builder) {
        this.a = 2;
        this.b = Builder.a(builder);
        this.c = false;
        this.e = Builder.b(builder);
        this.f = Builder.c(builder);
        this.g = Builder.d(builder);
        this.h = Builder.e(builder);
        this.i = Builder.f(builder);
        final byte[] g = Builder.g(builder);
        this.j = g;
        this.d = (byte)(g.length / 4);
        this.k = Builder.h(builder);
    }
    
    RtpPacket(final Builder builder, final RtpPacket$a object) {
        this(builder);
    }
    
    static byte[] a() {
        return RtpPacket.l;
    }
    
    public static int b(final int n) {
        return IntMath.g(n + 1, 65536);
    }
    
    public static int c(final int n) {
        return IntMath.g(n - 1, 65536);
    }
    
    public static RtpPacket d(final ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 12) {
            return null;
        }
        final int d = parsableByteArray.D();
        final byte b = (byte)(d >> 6);
        boolean b2 = true;
        final boolean b3 = (d >> 5 & 0x1) == 0x1;
        final byte b4 = (byte)(d & 0xF);
        if (b != 2) {
            return null;
        }
        final int d2 = parsableByteArray.D();
        if ((d2 >> 7 & 0x1) != 0x1) {
            b2 = false;
        }
        final byte b5 = (byte)(d2 & 0x7F);
        final int j = parsableByteArray.J();
        final long f = parsableByteArray.F();
        final int n = parsableByteArray.n();
        byte[] l;
        if (b4 > 0) {
            final byte[] array = new byte[b4 * 4];
            byte b6 = 0;
            while (true) {
                l = array;
                if (b6 >= b4) {
                    break;
                }
                parsableByteArray.j(array, b6 * 4, 4);
                ++b6;
            }
        }
        else {
            l = RtpPacket.l;
        }
        final byte[] array2 = new byte[parsableByteArray.a()];
        parsableByteArray.j(array2, 0, parsableByteArray.a());
        return new Builder().l(b3).k(b2).n(b5).o(j).q(f).p(n).j(l).m(array2).i();
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && RtpPacket.class == o.getClass()) {
            final RtpPacket rtpPacket = (RtpPacket)o;
            if (this.f != rtpPacket.f || this.g != rtpPacket.g || this.e != rtpPacket.e || this.h != rtpPacket.h || this.i != rtpPacket.i) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final byte f = this.f;
        final int g = this.g;
        final int e = this.e ? 1 : 0;
        final long h = this.h;
        return ((((527 + f) * 31 + g) * 31 + e) * 31 + (int)(h ^ h >>> 32)) * 31 + this.i;
    }
    
    @Override
    public String toString() {
        return Util.C("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", this.f, this.g, this.h, this.i, this.e);
    }
    
    public static final class Builder
    {
        private boolean a;
        private boolean b;
        private byte c;
        private int d;
        private long e;
        private int f;
        private byte[] g;
        private byte[] h;
        
        public Builder() {
            this.g = RtpPacket.a();
            this.h = RtpPacket.a();
        }
        
        static boolean a(final Builder builder) {
            return builder.a;
        }
        
        static boolean b(final Builder builder) {
            return builder.b;
        }
        
        static byte c(final Builder builder) {
            return builder.c;
        }
        
        static int d(final Builder builder) {
            return builder.d;
        }
        
        static long e(final Builder builder) {
            return builder.e;
        }
        
        static int f(final Builder builder) {
            return builder.f;
        }
        
        static byte[] g(final Builder builder) {
            return builder.g;
        }
        
        static byte[] h(final Builder builder) {
            return builder.h;
        }
        
        public RtpPacket i() {
            return new RtpPacket(this, null);
        }
        
        public Builder j(final byte[] g) {
            Assertions.e(g);
            this.g = g;
            return this;
        }
        
        public Builder k(final boolean b) {
            this.b = b;
            return this;
        }
        
        public Builder l(final boolean a) {
            this.a = a;
            return this;
        }
        
        public Builder m(final byte[] h) {
            Assertions.e(h);
            this.h = h;
            return this;
        }
        
        public Builder n(final byte c) {
            this.c = c;
            return this;
        }
        
        public Builder o(final int n) {
            Assertions.a(n >= 0 && n <= 65535);
            this.d = (n & 0xFFFF);
            return this;
        }
        
        public Builder p(final int f) {
            this.f = f;
            return this;
        }
        
        public Builder q(final long e) {
            this.e = e;
            return this;
        }
    }
}
