// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Format;

public class ForwardingAudioSink implements AudioSink
{
    private final AudioSink a;
    
    @Override
    public boolean a(final Format format) {
        return this.a.a(format);
    }
    
    @Override
    public PlaybackParameters b() {
        return this.a.b();
    }
    
    @Override
    public boolean c() {
        return this.a.c();
    }
    
    @Override
    public void d(final PlaybackParameters playbackParameters) {
        this.a.d(playbackParameters);
    }
    
    @Override
    public boolean e() {
        return this.a.e();
    }
    
    @Override
    public void f(final int n) {
        this.a.f(n);
    }
    
    @Override
    public void flush() {
        this.a.flush();
    }
    
    @Override
    public void g() {
        this.a.g();
    }
    
    @Override
    public void h(final AudioAttributes audioAttributes) {
        this.a.h(audioAttributes);
    }
    
    @Override
    public void i(final PlayerId playerId) {
        this.a.i(playerId);
    }
    
    @Override
    public boolean j(final ByteBuffer byteBuffer, final long n, final int n2) throws InitializationException, WriteException {
        return this.a.j(byteBuffer, n, n2);
    }
    
    @Override
    public void k(final Listener listener) {
        this.a.k(listener);
    }
    
    @Override
    public int l(final Format format) {
        return this.a.l(format);
    }
    
    @Override
    public void m() {
        this.a.m();
    }
    
    @Override
    public void n(final AuxEffectInfo auxEffectInfo) {
        this.a.n(auxEffectInfo);
    }
    
    @Override
    public void o() throws WriteException {
        this.a.o();
    }
    
    @Override
    public long p(final boolean b) {
        return this.a.p(b);
    }
    
    @Override
    public void pause() {
        this.a.pause();
    }
    
    @Override
    public void play() {
        this.a.play();
    }
    
    @Override
    public void q() {
        this.a.q();
    }
    
    @Override
    public void r() {
        this.a.r();
    }
    
    @Override
    public void reset() {
        this.a.reset();
    }
    
    @Override
    public void s(final Format format, final int n, final int[] array) throws ConfigurationException {
        this.a.s(format, n, array);
    }
    
    @Override
    public void setVolume(final float volume) {
        this.a.setVolume(volume);
    }
    
    @Override
    public void t(final boolean b) {
        this.a.t(b);
    }
}
