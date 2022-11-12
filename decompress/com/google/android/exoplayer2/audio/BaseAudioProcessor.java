// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.nio.ByteOrder;
import java.nio.ByteBuffer;

public abstract class BaseAudioProcessor implements AudioProcessor
{
    protected AudioFormat b;
    protected AudioFormat c;
    private AudioFormat d;
    private AudioFormat e;
    private ByteBuffer f;
    private ByteBuffer g;
    private boolean h;
    
    public BaseAudioProcessor() {
        final ByteBuffer a = AudioProcessor.a;
        this.f = a;
        this.g = a;
        final AudioFormat e = AudioFormat.e;
        this.d = e;
        this.e = e;
        this.b = e;
        this.c = e;
    }
    
    @Override
    public ByteBuffer a() {
        final ByteBuffer g = this.g;
        this.g = AudioProcessor.a;
        return g;
    }
    
    @Override
    public boolean c() {
        return this.h && this.g == AudioProcessor.a;
    }
    
    @Override
    public final AudioFormat d(AudioFormat d) throws UnhandledAudioFormatException {
        this.d = d;
        this.e = this.g(d);
        if (this.isActive()) {
            d = this.e;
        }
        else {
            d = AudioFormat.e;
        }
        return d;
    }
    
    @Override
    public final void e() {
        this.h = true;
        this.i();
    }
    
    protected final boolean f() {
        return this.g.hasRemaining();
    }
    
    @Override
    public final void flush() {
        this.g = AudioProcessor.a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        this.h();
    }
    
    protected AudioFormat g(final AudioFormat audioFormat) throws UnhandledAudioFormatException {
        return AudioFormat.e;
    }
    
    protected void h() {
    }
    
    protected void i() {
    }
    
    @Override
    public boolean isActive() {
        return this.e != AudioFormat.e;
    }
    
    protected void j() {
    }
    
    protected final ByteBuffer k(final int n) {
        if (this.f.capacity() < n) {
            this.f = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder());
        }
        else {
            this.f.clear();
        }
        return this.g = this.f;
    }
    
    @Override
    public final void reset() {
        this.flush();
        this.f = AudioProcessor.a;
        final AudioFormat e = AudioFormat.e;
        this.d = e;
        this.e = e;
        this.b = e;
        this.c = e;
        this.j();
    }
}
