// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout$Alignment;
import java.util.HashSet;
import java.util.ArrayDeque;
import android.text.SpannedString;
import android.text.TextUtils;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TypefaceSpan;
import android.text.style.StrikethroughSpan;
import android.text.Spannable;
import com.google.android.exoplayer2.text.span.SpanUtil;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import java.util.Comparator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.google.android.exoplayer2.util.Log;
import java.util.Iterator;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import java.util.Set;
import android.text.SpannableStringBuilder;
import java.util.Collections;
import android.graphics.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class WebvttCueParser
{
    public static final Pattern a;
    private static final Pattern b;
    private static final Map<String, Integer> c;
    private static final Map<String, Integer> d;
    
    static {
        a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        b = Pattern.compile("(\\S+?):(\\S+)");
        final HashMap hashMap = new HashMap();
        hashMap.put("white", Color.rgb(255, 255, 255));
        hashMap.put("lime", Color.rgb(0, 255, 0));
        hashMap.put("cyan", Color.rgb(0, 255, 255));
        hashMap.put("red", Color.rgb(255, 0, 0));
        hashMap.put("yellow", Color.rgb(255, 255, 0));
        hashMap.put("magenta", Color.rgb(255, 0, 255));
        hashMap.put("blue", Color.rgb(0, 0, 255));
        hashMap.put("black", Color.rgb(0, 0, 0));
        c = Collections.unmodifiableMap((Map<?, ?>)hashMap);
        final HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Color.rgb(255, 255, 255));
        hashMap2.put("bg_lime", Color.rgb(0, 255, 0));
        hashMap2.put("bg_cyan", Color.rgb(0, 255, 255));
        hashMap2.put("bg_red", Color.rgb(255, 0, 0));
        hashMap2.put("bg_yellow", Color.rgb(255, 255, 0));
        hashMap2.put("bg_magenta", Color.rgb(255, 0, 255));
        hashMap2.put("bg_blue", Color.rgb(0, 0, 255));
        hashMap2.put("bg_black", Color.rgb(0, 0, 0));
        d = Collections.unmodifiableMap((Map<?, ?>)hashMap2);
    }
    
    private static void a(final SpannableStringBuilder spannableStringBuilder, final Set<String> set, final int n, final int n2) {
        for (final String s : set) {
            final Map<String, Integer> c = WebvttCueParser.c;
            if (c.containsKey(s)) {
                spannableStringBuilder.setSpan((Object)new ForegroundColorSpan((int)c.get(s)), n, n2, 33);
            }
            else {
                final Map<String, Integer> d = WebvttCueParser.d;
                if (!d.containsKey(s)) {
                    continue;
                }
                spannableStringBuilder.setSpan((Object)new BackgroundColorSpan((int)d.get(s)), n, n2, 33);
            }
        }
    }
    
    private static void b(final String s, final SpannableStringBuilder spannableStringBuilder) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 3374865: {
                if (!s.equals("nbsp")) {
                    break;
                }
                n = 3;
                break;
            }
            case 96708: {
                if (!s.equals("amp")) {
                    break;
                }
                n = 2;
                break;
            }
            case 3464: {
                if (!s.equals("lt")) {
                    break;
                }
                n = 1;
                break;
            }
            case 3309: {
                if (!s.equals("gt")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("ignoring unsupported entity: '&");
                sb.append(s);
                sb.append(";'");
                Log.i("WebvttCueParser", sb.toString());
                break;
            }
            case 3: {
                spannableStringBuilder.append(' ');
                break;
            }
            case 2: {
                spannableStringBuilder.append('&');
                break;
            }
            case 1: {
                spannableStringBuilder.append('<');
                break;
            }
            case 0: {
                spannableStringBuilder.append('>');
                break;
            }
        }
    }
    
    private static void c(final SpannableStringBuilder spannableStringBuilder, final String s, final c c, final List<b> list, final List<WebvttCssStyle> list2) {
        final int i = i(list2, s, c);
        final ArrayList list3 = new ArrayList(list.size());
        list3.addAll(list);
        Collections.sort((List<Object>)list3, WebvttCueParser.b.b());
        int b = c.b;
        int j = 0;
        int n = 0;
        while (j < list3.size()) {
            if ("rt".equals(WebvttCueParser.b.c((b)list3.get(j)).a)) {
                final b b2 = (b)list3.get(j);
                final int g = g(i(list2, s, WebvttCueParser.b.c(b2)), i, 1);
                final int n2 = WebvttCueParser.b.c(b2).b - n;
                final int n3 = WebvttCueParser.b.d(b2) - n;
                final CharSequence subSequence = spannableStringBuilder.subSequence(n2, n3);
                spannableStringBuilder.delete(n2, n3);
                spannableStringBuilder.setSpan((Object)new RubySpan(subSequence.toString(), g), b, n2, 33);
                n += subSequence.length();
                b = n2;
            }
            ++j;
        }
    }
    
    private static void d(final String s, final c c, final List<b> list, final SpannableStringBuilder spannableStringBuilder, final List<WebvttCssStyle> list2) {
        final int b = c.b;
        final int length = spannableStringBuilder.length();
        final String a = c.a;
        a.hashCode();
        final int hashCode = a.hashCode();
        final int n = 0;
        int n2 = -1;
        switch (hashCode) {
            case 3511770: {
                if (!a.equals("ruby")) {
                    break;
                }
                n2 = 7;
                break;
            }
            case 3314158: {
                if (!a.equals("lang")) {
                    break;
                }
                n2 = 6;
                break;
            }
            case 118: {
                if (!a.equals("v")) {
                    break;
                }
                n2 = 5;
                break;
            }
            case 117: {
                if (!a.equals("u")) {
                    break;
                }
                n2 = 4;
                break;
            }
            case 105: {
                if (!a.equals("i")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case 99: {
                if (!a.equals("c")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case 98: {
                if (!a.equals("b")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case 0: {
                if (!a.equals("")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        while (true) {
            switch (n2) {
                default: {
                    return;
                }
                case 0:
                case 5:
                case 6: {
                    final List<d> h = h(list2, s, c);
                    for (int i = n; i < h.size(); ++i) {
                        e(spannableStringBuilder, ((d)h.get(i)).b, b, length);
                    }
                    return;
                }
                case 7: {
                    c(spannableStringBuilder, s, c, list, list2);
                    continue;
                }
                case 4: {
                    spannableStringBuilder.setSpan((Object)new UnderlineSpan(), b, length, 33);
                    continue;
                }
                case 3: {
                    spannableStringBuilder.setSpan((Object)new StyleSpan(2), b, length, 33);
                    continue;
                }
                case 2: {
                    a(spannableStringBuilder, c.d, b, length);
                    continue;
                }
                case 1: {
                    spannableStringBuilder.setSpan((Object)new StyleSpan(1), b, length, 33);
                    continue;
                }
            }
            break;
        }
    }
    
    private static void e(final SpannableStringBuilder spannableStringBuilder, final WebvttCssStyle webvttCssStyle, final int n, final int n2) {
        if (webvttCssStyle == null) {
            return;
        }
        if (webvttCssStyle.i() != -1) {
            SpanUtil.a((Spannable)spannableStringBuilder, new StyleSpan(webvttCssStyle.i()), n, n2, 33);
        }
        if (webvttCssStyle.l()) {
            spannableStringBuilder.setSpan((Object)new StrikethroughSpan(), n, n2, 33);
        }
        if (webvttCssStyle.m()) {
            spannableStringBuilder.setSpan((Object)new UnderlineSpan(), n, n2, 33);
        }
        if (webvttCssStyle.k()) {
            SpanUtil.a((Spannable)spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.c()), n, n2, 33);
        }
        if (webvttCssStyle.j()) {
            SpanUtil.a((Spannable)spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.a()), n, n2, 33);
        }
        if (webvttCssStyle.d() != null) {
            SpanUtil.a((Spannable)spannableStringBuilder, new TypefaceSpan(webvttCssStyle.d()), n, n2, 33);
        }
        final int f = webvttCssStyle.f();
        if (f != 1) {
            if (f != 2) {
                if (f == 3) {
                    SpanUtil.a((Spannable)spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e() / 100.0f), n, n2, 33);
                }
            }
            else {
                SpanUtil.a((Spannable)spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e()), n, n2, 33);
            }
        }
        else {
            SpanUtil.a((Spannable)spannableStringBuilder, new AbsoluteSizeSpan((int)webvttCssStyle.e(), true), n, n2, 33);
        }
        if (webvttCssStyle.b()) {
            spannableStringBuilder.setSpan((Object)new HorizontalTextInVerticalContextSpan(), n, n2, 33);
        }
    }
    
    private static int f(final String s, int n) {
        n = s.indexOf(62, n);
        if (n == -1) {
            n = s.length();
        }
        else {
            ++n;
        }
        return n;
    }
    
    private static int g(final int n, final int n2, final int n3) {
        if (n != -1) {
            return n;
        }
        if (n2 != -1) {
            return n2;
        }
        if (n3 != -1) {
            return n3;
        }
        throw new IllegalArgumentException();
    }
    
    private static List<d> h(final List<WebvttCssStyle> list, final String s, final c c) {
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            final WebvttCssStyle webvttCssStyle = list.get(i);
            final int h = webvttCssStyle.h(s, c.a, c.d, c.c);
            if (h > 0) {
                list2.add(new d(h, webvttCssStyle));
            }
        }
        Collections.sort((List<Comparable>)list2);
        return list2;
    }
    
    private static int i(final List<WebvttCssStyle> list, final String s, final c c) {
        final List<d> h = h(list, s, c);
        for (int i = 0; i < h.size(); ++i) {
            final WebvttCssStyle b = h.get(i).b;
            if (b.g() != -1) {
                return b.g();
            }
        }
        return -1;
    }
    
    private static String j(String trim) {
        trim = trim.trim();
        Assertions.a(trim.isEmpty() ^ true);
        return Util.U0(trim, "[ \\.]")[0];
    }
    
    private static boolean k(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 3511770: {
                if (!s.equals("ruby")) {
                    break;
                }
                n = 7;
                break;
            }
            case 3314158: {
                if (!s.equals("lang")) {
                    break;
                }
                n = 6;
                break;
            }
            case 3650: {
                if (!s.equals("rt")) {
                    break;
                }
                n = 5;
                break;
            }
            case 118: {
                if (!s.equals("v")) {
                    break;
                }
                n = 4;
                break;
            }
            case 117: {
                if (!s.equals("u")) {
                    break;
                }
                n = 3;
                break;
            }
            case 105: {
                if (!s.equals("i")) {
                    break;
                }
                n = 2;
                break;
            }
            case 99: {
                if (!s.equals("c")) {
                    break;
                }
                n = 1;
                break;
            }
            case 98: {
                if (!s.equals("b")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return false;
            }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7: {
                return true;
            }
        }
    }
    
    static Cue l(final CharSequence c) {
        final e e = new e();
        e.c = c;
        return e.g().a();
    }
    
    public static WebvttCueInfo m(final ParsableByteArray parsableByteArray, final List<WebvttCssStyle> list) {
        final String p2 = parsableByteArray.p();
        if (p2 == null) {
            return null;
        }
        final Pattern a = WebvttCueParser.a;
        final Matcher matcher = a.matcher(p2);
        if (matcher.matches()) {
            return n(null, matcher, parsableByteArray, list);
        }
        final String p3 = parsableByteArray.p();
        if (p3 == null) {
            return null;
        }
        final Matcher matcher2 = a.matcher(p3);
        if (matcher2.matches()) {
            return n(p2.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }
    
    private static WebvttCueInfo n(final String s, Matcher o, final ParsableByteArray parsableByteArray, final List<WebvttCssStyle> list) {
        final e e = new e();
        try {
            e.a = WebvttParserUtil.d(Assertions.e(((Matcher)o).group(1)));
            e.b = WebvttParserUtil.d(Assertions.e(((Matcher)o).group(2)));
            p(Assertions.e(((Matcher)o).group(3)), e);
            final StringBuilder sb = new StringBuilder();
            for (o = parsableByteArray.p(); !TextUtils.isEmpty((CharSequence)o); o = parsableByteArray.p()) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(((String)o).trim());
            }
            e.c = (CharSequence)q(s, sb.toString(), list);
            return e.a();
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Skipping cue with bad header: ");
            sb2.append(((Matcher)o).group());
            Log.i("WebvttCueParser", sb2.toString());
            return null;
        }
    }
    
    static Cue.Builder o(final String s) {
        final e e = new e();
        p(s, e);
        return e.g();
    }
    
    private static void p(String matcher, final e e) {
        matcher = (String)WebvttCueParser.b.matcher(matcher);
        while (((Matcher)matcher).find()) {
            final String s = Assertions.e(((Matcher)matcher).group(1));
            final String s2 = Assertions.e(((Matcher)matcher).group(2));
            try {
                if ("line".equals(s)) {
                    s(s2, e);
                }
                else if ("align".equals(s)) {
                    e.d = v(s2);
                }
                else if ("position".equals(s)) {
                    u(s2, e);
                }
                else if ("size".equals(s)) {
                    e.j = WebvttParserUtil.c(s2);
                }
                else if ("vertical".equals(s)) {
                    e.k = w(s2);
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown cue setting ");
                    sb.append(s);
                    sb.append(":");
                    sb.append(s2);
                    Log.i("WebvttCueParser", sb.toString());
                }
            }
            catch (final NumberFormatException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipping bad cue setting: ");
                sb2.append(((Matcher)matcher).group());
                Log.i("WebvttCueParser", sb2.toString());
            }
        }
    }
    
    static SpannedString q(final String s, final String s2, final List<WebvttCssStyle> list) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final ArrayDeque arrayDeque = new ArrayDeque();
        final ArrayList list2 = new ArrayList();
        int i = 0;
        while (i < s2.length()) {
            final char char1 = s2.charAt(i);
            if (char1 != '&') {
                if (char1 != '<') {
                    spannableStringBuilder.append(char1);
                    ++i;
                }
                else {
                    final int n = i + 1;
                    if (n >= s2.length()) {
                        i = n;
                    }
                    else {
                        final char char2 = s2.charAt(n);
                        int n2 = 1;
                        final boolean b = char2 == '/';
                        final int f = f(s2, n);
                        int n3 = f - 2;
                        final boolean b2 = s2.charAt(n3) == '/';
                        if (b) {
                            n2 = 2;
                        }
                        if (!b2) {
                            n3 = f - 1;
                        }
                        final String substring = s2.substring(i + n2, n3);
                        if (substring.trim().isEmpty()) {
                            i = f;
                        }
                        else {
                            final String j = j(substring);
                            if (!k(j)) {
                                i = f;
                            }
                            else if (b) {
                                while (!arrayDeque.isEmpty()) {
                                    final c c = arrayDeque.pop();
                                    d(s, c, list2, spannableStringBuilder, list);
                                    if (!arrayDeque.isEmpty()) {
                                        list2.add(new b(c, spannableStringBuilder.length(), null));
                                    }
                                    else {
                                        list2.clear();
                                    }
                                    if (c.a.equals(j)) {
                                        i = f;
                                        continue Label_0226;
                                    }
                                }
                                i = f;
                            }
                            else {
                                i = f;
                                if (b2) {
                                    continue;
                                }
                                arrayDeque.push(WebvttCueParser.c.a(substring, spannableStringBuilder.length()));
                                i = f;
                            }
                        }
                    }
                    Label_0226:;
                }
            }
            else {
                final int n4 = i + 1;
                i = s2.indexOf(59, n4);
                final int index = s2.indexOf(32, n4);
                if (i == -1) {
                    i = index;
                }
                else if (index != -1) {
                    i = Math.min(i, index);
                }
                if (i != -1) {
                    b(s2.substring(n4, i), spannableStringBuilder);
                    if (i == index) {
                        spannableStringBuilder.append((CharSequence)" ");
                    }
                    ++i;
                }
                else {
                    spannableStringBuilder.append(char1);
                    i = n4;
                }
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(s, arrayDeque.pop(), list2, spannableStringBuilder, list);
        }
        d(s, WebvttCueParser.c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf((CharSequence)spannableStringBuilder);
    }
    
    private static int r(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 109757538: {
                if (!s.equals("start")) {
                    break;
                }
                n = 3;
                break;
            }
            case 100571: {
                if (!s.equals("end")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1074341483: {
                if (!s.equals("middle")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1364013995: {
                if (!s.equals("center")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid anchor value: ");
                sb.append(s);
                Log.i("WebvttCueParser", sb.toString());
                return Integer.MIN_VALUE;
            }
            case 3: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 0:
            case 1: {
                return 1;
            }
        }
    }
    
    private static void s(final String s, final e e) {
        final int index = s.indexOf(44);
        String substring = s;
        if (index != -1) {
            e.g = r(s.substring(index + 1));
            substring = s.substring(0, index);
        }
        if (substring.endsWith("%")) {
            e.e = WebvttParserUtil.c(substring);
            e.f = 0;
        }
        else {
            e.e = (float)Integer.parseInt(substring);
            e.f = 1;
        }
    }
    
    private static int t(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 109757538: {
                if (!s.equals("start")) {
                    break;
                }
                n = 5;
                break;
            }
            case 100571: {
                if (!s.equals("end")) {
                    break;
                }
                n = 4;
                break;
            }
            case -1074341483: {
                if (!s.equals("middle")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1276788989: {
                if (!s.equals("line-right")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1364013995: {
                if (!s.equals("center")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1842484672: {
                if (!s.equals("line-left")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid anchor value: ");
                sb.append(s);
                Log.i("WebvttCueParser", sb.toString());
                return Integer.MIN_VALUE;
            }
            case 2:
            case 4: {
                return 2;
            }
            case 1:
            case 3: {
                return 1;
            }
            case 0:
            case 5: {
                return 0;
            }
        }
    }
    
    private static void u(final String s, final e e) {
        final int index = s.indexOf(44);
        String substring = s;
        if (index != -1) {
            e.i = t(s.substring(index + 1));
            substring = s.substring(0, index);
        }
        e.h = WebvttParserUtil.c(substring);
    }
    
    private static int v(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 109757538: {
                if (!s.equals("start")) {
                    break;
                }
                n = 5;
                break;
            }
            case 108511772: {
                if (!s.equals("right")) {
                    break;
                }
                n = 4;
                break;
            }
            case 3317767: {
                if (!s.equals("left")) {
                    break;
                }
                n = 3;
                break;
            }
            case 100571: {
                if (!s.equals("end")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1074341483: {
                if (!s.equals("middle")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1364013995: {
                if (!s.equals("center")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Invalid alignment value: ");
                sb.append(s);
                Log.i("WebvttCueParser", sb.toString());
                return 2;
            }
            case 5: {
                return 1;
            }
            case 4: {
                return 5;
            }
            case 3: {
                return 4;
            }
            case 2: {
                return 3;
            }
            case 0:
            case 1: {
                return 2;
            }
        }
    }
    
    private static int w(final String s) {
        s.hashCode();
        if (s.equals("lr")) {
            return 2;
        }
        if (!s.equals("rl")) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid 'vertical' value: ");
            sb.append(s);
            Log.i("WebvttCueParser", sb.toString());
            return Integer.MIN_VALUE;
        }
        return 1;
    }
    
    private static class b
    {
        private static final Comparator<b> c;
        private final c a;
        private final int b;
        
        static {
            c = com.google.android.exoplayer2.text.webvtt.c.a;
        }
        
        private b(final c a, final int b) {
            this.a = a;
            this.b = b;
        }
        
        b(final c c, final int n, final WebvttCueParser$a object) {
            this(c, n);
        }
        
        public static int a(final b b, final b b2) {
            return e(b, b2);
        }
        
        static Comparator b() {
            return b.c;
        }
        
        static c c(final b b) {
            return b.a;
        }
        
        static int d(final b b) {
            return b.b;
        }
        
        private static int e(final b b, final b b2) {
            return Integer.compare(b.a.b, b2.a.b);
        }
    }
    
    private static final class c
    {
        public final String a;
        public final int b;
        public final String c;
        public final Set<String> d;
        
        private c(final String a, final int b, final String c, final Set<String> d) {
            this.b = b;
            this.a = a;
            this.c = c;
            this.d = d;
        }
        
        public static c a(String trim, final int n) {
            String s = trim.trim();
            final boolean empty = s.isEmpty();
            int i = 1;
            Assertions.a(empty ^ true);
            final int index = s.indexOf(" ");
            if (index == -1) {
                trim = "";
            }
            else {
                trim = s.substring(index).trim();
                s = s.substring(0, index);
            }
            final String[] t0 = Util.T0(s, "\\.");
            final String s2 = t0[0];
            final HashSet set = new HashSet();
            while (i < t0.length) {
                set.add(t0[i]);
                ++i;
            }
            return new c(s2, n, trim, set);
        }
        
        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }
    
    private static final class d implements Comparable<d>
    {
        public final int a;
        public final WebvttCssStyle b;
        
        public d(final int a, final WebvttCssStyle b) {
            this.a = a;
            this.b = b;
        }
        
        public int a(final d d) {
            return Integer.compare(this.a, d.a);
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((d)o);
        }
    }
    
    private static final class e
    {
        public long a;
        public long b;
        public CharSequence c;
        public int d;
        public float e;
        public int f;
        public int g;
        public float h;
        public int i;
        public float j;
        public int k;
        
        public e() {
            this.a = 0L;
            this.b = 0L;
            this.d = 2;
            this.e = -3.4028235E38f;
            this.f = 1;
            this.g = 0;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = 1.0f;
            this.k = Integer.MIN_VALUE;
        }
        
        private static float b(final float n, final int n2) {
            final float n3 = fcmpl(n, -3.4028235E38f);
            if (n3 != 0 && n2 == 0 && (n < 0.0f || n > 1.0f)) {
                return 1.0f;
            }
            if (n3 != 0) {
                return n;
            }
            if (n2 == 0) {
                return 1.0f;
            }
            return -3.4028235E38f;
        }
        
        private static Layout$Alignment c(final int n) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 4) {
                            return Layout$Alignment.ALIGN_NORMAL;
                        }
                        if (n != 5) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Unknown textAlignment: ");
                            sb.append(n);
                            Log.i("WebvttCueParser", sb.toString());
                            return null;
                        }
                    }
                    return Layout$Alignment.ALIGN_OPPOSITE;
                }
                return Layout$Alignment.ALIGN_CENTER;
            }
            return Layout$Alignment.ALIGN_NORMAL;
        }
        
        private static float d(final int n, final float n2) {
            if (n == 0) {
                return 1.0f - n2;
            }
            if (n != 1) {
                if (n == 2) {
                    return n2;
                }
                throw new IllegalStateException(String.valueOf(n));
            }
            else {
                if (n2 <= 0.5f) {
                    return n2 * 2.0f;
                }
                return (1.0f - n2) * 2.0f;
            }
        }
        
        private static float e(final int n) {
            if (n == 4) {
                return 0.0f;
            }
            if (n != 5) {
                return 0.5f;
            }
            return 1.0f;
        }
        
        private static int f(final int n) {
            if (n != 1) {
                if (n != 3) {
                    if (n == 4) {
                        return 0;
                    }
                    if (n != 5) {
                        return 1;
                    }
                }
                return 2;
            }
            return 0;
        }
        
        public WebvttCueInfo a() {
            return new WebvttCueInfo(this.g().a(), this.a, this.b);
        }
        
        public Cue.Builder g() {
            float n = this.h;
            if (n == -3.4028235E38f) {
                n = e(this.d);
            }
            int n2 = this.i;
            if (n2 == Integer.MIN_VALUE) {
                n2 = f(this.d);
            }
            final Cue.Builder r = new Cue.Builder().p(c(this.d)).h(b(this.e, this.f), this.f).i(this.g).k(n).l(n2).n(Math.min(this.j, d(n2, n))).r(this.k);
            final CharSequence c = this.c;
            if (c != null) {
                r.o(c);
            }
            return r;
        }
    }
}
