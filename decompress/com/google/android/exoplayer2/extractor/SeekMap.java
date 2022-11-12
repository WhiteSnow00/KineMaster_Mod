// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public interface SeekMap
{
    SeekPoints f(final long p0);
    
    boolean h();
    
    long i();
    
    public static final class SeekPoints
    {
        public final SeekPoint a;
        public final SeekPoint b;
        
        public SeekPoints(final SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }
        
        public SeekPoints(final SeekPoint seekPoint, final SeekPoint seekPoint2) {
            this.a = Assertions.e(seekPoint);
            this.b = Assertions.e(seekPoint2);
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && SeekPoints.class == o.getClass()) {
                final SeekPoints seekPoints = (SeekPoints)o;
                if (!this.a.equals(seekPoints.a) || !this.b.equals(seekPoints.b)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() * 31 + this.b.hashCode();
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.a);
            String string;
            if (this.a.equals(this.b)) {
                string = "";
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(", ");
                sb2.append(this.b);
                string = sb2.toString();
            }
            sb.append(string);
            sb.append("]");
            return sb.toString();
        }
    }
    
    public static class Unseekable implements SeekMap
    {
        private final long a;
        private final SeekPoints b;
        
        public Unseekable(final long n) {
            this(n, 0L);
        }
        
        public Unseekable(final long a, final long n) {
            this.a = a;
            SeekPoint c;
            if (n == 0L) {
                c = SeekPoint.c;
            }
            else {
                c = new SeekPoint(0L, n);
            }
            this.b = new SeekPoints(c);
        }
        
        @Override
        public SeekPoints f(final long n) {
            return this.b;
        }
        
        @Override
        public boolean h() {
            return false;
        }
        
        @Override
        public long i() {
            return this.a;
        }
    }
}
