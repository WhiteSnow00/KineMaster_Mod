// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.util.ArrayList;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.AbsoluteSizeSpan;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.google.android.exoplayer2.util.Assertions;
import android.text.Html;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import android.text.style.BackgroundColorSpan;
import java.util.HashSet;
import android.text.Spanned;
import java.util.Map;
import com.google.common.collect.ImmutableMap;
import java.util.regex.Pattern;

final class SpannedToHtmlConverter
{
    private static final Pattern a;
    
    static {
        a = Pattern.compile("(&#13;)?&#10;");
    }
    
    public static HtmlAndCss a(final CharSequence charSequence, final float n) {
        if (charSequence == null) {
            return new HtmlAndCss("", (Map)ImmutableMap.of(), null);
        }
        if (!(charSequence instanceof Spanned)) {
            return new HtmlAndCss(b(charSequence), (Map)ImmutableMap.of(), null);
        }
        final Spanned spanned = (Spanned)charSequence;
        final HashSet set = new HashSet();
        final int length = spanned.length();
        final int n2 = 0;
        final BackgroundColorSpan[] array = (BackgroundColorSpan[])spanned.getSpans(0, length, (Class)BackgroundColorSpan.class);
        for (int length2 = array.length, i = 0; i < length2; ++i) {
            set.add(array[i].getBackgroundColor());
        }
        final HashMap hashMap = new HashMap();
        for (final int intValue : set) {
            final StringBuilder sb = new StringBuilder();
            sb.append("bg_");
            sb.append(intValue);
            hashMap.put(com.google.android.exoplayer2.ui.b.a(sb.toString()), Util.C("background-color:%s;", com.google.android.exoplayer2.ui.b.b(intValue)));
        }
        final SparseArray<c> c = c(spanned, n);
        final StringBuilder sb2 = new StringBuilder(spanned.length());
        final int n3 = 0;
        int j = n2;
        int n4 = n3;
        while (j < c.size()) {
            final int key = c.keyAt(j);
            sb2.append(b(spanned.subSequence(n4, key)));
            final c c2 = (c)c.get(key);
            Collections.sort((List<Object>)SpannedToHtmlConverter.c.a(c2), b.c());
            final Iterator iterator2 = SpannedToHtmlConverter.c.a(c2).iterator();
            while (iterator2.hasNext()) {
                sb2.append(((b)iterator2.next()).d);
            }
            Collections.sort((List<Object>)SpannedToHtmlConverter.c.b(c2), b.d());
            final Iterator iterator3 = SpannedToHtmlConverter.c.b(c2).iterator();
            while (iterator3.hasNext()) {
                sb2.append(((b)iterator3.next()).c);
            }
            ++j;
            n4 = key;
        }
        sb2.append(b(spanned.subSequence(n4, spanned.length())));
        return new HtmlAndCss(sb2.toString(), hashMap, null);
    }
    
    private static String b(final CharSequence charSequence) {
        return SpannedToHtmlConverter.a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
    
    private static SparseArray<c> c(final Spanned spanned, final float n) {
        final SparseArray sparseArray = new SparseArray();
        final int length = spanned.length();
        int i = 0;
        for (Object[] spans = spanned.getSpans(0, length, (Class)Object.class); i < spans.length; ++i) {
            final Object o = spans[i];
            final String e = e(o, n);
            final String d = d(o);
            final int spanStart = spanned.getSpanStart(o);
            final int spanEnd = spanned.getSpanEnd(o);
            if (e != null) {
                Assertions.e(d);
                final b b = new b(spanStart, spanEnd, e, d, null);
                c.b(f((SparseArray<c>)sparseArray, spanStart)).add(b);
                c.a(f((SparseArray<c>)sparseArray, spanEnd)).add(b);
            }
        }
        return (SparseArray<c>)sparseArray;
    }
    
    private static String d(final Object o) {
        final boolean b = o instanceof StrikethroughSpan;
        final String s = "</span>";
        if (b || o instanceof ForegroundColorSpan || o instanceof BackgroundColorSpan || o instanceof HorizontalTextInVerticalContextSpan || o instanceof AbsoluteSizeSpan || o instanceof RelativeSizeSpan || o instanceof TextEmphasisSpan) {
            return "</span>";
        }
        if (o instanceof TypefaceSpan) {
            String s2;
            if (((TypefaceSpan)o).getFamily() != null) {
                s2 = s;
            }
            else {
                s2 = null;
            }
            return s2;
        }
        if (o instanceof StyleSpan) {
            final int style = ((StyleSpan)o).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        }
        else {
            if (o instanceof RubySpan) {
                final RubySpan rubySpan = (RubySpan)o;
                final StringBuilder sb = new StringBuilder();
                sb.append("<rt>");
                sb.append(b(rubySpan.a));
                sb.append("</rt></ruby>");
                return sb.toString();
            }
            if (o instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }
    
    private static String e(final Object o, float n) {
        if (o instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (o instanceof ForegroundColorSpan) {
            return Util.C("<span style='color:%s;'>", com.google.android.exoplayer2.ui.b.b(((ForegroundColorSpan)o).getForegroundColor()));
        }
        if (o instanceof BackgroundColorSpan) {
            return Util.C("<span class='bg_%s'>", ((BackgroundColorSpan)o).getBackgroundColor());
        }
        if (o instanceof HorizontalTextInVerticalContextSpan) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (o instanceof AbsoluteSizeSpan) {
            final AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan)o;
            if (absoluteSizeSpan.getDip()) {
                n = (float)absoluteSizeSpan.getSize();
            }
            else {
                n = absoluteSizeSpan.getSize() / n;
            }
            return Util.C("<span style='font-size:%.2fpx;'>", n);
        }
        if (o instanceof RelativeSizeSpan) {
            return Util.C("<span style='font-size:%.2f%%;'>", ((RelativeSizeSpan)o).getSizeChange() * 100.0f);
        }
        final boolean b = o instanceof TypefaceSpan;
        final String s = null;
        if (b) {
            final String family = ((TypefaceSpan)o).getFamily();
            String c = s;
            if (family != null) {
                c = Util.C("<span style='font-family:\"%s\";'>", family);
            }
            return c;
        }
        if (o instanceof StyleSpan) {
            final int style = ((StyleSpan)o).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        else if (o instanceof RubySpan) {
            final int b2 = ((RubySpan)o).b;
            if (b2 == -1) {
                return "<ruby style='ruby-position:unset;'>";
            }
            if (b2 == 1) {
                return "<ruby style='ruby-position:over;'>";
            }
            if (b2 != 2) {
                return null;
            }
            return "<ruby style='ruby-position:under;'>";
        }
        else {
            if (o instanceof UnderlineSpan) {
                return "<u>";
            }
            if (o instanceof TextEmphasisSpan) {
                final TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan)o;
                return Util.C("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(textEmphasisSpan.a, textEmphasisSpan.b), g(textEmphasisSpan.c));
            }
            return null;
        }
    }
    
    private static c f(final SparseArray<c> sparseArray, final int n) {
        c c;
        if ((c = (c)sparseArray.get(n)) == null) {
            c = new c();
            sparseArray.put(n, (Object)c);
        }
        return c;
    }
    
    private static String g(final int n) {
        if (n != 2) {
            return "over right";
        }
        return "under left";
    }
    
    private static String h(final int n, final int n2) {
        final StringBuilder sb = new StringBuilder();
        if (n2 != 1) {
            if (n2 == 2) {
                sb.append("open ");
            }
        }
        else {
            sb.append("filled ");
        }
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        sb.append("unset");
                    }
                    else {
                        sb.append("sesame");
                    }
                }
                else {
                    sb.append("dot");
                }
            }
            else {
                sb.append("circle");
            }
        }
        else {
            sb.append("none");
        }
        return sb.toString();
    }
    
    public static class HtmlAndCss
    {
        public final String a;
        public final Map<String, String> b;
        
        private HtmlAndCss(final String a, final Map<String, String> b) {
            this.a = a;
            this.b = b;
        }
        
        HtmlAndCss(final String s, final Map map, final SpannedToHtmlConverter$a object) {
            this(s, map);
        }
    }
    
    private static final class b
    {
        private static final Comparator<b> e;
        private static final Comparator<b> f;
        public final int a;
        public final int b;
        public final String c;
        public final String d;
        
        static {
            e = com.google.android.exoplayer2.ui.c.a;
            f = d.a;
        }
        
        private b(final int a, final int b, final String c, final String d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        b(final int n, final int n2, final String s, final String s2, final SpannedToHtmlConverter$a object) {
            this(n, n2, s, s2);
        }
        
        public static int a(final b b, final b b2) {
            return e(b, b2);
        }
        
        public static int b(final b b, final b b2) {
            return f(b, b2);
        }
        
        static Comparator c() {
            return b.f;
        }
        
        static Comparator d() {
            return b.e;
        }
        
        private static int e(final b b, final b b2) {
            final int compare = Integer.compare(b2.b, b.b);
            if (compare != 0) {
                return compare;
            }
            final int compareTo = b.c.compareTo(b2.c);
            if (compareTo != 0) {
                return compareTo;
            }
            return b.d.compareTo(b2.d);
        }
        
        private static int f(final b b, final b b2) {
            final int compare = Integer.compare(b2.a, b.a);
            if (compare != 0) {
                return compare;
            }
            final int compareTo = b2.c.compareTo(b.c);
            if (compareTo != 0) {
                return compareTo;
            }
            return b2.d.compareTo(b.d);
        }
    }
    
    private static final class c
    {
        private final List<b> a;
        private final List<b> b;
        
        public c() {
            this.a = new ArrayList<b>();
            this.b = new ArrayList<b>();
        }
        
        static List a(final c c) {
            return c.b;
        }
        
        static List b(final c c) {
            return c.a;
        }
    }
}
