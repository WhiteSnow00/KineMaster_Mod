// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.pgs;

import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import com.google.android.exoplayer2.text.Subtitle;

final class a implements Subtitle
{
    private final List<Cue> a;
    
    public a(final List<Cue> a) {
        this.a = a;
    }
    
    @Override
    public int a(final long n) {
        return -1;
    }
    
    @Override
    public List<Cue> c(final long n) {
        return this.a;
    }
    
    @Override
    public long d(final int n) {
        return 0L;
    }
    
    @Override
    public int f() {
        return 1;
    }
}
