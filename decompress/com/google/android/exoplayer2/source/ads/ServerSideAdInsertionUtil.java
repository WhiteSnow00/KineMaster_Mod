// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaPeriodId;

public final class ServerSideAdInsertionUtil
{
    private ServerSideAdInsertionUtil() {
    }
    
    public static int a(final AdPlaybackState adPlaybackState, int b) {
        if ((b = adPlaybackState.c(b).b) == -1) {
            b = 0;
        }
        return b;
    }
    
    public static long b(long n, final MediaPeriodId mediaPeriodId, final AdPlaybackState adPlaybackState) {
        if (mediaPeriodId.b()) {
            n = c(n, mediaPeriodId.b, mediaPeriodId.c, adPlaybackState);
        }
        else {
            n = d(n, mediaPeriodId.e, adPlaybackState);
        }
        return n;
    }
    
    public static long c(long n, int n2, final int n3, final AdPlaybackState adPlaybackState) {
        final AdPlaybackState.AdGroup c = adPlaybackState.c(n2);
        n -= c.a;
        int e = adPlaybackState.e;
        int n4;
        while (true) {
            n4 = 0;
            final int n5 = 0;
            if (e >= n2) {
                break;
            }
            final AdPlaybackState.AdGroup c2 = adPlaybackState.c(e);
            for (int i = n5; i < a(adPlaybackState, e); ++i) {
                n -= c2.e[i];
            }
            n += c2.f;
            ++e;
        }
        long n6 = n;
        if (n3 < a(adPlaybackState, n2)) {
            n2 = n4;
            while (true) {
                n6 = n;
                if (n2 >= n3) {
                    break;
                }
                n -= c.e[n2];
                ++n2;
            }
        }
        return n6;
    }
    
    public static long d(final long n, int i, final AdPlaybackState adPlaybackState) {
        int b = i;
        if (i == -1) {
            b = adPlaybackState.b;
        }
        i = adPlaybackState.e;
        long n2 = 0L;
        while (i < b) {
            final AdPlaybackState.AdGroup c = adPlaybackState.c(i);
            final long a = c.a;
            if (a == Long.MIN_VALUE) {
                break;
            }
            if (a > n - n2) {
                break;
            }
            for (int j = 0; j < a(adPlaybackState, i); ++j) {
                n2 += c.e[j];
            }
            final long f = c.f;
            n2 -= f;
            final long a2 = c.a;
            final long n3 = n - n2;
            if (f + a2 > n3) {
                return Math.max(a2, n3);
            }
            ++i;
        }
        return n - n2;
    }
    
    public static long e(long n, final MediaPeriodId mediaPeriodId, final AdPlaybackState adPlaybackState) {
        if (mediaPeriodId.b()) {
            n = f(n, mediaPeriodId.b, mediaPeriodId.c, adPlaybackState);
        }
        else {
            n = g(n, mediaPeriodId.e, adPlaybackState);
        }
        return n;
    }
    
    public static long f(long n, int n2, final int n3, final AdPlaybackState adPlaybackState) {
        final AdPlaybackState.AdGroup c = adPlaybackState.c(n2);
        n += c.a;
        int e = adPlaybackState.e;
        int n4;
        while (true) {
            n4 = 0;
            final int n5 = 0;
            if (e >= n2) {
                break;
            }
            final AdPlaybackState.AdGroup c2 = adPlaybackState.c(e);
            for (int i = n5; i < a(adPlaybackState, e); ++i) {
                n += c2.e[i];
            }
            n -= c2.f;
            ++e;
        }
        long n6 = n;
        if (n3 < a(adPlaybackState, n2)) {
            n2 = n4;
            while (true) {
                n6 = n;
                if (n2 >= n3) {
                    break;
                }
                n += c.e[n2];
                ++n2;
            }
        }
        return n6;
    }
    
    public static long g(final long n, int e, final AdPlaybackState adPlaybackState) {
        int b = e;
        if (e == -1) {
            b = adPlaybackState.b;
        }
        e = adPlaybackState.e;
        long n2 = 0L;
        long n3;
        while (true) {
            n3 = n2;
            if (e >= b) {
                break;
            }
            final AdPlaybackState.AdGroup c = adPlaybackState.c(e);
            final long a = c.a;
            if (a == Long.MIN_VALUE) {
                break;
            }
            if (a > n) {
                break;
            }
            int i = 0;
            long n4 = n3;
            while (i < a(adPlaybackState, e)) {
                n4 += c.e[i];
                ++i;
            }
            final long f = c.f;
            n2 = n4 - f;
            if (c.a + f > n) {
                return Math.max(a + n3, n + n2);
            }
            ++e;
        }
        return n + n3;
    }
}
