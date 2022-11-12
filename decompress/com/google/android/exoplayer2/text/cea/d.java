// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;
import com.google.android.exoplayer2.text.Subtitle;

final class d implements Subtitle
{
    private final List<Cue> a;
    
    public d(final List<Cue> a) {
        this.a = a;
    }
    
    @Override
    public int a(final long n) {
        int n2;
        if (n < 0L) {
            n2 = 0;
        }
        else {
            n2 = -1;
        }
        return n2;
    }
    
    @Override
    public List<Cue> c(final long n) {
        Object o;
        if (n >= 0L) {
            o = this.a;
        }
        else {
            o = Collections.emptyList();
        }
        return (List<Cue>)o;
    }
    
    @Override
    public long d(final int n) {
        Assertions.a(n == 0);
        return 0L;
    }
    
    @Override
    public int f() {
        return 1;
    }
}
