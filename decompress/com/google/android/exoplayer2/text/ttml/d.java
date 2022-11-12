// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ttml;

import java.util.ArrayDeque;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import com.google.android.exoplayer2.util.Assertions;
import android.text.style.TypefaceSpan;
import android.text.style.BackgroundColorSpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import java.util.Map;
import android.text.Spannable;

final class d
{
    public static void a(final Spannable spannable, final int n, final int n2, final TtmlStyle ttmlStyle, final b b, final Map<String, TtmlStyle> map, int n3) {
        if (ttmlStyle.l() != -1) {
            spannable.setSpan((Object)new StyleSpan(ttmlStyle.l()), n, n2, 33);
        }
        if (ttmlStyle.s()) {
            spannable.setSpan((Object)new StrikethroughSpan(), n, n2, 33);
        }
        if (ttmlStyle.t()) {
            spannable.setSpan((Object)new UnderlineSpan(), n, n2, 33);
        }
        if (ttmlStyle.q()) {
            SpanUtil.a(spannable, new ForegroundColorSpan(ttmlStyle.c()), n, n2, 33);
        }
        if (ttmlStyle.p()) {
            SpanUtil.a(spannable, new BackgroundColorSpan(ttmlStyle.b()), n, n2, 33);
        }
        if (ttmlStyle.d() != null) {
            SpanUtil.a(spannable, new TypefaceSpan(ttmlStyle.d()), n, n2, 33);
        }
        if (ttmlStyle.o() != null) {
            final TextEmphasis textEmphasis = Assertions.e(ttmlStyle.o());
            final int a = textEmphasis.a;
            int b2;
            if (a == -1) {
                if (n3 != 2 && n3 != 1) {
                    n3 = 1;
                }
                else {
                    n3 = 3;
                }
                b2 = 1;
            }
            else {
                b2 = textEmphasis.b;
                n3 = a;
            }
            int c;
            if ((c = textEmphasis.c) == -2) {
                c = 1;
            }
            SpanUtil.a(spannable, new TextEmphasisSpan(n3, b2, c), n, n2, 33);
        }
        n3 = ttmlStyle.j();
        if (n3 != 2) {
            if (n3 == 3 || n3 == 4) {
                spannable.setSpan((Object)new a(), n, n2, 33);
            }
        }
        else {
            final b d = d(b, map);
            if (d != null) {
                final b e = e(d, map);
                if (e != null) {
                    if (e.g() == 1 && e.f(0).b != null) {
                        final String s = Util.j(e.f(0).b);
                        final TtmlStyle f = f(e.f, e.l(), map);
                        if (f != null) {
                            n3 = f.i();
                        }
                        else {
                            n3 = -1;
                        }
                        int i = n3;
                        if (n3 == -1) {
                            final TtmlStyle f2 = f(d.f, d.l(), map);
                            i = n3;
                            if (f2 != null) {
                                i = f2.i();
                            }
                        }
                        spannable.setSpan((Object)new RubySpan(s, i), n, n2, 33);
                    }
                    else {
                        Log.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                    }
                }
            }
        }
        if (ttmlStyle.n()) {
            SpanUtil.a(spannable, new HorizontalTextInVerticalContextSpan(), n, n2, 33);
        }
        n3 = ttmlStyle.f();
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 == 3) {
                    SpanUtil.a(spannable, new RelativeSizeSpan(ttmlStyle.e() / 100.0f), n, n2, 33);
                }
            }
            else {
                SpanUtil.a(spannable, new RelativeSizeSpan(ttmlStyle.e()), n, n2, 33);
            }
        }
        else {
            SpanUtil.a(spannable, new AbsoluteSizeSpan((int)ttmlStyle.e(), true), n, n2, 33);
        }
    }
    
    static String b(final String s) {
        return s.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }
    
    static void c(final SpannableStringBuilder spannableStringBuilder) {
        int n;
        for (n = spannableStringBuilder.length() - 1; n >= 0 && spannableStringBuilder.charAt(n) == ' '; --n) {}
        if (n >= 0 && spannableStringBuilder.charAt(n) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }
    
    private static b d(b j, final Map<String, TtmlStyle> map) {
        while (j != null) {
            final TtmlStyle f = f(j.f, j.l(), map);
            if (f != null && f.j() == 1) {
                return j;
            }
            j = j.j;
        }
        return null;
    }
    
    private static b e(b b, final Map<String, TtmlStyle> map) {
        final ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(b);
        while (!arrayDeque.isEmpty()) {
            b = (b)arrayDeque.pop();
            final TtmlStyle f = f(b.f, b.l(), map);
            if (f != null && f.j() == 3) {
                return b;
            }
            for (int i = b.g() - 1; i >= 0; --i) {
                arrayDeque.push(b.f(i));
            }
        }
        return null;
    }
    
    public static TtmlStyle f(TtmlStyle ttmlStyle, final String[] array, final Map<String, TtmlStyle> map) {
        int i = 0;
        final int n = 0;
        if (ttmlStyle == null) {
            if (array == null) {
                return null;
            }
            if (array.length == 1) {
                return map.get(array[0]);
            }
            if (array.length > 1) {
                ttmlStyle = new TtmlStyle();
                for (int length = array.length, j = n; j < length; ++j) {
                    ttmlStyle.a(map.get(array[j]));
                }
                return ttmlStyle;
            }
        }
        else {
            if (array != null && array.length == 1) {
                return ttmlStyle.a(map.get(array[0]));
            }
            if (array != null && array.length > 1) {
                while (i < array.length) {
                    ttmlStyle.a(map.get(array[i]));
                    ++i;
                }
            }
        }
        return ttmlStyle;
    }
}
