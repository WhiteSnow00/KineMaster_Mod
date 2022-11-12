// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.io.IOException;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;

public interface Renderer extends Target
{
    void A(final long p0, final long p1) throws ExoPlaybackException;
    
    long B();
    
    void C(final long p0) throws ExoPlaybackException;
    
    MediaClock D();
    
    boolean c();
    
    void e();
    
    int f();
    
    SampleStream g();
    
    String getName();
    
    int getState();
    
    boolean h();
    
    boolean isReady();
    
    void j();
    
    void l(final int p0, final PlayerId p1);
    
    void q() throws IOException;
    
    boolean r();
    
    void reset();
    
    void s(final Format[] p0, final SampleStream p1, final long p2, final long p3) throws ExoPlaybackException;
    
    void start() throws ExoPlaybackException;
    
    void stop();
    
    RendererCapabilities u();
    
    default void x(final float n, final float n2) throws ExoPlaybackException {
    }
    
    void y(final RendererConfiguration p0, final Format[] p1, final SampleStream p2, final long p3, final boolean p4, final boolean p5, final long p6, final long p7) throws ExoPlaybackException;
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @java.lang.annotation.Target({ ElementType.TYPE_USE })
    public @interface MessageType {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @java.lang.annotation.Target({ ElementType.TYPE_USE })
    public @interface State {
    }
    
    public interface WakeupListener
    {
        void a();
        
        void b();
    }
}
