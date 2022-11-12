// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.SampleStream;

final class a implements SampleStream
{
    private final Format a;
    private final EventMessageEncoder b;
    private long[] c;
    private boolean d;
    private EventStream e;
    private boolean f;
    private int g;
    private long h;
    
    public a(final EventStream e, final Format a, final boolean b) {
        this.a = a;
        this.e = e;
        this.b = new EventMessageEncoder();
        this.h = -9223372036854775807L;
        this.c = e.b;
        this.d(e, b);
    }
    
    @Override
    public void a() throws IOException {
    }
    
    public String b() {
        return this.e.a();
    }
    
    public void c(long h) {
        final long[] c = this.c;
        boolean b = true;
        final int e = Util.e(c, h, true, false);
        this.g = e;
        if (!this.d || e != this.c.length) {
            b = false;
        }
        if (!b) {
            h = -9223372036854775807L;
        }
        this.h = h;
    }
    
    public void d(final EventStream e, final boolean d) {
        final int g = this.g;
        long n;
        if (g == 0) {
            n = -9223372036854775807L;
        }
        else {
            n = this.c[g - 1];
        }
        this.d = d;
        this.e = e;
        final long[] b = e.b;
        this.c = b;
        final long h = this.h;
        if (h != -9223372036854775807L) {
            this.c(h);
        }
        else if (n != -9223372036854775807L) {
            this.g = Util.e(b, n, false, false);
        }
    }
    
    @Override
    public int e(final FormatHolder formatHolder, final DecoderInputBuffer decoderInputBuffer, final int n) {
        final int g = this.g;
        final boolean b = g == this.c.length;
        if (b && !this.d) {
            decoderInputBuffer.q(4);
            return -4;
        }
        if ((n & 0x2) != 0x0 || !this.f) {
            formatHolder.b = this.a;
            this.f = true;
            return -5;
        }
        if (b) {
            return -3;
        }
        if ((n & 0x1) == 0x0) {
            this.g = g + 1;
        }
        if ((n & 0x4) == 0x0) {
            final byte[] a = this.b.a(this.e.a[g]);
            decoderInputBuffer.s(a.length);
            decoderInputBuffer.d.put(a);
        }
        decoderInputBuffer.f = this.c[g];
        decoderInputBuffer.q(1);
        return -4;
    }
    
    @Override
    public boolean isReady() {
        return true;
    }
    
    @Override
    public int l(final long n) {
        return (this.g = Math.max(this.g, Util.e(this.c, n, true, false))) - this.g;
    }
}
