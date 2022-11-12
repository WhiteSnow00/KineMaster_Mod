// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.span;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

public final class TextEmphasisSpan implements LanguageFeatureSpan
{
    public int a;
    public int b;
    public final int c;
    
    public TextEmphasisSpan(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface MarkFill {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface MarkShape {
    }
}
