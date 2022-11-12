// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Util;
import android.view.accessibility.CaptioningManager$CaptionStyle;
import android.graphics.Typeface;

public final class CaptionStyleCompat
{
    public static final CaptionStyleCompat g;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final Typeface f;
    
    static {
        g = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    }
    
    public CaptionStyleCompat(final int a, final int b, final int c, final int d, final int e, final Typeface f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public static CaptionStyleCompat a(final CaptioningManager$CaptionStyle captioningManager$CaptionStyle) {
        if (Util.a >= 21) {
            return c(captioningManager$CaptionStyle);
        }
        return b(captioningManager$CaptionStyle);
    }
    
    private static CaptionStyleCompat b(final CaptioningManager$CaptionStyle captioningManager$CaptionStyle) {
        return new CaptionStyleCompat(captioningManager$CaptionStyle.foregroundColor, captioningManager$CaptionStyle.backgroundColor, 0, captioningManager$CaptionStyle.edgeType, captioningManager$CaptionStyle.edgeColor, captioningManager$CaptionStyle.getTypeface());
    }
    
    private static CaptionStyleCompat c(final CaptioningManager$CaptionStyle captioningManager$CaptionStyle) {
        int n;
        if (captioningManager$CaptionStyle.hasForegroundColor()) {
            n = captioningManager$CaptionStyle.foregroundColor;
        }
        else {
            n = CaptionStyleCompat.g.a;
        }
        int n2;
        if (captioningManager$CaptionStyle.hasBackgroundColor()) {
            n2 = captioningManager$CaptionStyle.backgroundColor;
        }
        else {
            n2 = CaptionStyleCompat.g.b;
        }
        int n3;
        if (captioningManager$CaptionStyle.hasWindowColor()) {
            n3 = captioningManager$CaptionStyle.windowColor;
        }
        else {
            n3 = CaptionStyleCompat.g.c;
        }
        int n4;
        if (captioningManager$CaptionStyle.hasEdgeType()) {
            n4 = captioningManager$CaptionStyle.edgeType;
        }
        else {
            n4 = CaptionStyleCompat.g.d;
        }
        int n5;
        if (captioningManager$CaptionStyle.hasEdgeColor()) {
            n5 = captioningManager$CaptionStyle.edgeColor;
        }
        else {
            n5 = CaptionStyleCompat.g.e;
        }
        return new CaptionStyleCompat(n, n2, n3, n4, n5, captioningManager$CaptionStyle.getTypeface());
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface EdgeType {
    }
}
