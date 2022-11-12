// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.util.Arrays;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataReader;

public interface TrackOutput
{
    int a(final DataReader p0, final int p1, final boolean p2, final int p3) throws IOException;
    
    default int b(final DataReader dataReader, final int n, final boolean b) throws IOException {
        return this.a(dataReader, n, b, 0);
    }
    
    default void c(final ParsableByteArray parsableByteArray, final int n) {
        this.f(parsableByteArray, n, 0);
    }
    
    void d(final Format p0);
    
    void e(final long p0, final int p1, final int p2, final int p3, final CryptoData p4);
    
    void f(final ParsableByteArray p0, final int p1, final int p2);
    
    public static final class CryptoData
    {
        public final int a;
        public final byte[] b;
        public final int c;
        public final int d;
        
        public CryptoData(final int a, final byte[] b, final int c, final int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && CryptoData.class == o.getClass()) {
                final CryptoData cryptoData = (CryptoData)o;
                if (this.a != cryptoData.a || this.c != cryptoData.c || this.d != cryptoData.d || !Arrays.equals(this.b, cryptoData.b)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return ((this.a * 31 + Arrays.hashCode(this.b)) * 31 + this.c) * 31 + this.d;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface SampleDataPart {
    }
}
