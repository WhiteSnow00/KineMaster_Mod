// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.text.Subtitle;
import android.text.Layout$Alignment;
import java.util.regex.Matcher;
import java.util.LinkedHashMap;
import com.google.common.base.Ascii;
import com.google.android.exoplayer2.util.Log;
import android.graphics.PointF;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.text.style.StyleSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.SpannableString;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class SsaDecoder extends SimpleSubtitleDecoder
{
    private static final Pattern t;
    private final boolean o;
    private final a p;
    private Map<String, SsaStyle> q;
    private float r;
    private float s;
    
    static {
        t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    }
    
    public SsaDecoder() {
        this((List<byte[]>)null);
    }
    
    public SsaDecoder(final List<byte[]> list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.s = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.o = true;
            final String d = Util.D(list.get(0));
            Assertions.a(d.startsWith("Format:"));
            this.p = Assertions.e(com.google.android.exoplayer2.text.ssa.a.a(d));
            this.G(new ParsableByteArray(list.get(1)));
        }
        else {
            this.o = false;
            this.p = null;
        }
    }
    
    private static int B(final long n, final List<Long> list, final List<List<Cue>> list2) {
        while (true) {
            for (int i = list.size() - 1; i >= 0; --i) {
                if ((long)list.get(i) == n) {
                    return i;
                }
                if ((long)list.get(i) < n) {
                    ++i;
                    list.add(i, n);
                    ArrayList list3;
                    if (i == 0) {
                        list3 = new ArrayList();
                    }
                    else {
                        list3 = new ArrayList(list2.get(i - 1));
                    }
                    list2.add(i, list3);
                    return i;
                }
            }
            int i = 0;
            continue;
        }
    }
    
    private static float C(final int n) {
        if (n == 0) {
            return 0.05f;
        }
        if (n == 1) {
            return 0.5f;
        }
        if (n != 2) {
            return -3.4028235E38f;
        }
        return 0.95f;
    }
    
    private static Cue D(final String s, final SsaStyle ssaStyle, final SsaStyle.b b, final float n, final float n2) {
        final SpannableString spannableString = new SpannableString((CharSequence)s);
        final Cue.Builder o = new Cue.Builder().o((CharSequence)spannableString);
        if (ssaStyle != null) {
            if (ssaStyle.c != null) {
                spannableString.setSpan((Object)new ForegroundColorSpan((int)ssaStyle.c), 0, spannableString.length(), 33);
            }
            if (ssaStyle.j == 3 && ssaStyle.d != null) {
                spannableString.setSpan((Object)new BackgroundColorSpan((int)ssaStyle.d), 0, spannableString.length(), 33);
            }
            final float e = ssaStyle.e;
            if (e != -3.4028235E38f && n2 != -3.4028235E38f) {
                o.q(e / n2, 1);
            }
            final boolean f = ssaStyle.f;
            if (f && ssaStyle.g) {
                spannableString.setSpan((Object)new StyleSpan(3), 0, spannableString.length(), 33);
            }
            else if (f) {
                spannableString.setSpan((Object)new StyleSpan(1), 0, spannableString.length(), 33);
            }
            else if (ssaStyle.g) {
                spannableString.setSpan((Object)new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ssaStyle.h) {
                spannableString.setSpan((Object)new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ssaStyle.i) {
                spannableString.setSpan((Object)new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int n3 = b.a;
        if (n3 == -1) {
            if (ssaStyle != null) {
                n3 = ssaStyle.b;
            }
            else {
                n3 = -1;
            }
        }
        o.p(M(n3)).l(L(n3)).i(K(n3));
        final PointF b2 = b.b;
        if (b2 != null && n2 != -3.4028235E38f && n != -3.4028235E38f) {
            o.k(b2.x / n);
            o.h(b.b.y / n2, 0);
        }
        else {
            o.k(C(o.d()));
            o.h(C(o.c()), 0);
        }
        return o.a();
    }
    
    private void E(final String s, final a a, final List<List<Cue>> list, final List<Long> list2) {
        Assertions.a(s.startsWith("Dialogue:"));
        final String[] split = s.substring(9).split(",", a.e);
        if (split.length != a.e) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Skipping dialogue line with fewer columns than format: ");
            sb.append(s);
            Log.i("SsaDecoder", sb.toString());
            return;
        }
        final long j = J(split[a.a]);
        if (j == -9223372036854775807L) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Skipping invalid timing: ");
            sb2.append(s);
            Log.i("SsaDecoder", sb2.toString());
            return;
        }
        final long i = J(split[a.b]);
        if (i == -9223372036854775807L) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Skipping invalid timing: ");
            sb3.append(s);
            Log.i("SsaDecoder", sb3.toString());
            return;
        }
        final Map<String, SsaStyle> q = this.q;
        SsaStyle ssaStyle = null;
        Label_0220: {
            if (q != null) {
                final int c = a.c;
                if (c != -1) {
                    ssaStyle = q.get(split[c].trim());
                    break Label_0220;
                }
            }
            ssaStyle = null;
        }
        final String s2 = split[a.d];
        final Cue d = D(SsaStyle.b.d(s2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), ssaStyle, SsaStyle.b.b(s2), this.r, this.s);
        for (int k = B(j, list2, list); k < B(i, list2, list); ++k) {
            list.get(k).add(d);
        }
    }
    
    private void F(final ParsableByteArray parsableByteArray, final List<List<Cue>> list, final List<Long> list2) {
        a a;
        if (this.o) {
            a = this.p;
        }
        else {
            a = null;
        }
        while (true) {
            final String p3 = parsableByteArray.p();
            if (p3 == null) {
                break;
            }
            if (p3.startsWith("Format:")) {
                a = com.google.android.exoplayer2.text.ssa.a.a(p3);
            }
            else {
                if (!p3.startsWith("Dialogue:")) {
                    continue;
                }
                if (a == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Skipping dialogue line before complete format: ");
                    sb.append(p3);
                    Log.i("SsaDecoder", sb.toString());
                }
                else {
                    this.E(p3, a, list, list2);
                }
            }
        }
    }
    
    private void G(final ParsableByteArray parsableByteArray) {
        while (true) {
            final String p = parsableByteArray.p();
            if (p == null) {
                break;
            }
            if ("[Script Info]".equalsIgnoreCase(p)) {
                this.H(parsableByteArray);
            }
            else if ("[V4+ Styles]".equalsIgnoreCase(p)) {
                this.q = I(parsableByteArray);
            }
            else if ("[V4 Styles]".equalsIgnoreCase(p)) {
                Log.f("SsaDecoder", "[V4 Styles] are not supported");
            }
            else {
                if ("[Events]".equalsIgnoreCase(p)) {
                    break;
                }
                continue;
            }
        }
    }
    
    private void H(final ParsableByteArray parsableByteArray) {
        while (true) {
            final String p = parsableByteArray.p();
            if (p == null || (parsableByteArray.a() != 0 && parsableByteArray.h() == 91)) {
                return;
            }
            final String[] split = p.split(":");
            if (split.length != 2) {
                continue;
            }
            final String e = Ascii.e(split[0].trim());
            e.hashCode();
            Label_0096: {
                if (e.equals("playresx")) {
                    break Label_0096;
                }
                if (!e.equals("playresy")) {
                    continue;
                }
                try {
                    this.s = Float.parseFloat(split[1].trim());
                    continue;
                    this.r = Float.parseFloat(split[1].trim());
                    continue;
                }
                catch (final NumberFormatException ex) {}
            }
        }
    }
    
    private static Map<String, SsaStyle> I(final ParsableByteArray parsableByteArray) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.a a = null;
        while (true) {
            final String p = parsableByteArray.p();
            if (p == null || (parsableByteArray.a() != 0 && parsableByteArray.h() == 91)) {
                break;
            }
            if (p.startsWith("Format:")) {
                a = SsaStyle.a.a(p);
            }
            else {
                if (!p.startsWith("Style:")) {
                    continue;
                }
                if (a == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Skipping 'Style:' line before 'Format:' line: ");
                    sb.append(p);
                    Log.i("SsaDecoder", sb.toString());
                }
                else {
                    final SsaStyle b = SsaStyle.b(p, a);
                    if (b == null) {
                        continue;
                    }
                    linkedHashMap.put(b.a, b);
                }
            }
        }
        return linkedHashMap;
    }
    
    private static long J(final String s) {
        final Matcher matcher = SsaDecoder.t.matcher(s.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return Long.parseLong(Util.j(matcher.group(1))) * 60L * 60L * 1000000L + Long.parseLong(Util.j(matcher.group(2))) * 60L * 1000000L + Long.parseLong(Util.j(matcher.group(3))) * 1000000L + Long.parseLong(Util.j(matcher.group(4))) * 10000L;
    }
    
    private static int K(final int n) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown alignment: ");
                sb.append(n);
                Log.i("SsaDecoder", sb.toString());
                return Integer.MIN_VALUE;
            }
            case 7:
            case 8:
            case 9: {
                return 0;
            }
            case 4:
            case 5:
            case 6: {
                return 1;
            }
            case 1:
            case 2:
            case 3: {
                return 2;
            }
            case -1: {
                return Integer.MIN_VALUE;
            }
        }
    }
    
    private static int L(final int n) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown alignment: ");
                sb.append(n);
                Log.i("SsaDecoder", sb.toString());
                return Integer.MIN_VALUE;
            }
            case 3:
            case 6:
            case 9: {
                return 2;
            }
            case 2:
            case 5:
            case 8: {
                return 1;
            }
            case 1:
            case 4:
            case 7: {
                return 0;
            }
            case -1: {
                return Integer.MIN_VALUE;
            }
        }
    }
    
    private static Layout$Alignment M(final int n) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown alignment: ");
                sb.append(n);
                Log.i("SsaDecoder", sb.toString());
                return null;
            }
            case 3:
            case 6:
            case 9: {
                return Layout$Alignment.ALIGN_OPPOSITE;
            }
            case 2:
            case 5:
            case 8: {
                return Layout$Alignment.ALIGN_CENTER;
            }
            case 1:
            case 4:
            case 7: {
                return Layout$Alignment.ALIGN_NORMAL;
            }
            case -1: {
                return null;
            }
        }
    }
    
    @Override
    protected Subtitle z(final byte[] array, final int n, final boolean b) {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array, n);
        if (!this.o) {
            this.G(parsableByteArray);
        }
        this.F(parsableByteArray, list, list2);
        return new b(list, list2);
    }
}
