// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import android.os.Bundle;
import h4.m;
import com.google.android.exoplayer2.Bundleable;

public final class VideoSize implements Bundleable
{
    public static final VideoSize e;
    public static final Creator<VideoSize> f;
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    
    static {
        e = new VideoSize(0, 0);
        f = (Creator)m.a;
    }
    
    public VideoSize(final int n, final int n2) {
        this(n, n2, 0, 1.0f);
    }
    
    public VideoSize(final int a, final int b, final int c, final float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static VideoSize a(final Bundle bundle) {
        return c(bundle);
    }
    
    private static String b(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static VideoSize c(final Bundle bundle) {
        return new VideoSize(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0), bundle.getFloat(b(3), 1.0f));
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o instanceof VideoSize) {
            final VideoSize videoSize = (VideoSize)o;
            if (this.a != videoSize.a || this.b != videoSize.b || this.c != videoSize.c || this.d != videoSize.d) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (((217 + this.a) * 31 + this.b) * 31 + this.c) * 31 + Float.floatToRawIntBits(this.d);
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.a);
        bundle.putInt(b(1), this.b);
        bundle.putInt(b(2), this.c);
        bundle.putFloat(b(3), this.d);
        return bundle;
    }
}
