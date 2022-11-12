// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.Collection;
import java.util.List;
import com.google.common.collect.ImmutableList;

final class o
{
    public final int a;
    public final q b;
    public final ImmutableList<t> c;
    
    public o(final int a, final q b, final List<t> list) {
        this.a = a;
        this.b = b;
        this.c = (ImmutableList<t>)ImmutableList.copyOf((Collection)list);
    }
}
