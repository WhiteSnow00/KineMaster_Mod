// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.span;

import android.text.Spannable;

public final class SpanUtil
{
    private SpanUtil() {
    }
    
    public static void a(final Spannable spannable, final Object o, final int n, final int n2, final int n3) {
        for (final Object o2 : spannable.getSpans(n, n2, (Class)o.getClass())) {
            if (spannable.getSpanStart(o2) == n && spannable.getSpanEnd(o2) == n2 && spannable.getSpanFlags(o2) == n3) {
                spannable.removeSpan(o2);
            }
        }
        spannable.setSpan(o, n, n2, n3);
    }
}
