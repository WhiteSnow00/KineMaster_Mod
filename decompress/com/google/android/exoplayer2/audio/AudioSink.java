// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Format;

public interface AudioSink
{
    boolean a(final Format p0);
    
    PlaybackParameters b();
    
    boolean c();
    
    void d(final PlaybackParameters p0);
    
    boolean e();
    
    void f(final int p0);
    
    void flush();
    
    void g();
    
    void h(final AudioAttributes p0);
    
    default void i(final PlayerId playerId) {
    }
    
    boolean j(final ByteBuffer p0, final long p1, final int p2) throws InitializationException, WriteException;
    
    void k(final Listener p0);
    
    int l(final Format p0);
    
    void m();
    
    void n(final AuxEffectInfo p0);
    
    void o() throws WriteException;
    
    long p(final boolean p0);
    
    void pause();
    
    void play();
    
    void q();
    
    void r();
    
    void reset();
    
    void s(final Format p0, final int p1, final int[] p2) throws ConfigurationException;
    
    void setVolume(final float p0);
    
    void t(final boolean p0);
    
    public static final class WriteException extends Exception
    {
        public final int errorCode;
        public final Format format;
        public final boolean isRecoverable;
        
        public WriteException(final int errorCode, final Format format, final boolean isRecoverable) {
            final StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack write failed: ");
            sb.append(errorCode);
            super(sb.toString());
            this.isRecoverable = isRecoverable;
            this.errorCode = errorCode;
            this.format = format;
        }
    }
    
    public static final class InitializationException extends Exception
    {
        public final int audioTrackState;
        public final Format format;
        public final boolean isRecoverable;
        
        public InitializationException(final int audioTrackState, final int n, final int n2, final int n3, final Format format, final boolean isRecoverable, final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed ");
            sb.append(audioTrackState);
            sb.append(" ");
            sb.append("Config(");
            sb.append(n);
            sb.append(", ");
            sb.append(n2);
            sb.append(", ");
            sb.append(n3);
            sb.append(")");
            String s;
            if (isRecoverable) {
                s = " (recoverable)";
            }
            else {
                s = "";
            }
            sb.append(s);
            super(sb.toString(), ex);
            this.audioTrackState = audioTrackState;
            this.isRecoverable = isRecoverable;
            this.format = format;
        }
    }
    
    public static final class ConfigurationException extends Exception
    {
        public final Format format;
        
        public ConfigurationException(final String s, final Format format) {
            super(s);
            this.format = format;
        }
        
        public ConfigurationException(final Throwable t, final Format format) {
            super(t);
            this.format = format;
        }
    }
    
    public interface Listener
    {
        default void a(final Exception ex) {
        }
        
        default void b(final long n) {
        }
        
        default void c() {
        }
        
        void d(final int p0, final long p1, final long p2);
        
        void e();
        
        default void f() {
        }
        
        void onSkipSilenceEnabledChanged(final boolean p0);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface SinkFormatSupport {
    }
    
    public static final class UnexpectedDiscontinuityException extends Exception
    {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;
        
        public UnexpectedDiscontinuityException(final long actualPresentationTimeUs, final long expectedPresentationTimeUs) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected audio track timestamp discontinuity: expected ");
            sb.append(expectedPresentationTimeUs);
            sb.append(", got ");
            sb.append(actualPresentationTimeUs);
            super(sb.toString());
            this.actualPresentationTimeUs = actualPresentationTimeUs;
            this.expectedPresentationTimeUs = expectedPresentationTimeUs;
        }
    }
}
