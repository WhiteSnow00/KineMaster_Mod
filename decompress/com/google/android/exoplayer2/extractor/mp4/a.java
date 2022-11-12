// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

abstract class a
{
    public final int a;
    
    public a(final int a) {
        this.a = a;
    }
    
    public static String a(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((char)(n >> 24 & 0xFF));
        sb.append((char)(n >> 16 & 0xFF));
        sb.append((char)(n >> 8 & 0xFF));
        sb.append((char)(n & 0xFF));
        return sb.toString();
    }
    
    public static int b(final int n) {
        return n & 0xFFFFFF;
    }
    
    public static int c(final int n) {
        return n >> 24 & 0xFF;
    }
    
    @Override
    public String toString() {
        return a(this.a);
    }
    
    static final class a extends com.google.android.exoplayer2.extractor.mp4.a
    {
        public final long b;
        public final List<b> c;
        public final List<a> d;
        
        public a(final int n, final long b) {
            super(n);
            this.b = b;
            this.c = new ArrayList<b>();
            this.d = new ArrayList<a>();
        }
        
        public void d(final a a) {
            this.d.add(a);
        }
        
        public void e(final b b) {
            this.c.add(b);
        }
        
        public a f(final int n) {
            for (int size = this.d.size(), i = 0; i < size; ++i) {
                final a a = this.d.get(i);
                if (a.a == n) {
                    return a;
                }
            }
            return null;
        }
        
        public b g(final int n) {
            for (int size = this.c.size(), i = 0; i < size; ++i) {
                final b b = this.c.get(i);
                if (b.a == n) {
                    return b;
                }
            }
            return null;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(com.google.android.exoplayer2.extractor.mp4.a.a(super.a));
            sb.append(" leaves: ");
            sb.append(Arrays.toString(this.c.toArray()));
            sb.append(" containers: ");
            sb.append(Arrays.toString(this.d.toArray()));
            return sb.toString();
        }
    }
    
    static final class b extends a
    {
        public final ParsableByteArray b;
        
        public b(final int n, final ParsableByteArray b) {
            super(n);
            this.b = b;
        }
    }
}
