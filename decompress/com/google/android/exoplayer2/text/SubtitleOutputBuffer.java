// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import java.util.List;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;

public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle
{
    private Subtitle d;
    private long e;
    
    @Override
    public int a(final long n) {
        return Assertions.e(this.d).a(n - this.e);
    }
    
    @Override
    public List<Cue> c(final long n) {
        return Assertions.e(this.d).c(n - this.e);
    }
    
    @Override
    public long d(final int n) {
        return Assertions.e(this.d).d(n) + this.e;
    }
    
    @Override
    public int f() {
        return Assertions.e(this.d).f();
    }
    
    @Override
    public void h() {
        super.h();
        this.d = null;
    }
    
    public void s(long n, final Subtitle d, final long n2) {
        super.b = n;
        this.d = d;
        if (n2 != Long.MAX_VALUE) {
            n = n2;
        }
        this.e = n;
    }
}
