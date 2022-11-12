// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import android.os.SystemClock;
import java.util.Comparator;
import java.util.Arrays;
import d4.a;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;

public abstract class BaseTrackSelection implements ExoTrackSelection
{
    protected final TrackGroup a;
    protected final int b;
    protected final int[] c;
    private final int d;
    private final Format[] e;
    private final long[] f;
    private int g;
    
    public BaseTrackSelection(final TrackGroup trackGroup, final int... array) {
        this(trackGroup, array, 0);
    }
    
    public BaseTrackSelection(final TrackGroup trackGroup, final int[] array, int i) {
        final int length = array.length;
        final int n = 0;
        Assertions.g(length > 0);
        this.d = i;
        this.a = Assertions.e(trackGroup);
        i = array.length;
        this.b = i;
        this.e = new Format[i];
        for (i = 0; i < array.length; ++i) {
            this.e[i] = trackGroup.c(array[i]);
        }
        Arrays.sort(this.e, (Comparator<? super Format>)d4.a.a);
        this.c = new int[this.b];
        i = n;
        int b;
        while (true) {
            b = this.b;
            if (i >= b) {
                break;
            }
            this.c[i] = trackGroup.d(this.e[i]);
            ++i;
        }
        this.f = new long[b];
    }
    
    public static int v(final Format format, final Format format2) {
        return w(format, format2);
    }
    
    private static int w(final Format format, final Format format2) {
        return format2.h - format.h;
    }
    
    @Override
    public boolean b(final int n, final long n2) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        int c = this.c(n, elapsedRealtime) ? 1 : 0;
        for (int n3 = 0; n3 < this.b && c == 0; ++n3) {
            if (n3 != n && !this.c(n3, elapsedRealtime)) {
                c = 1;
            }
            else {
                c = 0;
            }
        }
        if (c == 0) {
            return false;
        }
        final long[] f = this.f;
        f[n] = Math.max(f[n], Util.b(elapsedRealtime, n2, Long.MAX_VALUE));
        return true;
    }
    
    @Override
    public boolean c(final int n, final long n2) {
        return this.f[n] > n2;
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && this.getClass() == o.getClass()) {
            final BaseTrackSelection baseTrackSelection = (BaseTrackSelection)o;
            if (this.a != baseTrackSelection.a || !Arrays.equals(this.c, baseTrackSelection.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public final Format f(final int n) {
        return this.e[n];
    }
    
    @Override
    public final int g(final int n) {
        return this.c[n];
    }
    
    @Override
    public void h(final float n) {
    }
    
    @Override
    public int hashCode() {
        if (this.g == 0) {
            this.g = System.identityHashCode(this.a) * 31 + Arrays.hashCode(this.c);
        }
        return this.g;
    }
    
    @Override
    public final int k(final int n) {
        for (int i = 0; i < this.b; ++i) {
            if (this.c[i] == n) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public final TrackGroup l() {
        return this.a;
    }
    
    @Override
    public final int length() {
        return this.c.length;
    }
    
    @Override
    public void n() {
    }
    
    @Override
    public int o(final long n, final List<? extends MediaChunk> list) {
        return list.size();
    }
    
    @Override
    public final int p(final Format format) {
        for (int i = 0; i < this.b; ++i) {
            if (this.e[i] == format) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public final int r() {
        return this.c[this.a()];
    }
    
    @Override
    public final Format s() {
        return this.e[this.a()];
    }
}
