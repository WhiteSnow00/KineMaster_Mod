// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;
import android.os.Bundle;
import com.google.android.exoplayer2.util.Assertions;

public final class PlaybackParameters implements Bundleable
{
    public static final PlaybackParameters d;
    public static final Creator<PlaybackParameters> e;
    public final float a;
    public final float b;
    private final int c;
    
    static {
        d = new PlaybackParameters(1.0f);
        e = n1.a;
    }
    
    public PlaybackParameters(final float n) {
        this(n, 1.0f);
    }
    
    public PlaybackParameters(final float a, final float b) {
        final boolean b2 = true;
        Assertions.a(a > 0.0f);
        Assertions.a(b > 0.0f && b2);
        this.a = a;
        this.b = b;
        this.c = Math.round(a * 1000.0f);
    }
    
    public static PlaybackParameters a(final Bundle bundle) {
        return d(bundle);
    }
    
    private static String c(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static PlaybackParameters d(final Bundle bundle) {
        return new PlaybackParameters(bundle.getFloat(c(0), 1.0f), bundle.getFloat(c(1), 1.0f));
    }
    
    public long b(final long n) {
        return n * this.c;
    }
    
    public PlaybackParameters e(final float n) {
        return new PlaybackParameters(n, this.b);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && PlaybackParameters.class == o.getClass()) {
            final PlaybackParameters playbackParameters = (PlaybackParameters)o;
            if (this.a != playbackParameters.a || this.b != playbackParameters.b) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (527 + Float.floatToRawIntBits(this.a)) * 31 + Float.floatToRawIntBits(this.b);
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putFloat(c(0), this.a);
        bundle.putFloat(c(1), this.b);
        return bundle;
    }
    
    @Override
    public String toString() {
        return Util.C("PlaybackParameters(speed=%.2f, pitch=%.2f)", this.a, this.b);
    }
}
