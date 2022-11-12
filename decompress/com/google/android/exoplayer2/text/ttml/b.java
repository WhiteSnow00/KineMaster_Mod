// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import android.util.Pair;
import java.util.TreeSet;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import java.util.Map;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;
import java.util.HashMap;

final class b
{
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    public final TtmlStyle f;
    private final String[] g;
    public final String h;
    public final String i;
    public final b j;
    private final HashMap<String, Integer> k;
    private final HashMap<String, Integer> l;
    private List<b> m;
    
    private b(final String a, final String b, final long d, final long e, final TtmlStyle f, final String[] g, final String s, final String i, final b j) {
        this.a = a;
        this.b = b;
        this.i = i;
        this.f = f;
        this.g = g;
        this.c = (b != null);
        this.d = d;
        this.e = e;
        this.h = Assertions.e(s);
        this.j = j;
        this.k = new HashMap<String, Integer>();
        this.l = new HashMap<String, Integer>();
    }
    
    private void b(final Map<String, TtmlStyle> map, final Cue.Builder builder, final int n, final int n2, final int n3) {
        final TtmlStyle f = com.google.android.exoplayer2.text.ttml.d.f(this.f, this.g, map);
        SpannableStringBuilder spannableStringBuilder;
        if ((spannableStringBuilder = (SpannableStringBuilder)builder.e()) == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            builder.o((CharSequence)spannableStringBuilder);
        }
        if (f != null) {
            com.google.android.exoplayer2.text.ttml.d.a((Spannable)spannableStringBuilder, n, n2, f, this.j, map, n3);
            if ("p".equals(this.a)) {
                if (f.k() != Float.MAX_VALUE) {
                    builder.m(f.k() * -90.0f / 100.0f);
                }
                if (f.m() != null) {
                    builder.p(f.m());
                }
                if (f.h() != null) {
                    builder.j(f.h());
                }
            }
        }
    }
    
    public static b c(final String s, final long n, final long n2, final TtmlStyle ttmlStyle, final String[] array, final String s2, final String s3, final b b) {
        return new b(s, null, n, n2, ttmlStyle, array, s2, s3, b);
    }
    
    public static b d(final String s) {
        return new b(null, d.b(s), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }
    
    private static void e(final SpannableStringBuilder spannableStringBuilder) {
        final int length = spannableStringBuilder.length();
        final int n = 0;
        for (final a a : (a[])spannableStringBuilder.getSpans(0, length, (Class)a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart((Object)a), spannableStringBuilder.getSpanEnd((Object)a), (CharSequence)"");
        }
        for (int j = 0; j < spannableStringBuilder.length(); ++j) {
            if (spannableStringBuilder.charAt(j) == ' ') {
                int n3;
                int n2;
                for (n2 = (n3 = j + 1); n3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(n3) == ' '; ++n3) {}
                final int n4 = n3 - n2;
                if (n4 > 0) {
                    spannableStringBuilder.delete(j, n4 + j);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int k = 0; k < spannableStringBuilder.length() - 1; ++k) {
            if (spannableStringBuilder.charAt(k) == '\n') {
                final int n5 = k + 1;
                if (spannableStringBuilder.charAt(n5) == ' ') {
                    spannableStringBuilder.delete(n5, k + 2);
                }
            }
        }
        int l = n;
        if (spannableStringBuilder.length() > 0) {
            l = n;
            if (spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
                l = n;
            }
        }
        while (l < spannableStringBuilder.length() - 1) {
            if (spannableStringBuilder.charAt(l) == ' ') {
                final int n6 = l + 1;
                if (spannableStringBuilder.charAt(n6) == '\n') {
                    spannableStringBuilder.delete(l, n6);
                }
            }
            ++l;
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }
    
    private void i(final TreeSet<Long> set, final boolean b) {
        final boolean equals = "p".equals(this.a);
        final boolean equals2 = "div".equals(this.a);
        if (b || equals || (equals2 && this.i != null)) {
            final long d = this.d;
            if (d != -9223372036854775807L) {
                set.add(d);
            }
            final long e = this.e;
            if (e != -9223372036854775807L) {
                set.add(e);
            }
        }
        if (this.m == null) {
            return;
        }
        for (int i = 0; i < this.m.size(); ++i) {
            this.m.get(i).i(set, b || equals);
        }
    }
    
    private static SpannableStringBuilder k(final String s, final Map<String, Cue.Builder> map) {
        if (!map.containsKey(s)) {
            final Cue.Builder builder = new Cue.Builder();
            builder.o((CharSequence)new SpannableStringBuilder());
            map.put(s, builder);
        }
        return Assertions.e((SpannableStringBuilder)((Cue.Builder)map.get(s)).e());
    }
    
    private void n(final long n, String h, final List<Pair<String, String>> list) {
        if (!"".equals(this.h)) {
            h = this.h;
        }
        if (this.m(n) && "div".equals(this.a) && this.i != null) {
            list.add((Pair<String, String>)new Pair((Object)h, (Object)this.i));
            return;
        }
        for (int i = 0; i < this.g(); ++i) {
            this.f(i).n(n, h, list);
        }
    }
    
    private void o(final long n, final Map<String, TtmlStyle> map, final Map<String, c> map2, String h, final Map<String, Cue.Builder> map3) {
        if (!this.m(n)) {
            return;
        }
        if (!"".equals(this.h)) {
            h = this.h;
        }
        final Iterator<Map.Entry<String, Integer>> iterator = this.l.entrySet().iterator();
        int i;
        while (true) {
            final boolean hasNext = iterator.hasNext();
            i = 0;
            final int n2 = 0;
            if (!hasNext) {
                break;
            }
            final Map.Entry<String, V> entry = iterator.next();
            final String s = entry.getKey();
            int intValue = n2;
            if (this.k.containsKey(s)) {
                intValue = this.k.get(s);
            }
            final int intValue2 = (int)entry.getValue();
            if (intValue == intValue2) {
                continue;
            }
            this.b(map, Assertions.e(map3.get(s)), intValue, intValue2, Assertions.e(map2.get(h)).j);
        }
        while (i < this.g()) {
            this.f(i).o(n, map, map2, h, map3);
            ++i;
        }
    }
    
    private void p(final long n, final boolean b, String h, final Map<String, Cue.Builder> map) {
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.a)) {
            return;
        }
        if (!"".equals(this.h)) {
            h = this.h;
        }
        if (this.c && b) {
            k(h, map).append((CharSequence)Assertions.e(this.b));
        }
        else if ("br".equals(this.a) && b) {
            k(h, map).append('\n');
        }
        else if (this.m(n)) {
            for (final Map.Entry<String, V> entry : map.entrySet()) {
                this.k.put(entry.getKey(), Assertions.e(((Cue.Builder)entry.getValue()).e()).length());
            }
            final boolean equals = "p".equals(this.a);
            for (int i = 0; i < this.g(); ++i) {
                this.f(i).p(n, b || equals, h, map);
            }
            if (equals) {
                com.google.android.exoplayer2.text.ttml.d.c(k(h, map));
            }
            for (final Map.Entry<String, V> entry2 : map.entrySet()) {
                this.l.put(entry2.getKey(), Assertions.e(((Cue.Builder)entry2.getValue()).e()).length());
            }
        }
    }
    
    public void a(final b b) {
        if (this.m == null) {
            this.m = new ArrayList<b>();
        }
        this.m.add(b);
    }
    
    public b f(final int n) {
        final List<b> m = this.m;
        if (m != null) {
            return m.get(n);
        }
        throw new IndexOutOfBoundsException();
    }
    
    public int g() {
        final List<b> m = this.m;
        int size;
        if (m == null) {
            size = 0;
        }
        else {
            size = m.size();
        }
        return size;
    }
    
    public List<Cue> h(final long n, final Map<String, TtmlStyle> map, final Map<String, c> map2, final Map<String, String> map3) {
        final ArrayList list = new ArrayList();
        this.n(n, this.h, list);
        final TreeMap treeMap = new TreeMap();
        this.p(n, false, this.h, treeMap);
        this.o(n, map, map2, this.h, treeMap);
        final ArrayList list2 = new ArrayList();
        for (final Pair pair : list) {
            final String s = map3.get(pair.second);
            if (s == null) {
                continue;
            }
            final byte[] decode = Base64.decode(s, 0);
            final Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            final c c = Assertions.e(map2.get(pair.first));
            list2.add(new Cue.Builder().f(decodeByteArray).k(c.b).l(0).h(c.c, 0).i(c.e).n(c.f).g(c.g).r(c.j).a());
        }
        for (final Map.Entry<Object, V> entry : treeMap.entrySet()) {
            final c c2 = Assertions.e(map2.get(entry.getKey()));
            final Cue.Builder builder = (Cue.Builder)entry.getValue();
            e(Assertions.e((SpannableStringBuilder)builder.e()));
            builder.h(c2.c, c2.d);
            builder.i(c2.e);
            builder.k(c2.b);
            builder.n(c2.f);
            builder.q(c2.i, c2.h);
            builder.r(c2.j);
            list2.add(builder.a());
        }
        return list2;
    }
    
    public long[] j() {
        final TreeSet set = new TreeSet();
        int n = 0;
        this.i(set, false);
        final long[] array = new long[set.size()];
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            array[n] = (long)iterator.next();
            ++n;
        }
        return array;
    }
    
    public String[] l() {
        return this.g;
    }
    
    public boolean m(final long n) {
        final long d = this.d;
        return (d == -9223372036854775807L && this.e == -9223372036854775807L) || (d <= n && this.e == -9223372036854775807L) || (d == -9223372036854775807L && n < this.e) || (d <= n && n < this.e);
    }
}
