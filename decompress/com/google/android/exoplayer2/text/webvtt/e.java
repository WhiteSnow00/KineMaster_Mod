// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Comparator;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.google.android.exoplayer2.text.Subtitle;

final class e implements Subtitle
{
    private final List<WebvttCueInfo> a;
    private final long[] b;
    private final long[] c;
    
    public e(final List<WebvttCueInfo> list) {
        this.a = Collections.unmodifiableList((List<? extends WebvttCueInfo>)new ArrayList<WebvttCueInfo>(list));
        this.b = new long[list.size() * 2];
        for (int i = 0; i < list.size(); ++i) {
            final WebvttCueInfo webvttCueInfo = list.get(i);
            final int n = i * 2;
            final long[] b = this.b;
            b[n] = webvttCueInfo.b;
            b[n + 1] = webvttCueInfo.c;
        }
        final long[] b2 = this.b;
        Arrays.sort(this.c = Arrays.copyOf(b2, b2.length));
    }
    
    public static int b(final WebvttCueInfo webvttCueInfo, final WebvttCueInfo webvttCueInfo2) {
        return e(webvttCueInfo, webvttCueInfo2);
    }
    
    private static int e(final WebvttCueInfo webvttCueInfo, final WebvttCueInfo webvttCueInfo2) {
        return Long.compare(webvttCueInfo.b, webvttCueInfo2.b);
    }
    
    @Override
    public int a(final long n) {
        int e = Util.e(this.c, n, false, false);
        if (e >= this.c.length) {
            e = -1;
        }
        return e;
    }
    
    @Override
    public List<Cue> c(final long n) {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final int n2 = 0;
        for (int i = 0; i < this.a.size(); ++i) {
            final long[] b = this.b;
            final int n3 = i * 2;
            if (b[n3] <= n && n < b[n3 + 1]) {
                final WebvttCueInfo webvttCueInfo = this.a.get(i);
                final Cue a = webvttCueInfo.a;
                if (a.e == -3.4028235E38f) {
                    list2.add(webvttCueInfo);
                }
                else {
                    list.add(a);
                }
            }
        }
        Collections.sort((List<Object>)list2, d.a);
        for (int j = n2; j < list2.size(); ++j) {
            list.add(((WebvttCueInfo)list2.get(j)).a.b().h((float)(-1 - j), 1).a());
        }
        return list;
    }
    
    @Override
    public long d(final int n) {
        final boolean b = true;
        Assertions.a(n >= 0);
        Assertions.a(n < this.c.length && b);
        return this.c[n];
    }
    
    @Override
    public int f() {
        return this.c.length;
    }
}
