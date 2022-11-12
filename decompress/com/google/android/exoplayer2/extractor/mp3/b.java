// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.LongArray;

final class b implements Seeker
{
    private final long a;
    private final LongArray b;
    private final LongArray c;
    private long d;
    
    public b(final long d, final long n, final long a) {
        this.d = d;
        this.a = a;
        final LongArray b = new LongArray();
        this.b = b;
        final LongArray c = new LongArray();
        this.c = c;
        b.a(0L);
        c.a(n);
    }
    
    public boolean a(final long n) {
        final LongArray b = this.b;
        final int c = b.c();
        boolean b2 = true;
        if (n - b.b(c - 1) >= 100000L) {
            b2 = false;
        }
        return b2;
    }
    
    public void b(final long n, final long n2) {
        if (this.a(n)) {
            return;
        }
        this.b.a(n);
        this.c.a(n2);
    }
    
    @Override
    public long c(final long n) {
        return this.b.b(Util.f(this.c, n, true, true));
    }
    
    void d(final long d) {
        this.d = d;
    }
    
    @Override
    public SeekPoints f(final long n) {
        int f = Util.f(this.b, n, true, true);
        final SeekPoint seekPoint = new SeekPoint(this.b.b(f), this.c.b(f));
        if (seekPoint.a != n && f != this.b.c() - 1) {
            final LongArray b = this.b;
            ++f;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(b.b(f), this.c.b(f)));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }
    
    @Override
    public long g() {
        return this.a;
    }
    
    @Override
    public boolean h() {
        return true;
    }
    
    @Override
    public long i() {
        return this.d;
    }
}
