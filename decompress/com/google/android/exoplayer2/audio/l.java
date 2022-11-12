// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import android.media.AudioTimestamp;
import com.google.android.exoplayer2.util.Util;
import android.media.AudioTrack;

final class l
{
    private final a a;
    private int b;
    private long c;
    private long d;
    private long e;
    private long f;
    
    public l(final AudioTrack audioTrack) {
        if (Util.a >= 19) {
            this.a = new a(audioTrack);
            this.g();
        }
        else {
            this.a = null;
            this.h(3);
        }
    }
    
    private void h(final int b) {
        this.b = b;
        if (b != 0) {
            if (b != 1) {
                if (b != 2 && b != 3) {
                    if (b != 4) {
                        throw new IllegalStateException();
                    }
                    this.d = 500000L;
                }
                else {
                    this.d = 10000000L;
                }
            }
            else {
                this.d = 10000L;
            }
        }
        else {
            this.e = 0L;
            this.f = -1L;
            this.c = System.nanoTime() / 1000L;
            this.d = 10000L;
        }
    }
    
    public void a() {
        if (this.b == 4) {
            this.g();
        }
    }
    
    public long b() {
        final a a = this.a;
        long a2;
        if (a != null) {
            a2 = a.a();
        }
        else {
            a2 = -1L;
        }
        return a2;
    }
    
    public long c() {
        final a a = this.a;
        long b;
        if (a != null) {
            b = a.b();
        }
        else {
            b = -9223372036854775807L;
        }
        return b;
    }
    
    public boolean d() {
        return this.b == 2;
    }
    
    public boolean e(final long e) {
        final a a = this.a;
        boolean b2;
        final boolean b = b2 = false;
        if (a != null) {
            if (e - this.e < this.d) {
                b2 = b;
            }
            else {
                this.e = e;
                final boolean c = a.c();
                final int b3 = this.b;
                if (b3 != 0) {
                    if (b3 != 1) {
                        if (b3 != 2) {
                            if (b3 != 3) {
                                if (b3 != 4) {
                                    throw new IllegalStateException();
                                }
                            }
                            else if (c) {
                                this.g();
                            }
                        }
                        else if (!c) {
                            this.g();
                        }
                    }
                    else if (c) {
                        if (this.a.a() > this.f) {
                            this.h(2);
                        }
                    }
                    else {
                        this.g();
                    }
                }
                else if (c) {
                    b2 = b;
                    if (this.a.b() < this.c) {
                        return b2;
                    }
                    this.f = this.a.a();
                    this.h(1);
                }
                else if (e - this.c > 500000L) {
                    this.h(3);
                }
                b2 = c;
            }
        }
        return b2;
    }
    
    public void f() {
        this.h(4);
    }
    
    public void g() {
        if (this.a != null) {
            this.h(0);
        }
    }
    
    private static final class a
    {
        private final AudioTrack a;
        private final AudioTimestamp b;
        private long c;
        private long d;
        private long e;
        
        public a(final AudioTrack a) {
            this.a = a;
            this.b = new AudioTimestamp();
        }
        
        public long a() {
            return this.e;
        }
        
        public long b() {
            return this.b.nanoTime / 1000L;
        }
        
        public boolean c() {
            final boolean timestamp = this.a.getTimestamp(this.b);
            if (timestamp) {
                final long framePosition = this.b.framePosition;
                if (this.d > framePosition) {
                    ++this.c;
                }
                this.d = framePosition;
                this.e = framePosition + (this.c << 32);
            }
            return timestamp;
        }
    }
}
