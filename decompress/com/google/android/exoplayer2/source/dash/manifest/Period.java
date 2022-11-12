// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class Period
{
    public final String a;
    public final long b;
    public final List<AdaptationSet> c;
    public final List<EventStream> d;
    public final Descriptor e;
    
    public Period(final String s, final long n, final List<AdaptationSet> list, final List<EventStream> list2) {
        this(s, n, list, list2, null);
    }
    
    public Period(final String a, final long b, final List<AdaptationSet> list, final List<EventStream> list2, final Descriptor e) {
        this.a = a;
        this.b = b;
        this.c = Collections.unmodifiableList((List<? extends AdaptationSet>)list);
        this.d = Collections.unmodifiableList((List<? extends EventStream>)list2);
        this.e = e;
    }
    
    public int a(final int n) {
        for (int size = this.c.size(), i = 0; i < size; ++i) {
            if (this.c.get(i).b == n) {
                return i;
            }
        }
        return -1;
    }
}
