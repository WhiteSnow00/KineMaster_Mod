// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.Format;

public final class DecoderReuseEvaluation
{
    public final String a;
    public final Format b;
    public final Format c;
    public final int d;
    public final int e;
    
    public DecoderReuseEvaluation(final String s, final Format format, final Format format2, final int d, final int e) {
        Assertions.a(d == 0 || e == 0);
        this.a = Assertions.d(s);
        this.b = Assertions.e(format);
        this.c = Assertions.e(format2);
        this.d = d;
        this.e = e;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && DecoderReuseEvaluation.class == o.getClass()) {
            final DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation)o;
            if (this.d != decoderReuseEvaluation.d || this.e != decoderReuseEvaluation.e || !this.a.equals(decoderReuseEvaluation.a) || !this.b.equals(decoderReuseEvaluation.b) || !this.c.equals(decoderReuseEvaluation.c)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return ((((527 + this.d) * 31 + this.e) * 31 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface DecoderDiscardReasons {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface DecoderReuseResult {
    }
}
