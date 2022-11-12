// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.span;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

public final class TextAnnotation
{
    private TextAnnotation() {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Position {
    }
}
