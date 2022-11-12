// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;

public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder
{
    private final String n;
    
    protected SimpleSubtitleDecoder(final String n) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.n = n;
        this.u(1024);
    }
    
    static void v(final SimpleSubtitleDecoder simpleSubtitleDecoder, final DecoderOutputBuffer decoderOutputBuffer) {
        ((SimpleDecoder<I, SubtitleOutputBuffer, E>)simpleSubtitleDecoder).r((SubtitleOutputBuffer)decoderOutputBuffer);
    }
    
    protected final SubtitleDecoderException A(final SubtitleInputBuffer subtitleInputBuffer, final SubtitleOutputBuffer subtitleOutputBuffer, final boolean b) {
        try {
            final ByteBuffer byteBuffer = Assertions.e(subtitleInputBuffer.d);
            subtitleOutputBuffer.s(subtitleInputBuffer.f, this.z(byteBuffer.array(), byteBuffer.limit(), b), subtitleInputBuffer.j);
            subtitleOutputBuffer.i(Integer.MIN_VALUE);
            return null;
        }
        catch (final SubtitleDecoderException ex) {
            return ex;
        }
    }
    
    @Override
    public void a(final long n) {
    }
    
    @Override
    protected /* bridge */ DecoderInputBuffer g() {
        return this.w();
    }
    
    @Override
    public final String getName() {
        return this.n;
    }
    
    @Override
    protected /* bridge */ DecoderOutputBuffer h() {
        return this.x();
    }
    
    @Override
    protected /* bridge */ DecoderException i(final Throwable t) {
        return this.y(t);
    }
    
    @Override
    protected /* bridge */ DecoderException j(final DecoderInputBuffer decoderInputBuffer, final DecoderOutputBuffer decoderOutputBuffer, final boolean b) {
        return this.A((SubtitleInputBuffer)decoderInputBuffer, (SubtitleOutputBuffer)decoderOutputBuffer, b);
    }
    
    protected final SubtitleInputBuffer w() {
        return new SubtitleInputBuffer();
    }
    
    protected final SubtitleOutputBuffer x() {
        return new SubtitleOutputBuffer(this) {
            final SimpleSubtitleDecoder f;
            
            @Override
            public void r() {
                SimpleSubtitleDecoder.v(this.f, this);
            }
        };
    }
    
    protected final SubtitleDecoderException y(final Throwable t) {
        return new SubtitleDecoderException("Unexpected decode error", t);
    }
    
    protected abstract Subtitle z(final byte[] p0, final int p1, final boolean p2) throws SubtitleDecoderException;
}
