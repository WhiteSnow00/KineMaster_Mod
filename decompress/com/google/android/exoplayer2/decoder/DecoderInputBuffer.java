// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.Format;

public class DecoderInputBuffer extends Buffer
{
    public Format b;
    public final CryptoInfo c;
    public ByteBuffer d;
    public boolean e;
    public long f;
    public ByteBuffer g;
    private final int h;
    private final int i;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.decoder");
    }
    
    public DecoderInputBuffer(final int n) {
        this(n, 0);
    }
    
    public DecoderInputBuffer(final int h, final int i) {
        this.c = new CryptoInfo();
        this.h = h;
        this.i = i;
    }
    
    private ByteBuffer r(final int n) {
        final int h = this.h;
        if (h == 1) {
            return ByteBuffer.allocate(n);
        }
        if (h == 2) {
            return ByteBuffer.allocateDirect(n);
        }
        final ByteBuffer d = this.d;
        int capacity;
        if (d == null) {
            capacity = 0;
        }
        else {
            capacity = d.capacity();
        }
        throw new InsufficientCapacityException(capacity, n);
    }
    
    public static DecoderInputBuffer w() {
        return new DecoderInputBuffer(0);
    }
    
    @Override
    public void h() {
        super.h();
        final ByteBuffer d = this.d;
        if (d != null) {
            d.clear();
        }
        final ByteBuffer g = this.g;
        if (g != null) {
            g.clear();
        }
        this.e = false;
    }
    
    public void s(int position) {
        final int n = position + this.i;
        final ByteBuffer d = this.d;
        if (d == null) {
            this.d = this.r(n);
            return;
        }
        final int capacity = d.capacity();
        position = d.position();
        final int n2 = n + position;
        if (capacity >= n2) {
            this.d = d;
            return;
        }
        final ByteBuffer r = this.r(n2);
        r.order(d.order());
        if (position > 0) {
            d.flip();
            r.put(d);
        }
        this.d = r;
    }
    
    public final void t() {
        final ByteBuffer d = this.d;
        if (d != null) {
            d.flip();
        }
        final ByteBuffer g = this.g;
        if (g != null) {
            g.flip();
        }
    }
    
    public final boolean u() {
        return this.k(1073741824);
    }
    
    public void x(final int n) {
        final ByteBuffer g = this.g;
        if (g != null && g.capacity() >= n) {
            this.g.clear();
        }
        else {
            this.g = ByteBuffer.allocate(n);
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface BufferReplacementMode {
    }
    
    public static final class InsufficientCapacityException extends IllegalStateException
    {
        public final int currentCapacity;
        public final int requiredCapacity;
        
        public InsufficientCapacityException(final int currentCapacity, final int requiredCapacity) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Buffer too small (");
            sb.append(currentCapacity);
            sb.append(" < ");
            sb.append(requiredCapacity);
            sb.append(")");
            super(sb.toString());
            this.currentCapacity = currentCapacity;
            this.requiredCapacity = requiredCapacity;
        }
    }
}
