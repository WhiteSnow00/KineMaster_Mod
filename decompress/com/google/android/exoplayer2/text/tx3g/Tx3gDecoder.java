// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.tx3g;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.common.base.Charsets;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.text.style.StyleSpan;
import android.text.style.ForegroundColorSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Log;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class Tx3gDecoder extends SimpleSubtitleDecoder
{
    private final ParsableByteArray o;
    private final boolean p;
    private final int q;
    private final int r;
    private final String s;
    private final float t;
    private final int u;
    
    public Tx3gDecoder(final List<byte[]> list) {
        super("Tx3gDecoder");
        this.o = new ParsableByteArray();
        final int size = list.size();
        final String s = "sans-serif";
        boolean p = true;
        if (size == 1 && (((byte[])list.get(0)).length == 48 || ((byte[])list.get(0)).length == 53)) {
            final byte[] array = list.get(0);
            this.q = array[24];
            this.r = ((array[26] & 0xFF) << 24 | (array[27] & 0xFF) << 16 | (array[28] & 0xFF) << 8 | (array[29] & 0xFF));
            String s2 = s;
            if ("Serif".equals(Util.E(array, 43, array.length - 43))) {
                s2 = "serif";
            }
            this.s = s2;
            final int u = array[25] * 20;
            this.u = u;
            if ((array[0] & 0x20) == 0x0) {
                p = false;
            }
            this.p = p;
            if (p) {
                this.t = Util.p(((array[11] & 0xFF) | (array[10] & 0xFF) << 8) / (float)u, 0.0f, 0.95f);
            }
            else {
                this.t = 0.85f;
            }
        }
        else {
            this.q = 0;
            this.r = -1;
            this.s = "sans-serif";
            this.p = false;
            this.t = 0.85f;
            this.u = -1;
        }
    }
    
    private void B(final ParsableByteArray parsableByteArray, final SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        C(parsableByteArray.a() >= 12);
        final int j = parsableByteArray.J();
        int n = parsableByteArray.J();
        parsableByteArray.Q(2);
        final int d = parsableByteArray.D();
        parsableByteArray.Q(1);
        final int n2 = parsableByteArray.n();
        if (n > spannableStringBuilder.length()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Truncating styl end (");
            sb.append(n);
            sb.append(") to cueText.length() (");
            sb.append(spannableStringBuilder.length());
            sb.append(").");
            Log.i("Tx3gDecoder", sb.toString());
            n = spannableStringBuilder.length();
        }
        if (j >= n) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignoring styl with start (");
            sb2.append(j);
            sb2.append(") >= end (");
            sb2.append(n);
            sb2.append(").");
            Log.i("Tx3gDecoder", sb2.toString());
            return;
        }
        E(spannableStringBuilder, d, this.q, j, n, 0);
        D(spannableStringBuilder, n2, this.r, j, n, 0);
    }
    
    private static void C(final boolean b) throws SubtitleDecoderException {
        if (b) {
            return;
        }
        throw new SubtitleDecoderException("Unexpected subtitle format.");
    }
    
    private static void D(final SpannableStringBuilder spannableStringBuilder, final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n != n2) {
            spannableStringBuilder.setSpan((Object)new ForegroundColorSpan(n >>> 8 | (n & 0xFF) << 24), n3, n4, n5 | 0x21);
        }
    }
    
    private static void E(final SpannableStringBuilder spannableStringBuilder, int n, int n2, final int n3, final int n4, int n5) {
        if (n != n2) {
            final int n6 = n5 | 0x21;
            final int n7 = 1;
            if ((n & 0x1) != 0x0) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            if ((n & 0x2) != 0x0) {
                n5 = 1;
            }
            else {
                n5 = 0;
            }
            if (n2 != 0) {
                if (n5 != 0) {
                    spannableStringBuilder.setSpan((Object)new StyleSpan(3), n3, n4, n6);
                }
                else {
                    spannableStringBuilder.setSpan((Object)new StyleSpan(1), n3, n4, n6);
                }
            }
            else if (n5 != 0) {
                spannableStringBuilder.setSpan((Object)new StyleSpan(2), n3, n4, n6);
            }
            if ((n & 0x4) != 0x0) {
                n = n7;
            }
            else {
                n = 0;
            }
            if (n != 0) {
                spannableStringBuilder.setSpan((Object)new UnderlineSpan(), n3, n4, n6);
            }
            if (n == 0 && n2 == 0 && n5 == 0) {
                spannableStringBuilder.setSpan((Object)new StyleSpan(0), n3, n4, n6);
            }
        }
    }
    
    private static void F(final SpannableStringBuilder spannableStringBuilder, final String s, final int n, final int n2) {
        if (s != "sans-serif") {
            spannableStringBuilder.setSpan((Object)new TypefaceSpan(s), n, n2, 16711713);
        }
    }
    
    private static String G(final ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        C(parsableByteArray.a() >= 2);
        final int j = parsableByteArray.J();
        if (j == 0) {
            return "";
        }
        if (parsableByteArray.a() >= 2) {
            final char g = parsableByteArray.g();
            if (g == '\ufeff' || g == '\ufffe') {
                return parsableByteArray.B(j, Charsets.f);
            }
        }
        return parsableByteArray.B(j, Charsets.c);
    }
    
    @Override
    protected Subtitle z(final byte[] array, int n, final boolean b) throws SubtitleDecoderException {
        this.o.N(array, n);
        final String g = G(this.o);
        if (g.isEmpty()) {
            return com.google.android.exoplayer2.text.tx3g.a.b;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((CharSequence)g);
        E(spannableStringBuilder, this.q, 0, 0, spannableStringBuilder.length(), 16711680);
        D(spannableStringBuilder, this.r, -1, 0, spannableStringBuilder.length(), 16711680);
        F(spannableStringBuilder, this.s, 0, spannableStringBuilder.length());
        float t = this.t;
        while (this.o.a() >= 8) {
            final int e = this.o.e();
            final int n2 = this.o.n();
            n = this.o.n();
            boolean b2 = true;
            final boolean b3 = true;
            float p3;
            if (n == 1937013100) {
                C(this.o.a() >= 2 && b3);
                final int j = this.o.J();
                n = 0;
                while (true) {
                    p3 = t;
                    if (n >= j) {
                        break;
                    }
                    this.B(this.o, spannableStringBuilder);
                    ++n;
                }
            }
            else {
                p3 = t;
                if (n == 1952608120) {
                    p3 = t;
                    if (this.p) {
                        if (this.o.a() < 2) {
                            b2 = false;
                        }
                        C(b2);
                        p3 = Util.p(this.o.J() / (float)this.u, 0.0f, 0.95f);
                    }
                }
            }
            this.o.P(e + n2);
            t = p3;
        }
        return new a(new Cue.Builder().o((CharSequence)spannableStringBuilder).h(t, 0).i(0).a());
    }
}
