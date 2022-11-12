// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import com.google.common.base.Predicate;
import com.google.android.exoplayer2.util.Assertions;
import android.text.SpannableString;
import android.text.Spannable;
import android.text.Spanned;
import com.google.android.exoplayer2.text.Cue;
import android.text.style.RelativeSizeSpan;
import android.text.style.AbsoluteSizeSpan;
import com.google.android.exoplayer2.text.span.LanguageFeatureSpan;

final class b0
{
    public static boolean a(final Object o) {
        return c(o);
    }
    
    public static boolean b(final Object o) {
        return d(o);
    }
    
    private static boolean c(final Object o) {
        return o instanceof LanguageFeatureSpan ^ true;
    }
    
    private static boolean d(final Object o) {
        return o instanceof AbsoluteSizeSpan || o instanceof RelativeSizeSpan;
    }
    
    public static void e(final Cue.Builder builder) {
        builder.b();
        if (builder.e() instanceof Spanned) {
            if (!(builder.e() instanceof Spannable)) {
                builder.o((CharSequence)SpannableString.valueOf(builder.e()));
            }
            g(Assertions.e((Spannable)builder.e()), (Predicate<Object>)z.a);
        }
        f(builder);
    }
    
    public static void f(final Cue.Builder builder) {
        builder.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (builder.e() instanceof Spanned) {
            if (!(builder.e() instanceof Spannable)) {
                builder.o((CharSequence)SpannableString.valueOf(builder.e()));
            }
            g(Assertions.e((Spannable)builder.e()), (Predicate<Object>)a0.a);
        }
    }
    
    private static void g(final Spannable spannable, final Predicate<Object> predicate) {
        final int length = spannable.length();
        int i = 0;
        for (Object[] spans = spannable.getSpans(0, length, (Class)Object.class); i < spans.length; ++i) {
            final Object o = spans[i];
            if (predicate.apply(o)) {
                spannable.removeSpan(o);
            }
        }
    }
    
    public static float h(final int n, final float n2, final int n3, final int n4) {
        if (n2 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        float n5;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    return -3.4028235E38f;
                }
                return n2;
            }
            else {
                n5 = (float)n3;
            }
        }
        else {
            n5 = (float)n4;
        }
        return n2 * n5;
    }
}
