// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

public interface RendererCapabilities
{
    default int E(final int n) {
        return n & 0x7;
    }
    
    default int i(final int n) {
        return n & 0x80;
    }
    
    default int k(final int n, final int n2, final int n3, final int n4, final int n5) {
        return n | n2 | n3 | n4 | n5;
    }
    
    default int m(final int n) {
        return n & 0x20;
    }
    
    default int n(final int n) {
        return n & 0x18;
    }
    
    default int o(final int n) {
        return v(n, 0, 0);
    }
    
    default int t(final int n) {
        return n & 0x40;
    }
    
    default int v(final int n, final int n2, final int n3) {
        return k(n, n2, n3, 0, 128);
    }
    
    int a(final Format p0) throws ExoPlaybackException;
    
    int f();
    
    String getName();
    
    int z() throws ExoPlaybackException;
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface AdaptiveSupport {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Capabilities {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface DecoderSupport {
    }
    
    @Deprecated
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface FormatSupport {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface HardwareAccelerationSupport {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface TunnelingSupport {
    }
}
