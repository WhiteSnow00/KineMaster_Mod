// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Map;
import com.google.android.exoplayer2.text.Subtitle;

final class e implements Subtitle
{
    private final b a;
    private final long[] b;
    private final Map<String, TtmlStyle> c;
    private final Map<String, c> d;
    private final Map<String, String> e;
    
    public e(final b a, final Map<String, TtmlStyle> map, final Map<String, c> d, final Map<String, String> e) {
        this.a = a;
        this.d = d;
        this.e = e;
        Map<Object, Object> c;
        if (map != null) {
            c = (Map<Object, Object>)Collections.unmodifiableMap((Map<? extends String, ? extends TtmlStyle>)map);
        }
        else {
            c = (Map<Object, Object>)Collections.emptyMap();
        }
        this.c = (Map<String, TtmlStyle>)c;
        this.b = a.j();
    }
    
    @Override
    public int a(final long n) {
        int e = Util.e(this.b, n, false, false);
        if (e >= this.b.length) {
            e = -1;
        }
        return e;
    }
    
    @Override
    public List<Cue> c(final long n) {
        return this.a.h(n, this.c, this.d, this.e);
    }
    
    @Override
    public long d(final int n) {
        return this.b[n];
    }
    
    @Override
    public int f() {
        return this.b.length;
    }
}
