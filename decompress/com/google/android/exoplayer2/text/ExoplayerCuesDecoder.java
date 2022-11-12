// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import java.util.List;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;
import java.util.Deque;

public final class ExoplayerCuesDecoder implements SubtitleDecoder
{
    private final CueDecoder a;
    private final SubtitleInputBuffer b;
    private final Deque<SubtitleOutputBuffer> c;
    private int d;
    private boolean e;
    
    public ExoplayerCuesDecoder() {
        this.a = new CueDecoder();
        this.b = new SubtitleInputBuffer();
        this.c = new ArrayDeque<SubtitleOutputBuffer>();
        for (int i = 0; i < 2; ++i) {
            this.c.addFirst(new SubtitleOutputBuffer(this) {
                final ExoplayerCuesDecoder f;
                
                @Override
                public void r() {
                    ExoplayerCuesDecoder.e(this.f, this);
                }
            });
        }
        this.d = 0;
    }
    
    static void e(final ExoplayerCuesDecoder exoplayerCuesDecoder, final SubtitleOutputBuffer subtitleOutputBuffer) {
        exoplayerCuesDecoder.i(subtitleOutputBuffer);
    }
    
    private void i(final SubtitleOutputBuffer subtitleOutputBuffer) {
        Assertions.g(this.c.size() < 2);
        Assertions.a(this.c.contains(subtitleOutputBuffer) ^ true);
        subtitleOutputBuffer.h();
        this.c.addFirst(subtitleOutputBuffer);
    }
    
    @Override
    public void a(final long n) {
    }
    
    @Override
    public /* bridge */ Object b() throws DecoderException {
        return this.g();
    }
    
    @Override
    public /* bridge */ void c(final Object o) throws DecoderException {
        this.h((SubtitleInputBuffer)o);
    }
    
    @Override
    public /* bridge */ Object d() throws DecoderException {
        return this.f();
    }
    
    public SubtitleInputBuffer f() throws SubtitleDecoderException {
        Assertions.g(this.e ^ true);
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.b;
    }
    
    @Override
    public void flush() {
        Assertions.g(this.e ^ true);
        this.b.h();
        this.d = 0;
    }
    
    public SubtitleOutputBuffer g() throws SubtitleDecoderException {
        Assertions.g(this.e ^ true);
        if (this.d == 2 && !this.c.isEmpty()) {
            final SubtitleOutputBuffer subtitleOutputBuffer = this.c.removeFirst();
            if (this.b.n()) {
                subtitleOutputBuffer.g(4);
            }
            else {
                final SubtitleInputBuffer b = this.b;
                subtitleOutputBuffer.s(this.b.f, new b(b.f, this.a.a(Assertions.e(b.d).array())), 0L);
            }
            this.b.h();
            this.d = 0;
            return subtitleOutputBuffer;
        }
        return null;
    }
    
    @Override
    public String getName() {
        return "ExoplayerCuesDecoder";
    }
    
    public void h(final SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        final boolean e = this.e;
        final boolean b = true;
        Assertions.g(e ^ true);
        Assertions.g(this.d == 1);
        Assertions.a(this.b == subtitleInputBuffer && b);
        this.d = 2;
    }
    
    @Override
    public void release() {
        this.e = true;
    }
    
    private static final class b implements Subtitle
    {
        private final long a;
        private final ImmutableList<Cue> b;
        
        public b(final long a, final ImmutableList<Cue> b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int a(final long n) {
            int n2;
            if (this.a > n) {
                n2 = 0;
            }
            else {
                n2 = -1;
            }
            return n2;
        }
        
        @Override
        public List<Cue> c(final long n) {
            ImmutableList list;
            if (n >= this.a) {
                list = this.b;
            }
            else {
                list = ImmutableList.of();
            }
            return (List<Cue>)list;
        }
        
        @Override
        public long d(final int n) {
            Assertions.a(n == 0);
            return this.a;
        }
        
        @Override
        public int f() {
            return 1;
        }
    }
}
