// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.Collection;
import java.util.List;
import com.google.common.collect.ImmutableList;

final class n
{
    public final int a;
    public final ImmutableList<Integer> b;
    
    public n(final int a, final List<Integer> list) {
        this.a = a;
        this.b = (ImmutableList<Integer>)ImmutableList.copyOf((Collection)list);
    }
}
