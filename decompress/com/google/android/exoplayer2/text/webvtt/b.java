// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import java.util.ArrayList;
import java.util.List;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Ascii;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Pattern;

final class b
{
    private static final Pattern c;
    private static final Pattern d;
    private final ParsableByteArray a;
    private final StringBuilder b;
    
    static {
        c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
        d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    }
    
    public b() {
        this.a = new ParsableByteArray();
        this.b = new StringBuilder();
    }
    
    private void a(final WebvttCssStyle webvttCssStyle, String s) {
        if ("".equals(s)) {
            return;
        }
        final int index = s.indexOf(91);
        String substring = s;
        if (index != -1) {
            final Matcher matcher = com.google.android.exoplayer2.text.webvtt.b.c.matcher(s.substring(index));
            if (matcher.matches()) {
                webvttCssStyle.z(Assertions.e(matcher.group(1)));
            }
            substring = s.substring(0, index);
        }
        final String[] t0 = Util.T0(substring, "\\.");
        s = t0[0];
        final int index2 = s.indexOf(35);
        if (index2 != -1) {
            webvttCssStyle.y(s.substring(0, index2));
            webvttCssStyle.x(s.substring(index2 + 1));
        }
        else {
            webvttCssStyle.y(s);
        }
        if (t0.length > 1) {
            webvttCssStyle.w(Util.I0(t0, 1, t0.length));
        }
    }
    
    private static boolean b(final ParsableByteArray parsableByteArray) {
        final int e = parsableByteArray.e();
        int f = parsableByteArray.f();
        final byte[] d = parsableByteArray.d();
        if (e + 2 <= f) {
            final int n = e + 1;
            if (d[e] == 47) {
                int n2 = n + 1;
                if (d[n] == 42) {
                    while (true) {
                        final int n3 = n2 + 1;
                        if (n3 >= f) {
                            break;
                        }
                        if ((char)d[n2] == '*' && (char)d[n3] == '/') {
                            n2 = (f = n3 + 1);
                        }
                        else {
                            n2 = n3;
                        }
                    }
                    parsableByteArray.Q(f - parsableByteArray.e());
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean c(final ParsableByteArray parsableByteArray) {
        final char k = k(parsableByteArray, parsableByteArray.e());
        if (k != '\t' && k != '\n' && k != '\f' && k != '\r' && k != ' ') {
            return false;
        }
        parsableByteArray.Q(1);
        return true;
    }
    
    private static void e(String s, final WebvttCssStyle webvttCssStyle) {
        final Matcher matcher = b.d.matcher(Ascii.e(s));
        if (!matcher.matches()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid font-size: '");
            sb.append(s);
            sb.append("'.");
            Log.i("WebvttCssParser", sb.toString());
            return;
        }
        s = Assertions.e(matcher.group(2));
        s.hashCode();
        int n = -1;
        switch (s) {
            case "px": {
                n = 2;
                break;
            }
            case "em": {
                n = 1;
                break;
            }
            case "%": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                throw new IllegalStateException();
            }
            case 2: {
                webvttCssStyle.t(1);
                break;
            }
            case 1: {
                webvttCssStyle.t(2);
                break;
            }
            case 0: {
                webvttCssStyle.t(3);
                break;
            }
        }
        webvttCssStyle.s(Float.parseFloat(Assertions.e(matcher.group(1))));
    }
    
    private static String f(final ParsableByteArray parsableByteArray, final StringBuilder sb) {
        int n = 0;
        sb.setLength(0);
        int e = parsableByteArray.e();
        while (e < parsableByteArray.f() && n == 0) {
            final char c = (char)parsableByteArray.d()[e];
            if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '#' && c != '-' && c != '.' && c != '_') {
                n = 1;
            }
            else {
                ++e;
                sb.append(c);
            }
        }
        parsableByteArray.Q(e - parsableByteArray.e());
        return sb.toString();
    }
    
    static String g(final ParsableByteArray parsableByteArray, StringBuilder sb) {
        n(parsableByteArray);
        if (parsableByteArray.a() == 0) {
            return null;
        }
        final String f = f(parsableByteArray, sb);
        if (!"".equals(f)) {
            return f;
        }
        sb = new StringBuilder();
        sb.append("");
        sb.append((char)parsableByteArray.D());
        return sb.toString();
    }
    
    private static String h(final ParsableByteArray parsableByteArray, final StringBuilder sb) {
        final StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (i == 0) {
            final int e = parsableByteArray.e();
            final String g = g(parsableByteArray, sb);
            if (g == null) {
                return null;
            }
            if (!"}".equals(g) && !";".equals(g)) {
                sb2.append(g);
            }
            else {
                parsableByteArray.P(e);
                i = 1;
            }
        }
        return sb2.toString();
    }
    
    private static String i(final ParsableByteArray parsableByteArray, final StringBuilder sb) {
        n(parsableByteArray);
        if (parsableByteArray.a() < 5) {
            return null;
        }
        if (!"::cue".equals(parsableByteArray.A(5))) {
            return null;
        }
        final int e = parsableByteArray.e();
        final String g = g(parsableByteArray, sb);
        if (g == null) {
            return null;
        }
        if ("{".equals(g)) {
            parsableByteArray.P(e);
            return "";
        }
        String l;
        if ("(".equals(g)) {
            l = l(parsableByteArray);
        }
        else {
            l = null;
        }
        if (!")".equals(g(parsableByteArray, sb))) {
            return null;
        }
        return l;
    }
    
    private static void j(final ParsableByteArray parsableByteArray, final WebvttCssStyle webvttCssStyle, final StringBuilder sb) {
        n(parsableByteArray);
        final String f = f(parsableByteArray, sb);
        if ("".equals(f)) {
            return;
        }
        if (!":".equals(g(parsableByteArray, sb))) {
            return;
        }
        n(parsableByteArray);
        final String h = h(parsableByteArray, sb);
        if (h != null) {
            if (!"".equals(h)) {
                final int e = parsableByteArray.e();
                final String g = g(parsableByteArray, sb);
                if (!";".equals(g)) {
                    if (!"}".equals(g)) {
                        return;
                    }
                    parsableByteArray.P(e);
                }
                if ("color".equals(f)) {
                    webvttCssStyle.q(ColorParser.b(h));
                }
                else if ("background-color".equals(f)) {
                    webvttCssStyle.n(ColorParser.b(h));
                }
                else {
                    final boolean equals = "ruby-position".equals(f);
                    final boolean b = true;
                    if (equals) {
                        if ("over".equals(h)) {
                            webvttCssStyle.v(1);
                        }
                        else if ("under".equals(h)) {
                            webvttCssStyle.v(2);
                        }
                    }
                    else if ("text-combine-upright".equals(f)) {
                        boolean b2 = b;
                        if (!"all".equals(h)) {
                            b2 = (h.startsWith("digits") && b);
                        }
                        webvttCssStyle.p(b2);
                    }
                    else if ("text-decoration".equals(f)) {
                        if ("underline".equals(h)) {
                            webvttCssStyle.A(true);
                        }
                    }
                    else if ("font-family".equals(f)) {
                        webvttCssStyle.r(h);
                    }
                    else if ("font-weight".equals(f)) {
                        if ("bold".equals(h)) {
                            webvttCssStyle.o(true);
                        }
                    }
                    else if ("font-style".equals(f)) {
                        if ("italic".equals(h)) {
                            webvttCssStyle.u(true);
                        }
                    }
                    else if ("font-size".equals(f)) {
                        e(h, webvttCssStyle);
                    }
                }
            }
        }
    }
    
    private static char k(final ParsableByteArray parsableByteArray, final int n) {
        return (char)parsableByteArray.d()[n];
    }
    
    private static String l(final ParsableByteArray parsableByteArray) {
        int e = parsableByteArray.e();
        for (int f = parsableByteArray.f(), n = 0; e < f && n == 0; ++e) {
            if ((char)parsableByteArray.d()[e] == ')') {
                n = 1;
            }
            else {
                n = 0;
            }
        }
        return parsableByteArray.A(e - 1 - parsableByteArray.e()).trim();
    }
    
    static void m(final ParsableByteArray parsableByteArray) {
        while (!TextUtils.isEmpty((CharSequence)parsableByteArray.p())) {}
    }
    
    static void n(final ParsableByteArray parsableByteArray) {
    Label_0000:
        while (true) {
            for (int n = 1; parsableByteArray.a() > 0 && n != 0; n = 0) {
                if (c(parsableByteArray)) {
                    continue Label_0000;
                }
                if (b(parsableByteArray)) {
                    continue Label_0000;
                }
            }
            break;
        }
    }
    
    public List<WebvttCssStyle> d(final ParsableByteArray parsableByteArray) {
        this.b.setLength(0);
        final int e = parsableByteArray.e();
        m(parsableByteArray);
        this.a.N(parsableByteArray.d(), parsableByteArray.e());
        this.a.P(e);
        final ArrayList list = new ArrayList();
        while (true) {
            final String i = i(this.a, this.b);
            if (i == null) {
                return list;
            }
            if (!"{".equals(g(this.a, this.b))) {
                return list;
            }
            final WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            this.a(webvttCssStyle, i);
            Object g = null;
            int j = 0;
            while (j == 0) {
                final int e2 = this.a.e();
                g = g(this.a, this.b);
                if (g != null && !"}".equals(g)) {
                    j = 0;
                }
                else {
                    j = 1;
                }
                if (j == 0) {
                    this.a.P(e2);
                    j(this.a, webvttCssStyle, this.b);
                }
            }
            if (!"}".equals(g)) {
                continue;
            }
            list.add(webvttCssStyle);
        }
    }
}
