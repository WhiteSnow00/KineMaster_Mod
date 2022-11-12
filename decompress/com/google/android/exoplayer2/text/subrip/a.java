// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;

final class a implements Subtitle
{
    private final Cue[] a;
    private final long[] b;
    
    public a(final Cue[] a, final long[] b) {
        this.a = a;
        this.b = b;
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
        final int i = Util.i(this.b, n, true, false);
        if (i != -1) {
            final Cue[] a = this.a;
            if (a[i] != Cue.C) {
                return Collections.singletonList(a[i]);
            }
        }
        return Collections.emptyList();
    }
    
    @Override
    public long d(final int n) {
        final boolean b = true;
        Assertions.a(n >= 0);
        Assertions.a(n < this.b.length && b);
        return this.b[n];
    }
    
    @Override
    public int f() {
        return this.b.length;
    }
}
