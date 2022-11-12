// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ssa;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import com.google.android.exoplayer2.text.Subtitle;

final class b implements Subtitle
{
    private final List<List<Cue>> a;
    private final List<Long> b;
    
    public b(final List<List<Cue>> a, final List<Long> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public int a(final long n) {
        int d = Util.d(this.b, n, false, false);
        if (d >= this.b.size()) {
            d = -1;
        }
        return d;
    }
    
    @Override
    public List<Cue> c(final long n) {
        final int g = Util.g(this.b, n, true, false);
        if (g == -1) {
            return Collections.emptyList();
        }
        return this.a.get(g);
    }
    
    @Override
    public long d(final int n) {
        final boolean b = true;
        Assertions.a(n >= 0);
        Assertions.a(n < this.b.size() && b);
        return this.b.get(n);
    }
    
    @Override
    public int f() {
        return this.b.size();
    }
}
