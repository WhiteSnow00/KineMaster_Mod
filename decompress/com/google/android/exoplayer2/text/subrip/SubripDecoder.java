// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.text.Cue;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class SubripDecoder extends SimpleSubtitleDecoder
{
    private static final Pattern q;
    private static final Pattern r;
    private final StringBuilder o;
    private final ArrayList<String> p;
    
    static {
        q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
        r = Pattern.compile("\\{\\\\.*?\\}");
    }
    
    public SubripDecoder() {
        super("SubripDecoder");
        this.o = new StringBuilder();
        this.p = new ArrayList<String>();
    }
    
    private Cue B(final Spanned spanned, final String s) {
        final Cue.Builder o = new Cue.Builder().o((CharSequence)spanned);
        if (s == null) {
            return o.a();
        }
        int n = 0;
        Label_0242: {
            switch (s.hashCode()) {
                case -685620462: {
                    if (s.equals("{\\an9}")) {
                        n = 5;
                        break Label_0242;
                    }
                    break;
                }
                case -685620493: {
                    if (s.equals("{\\an8}")) {
                        n = 8;
                        break Label_0242;
                    }
                    break;
                }
                case -685620524: {
                    if (s.equals("{\\an7}")) {
                        n = 2;
                        break Label_0242;
                    }
                    break;
                }
                case -685620555: {
                    if (s.equals("{\\an6}")) {
                        n = 4;
                        break Label_0242;
                    }
                    break;
                }
                case -685620586: {
                    if (s.equals("{\\an5}")) {
                        n = 7;
                        break Label_0242;
                    }
                    break;
                }
                case -685620617: {
                    if (s.equals("{\\an4}")) {
                        n = 1;
                        break Label_0242;
                    }
                    break;
                }
                case -685620648: {
                    if (s.equals("{\\an3}")) {
                        n = 3;
                        break Label_0242;
                    }
                    break;
                }
                case -685620679: {
                    if (s.equals("{\\an2}")) {
                        n = 6;
                        break Label_0242;
                    }
                    break;
                }
                case -685620710: {
                    if (s.equals("{\\an1}")) {
                        n = 0;
                        break Label_0242;
                    }
                    break;
                }
            }
            n = -1;
        }
        if (n != 0 && n != 1 && n != 2) {
            if (n != 3 && n != 4 && n != 5) {
                o.l(1);
            }
            else {
                o.l(2);
            }
        }
        else {
            o.l(0);
        }
        int n2 = 0;
        Label_0514: {
            switch (s.hashCode()) {
                case -685620462: {
                    if (s.equals("{\\an9}")) {
                        n2 = 5;
                        break Label_0514;
                    }
                    break;
                }
                case -685620493: {
                    if (s.equals("{\\an8}")) {
                        n2 = 4;
                        break Label_0514;
                    }
                    break;
                }
                case -685620524: {
                    if (s.equals("{\\an7}")) {
                        n2 = 3;
                        break Label_0514;
                    }
                    break;
                }
                case -685620555: {
                    if (s.equals("{\\an6}")) {
                        n2 = 8;
                        break Label_0514;
                    }
                    break;
                }
                case -685620586: {
                    if (s.equals("{\\an5}")) {
                        n2 = 7;
                        break Label_0514;
                    }
                    break;
                }
                case -685620617: {
                    if (s.equals("{\\an4}")) {
                        n2 = 6;
                        break Label_0514;
                    }
                    break;
                }
                case -685620648: {
                    if (s.equals("{\\an3}")) {
                        n2 = 2;
                        break Label_0514;
                    }
                    break;
                }
                case -685620679: {
                    if (s.equals("{\\an2}")) {
                        n2 = 1;
                        break Label_0514;
                    }
                    break;
                }
                case -685620710: {
                    if (s.equals("{\\an1}")) {
                        n2 = 0;
                        break Label_0514;
                    }
                    break;
                }
            }
            n2 = -1;
        }
        if (n2 != 0 && n2 != 1 && n2 != 2) {
            if (n2 != 3 && n2 != 4 && n2 != 5) {
                o.i(1);
            }
            else {
                o.i(0);
            }
        }
        else {
            o.i(2);
        }
        return o.k(C(o.d())).h(C(o.c()), 0).a();
    }
    
    static float C(final int n) {
        if (n == 0) {
            return 0.08f;
        }
        if (n == 1) {
            return 0.5f;
        }
        if (n == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }
    
    private static long D(final Matcher matcher, final int n) {
        final String group = matcher.group(n + 1);
        long n2;
        if (group != null) {
            n2 = Long.parseLong(group) * 60L * 60L * 1000L;
        }
        else {
            n2 = 0L;
        }
        final long n3 = n2 + Long.parseLong(Assertions.e(matcher.group(n + 2))) * 60L * 1000L + Long.parseLong(Assertions.e(matcher.group(n + 3))) * 1000L;
        final String group2 = matcher.group(n + 4);
        long n4 = n3;
        if (group2 != null) {
            n4 = n3 + Long.parseLong(group2);
        }
        return n4 * 1000L;
    }
    
    private String E(final String s, final ArrayList<String> list) {
        final String trim = s.trim();
        final StringBuilder sb = new StringBuilder(trim);
        final Matcher matcher = SubripDecoder.r.matcher(trim);
        int n = 0;
        while (matcher.find()) {
            final String group = matcher.group();
            list.add(group);
            final int n2 = matcher.start() - n;
            final int length = group.length();
            sb.replace(n2, n2 + length, "");
            n += length;
        }
        return sb.toString();
    }
    
    @Override
    protected Subtitle z(byte[] array, int n, final boolean b) {
        final ArrayList list = new ArrayList();
        final LongArray longArray = new LongArray();
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array, n);
        while (true) {
            array = (byte[])(Object)parsableByteArray.p();
            n = 0;
            if (array == null) {
                break;
            }
            if (((String)(Object)array).length() == 0) {
                continue;
            }
            try {
                Integer.parseInt((String)(Object)array);
                array = (byte[])(Object)parsableByteArray.p();
                if (array == null) {
                    Log.i("SubripDecoder", "Unexpected end");
                    break;
                }
                final Matcher matcher = SubripDecoder.q.matcher((CharSequence)(Object)array);
                if (matcher.matches()) {
                    longArray.a(D(matcher, 1));
                    longArray.a(D(matcher, 6));
                    this.o.setLength(0);
                    this.p.clear();
                    for (array = (byte[])(Object)parsableByteArray.p(); !TextUtils.isEmpty((CharSequence)(Object)array); array = (byte[])(Object)parsableByteArray.p()) {
                        if (this.o.length() > 0) {
                            this.o.append("<br>");
                        }
                        this.o.append(this.E((String)(Object)array, this.p));
                    }
                    final Spanned fromHtml = Html.fromHtml(this.o.toString());
                    final byte[] array2 = null;
                    while (true) {
                        array = array2;
                        if (n >= this.p.size()) {
                            break;
                        }
                        array = (byte[])(Object)this.p.get(n);
                        if (((String)(Object)array).matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        }
                        ++n;
                    }
                    list.add(this.B(fromHtml, (String)(Object)array));
                    list.add(Cue.C);
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Skipping invalid timing: ");
                    sb.append((String)(Object)array);
                    Log.i("SubripDecoder", sb.toString());
                }
            }
            catch (final NumberFormatException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipping invalid index: ");
                sb2.append((String)(Object)array);
                Log.i("SubripDecoder", sb2.toString());
            }
        }
        return new a(list.toArray(new Cue[0]), longArray.d());
    }
}
