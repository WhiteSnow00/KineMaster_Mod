// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DefaultAllocator;

public class DefaultLoadControl implements LoadControl
{
    private final DefaultAllocator a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final boolean g;
    private final long h;
    private final boolean i;
    private int j;
    private boolean k;
    
    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }
    
    protected DefaultLoadControl(final DefaultAllocator a, final int n, final int n2, final int n3, final int n4, int n5, final boolean g, final int n6, final boolean i) {
        a(n3, 0, "bufferForPlaybackMs", "0");
        a(n4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(n, n3, "minBufferMs", "bufferForPlaybackMs");
        a(n, n4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(n2, n, "maxBufferMs", "minBufferMs");
        a(n6, 0, "backBufferDurationMs", "0");
        this.a = a;
        this.b = Util.C0(n);
        this.c = Util.C0(n2);
        this.d = Util.C0(n3);
        this.e = Util.C0(n4);
        this.f = n5;
        if (n5 == -1) {
            n5 = 13107200;
        }
        this.j = n5;
        this.g = g;
        this.h = Util.C0(n6);
        this.i = i;
    }
    
    private static void a(final int n, final int n2, final String s, final String s2) {
        final boolean b = n >= n2;
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" cannot be less than ");
        sb.append(s2);
        Assertions.b(b, sb.toString());
    }
    
    private static int k(final int n) {
        switch (n) {
            default: {
                throw new IllegalArgumentException();
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                return 131072;
            }
            case 2: {
                return 131072000;
            }
            case 1: {
                return 13107200;
            }
            case 0: {
                return 144310272;
            }
            case -2: {
                return 0;
            }
        }
    }
    
    private void l(final boolean b) {
        int f;
        if ((f = this.f) == -1) {
            f = 13107200;
        }
        this.j = f;
        this.k = false;
        if (b) {
            this.a.g();
        }
    }
    
    @Override
    public void b() {
        this.l(true);
    }
    
    @Override
    public boolean c() {
        return this.i;
    }
    
    @Override
    public long d() {
        return this.h;
    }
    
    @Override
    public void e(final Renderer[] array, final TrackGroupArray trackGroupArray, final ExoTrackSelection[] array2) {
        int j;
        if ((j = this.f) == -1) {
            j = this.j(array, array2);
        }
        this.j = j;
        this.a.h(j);
    }
    
    @Override
    public boolean f(long n, final float n2, final boolean b, final long n3) {
        final long f0 = Util.f0(n, n2);
        if (b) {
            n = this.e;
        }
        else {
            n = this.d;
        }
        long min = n;
        if (n3 != -9223372036854775807L) {
            min = Math.min(n3 / 2L, n);
        }
        return min <= 0L || f0 >= min || (!this.g && this.a.f() >= this.j);
    }
    
    @Override
    public Allocator g() {
        return this.a;
    }
    
    @Override
    public void h() {
        this.l(true);
    }
    
    @Override
    public boolean i(long n, final long n2, final float n3) {
        final int f = this.a.f();
        final int j = this.j;
        final boolean b = true;
        final boolean b2 = f >= j;
        n = this.b;
        if (n3 > 1.0f) {
            n = Math.min(Util.a0(n, n3), this.c);
        }
        if (n2 < Math.max(n, 500000L)) {
            boolean k = b;
            if (!this.g) {
                k = (!b2 && b);
            }
            this.k = k;
            if (!k && n2 < 500000L) {
                Log.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        }
        else if (n2 >= this.c || b2) {
            this.k = false;
        }
        return this.k;
    }
    
    protected int j(final Renderer[] array, final ExoTrackSelection[] array2) {
        int i = 0;
        int n = 0;
        while (i < array.length) {
            int n2 = n;
            if (array2[i] != null) {
                n2 = n + k(array[i].f());
            }
            ++i;
            n = n2;
        }
        return Math.max(13107200, n);
    }
    
    @Override
    public void onPrepared() {
        this.l(false);
    }
    
    public static final class Builder
    {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private int g;
        private boolean h;
        
        public Builder() {
            this.a = 50000;
            this.b = 50000;
            this.c = 2500;
            this.d = 5000;
            this.e = -1;
            this.f = false;
            this.g = 0;
            this.h = false;
        }
    }
}
