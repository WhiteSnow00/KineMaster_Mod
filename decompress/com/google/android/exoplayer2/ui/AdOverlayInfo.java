// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.view.View;

public final class AdOverlayInfo
{
    public final View a;
    public final int b;
    public final String c;
    
    @Deprecated
    public AdOverlayInfo(final View view, final int n) {
        this(view, n, null);
    }
    
    @Deprecated
    public AdOverlayInfo(final View a, final int b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static final class Builder
    {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface Purpose {
    }
}
