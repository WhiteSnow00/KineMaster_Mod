// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.Format;

public final class Track
{
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final Format f;
    public final int g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final TrackEncryptionBox[] k;
    
    public Track(final int a, final int b, final long c, final long d, final long e, final Format f, final int g, final TrackEncryptionBox[] k, final int j, final long[] h, final long[] i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.k = k;
        this.j = j;
        this.h = h;
        this.i = i;
    }
    
    public TrackEncryptionBox a(final int n) {
        final TrackEncryptionBox[] k = this.k;
        TrackEncryptionBox trackEncryptionBox;
        if (k == null) {
            trackEncryptionBox = null;
        }
        else {
            trackEncryptionBox = k[n];
        }
        return trackEncryptionBox;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Transformation {
    }
}
