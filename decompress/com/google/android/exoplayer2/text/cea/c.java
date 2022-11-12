// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import java.util.PriorityQueue;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import java.util.ArrayDeque;
import com.google.android.exoplayer2.text.SubtitleDecoder;

abstract class c implements SubtitleDecoder
{
    private final ArrayDeque<b> a;
    private final ArrayDeque<SubtitleOutputBuffer> b;
    private final PriorityQueue<b> c;
    private b d;
    private long e;
    private long f;
    
    public c() {
        this.a = new ArrayDeque<b>();
        final int n = 0;
        for (int i = 0; i < 10; ++i) {
            this.a.add(new b(null));
        }
        this.b = new ArrayDeque<SubtitleOutputBuffer>();
        for (int j = n; j < 2; ++j) {
            this.b.add(new c(new com.google.android.exoplayer2.text.cea.b(this)));
        }
        this.c = new PriorityQueue<b>();
    }
    
    private void m(final b b) {
        b.h();
        this.a.add(b);
    }
    
    @Override
    public void a(final long e) {
        this.e = e;
    }
    
    @Override
    public /* bridge */ Object b() throws DecoderException {
        return this.h();
    }
    
    @Override
    public /* bridge */ void c(final Object o) throws DecoderException {
        this.l((SubtitleInputBuffer)o);
    }
    
    @Override
    public /* bridge */ Object d() throws DecoderException {
        return this.g();
    }
    
    protected abstract Subtitle e();
    
    protected abstract void f(final SubtitleInputBuffer p0);
    
    @Override
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            this.m(Util.j(this.c.poll()));
        }
        final b d = this.d;
        if (d != null) {
            this.m(d);
            this.d = null;
        }
    }
    
    public SubtitleInputBuffer g() throws SubtitleDecoderException {
        Assertions.g(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        return this.d = this.a.pollFirst();
    }
    
    public SubtitleOutputBuffer h() throws SubtitleDecoderException {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && Util.j(this.c.peek()).f <= this.e) {
            final b b = Util.j(this.c.poll());
            if (b.n()) {
                final SubtitleOutputBuffer subtitleOutputBuffer = Util.j(this.b.pollFirst());
                subtitleOutputBuffer.g(4);
                this.m(b);
                return subtitleOutputBuffer;
            }
            this.f(b);
            if (this.k()) {
                final Subtitle e = this.e();
                final SubtitleOutputBuffer subtitleOutputBuffer2 = Util.j(this.b.pollFirst());
                subtitleOutputBuffer2.s(b.f, e, Long.MAX_VALUE);
                this.m(b);
                return subtitleOutputBuffer2;
            }
            this.m(b);
        }
        return null;
    }
    
    protected final SubtitleOutputBuffer i() {
        return this.b.pollFirst();
    }
    
    protected final long j() {
        return this.e;
    }
    
    protected abstract boolean k();
    
    public void l(final SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.a(subtitleInputBuffer == this.d);
        final b b = (b)subtitleInputBuffer;
        if (b.m()) {
            this.m(b);
        }
        else {
            final long f = this.f;
            this.f = 1L + f;
            com.google.android.exoplayer2.text.cea.c.b.y(b, f);
            this.c.add(b);
        }
        this.d = null;
    }
    
    protected void n(final SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.h();
        this.b.add(subtitleOutputBuffer);
    }
    
    @Override
    public void release() {
    }
    
    private static final class b extends SubtitleInputBuffer implements Comparable<b>
    {
        private long p;
        
        private b() {
        }
        
        b(final c$a object) {
            this();
        }
        
        static long y(final b b, final long p2) {
            return b.p = p2;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.z((b)o);
        }
        
        public int z(final b b) {
            final boolean n = this.n();
            final boolean n2 = b.n();
            final int n3 = 1;
            int n4 = 1;
            if (n != n2) {
                if (!this.n()) {
                    n4 = -1;
                }
                return n4;
            }
            long n5;
            if ((n5 = super.f - b.f) == 0L && (n5 = this.p - b.p) == 0L) {
                return 0;
            }
            int n6;
            if (n5 > 0L) {
                n6 = n3;
            }
            else {
                n6 = -1;
            }
            return n6;
        }
    }
    
    private static final class c extends SubtitleOutputBuffer
    {
        private Owner<c> f;
        
        public c(final Owner<c> f) {
            this.f = f;
        }
        
        @Override
        public final void r() {
            this.f.a(this);
        }
    }
}
